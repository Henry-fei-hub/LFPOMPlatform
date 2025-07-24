package pomplatform.shift.business;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import com.pomplatform.db.handler.ShiftTimeManageHandler;
import delicacy.common.*;
import delicacy.connection.ThreadConnection;
import delicacy.connection.ThreadUtil;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessInstance;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.shift.bean.*;
import pomplatform.shift.query.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 班次管理相关
 * @author lxf
 */
public class OnShiftManageProcess implements GenericProcessor,GenericDownloadProcessor {
	private static final Logger __logger = Logger.getLogger("");
	//操作类型
	private static final String OPT_TYPE = "optType";
	//节日保存
	private static final String ON_SAVE_BATCH_HOLIDAY_INFO = "onSaveBatchHolidayInfo";
	private static final String ON_UPDATE_SHIFT_MANAGE = "onUpdateShiftManage";
	private static final String DELETE_SHIFT_TIME_MANAGE = "deleteShiftTimeManage";
	//员工排班保存
	private static final String ON_SAVE_EMPOYEE_SHIFT = "onSaveEmployeeShift";
	//日考勤汇总计算
	private static final String ON_EMPLOYEE_DAY_CHECK = "onEmployeeDayCheck";
	//日考勤汇总计算
	private static final String ON_EMPLOYEE_DAY_CHECKS = "onEmployeeDayChecks";
	//月考勤汇总计算
	private static final String ON_EMPLOYEE_MONTH_CHECK = "onEmployeeMonthCheck";
	//给考勤总表和明细表的数据加锁
	private static final String ON_LOCK_CHECK_DATA = "onLockCheckData";
	//考勤月统计
	private static final String ON_CHECK_MONTH_DATA = "onCheckMonthData";
	//考勤总表统计
	private static final String ON_CHECK_TOTAL_ACCOUNT = "onCheckTotalAccount";
	//给个人考勤总表和明细表数据解锁
	private static final String UNLOCK_CHECK_DATA = "unlockCheckData";
	//给个人考勤明细表数据加锁
	private static final String LOCK_SINGLE_CHECK_DATA = "lockSingleCheckData";
	//加载日考勤数据
	private static final String ON_LOAD_EMPLOYEE_DAY_CHECK = "onLoadEmployeeDayCheck";

	//将ERP登记人员封装到map中
	private static Map<Integer,BaseEmployee> empMap = new HashMap<>();
	//用于存放已入库员工的月统计数据
	private static Map<Integer, BaseEmployeeMonthlyCheck> empMonthMap = new HashMap<>();
	//用于存放班次时段数据
	private static Map<Integer, BaseShiftTimeManage> shiftTimeMap = new HashMap<>();
	//*********************************************考勤状态开始**********
	public static final Integer ATTENDANCE_STATUS_OTHER = -1;//未知
	public static final Integer ATTENDANCE_STATUS_0 = 0;//正常
	public static final Integer ATTENDANCE_STATUS_1 = 1;//迟到
	public static final Integer ATTENDANCE_STATUS_2 = 2;//早退
	public static final Integer ATTENDANCE_STATUS_3 = 3;//病假
	public static final Integer ATTENDANCE_STATUS_4 = 4;//事假
	public static final Integer ATTENDANCE_STATUS_5 = 5;//产假
	public static final Integer ATTENDANCE_STATUS_6 = 6;//调休
	public static final Integer ATTENDANCE_STATUS_7 = 7;//出差
	public static final Integer ATTENDANCE_STATUS_8 = 8;//外出
	public static final Integer ATTENDANCE_STATUS_9 = 9;//陪护假
	public static final Integer ATTENDANCE_STATUS_10 = 10;//婚假
	public static final Integer ATTENDANCE_STATUS_11 = 11;//丧假
	public static final Integer ATTENDANCE_STATUS_12 = 12;//产检假
	public static final Integer ATTENDANCE_STATUS_13 = 13;//旷工
	public static final Integer ATTENDANCE_STATUS_14 = 14;//加班
	public static final Integer ATTENDANCE_STATUS_15 = 15;//休息
	public static final Integer ATTENDANCE_STATUS_16 = 16;//节假日
	public static final Integer ATTENDANCE_STATUS_17 = 17;//其它假类
	//*********************************************考勤状态结束**********

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
	//*********************************************班次类型**********
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取操作类型
		String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
		switch (optType) {
			case ON_SAVE_BATCH_HOLIDAY_INFO:
				return onSaveBatchHolidayInfo(param);
			case ON_UPDATE_SHIFT_MANAGE:
				return onUpdateShiftManage(param);
			case DELETE_SHIFT_TIME_MANAGE:
				return deleteShiftTimeManage(param, creteria);
			case ON_SAVE_EMPOYEE_SHIFT:
				return onSaveEmployeeShiftThread(param);
			case ON_EMPLOYEE_MONTH_CHECK:
				return onEmployeeMonthCheckThread(param);
			case ON_EMPLOYEE_DAY_CHECK:
				return onEmployeeDayCheck();
			case ON_LOCK_CHECK_DATA:
				return onLockCheckData(param);
			case ON_CHECK_MONTH_DATA:
				return onCheckMonthData(param);
			case ON_EMPLOYEE_DAY_CHECKS:
				return onEmployeeDayChecks(param);
			case ON_CHECK_TOTAL_ACCOUNT:
				return onCheckTotalAccount(param);
			case UNLOCK_CHECK_DATA:
				return unlockCheckData(param);
			case LOCK_SINGLE_CHECK_DATA:
				return lockSingleCheckData(param);
			case ON_LOAD_EMPLOYEE_DAY_CHECK:
				return onLoadEmployeeDayCheck(param);
			default:
				break;
		}
		return null;
	}

	/**
	 * 流程同步计算考勤
	 * @param bean
	 * @throws Exception
	 */
	public static void syncAttendance(BasePersonnelBusines bean) throws Exception {
		if(BaseHelpUtils.isNullOrEmpty(bean)) {
			return;
		}
		//单独起个线程来跑考勤计算
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					//获取时间开始时间
					Date startDate = bean.getStartDate();
					Date endDate = bean.getEndDate();
					if(BaseHelpUtils.isNullOrEmpty(endDate)) {
						//打卡申请只有一个打卡时间，所以设置结束时间和开始时间一致
						endDate = startDate;
					}
					//获取当月最后一天，如果结束日期在当月最后一天之后，则截止时间设置为当月的最后一天，主要解决长假（比如：产假）
					Date currentDate = new Date();
					if(endDate.after(currentDate)) {
						endDate = currentDate;
					}else {
						Date lastDate = DateUtil.getLastDay(currentDate);
						if(endDate.after(lastDate)) {
							endDate = lastDate;
						}
					}
					//开始日期往前推一天计算
//					startDate = DateUtil.getNextDayOfDay(startDate, -1);
					//取开始日期所属月的第一天开始计算，确保计算整月的数据集
					startDate = DateUtil.getFirstDay(startDate);
					//获取申请人
					int empId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
					OnShiftManageProcess p = new OnShiftManageProcess();
					p.syncAttendance(empId, startDate, endDate);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread thread=new Thread(runnable);
		thread.start();
	}

	/**
	 * 实时同步考勤（用于流程发起或者结束触发计算考勤）
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @throws Exception
	 */
	public void syncAttendance(int employeeId,Date startDate,Date endDate) throws Exception {
		if(employeeId <= 0 || BaseHelpUtils.isNullOrEmpty(startDate) || BaseHelpUtils.isNullOrEmpty(endDate)) {
			return;
		}
		//将开始日期的时间设置为00:00:00,结束时间设置为23:59:00
		Calendar ca = Calendar.getInstance();
		ca.setTime(startDate);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		startDate = ca.getTime();
		ca.setTime(endDate);
		ca.set(Calendar.HOUR_OF_DAY, 23);
		ca.set(Calendar.MINUTE, 59);
		ca.set(Calendar.SECOND, 0);
		endDate = ca.getTime();
		//获取开始日期的年月份
		int year = DateUtil.getYear(startDate);
		int month = DateUtil.getMonth(startDate);
		//如果开始日期和结束日期不在同一个月，则分两次计算
		if(DateUtil.getMonth(startDate) != DateUtil.getMonth(endDate)) {
			//说明是垮月的，分两次计算
			Date accStartDate = startDate;
			Date accEndDate = DateUtil.getLastDay(accStartDate);
			//第一次计算
			processCheckData(accStartDate, accEndDate, employeeId, year, month);
			employeeCheckMonthAccount(null,null,year, month,employeeId);
			accStartDate = DateUtil.getFirstDay(endDate);
			accEndDate = endDate;
			//重置开始年月
			year = DateUtil.getYear(endDate);
			month = DateUtil.getMonth(endDate);
			//第二次计算
			processCheckData(accStartDate, accEndDate, employeeId, year, month);
			employeeCheckMonthAccount(null,null,year, month,employeeId);
		}else {//如果在同一个月，则计算一次
			processCheckData(startDate, endDate, employeeId, year, month);
			employeeCheckMonthAccount(null,null,year, month,employeeId);
		}
	}

	/**
	 * 加载日考勤数据
	 * @param param
	 * @return
	 * @throws Exception
	 */
	private String onLoadEmployeeDayCheck(Map<String, Object> param) throws Exception {
		BaseCollection<BaseEmployeeDayCheck> bc = new BaseCollection<>();
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		Date recordDate = new Date();
		EmployeeCheckinoutDetail e = new EmployeeCheckinoutDetail();
		e.setConditionEmployeeId("=",employeeId);
		e.setConditionCheckDate("=",recordDate);
		List<BaseEmployeeCheckinoutDetail> list = e.conditionalLoad("order by check_date asc");
		Date checkin = null;//上班时间
		Date checkout = null;//下班时间
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			Date restEndTime = getNormalDate("13:45", recordDate, 0);
			for(BaseEmployeeCheckinoutDetail be : list){
				if(BaseHelpUtils.isNullOrEmpty(be.getCheckTime())){
					continue;
				}
				//和中午时间比较，如果早于这个时间，则视为上班卡，否则视为下班卡
				if(be.getCheckTime().before(restEndTime)){
					if(BaseHelpUtils.isNullOrEmpty(checkin)){
						checkin = be.getCheckTime();
						continue;
					}
					if(be.getCheckTime().before(checkin)){
						checkin = be.getCheckTime();
						continue;
					}
				}else{
					if(BaseHelpUtils.isNullOrEmpty(checkout)){
						checkout = be.getCheckTime();
						continue;
					}
					if(be.getCheckTime().after(checkout)){
						checkout = be.getCheckTime();
						continue;
					}
				}
			}
		}
		List<BaseEmployeeDayCheck> resultList = new ArrayList<>();
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		bean.setEmployeeId(employeeId);
		bean.setCheckin(checkin);
		bean.setCheckout(checkout);
		bean.setStatus(0);
		resultList.add(bean);
		bc.setCollections(resultList);
		return bc.toJSON(0, "");
	}

	private String onEmployeeDayChecks(Map<String, Object> param) throws Exception {
		BaseCollection<BaseEmployeeDayCheck> bc = new BaseCollection<>();
//		int year = BaseHelpUtils.getIntValue(param.get("year"));
		int year = DateUtil.getYear();
		int month = BaseHelpUtils.getIntValue(param.get("month"));
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		Date recordDate = new Date();
		EmployeeDayCheck e = new EmployeeDayCheck();
		e.setConditionEmployeeId("=",employeeId);
		e.setConditionYear("=",year);
		e.setConditionMonth("=",month);
		e.setConditionRecordDate("<=",recordDate);
		List<BaseEmployeeDayCheck> list = e.conditionalLoad("order by record_date asc");
		bc.setCollections(list);
		return bc.toJSON(0, "");
	}


	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
