package com.pomplatform.client.scapitaldistributionor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCapitalDistributionsPoolOfWorkflow extends DataSource
{


	public static CDCapitalDistributionsPoolOfWorkflow instance = null;

	public static CDCapitalDistributionsPoolOfWorkflow getInstance() {
		if(instance == null) {
			instance = new CDCapitalDistributionsPoolOfWorkflow("CDCapitalDistributionsPoolOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField titleField;
	private final DataSourceTextField otherNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField codeField;

	public CDCapitalDistributionsPoolOfWorkflow(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(true);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "回款金额");
		borrowMoneyField.setRequired(true);
		borrowMoneyField.setLength(16);
		borrowMoneyField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		titleField = new DataSourceTextField("title", "主题");
		titleField.setRequired(true);
		titleField.setLength(0);
		titleField.setHidden(false);

		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setRequired(false);
		otherNameField.setLength(128);
		otherNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属公司");
		departmentIdField.setRequired(true);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		codeField = new DataSourceTextField("code", "编号");
		codeField.setRequired(true);
		codeField.setLength(0);
		codeField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(statusField, processTypeField, employeeIdField, companyIdField, contractNameField, borrowMoneyField, customerNameField, titleField, otherNameField, departmentIdField, codeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

