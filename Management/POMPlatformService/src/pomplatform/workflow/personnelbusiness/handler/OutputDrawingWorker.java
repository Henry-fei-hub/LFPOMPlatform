package pomplatform.workflow.personnelbusiness.handler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.SystemDictionary;

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
import pomplatform.workflow.bean.BaseGetMainProEmpByProject;
import pomplatform.workflow.bean.ConditionGetMainProEmpByProject;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.query.QueryGetMainProEmpByProject;

public class OutputDrawingWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dataValidate(dao, false);
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
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				bean.setIsCompleted(true);
			}
		}
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dataValidate(dao, true);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		if(expression.contains("出图类型")) {
			if(null == bean.getType()) {
				e.setValue("出图类型", "");
			}else {
				SystemDictionary dicDao = new SystemDictionary();
				dicDao.unsetSelectFlags();
				dicDao.setSelectDicTypeValue(true);
				dicDao.setConditionDicTypeId("=", 239);
				dicDao.setConditionDicTypeValueId("=", bean.getType());
				BaseSystemDictionary dicBean = dicDao.executeQueryOneRow();
				if(null == dicBean || null == dicBean.getDicTypeValue()) {
					e.setValue("出图类型", "");
				}else {
					e.setValue("出图类型", dicBean.getDicTypeValue());
				}
			}
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		if(null != roleId){
			if(roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)) {
				//校对人
				if(null != bean.getLinkId()){
					return new int[] {bean.getLinkId()};
				}else{
					return new int[0];
				}
			}else if(roleId.equals(StaticUtils.ROLE_OUTPUT_DRAWING_REVIEWER)) {
				//审核人
				if(null != bean.getNextAuditor()){
					return new int[] {bean.getNextAuditor()};
				}else{
					return new int[0];
				}
			}else if(roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_SECRETARY) || roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_MANAGER) || 
					roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_PERSON_IN_CHARGE)) {
				//项目秘书
				MainProject mp =new MainProject();
				MainProjectEmployee mpe =new MainProjectEmployee();
				mp.setConditionMainProjectId("=", bean.getProjectId());
				mp.setMainProjectId(bean.getProjectId());
				if(mp.load()) {
					mpe.setConditionMainProjectId("=", bean.getProjectId());
					if(roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_SECRETARY)) {
						mpe.setConditionRelation("=",StaticUtils.RELATION_1);
					}else if(roleId.equals(StaticUtils.ROLE_MAIN_PROJECT_MANAGER)) {
						mpe.setConditionRelation("=",StaticUtils.RELATION_3);
					}else {
						mpe.setConditionRelation("=",StaticUtils.RELATION_5);
					}
					
					List<BaseMainProjectEmployee> list = mpe.conditionalLoad();
					if(null == list || list.size()<=0) {
						return new int[0];
					}else {
						int size = list.size();
						int[] arr = new int[size];
						for(int i = 0; i < size; i++) {
							arr[i] = list.get(i).getEmployeeId();
						}
						return arr;
					}
				}else {
					return new int[0];
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
		return dao.generateBase().toJSON();
	}

	private void dataValidate(PersonnelBusines dao, boolean isUpdate) throws Exception{
		if(BaseHelpUtils.isNullOrZero(dao.getProcessType())){
			throw new Exception("流程类型错误");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getEmployeeId())){
			throw new Exception("申请人不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getEmployeeNo())){
			throw new Exception("工号不能为空");
		}
		if(BaseHelpUtils.isNullOrZero(dao.getDepartmentId())){
			throw new Exception("部门不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getType())){
			throw new Exception("出图类型不能为空");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getProjectId()) || BaseHelpUtils.isNullOrEmpty(dao.getProjectCode()) || BaseHelpUtils.isNullOrEmpty(dao.getProjectName())) {
			throw new Exception("请填选出图的项目信息");
		}
//		if(Objects.equals(dao.getType(), StaticUtils.OUTPUT_DRAWING_TYPE_3)) {
//			if(BaseHelpUtils.isNullOrEmpty(dao.getSubTypeStr())) {
//				throw new Exception("请填写“替换原变更号”");
//			}
//		}

		if(Objects.equals(dao.getType(), StaticUtils.OUTPUT_DRAWING_TYPE_3) || Objects.equals(dao.getType(), StaticUtils.OUTPUT_DRAWING_TYPE_4)) {
			if(BaseHelpUtils.isNullOrEmpty(dao.getSubType())) {
				throw new Exception("请填写变更编号");
			}

			if(BaseHelpUtils.isNullOrEmpty(dao.getReason())) {
				throw new Exception("变更内容描述不能为空");
			}
			if(Objects.equals(dao.getType(), StaticUtils.OUTPUT_DRAWING_TYPE_3)) {
				if(BaseHelpUtils.getIntValue(dao.getTargetProvince()) <= 0) {
					throw new Exception("图纸份数必须大于0");
				}
				if(null == dao.getIsRemoteCity()) {
					throw new Exception("请勾选是否盖章签名");
				}
			}
		}else if(Objects.equals(dao.getType(), StaticUtils.OUTPUT_DRAWING_TYPE_1) || Objects.equals(dao.getType(), StaticUtils.OUTPUT_DRAWING_TYPE_2)) {
			if(BaseHelpUtils.isNullOrEmpty(dao.getReason())) {
				throw new Exception("请填写出图目的");
			}
			if(Objects.equals(dao.getType(), StaticUtils.OUTPUT_DRAWING_TYPE_1)) {
				if(BaseHelpUtils.getIntValue(dao.getTargetProvince()) <= 0) {
					throw new Exception("图纸份数必须大于0");
				}
				if(null == dao.getIsRemoteCity()) {
					throw new Exception("请勾选是否盖章签名");
				}
			}
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getProjectType())) {
			throw new Exception("请选择项目专业");
		}
		if(BaseHelpUtils.getIntValue(dao.getCompanyProvince()) <= 0) {
			throw new Exception("图纸张数必须大于0");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getStartDate())){
			throw new Exception("请填写出图日期");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getStartDateDetail())) {
			throw new Exception("请选择版本");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getLinkId())) {
			throw new Exception("请选择校对人");
		}
		if(BaseHelpUtils.isNullOrEmpty(dao.getNextAuditor())) {
			throw new Exception("请选择审核人");
		}
	}
}
