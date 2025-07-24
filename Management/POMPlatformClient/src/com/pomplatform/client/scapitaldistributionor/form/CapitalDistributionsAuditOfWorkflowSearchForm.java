package com.pomplatform.client.scapitaldistributionor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.scapitaldistributionor.datasource.CDCapitalDistributionsAuditOfWorkflow;

public class CapitalDistributionsAuditOfWorkflowSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final TextItem businessIdItem;
	private final TextItem statusItem;
	private final TextItem employeeIdItem;
	private final TextItem companyIdItem;
	private final TextItem contractNameItem;
	private final TextItem borrowMoneyItem;
	private final TextItem customerNameItem;
	private final TextItem titleItem;
	private final TextItem otherNameItem;
	private final TextItem departmentIdItem;
	private final TextItem codeItem;

	public CapitalDistributionsAuditOfWorkflowSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCapitalDistributionsAuditOfWorkflow.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.hide();
		
		businessIdItem = new TextItem("businessId", "业务编码");
		businessIdItem.hide();
		
		statusItem = new TextItem("status", "状态");
		statusItem.hide();
		
		employeeIdItem = new TextItem("employeeId", "审批操作人");
		employeeIdItem.hide();
		
		companyIdItem = new TextItem("companyId", "归属公司");
		companyIdItem.hide();
		
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		
		borrowMoneyItem = new TextItem("borrowMoney", "回款金额");
		borrowMoneyItem.hide();
		
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		
		titleItem = new TextItem("title", "主题");
		titleItem.setWidth("*");
		
		otherNameItem = new TextItem("otherName", "对方名称(付款方)");
		otherNameItem.setWidth("*");
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.hide();
		
		codeItem = new TextItem("code", "编号");
		codeItem.setWidth("*");

		setItems(processTypeItem, businessIdItem, statusItem, employeeIdItem, companyIdItem, contractNameItem, borrowMoneyItem, customerNameItem, titleItem, otherNameItem, departmentIdItem, codeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
