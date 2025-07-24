package pomplatform.workflow.contractstatus.handler;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.pomplatform.db.bean.BaseContractLog;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractLog;
import com.pomplatform.db.dao.Employee;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PreProject;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.common.KeyValuePair;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.workflow.contractstatus.bean.BaseContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatus;
import pomplatform.workflow.contractstatus.query.QueryContractStatus;
import pomplatform.workflow.contractstatus.utils.ContractStatusUtils;

public class PauseProjectWorker implements GenericWorkflowProcessor {

	protected BaseContractLog bean = new BaseContractLog();
	private Integer preProjectId = null;

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		ContractLog dao = new ContractLog();
		dao.setDataFromBase(bean);
		dao.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_NEW_CREATED);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getContractLogId(), "");
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getAttachmentId());
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
				//流程顺利完成，合同改为项目暂停状态，相关的订单修改为订单暂停状态
				ContractStatusUtils util = new ContractStatusUtils();
				util.updateContractAndProjectStatus(dao.getContractId(), dao.getNewStatus());
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
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
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
