package pomplatform.approveProjectStageStorage.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseApproveProjectStageStorage;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ApproveProjectStageStorage;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageStorage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.approveProjectStageStorage.bean.BaseApproveProjectStageStorageWithPp;
import pomplatform.approveProjectStageStorage.dao.ApproveProjectStageStorageWithPp;
import pomplatform.common.utils.StaticUtils;
import pomplatform.stage.bean.BaseProjectStageStorageWithP;
import pomplatform.stage.dao.ProjectStageStorageWithP;

public class approveprojectstagestoragecorWorker implements GenericWorkflowProcessor {
	private static final Logger __logger = Logger.getLogger("");
	protected  BaseApproveProjectStageStorageWithPp bean = new BaseApproveProjectStageStorageWithPp();

	@Override
	public  BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {

		int projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
		bean.setProjectId(projectId);
		
		
		//主表 （approve_project_stage_storages）
		Project project =new Project();
		project.setConditionProjectId("=",projectId);
		BaseProject baseProject = project.conditionalLoad().get(0);
		ApproveProjectStageStorage apssDao =new ApproveProjectStageStorage();
		BaseApproveProjectStageStorage appssb =new BaseApproveProjectStageStorage();
		Map<String,Object> param =new HashMap<>();
		param.put("projectId",baseProject.getProjectId());
		param.put("contractCode",baseProject.getContractCode());
		param.put("departmentManagerId",baseProject.getDepartmentManagerId());
		param.put("plateId",baseProject.getPlateId());
		param.put("plateManagerId",baseProject.getPlateManagerId());
		param.put("projectCode",baseProject.getProjectCode());
		param.put("projectManageId",baseProject.getProjectManageId());
		param.put("projectName",baseProject.getProjectName());
		param.put("projectType",baseProject.getProjectType());
		appssb.setDataFromMap(param);
		apssDao.setDataFromBase(appssb);
		apssDao.save();
		
		//子表 （project_stage_storages）
       ProjectStageStorageWithP projectStageStoragedao =new ProjectStageStorageWithP();
       BaseProjectStageStorageWithP p = new BaseProjectStageStorageWithP();
       String remark = BaseHelpUtils.getStringValue(params, "remark");
       List<Map> lm = (List<Map>) params.get("detailProjectStage");
       if(!BaseHelpUtils.isNullOrEmpty(remark)) {
          	if(!BaseHelpUtils.isNullOrEmpty(lm)) {
          		for (Map map : lm) {
          			map.put("remark", remark);
          		}
          	}
       }
       int projectTemplateId = BaseHelpUtils.getIntValue(params, "projectTemplateId");
       if(!BaseHelpUtils.isNullOrEmpty(projectTemplateId)&&projectTemplateId>0) {
          	if(!BaseHelpUtils.isNullOrEmpty(lm)) {
          		for (Map map : lm) {
          			map.put("projectTemplateId", projectTemplateId);
          		}
          	}
       }
       	p.setDataFromMap(params);
       	projectStageStoragedao.setDataFromBase(p);
   		projectStageStoragedao.update();
   		
		BusinessAbstract ba = new BusinessAbstract(apssDao.getApproveProjectStageStorageId(), "");
		return ba;
	}

	public   BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		 ProcessInstance pIns  = pi.getProcessInstance();
		 

