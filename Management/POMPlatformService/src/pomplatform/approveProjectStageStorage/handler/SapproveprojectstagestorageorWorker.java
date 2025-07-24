package pomplatform.approveProjectStageStorage.handler;

import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.Map;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.approveProjectStageStorage.bean.BaseApproveProjectStageStorageWithPp;
import pomplatform.approveProjectStageStorage.dao.ApproveProjectStageStorageWithPp;

public class SapproveprojectstagestorageorWorker implements GenericWorkflowProcessor {

	protected BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(1, "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(1, "");
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
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
