package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.bean.BaseFillcheckApplyTimes;
import pomplatform.workflow.personnelbusiness.bean.ConditionFillcheckApplyTimes;
import pomplatform.workflow.personnelbusiness.query.QueryFillcheckApplyTimes;

public class FillcheckApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		checkFrequency(bean);
		dao.setDataFromBase(bean);
		dataValidate(dao, false);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		//同步考勤
		OnShiftManageProcess.syncAttendance(bean);
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
			//同步考勤
			OnShiftManageProcess.syncAttendance(bean);
		}
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dataValidate(dao, true);
		dao.update();
		if(modified) {
			//同步考勤
			OnShiftManageProcess.syncAttendance(bean);
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);

		long sum = 0;
		Date date = bean.getStartDate();
		ConditionFillcheckApplyTimes condition = new ConditionFillcheckApplyTimes();
		QueryFillcheckApplyTimes query = new QueryFillcheckApplyTimes();
		condition.setEmployeeId(bean.getEmployeeId());
		condition.setStartDate(DateUtil.getFirstDay(date));
		condition.setEndDate(DateUtil.getFirstDayOfNextMonth(date));
		BaseCollection<BaseFillcheckApplyTimes> bc = query.executeQuery(null, condition);
		if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty() && null != bc.getCollections().get(0).getSum()){
			sum = bc.getCollections().get(0).getSum();
		}
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		e.setValue("次数", new BigDecimal(sum));
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		//"自定义审核人",也就是补卡时填写的"证明人"
		if(null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)){
			if(null != bean.getNextAuditor()){
				return new int[] {bean.getNextAuditor()};
			}else{
				return new int[0];
			}
		}
		//考勤管理专员做特殊处理 产讯所有的考勤专员 不区分部门
		if(null != roleId && roleId.equals(StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR)){
			EmployeeRole employeeRole = new EmployeeRole();
			employeeRole.setConditionRoleId("=", 16);
			List<BaseEmployeeRole> baseEmployeeRoles = employeeRole.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(baseEmployeeRoles)) {
				int size = baseEmployeeRoles.size();
				int[] ints = new int[size];
				int i = 0;
				for (BaseEmployeeRole role : baseEmployeeRoles) {
					Integer employeeId1 = role.getEmployeeId();
					ints[i] = employeeId1;
					i++;
					return ints;
				}
			} else {
				return new int[0];
			}
		}
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
		Date date = dao.getStartDate();
		ConditionFillcheckApplyTimes condition = null;
		QueryFillcheckApplyTimes query = null;
		BaseCollection<BaseFillcheckApplyTimes> bc = null;
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
		if(BaseHelpUtils.isNullOrEmpty(dao.getType())){
			throw new Exception("签到签退不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getStartDate())){
			throw new Exception("漏打卡日期不能为空");
		}else if(!isUpdate){
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTimeInMillis(System.currentTimeMillis());
//			calendar.set(Calendar.HOUR_OF_DAY, 0);
//			calendar.set(Calendar.MINUTE, 0);
//			calendar.set(Calendar.SECOND, 0);
//			calendar.set(Calendar.MILLISECOND, 0);
//			Date endDate = calendar.getTime();
//			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 7);
//			Date startDate = calendar.getTime();
//			calendar.setTime(date);
//			calendar.set(Calendar.HOUR_OF_DAY, 0);
//			calendar.set(Calendar.MINUTE, 0);
//			calendar.set(Calendar.SECOND, 0);
//			calendar.set(Calendar.MILLISECOND, 0);
//			date = calendar.getTime();
//			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//			if(!DateUtil.isBetween(date, startDate, endDate)){
//				throw new Exception("可申请的漏打卡日期范围为：<br><font style=\"color:red\">"+format.format(startDate)+"</font>至<font style=\"color:red\">"+format.format(endDate)+"</font>");
//			}
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getReason())){
			throw new Exception("申请缘由不能为空");
		}
		if(!isUpdate){
			condition = new ConditionFillcheckApplyTimes();
			condition.setEmployeeId(dao.getEmployeeId());
			condition.setType(dao.getType());
			condition.setAtThisDate(dao.getStartDate());
			query = new QueryFillcheckApplyTimes();
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("(b.start_date >= ? and b.start_date < ? )");
			kv.setValue("1 = ? and 1 = ?");
			KeyValuePair[] kvs = {kv};
			bc = query.executeQuery(kvs, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty() && bc.getCollections().get(0).getSum() > 0){
				throw new Exception("请不要重复申请");
			}
		}
	}
	/**
	 * @Author: liubin
	 * @Description : 校验次数
	 * @Date: 17:48 2019/12/2
	 * @param:
	 * @return:
	 */
	private void checkFrequency(BasePersonnelBusines bean) throws SQLException, ParseException {
		if (!BaseHelpUtils.isNullOrEmpty(bean)) {
			Integer employeeId = bean.getEmployeeId();
			Date date = bean.getStartDate();
			ConditionFillcheckApplyTimes condition = new ConditionFillcheckApplyTimes();
			QueryFillcheckApplyTimes query = new QueryFillcheckApplyTimes();
			condition.setEmployeeId(bean.getEmployeeId());
			condition.setStartDate(DateUtil.getFirstDay(date));
			condition.setEndDate(DateUtil.getFirstDayOfNextMonth(date));
			BaseCollection<BaseFillcheckApplyTimes> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty() && null != bc.getCollections().get(0).getSum()){
				 int sum = BaseHelpUtils.getIntValue(bc.getCollections().get(0).getSum());
				if (sum >= 3) {
					throw new SQLException("每月最多可申请打卡次数为3次");
				}
			}
		}
	}
}
