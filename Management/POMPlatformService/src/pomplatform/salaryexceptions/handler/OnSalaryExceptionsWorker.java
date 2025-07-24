package pomplatform.salaryexceptions.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.dao.SalaryException;
import com.pomplatform.db.dao.SalaryJobSubsidy;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.salaryexceptions.bean.BasePersonnelBusinesWithS;
import pomplatform.salaryexceptions.dao.PersonnelBusinesWithS;

public class OnSalaryExceptionsWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusinesWithS bean = new BasePersonnelBusinesWithS();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		PersonnelBusinesWithS dao = new PersonnelBusinesWithS();
		bean.setProcessType(pd.getProcessTypeId());
		dao.setDataFromBase(bean);
		dao.save();
		boolean testProcessor = BaseHelpUtils.getBoolean(params.get(StaticUtils.TEST_PROCESSOR));
		//如果是测试流程，就不走下面的方法
		if(!testProcessor) {
			//流程申请时 把IsApply设置为True
			SalaryException  sep = new SalaryException();
			Date currentDate = new Date();
			int personnelBusinessId = dao.getPersonnelBusinessId();
			sep.setOperateTime(currentDate);
			sep.setConditionPersonnelBusinessId("=", personnelBusinessId);
			sep.setIsApply(true);
			sep.conditionalUpdate();
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
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
		PersonnelBusinesWithS dao = new PersonnelBusinesWithS();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		//流程审批，修改，介绍时
		if(completed) {
			Date currentDate = new Date();
			//如果流程被驳回
			//被驳回时
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				SalaryException sep = new SalaryException();
				int personnelBusinessId = dao.getPersonnelBusinessId();
				sep.setConditionPersonnelBusinessId("=", personnelBusinessId);
				sep.setIsApply(false);
				int years = currentDate.getYear() + 1900;
				int months = currentDate.getMonth()+1;
				int day=currentDate.getDate();
				if(day<=10) {
					if(months==1) { 
						years=years-1;
						months=11;
					}else if(months==2){
						years=years-1;
						months=12;
					}else {
						months=months-2;
					}
				}else if(day>10) {
					if(months==1) {
						years=years-1;
						months=12;
					}else {
						months=months-1;	

					}
				}
				sep.setYear(years);
				sep.setMonth(months);
				sep.conditionalUpdate();
			}
			//流程结束时
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				int year = DateUtil.getYear(currentDate);
				int month = DateUtil.getMonth(currentDate);
				SalaryException  sep = new SalaryException();
				int personnelBusinessId = dao.getPersonnelBusinessId();
				sep.setConditionPersonnelBusinessId("=", personnelBusinessId);
				sep.setIsApply(true);
				sep.conditionalUpdate();

				//把申请的工资扣款金额相加，插入岗位补贴表
				List<Map<String,Object>> list = (List<Map<String, Object>>) params.get("detailSalaryException");
				SalaryJobSubsidy sjsDao = new SalaryJobSubsidy();
				sjsDao.setEmployeeId(BaseHelpUtils.getIntValue(params.get("employeeId")));
				sjsDao.setYear(year);
				sjsDao.setMonth(month);
				sjsDao.setRecordDate(currentDate);
				sjsDao.setOperateTime(currentDate);
				BigDecimal attendanceDeduction = BigDecimal.ZERO;
				for(Map<String,Object> value : list) {

					if(!BaseHelpUtils.isNullOrEmpty(value.get("actuallyDeduction"))) {
						attendanceDeduction = attendanceDeduction.add(BaseHelpUtils.getBigDecimalValue(value.get("actuallyDeduction")));
					}
				}
				sjsDao.setMileageSubsidy(BaseHelpUtils.getString(0));
				sjsDao.setSalarySubsidy(BaseHelpUtils.getString(0));
				sjsDao.setLeaveSubsidy(BaseHelpUtils.getString(0));
				sjsDao.setPerformanceSubsidy(BaseHelpUtils.getString(0));
				sjsDao.setWorkSiteSubsidy(BaseHelpUtils.getString(0));
				sjsDao.setPositiveAccount(BaseHelpUtils.getString(0));
				//				sjsDao.setAttentionSubsidy(attendanceDeduction.negate()+"");
				sjsDao.setAttentionSubsidy(attendanceDeduction+"");
				sjsDao.setTotalAmount(attendanceDeduction+"");
				sjsDao.save();

			}
		}

		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusinesWithS dao = new PersonnelBusinesWithS();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
