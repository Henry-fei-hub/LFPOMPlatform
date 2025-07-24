package pomplatform.shift.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeDayCheck;
import com.pomplatform.db.bean.BaseHolidayManage;
import com.pomplatform.db.bean.BaseShiftTimeManage;
import com.pomplatform.db.dao.EmployeeDayCheck;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.HolidayManage;
import com.pomplatform.db.dao.LeaveType;
import com.pomplatform.db.dao.ShiftTimeManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;
import pomplatform.common.utils.StaticUtils;
import pomplatform.shift.bean.BaseAttendanceAnalyseCheck;
import pomplatform.shift.bean.BaseAttendanceCheckinoutData;
import pomplatform.shift.bean.BaseAttendancePersonnelData;
import pomplatform.shift.bean.BaseOnLoadEmpShiftInfo;
import pomplatform.shift.bean.ConditionAttendanceAnalyseCheck;
import pomplatform.shift.bean.ConditionAttendanceCheckinoutData;
import pomplatform.shift.bean.ConditionAttendancePersonnelData;
import pomplatform.shift.bean.ConditionOnLoadEmpShiftInfo;
import pomplatform.shift.query.QueryAttendanceAnalyseCheck;
import pomplatform.shift.query.QueryAttendanceCheckinoutData;
import pomplatform.shift.query.QueryAttendancePersonnelData;
import pomplatform.shift.query.QueryOnLoadEmpShiftInfo;

public class OnShiftManageUtils {
	public static Logger __logger = Logger.getLogger(OnShiftManageUtils.class);
	//*********************************************考勤状态开始**********
	public static final Integer ATTE_STATUS_1 = 1;//正常
	public static final Integer ATTE_STATUS_2 = 2;//迟到
	public static final Integer ATTE_STATUS_3 = 3;//早退
	public static final Integer ATTE_STATUS_4 = 4;//旷工
	//*********************************************考勤状态结束**********

