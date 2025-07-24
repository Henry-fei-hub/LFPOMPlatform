package pomplatform.project.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseBonusPaymentDetail;
import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord;
import com.pomplatform.db.bean.BaseManageProjectEmployeeRecord;
import com.pomplatform.db.bean.BasePlateSalaryAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.dao.BonusPaymentDetail;
import com.pomplatform.db.dao.EmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryReturnRecord;
import com.pomplatform.db.dao.ManageProjectEmployeeRecord;
import com.pomplatform.db.dao.PlateSalaryAdvanceRecord;
import com.pomplatform.db.dao.ProjectEmployeeAdvanceRecord;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.SystemConfig;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.common.MapUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeReportRecordDetail;
import pomplatform.getEmployeeIdByRoleId.bean.BaseGetPlateEmployeeIdByTime;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditionGetPlateEmployeeIdByTime;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.query.QueryGetPlateEmployeeIdByTime;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleId;

public class PlateEmployeeAchieveIntegralReturn implements GenericProcessor {

	public static void main(String[] args) {
		Map map = new HashMap();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2016);
		calendar.set(Calendar.MONTH,0);
		map.put("startDate", calendar.getTime().getTime());
		calendar.set(Calendar.MONTH, 11);
		map.put("endDate", calendar.getTime().getTime());
		map.put("plateId", 7);
		PlateEmployeeAchieveIntegralReturn aaa = new PlateEmployeeAchieveIntegralReturn();
		try {
			aaa.execute(MapUtils.toJSON(map), null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection bc = new BaseCollection();
		try {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
			// 获取开始年月份
			String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
			Date startDate = new Date(Long.valueOf(startDateStr));
			// 获取结束年月份
			String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
			Date endDate = new Date(Long.valueOf(endDateStr));
			endDate = DateUtil.getLastDay(endDate);
			// 获取加锁的业务部门id
			int plateId = BaseHelpUtils.getIntValue(param, "plateId");
			// 将开始日期重置为当前月份的第一天的日期
			startDate = DateUtil.getFirstDay(startDate);

			// 判断结束月份是否大于开始月份，否则抛出异常
			if (startDate.after(endDate)) {
				throw new SQLException("计算的开始年月份不可大于结束年月份,请重置");
			}
			ThreadConnection.beginTransaction();
			// 找出该事业部的积分高管的employeeId
			ConditiongetEmployeeIdByRoleId condition = new ConditiongetEmployeeIdByRoleId();
			condition.setPlateId(plateId);
			QuerygetEmployeeIdByRoleId query = new QuerygetEmployeeIdByRoleId();
			BaseCollection<BasegetEmployeeIdByRoleId> plateManagerBC = null;
			List<BasegetEmployeeIdByRoleId> list = null;
			int months = DateUtil.getCompareMonths(startDate, endDate) + 1;
			Date calculateDate = startDate;
			SystemConfig configDao = new SystemConfig();
			configDao.setConditionSystemConfigId("=", StaticUtils.SYSTEM_KEY);
			DES des = new DES(configDao.executeQueryOneRow().getImagePath());
			for(int i = 0; i<months; i++){
//				PlateReportRecord plateRecordDao = new PlateReportRecord();
//				plateRecordDao.setConditionPlateId("=", plateId);
//				plateRecordDao.setConditionRecordDate("=", DateUtil.getFirstDay(calculateDate));
//				BasePlateReportRecord plateReportRecord = plateRecordDao.executeQueryOneRow();
//				if(null == plateReportRecord || (null != plateReportRecord && !plateReportRecord.getIsLock())){
					condition.setChangePlateDate(DateUtil.getFirstDay(calculateDate));
					Map<Integer,BaseEmployeeReportRecordDetail> tempMap = new HashMap<>();
					//积分高管
					condition.setRoleId(StaticUtils.ROLE_INTEGRAL_EXECUTIVE);
					plateManagerBC = query.executeQuery(null, condition);
					if(null != plateManagerBC){
						list = plateManagerBC.getCollections();
						if(null != list && !list.isEmpty()){
							for(BasegetEmployeeIdByRoleId obj : list){
								initEmployeeReportRecordDetailInfo(obj.getEmployeeId(), obj.getEmployeeName(), obj.getEmployeeNo(), tempMap,1);
							}
						}
					}
					//年薪员工
					condition.setRoleId(StaticUtils.ROLE_ANNUAL_SALARY_EMPLOYEE);
					plateManagerBC = query.executeQuery(null, condition);
					if(null != plateManagerBC){
						list = plateManagerBC.getCollections();
						if(null != list && !list.isEmpty()){
							for(BasegetEmployeeIdByRoleId obj : list){
								initEmployeeReportRecordDetailInfo(obj.getEmployeeId(), obj.getEmployeeName(), obj.getEmployeeNo(), tempMap,2);
							}
						}
					}
					ConditionGetPlateEmployeeIdByTime employeeIdRecordCondition = new ConditionGetPlateEmployeeIdByTime();
					employeeIdRecordCondition.setPlateId(plateId);
					employeeIdRecordCondition.setStartDate(DateUtil.getFirstDay(calculateDate));
					employeeIdRecordCondition.setEndDate(DateUtil.getLastDay(calculateDate));
					QueryGetPlateEmployeeIdByTime employeeIdRecordQuery = new QueryGetPlateEmployeeIdByTime();
					BaseCollection<BaseGetPlateEmployeeIdByTime> employeeIdRecordBC = employeeIdRecordQuery.executeQuery(null,
							employeeIdRecordCondition);
					List<BaseGetPlateEmployeeIdByTime> employeeIdRecordList = employeeIdRecordBC.getCollections();
					if(null!=employeeIdRecordList && !employeeIdRecordList.isEmpty()){
						//本月该事业部所有非在职人员，则进行后续操作，将这些人员的积分回收
						for(BaseGetPlateEmployeeIdByTime obj : employeeIdRecordList){
							initEmployeeReportRecordDetailInfo(obj.getEmployeeId(), obj.getEmployeeName(), obj.getEmployeeNo(), tempMap,0);
						}
					}
					if(!tempMap.isEmpty()){
						Object[] employeeIdArr = tempMap.keySet().toArray();
						StringBuilder sqlBuilder = new StringBuilder();
						sqlBuilder.append("Paramter").append(" >= '").append(DateUtil.getFirstDay(calculateDate)).append("' and ")
								.append("Paramter").append(" <= '").append(DateUtil.getLastDay(calculateDate)).append("'");
						String sql = sqlBuilder.toString();
						//获取本月该事业部所有非在职人员的未回收的确认积分和项目成本
						getSureIntegralAndProejctCost(employeeIdArr, calculateDate, tempMap, sql);
						//获取本月该事业部所有非在职人员的未回收的奖金补贴
						getManageProjectIntegral(employeeIdArr, calculateDate, tempMap, sql);
						//获取本月该事业部所有非在职人员的未回收的项目补贴
						getProjectAdvanceIntegral(employeeIdArr, calculateDate, tempMap, sql);
						//获取本月该事业部所有非在职人员的未回收的人工成本
						getSalary(employeeIdArr, calculateDate, tempMap, des);
						//获取本月该事业部所有非在职人员的未回收的奖金发放积分
						getBonusIntegral(employeeIdArr, calculateDate, tempMap, sql);
						//获取截止到本月为止，该事业部所有非在职人员的未回收的积分借款
						getPlateSalaryAdvanceIntegral(employeeIdArr, calculateDate, tempMap);
						//获取截止到本月为止，该事业部所有非在职人员的未回收的积分还款
						getEmployeeSalaryReturnIntegral(employeeIdArr, calculateDate, tempMap);
						//获得本月本次计算该员工在该事业部可以回收的价值积分总额，并将其保存或者更新到员工价值积分回收表中
						saveOrUpdateEmployeeAchieveIntegralReturnRecord(plateId, employeeIdArr, calculateDate, tempMap, sql);
					}
					calculateDate = DateUtil.getNextMonth(calculateDate);
				}
//			}
			ThreadConnection.commit();
			return bc.toJSON(0, null);
		} catch (Exception e) {
			e.printStackTrace();
			return bc.toJSON(-1, null);
		}
	}

	/**
	 * 	获取本月该事业部所有非在职人员的未回收的确认积分和项目成本
	 * @param employeeIdArr		本月非在职员工的ID数组
	 * @param calculateDate		计算的年月
	 * @param tempMap			key:员工ID   value:与员工积分回收相关项信息
	 * @param sql				相关的查询条件限制
	 * @throws Exception
	 */
	public void getSureIntegralAndProejctCost(Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap,String sql) throws Exception{
		ProjectSettlementDetail dao = new ProjectSettlementDetail();
		dao.setConditionIsReturn("=", false);
		dao.addCondition(BaseProjectSettlementDetail.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BaseProjectSettlementDetail> list = dao.conditionalLoad(sql.replaceAll("Paramter", BaseProjectSettlementDetail.CS_SETTLEMENT_DATE));
		if(null!=list && !list.isEmpty()){
			int size = list.size();
			//需要修改isReturn状态的记录的ID数组
			Object[] changeIsReturnStatusArr = new Object[size];
			for(int j = 0; j<size; j++){
				BaseProjectSettlementDetail obj = list.get(j);
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				if(null!=obj.getRealAmount()){
					bean.setSureIntegral(bean.getSureIntegral().add(obj.getRealAmount()));
				}
				if(null!=obj.getProjectCost()){
					bean.setProjectCost(bean.getProjectCost().add(obj.getProjectCost()));
				}
				changeIsReturnStatusArr[j] = obj.getSettlementDetailId();
			}
			dao.clear();
			dao.addCondition(BaseProjectSettlementDetail.CS_SETTLEMENT_DETAIL_ID, "in", changeIsReturnStatusArr);
			dao.setIsReturn(true);
			dao.conditionalUpdate();
		}
	}
	
	/**
	 * 	获取本月该事业部所有非在职人员的未回收的奖金补贴积分
	 * @param employeeIdArr		本月非在职员工的ID数组
	 * @param calculateDate		计算的年月
	 * @param tempMap			key:员工ID   value:与员工积分回收相关项信息
	 * @param sql				相关的查询条件限制
	 * @throws Exception
	 */
	public void getManageProjectIntegral(Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap,String sql) throws Exception{
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setConditionIsReturn("=", false);
		dao.addCondition(BaseManageProjectEmployeeRecord.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BaseManageProjectEmployeeRecord> list = dao.conditionalLoad(sql.replaceAll("Paramter", BaseManageProjectEmployeeRecord.CS_ASSIGN_DATE));
		if(null!=list && !list.isEmpty()){
			int size = list.size();
			//需要修改isReturn状态的记录的ID数组
			Object[] changeIsReturnStatusArr = new Object[size];
			for(int j = 0; j<size; j++){
				BaseManageProjectEmployeeRecord obj = list.get(j);
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				if(null!=obj.getAssignedIntegral()){
					bean.setManagerProjectIntegral(bean.getManagerProjectIntegral().add(obj.getAssignedIntegral()));
				}
				changeIsReturnStatusArr[j] = obj.getManageProjectEmployeeRecordId();
			}
			dao.clear();
			dao.addCondition(BaseManageProjectEmployeeRecord.CS_MANAGE_PROJECT_EMPLOYEE_RECORD_ID, "in", changeIsReturnStatusArr);
			dao.setIsReturn(true);
			dao.conditionalUpdate();
		}
	}
	
	/**
	 * 	获取本月该事业部所有非在职人员的未回收的项目补贴积分
	 * @param employeeIdArr		本月非在职员工的ID数组
	 * @param calculateDate		计算的年月
	 * @param tempMap			key:员工ID   value:与员工积分回收相关项信息
	 * @param sql				相关的查询条件限制
	 * @throws Exception
	 */
	public void getProjectAdvanceIntegral(Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap,String sql) throws Exception{
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setConditionIsReturn("=", false);
		dao.addCondition(BaseProjectEmployeeAdvanceRecord.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BaseProjectEmployeeAdvanceRecord> list = dao.conditionalLoad(sql.toString().replaceAll("Paramter", BaseProjectEmployeeAdvanceRecord.CS_ADVANCE_DATE));
		if(null!=list && !list.isEmpty()){
			int size = list.size();
			//需要修改isReturn状态的记录的ID数组
			Object[] changeIsReturnStatusArr = new Object[size];
			for(int j = 0; j<size; j++){
				BaseProjectEmployeeAdvanceRecord obj = list.get(j);
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				if(null!=obj.getAdvancedIntegral()){
					bean.setProjectAdvance(bean.getProjectAdvance().add(obj.getAdvancedIntegral()));
				}
				changeIsReturnStatusArr[j] = obj.getProjectEmployeeAdvanceRecordId();
			}
			dao.clear();
			dao.addCondition(BaseProjectEmployeeAdvanceRecord.CS_PROJECT_EMPLOYEE_ADVANCE_RECORD_ID, "in", changeIsReturnStatusArr);
			dao.setIsReturn(true);
			dao.conditionalUpdate();
		}
	}
	
	/**
	 * 	获取本月该事业部所有非在职人员的未回收的人工成本
	 * @param employeeIdArr		本月非在职员工的ID数组
	 * @param calculateDate		计算的年月
	 * @param tempMap			key:员工ID   value:与员工积分回收相关项信息
	 * @param des				解密工资
	 * @throws Exception
	 */
	public void getSalary(Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap,DES des) throws Exception{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calculateDate);
		EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
		dao.setConditionIsReturn("=", false);
		dao.setConditionSalaryYear("=", calendar.get(Calendar.YEAR));
		dao.setConditionSalaryMonth("=", calendar.get(Calendar.MONTH)+1);
		dao.addCondition(BaseEmployeeSalaryDetail.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BaseEmployeeSalaryDetail> list = dao.conditionalLoad();
		dao.setIsReturn(true);
		dao.conditionalUpdate();
		if(null!=list && !list.isEmpty()){
			for(BaseEmployeeSalaryDetail obj : list){
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				BigDecimal salary = BigDecimal.ZERO;
				if(null!=obj.getBasicSalary()){
					salary = new BigDecimal(des.DEC(obj.getBasicSalary()));
				}
				bean.setSalary(bean.getSalary().add(salary));
			}
		}
	}
	
	/**
	 * 	获取本月该事业部所有非在职人员的未回收的奖金发放积分
	 * @param employeeIdArr		本月非在职员工的ID数组
	 * @param calculateDate		计算的年月
	 * @param tempMap			key:员工ID   value:与员工积分回收相关项信息
	 * @param sql				相关的查询条件限制
	 * @throws Exception
	 */
	public void getBonusIntegral(Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap,String sql) throws Exception{
		BonusPaymentDetail dao = new BonusPaymentDetail();
		dao.setConditionIsReturn("=", false);
		dao.addCondition(BaseBonusPaymentDetail.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BaseBonusPaymentDetail> list = dao.conditionalLoad(sql.toString().replaceAll("Paramter", BaseBonusPaymentDetail.CS_PAY_DATE));
		if(null!=list && !list.isEmpty()){
			int size = list.size();
			//需要修改isReturn状态的记录的ID数组
			Object[] changeIsReturnStatusArr = new Object[size];
			for(int j = 0; j<size; j++){
				BaseBonusPaymentDetail obj = list.get(j);
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				if(null!=obj.getPayIntegral()){
					bean.setBonusPayment(bean.getBonusPayment().add(obj.getPayIntegral()));
				}
				changeIsReturnStatusArr[j] = obj.getBonusPaymentDetailId();
			}
			dao.clear();
			dao.addCondition(BaseBonusPaymentDetail.CS_BONUS_PAYMENT_DETAIL_ID, "in", changeIsReturnStatusArr);
			dao.setIsReturn(true);
			dao.conditionalUpdate();
		}
	}
	
	/**
	 * 	获取截止到本月为止，该事业部所有非在职人员的未回收的积分借款
	 * @param employeeIdArr		本月非在职员工的ID数组
	 * @param calculateDate		计算的年月
	 * @param tempMap			key:员工ID   value:与员工积分回收相关项信息
	 * @throws Exception
	 */
	public void getPlateSalaryAdvanceIntegral(Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap) throws Exception{
		PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
		dao.setConditionIsReturn("=", false);
		dao.setConditionRecordDate("<=", DateUtil.getLastDay(calculateDate));
		dao.addCondition(BasePlateSalaryAdvanceRecord.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BasePlateSalaryAdvanceRecord> list = dao.conditionalLoad();
		dao.setIsReturn(true);
		dao.conditionalUpdate();
		if(null!=list && !list.isEmpty()){
			for(BasePlateSalaryAdvanceRecord obj : list){
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				if(null!=obj.getSalaryReturn()){
					bean.setSalaryAdvance(bean.getSalaryAdvance().add(obj.getSalaryReturn()));
				}
			}
		}
	}
	
	/**
	 * 	获取截止到本月为止，该事业部所有非在职人员的未回收的积分还款
	 * @param employeeIdArr		本月非在职员工的ID数组
	 * @param calculateDate		计算的年月
	 * @param tempMap			key:员工ID   value:与员工积分回收相关项信息
	 * @throws Exception
	 */
	public void getEmployeeSalaryReturnIntegral(Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap) throws Exception{
		EmployeeSalaryReturnRecord dao = new EmployeeSalaryReturnRecord();
		dao.setConditionIsReturn("=", false);
		dao.setConditionRecordDate("<=", DateUtil.getLastDay(calculateDate));
		dao.addCondition(BaseEmployeeSalaryReturnRecord.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BaseEmployeeSalaryReturnRecord> list = dao.conditionalLoad();
		dao.setIsReturn(true);
		dao.conditionalUpdate();
		if(null!=list && !list.isEmpty()){
			for(BaseEmployeeSalaryReturnRecord obj : list){
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				if(null!=obj.getSalaryReturn()){
					bean.setSalaryReturn(bean.getSalaryReturn().add(obj.getSalaryReturn()));
				}
			}
		}
	}
	
	/**
	 * 初始化用户积分信息
	 * @param employeeId
	 * @param employeeName
	 * @param employeeNo
	 * @param tempMap
	 * @param status	积分回收的类型  0:离职员工积分回收   1:高管积分回收  2:年薪员工积分回收
	 */
	public void initEmployeeReportRecordDetailInfo(Integer employeeId, String employeeName, String employeeNo, Map<Integer,BaseEmployeeReportRecordDetail> tempMap, int status){
		BaseEmployeeReportRecordDetail bean = new BaseEmployeeReportRecordDetail();
		bean.setEmployeeId(employeeId);
		bean.setEmployeeName(employeeName);
		bean.setEmployeeNo(employeeNo);
		bean.setAchieveIntegral(BigDecimal.ZERO);
		bean.setBonusPayment(BigDecimal.ZERO);
		bean.setManagerProjectIntegral(BigDecimal.ZERO);
		bean.setProjectAdvance(BigDecimal.ZERO);
		bean.setProjectCost(BigDecimal.ZERO);
		bean.setSalary(BigDecimal.ZERO);
		bean.setSalaryAdvance(BigDecimal.ZERO);
		bean.setSalaryReturn(BigDecimal.ZERO);
		bean.setSureIntegral(BigDecimal.ZERO);
		bean.setStatus(status);
		tempMap.put(bean.getEmployeeId(), bean);
	}
	public BigDecimal addBigDecimal(BigDecimal achieveIntegral, BigDecimal number){
		if(null!=number && number.compareTo(BigDecimal.ZERO)!=0){
			return achieveIntegral.add(number);
		}
		return achieveIntegral;
	}
	
	public BigDecimal subtractBigDecimal(BigDecimal achieveIntegral, BigDecimal number){
		if(null!=number && number.compareTo(BigDecimal.ZERO)!=0){
			return achieveIntegral.subtract(number);
		}
		return achieveIntegral;
	}
	/**
	 * 	获得本月本次计算该员工在该事业部可以回收的价值积分总额，并将其保存或者更新到员工价值积分回收表中
	 * @param plateId				员工所在事业部
	 * @param employeeIdArr			本月非在职员工的ID数组
	 * @param calculateDate			计算的年月
	 * @param tempMap				key:员工ID   value:与员工积分回收相关项信息
	 * @param sql					相关的查询条件限制
	 * @throws Exception
	 */
	public void saveOrUpdateEmployeeAchieveIntegralReturnRecord(Integer plateId, Object[] employeeIdArr, Date calculateDate, Map<Integer,BaseEmployeeReportRecordDetail> tempMap,String sql) throws Exception{
		Map<Integer, BaseEmployeeAchieveIntegralReturnRecord> map = new HashMap<>();
		//汇总出这个月的回收价值积分总额，更新到部门账户中
		BigDecimal sum = BigDecimal.ZERO;
		Date date = new Date();
		Date recordDate = DateUtil.getFirstDay(calculateDate);
		EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
		dao.setConditionPlateId("=", plateId);
		dao.addCondition(BaseEmployeeAchieveIntegralReturnRecord.CS_EMPLOYEE_ID, "in", employeeIdArr);
		List<BaseEmployeeAchieveIntegralReturnRecord> list = dao.conditionalLoad(sql.toString().replaceAll("Paramter", BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE));
		if(null!=list && !list.isEmpty()){
			for(BaseEmployeeAchieveIntegralReturnRecord obj : list){
				BigDecimal achieveIntegral = null==obj.getAchieveIntegral()?BigDecimal.ZERO:obj.getAchieveIntegral();
				BaseEmployeeReportRecordDetail bean = tempMap.get(obj.getEmployeeId());
				achieveIntegral = addBigDecimal(achieveIntegral, bean.getSureIntegral());
				achieveIntegral = addBigDecimal(achieveIntegral, bean.getManagerProjectIntegral());
				achieveIntegral = addBigDecimal(achieveIntegral, bean.getSalaryAdvance());
				achieveIntegral = addBigDecimal(achieveIntegral, bean.getProjectAdvance());
				achieveIntegral = subtractBigDecimal(achieveIntegral, bean.getSalaryReturn());
				achieveIntegral = subtractBigDecimal(achieveIntegral, bean.getSalary());
				achieveIntegral = subtractBigDecimal(achieveIntegral, bean.getProjectCost());
				achieveIntegral = subtractBigDecimal(achieveIntegral, bean.getBonusPayment());
				if(achieveIntegral.compareTo(obj.getAchieveIntegral())!=0){
					dao.clear();
					dao.setConditionEmployeeAchieveIntegralReturnRecordId("=", obj.getEmployeeAchieveIntegralReturnRecordId());
					dao.setAchieveIntegral(achieveIntegral);
					dao.setUpdateTime(date);
					dao.conditionalUpdate();
					//更新个人账户表
					//获取主键ID，即业务ID
					int businessId = obj.getEmployeeAchieveIntegralReturnRecordId();
					//获取人员id
					int employeeId = obj.getEmployeeId();
					//积分回收入个人账户表
					AccountManageProcess.onUpdateEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_INTEGRAL_RECYCLE, achieveIntegral, recordDate, "", -1);
					//积分回收入部门账户表
					AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_INTEGRAL_RECYCLE, achieveIntegral, recordDate, "", -1);
					map.put(obj.getEmployeeId(), dao.generateBase());
					sum = sum.add(dao.getAchieveIntegral());
				}
				tempMap.remove(obj.getEmployeeId());
			}
		}
		if(!tempMap.isEmpty()){
			for(Integer id : tempMap.keySet()){
				BaseEmployeeReportRecordDetail bean = tempMap.get(id);
				BaseEmployeeAchieveIntegralReturnRecord obj = new BaseEmployeeAchieveIntegralReturnRecord();
				obj.setAchieveIntegral(bean.getSureIntegral().add(bean.getManagerProjectIntegral()).add(bean.getSalaryAdvance()).add(bean.getProjectAdvance()).subtract(bean.getSalaryReturn()).subtract(bean.getSalary()).subtract(bean.getProjectCost()).subtract(bean.getBonusPayment()));
				if(obj.getAchieveIntegral().compareTo(BigDecimal.ZERO)!=0){
					obj.setCreateTime(date);
					obj.setUpdateTime(date);
					obj.setRecordDate(recordDate);
					obj.setEmployeeId(bean.getEmployeeId());
					obj.setEmployeeName(bean.getEmployeeName());
					obj.setEmployeeNo(bean.getEmployeeNo());
					obj.setPlateId(plateId);
					obj.setStatus(bean.getStatus());
					dao.clear();
					dao.setDataFromBase(obj);
					dao.save();
					//获取主键ID，即业务ID
					int businessId = dao.getEmployeeAchieveIntegralReturnRecordId();
					//获取人员id
					int employeeId = dao.getEmployeeId();
					//获取积分
					BigDecimal integral = dao.getAchieveIntegral();
					//积分回收入个人账户表
					AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_INTEGRAL_RECYCLE, integral, recordDate, "", -1);
					//积分回收入部门账户表
					AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_INTEGRAL_RECYCLE, integral, recordDate, "", -1);
					map.put(obj.getEmployeeId(), obj);
					sum = sum.add(obj.getAchieveIntegral());
				}
			}
		}
		//积分回收的总额不为0，则需要更新部门本月的积分汇总记录里面的价值积分和积分回收两项
//		if(sum.compareTo(BigDecimal.ZERO) != 0){
//			PlateReportRecord pDao = new PlateReportRecord();
//			pDao.setConditionPlateId("=", plateId);
//			pDao.setConditionRecordDate("=", recordDate);
//			BasePlateReportRecord bean = pDao.executeQueryOneRow();
//			if(null != bean){
//				bean.setAchieveIntegral(bean.getAchieveIntegral().add(sum));
//				bean.setEmployeeAchieveIntegralReturn(sum);
//				pDao.setDataFromBase(bean);
//				pDao.update();
//			}else{
//				pDao.setPlateId(plateId);
//				pDao.setRecordDate(recordDate);
//				pDao.setAchieveIntegral(sum);
//				pDao.setEmployeeAchieveIntegralReturn(sum);
//				pDao.save();
//			}
//		}
		//更新各个员工的当月积分汇总数据
//		if(!map.isEmpty()){
//			EmployeeReportRecord eDao = new EmployeeReportRecord();
//			eDao.setConditionRecordDate("=", recordDate);
//			eDao.addCondition(BaseEmployeeReportRecord.CS_EMPLOYEE_ID, "in", map.keySet().toArray());
//			List<BaseEmployeeReportRecord> eList = eDao.conditionalLoad();
//			//有记录，修改
//			if(null != eList && !eList.isEmpty()){
//				for(BaseEmployeeReportRecord obj : eList){
//					Integer key = obj.getEmployeeId();
//					BaseEmployeeAchieveIntegralReturnRecord bean = map.get(key);
//					BigDecimal integral = bean.getAchieveIntegral();
//					obj.setAchieveIntegral(obj.getAchieveIntegral().subtract(integral));
//					obj.setIntegralReturn(obj.getIntegralReturn().add(integral));
//					map.remove(key);
//					eDao.clear();
//					eDao.setDataFromBase(obj);
//					eDao.update();
//				}
//			}
//			//无记录，新增
//			if(!map.isEmpty()){
//				for(Integer id : map.keySet()){
//					BaseEmployeeAchieveIntegralReturnRecord bean = map.get(id);
//					eDao.clear();
//					eDao.setEmployeeId(id);
//					eDao.setEmployeeName(bean.getEmployeeName());
//					eDao.setEmployeeNo(bean.getEmployeeNo());
//					eDao.setAchieveIntegral(BigDecimal.ZERO.subtract(bean.getAchieveIntegral()));
//					eDao.setIntegralReturn(bean.getAchieveIntegral());
//					eDao.setRecordDate(recordDate);
//					eDao.setPlateId(plateId);
//					eDao.save();
//				}
//			}
//		}
	}
	
}
