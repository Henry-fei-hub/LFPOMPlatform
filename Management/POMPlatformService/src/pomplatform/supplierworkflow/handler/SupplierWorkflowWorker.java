package pomplatform.supplierworkflow.handler;

import java.sql.SQLException;
import java.util.Map;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.common.utils.StaticUtils;
import pomplatform.supplierworkflow.bean.BaseReceiveUnitManageWithS;
import pomplatform.supplierworkflow.dao.ReceiveUnitManageWithS;

public class SupplierWorkflowWorker implements GenericWorkflowProcessor {

	protected BaseReceiveUnitManageWithS bean = new BaseReceiveUnitManageWithS();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getReceiveUnitManageId(), "");
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
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getReceiveUnitManageId(), "");
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
		ReceiveUnitManageWithS dao = new ReceiveUnitManageWithS();
		dao.setReceiveUnitManageId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
