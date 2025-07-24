package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.attachment.handler.CustomAttachmentWorkProcess;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.workflow.business.OnWrokflowProcess;

public class AttachmentApplyWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		if(null != bean.getProjectId()) {
			Contract cDao = new Contract();
			cDao.unsetSelectFlags();
			cDao.setSelectContractCode(true);
			cDao.setSelectContractName(true);
			cDao.setContractId(bean.getProjectId());
			if(cDao.load()) {
				bean.setProjectName(cDao.getContractName());
				bean.setProjectCode(cDao.getContractCode());
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao);
		dao.save();
		boolean testProcessor = BaseHelpUtils.getBoolean(params.get(StaticUtils.TEST_PROCESSOR));
		//如果是测试流程，就不走下面的方法
		if(!testProcessor) {
			params.put("personnelBusinessId", dao.getPersonnelBusinessId());
			CustomAttachmentWorkProcess.bindAttachment(params, false);
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		//增加附件的引用次数
		FileManageProcessor.addTimesById(bean.getNumberOfBaby());
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		int activityType = 0;
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
			activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			//只有处理节点才可以更改数据
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
				return null;
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		ColumnChangedData contractIdChange = dao.getColumnChangedData(BasePersonnelBusines.CS_PROJECT_ID);
		if(null != contractIdChange) {
			if(null != bean.getProjectId()) {
				Contract cDao = new Contract();
				cDao.unsetSelectFlags();
				cDao.setSelectContractCode(true);
				cDao.setSelectContractName(true);
				cDao.setContractId(bean.getProjectId());
				if(cDao.load()) {
					dao.setProjectName(cDao.getContractName());
					dao.setProjectCode(cDao.getContractCode());
				}
			}
		}
		dataValidate(dao);
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BasePersonnelBusines.CS_NUMBER_OF_BABY);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		
		//只有处理节点才允许次操作
		if(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL) {
			CustomAttachmentWorkProcess.bindAttachment(params, true);
		}
		
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setIsCompleted(Boolean.TRUE);
				CustomAttachmentWorkProcess.passAttachmentApply(params);
			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), dao.getReason());
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		e.setValue("天数", bean.getDays() == null ? 0.0 : bean.getDays().doubleValue());
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		if(roleId != null){
			if(Objects.equals(roleId, StaticUtils.ROLE_PROJECT_MANAGER)){
				if(null != bean.getProjectId()){
					Project pDao = new Project();
					pDao.setConditionContractId("=", bean.getProjectId());
					List<BaseProject> pList = pDao.conditionalLoad();
					if(pList.size() > 0){
						Employee e = new Employee();
						Object[] arr = new Object[pList.size()];
						int idx = 0;
						for (BaseProject ber : pList) {
							arr[idx++] = ber.getProjectManageId();
						}
						e.setConditionStatus("=", 0);// 在职人员
						e.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", arr);
						List<BaseEmployee> list = e.conditionalLoad();
						if (null != list && !list.isEmpty()) {
							int size = list.size();
							int[] res = new int[size];
							for (int i = 0; i < size; i++) {
								res[i] = list.get(i).getEmployeeId();
							}
							return res;
						}
					}
				}
			}
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getNumberOfBaby()));
		return dao.generateBase().toJSON();
	}

	private void dataValidate(PersonnelBusines dao) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("申请人不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("工号不能为空");
		}
	}

}
