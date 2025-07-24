package com.pomplatform.client.projectteambuild.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.projectteambuild.datasource.DSSprojectteambuild;

public class SprojectteambuildNewForm extends AbstractWizadPage
{


	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem customerNameItem;
	private final TextItem workHoursItem;
	private final TextItem departmentIdItem;
	private final TextItem designPhaseItem;
	private final TextItem projectTypeItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final DateItem planStartDateItem;
	private final DateItem planEndDateItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem statusItem;
	private final TextItem projectProgressItem;
	private final TextItem projectManageIdItem;
	private final TextItem projectManageNameItem;
	private final TextItem projectSizeItem;
	private final TextItem projectIntegralItem;
	private final TextItem projectDescriptionItem;
	private final TextItem budgetItem;
	private final TextItem auditReasonItem;
	private final TextItem projectLevelItem;

	public SprojectteambuildNewForm() {
		__form = new DynamicForm();
		DSSprojectteambuild ds = DSSprojectteambuild.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		workHoursItem = new TextItem("workHours", "预估工时");
		workHoursItem.setWidth("*");
		departmentIdItem = new TextItem("departmentId", "归属部门");
		departmentIdItem.setWidth("*");
		designPhaseItem = new TextItem("designPhase", "设计阶段");
		designPhaseItem.setWidth("*");
		projectTypeItem = new TextItem("projectType", "项目类型");
		projectTypeItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		planStartDateItem = new DateItem("planStartDate", "项目计划开始日期");
		planEndDateItem = new DateItem("planEndDate", "项目计划结束日期");
		startDateItem = new DateItem("startDate", "项目开始日期");
		endDateItem = new DateItem("endDate", "项目结束日期");
		statusItem = new TextItem("status", "项目状态");
		statusItem.setWidth("*");
		projectProgressItem = new TextItem("projectProgress", "项目进度");
		projectProgressItem.setWidth("*");
		projectManageIdItem = new TextItem("projectManageId", "项目负责人编码");
		projectManageIdItem.setWidth("*");
		projectManageNameItem = new TextItem("projectManageName", "项目负责人姓名");
		projectManageNameItem.setWidth("*");
		projectSizeItem = new TextItem("projectSize", "项目大小");
		projectSizeItem.setWidth("*");
		projectIntegralItem = new TextItem("projectIntegral", "项目积分");
		projectIntegralItem.setWidth("*");
		projectDescriptionItem = new TextItem("projectDescription", "项目描述");
		projectDescriptionItem.setWidth("*");
		budgetItem = new TextItem("budget", "预算");
		budgetItem.setWidth("*");
		auditReasonItem = new TextItem("auditReason", "审核意见");
		auditReasonItem.setWidth("*");
		projectLevelItem = new TextItem("projectLevel", "项目等级");
		projectLevelItem.setWidth("*");

		__form.setItems(contractCodeItem, contractNameItem, customerNameItem, workHoursItem, departmentIdItem, designPhaseItem, projectTypeItem, projectCodeItem, projectNameItem, planStartDateItem, planEndDateItem, startDateItem, endDateItem, statusItem, projectProgressItem, projectManageIdItem, projectManageNameItem, projectSizeItem, projectIntegralItem, projectDescriptionItem, budgetItem, auditReasonItem, projectLevelItem);

		__form.setDataSource(ds);
		__form.setNumCols(4);
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
		manager.setDataSource(DSSprojectteambuild.getInstance());
		manager.addMember(__form);
	}

	@Override
	public Map<String, FormItem> getItems() {
		Map<String, FormItem> res = new HashMap<String, FormItem>();
		res.put("contractCode", contractCodeItem);
		res.put("contractName", contractNameItem);
		res.put("customerName", customerNameItem);
		res.put("workHours", workHoursItem);
		res.put("departmentId", departmentIdItem);
		res.put("designPhase", designPhaseItem);
		res.put("projectType", projectTypeItem);
		res.put("projectCode", projectCodeItem);
		res.put("projectName", projectNameItem);
		res.put("planStartDate", planStartDateItem);
		res.put("planEndDate", planEndDateItem);
		res.put("startDate", startDateItem);
		res.put("endDate", endDateItem);
		res.put("status", statusItem);
		res.put("projectProgress", projectProgressItem);
		res.put("projectManageId", projectManageIdItem);
		res.put("projectManageName", projectManageNameItem);
		res.put("projectSize", projectSizeItem);
		res.put("projectIntegral", projectIntegralItem);
		res.put("projectDescription", projectDescriptionItem);
		res.put("budget", budgetItem);
		res.put("auditReason", auditReasonItem);
		res.put("projectLevel", projectLevelItem);
		return res;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

	private DynamicForm __form;

}
