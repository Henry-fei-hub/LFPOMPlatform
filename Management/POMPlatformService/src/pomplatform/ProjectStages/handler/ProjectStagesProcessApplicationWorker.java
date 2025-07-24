package pomplatform.ProjectStages.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageProcessDetail;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageProcessDetail;

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
import pomplatform.ProjectStages.bean.BaseProjectStageProcessRecordWithP;
import pomplatform.ProjectStages.dao.ProjectStageProcessRecordWithP;
import pomplatform.capitaldistribution.business.CapitalAndInvoiceProcessor;
import pomplatform.common.utils.StaticUtils;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployee;
import pomplatform.project.bean.BaseOnLoadMainProjectEmployeeByContractId;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployee;
import pomplatform.project.bean.ConditionOnLoadMainProjectEmployeeByContractId;
import pomplatform.project.query.QueryOnLoadMainProjectEmployee;
import pomplatform.project.query.QueryOnLoadMainProjectEmployeeByContractId;

public class ProjectStagesProcessApplicationWorker implements GenericWorkflowProcessor {

	protected BaseProjectStageProcessRecordWithP bean = new BaseProjectStageProcessRecordWithP();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		dao.setDataFromBase(bean);
		List<BaseProjectStageProcessDetail> list = dao.getDetailProjectStageProcessDetail();
		ProjectStage psDao =new ProjectStage();
		for (BaseProjectStageProcessDetail baseProjectStageProcessDetail : list) {
			Integer contractId = baseProjectStageProcessDetail.getContractId();
			Integer stageId = baseProjectStageProcessDetail.getStageId();
			psDao.clear();
			psDao.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_3);
			psDao.setConditionContractId("=", contractId);
			psDao.setConditionStageId("=", stageId);
			psDao.conditionalUpdate();
			
		}
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getProjectStageProcessRecordId(), "");
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
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				ProjectStageProcessDetail detao =new ProjectStageProcessDetail();
				detao.setConditionProjectStageProcessRecordId("=", dao.getProjectStageProcessRecordId());
				List<BaseProjectStageProcessDetail> list = detao.conditionalLoad();
				ProjectStage psDao =new ProjectStage();
				BigDecimal percent = BigDecimal.ZERO;
				int it = 1;
				for (BaseProjectStageProcessDetail baseProjectStageProcessDetail : list) {
					//本次流程确认的占比和
					percent = percent.add(BaseHelpUtils.getBigDecimalValue(baseProjectStageProcessDetail.getPercent()));
					System.out.println("it===="+it);
					System.out.println("percent===="+percent);
					it+=1;
					
				}
				int operateEmployeeId = BaseHelpUtils.getIntValue(params.get("operateEmployeeId"));
				
				System.out.println("last========="+percent);
				CapitalAndInvoiceProcessor.settleProjectType16(percent,bean.getContractId(), operateEmployeeId);
				
				for (BaseProjectStageProcessDetail baseProjectStageProcessDetail : list) {
					Integer contractId = baseProjectStageProcessDetail.getContractId();
					Integer stageId = baseProjectStageProcessDetail.getStageId();
					psDao.clear();
					psDao.setConditionContractId("=", contractId);
					psDao.setConditionStageId("=", stageId);
					BaseProjectStage base = psDao.executeQueryOneRow();
					base.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_2);
					psDao.clear();
					psDao.setDataFromBase(base);
					psDao.update();
				}
				
				//流程完成后，判读当前的阶段确认是否比回款快，如果是则保存数据以及进行消息通知
				CapitalAndInvoiceProcessor capitalAndInvoiceProcessor = new  CapitalAndInvoiceProcessor();
				Map map =new HashMap<String, Object>();
				map.put("contractId", bean.getContractId());
				map.put("projectStageProcessRecordId", bean.getProjectStageProcessRecordId());
				map.put("employeeId", BaseHelpUtils.isNullOrEmpty(pi.getProcessInstance())?-1:pi.getProcessInstance().getEmployeeId());
				map.put("saveOrUpdate", 1);//保存
				capitalAndInvoiceProcessor.checkAndSaveContractMessage(map);

			}else if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				List<BaseProjectStageProcessDetail> list = dao.getDetailProjectStageProcessDetail();
				ProjectStage psDao =new ProjectStage();
				for (BaseProjectStageProcessDetail baseProjectStageProcessDetail : list) {
					Integer contractId = baseProjectStageProcessDetail.getContractId();
					Integer stageId = baseProjectStageProcessDetail.getStageId();
					psDao.clear();
					psDao.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
					psDao.setConditionContractId("=", contractId);
					psDao.setConditionStageId("=", stageId);
					psDao.conditionalUpdate();
					
				}
			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getProjectStageProcessRecordId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
			Integer contractId = BaseHelpUtils.getIntValue(bean.getContractId());
			if(contractId<=0) {
				throw new SQLException("合同信息获取失败！");
			}
			
			if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.ROLE_143) {// 项目秘书1
				QueryOnLoadMainProjectEmployeeByContractId query = new QueryOnLoadMainProjectEmployeeByContractId();
				ConditionOnLoadMainProjectEmployeeByContractId condition = new ConditionOnLoadMainProjectEmployeeByContractId();
				condition.setContractId(contractId);
				condition.setRelation(1);
				BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> execute = query.execute(null, condition);
				if (!BaseHelpUtils.isNullOrEmpty(execute) && execute.getCollections().size() > 0) {
					List<BaseOnLoadMainProjectEmployeeByContractId> collections = execute.getCollections();
					int[] activityOwners = new int[collections.size()];
					for (int i = 0; i < collections.size(); i++) {
						activityOwners[i] = BaseHelpUtils.getIntValue(collections.get(i).getEmployeeId());
					}
					return activityOwners;
				} else {
					return new int[0];
				}
			} else if (!BaseHelpUtils.isNullOrEmpty(roleId) && roleId == StaticUtils.ROLE_152) {// 项目负责人5
				QueryOnLoadMainProjectEmployeeByContractId query = new QueryOnLoadMainProjectEmployeeByContractId();
				ConditionOnLoadMainProjectEmployeeByContractId condition = new ConditionOnLoadMainProjectEmployeeByContractId();
				condition.setContractId(contractId);
				condition.setRelation(5);
				BaseCollection<BaseOnLoadMainProjectEmployeeByContractId> execute = query.execute(null, condition);
				if (!BaseHelpUtils.isNullOrEmpty(execute) && execute.getCollections().size() > 0) {
					List<BaseOnLoadMainProjectEmployeeByContractId> collections = execute.getCollections();
					int[] activityOwners = new int[collections.size()];
					for (int i = 0; i < collections.size(); i++) {
						activityOwners[i] = BaseHelpUtils.getIntValue(collections.get(i).getEmployeeId());
					}
					return activityOwners;
				} else {
					return new int[0];
				}
			} else {
				return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
			}
		
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ProjectStageProcessRecordWithP dao = new ProjectStageProcessRecordWithP();
		dao.setProjectStageProcessRecordId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}
	
	

}
