package pomplatform.attachmentapproval.handler;

import java.sql.SQLException;
import java.util.Map;

import com.pomplatform.db.bean.BaseBudgetAttachment;
import com.pomplatform.db.dao.BudgetAttachment;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;

public class AttachmentApprovalWorker implements GenericWorkflowProcessor {

	protected BaseBudgetAttachment bean = new BaseBudgetAttachment();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		//获取预算管理ID
		int budgetManagementId=BaseHelpUtils.getIntValue(params.get("budgetManagementId"));
		//获取预算附件ID
		int budgetAttachmentId=BaseHelpUtils.getIntValue(params.get("budgetAttachmentId"));
		BudgetAttachment dao = new BudgetAttachment();
		dao.setConditionBudgetAttachmentId("=", budgetAttachmentId);
		dao.setConditionBudgetManagementId("=", budgetManagementId);
		bean=dao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(bean)) {
			dao.setIsApproval(StaticUtils.ATTACHMENT_APPROVAL_STATUS_ONGOING);//审批中
			dao.setIsLock(true);//加锁
			dao.conditionalUpdate();
		}else {
			throw new Exception("找不到关联的预算附件");
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getBudgetAttachmentId(), "");
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
		BudgetAttachment dao = new BudgetAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setIsApproval(StaticUtils.ATTACHMENT_APPROVAL_STATUS_ALREADY);;//审批完成

			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getBudgetAttachmentId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		BudgetAttachment dao = new BudgetAttachment();
		dao.setBudgetAttachmentId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

}
