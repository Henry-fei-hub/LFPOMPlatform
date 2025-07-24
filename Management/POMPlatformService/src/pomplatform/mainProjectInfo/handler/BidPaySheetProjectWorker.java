package pomplatform.mainProjectInfo.handler;

import org.apache.axis2.databinding.types.soapencoding.Array;
import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.mainProjectInfo.bean.BasePersonnelBusinessWithProject;
import pomplatform.project.business.OnProjectCommonProcess;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BaseNormalReimbursementLinkProject;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.Project;


public class BidPaySheetProjectWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();
	protected BasePersonnelBusinessWithProject beanWithProject = new BasePersonnelBusinessWithProject();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		
		//项目关闭进行中
		PreProject pDao =new PreProject();
		String infoCode = BaseHelpUtils.getStringValue(params, "unit");
		pDao.setConditionInfoCode("=", infoCode);
		BasePreProject preProject = pDao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(preProject)) {
			preProject.setStatus(4);//关闭进行中
			pDao.clear();
			pDao.setDataFromBase(preProject);
			pDao.update();
		}else {
			throw new SQLException("前期项目查询失败");
		}
		
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		beanWithProject.setDataFromMap(params);
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
		if(completed){
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {// 被驳回
				//项目关闭
				PreProject pDao =new PreProject();
				String infoCode = BaseHelpUtils.getStringValue(params, "unit");
				pDao.setConditionInfoCode("=", infoCode);
				BasePreProject preProject = pDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(preProject)) {
					preProject.setStatus(6);//关闭失败
					pDao.clear();
					pDao.setDataFromBase(preProject);
					pDao.update();
				}else {
					throw new SQLException("前期项目查询失败");
				}
				
			}else if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {//
				OnProjectCommonProcess process =new OnProjectCommonProcess();
				Map param = new HashMap<>();
				param.put("contractId", params.get("linkId"));
				param.put("mainProjectId", params.get("dutyId"));
				param.put("signingMoneySum", params.get("livingExpenses"));
//				param.put("projectId", params.get("projectId"));
				param.put("projectRecords",  beanWithProject.getProjectRecords());
				param.put("operator",params.get("employeeId") );
				process.onBidPaySheetProjectSave(param);
				
				//项目关闭
				PreProject pDao =new PreProject();
				String infoCode = BaseHelpUtils.getStringValue(params, "unit");
				pDao.setConditionInfoCode("=", infoCode);
				BasePreProject preProject = pDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(preProject)) {
					preProject.setStatus(5);//关闭成功
					preProject.setCloseReason(BaseHelpUtils.getStringValue(params, "projectType"));
					preProject.setCloseRemark(BaseHelpUtils.getStringValue(params, "reason"));
					pDao.clear();
					pDao.setDataFromBase(preProject);
					pDao.update();
				}else {
					throw new SQLException("前期项目查询失败");
				}
			}
		}
		
		List<BaseProject> projectRecords = beanWithProject.getProjectRecords();
		if (!BaseHelpUtils.isNullOrEmpty(projectRecords)) {
			Project dao = new Project();
			for (BaseProject baseProject : projectRecords) {
				dao.setProjectId(baseProject.getProjectId());
				if (dao.load()) {
					if(completed){
						if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {// 被驳回
							// 获取甲方补偿金额
							dao.setTotalAmount(BigDecimal.ZERO);
							dao.setTotalIntegral(BigDecimal.ZERO);
							dao.update();
						}
					}else {
						// 获取甲方补偿金额
						dao.setSheetAmount(BigDecimal.ZERO);
						dao.setTotalAmount(BaseHelpUtils.getBigDecimalValue(baseProject.getTotalAmount()));
						dao.setProjectIntegral(BigDecimal.ZERO);
						dao.setTotalIntegral(BaseHelpUtils.getBigDecimalValue(baseProject.getTotalAmount()));
						dao.setPercentage(BigDecimal.ZERO);
						dao.setComplaintPercentage(BigDecimal.ZERO);
						dao.update();}
					}
					       
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
	
			int mainProjectId = BaseHelpUtils.getIntValue(bean.getDutyId());
			if (mainProjectId <= 0) {
				throw new SQLException("前期项目信息丢失！");
			}
			if(!BaseHelpUtils.isNullOrEmpty(roleId)&&roleId==StaticUtils.ROLE_67) {
				Set<Integer> ownerSet = getRole67(mainProjectId);
				if (!ownerSet.isEmpty()) {
					Employee e = new Employee();
					e.unsetSelectFlags();
					e.setSelectEmployeeId(true);
					e.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
					e.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", ownerSet.toArray());
					List<BaseEmployee> employeeList = e.conditionalLoad();
					int length = employeeList.size();
					int[] activityOwners = new int[length];
					for (int i = 0; i < length; i++) {
						activityOwners[i] = BaseHelpUtils.getIntValue(employeeList.get(i).getEmployeeId());
					}
					return activityOwners;
				} else {
					return new int[0];
				}
			}else if(!BaseHelpUtils.isNullOrEmpty(roleId)&&roleId==StaticUtils.ROLE_81){
				Set<Integer> ownerSet = new HashSet<>();
				MainProjectEmployee dao = new MainProjectEmployee();
				dao.setConditionRelation("=", 4);
				dao.setConditionMainProjectId("=", mainProjectId);
				dao.setConditionIsPlateManager("=", true);
				List<BaseMainProjectEmployee> conditionalLoad = dao.conditionalLoad();
				if(conditionalLoad.size()>0) {
					for (BaseMainProjectEmployee baseMainProjectEmployee : conditionalLoad) {
						Integer  empId = BaseHelpUtils.getIntValue(baseMainProjectEmployee.getEmployeeId());
						if(empId>0) {
							ownerSet.add(empId);
						}
					}
				}
				if (!ownerSet.isEmpty()) {
					Employee e = new Employee();
					e.unsetSelectFlags();
					e.setSelectEmployeeId(true);
					e.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
					e.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", ownerSet.toArray());
					List<BaseEmployee> employeeList = e.conditionalLoad();
					int length = employeeList.size();
					int[] activityOwners = new int[length];
					for (int i = 0; i < length; i++) {
						activityOwners[i] = BaseHelpUtils.getIntValue(employeeList.get(i).getEmployeeId());
					}
					return activityOwners;
				} else {
					return new int[0];
				}
			}else if(!BaseHelpUtils.isNullOrEmpty(roleId)&&roleId==StaticUtils.ROLE_OPERATIONS_MANAGER){//部门经理
				EmployeeRole erDao =new EmployeeRole();
				Department dDao =new Department();
				Project pDao =new Project();
				Set<Integer> ownerSet = new HashSet<>();
//				List<BaseProject> projectRecords = beanWithProject.getProjectRecords();
				
				Integer contractId = BaseHelpUtils.getIntValue(bean.getLinkId());
				pDao.unsetSelectFlags();
				pDao.setSelectDepartmentManagerId(true);
				pDao.setConditionContractId("=", contractId);
				pDao.setConditionProjectType("=", 66);//投标类型订单
				pDao.addCondition(BaseProject.CS_DEPARTMENT_MANAGER_ID, ">", 0);
				List<BaseProject> projectRecords = pDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(projectRecords)&&projectRecords.size()>0){
					for (BaseProject baseProject : projectRecords) {
						ownerSet.add(baseProject.getDepartmentManagerId());
					}
					
					if (!ownerSet.isEmpty()) {
						Iterator<Integer> ir = ownerSet.iterator();
						int[] activityOwners = new int[ownerSet.size()];
						int i = 0;
				        while(ir.hasNext()){
				        	activityOwners[i] = BaseHelpUtils.getIntValue(ir.next());
				        	i+=1;
				        }
						return activityOwners;
					}else {
						return new int[0];
					}
				}else {
					return new int[0];
				}
			}else {
				return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
			}
		}
	

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}
	
	
	private Set<Integer> getRole67(int mainProjectId) throws SQLException {
		Set<Integer> ownerSet = new HashSet<>();
		MainProject dao = new MainProject();
		PlateRecord pDao = new PlateRecord();
		Department dDao = new Department();
		EmployeeRole erDao = new EmployeeRole();
		dao.setMainProjectId(mainProjectId);
		if (dao.load()) {
			String projectSalesTeam = dao.getProjectSalesTeam();
			pDao.clear();
			pDao.setConditionPlateName("=", projectSalesTeam);
			BasePlateRecord plate = pDao.executeQueryOneRow();
			if (!BaseHelpUtils.isNullOrEmpty(plate)&&plate.getPlateId()>0) {
					dDao.setConditionPlateId("=", plate.getPlateId());
					List<BaseDepartment> departmentList = dDao.conditionalLoad();
					if (departmentList.size() > 0) {
						for (BaseDepartment baseDepartment : departmentList) {
							Integer deptId = baseDepartment.getDepartmentId();
							erDao.clear();
							erDao.setConditionDepartmentId("=", deptId);
							erDao.setConditionRoleId("=", StaticUtils.ROLE_67);
							List<BaseEmployeeRole> list = erDao.conditionalLoad();
							if (list.size() > 0) {
								for (BaseEmployeeRole baseEmployeeRole : list) {
									ownerSet.add(baseEmployeeRole.getEmployeeId());
								}
							}
						}
					}
			}
		}
		return ownerSet;
	}
	
	public static void main(String[] args) throws Exception {
		BidPaySheetProjectWorker a =new BidPaySheetProjectWorker();
		a.findActivityOwner(0, 0, 0,81,0);
	}

}
