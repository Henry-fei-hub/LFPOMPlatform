package pomplatform.preprojecttransferrecordpors.handler;

import java.sql.SQLException;
import java.util.Map;

import com.pomplatform.db.bean.BasePreProjectTransferRecord;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectTransferRecord;

import delicacy.common.BaseCollection;
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
import pomplatform.preprojecttransferrecordpors.bean.BaseForPreproJectTransFerrecordporDate;
import pomplatform.preprojecttransferrecordpors.bean.ConditionForPreproJectTransFerrecordporDate;
import pomplatform.preprojecttransferrecordpors.query.QueryForPreproJectTransFerrecordporDate;

public class ForPreproJectTransFerrecordporWorker implements GenericWorkflowProcessor {

	protected BasePreProjectTransferRecord bean = new BasePreProjectTransferRecord();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPreProjectTransferRecordId(), "");
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
		PreProjectTransferRecord dao = new PreProjectTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		if(completed) {
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				int preProjectId=BaseHelpUtils.getIntValue(params.get("preProjectId"));
				int employeeIds=BaseHelpUtils.getIntValue(params.get("employeeId"));
				int transferEmployeeIds=BaseHelpUtils.getIntValue(params.get("transferEmployeeId"));
				//更改项目的主要跟进人
				MainProjectEmployee medao = new MainProjectEmployee();
				medao.setConditionPreProjectId("=", preProjectId);
				medao.setConditionEmployeeId("=", employeeIds);
				medao.setConditionRelation("=", 1);
				medao.setConditionMainAndAssistance("=", 1);
				medao.setEmployeeId(transferEmployeeIds);
				medao.conditionalUpdate();

				//更改前期项目表的报备人
				PreProject daos = new PreProject();
				daos.setPreProjectId(preProjectId);
				if(daos.load()){
					daos.setApplyEmployeeId(transferEmployeeIds);
					daos.update();
				}
			}

		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPreProjectTransferRecordId(), "");
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
		QueryForPreproJectTransFerrecordporDate   query=new  QueryForPreproJectTransFerrecordporDate();
		ConditionForPreproJectTransFerrecordporDate condition=new  ConditionForPreproJectTransFerrecordporDate();
		condition.setPreProjectTransferRecordId(businessId);
		BaseCollection<BaseForPreproJectTransFerrecordporDate> data=query.executeQuery(null, condition);

		if(null != data && null != data.getCollections() && !data.getCollections().isEmpty()) {
			return data.getCollections().get(0).toJSON();
		}
		return null;
	}

}