//        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);

	}

	/**
	 * 给个人考勤详情表数据加锁
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	private String lockSingleCheckData(Map<String, Object> param) throws SQLException {
		int year = BaseHelpUtils.getIntValue(param.get("year"));
		int month = BaseHelpUtils.getIntValue(param.get("month"));
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		if(year == 0 || month == 0){
			throw new SQLException("操作异常:年份或月份不可为空");
		}
		if(employeeId == 0){
			throw new SQLException("操作异常:人员不可为空");
		}
		EmployeeDayCheck ddao = new EmployeeDayCheck();
		ddao.setConditionEmployeeId("=",employeeId);
		ddao.setConditionYear("=", year);
		ddao.setConditionMonth("=", month);
		ddao.setConditionIsLocked("=",Boolean.FALSE);
		ddao.setIsLocked(true);
		ddao.conditionalUpdate();

		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}


	/**
	 * 给个人考勤总表和明细表数据解锁
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	private String unlockCheckData(Map<String, Object> param) throws SQLException {
		int year = BaseHelpUtils.getIntValue(param.get("year"));
		int month = BaseHelpUtils.getIntValue(param.get("month"));
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		if(year == 0 || month == 0){
			throw new SQLException("操作异常:年份或月份不可为空");
		}
		if(employeeId == 0){
			throw new SQLException("操作异常:人员不可为空");
		}
		EmployeeDayCheck ddao = new EmployeeDayCheck();
		ddao.setConditionEmployeeId("=",employeeId);
		ddao.setConditionYear("=", year);
		ddao.setConditionMonth("=", month);
		ddao.setConditionIsLocked("=",Boolean.TRUE);
		ddao.setIsLocked(false);
		ddao.conditionalUpdate();

		EmployeeMonthCheck mdao = new EmployeeMonthCheck();
		mdao.setConditionEmployeeId("=", employeeId);
		mdao.setConditionYear("=", year);
		mdao.setConditionMonth("=", month);
		mdao.setConditionIsLocked("=",Boolean.TRUE);
		mdao.setIsLocked(false);
		mdao.conditionalUpdate();

		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}


	/**
	 * 考勤总表计算
	 * @param param
	 * @return
	 * @throws Exception
	 */
	private String onCheckTotalAccount(Map<String, Object> param) throws Exception {
		//获取日期
		String recordDateStr = BaseHelpUtils.getStringValue(param, "recordDate");
		if(BaseHelpUtils.isNullOrEmpty(recordDateStr)){
			throw new SQLException("加载异常:检索日期不可为空");
		}
		Date recordDate = new Date(Long.valueOf(recordDateStr));
		//获取业务部门
		int plateId = BaseHelpUtils.getIntValue(param, "plateId");
		//加载总表汇率数据
		ConditionOnLoadAttendanceTotal con = new ConditionOnLoadAttendanceTotal();
		if(plateId > 0){
			con.setPlateId(plateId);
		}
		con.setStartDate(recordDate);
		con.setEndDate(recordDate);
		QueryOnLoadAttendanceTotal dao = new QueryOnLoadAttendanceTotal();
		BaseCollection<BaseOnLoadAttendanceTotal> result = dao.executeQuery(null, con);
		List<BaseOnCheckAttendanceTotal> list = new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(result) && result.getCollections().size() > 0){
			ConditionOnLoadAttendanceStatus asCon = new ConditionOnLoadAttendanceStatus();
			QueryOnLoadAttendanceStatus asDao = new QueryOnLoadAttendanceStatus();
			BaseOnCheckAttendanceTotal bean = null;
			for(BaseOnLoadAttendanceTotal e : result.getCollections()){
				bean = new BaseOnCheckAttendanceTotal();
				int id = e.getPlateId();
				bean.setPlateId(id);
				//获取总数
				int totalNum = BaseHelpUtils.getIntValue(e.getTotalNum());
				//获取请假人员数
				int leaveNum = BaseHelpUtils.getIntValue(e.getLeaveNum());
				//获取旷工人员数
				int absenceNum = BaseHelpUtils.getIntValue(e.getAbsenceNum());
				//计算出勤率=(总数-请假人员数-旷工人员数)/总数*100
				if(totalNum == 0){
					continue;
				}
				BigDecimal percent = BigDecimal.valueOf(totalNum-leaveNum-absenceNum).multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(totalNum), 2, BigDecimal.ROUND_DOWN);
				String percentStr = percent+"%";
				bean.setAttendanceRate(percentStr);
				asCon.setPlateId(id);
				asCon.setStartDate(recordDate);
				asCon.setEndDate(recordDate);
				BaseCollection<BaseOnLoadAttendanceStatus> asResult = asDao.executeQuery(null, asCon);
				if(!BaseHelpUtils.isNullOrEmpty(asResult) && asResult.getCollections().size() > 0){
					for(BaseOnLoadAttendanceStatus asBean : asResult.getCollections()){
						int processType = asBean.getProcessType();
						//获取人员数
						int personnelNum = BaseHelpUtils.getIntValue(asBean.getPersonnelNum());
						switch (processType) {
							case 16://外出
								bean.setOutNum(personnelNum);
								break;
							case 14://出差
								bean.setBusinessNum(personnelNum);
								break;
							case 13://请假
								bean.setLeaveNum(personnelNum);
								break;
							case 4://旷工
								bean.setAbsenceNum(personnelNum);
								break;
							case 3://早退
								bean.setEarlyNum(personnelNum);
								break;
							case 2://迟到
								bean.setLateNum(personnelNum);
								break;
							default:
								break;
						}
					}
					list.add(bean);
				}
			}
		}
		BaseCollection<BaseOnCheckAttendanceTotal> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON(0,null);
	}

	/**
	 * 考勤数据月统计
	 * @param param
	 * @return
	 * @throws Exception
	 */
	private String onCheckMonthData(Map<String, Object> param) throws Exception {
		int year = BaseHelpUtils.getIntValue(param.get("year"));
		int month = BaseHelpUtils.getIntValue(param.get("month"));
		int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
		Calendar ca =Calendar.getInstance();
		ca.set(year, month-1, 1);
		Date startDate = DateUtil.getFirstDay(ca.getTime());
		Date endDate = DateUtil.getLastDay(ca.getTime());
		employeeCheckMonthAccount(startDate,endDate,year, month,employeeId);
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}


	/**
	 * 给考勤总表和明细表的数据加锁
	 * @return
	 * @throws SQLException
	 */
	private String onLockCheckData(Map<String,Object> map) throws SQLException {
		int year = BaseHelpUtils.getIntValue(map.get("year"));
		int month = BaseHelpUtils.getIntValue(map.get("month"));

		EmployeeDayCheck ddao = new EmployeeDayCheck();
		if(!BaseHelpUtils.isNullOrEmpty(map.get("employeeId"))){
			ddao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(map.get("employeeId")));
		}
		ddao.setConditionYear("=", year);
		ddao.setConditionMonth("=", month);
		ddao.setIsLocked(true);
		ddao.conditionalUpdate();

		EmployeeMonthCheck mdao = new EmployeeMonthCheck();
		if(!BaseHelpUtils.isNullOrEmpty(map.get("employeeId"))){
			mdao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(map.get("employeeId")));
		}
		mdao.setConditionYear("=", year);
		mdao.setConditionMonth("=", month);
		mdao.setIsLocked(true);
		mdao.conditionalUpdate();

		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}

	public static String onEmployeeMonthCheckThread(Map<String, Object> params) throws Exception{
		int operator = BaseHelpUtils.getIntValue(params, "operator");
		return ThreadTaskTemplate.runThreadTask(params, ThreadTaskUtils.TASK_TYPE_ONE,
				operator, ThreadTaskUtils.OPERATION_TYPE_ONE);
	}

	/**
	 * 月考勤汇总计算
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static String onEmployeeMonthCheck(Map<String, Object> param) throws Exception{
		//获取年份和月份
		int year = BaseHelpUtils.getIntValue(param, "year");
		int month = BaseHelpUtils.getIntValue(param, "month");
		//获取职员ID
		int employeeId = BaseHelpUtils.getIntValue(param,"employeeId");
		Date currentDate = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(currentDate);
		int currentYear = ca.get(Calendar.YEAR);
		int currentMonth = ca.get(Calendar.MONTH)+1;
		Date endDate =null;
		Date startDate =null;
		//判断是否是跨月考勤
		boolean isCrossMonth = false;
		int countDay = 0;
		BaseSystemConfig scBean = StaticUtils.configMap.get(StaticUtils.CONFIG_TYPE_4);
		if(!BaseHelpUtils.isNullOrEmpty(scBean)){
			isCrossMonth = BaseHelpUtils.getBoolean(scBean.getIsCrossMonth());
			countDay = BaseHelpUtils.getIntValue(scBean.getCountDay());
		}
		//计算是否是计算本月的数据
		boolean isAccountCurrentMonth = true;
		if(year != currentYear || month != currentMonth){
			isAccountCurrentMonth = false;
		}
		if(isCrossMonth){//说明是跨月考勤
			ca.set(year, month-2, countDay+1);
			startDate = ca.getTime();
			if(isAccountCurrentMonth){//计算当前月数据
				ca.set(year, month-1, countDay);
				if(currentDate.before(ca.getTime())){
					endDate = currentDate;
				}else{
					endDate = ca.getTime();
				}
			}else{
				ca.set(year, month-1, countDay);
				endDate = ca.getTime();
			}
		}else{//非跨月考勤
			if(isAccountCurrentMonth){//计算当前月数据
				startDate = DateUtil.getFirstDay(currentDate);
				endDate = currentDate;
			}else{
				ca.set(year, month-1, 1);
				startDate = DateUtil.getFirstDay(ca.getTime());
				endDate = DateUtil.getLastDay(ca.getTime());
			}
		}
		//将结束日期的时间设置到23:59
		ca.setTime(endDate);
		ca.set(Calendar.HOUR_OF_DAY, 23);
		ca.set(Calendar.MINUTE, 59);
		endDate = ca.getTime();
		if(!BaseHelpUtils.isNullOrEmpty(startDate) && !BaseHelpUtils.isNullOrEmpty(endDate)){
			processCheckData(startDate,endDate,employeeId,year,month);
			employeeCheckMonthAccount(startDate,endDate,year, month,employeeId);
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}

	/**
	 * 日考勤汇总计算
	 * @return
	 * @throws Exception
	 */
	public String onEmployeeDayCheck() throws Exception{
		//获取当前系统日期，如果结束日期大于当前系统日期，则设置结束日期为当前系统日期
		Date currentDate = new Date();
		int year = DateUtil.getYear(currentDate);
		int month = DateUtil.getMonth(currentDate);
		ThreadConnection.beginTransaction();
		processCheckData(currentDate,currentDate,0,year,month);
		//计算月考勤数据
		employeeCheckMonthAccount(currentDate,currentDate,year, month,0);
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}

	/**
	 * 第三版考勤计算算法
	 * @param startDate
	 * @param endDate
	 * @param personId
	 * @param year
	 * @param month
	 * @throws Exception
	 */
	public static void processCheckData(Date startDate,Date endDate,int personId,int year,int month) throws Exception {
		OnShiftManageUtils p = new OnShiftManageUtils();
		p.accountDayAttendance(startDate, endDate, personId, year, month);
	}

	/**
	 * 第二版考勤计算算法
	 * 公用算法，可计算每天所有人员、没人每月、所有人每月考勤
	 * @param startDate:计算开始日期
	 * @param endDate：计算结束日期
	 * @param year：计算年份
	 * @param month；计算月份
	 * @throws Exception
	 */
	public static void processCheckDataOld(Date startDate,Date endDate,int personId,int year,int month) throws Exception {
		//封装本月需计算的人员,如果employeeId>0则说明是计算个人的
		List<BaseEmployee> empList = new ArrayList<>();
		empMap.clear();
		Employee empDao = new Employee();
		if(personId > 0){
			empDao.setEmployeeId(personId);
			if(empDao.load()){
				BaseEmployee be = empDao.generateBase();
				empList.add(empDao.generateBase());
				empMap.put(personId, be);
			}
		}else{
			//封装ERP系统上登记的入职的在职和参与考勤的人员信息，检索在职或者本月离职的人员
			empDao.unsetSelectFlags();
			empDao.setSelectEmployeeId(true);//只需要检索职员的ID
			empDao.setSelectStatus(true);
			empDao.setSelectResignationDate(true);
			empDao.setSelectDepartmentId(true);
			empDao.setSelectOnboardDate(true);
			empDao.setSelectIsCheck(true);
			empDao.setConditionEmployeeId(">",0);//过滤超级管理员
			StringBuffer sql = new StringBuffer();
			/**
			 * 不参与考勤，但是在当前计算月入职和离职的需要计算
			 * 参与考勤，入职日期小于或等于当前计算截止日期或者是当前计算月离职的员工
			 */
			sql.append("(is_check = false and ((EXTRACT(YEAR from onboard_date)= ").append(year)
					.append(" and EXTRACT(MONTH from onboard_date) = ").append(month)
					.append(") or (EXTRACT(YEAR from resignation_date)=").append(year)
					.append(" and EXTRACT(MONTH from resignation_date) = ").append(month)
					.append(" ))) or (is_check = true and (status = 0 and onboard_date <='").append(endDate)
					.append("') or (status = 1 and EXTRACT(YEAR from resignation_date)=")
					.append(year).append(" and EXTRACT(MONTH from resignation_date) = ")
					.append(month).append(")) order by employee_id");
//    		String sql = " (status = 0 and onboard_date <='"+endDate+"') or (status = 1 and EXTRACT(YEAR from resignation_date)="+year+" and EXTRACT(MONTH from resignation_date) = "+month+") order by employee_id";
			empList = empDao.conditionalLoad(sql.toString());
			for(BaseEmployee bean : empList){
				int empId = bean.getEmployeeId();
				empMap.put(empId,bean);
			}
		}
		//检索是否有加载班次时段的数据，如果没有，则重新封装
		shiftTimeMap.clear();
		//封装班次时段的数据集
		ShiftTimeManage shiftTimeDao = new ShiftTimeManage();
		List<BaseShiftTimeManage> shiftTimeList = shiftTimeDao.conditionalLoad();
		for(BaseShiftTimeManage bean : shiftTimeList){
			int shiftTimeManageId = bean.getShiftTimeManageId();
			shiftTimeMap.put(shiftTimeManageId,bean);
		}
		HolidayManage holidayDao = new HolidayManage();
		PersonnelBusines personnelBusinessDao = new PersonnelBusines();
		EmployeeDayCheck empDayCheckDao = new EmployeeDayCheck();
		BaseEmployeeDayCheck empDayCheckBean = null;
		//加载考勤规则数据集
		AttendanceRule arDao = new AttendanceRule();
		arDao.setConditionIsEnable("=", true);
		List<BaseAttendanceRule> arList = arDao.conditionalLoad();
		Map<Integer,List<BaseAttendanceRuleTime>> ruleTimeMap = new HashMap<>();
		int ruleType = 0;
		if(!BaseHelpUtils.isNullOrEmpty(arList) && arList.size() > 0) {
			AttendanceRuleDepartment ardDao = new AttendanceRuleDepartment();
			AttendanceRuleTime artDao = new AttendanceRuleTime();
			for(BaseAttendanceRule arBean : arList) {
				ruleType = BaseHelpUtils.getIntValue(arBean.getRuleType());
				int ruleId = BaseHelpUtils.getIntValue(arBean.getAttendanceRuleId());
				if(ruleType == 1) {
					ardDao.clear();
					ardDao.setConditionAttendanceRuleId("=", ruleId);
					List<BaseAttendanceRuleDepartment> ardList = ardDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(ardList) && ardList.size() > 0) {
						artDao.clear();
						artDao.setConditionAttendanceRuleId("=", ruleId);
						List<BaseAttendanceRuleTime> artList = artDao.conditionalLoad("order by attendance_rule_time_id");
						if(!BaseHelpUtils.isNullOrEmpty(artList) && artList.size() > 0) {
							for(BaseAttendanceRuleDepartment ardBean : ardList) {
								int depId = BaseHelpUtils.getIntValue(ardBean.getDepartmentId());
								ruleTimeMap.put(depId, artList);
							}
						}
					}
				}
			}
		}

		//定义map来存放不计算加班补助的部门,人力资源部、行政部、财务部没有加班补助
