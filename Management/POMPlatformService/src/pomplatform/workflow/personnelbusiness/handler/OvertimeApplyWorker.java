package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.date.util.DateUtil;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.bean.BaseCountOverTimeApply;
import pomplatform.workflow.personnelbusiness.bean.BaseGetOvertimeApplyHours;
import pomplatform.workflow.personnelbusiness.bean.ConditionCountOverTimeApply;
import pomplatform.workflow.personnelbusiness.bean.ConditionGetOvertimeApplyHours;
import pomplatform.workflow.personnelbusiness.query.QueryCountOverTimeApply;
import pomplatform.workflow.personnelbusiness.query.QueryGetOvertimeApplyHours;

public class OvertimeApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao, false);
		//		validateHours(false, dao, null);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}

			//获取当前审批节点
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			//获取当前节点类型
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			//只有处理节点才可以更改数据
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
				return null;
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				bean.setIsCompleted(true);
			}
		}
		if(!dao.load()) throw new SQLException("Business data not found");
		BigDecimal hour = dao.getHours();
		dao.setDataFromBase(bean);
//		Integer projectType = dao.getProjectType();
//		if(BaseHelpUtils.isNullOrEmpty(projectType)) {
//			throw new SQLException("加班类型不能为空");
//		}
//		
//		if(projectType.equals(StaticUtils.OVER_TIME_APPLY_TYPE_3)){
//			if(null != dao.getProjectId()){
//				dao.setProjectId(null);
//			}
//			if(null != dao.getProjectCode()){
//				dao.setProjectCode(null);
//			}
//			if(null != dao.getProjectName()){
//				dao.setProjectName(null);
//			}
//		}
		//		validateHours(true, dao, hour);
		dataValidate(dao, true);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	private void dataValidate(PersonnelBusines dao, boolean isUpdate) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("申请人不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("工号不能为空");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getDepartmentId())){
			throw new Exception("部门不能为空");
		}
		Date date = dao.getStartDate();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(BaseHelpUtils.isNullOrEmpty(date)){
			throw new Exception("开始日期不能为空");
		}else if(!isUpdate){
//			calendar.setTime(date);
//			calendar.set(Calendar.HOUR_OF_DAY, 0);
//			calendar.set(Calendar.MINUTE, 0);
//			calendar.set(Calendar.SECOND, 0);
//			calendar.set(Calendar.MILLISECOND, 0);
//			date = calendar.getTime();
//			calendar.setTime(new Date());
//			calendar.set(Calendar.HOUR_OF_DAY, 0);
//			calendar.set(Calendar.MINUTE, 0);
//			calendar.set(Calendar.SECOND, 0);
//			calendar.set(Calendar.MILLISECOND, 0);
//			if(calendar.get(Calendar.DATE) <= 5){
//				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
//			}
//			calendar.set(Calendar.DATE, 1);
//			Date startDate = calendar.getTime();
//			if((new Date()).getDate() <= 5){
//				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 2);
//			}else{
//				calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
//			}
//			calendar.set(Calendar.DATE, 5);
//			Date endDate = calendar.getTime();
//			if(!DateUtil.isBetween(date, startDate, endDate)){
//				throw new Exception("当前可申请的开始日期范围为：<br><font style=\"color:red\">"+format.format(startDate)+"</font>至<font style=\"color:red\">"+format.format(endDate)+"</font>");
//			}
		}
		Date endDate = dao.getEndDate();
		if(BaseHelpUtils.isNullOrEmpty(endDate)){
			throw new Exception("结束日期不能为空");
		}else{
			if(dao.getStartDate().getTime() - endDate.getTime() > 0){
				throw new Exception("开始日期必须小于等于结束日期");
			}
		}
		//判断是否是同一天，如果不是同一天，则不允许提交
		if(!DateUtil.isSameDay(date, endDate)) {
			throw new Exception("开始时间和结束时间需为同一天");
		}
		if(!isUpdate){
			ConditionCountOverTimeApply condition = new ConditionCountOverTimeApply();
			QueryCountOverTimeApply query = new QueryCountOverTimeApply();
			BaseCollection<BaseCountOverTimeApply> result = null;
			condition.setEmployeeId(dao.getEmployeeId());
			int days = DateUtil.generateDaysBetween(dao.getEndDate(), dao.getStartDate());
			Date tempDate = dao.getStartDate();
			for(int i = 0; i < days; i++){
				if(i != 0){
					tempDate = DateUtil.getNextDayOfDay(tempDate, 1);
				}
				condition.setTime(tempDate);
				result = query.executeQuery(null, condition);
				if(null != result && null != result.getCollections() && !result.getCollections().isEmpty() && BaseHelpUtils.getIntValue(result.getCollections().get(0).getCount()) > 0){
					throw new Exception("您已申请过" + format.format(tempDate) + "的加班，请不要重复申请");
				}
			}
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getReason())){
			throw new Exception("申请缘由不能为空");
		}
	}

	/**
	 * 
	 * @param isUpdate
	 * @param dao
	 * @param hour		之前的小时数
	 * @throws Exception
	 */
	private void validateHours(boolean isUpdate, PersonnelBusines dao, BigDecimal hour) throws Exception{
		BigDecimal hours = BigDecimal.ZERO;
		BigDecimal twenty = new BigDecimal(20);
		BigDecimal maxHours = BigDecimal.ZERO;
		ConditionGetOvertimeApplyHours condition = new ConditionGetOvertimeApplyHours();
		condition.setEmployeeId(dao.getEmployeeId());
		Calendar c = Calendar.getInstance();
		if(isUpdate){
			c.setTime(dao.getCreateTime());
		}else{
			c.setTime(new Date());
		}
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Date startTime = c.getTime();
		c.set(Calendar.YEAR, c.get(Calendar.YEAR) + 1);
		Date endTime = c.getTime();
		condition.setStartTime(startTime);
		condition.setEndTime(endTime);
		QueryGetOvertimeApplyHours query = new QueryGetOvertimeApplyHours();
		BaseCollection<BaseGetOvertimeApplyHours> bc = query.executeQuery(null, condition);
		if(null != bc.getCollections() && null != bc.getCollections().get(0) && null != bc.getCollections().get(0).getHours()){
			hours = bc.getCollections().get(0).getHours();
		}
		if(isUpdate){
			//修改的，需要减去原有的小时数，再加上本次的小时数
			if(null != dao && null != dao.getHours()){
				hours = hours.subtract(hour);
				maxHours = twenty.subtract(hours);
			}
			hours = hours.add(dao.getHours());
		}else{
			maxHours = twenty.subtract(hours);
			//新增的，只需要加上本次的小时数
			hours = hours.add(dao.getHours());
		}
		//减去已经使用的小时数
		PersonnelBusines pbDao = new PersonnelBusines();
		pbDao.setConditionProcessType("=", StaticUtils.PROCESS_TYPE_13);
		pbDao.setConditionType("=", StaticUtils.LEAVE_TYPE_21);
		pbDao.setConditionIsCompleted("=", true);
		pbDao.setConditionEmployeeId("=", dao.getEmployeeId());
		List<BasePersonnelBusines> list = pbDao.conditionalLoad();
		for (BasePersonnelBusines bqlad : list) {
			if(null != bqlad.getDays()){
				hours = hours.subtract(bqlad.getDays().multiply(StaticUtils.TOTAL_HOURS));
				maxHours = maxHours.add(bqlad.getDays().multiply(StaticUtils.TOTAL_HOURS));
			}
			if(null != bqlad.getHours()){
				hours = hours.subtract(bqlad.getHours());
				maxHours = maxHours.add(bqlad.getHours());
			}
		}
		//控制，1年内，总的加班时数最多只能有20个小时
		if(hours.compareTo(twenty) > 0){
			if(maxHours.compareTo(BigDecimal.ZERO) > 0){
				throw new Exception("对不起，您本次最多只能申请"+maxHours+"小时");
			}else{
				throw new Exception("对不起，您申请的加班时间已达上限，无法继续申请；建议您先调休，再申请加班");
			}
		}
	}
}
