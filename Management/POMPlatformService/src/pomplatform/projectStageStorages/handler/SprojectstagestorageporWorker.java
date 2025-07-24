package pomplatform.projectStageStorages.handler;

import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.stage.bean.BaseProjectStageStorageWithP;
import pomplatform.stage.dao.ProjectStageStorageWithP;

import com.pomplatform.db.bean.BaseApproveProjectStageStorage;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ApproveProjectStageStorage;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectStageStorage;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.Map;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ProjectStageStorage;
import java.sql.SQLException;
import java.util.Map;

import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.dao.ProjectStageStorage;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import pomplatform.common.utils.StaticUtils;

public class SprojectstagestorageporWorker implements GenericWorkflowProcessor {

	protected BaseProjectStageStorage bean = new BaseProjectStageStorage();

	public     BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		 int projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
		
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
		param.put("employeeId",params.get("employeeId"));
		appssb.setDataFromMap(param);
		apssDao.setDataFromBase(appssb);
		apssDao.save();
		
		//子表 （project_stage_storages）
        ProjectStageStorageWithP projectStageStoragedao =new ProjectStageStorageWithP();
        BaseProjectStageStorageWithP p = new BaseProjectStageStorageWithP();
        String remark = BaseHelpUtils.getStringValue(params, "remark");
        if(!BaseHelpUtils.isNullOrEmpty(remark)) {
        	List<Map> lm = (List<Map>) params.get("detailProjectStage");
        	if(!BaseHelpUtils.isNullOrEmpty(lm)) {
        		for (Map map : lm) {
//        			int stageId = BaseHelpUtils.getIntValue(map.get("stageId"));
        			map.put("remark", remark);
        		}
        	}
        }
        p.setDataFromMap(params);
        projectStageStoragedao.setDataFromBase(p);
    	projectStageStoragedao.update();
		BusinessAbstract ba = new BusinessAbstract(projectId, "");
		return ba;
	}
	
	
/*	public static void main(String[] args) {
        java.util.Map param = new java.util.HashMap();
        java.util.Map res = new java.util.HashMap();
//        ListGridRecord[] rows = newGrid.getRecords();
//        MapUtils.convertRecordToMap(newGrid.getDataSource(), rows, param, "detailProjectStage");
		List<Map> ll = new ArrayList<>();
		res.put("projectId",6170 );
		res.put("stageId", 0);
		res.put("stageName","测试" );
		res.put("percent",100 );
		res.put("projectAmount",10000);
		ll.add(res);
		param.put("detailProjectStage", ll);
        param.put("projectId", 6170);
        param.put("remark","1231231");
        param.put("employeeId","38");
        try {
			startNewWorkflow(null,param,0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

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
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getProjectStageStorageId(), "");
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
	public String getBusinessData(Integer projectId) throws Exception {
		ProjectStageStorage dao = new ProjectStageStorage();
		dao.setProjectId(projectId);
		dao.load();
		return dao.generateBase().toJSON();
	}

}
