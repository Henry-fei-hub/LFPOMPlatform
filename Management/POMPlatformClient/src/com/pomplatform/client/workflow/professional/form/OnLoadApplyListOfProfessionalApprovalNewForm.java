package com.pomplatform.client.workflow.professional.form;

import java.util.*;

import com.pomplatform.client.workflow.professional.datasource.DSOnLoadApplyListOfProfessionalApproval;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;

public class OnLoadApplyListOfProfessionalApprovalNewForm extends AbstractWizadPage
{


	private final TextItem businessIdItem;
	private final TextItem businessNameItem;
	private final TextItem processIdItem;
	private final TextItem processInstanceActivityIdItem;
	private final TextItem processStatusItem;
	private final DateTimeItem completeTimeItem;
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

	public OnLoadApplyListOfProfessionalApprovalNewForm() {
		DSOnLoadApplyListOfProfessionalApproval ds = DSOnLoadApplyListOfProfessionalApproval.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		businessIdItem = new TextItem("businessId", "业务编码");
		__formItems.add(businessIdItem);
		businessNameItem = new TextItem("businessName", "业务名称");
		__formItems.add(businessNameItem);
		processIdItem = new TextItem("processId", "流程编码");
		__formItems.add(processIdItem);
		processInstanceActivityIdItem = new TextItem("processInstanceActivityId", "活动实列编码");
		__formItems.add(processInstanceActivityIdItem);
		processStatusItem = new TextItem("processStatus", "流程状态 0 发起中  1");
		__formItems.add(processStatusItem);
		completeTimeItem = new DateTimeItem("completeTime", "完成时间");
		__formItems.add(completeTimeItem);
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
		projectIdItem = new TextItem("projectId", "项目编码");
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
		projectTypeItem = new TextItem("projectType", "项目类别");
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

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOnLoadApplyListOfProfessionalApproval.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map getValuesAsMap() {
		return __form.getValues();
	}


}
