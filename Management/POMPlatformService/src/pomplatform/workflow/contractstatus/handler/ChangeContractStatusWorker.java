package pomplatform.workflow.contractstatus.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.pomplatform.db.bean.BaseContractLog;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectPerformance;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractLog;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectPerformance;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.common.KeyValuePair;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.workflow.contractstatus.bean.BaseChangeContractStatus;
import pomplatform.workflow.contractstatus.bean.BaseContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionChangeContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatus;
import pomplatform.workflow.contractstatus.query.QueryChangeContractStatus;
import pomplatform.workflow.contractstatus.query.QueryContractStatus;
import pomplatform.workflow.contractstatus.utils.ContractStatusUtils;

public class ChangeContractStatusWorker implements GenericWorkflowProcessor {

	protected BaseContractLog bean = new BaseContractLog();
	private Integer preProjectId = null;

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		ContractLog dao = new ContractLog();
		dao.setDataFromBase(bean);
		dao.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_NEW_CREATED);
		ConditionChangeContractStatus condition = new ConditionChangeContractStatus();
		condition.setContractId(dao.getContractId());
		condition.setProcessType(StaticUtils.PROCESS_TYPE_64);
		QueryChangeContractStatus query = new QueryChangeContractStatus();
		BaseCollection<BaseChangeContractStatus> bc = query.executeQuery(null, condition);
		if(null == bc || null == bc.getCollections() || bc.getCollections().isEmpty()) {
			throw new Exception("无法获取合同相关信息");
		}else {
			if(bc.getCollections().size() > 1) {
				throw new Exception("获取合同信息出错");
			}else {
				if(bc.getCollections().get(0).getWorkflowNum() > 0) {
					throw new Exception("该合同已有正在进行中的合同状态变更流程，无法再次发起合同状态变更流程");
				}
			}
		}
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getContractLogId(), "");
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());
		//项目(合同)终止流程发起的时候，合同改为项目(合同)终止-结算中状态，相关订单也改为订单终止—结算中状态
		if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_14) || Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_11)) {
			dao.clear();
			dao.setDataFromBase(bean);
			if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_14)) {
				dao.setNewStatus(StaticUtils.CONTRACT_STATUS_13);
			}else {
				dao.setNewStatus(StaticUtils.CONTRACT_STATUS_10);
			}
			dao.setOperateTime(new Date());
			dao.save();
			ContractStatusUtils util = new ContractStatusUtils();
			util.updateContractAndProjectStatus(dao.getContractId(), dao.getNewStatus());
		}
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
		ContractLog dao = new ContractLog();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		Integer processStatus = pi.getProcessInstance().getProcessStatus();
		dao.setProcessStatus(processStatus);
		if(completed){
			dao.setOperateTime(new Date());
			if(Objects.equals(processStatus, SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				Contract cDao = new Contract();
				cDao.setContractId(dao.getContractId());
				if(!cDao.load()) {
					throw new SQLException("无法获取合同数据");
				}
				Integer nowStatus = cDao.getContractStatus();
				if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_5) || Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_8) || Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_6) || Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_12)) {
					//项目暂停、合同暂停、合同重启、合同结束
					ContractStatusUtils util = new ContractStatusUtils();
					util.updateContractAndProjectStatus(dao.getContractId(), dao.getNewStatus());
					if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_12)) {
						//合同结束的，还需要将订单的投诉保证金返回给部门
						Project pDao = new Project();
						pDao.setConditionContractId("=", dao.getContractId());
						List<BaseProject> pList = pDao.conditionalLoad();
						if(null != pList && !pList.isEmpty()) {
							for(BaseProject pBean : pList) {
								if(null != pBean.getReserveIntegral() && pBean.getReserveIntegral().compareTo(BigDecimal.ZERO) != 0){
									PlateAccountRecord parDao = new PlateAccountRecord();
									parDao.setConditionBusinessId("=", pBean.getProjectId());
									parDao.setConditionBusinessTypeId("=", AccountManageProcess.PLATE_BT_END_PROJECT);
									if(parDao.countRows() > 0) {
										continue;
									}
									BigDecimal integral = pBean.getComplaintIntegral();
									ProjectPerformance ppDao = new ProjectPerformance();
									ppDao.setConditionProjectId("=", pBean.getProjectId());
									ppDao.setConditionBusinessType("=", StaticUtils.PERFORMANCE_BUSINESS_TYPE_2);
									List<BaseProjectPerformance> ppList = ppDao.conditionalLoad();
									if(null != ppList && !ppList.isEmpty()){
										for(BaseProjectPerformance pp : ppList){
											if(null != pp.getIntegral() && pp.getIntegral().compareTo(BigDecimal.ZERO) != 0){
												switch(pp.getPerformanceFlag()){
												case StaticUtils.PERFORMANCE_FLAG_1:
													integral = integral.subtract(pp.getIntegral());
													break;
												case StaticUtils.PERFORMANCE_FLAG_2:
													integral = integral.add(pp.getIntegral());
													break;
												default:
													break;
												}
											}
										}
									}
									//往部门账户表中插入数据
									String remark = pBean.getContractCode() + " 项目名称：" + pBean.getProjectName()+ "的结项积分";
									AccountManageProcess.onSavePlateAccount(pBean.getPlateId(), pBean.getProjectId(), AccountManageProcess.PLATE_BT_END_PROJECT, integral, new Date(), remark, dao.getOperator());
								}
							}
						}
					}
				}else if(Objects.equals(dao.getOriginalStatus(), StaticUtils.CONTRACT_STATUS_5) && Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_4)) {
					//项目重启
					ContractStatusUtils util = new ContractStatusUtils();
					if(Objects.equals(cDao.getContractSigningStatus(), StaticUtils.CONTRACT_SIGING_STATUS_2)) {
						//合同已签订，则合同改为合同运行状态，相关订单改为订单运行状态
						util.updateContractAndProjectStatus(dao.getContractId(), StaticUtils.CONTRACT_STATUS_6);
					}else {
						//合同未签订，则看项目是否是投标/方案必选项目
						MainProject mpDao = new MainProject();
						mpDao.setConditionInfoCode("=", cDao.getInfoCode());
						BaseMainProject mpBean = mpDao.executeQueryOneRow();
						if(null == mpBean) {
							throw new SQLException("无法获取项目信息");
						}
						if(Objects.equals(mpBean.getProjectBaseOn(), StaticUtils.PROJECT_BASE_ON_2) || Objects.equals(mpBean.getProjectBaseOn(), StaticUtils.PROJECT_BASE_ON_3)) {
							//是合同立项/委托函立项的项目，合同改为项目缓慢状态，相关订单改为订单缓慢状态
							util.updateContractAndProjectStatus(dao.getContractId(), StaticUtils.CONTRACT_STATUS_4);
						}else if(Objects.equals(mpBean.getProjectBaseOn(), StaticUtils.PROJECT_BASE_ON_1) || Objects.equals(mpBean.getProjectBaseOn(), StaticUtils.PROJECT_BASE_ON_4)) {
							//是投标/方案比选项目，判断该项目是否中标
							if(Objects.equals(mpBean.getBidType(), StaticUtils.BID_TYPE_WIN_BID)) {
								//中标，合同改为项目缓慢状态，相关订单改为订单缓慢状态
								util.updateContractAndProjectStatus(dao.getContractId(), StaticUtils.CONTRACT_STATUS_4);
							}else if(Objects.equals(mpBean.getBidType(), StaticUtils.BID_TYPE_NO_RESULT)) {
								//未出结果，合同改为未出结果状态，相关订单改为未出结果状态
								util.updateContractAndProjectStatus(dao.getContractId(), StaticUtils.CONTRACT_STATUS_1);
							}else if(Objects.equals(mpBean.getBidType(), StaticUtils.BID_TYPE_LOSE_BID)) {
								//落标，不允许重启
								throw new Exception("该合同已落标，无法重启");
							}
						}
					}
				}else if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_14) || Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_11)) {
					//项目(合同)终止
					//流程顺利完成，合同改为项目(合同)终止状态，相关订单也改为订单终止状态
					ContractStatusUtils util = new ContractStatusUtils();
					util.updateContractAndProjectStatus(dao.getContractId(), dao.getNewStatus());
					//新建流程的时候，合同日志记录了状态由原始状态变为项目(合同)终止-结算中状态，所以流程顺利完成之后，本记录应改为从项目(合同)终止-结算中状态变为项目(合同)终止状态
					if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_14)) {
						dao.setOriginalStatus(StaticUtils.CONTRACT_STATUS_13);
					}else {
						dao.setOriginalStatus(StaticUtils.CONTRACT_STATUS_10);
					}
				}
				if(Objects.equals(nowStatus, dao.getOriginalStatus())) {
					throw new Exception("合同状态已发生变化，本次合同变更失败，请驳回数据");
				}
			}else if(Objects.equals(processStatus, SystemProcessConstants.PROCESS_STATUS_REJECT)){
				if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_14) || Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_11)) {
					//项目(合同)终止
					//流程被驳回，合同改为发起流程时的状态，相关订单也根据合同状态重新设定订单状态
					ContractStatusUtils util = new ContractStatusUtils();
					util.updateContractAndProjectStatus(dao.getContractId(), dao.getOriginalStatus());
					//新建流程的时候，合同日志记录了状态由原始状态变为项目终止-结算中状态，所以流程被驳回时后，需要增加一条从项目终止-结算中状态变为发起流程时的合同状态的记录
					ContractLog logDao = new ContractLog();
					logDao.setContractId(dao.getContractId());
					if(Objects.equals(dao.getNewStatus(), StaticUtils.CONTRACT_STATUS_14)) {
						logDao.setOriginalStatus(StaticUtils.CONTRACT_STATUS_13);
						logDao.setContent("项目终止流程被驳回，合同恢复为发起流程时的状态");
					}else {
						logDao.setOriginalStatus(StaticUtils.CONTRACT_STATUS_10);
						logDao.setContent("合同终止流程被驳回，合同恢复为发起流程时的状态");
					}
					logDao.setNewStatus(dao.getOriginalStatus());
					logDao.setOperator(dao.getOperator());
					logDao.setOperateTime(new Date());
					logDao.save();
				}
			}
		}
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseContractLog.CS_ATTACHMENT_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getContractLogId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		if(expression.indexOf("合同状态变更") >= 0) {
			String value = null;
			switch(bean.getNewStatus()) {
			case StaticUtils.CONTRACT_STATUS_4:
				value = "项目重启";
				break;
			case StaticUtils.CONTRACT_STATUS_5:
				value = "项目暂停";
				break;
			case StaticUtils.CONTRACT_STATUS_6:
				value = "合同重启";
				break;
			case StaticUtils.CONTRACT_STATUS_8:
				value = "合同暂停";
				break;
			case StaticUtils.CONTRACT_STATUS_11:
				value = "合同终止";
				break;
			case StaticUtils.CONTRACT_STATUS_12:
				value = "合同结束";
				break;
			case StaticUtils.CONTRACT_STATUS_14:
				value = "项目终止";
				break;
			default:
				value = "";
			}
			e.setValue("合同状态变更", value);
		}
		return ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		if(null != roleId) {
			Set<Integer> set = new HashSet<>();
			if(Objects.equals(roleId, StaticUtils.ROLE_CUSTOM_AUDITOR)) {
				//返回项目组的所有成员
				Integer preProjectId = getPreProjectId();
				if(null == preProjectId) {
					return new int[0];
				}else {
					MainProjectEmployee mpeDao = new MainProjectEmployee();
					mpeDao.setConditionPreProjectId("=", preProjectId);
					mpeDao.unsetSelectFlags();
					mpeDao.setSelectEmployeeId(true);
					List<BaseMainProjectEmployee> mpeList = mpeDao.conditionalLoad();
					for(BaseMainProjectEmployee obj : mpeList) {
						set.add(obj.getEmployeeId());
					}
					return generateIntArrBySet(set);
				}
			}else if(Objects.equals(roleId, StaticUtils.ROLE_PLATE_MANAGER) || Objects.equals(roleId, StaticUtils.ROLE_OPERATIONS_MANAGER)) {
				//返回合同下所有订单所在部门的事业部负责人、部门经理
				if(null == bean.getContractId()) {
					return new int[0];
				}
				KeyValuePair kv = new KeyValuePair();
				kv.setKey("plate_id = ?");
				kv.setValue(String.format("plate_id = ? and plate_id in (select distinct plate_id from projects where contract_id = %1$s)", bean.getContractId()));
				KeyValuePair[] kvs = {kv};
				ConditiongetEmployeeIdByRoleIdWithoutPlateRecord condition = new ConditiongetEmployeeIdByRoleIdWithoutPlateRecord();
				condition.setRoleId(roleId);
				QuerygetEmployeeIdByRoleIdWithoutPlateRecord query = new QuerygetEmployeeIdByRoleIdWithoutPlateRecord();
				BaseCollection<BasegetEmployeeIdByRoleId> bc = query.executeQuery(kvs, condition);
				if (null == bc || null == bc.getCollections() || bc.getCollections().isEmpty()) {
					return new int[0];
				}
				for (BasegetEmployeeIdByRoleId obj : bc.getCollections()) {
					if (null != obj.getEmployeeId()) {
						set.add(obj.getEmployeeId());
					}
				}
				return generateIntArrBySet(set);
			}else if(Objects.equals(roleId, StaticUtils.ROLE_PRE_PROJECT_APPLICANT)) {
				//返回前期项目的报备人
				Integer preProjectId = getPreProjectId();
				if(null != preProjectId) {
					PreProject preDao = new PreProject();
					preDao.setPreProjectId(preProjectId);
					preDao.unsetSelectFlags();
					preDao.setSelectApplyEmployeeId(true);
					if(preDao.load()) {
						int[] arr = {BaseHelpUtils.getIntValue(preDao.getApplyEmployeeId())};
						return arr;
					}
					return new int[0];
				}
			}else if(Objects.equals(roleId, StaticUtils.ROLE_DEPARTMENT_LEADER)) {
				//返回项目的报备人所在的部门的负责人
				Integer preProjectId = getPreProjectId();
				if(null != preProjectId) {
					PreProject preDao = new PreProject();
					preDao.setPreProjectId(preProjectId);
					preDao.unsetSelectFlags();
					preDao.setSelectApplyEmployeeId(true);
					if(preDao.load()) {
						int applicant = BaseHelpUtils.getIntValue(preDao.getApplyEmployeeId());
						Employee eDao = new Employee();
						eDao.unsetSelectFlags();
						eDao.setSelectDepartmentId(true);
						eDao.setEmployeeId(applicant);
						if(eDao.load()) {
							return ProcessUtil.findNextOwner(processCreator, null, eDao.getDepartmentId(), roleId);
						}
					}
				}
				return new int[0];
			}
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	private Integer getPreProjectId() throws SQLException{
		if(null != preProjectId) {
			return preProjectId;
		}
		if(null == preProjectId && null != bean.getContractId()) {
			Contract c = new Contract();
			c.setContractId(bean.getContractId());
			c.unsetSelectFlags();
			c.setSelectInfoCode(true);
			if(c.load()) {
				PreProject preDao = new PreProject();
				preDao.unsetSelectFlags();
				preDao.setSelectPreProjectId(true);
				preDao.setConditionInfoCode("=", c.getInfoCode());
				BasePreProject preBean = preDao.executeQueryOneRow();
				if(null != preBean) {
					preProjectId = preBean.getPreProjectId();
					return preProjectId;
				}
			}
		}
		return null; 
	}
	
	private int[] generateIntArrBySet(Set<Integer> set) {
		if(null == set || set.isEmpty()) {
			return new int[0];
		}
		int size = set.size();
		int[] arr = new int[size];
		int i = 0;
		for(Integer id : set) {
			arr[i++] = id;
		}
		return arr;
	}
	
	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		ConditionContractStatus condition = new ConditionContractStatus();
		condition.setContractLogId(businessId);
		QueryContractStatus query = new QueryContractStatus();
		BaseCollection<BaseContractStatus> bc = query.executeQuery(null, condition);
		if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
			return bc.getCollections().get(0).toJSON();
		}
		return null;
	}

}
