package pomplatform.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectStageProcessDetail;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectStage;

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
import pomplatform.personnelbusiness.bean.BasePersonnelBusinesWithP;
import pomplatform.personnelbusiness.dao.PersonnelBusinesWithP;

public class ProjectEmployeeProcessApplicationWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setIsCompleted(false);
		int projectId = BaseHelpUtils.getIntValue(bean.getProjectId());
		List<BaseProjectEmployee> detailProjectEmployee = bean.getDetailProjectEmployee();
		for (BaseProjectEmployee baseProjectEmployee : detailProjectEmployee) {
			baseProjectEmployee.setProjectId(projectId);
		}
		
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
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
		bean.setIsCompleted(true);
		int projectId = BaseHelpUtils.getIntValue(bean.getProjectId());
		List<BaseProjectEmployee> detailProjectEmployee = bean.getDetailProjectEmployee();
		for (BaseProjectEmployee baseProjectEmployee : detailProjectEmployee) {
			baseProjectEmployee.setProjectId(projectId);
		}
		
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				for (BaseProjectEmployee baseProjectEmployee : detailProjectEmployee) {
					baseProjectEmployee.setAlternateField2(2+"");
					baseProjectEmployee.setStatus(2);
				}
				ProjectEmployee peDao =new ProjectEmployee();
				peDao.setConditionProjectId("=", bean.getProjectId());
				peDao.setConditionBusinessId("!=", bean.getPersonnelBusinessId());
				peDao.setConditionStatus("=", 2);
				peDao.addCondition(BaseProjectEmployee.CS_BUSINESS_ID, ">", 0);
				peDao.setStatus(0);
				peDao.conditionalUpdate();
				
				
			}else if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				for (BaseProjectEmployee baseProjectEmployee : detailProjectEmployee) {
					baseProjectEmployee.setAlternateField2(1+"");
					baseProjectEmployee.setStatus(1);
				}
			}
		}

		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		if(!BaseHelpUtils.isNullOrEmpty(roleId) && Objects.equals(roleId, StaticUtils.ROLE_OPERATIONS_MANAGER)) {
			int[] arr = new int[1];
			int departmentManagerId = BaseHelpUtils.getIntValue(bean.getDepartmentId());
			if(departmentManagerId>0) {
				arr[0] = departmentManagerId;
			}
			return arr;
		}else {
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}
	
	public static void main(String[] args) throws SQLException {
		ProjectEmployee peDao =new ProjectEmployee();
		peDao.setConditionProjectId("=", 8043);
		peDao.setConditionBusinessId("!=",52321);
		peDao.setConditionStatus("=", 2);
		peDao.addCondition(BaseProjectEmployee.CS_BUSINESS_ID, ">", 0);
		peDao.setStatus(0);
		peDao.conditionalUpdate();
	}

}
