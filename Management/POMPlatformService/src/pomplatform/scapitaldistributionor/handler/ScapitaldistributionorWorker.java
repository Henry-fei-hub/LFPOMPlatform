package pomplatform.scapitaldistributionor.handler;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;

import delicacy.common.BaseCollection;
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
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.scapitaldistributionor.bean.BaseCapitalDistributionWithCc;
import pomplatform.scapitaldistributionor.dao.CapitalDistributionWithCc;

public class ScapitaldistributionorWorker implements GenericWorkflowProcessor {

	protected BaseCapitalDistributionWithCc bean = new BaseCapitalDistributionWithCc();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		dao.setDataFromBase(bean);
		//		dao.setCode(OnWrokflowProcess.getNewCode(BaseHelpUtils.getIntValue(pd.getProcessTypeId())));
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getCapitalDistributionId(), "");
		//流程开始将所选的回款数据 置于流程中
		CustomCapitalDistributionProcess.doCapitalProcess(dao.getCapitalDistributionId(), dao.getCapitalId());
		return ba;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				CustomCapitalDistributionProcess.passDoCapitalProcess(dao.getCapitalId());
				//				dao.setIsCompleted(true);
				//				dao.setCompleteTime(new Date());
			} else {
				CustomCapitalDistributionProcess.unDoCapitalProcess(dao.getCapitalId());
			}
		} else {
			CustomCapitalDistributionProcess.updateDoCapitalProcess(dao.getCapitalDistributionId(), dao.getCapitalId());
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getCapitalDistributionId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if (poolType == null || poolType == 0) {
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		} else {
			//先确定 做分配的人   1:有大项目经理的就分配给大项目经理  2:没有大项目经理找到主专业的项目经理

			//找大项目经理
			int contractId = bean.getContractId();
			Contract cDao = new Contract();
			cDao.setContractId(contractId);
			if(cDao.load() && !BaseHelpUtils.isNullOrEmpty(cDao.getContractCode())){
				List<BaseProject> pList = CustomCapitalDistributionProcess.getProjectListByContractCodeOrContractId(null, cDao.getContractCode());
				if(pList.size() > 0){
					Set<Integer> ownerSet = new HashSet<>();

					Integer manageId = null;//大项目经理ID
					String infoCode = cDao.getInfoCode();
					MainProject mpDao = new MainProject();
					mpDao.setConditionInfoCode("=", infoCode);
					BaseMainProject pBean = mpDao.executeQueryOneRow();
					if(null != pBean){//可能有项目经理
						MainProjectEmployee mpeDao = new MainProjectEmployee();
						mpeDao.setConditionMainProjectId("=", pBean.getMainProjectId());
						mpeDao.setConditionRelation("=", 3);
						mpeDao.executeQueryOneRow();
						manageId = mpeDao.getEmployeeId();
					}
					if(null == manageId){//没有大项目经理  找主专业经理
						for (BaseProject baseProject : pList) {
							//							if(Objects.equals(baseProject.getPlateId(), bean.getMainProfessional())){
							//								manageId = baseProject.getProjectManageId();
							//								break;
							//							}
						}
					}
					if( null != manageId ){
						if (Objects.equals(roleId, StaticUtils.ROLE_CAPITAL_DISTRIBUTION_MANAGER)) {
							ownerSet.add(manageId);
						} else if (Objects.equals(roleId, StaticUtils.ROLE_CAPITAL_CONFIRM_MANAGER)) {
							if(pList.size() > 0){
								Set<Integer> plateIds = new HashSet<>();
								//找出所有项目的项目经理且不包含大项目经理
								for (BaseProject baseProject : pList) {
									if(!Objects.equals(baseProject.getProjectManageId(), manageId)){
										if (null != baseProject.getProjectManageId()) {
											ownerSet.add(baseProject.getProjectManageId());
										}
									}
									plateIds.add(baseProject.getPlateId());
								}
								//所有回款确认专员
								for (Integer integer : plateIds) {
									if(null != integer){
										ConditiongetEmployeeIdByRoleIdWithoutPlateRecord condition = new ConditiongetEmployeeIdByRoleIdWithoutPlateRecord();
										condition.setPlateId(integer);
										condition.setRoleId(StaticUtils.ROLE_CAPITAL_CONFIRM_MANAGER);
										QuerygetEmployeeIdByRoleIdWithoutPlateRecord query = new QuerygetEmployeeIdByRoleIdWithoutPlateRecord();
										BaseCollection<BasegetEmployeeIdByRoleId> bc = query.executeQuery(null, condition);
										if (null != bc && null != bc.getCollections()) {
											for (BasegetEmployeeIdByRoleId obj : bc.getCollections()) {
												if (null != obj.getEmployeeId()) {
													ownerSet.add(obj.getEmployeeId());
												}
											}
										}
									}
								}
								/*if(ownerSet.isEmpty()){
									throw new Exception("该合同没有回款确认专员  contractId = " + contractId);
								}*/
							} /*else {
								throw new Exception("该合同下没有回款确认专员  contractId = " + contractId);
							}*/
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
					} else {
						throw new Exception("该合同下没有找到回款分配专员  contractId = " + contractId);
					}
				} else {
					throw new Exception("该没有找到该合同 或合同编号为空 contractID = " + contractId);
				}


				//找到主合同对应的子合同 将所有子合同的code转换成String []
				//				SubContract sbDao = new SubContract();
				//				sbDao.setConditionParentId("=", cDao.getContractId());
				//				List<BaseSubContract> sbList = sbDao.conditionalLoad();
				//				
				//				if( sbList.size() > 0 ){
				//					Set<Integer> ownerSet = new HashSet<>();
				//					Object [] conditionArra = new Object [sbList.size()];
				//					for (int i = 0; i < sbList.size(); i++) {
				//						conditionArra [i] = sbList.get(i).getSubContractCode();
				//					}
				//					Project pDao = new Project();
				//					Integer manageId = null;//大项目经理ID
				//					String infoCode = cDao.getInfoCode();
				//					MainProject mpDao = new MainProject();
				//					mpDao.setConditionInfoCode("=", infoCode);
				//					BaseMainProject pBean = mpDao.executeQueryOneRow();
				//					if(null != pBean){//可能有项目经理
				//						MainProjectEmployee mpeDao = new MainProjectEmployee();
				//						mpeDao.setConditionMainProjectId("=", pBean.getMainProjectId());
				//						mpeDao.setConditionRelation("=", 3);
				//						mpeDao.executeQueryOneRow();
				//						manageId = mpeDao.getEmployeeId();
				//					}
				//					if(null == manageId){//没有大项目经理  找主专业经理
				//						pDao.setConditionPlateId("=", bean.getMainProfessional());
				//						pDao.addCondition(BaseProject.CS_CONTRACT_CODE, "in", conditionArra);
				//						BaseProject __pbean = pDao.executeQueryOneRow();
				//						if(null != __pbean){
				//							manageId = __pbean.getProjectManageId();
				//						} 
				//					}
				//					if( null != manageId ){
				//						if (Objects.equals(roleId, StaticUtils.ROLE_CAPITAL_DISTRIBUTION_MANAGER)) {
				//							ownerSet.add(manageId);
				//						} else if (Objects.equals(roleId, StaticUtils.ROLE_CAPITAL_CONFIRM_MANAGER)) {
				//							pDao.clear();
				//							pDao.addCondition(BaseProject.CS_CONTRACT_CODE, "in", conditionArra);
				//							List<BaseProject> __pList = pDao.conditionalLoad();
				//							if(__pList.size() > 0){
				//								Set<Integer> plateIds = new HashSet<>();
				//								//找出所有项目的项目经理且不包含大项目经理
				//								for (BaseProject baseProject : __pList) {
				//									if(!Objects.equals(baseProject.getProjectManageId(), manageId)){
				//										if (null != baseProject.getProjectManageId()) {
				//											ownerSet.add(baseProject.getProjectManageId());
				//										}
				//									}
				//									plateIds.add(baseProject.getPlateId());
				//								}
				//								//所有部门助理
				//								for (Integer integer : plateIds) {
				//									ConditiongetEmployeeIdByRoleIdWithoutPlateRecord condition = new ConditiongetEmployeeIdByRoleIdWithoutPlateRecord();
				//									condition.setPlateId(integer);
				//									condition.setRoleId(StaticUtils.ROLE_DEPARTMENT_ASSISTANT);
				//									QuerygetEmployeeIdByRoleIdWithoutPlateRecord query = new QuerygetEmployeeIdByRoleIdWithoutPlateRecord();
				//									BaseCollection<BasegetEmployeeIdByRoleId> bc = query.executeQuery(null, condition);
				//									if (null != bc && null != bc.getCollections()) {
				//										for (BasegetEmployeeIdByRoleId obj : bc.getCollections()) {
				//											if (null != obj.getEmployeeId()) {
				//												ownerSet.add(obj.getEmployeeId());
				//											}
				//										}
				//									}
				//								}
				//								if(ownerSet.isEmpty()){
				//									throw new Exception("该合同没有回款确认专员  contractId = " + contractId);
				//								}
				//							} else {
				//								throw new Exception("该合同下没有回款确认专员  contractId = " + contractId);
				//							}
				//						}
				//						
				//						if (!ownerSet.isEmpty()) {
				//							Employee e = new Employee();
				//							e.unsetSelectFlags();
				//							e.setSelectEmployeeId(true);
				//							e.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
				//							e.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", ownerSet.toArray());
				//							List<BaseEmployee> employeeList = e.conditionalLoad();
				//							int length = employeeList.size();
				//							int[] activityOwners = new int[length];
				//							for (int i = 0; i < length; i++) {
				//								activityOwners[i] = BaseHelpUtils.getIntValue(employeeList.get(i).getEmployeeId());
				//							}
				//							return activityOwners;
				//						} else {
				//							return new int[0];
				//						}
				//					} else {
				//						throw new Exception("该合同下没有找到回款分配专员  contractId = " + contractId);
				//					}
				//				} else {
				//					throw new Exception("该合同下没有找到 子订单  contractId = " + contractId);
				//				}

			} else {
				throw new Exception("没有找到合同  contractId = " + contractId);
			}

		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		CapitalDistributionWithCc dao = new CapitalDistributionWithCc();
		dao.setCapitalDistributionId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

}
