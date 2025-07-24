package com.pomplatform.client.scapitaldistributionor.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.scapitaldistributionor.datasource.CDCapitalDistributionsPoolOfWorkflow;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CapitalDistributionsPoolOfWorkflowSearchForm extends SearchForm {

	private final TextItem statusItem;
	private final TextItem processTypeItem;
	private final TextItem employeeIdItem;
	private final TextItem companyIdItem;
	private final TextItem contractNameItem;
	private final TextItem borrowMoneyItem;
	private final TextItem customerNameItem;
	private final TextItem titleItem;
	private final TextItem otherNameItem;
	private final TextItem departmentIdItem;
	private final TextItem codeItem;

	public CapitalDistributionsPoolOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDistributionsPoolOfWorkflow.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.hide();

		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();

		employeeIdItem = new TextItem("employeeId", "处理人");
		employeeIdItem.hide();

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();

		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");

		borrowMoneyItem = new TextItem("borrowMoney", "回款金额");
		borrowMoneyItem.setWidth("*");

		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");

		titleItem = new TextItem("title", "主题");
		titleItem.setWidth("*");

		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		otherNameItem.setWidth("*");

		departmentIdItem = new TextItem("departmentId", "归属公司");
		departmentIdItem.hide();

		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");

		setItems(statusItem, processTypeItem, employeeIdItem, companyIdItem, contractNameItem, borrowMoneyItem,
				customerNameItem, titleItem, otherNameItem, departmentIdItem, codeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