	//*********************************************人事流程开始**********
	public static final Integer PROCESS_TYPE_13 = 13;//请假
	public static final Integer PROCESS_TYPE_15 = 15;//打卡
	public static final Integer PROCESS_TYPE_16 = 16;//外出
	public static final Integer PROCESS_TYPE_17 = 17;//加班
	public static final Integer PROCESS_TYPE_14 = 14;//非项目出差
	public static final Integer PROCESS_TYPE_18 = 18;//项目出差
	public static final Integer PROCESS_TYPE_19 = 19;//出差延期
	public static final Integer PROCESS_TYPE_20 = 20;//出差更改行程
	public static final Integer PROCESS_TYPE_21 = 21;//项目派驻
	public static final Integer PROCESS_TYPE_22 = 22;//项目派驻延期
	//*********************************************人事流程结束**********
	//*********************************************班次类型**********
	public static final Integer SHIFT_1 = 1;//休息
	public static final Integer SHIFT_2 = 2;//节假日

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized void accountDayAttendance(Date startDate, Date endDate, int personId, int year, int month) throws Exception {
		Long sTime = System.currentTimeMillis();
		//获取要计算的成员数据集
		Map<String,Map> empData = getEmpMap(startDate,endDate, personId, year, month);
		Map<String,BaseAttendanceAnalyseCheck> empMap = empData.get("empMap");
		Map<Integer,Integer> idsMap = empData.get("idsMap");
		//封装记旷工人员
		Set<String> employeeAbsenceIds = getAbsenceEmployees(empMap);
		//封装班次时段的数据集
		Map<Integer, BaseShiftTimeManage> shiftTimeMap = new HashMap<>();
		ShiftTimeManage shiftTimeDao = new ShiftTimeManage();
		List<BaseShiftTimeManage> shiftTimeList = shiftTimeDao.conditionalLoad();
		for(BaseShiftTimeManage bean : shiftTimeList){
			int shiftTimeManageId = bean.getShiftTimeManageId();
			shiftTimeMap.put(shiftTimeManageId,bean);
		}
		//封装节假日
		Map<Date,BaseHolidayManage> holidayMap = new HashMap<>();
		HolidayManage holidayDao = new HolidayManage();
		holidayDao.addAnyAndCondition("record_date between ? and ?", startDate,endDate);
		List<BaseHolidayManage> holidayList = holidayDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(holidayList) && holidayList.size() > 0) {
			for(BaseHolidayManage holidayBean : holidayList) {
				Date rDate = holidayBean.getRecordDate();
				holidayMap.put(rDate, holidayBean);
			}
		}
		//获取所有参与考勤且排班的人员班次信息
		Map<String,BaseOnLoadEmpShiftInfo> shiftInfoMap = generateEmployeeWorkDays(startDate, endDate,personId);
		//获取参与考勤的流程数据集
		Map<String,List<BaseAttendancePersonnelData>> perMap = getPersonnelData(personId, startDate, endDate);
		//加载已经加锁的员工数据集
		Set<String> lockedEmployeeIds = getLockedData(startDate, endDate, personId);
		//获取员工每天凌晨打卡数据集
		Map<String,Date> inoutMap = getCheckinoutData(startDate, endDate, personId);
		//用多线程来跑,50条为基数
		int step = 50;
		int size = idsMap.size();
		int num = size/step;//取整
		int lNum = size%step;//取余数
		if(lNum > 0) {
			num++;
		}
		Object[] ids = new Object[size];
		int i = 0;
		List<Integer> allEmpList = new ArrayList<>();
		for(Integer id : idsMap.keySet()) {
			ids[i] = id;
			allEmpList.add(id);
			i++;
		}
		Long eTime = System.currentTimeMillis();
		__logger.info("截止计算前查询总耗秒------------------"+((eTime-sTime)/6000));
		//先删除数据集
		deleteData(personId, year, month, startDate, endDate);
		List<FutureTask> tList = new ArrayList<>();
		for(int k = 0;k<num;k++) {
			int fromIndex = step*k;
			int toIndex = step*(k+1);
			if(toIndex > size) {
				toIndex = size;
			}
			List<Integer> empList = allEmpList.subList(fromIndex, toIndex);
			__logger.info("empList===="+empList.size());
			if(BaseHelpUtils.isNullOrEmpty(empList) || empList.size() == 0) {
				break;
			}
			Callable c = new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					dayAttendance(startDate, endDate, personId, year, month,empMap, empList, shiftTimeMap, holidayMap, shiftInfoMap,perMap,lockedEmployeeIds,employeeAbsenceIds,inoutMap);
					return 0;
				}
			};
			FutureTask<Integer> ft=new FutureTask<Integer>(c);
			Thread t = new Thread(ft);
			t.start();
			tList.add(ft);

		}
		for(FutureTask t : tList) {
			int result = BaseHelpUtils.getIntValue(t.get());
			__logger.info("result===="+result);
		}
		__logger.info("线程数量===="+tList.size());

	}

	/**
	 * 考勤计算明细
	 * @param startDate
	 * @param endDate
	 * @param personId
	 * @param year
	 * @param month
	 * @param empMap
	 * @param empList
	 * @param shiftTimeMap
	 * @param holidayMap
	 * @param shiftInfoMap
	 * @param perMap
	 * @param lockedEmployeeIds
	 * @param employeeAbsenceIds
	 * @throws SQLException
	 */
	public void dayAttendance(Date startDate, Date endDate, int personId, int year,int month,Map<String,BaseAttendanceAnalyseCheck> empMap,List<Integer> empList,Map<Integer, BaseShiftTimeManage> shiftTimeMap,Map<Date,BaseHolidayManage> holidayMap,Map<String,BaseOnLoadEmpShiftInfo> shiftInfoMap,Map<String,List<BaseAttendancePersonnelData>> perMap,Set<String> lockedEmployeeIds,Set<String> employeeAbsenceIds,Map<String,Date> inoutMap) throws SQLException {
		BaseEmployeeDayCheck empDayCheckBean = null;
		List<BaseEmployeeDayCheck> empDayCheckList = new ArrayList<>();
		for(Integer empId : empList) {
			for (Date recordDate = startDate; recordDate.compareTo(endDate) <= 0; recordDate = DateUtil.getNextDayOfDay(recordDate, 1)) {
				String dateStr = DateUtil.getChinaDateString(recordDate);
				String key = dateStr + empId;
				//判断这该员工在这一天是否加锁
				if(lockedEmployeeIds.contains(key)) {//说明加锁，不进行计算
					continue;
				}
				//获取这一天的考勤数据
				BaseAttendanceAnalyseCheck e = empMap.get(key);
				if(BaseHelpUtils.isNullOrEmpty(e)) {
					continue;
				}
				empDayCheckBean = new BaseEmployeeDayCheck();
				initBean(empDayCheckBean, empId, year, month, recordDate);
				empDayCheckList.add(empDayCheckBean);
				//定义是否是只有一次打卡
				Boolean onlyOneCheck = false;
				//定义上班打卡时间和下班打开时间，初始化为空
				Date checkin = e.getCheckinTime();
				Date checkout = e.getCheckoutTime();
				//检索是否有凌晨打卡数据集，如果有，则替换当前打卡数据集
				if(inoutMap.containsKey(key)) {
					checkout = inoutMap.get(key);
				}
				//定义实际打卡下班时间
				Date factCheckOut = checkout;
				empDayCheckBean.setCheckin(checkin);
				empDayCheckBean.setCheckout(checkout);

				//获取是否需要签到
				boolean checkSignIn = BaseHelpUtils.getBoolean(e.getCheckSignIn());
				//获取是否需要签退
				boolean checkSignOff = BaseHelpUtils.getBoolean(e.getCheckSignOff());
				//获取签到时间
				String signInTime = e.getSignInTime() == null ? "09:00" : e.getSignInTime();
				//获取签退时间
				String signOffTime = e.getSignOffTime() == null ? "17:30" : e.getSignOffTime();
				//获取计迟到分钟数
				int lateMinutes = BaseHelpUtils.getIntValue(e.getLateMinutes());
				//获取计早退分钟数
				int leaveMinutes = BaseHelpUtils.getIntValue(e.getLeaveEarlyTime());
				if (leaveMinutes > 0) {//如果即早退分钟数大于0，则设置为负数
					leaveMinutes = (-1) * leaveMinutes;
				}
				//获取正常上班时间和下班时间,即没有加上计迟到或者早退分钟数
				Date normalCheckin = getNormalDate(signInTime, recordDate, 0);
				Date normalCheckout = getNormalDate(signOffTime, recordDate, 0);
				//获取正常上班时间和下班时间,即加上计迟到或者早退分钟数
				Date normalCheckinAdd = getNormalDate(signInTime, recordDate, lateMinutes);
				Date normalCheckoutAdd = getNormalDate(signOffTime, recordDate, leaveMinutes);

				//更具当前日期检索是否为节假日,默认为false
				boolean isHoliDay = false;
				boolean isholidayWorkDay = false;
				boolean isCountOvertime = true;
				BaseHolidayManage holidayBean = holidayMap.get(recordDate);
				if(!BaseHelpUtils.isNullOrEmpty(holidayBean)){//说明是节假日
					isHoliDay = true;
					isholidayWorkDay = holidayBean.getIsWorkDay();
					isCountOvertime = BaseHelpUtils.getBoolean(holidayBean.getIsCountOvertime());
				}
				//设置加班开始时间
				Date overtimePayOfTime = getNormalDate("19:00", recordDate,0);
				//先检查这一天是否是节假日
				if(isHoliDay){//说明是节假日
					if(isholidayWorkDay){//如果是节假日，且是法定节假日，则计应出勤工作日
						empDayCheckBean.setShouldDays(BigDecimal.ONE);
						if(employeeAbsenceIds.contains(key)){//表示在需要计算工作日的时候设置为缺勤
							empDayCheckBean.setAbsenceDays(BigDecimal.ONE);//设置旷工1天
							empDayCheckBean.setFactDays(BigDecimal.ZERO);//设置实到0天
							empDayCheckBean.setStatus(ATTE_STATUS_4);// 旷工
							empDayCheckBean.setRemark("旷工");
						}else{
							empDayCheckBean.setFactDays(BigDecimal.ONE);
						}
					}
					//如果是节假日,则设置这一天为节假日班次
					empDayCheckBean.setShiftManageId(SHIFT_2);
					if(!(employeeAbsenceIds.contains(key) && isholidayWorkDay)){
						empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
						empDayCheckBean.setRemark("节假日");
					}
					//是否可记加班节假日
					if(!isCountOvertime) {
						continue;
					}
					BigDecimal overtimeHours = BigDecimal.ZERO;
					//检索是否有加班申请
					BaseAttendancePersonnelData overTime = checkPersonnelBase(perMap, PROCESS_TYPE_17, empId, recordDate, normalCheckin, normalCheckout);
					if(overTime != null){
						//获取开始时间和结束时间
						Date oStartTime = overTime.getStartDate();
						Date oEndTime = overTime.getEndDate();
						if(!BaseHelpUtils.isNullOrEmpty(oStartTime) && !BaseHelpUtils.isNullOrEmpty(oEndTime)) {
							if(DateUtil.isSameDay(oStartTime, oEndTime)) {
								empDayCheckBean.setCheckin(oStartTime);
								empDayCheckBean.setCheckout(oEndTime);
								overtimeHours = betweenHoursBetween(oEndTime,oStartTime);
							}
						}
					}else {
						//检索是否有员工打卡记录，如果有打卡记录，则计算其加班时间
						if(!BaseHelpUtils.isNullOrEmpty(checkin) && !BaseHelpUtils.isNullOrEmpty(checkout)){
							//设置加班时间(小时)=checkout-checkin
							overtimeHours = betweenHoursBetween(checkout,checkin);
						}
					}
					if(overtimeHours.compareTo(BigDecimal.ZERO) > 0) {
						//节假日加班
						empDayCheckBean.setHolidayOvertimeHours(overtimeHours);
						empDayCheckBean.setRemark("节假日加班");
						/**
						 * 节假日加班餐补：三小时以上给予加班餐补20元 。
						 * 节假日加班补助：人力资源部、行政部、财务部没有加班补助;加班时长<2小时，加班补助=0；2小时=<加班时长< 5小时，加班补助=20元；加班时长>=5小时，加班补助=40元。
						 */
						if(overtimeHours.compareTo(new BigDecimal(3)) >= 0) {
							//设置加班餐补
							empDayCheckBean.setOvertimePay(new BigDecimal("20"));
						}
						BigDecimal overtimePaySub = BigDecimal.ZERO;
						if(overtimeHours.compareTo(new BigDecimal("2")) >= 0 && overtimeHours.compareTo(new BigDecimal("5")) < 0) {
							overtimePaySub = new BigDecimal("20");
						}else if(overtimeHours.compareTo(new BigDecimal("5")) >= 0) {
							overtimePaySub = new BigDecimal("40");
						}
						empDayCheckBean.setOvertimePaySub(overtimePaySub);
					}
					continue;
				}

				//获取员工在这一天的班次,初始化为0
				int shiftManageId = 0;
				BaseOnLoadEmpShiftInfo shiftInfoBean = shiftInfoMap.get(key);
				if(!BaseHelpUtils.isNullOrEmpty(shiftInfoBean)){
					shiftManageId = shiftInfoBean.getShiftManageId();
				}
				empDayCheckBean.setShiftManageId(shiftManageId);
				//先检索这一天是否有排班，如果班次ID>0说明是有排班，否则无排班
				if(shiftManageId == 0){//说明无排班
					empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
					empDayCheckBean.setRemark("无排班");
					continue;
				}
				//先检索这一天是否是工作日，如果班次ID为1(休息),2(节假日)
				if(shiftManageId == 1 || shiftManageId == 2){//说明不是工作日
					empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
					empDayCheckBean.setRemark("非工作日");
					BigDecimal overtimeHours = BigDecimal.ZERO;
					//检索是否有加班申请
					BaseAttendancePersonnelData overTime = checkPersonnelBase(perMap, PROCESS_TYPE_17, empId, recordDate, normalCheckin, normalCheckout);
					if(!BaseHelpUtils.isNullOrEmpty(overTime)) {
						//获取开始时间和结束时间
						Date oStartTime = overTime.getStartDate();
						Date oEndTime = overTime.getEndDate();
						if(!BaseHelpUtils.isNullOrEmpty(oStartTime) && !BaseHelpUtils.isNullOrEmpty(oEndTime)) {
							if(DateUtil.isSameDay(oStartTime, oEndTime)) {
								empDayCheckBean.setCheckin(oStartTime);
								empDayCheckBean.setCheckout(oEndTime);
								overtimeHours = betweenHoursBetween(oEndTime,oStartTime);
							}
						}
					}else {
						//检索是否有员工打卡记录，如果有打卡记录，则计算其加班时间
						if(!BaseHelpUtils.isNullOrEmpty(checkin) && !BaseHelpUtils.isNullOrEmpty(checkout)){
							empDayCheckBean.setCheckin(checkin);
							empDayCheckBean.setCheckout(checkout);
							//设置加班时间(小时)=checkout-checkin
							overtimeHours = betweenHoursBetween(checkout,checkin);
						}
					}
					/**
					 * 周末加班餐补：三小时以上给予加班餐补20元 。
					 * 周末加班补助：人力资源部、行政部、财务部没有加班补助;加班时长<2小时，加班补助=0；2小时=<加班时长< 5小时，加班补助=20元；加班时长>=5小时，加班补助=40元。
					 */
					if(overtimeHours.compareTo(BigDecimal.ZERO) > 0) {
						empDayCheckBean.setWeekendOvertimeHours(overtimeHours);
						empDayCheckBean.setRemark("非工作日加班");
						if(overtimeHours.compareTo(new BigDecimal(3)) >= 0) {
							//设置加班餐补
							empDayCheckBean.setOvertimePay(new BigDecimal("20"));
						}
						BigDecimal overtimePaySub = BigDecimal.ZERO;
						if(overtimeHours.compareTo(new BigDecimal("2")) >= 0 && overtimeHours.compareTo(new BigDecimal("5")) < 0) {
							overtimePaySub = new BigDecimal("20");
						}else if(overtimeHours.compareTo(new BigDecimal("5")) >= 0) {
							overtimePaySub = new BigDecimal("40");
						}
						empDayCheckBean.setOvertimePaySub(overtimePaySub);
					}
					continue;
				}
				//到这里说明员工是需要正常上班的，则设置应出勤工作日和实际出勤工作日
				empDayCheckBean.setShouldDays(BigDecimal.ONE);
				empDayCheckBean.setFactDays(BigDecimal.ONE);
				//针对不计考勤中旬入离职人员考勤处理，如入职后半个月均记正常，离职前半个月均记正常
				//获取是否参与考勤
				boolean isCheck = BaseHelpUtils.getBoolean(e.getIsCheck());
				if(!isCheck) {//说明不参与考勤人员
					//获取在职状态
					int empStatus = BaseHelpUtils.getIntValue(e.getStatus());
					if(empStatus == 0) {//说明是在职
						//获取入职时间
						Date onBoardDate = e.getOnboardDate();
						if(!BaseHelpUtils.isNullOrEmpty(onBoardDate) && (onBoardDate.before(recordDate) || DateUtil.isSameDay(onBoardDate, recordDate))) {
							empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
							empDayCheckBean.setRemark("不参与考勤人员入职月记正常");
						}else {
							empDayCheckBean.setStatus(ATTE_STATUS_4);//设置为异常
							empDayCheckBean.setFactDays(BigDecimal.ZERO);
							empDayCheckBean.setAbsenceDays(BigDecimal.ONE);
						}
					}else {//离职
						//获取离职日期
						Date reDate = e.getResignationDate();
						if(!BaseHelpUtils.isNullOrEmpty(reDate) && (reDate.after(recordDate) || DateUtil.isSameDay(reDate, recordDate))) {
							empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
							empDayCheckBean.setRemark("不参与考勤人员离职月记正常");
						}else {
							empDayCheckBean.setStatus(ATTE_STATUS_4);//设置为异常
							empDayCheckBean.setFactDays(BigDecimal.ZERO);
							empDayCheckBean.setAbsenceDays(BigDecimal.ONE);
						}
					}
					continue;
				}
				//获取职员在当前计算日期排的班次时段
				int shiftTimeManageId = BaseHelpUtils.getIntValue(e.getShiftTimeManageId());
				if(shiftTimeManageId == 0){//说明没获取到该时段
					empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
					empDayCheckBean.setRemark("休息日");
					continue;
				}
				//从map中获取该时段的所有信息
				BaseShiftTimeManage shiftTimeBean = shiftTimeMap.get(shiftTimeManageId);
				if(shiftTimeBean == null){//说明该时段已不存在封装的时段中
					empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
					empDayCheckBean.setRemark("未检索到时段");
					continue;
				}
				//获取算加班时间
				String overTime = shiftTimeBean.getOvertimeStartTime()==null?"19:00":shiftTimeBean.getOvertimeStartTime();
				Date overCheckout = getNormalDate(overTime, recordDate,0);
				//定义中午开始休息时间和结束时间
				Date restStartTime = getNormalDate("12:15", recordDate, 0);
				Date restEndTime = getNormalDate("13:45", recordDate, 0);
				//先检索该员工在当期日期是否有出差(非项目出差)
				int checkFlag = checkPersonnelBusiness(perMap, empDayCheckBean, PROCESS_TYPE_14, empId, recordDate, restStartTime, restEndTime, "非项目出差", normalCheckin, normalCheckout);
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}
				//先检索该员工在当期日期是否有出差(项目出差)
				checkFlag = checkPersonnelBusiness(perMap, empDayCheckBean, PROCESS_TYPE_18, empId, recordDate, restStartTime, restEndTime, "项目出差", normalCheckin, normalCheckout);
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(出差延期)
				checkFlag = checkPersonnelBusiness(perMap, empDayCheckBean, PROCESS_TYPE_19, empId, recordDate, restStartTime, restEndTime, "出差延期", normalCheckin, normalCheckout);
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(出差更改行程)
				checkFlag = checkPersonnelBusiness(perMap, empDayCheckBean, PROCESS_TYPE_20, empId, recordDate, restStartTime, restEndTime, "出差更改行程", normalCheckin, normalCheckout);
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(项目派驻)
				checkFlag = checkPersonnelBusiness(perMap, empDayCheckBean, PROCESS_TYPE_21, empId, recordDate, restStartTime, restEndTime, "项目派驻", normalCheckin, normalCheckout);
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(项目派驻延期)
				checkFlag = checkPersonnelBusiness(perMap, empDayCheckBean, PROCESS_TYPE_22, empId, recordDate, restStartTime, restEndTime, "项目派驻延期", normalCheckin, normalCheckout);
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}
				//先检索该员工在当期日期是否有外出
				List<BaseAttendancePersonnelData> outList = checkPersonnelList(perMap, PROCESS_TYPE_16, empId, recordDate, normalCheckinAdd, normalCheckoutAdd);
				if(!BaseHelpUtils.isNullOrEmpty(outList) && outList.size() > 0) {
					//如果是多条流程，则取所有流程的最早时间点和最晚时间点
					Date accountStartTime = null;
					Date accountEndTime = null;
					for(BaseAttendancePersonnelData out : outList) {
						Date startTime = out.getStartDate();
						Date endTime = out.getEndDate();
						if(!BaseHelpUtils.isNullOrEmpty(startTime)) {
							if(BaseHelpUtils.isNullOrEmpty(accountStartTime) || startTime.before(accountStartTime)) {
								accountStartTime = startTime;
							}
						}
						if(!BaseHelpUtils.isNullOrEmpty(endTime)) {
							if(BaseHelpUtils.isNullOrEmpty(accountEndTime) || accountEndTime.before(endTime)) {
								accountEndTime = endTime;
							}
						}
					}
					if(!BaseHelpUtils.isNullOrEmpty(accountStartTime) && !BaseHelpUtils.isNullOrEmpty(accountEndTime)) {
						//判断是否跨度中午休息时段
						if(accountStartTime.compareTo(restStartTime) <= 0 && accountEndTime.compareTo(restEndTime) >= 0) {
							empDayCheckBean.setStatus(ATTE_STATUS_1);
							empDayCheckBean.setOutForBusiness(BigDecimal.ONE);
							empDayCheckBean.setRemark("外出");
							empDayCheckBean.setFactDays(BigDecimal.ONE);
							empDayCheckBean.setAbsenceDays(BigDecimal.ZERO);
							continue;
						}else {
							//没跨中午休息时间段的话，则设置外出0.5天，继续走考勤
							empDayCheckBean.setOutForBusiness(new BigDecimal("0.5"));
							//如果外出结束时间早于中午休息结束时间，则记上午外出，否则记下午外出
							if(accountEndTime.compareTo(restEndTime) < 0) {
								//早上外出，则上班打卡时间为上班时间
								checkin = normalCheckin;
							}else {
								//下午外出，则下班打卡时间为下班时间
								checkout = normalCheckout;
							}
						}
					}
				}

				//先检索该员工在当期日期是否有请假
				List<BaseAttendancePersonnelData> pList = checkPersonnelList(perMap, PROCESS_TYPE_13, empId, recordDate, normalCheckinAdd, normalCheckoutAdd);
				if(!BaseHelpUtils.isNullOrEmpty(pList) && pList.size() > 0) {
					//设置请假的开始时间和结束时间，主要是解决同一天多种假类的问题（比如，早上调休，下午请假）
					Date accountStartTime = null;//取最早的
					Date accountEndTime = null;//取最晚的
					for(BaseAttendancePersonnelData leave : pList) {
						//获取请假类型，只有事假和病假按小时和天算，其它假类按天算(最小单位为0.5天)，小时存放设置保留1位有效小数
						//事假和病假计算规则:先统计请假小时数，然后将请假小时数和一天上班小时总数(7.5)求余(保存至小时字段)和求整（保存至天数字段）
						//如果是其它假类，则只计算天数，计算规则:如果请假开始时间和结束是否都在早上或者都在下午，则计0.5天，否则计1天
						int type = BaseHelpUtils.getIntValue(leave.getType());
						//定义请假的小时数和天数(即请假小时数/实际上班小时数，保留两位小数)
						BigDecimal leaveHours = BigDecimal.ZERO;
						//获取请假开始时间和结束时间
						Date leaveStartTime = leave.getStartDate();
						Date leaveEndTime = leave.getEndDate();
						if(BaseHelpUtils.isNullOrEmpty(accountStartTime)) {
							accountStartTime = leaveStartTime;
						}else {
							if(leaveStartTime.before(accountStartTime)) {
								accountStartTime = leaveStartTime;
							}
						}
						if(BaseHelpUtils.isNullOrEmpty(accountEndTime)) {
							accountEndTime = leaveEndTime;
						}else {
							if(leaveEndTime.after(accountEndTime)) {
								accountEndTime = leaveEndTime;
							}
						}
						empDayCheckBean.setStatus(ATTE_STATUS_1);
						BigDecimal leaveDays = BigDecimal.ZERO;
						//调休走原来计算的逻辑，其他的走新的计算规则：即根据判断是否跨度中午休息时段，如果是跨度了，则记一天，否则记0.5天
						if(StaticUtils.LEAVE_TYPE_21 == type) {//调休
							//情况1：请假开始时间<=上班开始时间（计算开始时间为：上班开始时间），上班结束时间<=请假结束时间（计算结束时间为：上班结束时间）,需减去中午休息的小时数
							if(leaveStartTime.compareTo(normalCheckinAdd) <= 0 && normalCheckoutAdd.compareTo(leaveEndTime) <= 0){
								leaveHours = betweenHoursBetween(normalCheckoutAdd,normalCheckinAdd);//获取请假小时数
								leaveHours = leaveHours.subtract(StaticUtils.REST_HOURS);//减去中午休息的小时数
								//情况2：请假开始时间<=上班开始时间，请假结束时间<上班结束时间
							}else if(leaveStartTime.compareTo(normalCheckinAdd) <= 0 && leaveEndTime.compareTo(normalCheckoutAdd) < 0){
								if(leaveEndTime.compareTo(normalCheckinAdd) > 0) {
									//情况a：请假结束时间<=中午休息开始时间(计算开始时间为上班开始时间,计算结束时间为请假结束时间),不需减去中午休息的小时数
									if(leaveEndTime.compareTo(restStartTime) <= 0){
										leaveHours = betweenHoursBetween(leaveEndTime,normalCheckinAdd);//获取请假小时数
										//情况b:中午休息开始时间<请假结束时间<=中午休息结束时间(则计算开始时间为上班开始时间,计算结束时间为中午休息开始时间),不需减去中午休息的小时数
									}else if(restStartTime.compareTo(leaveEndTime) < 0 && leaveEndTime.compareTo(restEndTime) <= 0){
										leaveHours = betweenHoursBetween(restStartTime,normalCheckinAdd);//获取请假小时数
										//情况c：请假结束时间>中午休息结束时间(计算开始时间为上班开始时间,计算结束时间为请假结束时间),需减去中午休息的小时数
									}else{
										leaveHours = betweenHoursBetween(leaveEndTime,normalCheckinAdd);//获取请假小时数
										leaveHours = leaveHours.subtract(StaticUtils.REST_HOURS);//减去中午休息的小时数
									}
								}
								//这种情况，如果调休时长小于3.25小时，则重置上班开始时间，否则则做为打卡数据分析
								if(leaveHours.compareTo(new BigDecimal("3.25")) >= 0) {
									//将调休开始时间作为上班打卡开始时间，调休结束时间做为下班打卡时间
									if(BaseHelpUtils.isNullOrEmpty(checkin) || checkin.compareTo(leaveStartTime) > 0) {
										checkin = leaveStartTime;
									}
									if(BaseHelpUtils.isNullOrEmpty(checkout) || checkout.compareTo(leaveEndTime) < 0) {
										checkout = leaveEndTime;
									}
								}else {
									normalCheckin = leaveEndTime;
									normalCheckinAdd = leaveEndTime;
								}
								//情况3：上班开始时间<请假开始时间，上班结束时间<=请假结束时间
							}else if(normalCheckinAdd.compareTo(leaveStartTime) < 0 && normalCheckoutAdd.compareTo(leaveEndTime) <= 0){
								if(leaveStartTime.compareTo(normalCheckoutAdd) < 0) {
									//情况a:请假开始时间<=中午休息开始时间(则计算开始时间为请假开始时间，计算结束时间为上班结束时间)，需减去中午休息的小时数
									if(leaveStartTime.compareTo(restStartTime) <= 0){
										leaveHours = betweenHoursBetween(normalCheckoutAdd,leaveStartTime);//获取请假小时数
										leaveHours = leaveHours.subtract(StaticUtils.REST_HOURS);//减去中午休息的小时数
										//情况b:中午休息开始时间<请假开始时间<=中午休息结束时间(则计算开始时间为中午休息结束时间，计算结束时间为上班结束时间),不需减去中午休息的小时数
									}else if(restStartTime.compareTo(leaveStartTime) < 0 && leaveStartTime.compareTo(restEndTime) <= 0){
										leaveHours= betweenHoursBetween(normalCheckoutAdd,restEndTime);//获取请假小时数
										//情况c:请假开始时间>中午休息结束时间(则计算开始时间为请假开始时间，计算结束时间为上班结束时间),不需减去中午休息的小时数
									}else{
										leaveHours = betweenHoursBetween(normalCheckoutAdd,leaveStartTime);//获取请假小时数
									}
								}
								//将调休开始时间作为上班打卡开始时间，调休结束时间做为下班打卡时间
								if(BaseHelpUtils.isNullOrEmpty(checkin) || checkin.compareTo(leaveStartTime) > 0) {
									checkin = leaveStartTime;
								}
								if(BaseHelpUtils.isNullOrEmpty(checkout) || checkout.compareTo(leaveEndTime) < 0) {
									checkout = leaveEndTime;
								}
								//情况4：上班开始时间<请假开始时间，请假结束时间<上班结束时间
							}else{
								//情况a:请假开始时间>=中午休息结束时间或者请假结束时间<=中午开始休息时间(计算开始时间为请假开始时间，计算结束时间为请假结束时间)，不需减去中午休息的小时数
								if(leaveStartTime.compareTo(restEndTime) >= 0 || leaveEndTime.compareTo(restStartTime) <= 0){
									leaveHours = betweenHoursBetween(leaveEndTime,leaveStartTime);//获取请假小时数
									//情况b:中午休息开始时间<请假开始时间<中午休息结束时间(计算开始时间为中午休息结束时间，计算结束时间为请假结束时间)，不需减去中午休息的小时数
								}else if(restStartTime.compareTo(leaveStartTime) < 0 && leaveStartTime.compareTo(restEndTime) < 0){
									leaveHours = betweenHoursBetween(leaveEndTime,restEndTime);//获取请假小时数
									//情况c:中午休息开始时间<请假结束时间<中午休息结束时间(计算开始时间为请假开始时间，计算结束时间为中午休息开始时间)，不需减去中午休息的小时数
								}else if(restStartTime.compareTo(leaveEndTime) < 0 && leaveEndTime.compareTo(restEndTime) < 0){
									leaveHours = betweenHoursBetween(restStartTime,leaveStartTime);//获取请假小时数
									//情况d:请假开始时间<=中午休息开始时间且中午休息结束时间<=请假结束时间(计算开始时间为请假开始时间，计算结束时间为请假结束时间)，需减去中午休息的小时数
								}else{
									leaveHours = betweenHoursBetween(leaveEndTime,leaveStartTime);//获取请假小时数
									leaveHours = leaveHours.subtract(StaticUtils.REST_HOURS);//减去中午休息的小时数
								}
								//将调休开始时间作为上班打卡开始时间，调休结束时间做为下班打卡时间
								if(BaseHelpUtils.isNullOrEmpty(checkin) || checkin.compareTo(leaveStartTime) > 0) {
									checkin = leaveStartTime;
								}
								if(BaseHelpUtils.isNullOrEmpty(checkout) || checkout.compareTo(leaveEndTime) < 0) {
									checkout = leaveEndTime;
								}
							}
						}else {
							//判断是否跨度中午休息时段
							if(leaveStartTime.compareTo(restStartTime) < 0 && leaveEndTime.compareTo(restEndTime) > 0) {
								leaveDays = BigDecimal.ONE;
							}else {//否则记半天
								leaveDays = new BigDecimal("0.5");
								//说明只请半天假，则需要判断是上午请假还是下午请假
								if(leaveEndTime.compareTo(restEndTime) < 0) {//说明是请上午假，则午休结束时间为这一天的上班时间
									//上午请假，则设置上班打卡时间为上班时间
									checkin = normalCheckin;
								}else {//说明是下午请假
									//下午请假，则设置下班打卡时间为下班时间
									checkout = normalCheckout;
								}
							}
						}

						//根据请假类型ID去假类表检索其对应的名称
						LeaveType leaveTypeDao = new LeaveType();
						leaveTypeDao.setLeaveTypeId(type);
						String leaveName ="";
						if(leaveTypeDao.load()){
							leaveName = leaveTypeDao.getLeaveTypeName();
						}
						empDayCheckBean.setRemark(leaveName);

						if(StaticUtils.LEAVE_TYPE_19 == type){//说明是事假
							BigDecimal thingLeaveDays = BaseHelpUtils.getBigDecimalValue(empDayCheckBean.getThingLeaveDays());
							empDayCheckBean.setThingLeaveDays(leaveDays.add(thingLeaveDays));
						}else if(StaticUtils.LEAVE_TYPE_20 == type){//说明是病假
							BigDecimal illLeaveDays = BaseHelpUtils.getBigDecimalValue(empDayCheckBean.getIllLeaveDays());
							empDayCheckBean.setIllLeaveDays(leaveDays.add(illLeaveDays));
						}else if(StaticUtils.LEAVE_TYPE_22 == type){//说明是年假
							BigDecimal annualLeave = BaseHelpUtils.getBigDecimalValue(empDayCheckBean.getAnnualLeave());
							empDayCheckBean.setAnnualLeave(leaveDays.add(annualLeave));
						}else if(StaticUtils.LEAVE_TYPE_21 == type) {//调休假小时
							BigDecimal adjust = BaseHelpUtils.getBigDecimalValue(empDayCheckBean.getAdjust());
							leaveHours = leaveHours.add(adjust);
							BigDecimal [] hourArr = leaveHours.divideAndRemainder(BigDecimal.ONE);
							if(hourArr[1].compareTo(new BigDecimal("0.5")) > 0) {
								leaveHours = hourArr[0].add(BigDecimal.ONE);
							}else {
								if(hourArr[1].compareTo(BigDecimal.ZERO) > 0) {
									leaveHours = hourArr[0].add(new BigDecimal("0.5"));
								}
							}
							empDayCheckBean.setAdjust(leaveHours);
						}else {//其他假类
							BigDecimal otherLeaveDays = BaseHelpUtils.getBigDecimalValue(empDayCheckBean.getOtherLeaveDays());
							empDayCheckBean.setOtherLeaveDays(leaveDays.add(otherLeaveDays));
						}
					}

					//判断是否跨度中午休息时段
					if(accountStartTime.compareTo(restStartTime) < 0 && accountEndTime.compareTo(restEndTime) > 0) {
						//如果有打卡，则设置打卡时间
						if(!BaseHelpUtils.isNullOrEmpty(checkin)){
							empDayCheckBean.setCheckin(checkin);
						}
						if(!BaseHelpUtils.isNullOrEmpty(checkout)){
							empDayCheckBean.setCheckout(checkout);
						}
						//根据实际打卡下班时间，判断是否有加班
						if(!BaseHelpUtils.isNullOrEmpty(factCheckOut)) {
							BigDecimal overTimeHours = betweenHoursBetween(factCheckOut, overCheckout);
							if(overTimeHours.compareTo(BigDecimal.ZERO) > 0) {
								empDayCheckBean.setNornalOvertimeHours(overTimeHours);
							}
						}
						continue;
					}else {//否则记半天
						//说明只请半天假，则需要判断是上午请假还是下午请假
						if(accountEndTime.compareTo(restEndTime) < 0) {//说明是请上午假，则午休结束时间为这一天的上班时间
							//上午请假，则设置上班打卡时间为上班时间
							checkin = normalCheckin;
						}else {//说明是下午请假
							//下午请假，则设置下班打卡时间为下班时间
							checkout = normalCheckout;
						}
					}

				}
				String remark = BaseHelpUtils.getString(empDayCheckBean.getRemark());
				//先检索是否补卡记录，如果有补卡记录，则更新打卡时间
				//获取上班补签的数据
				BaseAttendancePersonnelData fillCheckBeanOne = fillcheckOfPersonnel(perMap,PROCESS_TYPE_15, empId, recordDate,0);
				if(fillCheckBeanOne != null){//说明早上有补签记录
					checkin = normalCheckin;
					if(!BaseHelpUtils.isNullOrEmpty(remark)){
						remark+=",";
					}
					remark += "上班补签";
					empDayCheckBean.setRemark("上班补签");
					if(checkout == null){
						checkout = checkin;
					}
				}
				//获取下班补签的数据
				BaseAttendancePersonnelData fillCheckBeanTwo = fillcheckOfPersonnel(perMap,PROCESS_TYPE_15, empId, recordDate,1);
				if(fillCheckBeanTwo != null){//说明下午有补签记录
					checkout = normalCheckout;
					if(!BaseHelpUtils.isNullOrEmpty(remark)){
						remark+=",";
					}
					remark += "下班补签";
					empDayCheckBean.setRemark(remark);
					if(checkin == null){
						checkin = checkout;
					}
				}
				//检索是否需要签到和签退，如果不需要签到和签退，则设置打卡时间为班次正常上下班时间
				if(!checkSignIn){//说明不需要签到
					checkin = normalCheckin;
				}
				if(!checkSignOff){//说明不需要签退
					checkout = normalCheckout;
				}
				//如果是9-17.30点之间的计算，则设置下班时间点为正常下班的时间点
				if(DateUtil.compareDate(recordDate, normalCheckin) && DateUtil.compareDate(normalCheckout, recordDate)){
					checkout = normalCheckout;
				}else{
					empDayCheckBean.setCheckout(checkout);
				}
				empDayCheckBean.setCheckin(checkin);
				//*********************************计算迟到早退开始********************
				if(checkin == null && checkout == null){//说明无上班打卡和无下班打卡，则即旷工处理
					empDayCheckBean.setFactDays(BigDecimal.ZERO);//设置实到0天
					empDayCheckBean.setAbsenceDays(BigDecimal.ONE);//设置旷工1天
					empDayCheckBean.setThingLeaveHours(new BigDecimal("400"));//旷工1天，则设置扣款400
					empDayCheckBean.setStatus(ATTE_STATUS_4);// 旷工
					empDayCheckBean.setRemark("旷工");
					continue;
				}else{//说明上班有打卡，下班有打卡,正常计算迟到、早退、加班
					if(BaseHelpUtils.isNullOrEmpty(checkin) && !BaseHelpUtils.isNullOrEmpty(checkout)) {
						checkin = checkout;
						onlyOneCheck = true;
					}else if(!BaseHelpUtils.isNullOrEmpty(checkin) && BaseHelpUtils.isNullOrEmpty(checkout)) {
						checkout = checkin;
						onlyOneCheck = true;
					}else{
						if(checkin.compareTo(checkout) == 0) {
							onlyOneCheck = true;
						}
					}
					//只有一次打卡情况
					if(onlyOneCheck) {
						//只有一次打卡,则设置旷工0.5天
						empDayCheckBean.setFactDays(new BigDecimal("0.5"));//设置实到0.5
						empDayCheckBean.setAbsenceDays(new BigDecimal("0.5"));//设置旷工0.5天
						empDayCheckBean.setThingLeaveHours(new BigDecimal("200"));//旷工0.5天，设置扣款200
						empDayCheckBean.setStatus(ATTE_STATUS_4);// 旷工
						empDayCheckBean.setRemark("只有一次打卡(旷工)");
						continue;
					}
					//两次打卡情况，如果上班时间晚于12.15，则旷工0.5天，如果下班时间早于13.45，则旷工0.5天
					Date signInDate = getNormalDate(signInTime, recordDate, 0);
					Date signOffDate = getNormalDate(signOffTime, recordDate, 0);

					boolean isDeductLate = false;
					if(checkin.after(restStartTime)&&restStartTime.after(signInDate)) {
						empDayCheckBean.setFactDays(new BigDecimal("0.5"));//设置实到0.5天
						empDayCheckBean.setAbsenceDays(new BigDecimal("0.5"));//设置旷工0.5天
						empDayCheckBean.setThingLeaveHours(new BigDecimal("200"));//旷工0.5天，设置扣款200
						empDayCheckBean.setStatus(ATTE_STATUS_4);// 旷工
						isDeductLate = true;
					}
					boolean isDeductLeave = false;
					if(checkout.before(restEndTime)&&restEndTime.before(signOffDate)) {
						isDeductLeave = true;
						//获取旷工天
						BigDecimal absenceDays = BaseHelpUtils.getBigDecimalValue(empDayCheckBean.getAbsenceDays());
						absenceDays = absenceDays.add(new BigDecimal("0.5"));////设置旷工0.5天
						empDayCheckBean.setFactDays(BigDecimal.ONE.subtract(absenceDays));//设置实到天
						empDayCheckBean.setAbsenceDays(absenceDays);//设置旷工天
						empDayCheckBean.setStatus(ATTE_STATUS_4);// 旷工
						if(absenceDays.compareTo(BigDecimal.ONE) == 0) {
							empDayCheckBean.setThingLeaveHours(new BigDecimal("400"));//旷工1天，设置扣款400
							continue;
						}else {
							empDayCheckBean.setThingLeaveHours(new BigDecimal("200"));//旷工0.5天，设置扣款200
						}
					}
					//开始判读是否迟到
					int lateMinute = DateUtil.generateMinusBetween(checkin, normalCheckinAdd);
					if(!isDeductLate && lateMinute > 0) {//说明有迟到
						//迟到分钟数（前10分钟不扣款，9点开始计迟到，9点11分开始计算扣款）*1
						int deductLateMinute = lateMinute-10;
						if(deductLateMinute > 0) {
							empDayCheckBean.setLateCharge(new BigDecimal(deductLateMinute));
						}
						empDayCheckBean.setStatus(ATTE_STATUS_2);//设置迟到
						empDayCheckBean.setLateForMinutes(new BigDecimal(lateMinute));
						//设置迟到一次
						empDayCheckBean.setNumberOfLate(BigDecimal.ONE);
						//设置迟到分钟
						if(!BaseHelpUtils.isNullOrEmpty(remark)){
							remark+=",";
						}
						remark += "迟到("+lateMinute+")分钟";
					}

					//开始判读是否早退
					int leaveMinute = DateUtil.generateMinusBetween(normalCheckoutAdd, checkout);
					if(!isDeductLeave && leaveMinute > 0){//说明有早退
						empDayCheckBean.setStatus(ATTE_STATUS_3);//设置早退
						empDayCheckBean.setLeaveForMinutes(new BigDecimal(leaveMinute));
						empDayCheckBean.setNumberOfLeave(BigDecimal.ONE);
						if(!BaseHelpUtils.isNullOrEmpty(remark)){
							remark+=",";
						}
						remark += "早退";

					}
					//判读是否有加班
					BigDecimal overTimeHours = betweenHoursBetween(checkout, overCheckout);
					int status = empDayCheckBean.getStatus()==null?0:empDayCheckBean.getStatus();
					/**
					 * 工作日加班餐补：加班餐补从19:00开始计算，餐补10元；
					 * 工作日加班补助：人力资源部、行政部、财务部没有加班补助;加班时长<1小时，加班补助=0；1小时=<加班时长< 3.5小时，加班补助=10元；加班时长>=3.5小时，加班补助=20元。
					 */
					if(checkout.compareTo(overtimePayOfTime) > 0) {
						empDayCheckBean.setOvertimePay(BigDecimal.TEN);
					}
					if(overTimeHours.compareTo(BigDecimal.ZERO) > 0){//说明有加班
						//设置工作日加班
						empDayCheckBean.setNornalOvertimeHours(overTimeHours);
						if(!BaseHelpUtils.isNullOrEmpty(remark)){
							remark+=",";
						}
						remark += "工作日加班";
						//设置加班补助
						BigDecimal overtimePaySub = BigDecimal.ZERO;
						if(overTimeHours.compareTo(BigDecimal.ONE) >= 0 && overTimeHours.compareTo(new BigDecimal("3.5")) < 0) {
							overtimePaySub = BigDecimal.TEN;
						}else if(overTimeHours.compareTo(new BigDecimal("3.5")) >= 0) {
							overtimePaySub = new BigDecimal("20");
						}
						empDayCheckBean.setOvertimePaySub(overtimePaySub);
					}
					if(status == 0){
						empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
					}
					empDayCheckBean.setRemark(remark);
				}
				//*********************************计算迟到早退结束********************

			}
		}

		//插入数据
		if(!BaseHelpUtils.isNullOrEmpty(empDayCheckList) && empDayCheckList.size() > 0){
			EmployeeDayCheck empDayCheckDao = new EmployeeDayCheck();
			empDayCheckDao.save(empDayCheckList);
		}

	}

	/**
	 * 日考勤计算bean初始化
	 * @param empDayCheckBean
	 * @param empId
	 * @param year
	 * @param month
	 * @param recordDate
	 */
	public void initBean(BaseEmployeeDayCheck empDayCheckBean,int empId,int year,int month,Date recordDate) {
		empDayCheckBean.setEmployeeId(empId);
		empDayCheckBean.setYear(year);
		empDayCheckBean.setMonth(month);
		empDayCheckBean.setRecordDate(recordDate);
		empDayCheckBean.setOperateTime(new Date());
		empDayCheckBean.setShiftManageId(0);
		empDayCheckBean.setNumberOfLate(BigDecimal.ZERO);//迟到次数
		empDayCheckBean.setLateForMinutes(BigDecimal.ZERO);//迟到分钟
		empDayCheckBean.setLateCharge(BigDecimal.ZERO);//迟到扣款
		empDayCheckBean.setThingLeaveHours(BigDecimal.ZERO);//旷工扣款
		empDayCheckBean.setNumberOfLeave(BigDecimal.ZERO);//早退次数
		empDayCheckBean.setLeaveForMinutes(BigDecimal.ZERO);//早退分钟
		empDayCheckBean.setAdjust(BigDecimal.ZERO);//调休假小时
		empDayCheckBean.setThingLeaveDays(BigDecimal.ZERO);//事假天
		empDayCheckBean.setIllLeaveDays(BigDecimal.ZERO);//病假天
		empDayCheckBean.setAnnualLeave(BigDecimal.ZERO);//年假天
		empDayCheckBean.setOtherLeaveDays(BigDecimal.ZERO);//其他假类天
		empDayCheckBean.setOutForBusiness(BigDecimal.ZERO);//因公外出次数
		empDayCheckBean.setWeekendOvertimeHours(BigDecimal.ZERO);//周末加班
		empDayCheckBean.setNornalOvertimeHours(BigDecimal.ZERO);//平时加班
		empDayCheckBean.setHolidayOvertimeHours(BigDecimal.ZERO);//节假日加班
		empDayCheckBean.setAbsenceDays(BigDecimal.ZERO);//旷工天
		empDayCheckBean.setShouldDays(BigDecimal.ZERO);//应到天
		empDayCheckBean.setFactDays(BigDecimal.ZERO);//实到天
		empDayCheckBean.setOvertimePay(BigDecimal.ZERO);//加班餐补(本月)
		empDayCheckBean.setOvertimePaySub(BigDecimal.ZERO);//加班补助(本月)
		empDayCheckBean.setStatus(0);
		empDayCheckBean.setRemark("　");
		empDayCheckBean.setIsLocked(false);
	}

	/**
	 * 加载参与考勤的流程数据集
	 * @param personId
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws SQLException
	 */
	public Map<String,List<BaseAttendancePersonnelData>> getPersonnelData(int personId,Date startDate,Date endDate) throws SQLException {
		Map<String,List<BaseAttendancePersonnelData>> perMap = new HashMap<>();
		QueryAttendancePersonnelData query = new QueryAttendancePersonnelData();
		ConditionAttendancePersonnelData con = new ConditionAttendancePersonnelData();
		if(personId > 0) {
			con.setEmployeeId(personId);
		}
		con.setStartDate(startDate);
		con.setEndDate(endDate);
		BaseCollection<BaseAttendancePersonnelData> result = query.runQuery(null, con);
		if(BaseHelpUtils.isNullOrEmpty(result)) {
			return perMap;
		}
		List<BaseAttendancePersonnelData> list = result.getCollections();
		for(BaseAttendancePersonnelData e : list) {
			//获取职员id
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			//获取流程类型
			int processType = BaseHelpUtils.getIntValue(e.getProcessType());
			String key = empId+"_"+processType;
			List<BaseAttendancePersonnelData> reList = perMap.get(key);
			if(BaseHelpUtils.isNullOrEmpty(reList)) {
				reList = new ArrayList<>();
			}
			reList.add(e);
			perMap.put(key, reList);
		}
		return perMap;
	}


	/**
	 * 获取员工每一天是否记旷工的数据集
	 * @param empMap
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Set<String> getAbsenceEmployees(Map<String,BaseAttendanceAnalyseCheck> empMap){
		Set<String> employeeAbsenceIds = new HashSet<>();
		for(String key : empMap.keySet()) {
			BaseAttendanceAnalyseCheck e = empMap.get(key);
			if(BaseHelpUtils.isNullOrEmpty(e)) {
				continue;
			}
			int status = BaseHelpUtils.getIntValue(e.getStatus());
			Date recordDate = e.getRecordDate();
			if(BaseHelpUtils.isNullOrEmpty(recordDate)) {
				continue;
			}
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			if(status == 1){//离职员工 判断统计日期是否在离职日期之后
				if(null != e.getResignationDate()){
					if(e.getResignationDate().compareTo(recordDate) < 0){
						String dateStr = DateUtil.getChinaDateString(recordDate);
						String str = dateStr + empId;
						employeeAbsenceIds.add(str);
					}
				}
			}else if(status == 0){
				if(null != e.getOnboardDate()){//在职员工 判断统计日期是否在入职日期之前
					if(e.getOnboardDate().compareTo(recordDate) > 0){
						String dateStr = DateUtil.getChinaDateString(recordDate);
						String str = dateStr + empId;
						employeeAbsenceIds.add(str);
					}
				}
			}
		}
		return employeeAbsenceIds;
	}


	/**
	 * 封装所有参与考勤且排班的人员班次信息
	 * @param startDate
	 * @param endDate
	 * @throws SQLException
	 */
	public static Map<String,BaseOnLoadEmpShiftInfo> generateEmployeeWorkDays(Date startDate, Date endDate,int employeeId)throws SQLException {
		//定义map来存放员工排班的信息
		Map<String,BaseOnLoadEmpShiftInfo> map = new HashMap<>();
		ConditionOnLoadEmpShiftInfo condition = new ConditionOnLoadEmpShiftInfo();
		condition.setStartDate(startDate);
		condition.setEndDate(endDate);
		if(employeeId > 0){
			condition.setEmployeeId(employeeId);
		}
		QueryOnLoadEmpShiftInfo dao = new QueryOnLoadEmpShiftInfo();
		BaseCollection<BaseOnLoadEmpShiftInfo> result = dao.executeQuery(null, condition);
		if(BaseHelpUtils.isNullOrEmpty(result)) {
			return map;
		}
		List<BaseOnLoadEmpShiftInfo> list = result.getCollections();
		if(BaseHelpUtils.isNullOrEmpty(list) || list.size() == 0) {
			return map;
		}
		for (BaseOnLoadEmpShiftInfo bean : result.getCollections()) {
			int empId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
			Date recordDate = bean.getRecordDate();
			if(empId > 0 && !BaseHelpUtils.isNullOrEmpty(recordDate)) {
				String dateStr = DateUtil.getChinaDateString(recordDate);
				//遍历员工进行考勤数据的计算
				String str = dateStr + empId;
				map.put(str, bean);
			}
		}
		return map;
	}

	/**
	 * 获取要计算的人员数据集
	 * @param endDate
	 * @param personId
	 * @param year
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("rawtypes")
	public Map<String,Map> getEmpMap(Date startDate,Date endDate, int personId, int year, int month) throws SQLException {
		//封装本月需计算的人员,如果employeeId>0则说明是计算个人的
		Map<String,BaseAttendanceAnalyseCheck> empMap = new HashMap<>();
		Map<Integer,Integer> idsMap = new HashMap<>();
		Map<String,Map> empData = new HashMap<>();
		QueryAttendanceAnalyseCheck query = new QueryAttendanceAnalyseCheck();
		ConditionAttendanceAnalyseCheck con = new ConditionAttendanceAnalyseCheck();
		con.setYear(year);
		con.setMonth(month);
		con.setStartDate(startDate);
		con.setEndDate(endDate);
		if(personId > 0) {
			con.setEmployeeId(personId);
		}
		BaseCollection<BaseAttendanceAnalyseCheck> re = query.runQuery(null, con);
		List<BaseAttendanceAnalyseCheck> empList = re.getCollections();
		for(BaseAttendanceAnalyseCheck e : empList) {
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			Date recordDate = e.getRecordDate();
			String dateStr = DateUtil.getChinaDateString(recordDate);
			String key = dateStr + empId;
			empMap.put(key, e);
			idsMap.put(empId, empId);
		}
		empData.put("empMap", empMap);
		empData.put("idsMap", idsMap);
		return empData;
	}

	/**
	 * 加载已经加锁的员工
	 * @param startDate
	 * @param endDate
	 * @param personId
	 * @return
	 * @throws SQLException
	 */
	public Set<String> getLockedData(Date startDate,Date endDate,Integer personId) throws SQLException{
		Set<String> lockedEmployeeIds = new HashSet<>();
		EmployeeDayCheck empDayCheckDao = new EmployeeDayCheck();
		empDayCheckDao.unsetSelectFlags();
		empDayCheckDao.setSelectEmployeeId(true);
		empDayCheckDao.setSelectRecordDate(true);
		if(BaseHelpUtils.getIntValue(personId) > 0) {
			empDayCheckDao.setConditionEmployeeId("=", personId);
		}
		empDayCheckDao.addAnyAndCondition("record_date between ? and ?", startDate,endDate);
		empDayCheckDao.setConditionIsLocked("=",Boolean.TRUE);
		List<BaseEmployeeDayCheck> list = empDayCheckDao.conditionalLoad();
		for(BaseEmployeeDayCheck e : list) {
			Date recordDate = e.getRecordDate();
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			String dateStr = DateUtil.getChinaDateString(recordDate);
			String key = dateStr + empId;
			lockedEmployeeIds.add(key);
		}
		return lockedEmployeeIds;
	}

	public static BigDecimal betweenHoursBetween(Date t1, Date t2) {
		long time = t1.getTime() - t2.getTime();
		BigDecimal minus = new BigDecimal(time / 60000L);
		BigDecimal hours = minus.divide(new BigDecimal("60"), 2, BigDecimal.ROUND_DOWN);
		return hours;
	}

	/**
	 * 根据新的小时和分钟数获取日期
	 * @param time
	 * @param date
	 * @param otherMinutes
	 * @return
	 */
	public static Date getNormalDate(String time,Date date,int otherMinutes){
		String[] timeArr = time.split(":");
		int hours = BaseHelpUtils.getIntValue(timeArr[0]);
		int minutes = BaseHelpUtils.getIntValue(timeArr[1]);
		minutes += otherMinutes;
		date = DateUtil.getDateOfSpecialHour(date,hours,minutes);
		return date;
	}

	/**
	 * 获取流程数据
	 * @param empDayCheckBean
	 * @param perMap
	 * @param processType
	 * @param employeeId
	 * @param recordDate
	 * @param normalCheckin
	 * @param normalCheckout
	 * @return
	 * @throws SQLException
	 */
	public boolean checkPersonnel(BaseEmployeeDayCheck empDayCheckBean,Map<String,List<BaseAttendancePersonnelData>> perMap, int processType, int employeeId, Date recordDate,Date normalCheckin,Date normalCheckout) throws SQLException {
		List<BaseAttendancePersonnelData> list = perMap.get(employeeId+"_"+processType);
		boolean hasData = false;
		if(!BaseHelpUtils.isNullOrEmpty(list)) {
			for(BaseAttendancePersonnelData e : list) {
				//获取结束时间
				Date endDate = e.getEndDate();
				//获取开始时间
				Date startDate = e.getStartDate();
				if (DateUtil.isSameDay(recordDate, startDate) || DateUtil.isSameDay(endDate, recordDate) || (DateUtil.compareDate(normalCheckout, startDate) && DateUtil.compareDate(endDate, normalCheckin))) {
					/**
					 * 如果是项目派驻
					 * 派驻形式：1、派驻至甲方（业主） 2、派驻至公司其他分部  (2021.7改为 1.工地驻场 2.外派学习 3.外派办公)
					 * 第一种默认全勤
					 * 第二种需要正常考勤打卡
					 */
					if(processType == OnShiftManageProcess.PROCESS_TYPE_21) {
						int dutyId = BaseHelpUtils.getIntValue(e.getDutyId());
						if(dutyId != 1) {
							continue;
						}
					}
					hasData = true;
					String remark = BaseHelpUtils.getString(empDayCheckBean.getRemark());
					if(!BaseHelpUtils.isNullOrEmpty(remark)) {
						remark = remark+",";
					}
					//获取流程名称
					String processTypeName = BaseHelpUtils.getString(e.getProcessTypeName());
					remark = remark+processTypeName;
					empDayCheckBean.setRemark(remark);
					empDayCheckBean.setStatus(OnShiftManageProcess.ATTE_STATUS_1);
					return hasData;
				}
			}
		}
		return hasData;
	}

	/**
	 * 检索流程数据集
	 * @param perMap
	 * @param processType
	 * @param employeeId
	 * @param recordDate
	 * @param normalCheckin
	 * @param normalCheckout
	 * @return
	 * @throws SQLException
	 */
	public BaseAttendancePersonnelData checkPersonnelBase(Map<String,List<BaseAttendancePersonnelData>> perMap, int processType, int employeeId, Date recordDate,Date normalCheckin,Date normalCheckout) throws SQLException {
		List<BaseAttendancePersonnelData> list = perMap.get(employeeId+"_"+processType);
		if(!BaseHelpUtils.isNullOrEmpty(list)) {
			for(BaseAttendancePersonnelData e : list) {
				//获取结束时间
				Date endDate = e.getEndDate();
				//获取开始时间
				Date startDate = e.getStartDate();
				if (DateUtil.isSameDay(recordDate, startDate) || DateUtil.isSameDay(endDate, recordDate) || (DateUtil.compareDate(normalCheckout, startDate) && DateUtil.compareDate(endDate, normalCheckin))) {
					return e;
				}
			}
		}
		return null;
	}


	/**
	 * 人事流程考勤处理公用方法
	 * @param perMap
	 * @param empDayCheckBean
	 * @param processType
	 * @param employeeId
	 * @param recordDate
	 * @param restStartTime
	 * @param restEndTime
	 * @param remark
	 * @param normalCheckin
	 * @param normalCheckout
	 * @return
	 * @throws SQLException
	 */
	public int checkPersonnelBusiness(Map<String,List<BaseAttendancePersonnelData>> perMap,BaseEmployeeDayCheck empDayCheckBean,int processType,int employeeId,Date recordDate,Date restStartTime,Date restEndTime,String remark,Date normalCheckin,Date normalCheckout) throws SQLException {
		int checkFlat = 0;
		BaseAttendancePersonnelData bean = checkPersonnelBase(perMap, processType, employeeId, recordDate, normalCheckin, normalCheckout);
		if(BaseHelpUtils.isNullOrEmpty(bean)) {
			return checkFlat;
		}
		Date startTime = bean.getStartDate();
		Date endTime = bean.getEndDate();
		if(BaseHelpUtils.isNullOrEmpty(startTime) || BaseHelpUtils.isNullOrEmpty(endTime)) {
			return checkFlat;
		}
		if(processType != PROCESS_TYPE_16) {
			int startType = BaseHelpUtils.getIntValue(bean.getStartDateDetail());
			if(startType == 0) {//说明是上午
				startTime.setHours(9);
				startTime.setMinutes(0);
				startTime.setSeconds(0);
			}else {//说明是下午
				startTime.setHours(13);
				startTime.setMinutes(45);
				startTime.setSeconds(0);
			}
			int endType = BaseHelpUtils.getIntValue(bean.getEndDateDetail());
			if(endType == 0) {//说明是上午
				endTime.setHours(12);
				endTime.setMinutes(15);
				endTime.setSeconds(0);
			}else {//说明是下午
				endTime.setHours(17);
				endTime.setMinutes(30);
				endTime.setSeconds(0);
			}
		}
		//判断是否跨度中午休息时段
		if(startTime.compareTo(restStartTime) <= 0 && endTime.compareTo(restEndTime) >= 0) {
			empDayCheckBean.setStatus(ATTE_STATUS_1);
			empDayCheckBean.setOutForBusiness(BigDecimal.ONE);
			empDayCheckBean.setRemark(remark);
			empDayCheckBean.setFactDays(BigDecimal.ONE);
			empDayCheckBean.setAbsenceDays(BigDecimal.ZERO);
			checkFlat = 1;
		}else {
			//没跨中午休息时间段的话，则设置外出0.5天，继续走考勤
			empDayCheckBean.setOutForBusiness(new BigDecimal("0.5"));
			//如果外出结束时间早于中午休息结束时间，则记上午外出，否则记下午外出
			if(endTime.compareTo(restEndTime) < 0) {
				//早上外出，则上班打卡时间为上班时间
				checkFlat = 2;
			}else {
				//下午外出，则下班打卡时间为下班时间
				checkFlat = 3;
			}
		}
		return checkFlat;
	}

	/**
	 *
	 * @param perMap
	 * @param processType
	 * @param employeeId
	 * @param recordDate
	 * @param normalCheckin
	 * @param normalCheckout
	 * @return
	 * @throws SQLException
	 */
	public static List<BaseAttendancePersonnelData> checkPersonnelList(Map<String,List<BaseAttendancePersonnelData>> perMap, int processType, int employeeId, Date recordDate,Date normalCheckin,Date normalCheckout) throws SQLException{
		List<BaseAttendancePersonnelData> list = perMap.get(employeeId+"_"+processType);
		List<BaseAttendancePersonnelData> resultList = new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(list)) {
			for(BaseAttendancePersonnelData e : list) {
				//外出、请假流程，需流程审批通过才算有效数据
				if(processType == PROCESS_TYPE_16 || processType == PROCESS_TYPE_13){
					//获取流程状态，只加载流程通过
					Integer processStatus = BaseHelpUtils.getIntValue(e.getProcessStatus());
					if(processStatus != 3){
						continue;
					}
				}
				//获取结束时间
				Date endDate = e.getEndDate();
				//获取开始时间
				Date startDate = e.getStartDate();
				if (DateUtil.isSameDay(recordDate, startDate) || DateUtil.isSameDay(endDate, recordDate) || (DateUtil.compareDate(normalCheckout, startDate) && DateUtil.compareDate(endDate, normalCheckin))) {
					resultList.add(e);
				}
			}
		}
		return resultList;
	}

	/**
	 * 获取补签的数据
	 * @param personnelList
	 * @param processType
	 * @param employeeId
	 * @param date
	 * @param type:补签：0：上午；1：下午
	 * @return
	 * @throws SQLException
	 */
	public BaseAttendancePersonnelData fillcheckOfPersonnel(Map<String,List<BaseAttendancePersonnelData>> perMap,int processType,int employeeId,Date date,int type) throws SQLException{
		List<BaseAttendancePersonnelData> personnelList = perMap.get(employeeId+"_"+processType);
		if(BaseHelpUtils.isNullOrEmpty(personnelList) || personnelList.size() == 0) {
			return null;
		}
		for(BaseAttendancePersonnelData bean : personnelList){
			if (bean.getProcessType() == processType && bean.getType() == type && bean.getEmployeeId() == employeeId && DateUtil.isSameDay(date,bean.getStartDate())) {
				return bean;
			}
		}
		return null;
	}

	/**
	 * 删除数据集
	 * @param ids
	 * @param year
	 * @param month
	 * @param startDate
	 * @param endDate
	 * @throws SQLException
	 */
	public void deleteData(Integer personId,int year,int month,Date startDate,Date endDate) throws SQLException {
		EmployeeDayCheck dDao = new EmployeeDayCheck();
		dDao.addAnyAndCondition("record_date between ? and ?", startDate,endDate);
		dDao.setConditionIsLocked("=", false);
		EmployeeMonthCheck mDao = new EmployeeMonthCheck();
		mDao.setConditionYear("=", year);
		mDao.setConditionMonth("=", month);
		mDao.setConditionIsLocked("=", false);
		if(!BaseHelpUtils.isNullOrEmpty(personId) && personId > 0) {
			dDao.setConditionEmployeeId("=", personId);
			mDao.setConditionEmployeeId("=", personId);
		}
		dDao.conditionalDelete();
		mDao.conditionalDelete();
	}

	/**
	 * 获取员工每天凌晨打卡数据集
	 * @param startDate
	 * @param endDate
	 * @param personId
	 * @return
	 * @throws SQLException
	 */
	public Map<String,Date> getCheckinoutData(Date startDate,Date endDate,int personId) throws SQLException{
		Map<String,Date> inoutMap = new HashMap<>();
		QueryAttendanceCheckinoutData inoutQuery = new QueryAttendanceCheckinoutData();
		ConditionAttendanceCheckinoutData inoutCon = new ConditionAttendanceCheckinoutData();
		inoutCon.setStartDate(startDate);
		//计算是当前的，但是要取第二天的凌晨打卡数据，则需要将结束天往后追加一天
		endDate = DateUtil.getNextDayOfDay(endDate, 1);
		inoutCon.setEndDate(endDate);
		if(personId > 0) {
			inoutCon.setEmployeeId(personId);
		}
		BaseCollection<BaseAttendanceCheckinoutData> inoutRe = inoutQuery.runQuery(null, inoutCon);
		if(!BaseHelpUtils.isNullOrEmpty(inoutRe)) {

			Calendar ca = Calendar.getInstance();
			List<BaseAttendanceCheckinoutData> inoutList = inoutRe.getCollections();
			for(BaseAttendanceCheckinoutData inoutBean : inoutList) {
				//获取打卡开始日期，只获取6点之前的数据，包含6点
				Date checkinTime = inoutBean.getLastCheckoutTime();
				if(BaseHelpUtils.isNullOrEmpty(checkinTime)) {
					continue;
				}
				ca.setTime(checkinTime);
				int hour = ca.get(Calendar.HOUR_OF_DAY);
				int minute = ca.get(Calendar.MINUTE);
				if(hour > 6 || (hour == 6 && minute > 0)) {
					continue;
				}
				int empId = BaseHelpUtils.getIntValue(inoutBean.getEmployeeId());
				//设置为上一天的打卡数据
				ca.add(Calendar.DAY_OF_MONTH, -1);
				String dateStr = DateUtil.getChinaDateString(ca.getTime());
				inoutMap.put(dateStr+empId, checkinTime);
			}
		}
		return inoutMap;
	}

}