//    	Map<Integer,Integer> depMap = new HashMap<>();
//    	depMap.put(56, 56);//行政部
//    	depMap.put(57, 57);//人力资源部
//    	depMap.put(58, 58);//财务部

		//获取所有参与考勤且排班的人员班次信息
		Map<String,BaseOnLoadEmpShiftInfo> shiftInfoMap = generateEmployeeWorkDays(startDate, endDate,personId);
		//加载员工在上一天的加班可调休工时
		Map<String,Integer> restMap = new HashMap<>();
		Set<Integer> lockedEmployeeIds = new HashSet<>();
		List<Integer> employeeAbsenceIds = new ArrayList<>();
		Map<Integer,BaseOnLoadEmployeeCheckTime> checkMap = new HashMap<>();
		int ii = 0;
		//遍历每一天数据开始***********************************
		for(Date recordDate = startDate; recordDate.compareTo(endDate) <= 0; recordDate = DateUtil.getNextDayOfDay(recordDate, 1)) {
			ii++;
			//统计 在 为工作日的节假日 需要记为旷工的人 （1:计算日期在入职日期之前的 或 2:计算日期在离职以后的 视为缺勤）
			employeeAbsenceIds.clear();
			for (BaseEmployee baseEmployee : empList) {
				if(baseEmployee.getStatus() == 1){//离职员工 判断统计日期是否在离职日期之后
					if(null != baseEmployee.getResignationDate()){
						if(baseEmployee.getResignationDate().compareTo(recordDate) < 0){
							employeeAbsenceIds.add(baseEmployee.getEmployeeId());
						}
					}
				}else if(baseEmployee.getStatus() == 0){
					if(null != baseEmployee.getOnboardDate()){//在职员工 判断统计日期是否在入职日期之前
						if(baseEmployee.getOnboardDate().compareTo(recordDate) > 0){
							employeeAbsenceIds.add(baseEmployee.getEmployeeId());
						}
					}
				}
			}

			//更具当前日期检索是否为节假日,默认为false
			boolean isHoliDay = false;
			boolean isholidayWorkDay = false;
			boolean isCountOvertime = true;
			holidayDao.clear();
			holidayDao.setConditionRecordDate("=",recordDate);
			BaseHolidayManage holidayBean = holidayDao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(holidayBean)){//说明是节假日
				isHoliDay = true;
				isholidayWorkDay = holidayBean.getIsWorkDay();
				isCountOvertime = BaseHelpUtils.getBoolean(holidayBean.getIsCountOvertime());
			}
			personnelBusinessDao.clear();
			if(personId > 0){
				personnelBusinessDao.setConditionEmployeeId("=",personId);
			}
			personnelBusinessDao.setConditionDeleteFlag("=",StaticUtils.NO_DELETE);
			String recordDateStr = DateUtil.formatDateString(recordDate);
			String sql = "('"+recordDateStr+"' >= to_char(start_date,'yyyy-mm-dd') and '"+recordDateStr+"' <= to_char(end_date,'yyyy-mm-dd') or (process_type = 15 and '"+recordDateStr+"' = to_char(start_date,'yyyy-mm-dd')))";
			List<BasePersonnelBusines> personnelList = personnelBusinessDao.conditionalLoad(sql);

			//根据当前计算日期检索所有员工这一天的最早打卡时间和最晚打卡时间，可跨天，当前设置跨天界限为6点
			Calendar ca = Calendar.getInstance();
			ca.setTime(recordDate);
			ca.set(Calendar.HOUR_OF_DAY,6);
			ca.set(Calendar.MINUTE,0);
			ca.set(Calendar.SECOND,0);
			//这一天的最早打卡时间点
			Date checkTime = ca.getTime();
			//这一天的最晚打卡时间点
			ca.add(Calendar.DATE, 1);
			Date checkEndTime = ca.getTime();
			checkMap.clear();
			QueryOnLoadEmployeeCheckTime empCheckTimeDao = new QueryOnLoadEmployeeCheckTime();
			ConditionOnLoadEmployeeCheckTime condition = new ConditionOnLoadEmployeeCheckTime();
			if(personId > 0){
				condition.setEmployeeId(personId);
			}
			condition.setStartTime(checkTime);
			condition.setEndTime(checkEndTime);
			BaseCollection<BaseOnLoadEmployeeCheckTime> empCheckTimeResult = empCheckTimeDao.executeQuery(null, condition);
			List<BaseOnLoadEmployeeCheckTime> checkList = null;
			if(!BaseHelpUtils.isNullOrEmpty(empCheckTimeResult)){
				checkList = empCheckTimeResult.getCollections();
				for(BaseOnLoadEmployeeCheckTime e : checkList){
					checkMap.put(e.getEmployeeId(), e);
				}
			}

			List<BaseEmployeeDayCheck> empDayCheckList = new ArrayList<>();
			//加载加锁员工数据集
			lockedEmployeeIds.clear();
			empDayCheckDao.clear();
			empDayCheckDao.unsetSelectFlags();
			empDayCheckDao.setSelectEmployeeId(true);
			empDayCheckDao.setConditionRecordDate("=",recordDate);
			empDayCheckDao.setConditionIsLocked("=",Boolean.TRUE);
			List<BaseEmployeeDayCheck> bedcs = empDayCheckDao.conditionalLoad();
			for(BaseEmployeeDayCheck bedc : bedcs) {
				lockedEmployeeIds.add(bedc.getEmployeeId());
			}
			if(ruleType == 1 && ii == 1) {
				empDayCheckDao.clear();
				Date yesterday = DateUtil.getNextDayOfDay(recordDate, -1);
				empDayCheckDao.setConditionRecordDate("=",yesterday);
				empDayCheckDao.setConditionHolidayOvertimeHours(">", BigDecimal.ZERO);
				List<BaseEmployeeDayCheck> edcList = empDayCheckDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(edcList) && edcList.size() > 0) {
					String dateStr = DateUtil.getChinaDateString(yesterday);
					for(BaseEmployeeDayCheck edcBean : edcList) {
						int minutes = BaseHelpUtils.getIntValue(edcBean.getHolidayOvertimeHours());
						int empId = BaseHelpUtils.getIntValue(edcBean.getEmployeeId());
						String str = dateStr+empId;
						restMap.put(str, minutes);
					}
				}
			}
			String dateStr = DateUtil.getChinaDateString(recordDate);
			//遍历员工进行考勤数据的计算
			for(Integer employeeId : empMap.keySet()){
				String str = dateStr + employeeId;
				//如果该人员在当前日期已经加锁，则不需要做任何操作
				if(lockedEmployeeIds.contains(employeeId)){//说明已经加锁
					continue;
				}
				empDayCheckBean = new BaseEmployeeDayCheck();
				empDayCheckList.add(empDayCheckBean);
				empDayCheckBean.setEmployeeId(employeeId);
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
				//获取员工的打卡记录
				BaseOnLoadEmployeeCheckTime checkBean = checkMap.get(employeeId);
				//定义上班打卡时间和下班打开时间，初始化为空
				Date checkin = null;
				Date checkout = null;
				//定义是否是只有一次打卡
				Boolean onlyOneCheck = false;
				//定义实际打卡下班时间
				Date factCheckOut = null;
				if(!BaseHelpUtils.isNullOrEmpty(checkBean)){//说明有打卡
					//获取上班时间和下班时间
					checkin = checkBean.getCheckinTime();
					checkout = checkBean.getCheckoutTime();
					empDayCheckBean.setCheckin(checkin);
					empDayCheckBean.setCheckout(checkout);
					factCheckOut= checkout;
				}
				//计算当前天可自动调休的工时
				//获取员工部门信息
				BaseEmployee empBean = empMap.get(employeeId);
				int depId = BaseHelpUtils.getIntValue(empBean.getDepartmentId());
				if(!BaseHelpUtils.isNullOrEmpty(checkout) && ruleTimeMap.size() > 0) {
					if(!BaseHelpUtils.isNullOrEmpty(empBean)) {
						//获取部门对应的时间段
						List<BaseAttendanceRuleTime> artList = ruleTimeMap.get(depId);
						int finalMinutes = 0;
						if(!BaseHelpUtils.isNullOrEmpty(artList) && artList.size() > 0) {
							for(BaseAttendanceRuleTime artBean : artList) {
								//获取开始时间点和结束时间点
								String fromTimeStr = BaseHelpUtils.getString(artBean.getFromTime());
								String toTimeStr = BaseHelpUtils.getString(artBean.getToTime());
								int minutes = BaseHelpUtils.getIntValue(artBean.getMinutes());
								boolean isCrossFrom = BaseHelpUtils.getBoolean(artBean.getIsCrossFrom());
								boolean isCrossTo = BaseHelpUtils.getBoolean(artBean.getIsCrossTo());
								//设置开始和结束时间点
								Date dateFrom = recordDate;
								Date dateTo = recordDate;
								if(isCrossFrom) {
									dateFrom = DateUtil.getNextDayOfDay(recordDate, 1);
								}
								if(isCrossTo) {
									dateTo = DateUtil.getNextDayOfDay(recordDate, 1);
								}
								Date fromTime = getNormalDate(fromTimeStr, dateFrom,0);
								Date toTime = getNormalDate(toTimeStr, dateTo,0);
								if(checkout.after(fromTime) && checkout.before(toTime)) {
									finalMinutes = minutes;
								}
							}
							empDayCheckBean.setHolidayOvertimeHours(new BigDecimal(finalMinutes));
							restMap.put(str, finalMinutes);
						}
					}
				}
				//设置加班开始时间
				Date overtimePayOfTime = getNormalDate("19:00", recordDate,0);
				//先检查这一天是否是节假日
				if(isHoliDay){//说明是节假日
					empDayCheckBean.setCheckin(checkin);
					empDayCheckBean.setCheckout(checkout);
					if(isholidayWorkDay){//如果是节假日，且是法定节假日，则计应出勤工作日
						empDayCheckBean.setShouldDays(BigDecimal.ONE);
						if(employeeAbsenceIds.contains(employeeId)){//表示在需要计算工作日的时候设置为缺勤
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
					if(!(employeeAbsenceIds.contains(employeeId) && isholidayWorkDay)){
						empDayCheckBean.setStatus(ATTE_STATUS_1);//设置为正常
						empDayCheckBean.setRemark("节假日");
					}
					//是否可记加班节假日
					if(!isCountOvertime) {
						continue;
					}
					BigDecimal overtimeHours = BigDecimal.ZERO;
					//检索是否有加班申请
					BasePersonnelBusines overTime = checkPersonnel(personnelList,PROCESS_TYPE_17, employeeId, recordDate);
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
				BaseOnLoadEmpShiftInfo shiftInfoBean = shiftInfoMap.get(str);
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
					BasePersonnelBusines overTime = checkPersonnel(personnelList,PROCESS_TYPE_17, employeeId, recordDate);
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
				boolean isCheck = BaseHelpUtils.getBoolean(empBean.getIsCheck());
				if(!isCheck) {//说明不参与考勤人员
					//获取在职状态
					int empStatus = BaseHelpUtils.getIntValue(empBean.getStatus());
					if(empStatus == 0) {//说明是在职
						//获取入职时间
						Date onBoardDate = empBean.getOnboardDate();
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
						Date reDate = empBean.getResignationDate();
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
				int shiftTimeManageId = getShiftTime(shiftInfoBean, recordDate);
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
				//获取是否需要签到
				boolean checkSignIn = shiftTimeBean.getCheckSignIn();
				//获取是否需要签退
				boolean checkSignOff = shiftTimeBean.getCheckSignOff();
				//获取签到时间
				String signInTime = shiftTimeBean.getSignInTime()==null?"09:00":shiftTimeBean.getSignInTime();
				//获取签退时间
				String signOffTime = shiftTimeBean.getSignOffTime()==null?"17:30":shiftTimeBean.getSignOffTime();
				//获取计迟到分钟数
				int lateMinutes = shiftTimeBean.getLateMinutes();
				//获取计早退分钟数
				int leaveMinutes = shiftTimeBean.getLeaveEarlyTime();
				if(leaveMinutes > 0){//如果即早退分钟数大于0，则设置为负数
					leaveMinutes = (-1)*leaveMinutes;
				}
				//获取正常上班时间和下班时间,即没有加上计迟到或者早退分钟数
				Date normalCheckin = getNormalDate(signInTime, recordDate,0);
				Date normalCheckout = getNormalDate(signOffTime, recordDate,0);
				//获取正常上班时间和下班时间,即加上计迟到或者早退分钟数
				Date normalCheckinAdd = getNormalDate(signInTime, recordDate,lateMinutes);
				if(ruleType == 1) {
					Date yesterday = DateUtil.getNextDayOfDay(recordDate, -1);
					String yesStr = DateUtil.getChinaDateString(yesterday);
					yesStr = yesStr+employeeId;
					Calendar cal = Calendar.getInstance();
					cal.setTime(normalCheckin);
					int minutes = BaseHelpUtils.getIntValue(restMap.get(yesStr));
					cal.add(Calendar.MINUTE, minutes);
					normalCheckin = cal.getTime();

					cal.setTime(normalCheckinAdd);
					cal.add(Calendar.MINUTE, minutes);
					normalCheckinAdd = cal.getTime();
				}
				Date normalCheckoutAdd = getNormalDate(signOffTime, recordDate,leaveMinutes);
				//获取算加班时间
				String overTime = shiftTimeBean.getOvertimeStartTime()==null?"19:00":shiftTimeBean.getOvertimeStartTime();
				Date overCheckout = getNormalDate(overTime, recordDate,0);
				//定义中午开始休息时间和结束时间
				Date restStartTime = getNormalDate("12:15", recordDate, 0);
				Date restEndTime = getNormalDate("13:45", recordDate, 0);
				//先检索该员工在当期日期是否有出差(非项目出差)
				int checkFlag = checkPersonnelBusiness(personnelList, empDayCheckBean, PROCESS_TYPE_14, employeeId, recordDate, restStartTime, restEndTime, "非项目出差");
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(项目出差)
				checkFlag = checkPersonnelBusiness(personnelList, empDayCheckBean, PROCESS_TYPE_18, employeeId, recordDate, restStartTime, restEndTime, "项目出差");
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(出差延期)
				checkFlag = checkPersonnelBusiness(personnelList, empDayCheckBean, PROCESS_TYPE_19, employeeId, recordDate, restStartTime, restEndTime, "出差延期");
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(出差更改行程)
				checkFlag = checkPersonnelBusiness(personnelList, empDayCheckBean, PROCESS_TYPE_20, employeeId, recordDate, restStartTime, restEndTime, "出差更改行程");
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(项目派驻)
				checkFlag = checkPersonnelBusiness(personnelList, empDayCheckBean, PROCESS_TYPE_21, employeeId, recordDate, restStartTime, restEndTime, "项目派驻");
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有出差(项目派驻延期)
				checkFlag = checkPersonnelBusiness(personnelList, empDayCheckBean, PROCESS_TYPE_22, employeeId, recordDate, restStartTime, restEndTime, "项目派驻延期");
				if(checkFlag == 1) {
					continue;
				}else if(checkFlag == 2) {//设置上班打卡时间为上班时间
					checkin = normalCheckin;
				}else if(checkFlag == 3) {//设置下班打卡时间为下班时间
					checkout = normalCheckout;
				}

				//先检索该员工在当期日期是否有外出
				List<BasePersonnelBusines> outList = checkPersonnelList(personnelList, PROCESS_TYPE_16, employeeId, recordDate);
				if(!BaseHelpUtils.isNullOrEmpty(outList) && outList.size() > 0) {
					//如果是多条流程，则取所有流程的最早时间点和最晚时间点
					Date accountStartTime = null;
					Date accountEndTime = null;
					for(BasePersonnelBusines out : outList) {
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
				List<BasePersonnelBusines> pList = checkPersonnelList(personnelList, PROCESS_TYPE_13, employeeId, recordDate);
				if(!BaseHelpUtils.isNullOrEmpty(pList) && pList.size() > 0) {
					boolean canCross = false;//设置第一种情况和第四种情况可跳过
					//设置请假的开始时间和结束时间，主要是解决同一天多种假类的问题（比如，早上调休，下午请假）
					Date accountStartTime = null;//取最早的
					Date accountEndTime = null;//取最晚的
					for(BasePersonnelBusines leave : pList) {
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
								canCross = true;
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
								canCross = true;
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
				BasePersonnelBusines fillCheckBeanOne = fillcheckOfPersonnel(personnelList,PROCESS_TYPE_15, employeeId, recordDate,0);
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
				BasePersonnelBusines fillCheckBeanTwo = fillcheckOfPersonnel(personnelList,PROCESS_TYPE_15, employeeId, recordDate,1);
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
//					empDayCheckBean.setCheckout(normalCheckout);
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
			if(!BaseHelpUtils.isNullOrEmpty(empDayCheckList) && empDayCheckList.size() > 0){
				for(BaseEmployeeDayCheck e : empDayCheckList){
					empDayCheckDao.clear();
					empDayCheckDao.setConditionRecordDate("=",e.getRecordDate());
					empDayCheckDao.setConditionEmployeeId("=",e.getEmployeeId());
					if(empDayCheckDao.countRows() > 0){
						empDayCheckDao.setDataFromBase(e);
						empDayCheckDao.conditionalUpdate();
					}else{
						empDayCheckDao.setDataFromBase(e);
						empDayCheckDao.save();
					}
				}
			}

		}//遍历每一天数据结束***********************************
	}


	/**
	 * 月考勤计算
	 * @param year
	 * @param month
	 * @throws Exception
	 */
	public static void employeeCheckMonthAccount(Date startDate,Date endDate,int year,int month,int employeeId) throws Exception{
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		BaseEmployeeMonthCheck bean =null;
		List<BaseEmployeeMonthCheck> list = new ArrayList<>();
		//加载日考勤数据汇总
		QueryOnLoadEmployeeMonthCheck monthDao = new QueryOnLoadEmployeeMonthCheck();
		ConditionOnLoadEmployeeMonthCheck condition = new ConditionOnLoadEmployeeMonthCheck();
		condition.setYear(year);
		condition.setMonth(month);
		if(!BaseHelpUtils.isNullOrEmpty(endDate)) {
			condition.setRecordDate(endDate);
		}
		if(employeeId > 0){
			condition.setEmployeeId(employeeId);
		}
		//获取上个月的加班补助
		Calendar ca = Calendar.getInstance();
		ca.set(year, month-1, 1);
		ca.add(Calendar.MONTH, -1);
		int lastYear = DateUtil.getYear(ca.getTime());
		int lastMonth = DateUtil.getMonth(ca.getTime());
		BaseCollection<BaseOnLoadEmployeeMonthCheck> result = monthDao.executeQuery(null, condition);
		if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result.getCollections())){
			//加载上上个月的考勤数据集
			dao.clear();
			dao.unsetSelectFlags();
			dao.setSelectEmployeeId(true);
			dao.setSelectOvertimePaySub(true);
			dao.setConditionYear("=", lastYear);
			dao.setConditionMonth("=", lastMonth);
			if(employeeId > 0){
				dao.setConditionEmployeeId("=", employeeId);
			}
			List<BaseEmployeeMonthCheck> lastList = dao.conditionalLoad();
			//定义存放上上个月的加班补助
			Map<Integer,BigDecimal> overtimePayMap = new HashMap<>();
			if(!BaseHelpUtils.isNullOrEmpty(lastList) && lastList.size() > 0) {
				for(BaseEmployeeMonthCheck ee : lastList) {
					int empId = BaseHelpUtils.getIntValue(ee.getEmployeeId());
					//获取加班补助
					BigDecimal overtimePaySub = BaseHelpUtils.getBigDecimalValue(ee.getOvertimePaySub());
					overtimePayMap.put(empId, overtimePaySub);
				}
			}
			for(BaseOnLoadEmployeeMonthCheck e : result.getCollections()){
				int empId = e.getEmployeeId();
				//先检索当前人员在当前年月份是否已经加锁了，如果已经加锁，则不需进行计算
				dao.clear();
				dao.setConditionYear("=",year);
				dao.setConditionMonth("=",month);
				dao.setConditionEmployeeId("=",empId);
				dao.setConditionIsLocked("=",Boolean.TRUE);
				if(dao.countRows() > 0){//说明已经加锁
					continue;
				}
				bean = new BaseEmployeeMonthCheck();
				bean.setDataFromJSON(e.toJSON());
				//获取加班补助
				BigDecimal overtimePaySub = BaseHelpUtils.getBigDecimalValue(e.getOvertimePaySub());
				//获取调休时长
				BigDecimal adjusthours = BaseHelpUtils.getBigDecimalValue(e.getAdjust());
				//获取节假日加班时长
				BigDecimal holidayOvertimeHours = BaseHelpUtils.getBigDecimalValue(e.getHolidayOvertimeHours());
				//获取周末加班时长
				BigDecimal weekendOvertimeHours = BaseHelpUtils.getBigDecimalValue(e.getWeekendOvertimeHours());
				//获取工作日加班时长
				BigDecimal nornalOvertimeHours = BaseHelpUtils.getBigDecimalValue(e.getNornalOvertimeHours());
				//设置总加班时长
				BigDecimal totalOvertimeHours = holidayOvertimeHours.add(weekendOvertimeHours).add(nornalOvertimeHours);
				//最终加班补助=初始计算的加班补助*（1-调休时间/总加班小时）
				if(totalOvertimeHours.compareTo(BigDecimal.ZERO) == 0) {
					overtimePaySub = BigDecimal.ZERO;
				}else {
					overtimePaySub = (BigDecimal.ONE.subtract(adjusthours.divide(totalOvertimeHours, 2, BigDecimal.ROUND_DOWN))).multiply(overtimePaySub);
				}
				//本月加班补助
				bean.setOvertimePaySub(overtimePaySub);
				//获取上一个月的加班补助
				BigDecimal overtimePaySubBefore = BaseHelpUtils.getBigDecimalValue(overtimePayMap.get(empId));
				bean.setOvertimePaySubBefore(overtimePaySubBefore);
				//获取判断是否是全勤
				boolean isFullTime = getIsFullTime(bean);
				bean.setIsFullTime(isFullTime);
				dao.clear();
				dao.setConditionEmployeeId("=",e.getEmployeeId());
				dao.setConditionYear("=",year);
				dao.setConditionMonth("=",month);
				if(dao.countRows() > 0){//说明数据已存在，则只需做更新即可
					dao.setDataFromBase(bean);
					dao.conditionalUpdate();
				}else{
					list.add(bean);
				}
			}
			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
				dao.clear();
				dao.save(list);
			}
		}
	}

	/**
	 * 判断是否是全勤
	 * @param bean
	 * @return
	 */
	public static boolean getIsFullTime(BaseEmployeeMonthCheck bean) {
		if(BaseHelpUtils.isNullOrEmpty(bean)) {
			return false;
		}
		//获取旷工天数
		BigDecimal absenceDays = BaseHelpUtils.getBigDecimalValue(bean.getAbsenceDays());
		if(absenceDays.compareTo(BigDecimal.ZERO) > 0) {
			return false;
		}
		//获取迟到分钟数
		BigDecimal lateForMinutes = BaseHelpUtils.getBigDecimalValue(bean.getLateForMinutes());
		if(lateForMinutes.compareTo(BigDecimal.ZERO) > 0) {
			return false;
		}
		//获取早退分钟数
		BigDecimal leaveForMinutes = BaseHelpUtils.getBigDecimalValue(bean.getLeaveForMinutes());
		if(leaveForMinutes.compareTo(BigDecimal.ZERO) > 0) {
			return false;
		}
		//获取事假天
		BigDecimal thingLeaveDays = BaseHelpUtils.getBigDecimalValue(bean.getThingLeaveDays());
		if(thingLeaveDays.compareTo(BigDecimal.ZERO) > 0) {
			return false;
		}
		//获取病假天
		BigDecimal illLeaveDays = BaseHelpUtils.getBigDecimalValue(bean.getIllLeaveDays());
		if(illLeaveDays.compareTo(BigDecimal.ZERO) > 0) {
			return false;
		}
		//获取其他假类
		BigDecimal leaveDays = BaseHelpUtils.getBigDecimalValue(bean.getOtherLeaveDays());
		if(leaveDays.compareTo(BigDecimal.ZERO) > 0) {
			return false;
		}
		return true;
	}

	/**
	 * 获取人事流程的请假、出差、外出,打卡
	 * @param personnelList
	 * @param processType
	 * @param employeeId
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public static BasePersonnelBusines checkPersonnel(List<BasePersonnelBusines> personnelList,int processType,int employeeId,Date date) throws SQLException{
		//结束时间一定得大于9:00
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY,9);
		ca.set(Calendar.SECOND,0);
		ca.set(Calendar.MINUTE,0);
		Date compareStartDate = ca.getTime();
		ca.set(Calendar.HOUR_OF_DAY,18);
		ca.set(Calendar.SECOND,0);
		ca.set(Calendar.MINUTE,0);
		Date compareEndDate = ca.getTime();
		SystemProcessInstance dao = new SystemProcessInstance();
		for(BasePersonnelBusines bean : personnelList){
			if (bean.getProcessType() == processType && bean.getEmployeeId()==employeeId  && bean.getDeleteFlag() == 0) {
				//获取结束时间
				Date endDate = bean.getEndDate();
				//获取开始时间
				Date startDate = bean.getStartDate();
				if(DateUtil.isSameDay(date, startDate) || DateUtil.isSameDay(endDate, date) || (DateUtil.compareDate(compareEndDate, startDate) && DateUtil.compareDate(endDate, compareStartDate))){
					//检索当前数据是否是被驳回了的，如果被驳回或取消，则不计入计算
					int businessId = bean.getPersonnelBusinessId();
					dao.clear();
					dao.setConditionBusinessId("=",businessId);
					dao.setConditionProcessType("=",processType);
//    				dao.setConditionProcessStatus("=",5);
					dao.addAnyCondition("process_status in (5,7)");
					if(dao.countRows() == 0){//说明没有被驳回的
						return bean;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 获取人事流程的请假、出差、外出,打卡
	 * @param personnelList
	 * @param processType
	 * @param employeeId
	 * @param date
	 * @return
	 * @throws SQLException
	 */
	public static List<BasePersonnelBusines> checkPersonnelList(List<BasePersonnelBusines> personnelList,int processType,int employeeId,Date date) throws SQLException{
		//结束时间一定得大于9:00
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.HOUR_OF_DAY,9);
		ca.set(Calendar.SECOND,0);
		ca.set(Calendar.MINUTE,0);
		Date compareStartDate = ca.getTime();
		ca.set(Calendar.HOUR_OF_DAY,18);
		ca.set(Calendar.SECOND,0);
		ca.set(Calendar.MINUTE,0);
		Date compareEndDate = ca.getTime();
		SystemProcessInstance dao = new SystemProcessInstance();
		List<BasePersonnelBusines> resultList = new ArrayList<>();
		for(BasePersonnelBusines bean : personnelList){
			if (bean.getProcessType() == processType && BaseHelpUtils.getIntValue(bean.getEmployeeId())==employeeId  && bean.getDeleteFlag() == 0) {
				//获取结束时间
				Date endDate = bean.getEndDate();
				//获取开始时间
				Date startDate = bean.getStartDate();
				if(DateUtil.isSameDay(date, startDate) || DateUtil.isSameDay(endDate, date) || (DateUtil.compareDate(compareEndDate, startDate) && DateUtil.compareDate(endDate, compareStartDate))){
					//检索当前数据是否是被驳回了的，如果被驳回，则不计入计算 //如被销假，也不计入计算
					int businessId = bean.getPersonnelBusinessId();
					dao.clear();
					dao.setConditionBusinessId("=",businessId);
					dao.setConditionProcessType("=",processType);
//    				dao.setConditionProcessStatus("=",5);
					dao.addAnyCondition("process_status in (5,7)");
					if(dao.countRows() == 0){//说明没有被驳回的
						resultList.add(bean);
					}
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
	public static BasePersonnelBusines fillcheckOfPersonnel(List<BasePersonnelBusines> personnelList,int processType,int employeeId,Date date,int type) throws SQLException{
		SystemProcessInstance dao = new SystemProcessInstance();
		for(BasePersonnelBusines bean : personnelList){
			if (bean.getProcessType() == processType && bean.getType() == type && bean.getEmployeeId() == employeeId && DateUtil.isSameDay(date,bean.getStartDate()) && bean.getDeleteFlag() == 0) {
				//检索当前数据是否是被驳回了的，如果被驳回，则不计入计算
				int businessId = bean.getPersonnelBusinessId();
				dao.clear();
				dao.setConditionBusinessId("=",businessId);
				dao.setConditionProcessType("=",processType);
				dao.setConditionProcessStatus("=",5);
				if(dao.countRows() == 0){//说明没有被驳回的
					return bean;
				}
			}
		}
		return null;
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
	 * 获取职员在当前计算日期排的班次时段
	 * @param
	 * @param date
	 * @return
	 */
	public static int getShiftTime(BaseOnLoadEmpShiftInfo bean,Date date){
		int shiftTimeManageId = 0;
		int dayOfWeek = DateUtil.getDayOfWeek(date);
		if(!BaseHelpUtils.isNullOrEmpty(bean)){
			if (DateUtil.isSameDay(date,bean.getRecordDate())) {
				switch (dayOfWeek) {
					case 1:
						if (bean.getMonday())
							shiftTimeManageId = bean.getShiftTimeManageId();
						break;
					case 2:
						if (bean.getTuesday())
							shiftTimeManageId = bean.getShiftTimeManageId();
						break;
					case 3:
						if (bean.getWednesday())
							shiftTimeManageId = bean.getShiftTimeManageId();
						break;
					case 4:
						if (bean.getThursday())
							shiftTimeManageId = bean.getShiftTimeManageId();
						break;
					case 5:
						if (bean.getFriday())
							shiftTimeManageId = bean.getShiftTimeManageId();
						break;
					case 6:
						if (bean.getSaturday())
							shiftTimeManageId = bean.getShiftTimeManageId();
						break;
					case 7:
						if (bean.getSunday())
							shiftTimeManageId = bean.getShiftTimeManageId();
						break;
				}
			}
		}
		return shiftTimeManageId;
	}

	/**
	 * 检索当前员工排班的数据集
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @param holidayList
	 * @return
	 * @throws SQLException
	 */
//    public static List<BaseEmployeeCheckinout> generateNormalCheckList(int employeeId,Date startDate,Date endDate, List<BaseHolidayManage> holidayList) throws SQLException {
//		List<BaseEmployeeCheckinout> checkinoutList = new ArrayList<>();
//		EmployeeCheckinout checkDao = new EmployeeCheckinout();
//		for (Date date = startDate; date.compareTo(endDate) <= 0; date = DateUtil.getNextDayOfDay(date, 1)) {
//			int dayOfWeek = DateUtil.getDayOfWeek(date);
//			int weekOfYear = DateUtil.getWeekOfYear(date);
//			//检索当前员工在当前日期是否是工作日,如果为空，说明该员工在当前日期是没有进行排班的
//			Boolean isWorkDay = isWorkDay(employeeId,date);
//			if (isWorkDay == null) {//说明未排班
//				if (dayOfWeek == 7) {
//					continue;
//				}
//				if (dayOfWeek == 6 && weekOfYear % 2 == 0) {//如果是大周，则是休息日，不进行计算
//					continue;
//				}
//			} else {//说明有排班
//				if (!isWorkDay)//说明是休息
//					continue;
//				if (dayOfWeek == 6 && weekOfYear % 2 == 0) {//如果是大周，则是休息日，不进行计算
//					continue;
//				}
//			}
//			if (isHoliday(date, holidayList)) {//检索这一天是否是节假日,如果是则不进行考勤计算
//				checkDao.clear();
//				checkDao.setConditionEmployeeId("=",employeeId);
//				checkDao.setConditionCheckDate("=",date);
//				checkDao.setStatus(ATTENDANCE_STATUS_16);//设置为节假日
//				checkDao.setComments("节假日");
//				checkDao.conditionalUpdate();
//				continue;
//			}
//			BaseEmployeeCheckinout bean = new BaseEmployeeCheckinout();
//			checkinoutList.add(bean);
//			bean.setBigWeek(weekOfYear % 2 == 1);
//			bean.setWeekOfYear(weekOfYear);
//			bean.setDayOfWeek(dayOfWeek);
//			bean.setLateTime(0);
//			bean.setIsWorkDay(true);
//			bean.setOverTime(BigDecimal.ZERO);
//			bean.setCheckDate(date);
//		}
//		return checkinoutList;
//	}

	/**
	 * 检索这一天是否是节假日
	 * @param date
	 * @param holidayList
	 * @return
	 */
	public static boolean isHoliday(Date date, List<BaseHolidayManage> holidayList) {
		for (BaseHolidayManage b : holidayList) {
			if (DateUtil.isSameDay(date, b.getRecordDate())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 检索当前员工在当前日期是否是工作日
	 * @param employeeId
	 * @param date
	 * @return
	 * @throws SQLException
	 */
//    public static Boolean isWorkDay(Integer employeeId, Date date) throws SQLException {
//		int dayOfWeek = DateUtil.getDayOfWeek(date);
//		List<BaseOnLoadEmpShiftInfo> empShiftInfoList = globalWorkDays.get(employeeId);
//		if (empShiftInfoList == null || empShiftInfoList.isEmpty())
//			return null;
//		EmployeeCheckinout checkDao = new EmployeeCheckinout();
//		for (BaseOnLoadEmpShiftInfo bean : empShiftInfoList) {
//			if (DateUtil.isSameDay(date,bean.getRecordDate())) {
//				//如果是休息和节假日班次,则不参与考勤计算，并更新为休息和节假日
//				//获取班次，如果为1：表示是休息；2：表示节假日
//				int shiftManageId = bean.getShiftManageId();
//				if(1 == shiftManageId){//说明是休息
//					checkDao.clear();
//					checkDao.setConditionEmployeeId("=",bean.getEmployeeId());
//					checkDao.setConditionCheckDate("=",bean.getRecordDate());
//					checkDao.setStatus(ATTENDANCE_STATUS_15);//设置为休息状态
//					checkDao.setComments("休息");
//					checkDao.conditionalUpdate();
//					return false;
//				}else if(2 == shiftManageId){//说明是节假日
//					checkDao.clear();
//					checkDao.setConditionEmployeeId("=",bean.getEmployeeId());
//					checkDao.setConditionCheckDate("=",bean.getRecordDate());
//					checkDao.setStatus(ATTENDANCE_STATUS_16);//设置为节假日状态
//					checkDao.setComments("节假日");
//					checkDao.conditionalUpdate();
//					return false;
//				}else{//说明是其它排班
//					switch (dayOfWeek) {
//					case 1:
//						if (bean.getMonday())
//							return true;
//						break;
//					case 2:
//						if (bean.getTuesday())
//							return true;
//						break;
//					case 3:
//						if (bean.getWednesday())
//							return true;
//						break;
//					case 4:
//						if (bean.getThursday())
//							return true;
//						break;
//					case 5:
//						if (bean.getFriday())
//							return true;
//						break;
//					case 6:
//						if (bean.getSaturday())
//							return true;
//						break;
//					case 7:
//						if (bean.getSunday())
//							return true;
//						break;
//					}
//				}
//					
//			}
//		}
//		return false;
//	}

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
	 * 检索员工在当前日期是否有保存这一天的打卡数据
	 * @param checkList
	 * @param employeeId
	 * @param checkDate
	 * @return
	 */
	public static BaseEmployeeCheckinout findCheckInfo(List<BaseEmployeeCheckinout> checkList, Integer employeeId, Date checkDate) {
		if(!BaseHelpUtils.isNullOrEmpty(checkList) && checkList.size() > 0){
			for (BaseEmployeeCheckinout b : checkList) {
				if (employeeId.equals(b.getEmployeeId()) && DateUtil.isSameDay(b.getCheckDate(), checkDate)) {
					return b;
				}
			}
		}
		return null;
	}

	/**
	 * 设置获取考勤打卡数据的路径
	 * @param year
	 * @param month
	 * @return
	 * @throws Exception
	 */
	public static String generateCheckDataFileName(int year, int month) throws Exception {
		StringBuilder sb = new StringBuilder();
		String rootPath = ThreadUtil.getRealPath();
		sb.append(rootPath);
		if (!rootPath.endsWith("/")) {
			sb.append("/");
		}
		sb.append("checkdata");
		File path = new File(sb.toString());
		if (!path.exists()) {
			path.mkdirs();
		}
		sb.append("/checkdata_");
		sb.append(year);
		sb.append("_");
		sb.append(month);
		sb.append(".mdb");
		return sb.toString();
	}

	/**
	 * 员工排班保存
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String onSaveEmployeeShiftThread(Map<String, Object> params) throws Exception{
		int operator = BaseHelpUtils.getIntValue(params, "operateEmployeeId");
		return ThreadTaskTemplate.runThreadTask(params, ThreadTaskUtils.TASK_TYPE_FOUR,
				operator, ThreadTaskUtils.OPERATION_TYPE_ONE);
	}

	public String onSaveEmployeeShiftOld(Map<String, Object> param) throws SQLException{
//    	ThreadConnection.beginTransaction();
		@SuppressWarnings({"unchecked" })
		List<BaseOnLoadEmployeeShiftDetailOfShift> shiftEmployees = GenericBase.__getList(param.get("shiftEmployees"),
				BaseOnLoadEmployeeShiftDetailOfShift.newInstance());
		if(!shiftEmployees.isEmpty() && shiftEmployees.size() > 0){
			//获取班次ID
			int shiftManageId = BaseHelpUtils.getIntValue(param, "shiftManageId");
			//获取操作人
			int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(BaseHelpUtils.getLongValue(param.get("startDate")));
			Date startDate = cal.getTime();
			cal.setTimeInMillis(BaseHelpUtils.getLongValue(param.get("endDate")));
			Date endDate = cal.getTime();

			if(startDate == null){//如果该职员的开始日期为空，则抛出异常
				throw new SQLException("开始日期为空,不可进行操作");
			}
			if(endDate == null){//如果该职员的结束日期为空，则抛出异常
				throw new SQLException("结束日期为空,不可进行操作");
			}
			if(startDate.after(endDate)){//如果开始日期晚于结束日期，则不可进行操作
				throw new SQLException("开始日期晚于结束日期,不可进行操作");
			}
			for(BaseOnLoadEmployeeShiftDetailOfShift e : shiftEmployees){
				//获取人员ID
				int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
				//获取职员姓名
				String employeeName = BaseHelpUtils.getString(e.getEmployeeName());
				commonEmployeeShiftSave(employeeName, employeeId, startDate, endDate, shiftManageId, operateEmployeeId);
			}
		}
//    	ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}

	/**
	 * 员工排班保存
	 * @param param
	 * @return
	 * @throws SQLException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized String onSaveEmployeeShift(Map<String, Object> param) throws SQLException, InterruptedException, ExecutionException{
		//获取班次ID
		int shiftManageId = BaseHelpUtils.getIntValue(param, "shiftManageId");
		//获取操作人
		int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(BaseHelpUtils.getLongValue(param.get("startDate")));
		Date startDate = cal.getTime();
		cal.setTimeInMillis(BaseHelpUtils.getLongValue(param.get("endDate")));
		Date endDate = cal.getTime();
		if(startDate == null){//如果该职员的开始日期为空，则抛出异常
			throw new SQLException("开始日期为空,不可进行操作");
		}
		if(endDate == null){//如果该职员的结束日期为空，则抛出异常
			throw new SQLException("结束日期为空,不可进行操作");
		}
		if(startDate.after(endDate)){//如果开始日期晚于结束日期，则不可进行操作
			throw new SQLException("开始日期晚于结束日期,不可进行操作");
		}
		List<BaseOnLoadEmployeeShiftDetailOfShift> shiftEmployees = GenericBase.__getList(param.get("shiftEmployees"),
				BaseOnLoadEmployeeShiftDetailOfShift.newInstance());
		if(!shiftEmployees.isEmpty() && shiftEmployees.size() > 0){
			//加载班次表数据
			TimeOfShiftManage tdao = new TimeOfShiftManage();
			tdao.setConditionShiftManageId("=",shiftManageId);
			BaseTimeOfShiftManage timeBean = tdao.executeQueryOneRow();
			if(BaseHelpUtils.isNullOrEmpty(timeBean)) {
				throw new SQLException("未加载到班次信息");
			}
			//用多线程来跑,50条为基数
			int step = 50;
			int size = shiftEmployees.size();
			int num = size/step;//取整
			int lNum = size%step;//取余数
			if(lNum > 0) {
				num++;
			}
			Long sTime = System.currentTimeMillis();
			//删除这些员工在这个排班时间段的数据
			EmployeeShiftManage esdao = new EmployeeShiftManage();
			Object[] ids = new Object[size];
			int i = 0;
			for(BaseOnLoadEmployeeShiftDetailOfShift ee : shiftEmployees) {
				int empId = BaseHelpUtils.getIntValue(ee.getEmployeeId());
				ids[i] = empId;
				i++;
			}
			esdao.addCondition(BaseOnLoadEmployeeShiftDetailOfShift.CS_EMPLOYEE_ID, "in", ids);
			esdao.addAnyAndCondition("record_date between ? and ?", startDate,endDate);
			esdao.conditionalDelete();
			__logger.info("截止删除数据耗时(分钟)-----------"+((System.currentTimeMillis()-sTime)/60000));
			//用map来存储每一天是工作日还是非工作日
			Map<Date,Boolean> workDayMap = new HashMap<>();
			for(Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextDayOfDay(s, 1)) {
				int dayOfWeek = DateUtil.getDayOfWeek(s);
				boolean isWorkDay = false;
				switch (dayOfWeek) {
					case 1:
						if (timeBean.getMonday())
							isWorkDay = true;
						break;
					case 2:
						if (timeBean.getTuesday())
							isWorkDay = true;
						break;
					case 3:
						if (timeBean.getWednesday())
							isWorkDay = true;
						break;
					case 4:
						if (timeBean.getThursday())
							isWorkDay = true;
						break;
					case 5:
						if (timeBean.getFriday())
							isWorkDay = true;
						break;
					case 6:
						if (timeBean.getSaturday())
							isWorkDay = true;
						break;
					case 7:
						if (timeBean.getSunday())
							isWorkDay = true;
						break;
				}
				workDayMap.put(s, isWorkDay);
			}
			__logger.info("截止计算是否是工作日耗时(分钟)-----------"+((System.currentTimeMillis()-sTime)/60000));
			List<FutureTask> tList = new ArrayList<>();
			for(int k = 0;k<num;k++) {
				int fromIndex = step*k;
				int toIndex = step*(k+1);
				if(toIndex > size) {
					toIndex = size;
				}
				List<BaseOnLoadEmployeeShiftDetailOfShift> list = shiftEmployees.subList(fromIndex, toIndex);
				if(BaseHelpUtils.isNullOrEmpty(list) || list.size() == 0) {
					break;
				}
				Callable c = new Callable<Integer>() {
					@Override
					public Integer call() throws Exception {
						BaseEmployeeShiftManage bean;
						List<BaseEmployeeShiftManage> beanList = new ArrayList<>();
						for(BaseOnLoadEmployeeShiftDetailOfShift e : list) {
							//获取人员ID
							int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
							//按日期遍历进行排班的更新和插入操作
							for (Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextDayOfDay(s, 1)) {
								//检索这个班次在这一天是否是工作日，如果返回false,则说明不是工作日，则这一天的班次设置为休息日
								boolean isWorkDay = workDayMap.get(s);
								//根据员工ID和日期去检索员工在这天是否已经排班，如果已经排班则更新，如果没有则插入
								int year = DateUtil.getYear(s);
								int month = DateUtil.getMonth(s);
								bean = new BaseEmployeeShiftManage();
								bean.setEmployeeId(employeeId);
								if(isWorkDay){
									bean.setShiftManageId(shiftManageId);
								}else{
									bean.setShiftManageId(SHIFT_1);//设置为休息日
								}
								bean.setYear(year);
								bean.setMonth(month);
								bean.setRecordDate(s);
								bean.setOperateEmployeeId(operateEmployeeId);
								bean.setOperateTime(new Date());
								beanList.add(bean);
							}
						}
						if(!BaseHelpUtils.isNullOrEmpty(beanList) && beanList.size() > 0) {
							EmployeeShiftManage dao = new EmployeeShiftManage();
							dao.save(beanList);
						}
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
			__logger.info("总耗时(分钟)-----------"+((System.currentTimeMillis()-sTime)/60000));
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}

	/**
	 * 员工排班公用方法
	 * @param employeeName
	 * @param employeeId
	 * @param startDate
	 * @param endDate
	 * @param shiftManageId
	 * @param operateEmployeeId
	 * @throws SQLException
	 */
	public void commonEmployeeShiftSave(String employeeName,int employeeId,Date startDate ,Date endDate,int shiftManageId,int operateEmployeeId) throws SQLException{
		EmployeeShiftManage dao = new EmployeeShiftManage();
		BaseEmployeeShiftManage bean;
		List<BaseEmployeeShiftManage> beanList = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		//按日期遍历进行排班的更新和插入操作
		for (Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextDayOfDay(s, 1)) {
			//检索这个班次在这一天是否是工作日，如果返回false,则说明不是工作日，则这一天的班次设置为休息日
			boolean isWorkDay = isOrNotWorkDay(shiftManageId, s);
			//根据员工ID和日期去检索员工在这天是否已经排班，如果已经排班则更新，如果没有则插入
			dao.clear();
			dao.setConditionEmployeeId("=",employeeId);
			dao.setConditionRecordDate("=",s);
			bean = dao.executeQueryOneRow();
			if(bean != null){//说明是已经排班，则做更新操作
				if(isWorkDay){
					bean.setShiftManageId(shiftManageId);
				}else{
					bean.setShiftManageId(SHIFT_1);//设置为休息日
				}
				dao.clear();
				dao.setPrimaryKeyFromBase(bean);
				dao.setDataFromBase(bean);
				dao.update();
			}else{//说明是没有排班，则做插入操作
				//获取年月份
				calendar.setTime(s);
				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH)+1;
				bean = new BaseEmployeeShiftManage();
				bean.setEmployeeId(employeeId);
				if(isWorkDay){
					bean.setShiftManageId(shiftManageId);
				}else{
					bean.setShiftManageId(SHIFT_1);//设置为休息日
				}
				bean.setYear(year);
				bean.setMonth(month);
				bean.setRecordDate(s);
				bean.setOperateEmployeeId(operateEmployeeId);
				bean.setOperateTime(new Date());
				dao.clear();
				dao.setDataFromBase(bean);
				dao.save();
//				beanList.add(bean);
			}
		}
//		if(!beanList.isEmpty() && beanList.size() > 0){
//			dao.clear();
//			dao.save(beanList);
//		}
	}

	/**
	 * 节日保存
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public String onSaveBatchHolidayInfo(Map<String, Object> param) throws SQLException{
		ThreadConnection.beginTransaction();
		//获取节日名称
		String name = BaseHelpUtils.getStringValue(param, "name");
		//获取操作人
		int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
		//获取说明
		String description = BaseHelpUtils.getStringValue(param, "description");
		//获取开始日期
		String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
		Date startDate = startDateStr==null?new Date():new Date(Long.valueOf(startDateStr));
		//获取结束日期
		String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
		Date endDate = endDateStr==null?new Date():new Date(Long.valueOf(endDateStr));
		//判断，如果开始日期大于结束日期，则抛出异常
		if(startDate.after(endDate)){
			throw new SQLException("开始日期不可大于结束日期");
		}
		HolidayManage dao = new HolidayManage();
		BaseHolidayManage bean;
		List<BaseHolidayManage> beanList = new ArrayList<>();
		//日期遍历
		Calendar calendar = Calendar.getInstance();
		for (Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextDayOfDay(s, 1)) {
			//获取年月份
			calendar.setTime(s);
			int year = calendar.get(Calendar.YEAR);
			int month = calendar.get(Calendar.MONTH);
			int date = calendar.get(Calendar.DATE);
			//根据当前日期去检索，如果当天已经存在，则不进行插入操作
			calendar.set(year, month, date, 0, 0, 0);
			s = calendar.getTime();
			dao.clear();
			dao.setConditionRecordDate("=",s);
			if(dao.countRows() > 0){//说明存在，则跳出本次循环
				continue;
			}
			calendar.set(year, month, date, 9, 0, 0);
			Date startTime = calendar.getTime();
			calendar.set(year, month, date, 18, 0, 0);
			Date endTime = calendar.getTime();
			bean = new BaseHolidayManage();
			bean.setName(name);
			bean.setYear(year);
			bean.setMonth(month+1);
			bean.setRecordDate(s);
			bean.setStartTime(startTime);
			bean.setEndTime(endTime);
			bean.setOperateEmployeeId(operateEmployeeId);
			bean.setOperateTime(new Date());
			bean.setDescription(description);
			beanList.add(bean);
		}
		if(!beanList.isEmpty() && beanList.size() > 0){
			dao.clear();
			dao.save(beanList);
		}
		ThreadConnection.commit();
		BaseCollection<GenericBase> s = new BaseCollection<>();
		return s.toJSON(0,null);
	}

	public String deleteShiftTimeManage(Map<String, Object> param, String creteria) throws Exception{
		BaseCollection bc = new BaseCollection();
		int shiftTimeManageId = BaseHelpUtils.getIntValue(param.get("shiftTimeManageId"));
		if(shiftTimeManageId > 0){
			TimeOfShiftManage tsmDao = new TimeOfShiftManage();
			tsmDao.setConditionShiftTimeManageId("=", shiftTimeManageId);
			if(tsmDao.countRows() > 0){
				return bc.toJSON(-1, "删除失败，原因：有班次在使用这个时段");
			}else{
				BaseShiftTimeManage bean = new BaseShiftTimeManage();
				bean.setDataFromJSON(creteria);
				ShiftTimeManage dao = new ShiftTimeManage();
				ShiftTimeManageHandler.setDeleteConditions(bean, dao);
				int num = dao.conditionalDelete();
				return bc.toJSON(num, null);
			}
		}
		return bc.toJSON(-1, "删除失败");
	}


	public String onUpdateShiftManage(Map<String, Object> param) throws SQLException {
		ThreadConnection.beginTransaction();
		int shiftManageId = BaseHelpUtils.getIntValue(param.get("shiftManageId"));
		ShiftManage recordDao = new ShiftManage();
		if(null != param){
			recordDao.setConditionShiftManageId("=", shiftManageId);
			BaseShiftManage record = recordDao.executeQueryOneRow();
			Date startDate = new Date(BaseHelpUtils.getLongValue(param.get("startDate")));
			Date endDate = new Date(BaseHelpUtils.getLongValue(param.get("endDate")));
			if (null != record) {
				record.setShiftName(BaseHelpUtils.getString(param.get("shiftName")));
				record.setStartDate(startDate);
				record.setEndDate(endDate);
				record.setOperateEmployeeId(BaseHelpUtils.getIntValue(param.get("operateEmployeeId")));
				record.setRemark(BaseHelpUtils.getString(param.get("remark")));
				record.setOperateTime(new Date());
				recordDao.setDataFromBase(record);
				recordDao.update();
			} else {
				recordDao.clear();
				recordDao.setShiftName(BaseHelpUtils.getString(param.get("shiftName")));
				recordDao.setStartDate(startDate);
				recordDao.setEndDate(endDate);
				recordDao.setOperateEmployeeId(BaseHelpUtils.getIntValue(param.get("operateEmployeeId")));
				recordDao.setRemark(BaseHelpUtils.getString(param.get("remark")));
				recordDao.setOperateTime(new Date());
				recordDao.save();
				//获取主表的主键id
				int shiftManageIdValue = recordDao.getShiftManageId();
				//获取gird的数据集timeOfShiftManages
				@SuppressWarnings("unchecked")
				List<BaseTimeOfShiftManage> result = GenericBase.__getList(param.get("timeOfShiftManages"),
						BaseTimeOfShiftManage.newInstance());
				if(!result.isEmpty() && result.size() > 0){
					//保存gird的数据集
					TimeOfShiftManage shiftDao = new TimeOfShiftManage();
					List<BaseTimeOfShiftManage> beanList = new ArrayList<>();
					for(BaseTimeOfShiftManage e : result){
						e.setShiftManageId(shiftManageIdValue);
						beanList.add(e);
					}
					if(!beanList.isEmpty() && beanList.size() > 0){
						shiftDao.save(beanList);
					}
				}
			}
			ThreadConnection.commit();
		}
		return null;
	}

	/**
	 * 检索当前班次当这一天是否是工作日
	 * @param shiftManageId
	 * @param recordDate
	 * @return
	 * @throws SQLException
	 */
	public static Boolean isOrNotWorkDay(int shiftManageId,Date recordDate) throws SQLException {
		TimeOfShiftManage dao = new TimeOfShiftManage();
		dao.setConditionShiftManageId("=",shiftManageId);
		List<BaseTimeOfShiftManage> list = dao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
			for(BaseTimeOfShiftManage bean : list) {
				int dayOfWeek = DateUtil.getDayOfWeek(recordDate);
				switch (dayOfWeek) {
					case 1:
						if (bean.getMonday())
							return true;
						break;
					case 2:
						if (bean.getTuesday())
							return true;
						break;
					case 3:
						if (bean.getWednesday())
							return true;
						break;
					case 4:
						if (bean.getThursday())
							return true;
						break;
					case 5:
						if (bean.getFriday())
							return true;
						break;
					case 6:
						if (bean.getSaturday())
							return true;
						break;
					case 7:
						if (bean.getSunday())
							return true;
						break;
				}
			}
		}
		return false;
	}

	public static BigDecimal betweenHoursBetween(Date t1, Date t2) {
		long time = t1.getTime() - t2.getTime();
		BigDecimal minus = new BigDecimal(time / 60000L);
		BigDecimal hours = minus.divide(new BigDecimal("60"), 2, BigDecimal.ROUND_DOWN);
		return hours;
	}

	/**
	 * 人事流程考勤处理公用方法
	 * @param personnelList
	 * @param empDayCheckBean
	 * @param processType
	 * @param employeeId
	 * @param recordDate
	 * @param restStartTime
	 * @param restEndTime
	 * @param remark
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public static int checkPersonnelBusiness(List<BasePersonnelBusines> personnelList,BaseEmployeeDayCheck empDayCheckBean,int processType,int employeeId,Date recordDate,Date restStartTime,Date restEndTime,String remark) throws SQLException {
		int checkFlat = 0;
		BasePersonnelBusines bean = checkPersonnel(personnelList,processType, employeeId, recordDate);
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

	public void tes(Integer type,Date currentDate,BasePersonnelBusines bean) throws ParseException {
		type = 2;
		currentDate = DateUtil.getLastDay(currentDate);
		bean.setPersonnelBusinessId(111);
	}

	/**
	 * 排班测试
	 * @throws SQLException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void testSendShift() throws SQLException, InterruptedException, ExecutionException {
		Calendar ca = Calendar.getInstance();
		ca.set(2022, 0, 1);
		Date startDate = ca.getTime();
		ca.set(2022, 11, 31);
		Date endDate = ca.getTime();
		int shiftManageId = 4;
		Employee eDao = new Employee();
		eDao.unsetSelectFlags();
		eDao.setSelectEmployeeId(true);
		eDao.setConditionStatus("=", 0);
		List<BaseEmployee> eList = eDao.conditionalLoad("order by employee_id");
		__logger.info("eList-------"+eList.size());
		List<BaseOnLoadEmployeeShiftDetailOfShift> shiftEmployees = new ArrayList<>();
		BaseOnLoadEmployeeShiftDetailOfShift b = null;
		for(BaseEmployee eBean : eList) {
			b = new BaseOnLoadEmployeeShiftDetailOfShift();
			b.setEmployeeId(eBean.getEmployeeId());
			shiftEmployees.add(b);
		}
		if(!shiftEmployees.isEmpty() && shiftEmployees.size() > 0){
			//加载班次表数据
			TimeOfShiftManage tdao = new TimeOfShiftManage();
			tdao.setConditionShiftManageId("=",shiftManageId);
			BaseTimeOfShiftManage timeBean = tdao.executeQueryOneRow();
			if(BaseHelpUtils.isNullOrEmpty(timeBean)) {
				throw new SQLException("未加载到班次信息");
			}
			//用多线程来跑,50条为基数
			int step = 50;
			int size = shiftEmployees.size();
			int num = size/step;//取整
			int lNum = size%step;//取余数
			if(lNum > 0) {
				num++;
			}
			Long sTime = System.currentTimeMillis();
			//删除这些员工在这个排班时间段的数据
			EmployeeShiftManage esdao = new EmployeeShiftManage();
			Object[] ids = new Object[size];
			int i = 0;
			for(BaseOnLoadEmployeeShiftDetailOfShift ee : shiftEmployees) {
				int empId = BaseHelpUtils.getIntValue(ee.getEmployeeId());
				ids[i] = empId;
				i++;
			}
			esdao.addCondition(BaseOnLoadEmployeeShiftDetailOfShift.CS_EMPLOYEE_ID, "in", ids);
			esdao.addAnyAndCondition("record_date between ? and ?", startDate,endDate);
			esdao.conditionalDelete();
			__logger.info("截止删除数据耗时(分钟)-----------"+((System.currentTimeMillis()-sTime)/60000));
			//用map来存储每一天是工作日还是非工作日
			Map<Date,Boolean> workDayMap = new HashMap<>();
			for(Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextDayOfDay(s, 1)) {
				int dayOfWeek = DateUtil.getDayOfWeek(s);
				boolean isWorkDay = false;
				switch (dayOfWeek) {
					case 1:
						if (timeBean.getMonday())
							isWorkDay = true;
						break;
					case 2:
						if (timeBean.getTuesday())
							isWorkDay = true;
						break;
					case 3:
						if (timeBean.getWednesday())
							isWorkDay = true;
						break;
					case 4:
						if (timeBean.getThursday())
							isWorkDay = true;
						break;
					case 5:
						if (timeBean.getFriday())
							isWorkDay = true;
						break;
					case 6:
						if (timeBean.getSaturday())
							isWorkDay = true;
						break;
					case 7:
						if (timeBean.getSunday())
							isWorkDay = true;
						break;
				}
				workDayMap.put(s, isWorkDay);
			}
			__logger.info("截止计算是否是工作日耗时(分钟)-----------"+((System.currentTimeMillis()-sTime)/60000));
			List<FutureTask> tList = new ArrayList<>();
			for(int k = 0;k<num;k++) {
				int fromIndex = step*k;
				int toIndex = step*(k+1);
				if(toIndex > size) {
					toIndex = size;
				}
				List<BaseOnLoadEmployeeShiftDetailOfShift> list = shiftEmployees.subList(fromIndex, toIndex);
				__logger.info("list-----size==="+list.size());
				if(BaseHelpUtils.isNullOrEmpty(list) || list.size() == 0) {
					break;
				}
				Callable c = new Callable<Integer>() {
					@Override
					public Integer call() throws Exception {
						BaseEmployeeShiftManage bean;
						List<BaseEmployeeShiftManage> beanList = new ArrayList<>();
						for(BaseOnLoadEmployeeShiftDetailOfShift e : list) {
							//获取人员ID
							int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
							//按日期遍历进行排班的更新和插入操作
							for (Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextDayOfDay(s, 1)) {
								//检索这个班次在这一天是否是工作日，如果返回false,则说明不是工作日，则这一天的班次设置为休息日
								boolean isWorkDay = workDayMap.get(s);
								//根据员工ID和日期去检索员工在这天是否已经排班，如果已经排班则更新，如果没有则插入
								int year = DateUtil.getYear(s);
								int month = DateUtil.getMonth(s);
								bean = new BaseEmployeeShiftManage();
								bean.setEmployeeId(employeeId);
								if(isWorkDay){
									bean.setShiftManageId(shiftManageId);
								}else{
									bean.setShiftManageId(SHIFT_1);//设置为休息日
								}
								bean.setYear(year);
								bean.setMonth(month);
								bean.setRecordDate(s);
								bean.setOperateEmployeeId(0);
								bean.setOperateTime(new Date());
								beanList.add(bean);
							}
						}
						if(!BaseHelpUtils.isNullOrEmpty(beanList) && beanList.size() > 0) {
							EmployeeShiftManage dao = new EmployeeShiftManage();
							dao.save(beanList);
						}
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
			__logger.info("总耗时(分钟)-----------"+((System.currentTimeMillis()-sTime)/60000));
		}
	}


	public static void main(String[] args) throws Exception {
		//获取当前系统日期，如果结束日期大于当前系统日期，则设置结束日期为当前系统日期
//		Date currentDate = new Date();
//		int year = DateUtil.getYear(currentDate);
//		int month = DateUtil.getMonth(currentDate);
//    	ThreadConnection.beginTransaction();
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.setTime(currentDate);
//    	calendar.add(Calendar.DATE,-7);
//    	currentDate = calendar.getTime();
//    	System.out.println(currentDate);
//    	processCheckData(currentDate);
		//计算月考勤数据
//    	employeeCheckMonthAccount(year, month);
//    	ThreadConnection.commit();
//		OnShiftManageProcess os = new OnShiftManageProcess();
////		os.onEmployeeDayCheck();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date startDate = sdf.parse("2018-01-01");
//		Date endDate = sdf.parse("2018-03-31");
//		
//		Map<String, Object> param = new HashMap<>();
//		List<Map<String, Object>> list = new ArrayList<>();
//		Map<String, Object> shiftEmployeesMap = new HashMap<>();
//		shiftEmployeesMap.put("startDate", startDate.getTime());
//		shiftEmployeesMap.put("endDate", endDate.getTime());
//		shiftEmployeesMap.put("employeeId", "1734");
//		shiftEmployeesMap.put("departmentId", "66");
//		list.add(shiftEmployeesMap);
//		param.put("shiftEmployees", list);
//		param.put("shiftManageId", 4);
//		param.put("operateEmployeeId", 0);
////		os.onEmployeeMonthCheck(param);
//		ThreadTaskTemplate.runThreadTask(param, ThreadTaskUtils.TASK_TYPE_FOUR, 
//				0, ThreadTaskUtils.OPERATION_TYPE_ONE);
//		
		OnShiftManageProcess os = new OnShiftManageProcess();
//		os.onEmployeeDayCheck();
		Map<String, Object> param = new HashMap<>();
		param.put("year","2022");
		param.put("month","2");
//		param.put("employeeId",3394);
		os.onEmployeeMonthCheck(param);
//		testSendShift();

	}


	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
}
