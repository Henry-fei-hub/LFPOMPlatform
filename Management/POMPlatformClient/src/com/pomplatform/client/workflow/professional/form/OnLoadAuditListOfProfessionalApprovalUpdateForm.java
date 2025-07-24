package com.pomplatform.client.workflow.professional.form;

import java.util.*;

import com.pomplatform.client.workflow.professional.datasource.DSOnLoadAuditListOfProfessionalApproval;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;

public class OnLoadAuditListOfProfessionalApprovalUpdateForm extends AbstractWizadPage
{


	private final TextItem processInstanceActivityIdItem;
	private final TextItem businessIdItem;
	private final TextItem businessNameItem;
	private final TextItem processActivityIdItem;
	private final TextItem processIdItem;
	private final TextItem processInstanceIdItem;
	private final TextItem nodeTypeItem;
	private final TextItem activityIdItem;
	private final TextItem nextActivityIdItem;
	private final TextItem mainActivityIdItem;
	private final DateTimeItem instanceActivityCreateTimeItem;
	private final DateTimeItem instanceActivityStartTimeItem;
	private final DateTimeItem operateTimeItem;
	private final TextItem processCommentItem;
	private final TextItem statusItem;
	private final TextItem activityTypeItem;
	private final TextItem backViewNameItem;
	private final TextItem professionalApproval_idItem;
	private final SelectItem employeeIdItem;
	private final SelectItem employeeNoItem;
	private final DateTimeItem startDateItem;
	private final TextItem deleteFlagItem;
	private final TextItem projectIdItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem contractIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem plateIdItem;
	private final TextItem designTypeItem;
	private final TextItem projectTypeItem;
	private final TextItem plateManagerIdItem;
	private final TextItem projectLevelItem;
	private final TextItem departmentManagerIdItem;
	private final TextItem projectManageIdItem;
	private final TextItem projectManageNameItem;
	private final TextItem projectManageDepartmentIdItem;
	private final TextItem commonAreaItem;
	private final TextItem logisticsAreaItem;
	private final TextItem cadAreaItem;
	private final TextItem totalIntegralItem;
	private final TextItem projectIntegralItem;
	private final TextItem reserveIntegralItem;
	private final TextItem percentageItem;
	private final TextItem empStatusItem;

