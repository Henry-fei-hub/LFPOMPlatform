package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.Map;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;

public class StampCarvingApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
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
		PersonnelBusines dao = new PersonnelBusines();
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				bean.setIsCompleted(true);
			}
		}
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load())
			throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e =OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
		if(expression.indexOf("印章类型") >= 0){
			String type = "";
			if(null != bean.getType() && bean.getType().intValue() == StaticUtils.SIGNET_TYPE_10){
				type = "项目刻章";
			}
			e.setValue("印章类型", type);
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	private void dataValidate(PersonnelBusines dao) throws Exception {
		if (BaseHelpUtils.isNullOrZero(dao.getProcessType())) {
			throw new Exception("流程类型错误");
		}
		if (BaseHelpUtils.isNullOrZero(dao.getEmployeeId())) {
			throw new Exception("申请人不能为空");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getAddress())) {
			throw new Exception("请选择印章种类");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getProjectName())) {
			throw new Exception("请填写刻章字样");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getProjectCode())) {
			throw new Exception("请填写刻章内容");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getSubType())) {
			throw new Exception("请填写印章尺寸");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getSubTypeStr())) {
			throw new Exception("请填写印章形状");
		}
		if (BaseHelpUtils.isNullOrEmpty(dao.getReason())) {
			throw new Exception("请选择申请原因");
		}
	}
}
