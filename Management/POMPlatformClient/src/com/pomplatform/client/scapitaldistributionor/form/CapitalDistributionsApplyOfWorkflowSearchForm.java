package com.pomplatform.client.scapitaldistributionor.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.scapitaldistributionor.datasource.CDCapitalDistributionsApplyOfWorkflow;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CapitalDistributionsApplyOfWorkflowSearchForm extends SearchForm {

	private final TextItem processTypeItem;
	private final TextItem businessIdItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem companyIdItem;
	private final TextItem contractNameItem;
	private final TextItem borrowMoneyItem;
	private final TextItem customerNameItem;
	private final TextItem titleItem;
	private final TextItem otherNameItem;
	private final TextItem departmentIdItem;
	private final TextItem codeItem;

	public CapitalDistributionsApplyOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDistributionsApplyOfWorkflow.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		businessIdItem = new TextItem("businessId", "业务编码");
		businessIdItem.hide();
		employeeIdItem = new ComboBoxItem("employeeId", "发起人");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.hide();

		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();

		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");

		borrowMoneyItem = new TextItem("borrowMoney", "借（增加）");
		borrowMoneyItem.setWidth("*");
		borrowMoneyItem.hide();

		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");

		titleItem = new TextItem("title", "主题");
		titleItem.setWidth("*");

		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		otherNameItem.setWidth("*");

		departmentIdItem = new TextItem("departmentId", "报销部门");
		departmentIdItem.hide();

		codeItem = new TextItem("code", "报销编号");
		codeItem.setWidth("*");

		setItems(processTypeItem, businessIdItem, employeeIdItem, companyIdItem, contractNameItem, borrowMoneyItem,
				customerNameItem, titleItem, otherNameItem, departmentIdItem, codeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
