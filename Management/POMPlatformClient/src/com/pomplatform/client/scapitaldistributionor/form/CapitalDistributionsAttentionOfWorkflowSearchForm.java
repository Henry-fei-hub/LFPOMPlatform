package com.pomplatform.client.scapitaldistributionor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.scapitaldistributionor.datasource.CDCapitalDistributionsAttentionOfWorkflow;

public class CapitalDistributionsAttentionOfWorkflowSearchForm extends SearchForm
{


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

	public CapitalDistributionsAttentionOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDistributionsAttentionOfWorkflow.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		processTypeItem = new TextItem("processType", "流程类型");
		employeeIdItem = new TextItem("employeeId", "处理人");
		companyIdItem = new TextItem("companyId", "归属公司");
		contractNameItem = new TextItem("contractName", "合同名称");
		borrowMoneyItem = new TextItem("borrowMoney", "回款金额");
		customerNameItem = new TextItem("customerName", "客户名称");
		titleItem = new TextItem("title", "主题");
		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		departmentIdItem = new TextItem("departmentId", "归属公司");
		codeItem = new TextItem("code", "编号");

		setItems(statusItem, processTypeItem, employeeIdItem, companyIdItem, contractNameItem, borrowMoneyItem, customerNameItem, titleItem, otherNameItem, departmentIdItem, codeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
