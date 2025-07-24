package pomplatform.projectstageauditinfo.handler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAttachment;
import com.pomplatform.db.dao.ProjectLinkAttachmentRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.projectstageauditinfo.bean.BaseGetApproveTimeAndDepIdByProjectId;
import pomplatform.projectstageauditinfo.bean.ConditionGetApproveTimeAndDepIdByProjectId;
import pomplatform.projectstageauditinfo.query.QueryGetApproveTimeAndDepIdByProjectId;

public class ProjectStageAuditInfoWorker implements GenericWorkflowProcessor {
	private static final Logger __logger = Logger.getLogger("");
	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setCompanyId(BaseHelpUtils.getIntValue(params.get("contractId")));
		bean.setProjectId(BaseHelpUtils.getIntValue(params.get("projectId")));
		bean.setStageId(BaseHelpUtils.getIntValue(params.get("stageId")));
		bean.setContactPerson(BaseHelpUtils.getString(params.get("contractCode")));
		bean.setUnit(BaseHelpUtils.getString(params.get("contractName")));
		bean.setProjectCode(BaseHelpUtils.getString(params.get("sheetCode")));
		bean.setProjectName(BaseHelpUtils.getString(params.get("sheetName")));
		bean.setRemark(BaseHelpUtils.getString(params.get("remark")));
		bean.setEmployeeId(BaseHelpUtils.getIntValue(params.get("operateEmployeeId")));
		bean.setStartDate(new Date(BaseHelpUtils.getLongValue(params.get("operateTime"))));
		bean.setEndDate(new Date(BaseHelpUtils.getLongValue(params.get("uploadTime"))));
		bean.setLinkId(BaseHelpUtils.getIntValue(params.get("attachmentManageId")));
		bean.setPlan(BaseHelpUtils.getString(params.get("attachmentCode")));
		bean.setReason(BaseHelpUtils.getString(params.get("attachmentName")));
		bean.setAddress(BaseHelpUtils.getString(params.get("attachmentAddress")));
		bean.setAttachment(BaseHelpUtils.getString(params.get("attachmentFile")));
		bean.setProcessType(BaseHelpUtils.getIntValue(pd.getProcessTypeId()));
		bean.setDepartmentId(BaseHelpUtils.getIntValue(params.get("departmentId")));
		bean.setEmployeeNo(BaseHelpUtils.getString(params.get("employeeNo")));
		bean.setDrafter(BaseHelpUtils.getIntValue(params.get("drafter")));
		bean.setIsCompleted(true);//已发起流程
		int projectId=BaseHelpUtils.getIntValue(params.get("projectId"));
		int currentStageId=BaseHelpUtils.getIntValue(params.get("stageId"));
		PersonnelBusines  dao=new PersonnelBusines();
		boolean isCompleted=false;
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		dao.setConditionProjectId("=", projectId);
		dao.setConditionStageId("=", currentStageId);
		if(dao.countRows()<=0) {
			dao.clear();
			dao.setDataFromBase(bean);
			dao.save();
		}else {
			List<BasePersonnelBusines> list=dao.conditionalLoad();
			for (BasePersonnelBusines basePersonnelBusines : list) {
				isCompleted=basePersonnelBusines.getIsCompleted();
				if(isCompleted==true) {
					break;
				}
			}
			if(isCompleted==true) {
				throw new Exception("确认函在流程审批中或已通过审批,不能再申请");
			}else {
				dao.clear();
				dao.setDataFromBase(bean);
				dao.save();
			}
		}

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
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){//完成
				ProjectLinkAttachmentRecord parDao=new ProjectLinkAttachmentRecord();
				parDao.setContractId(bean.getCompanyId());
				parDao.setProjectId(bean.getProjectId());
				parDao.setStageId(bean.getStageId());
				parDao.setContractCode(bean.getContactPerson());
				parDao.setContractName(bean.getUnit());
				parDao.setSheetCode(bean.getProjectCode());
				parDao.setSheetName(bean.getProjectName());
				parDao.setRemark(bean.getRemark());
				parDao.setOperateEmployeeId(bean.getEmployeeId());
				parDao.setOperateTime(new Date());
				parDao.setUploadTime(bean.getEndDate());
				parDao.setAttachmentCode(bean.getPlan());
				parDao.setAttachmentAddress(bean.getAddress());
				parDao.setAttachmentManageId(bean.getLinkId());
				parDao.setAttachmentName(bean.getReason());
				parDao.save();


				ProjectAttachment paDao=new ProjectAttachment();
				paDao.setProjectId(bean.getProjectId());
				paDao.setStageId(bean.getStageId());
				paDao.setUploadTime(bean.getEndDate());
				paDao.setAttachmentFile(bean.getAttachment());
				paDao.setRemark(bean.getRemark());
				paDao.setOperateEmployeeId(bean.getEmployeeId());
				paDao.setOperateTime(new Date());
				paDao.save();

			}
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){//驳回
				dao.setIsCompleted(false);
			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		Integer status = null;
		if(expression.indexOf("立项时间") >= 0) {
			ConditionGetApproveTimeAndDepIdByProjectId condition = new ConditionGetApproveTimeAndDepIdByProjectId();
			condition.setProjectId(bean.getProjectId());
			QueryGetApproveTimeAndDepIdByProjectId query = new QueryGetApproveTimeAndDepIdByProjectId();
			BaseCollection<BaseGetApproveTimeAndDepIdByProjectId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
				BaseGetApproveTimeAndDepIdByProjectId bean = bc.getCollections().get(0);
				status = BaseHelpUtils.getIntValue(bean.getContractSigningStatus());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				e.setValue("立项时间", null == bean.getProjectApprovalTime() ? "" : format.format(bean.getProjectApprovalTime()));
			}
		}
		if(expression.indexOf("合同签订状态") >= 0) {
			if(null == status) {
				ConditionGetApproveTimeAndDepIdByProjectId condition = new ConditionGetApproveTimeAndDepIdByProjectId();
				condition.setProjectId(bean.getProjectId());
				QueryGetApproveTimeAndDepIdByProjectId query = new QueryGetApproveTimeAndDepIdByProjectId();
				BaseCollection<BaseGetApproveTimeAndDepIdByProjectId> bc = query.executeQuery(null, condition);
				if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
					BaseGetApproveTimeAndDepIdByProjectId bean = bc.getCollections().get(0);
					status = BaseHelpUtils.getIntValue(bean.getContractSigningStatus());
				}
			}
			String statusStr = null;
			if(status.intValue() == 1) {
				statusStr = "未签订";
			}else if(status.intValue() == 2) {
				statusStr = "已签订";
			}else {
				statusStr = "";
			}
			e.setValue("合同签订状态", statusStr);
		}
		return ProcessUtil.executeExpression(e, expression);
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
		}else if(null != roleId && Objects.equals(roleId, StaticUtils.ROLE_67)){
			//节点的角色为总监，则需要找到所在前期项目的项目营销团队的总监
			ConditionGetApproveTimeAndDepIdByProjectId condition = new ConditionGetApproveTimeAndDepIdByProjectId();
			condition.setProjectId(bean.getProjectId());
			QueryGetApproveTimeAndDepIdByProjectId query = new QueryGetApproveTimeAndDepIdByProjectId();
			BaseCollection<BaseGetApproveTimeAndDepIdByProjectId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
				BaseGetApproveTimeAndDepIdByProjectId bean = bc.getCollections().get(0);
				if(null != bean.getDepartmentId()) {
					EmployeeRole erDao = new EmployeeRole();
					erDao.setConditionDepartmentId("=", bean.getDepartmentId());
					erDao.setConditionRoleId("=", StaticUtils.ROLE_67);
					erDao.unsetSelectFlags();
					erDao.setSelectEmployeeId(true);
					List<BaseEmployeeRole> erList = erDao.conditionalLoad();
					int size = erList.size();
					int[] arr = new int[size];
					for(int i = 0; i < size; i++) {
						arr[i] = erList.get(i).getEmployeeId();
					}
					return arr;
				}
			}
			return new int[0];
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

}
