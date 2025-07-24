package pomplatform.personnelbusiness.handler;

import delicacy.common.BaseHelpUtils;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.executor.SystemProcessConstants;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.Map;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import com.pomplatform.db.bean.BaseEmployeeContractAttachment;
import com.pomplatform.db.dao.EmployeeContractAttachment;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;

public class EmployeeContractAttachmentWorker implements GenericWorkflowProcessor {

	protected BaseEmployeeContractAttachment bean = new BaseEmployeeContractAttachment();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getEmployeeContractAttachmentId(), "");
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
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
				return null;
			}
		}
		//流程被驳回
		if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
			bean.setDeleteFlag(0);
		}
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getEmployeeContractAttachmentId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
//		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId, null, null, null);
		return ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId,
								   Integer roleId, Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(bean.getEmployeeId(), employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		EmployeeContractAttachment dao = new EmployeeContractAttachment();
		dao.setEmployeeContractAttachmentId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

}