		int projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		bean.setDataFromMap(params);
		dao.setDataFromBase(bean);
		BusinessAbstract ba = new BusinessAbstract(dao.getApproveProjectStageStorageId(), "");
		if(!modified) {
			    
			   if(BaseHelpUtils.isNullOrEmpty(pIns)) {
			    return ba;
			   }
			   //获取当前审批节点
			   ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			   if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
			    return ba;
			   }
			   //只有处理节点才可以更改数据
			   int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			   if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
			    return ba;
			   }
		}
		
		if(!dao.load()) {
			throw new SQLException("Business data not found");}
		else {
			if(completed&&pIns.getProcessStatus()==3) {
				//将project_stage_storages的数据 转移到 project_stages
				//子表 （project_stage_storages）
				ProjectStageStorage projectStageStoragedao =new ProjectStageStorage();
				projectStageStoragedao.setConditionProjectId("=", projectId);
				List<BaseProjectStageStorage> ProjectStageStorageList = projectStageStoragedao.conditionalLoad();
				
				//字表（project_stages）
				ProjectStage projectStageDao =new ProjectStage();
				projectStageDao.setConditionProjectId("=", projectId);
				
				if(ProjectStageStorageList.size()>0) {
					projectStageDao.conditionalDelete();
					for (BaseProjectStageStorage baseProjectStageStorage : ProjectStageStorageList) {
						BaseProjectStage base =new BaseProjectStage();
						Map<String,Object> param =new HashMap<>();
						param.put("projectId",baseProjectStageStorage.getProjectId());
						param.put("stageId",baseProjectStageStorage.getStageId());
						param.put("stageName",baseProjectStageStorage.getStageName());
						param.put("percent",BaseHelpUtils.getIntValue(baseProjectStageStorage.getPercent()));
						param.put("projectAmount",BaseHelpUtils.getBigDecimalValue(baseProjectStageStorage.getProjectAmount()));
						param.put("remark",baseProjectStageStorage.getRemark());
						base.setDataFromMap(param);
						projectStageDao.setDataFromBase(base);
						projectStageDao.save();
					}
					projectStageStoragedao.conditionalDelete();
				}
			}
		return ba;
		}
	}
	

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		//poolType 0并行  1串行
		if(!BaseHelpUtils.isNullOrEmpty(roleId) && Objects.equals(roleId, StaticUtils.ROLE_CONTRACT_MANAGER)) {
			Project dao = new Project();
			//获取项目ID
			int projectId = BaseHelpUtils.getIntValue(bean.getProjectId());
			dao.setProjectId(projectId);
			if(!dao.load()) {
				__logger.info(String.format("操作异常：未加载到项目信息，项目ID(%1$s)", projectId));
				return null;
			}
			//获取合同ID
			int contractId = BaseHelpUtils.getIntValue(dao.getContractId());
			dao.setConditionContractId("=",contractId);
			dao.setConditionProjectId("=", projectId);
			List<BaseProject> list = dao.conditionalLoad(String.format(" project_type in(%1$s,%2$s)",StaticUtils.PROJECT_TYPE_16,StaticUtils.PROJECT_TYPE_33));
			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
				int[] array=new int[1];
				array[0]= list.get(0).getProjectManageId();
				return array;
			}else {
				//获取业务部门ID
				int plateId=BaseHelpUtils.getIntValue(dao.getPlateId());
				Department deDao=new Department();
				deDao.setConditionDeleteFlag("=", 0);
				deDao.setConditionPlateId("=", plateId);
				List<BaseDepartment> delist=deDao.conditionalLoad("order by parent_id");
				Set<Integer> set=new HashSet<>();
				for (BaseDepartment debean : delist) {
					//获取部门ID
					int departmentIds=BaseHelpUtils.getIntValue(debean.getDepartmentId());
					EmployeeRole emDao=new EmployeeRole();
					emDao.setConditionDepartmentId("=", departmentIds);
					emDao.setConditionRoleId("=",StaticUtils.ROLE_OPERATIONS_MANAGER);
					List<BaseEmployeeRole>  erlist=emDao.conditionalLoad();
					for (BaseEmployeeRole bean : erlist) {
						set.add(bean.getEmployeeId());
					}
				}
				int[] arr = new int[set.size()];
				int i = 0;
				for (Integer value : set) {
					arr[i++] = BaseHelpUtils.getIntValue(value);
				}
				return arr;
			}
		}else {
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ApproveProjectStageStorageWithPp dao = new ApproveProjectStageStorageWithPp();
		dao.setApproveProjectStageStorageId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