	public OnLoadAuditListOfProfessionalApprovalUpdateForm() {
		DSOnLoadAuditListOfProfessionalApproval ds = DSOnLoadAuditListOfProfessionalApproval.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		processInstanceActivityIdItem = new TextItem("processInstanceActivityId", "活动实列编码");
		__formItems.add(processInstanceActivityIdItem);
		businessIdItem = new TextItem("businessId", "业务编码");
		__formItems.add(businessIdItem);
		businessNameItem = new TextItem("businessName", "业务名称");
		__formItems.add(businessNameItem);
		processActivityIdItem = new TextItem("processActivityId", "活动编码");
		__formItems.add(processActivityIdItem);
		processIdItem = new TextItem("processId", "流程编码");
		__formItems.add(processIdItem);
		processInstanceIdItem = new TextItem("processInstanceId", "主键编码");
		processInstanceIdItem.setDisabled(true);
		processInstanceIdItem.setRequired(true);
		IsIntegerValidator processInstanceIdValidator = new IsIntegerValidator();
		processInstanceIdItem.setValidators(processInstanceIdValidator);
		__formItems.add(processInstanceIdItem);
		nodeTypeItem = new TextItem("nodeType", "附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人");
		__formItems.add(nodeTypeItem);
		activityIdItem = new TextItem("activityId", "当前流程实例节点的内部编码");
		__formItems.add(activityIdItem);
		nextActivityIdItem = new TextItem("nextActivityId", "下一个流程节点的编码");
		__formItems.add(nextActivityIdItem);
		mainActivityIdItem = new TextItem("mainActivityId", "如果是知会节点，所依附的主节点");
		__formItems.add(mainActivityIdItem);
		instanceActivityCreateTimeItem = new DateTimeItem("instanceActivityCreateTime", "流程实例节点创建时间");
		__formItems.add(instanceActivityCreateTimeItem);
		instanceActivityStartTimeItem = new DateTimeItem("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		__formItems.add(instanceActivityStartTimeItem);
		operateTimeItem = new DateTimeItem("operateTime", "操作时间");
		__formItems.add(operateTimeItem);
		processCommentItem = new TextItem("processComment", "提交意见");
		__formItems.add(processCommentItem);
		statusItem = new TextItem("status", "状态");
		__formItems.add(statusItem);
		activityTypeItem = new TextItem("activityType", "节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会");
		__formItems.add(activityTypeItem);
		backViewNameItem = new TextItem("backViewName", "返回数据集");
		__formItems.add(backViewNameItem);
		professionalApproval_idItem = new TextItem("professionalApproval_id", "专业负责人审批编码");
		professionalApproval_idItem.setDisabled(true);
		professionalApproval_idItem.setRequired(true);
		IsIntegerValidator professionalApproval_idValidator = new IsIntegerValidator();
		professionalApproval_idItem.setValidators(professionalApproval_idValidator);
		__formItems.add(professionalApproval_idItem);
		employeeIdItem = new SelectItem("employeeId", "创建人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		__formItems.add(employeeIdItem);
		employeeNoItem = new SelectItem("employeeNo", "工号");
		employeeNoItem.setValueMap(KeyValueManager.getValueMap(""));
		__formItems.add(employeeNoItem);
		startDateItem = new DateTimeItem("startDate", "开始日期");
		__formItems.add(startDateItem);
		deleteFlagItem = new TextItem("deleteFlag", "删除状态  0未删除    1已删除");
		__formItems.add(deleteFlagItem);
		projectIdItem = new TextItem("projectId", "项目");
		__formItems.add(projectIdItem);
		projectCodeItem = new TextItem("projectCode", "项目编号");
		__formItems.add(projectCodeItem);
		projectNameItem = new TextItem("projectName", "项目名称");
		__formItems.add(projectNameItem);
		contractIdItem = new TextItem("contractId", "合同编码");
		__formItems.add(contractIdItem);
		contractCodeItem = new TextItem("contractCode", "合同编号");
		__formItems.add(contractCodeItem);
		contractNameItem = new TextItem("contractName", "合同名称");
		__formItems.add(contractNameItem);
		plateIdItem = new TextItem("plateId", "业务部门");
		__formItems.add(plateIdItem);
		designTypeItem = new TextItem("designType", "业务类别");
		__formItems.add(designTypeItem);
		projectTypeItem = new TextItem("projectType", "项目类型 1项目 2前期项目");
		__formItems.add(projectTypeItem);
		plateManagerIdItem = new TextItem("plateManagerId", "事业部负责人");
		__formItems.add(plateManagerIdItem);
		projectLevelItem = new TextItem("projectLevel", "项目等级");
		__formItems.add(projectLevelItem);
		departmentManagerIdItem = new TextItem("departmentManagerId", "部门经理");
		__formItems.add(departmentManagerIdItem);
		projectManageIdItem = new TextItem("projectManageId", "积分管理员");
		__formItems.add(projectManageIdItem);
		projectManageNameItem = new TextItem("projectManageName", "专业负责人");
		__formItems.add(projectManageNameItem);
		projectManageDepartmentIdItem = new TextItem("projectManageDepartmentId", "专业负责人部门");
		__formItems.add(projectManageDepartmentIdItem);
		commonAreaItem = new TextItem("commonArea", "公区面积");
		__formItems.add(commonAreaItem);
		logisticsAreaItem = new TextItem("logisticsArea", "后勤面积");
		__formItems.add(logisticsAreaItem);
		cadAreaItem = new TextItem("cadArea", "设计面积");
		__formItems.add(cadAreaItem);
		totalIntegralItem = new TextItem("totalIntegral", "项目总积分");
		__formItems.add(totalIntegralItem);
		projectIntegralItem = new TextItem("projectIntegral", "项目积分");
		__formItems.add(projectIntegralItem);
		reserveIntegralItem = new TextItem("reserveIntegral", "预留积分");
		__formItems.add(reserveIntegralItem);
		percentageItem = new TextItem("percentage", "核算比例");
		__formItems.add(percentageItem);
		empStatusItem = new TextItem("empStatus", "");
		empStatusItem.setRequired(true);
		IsIntegerValidator empStatusValidator = new IsIntegerValidator();
		empStatusItem.setValidators(empStatusValidator);
		__formItems.add(empStatusItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOnLoadAuditListOfProfessionalApproval.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
