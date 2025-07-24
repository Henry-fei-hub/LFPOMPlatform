package com.pomplatform.client.scapitaldistributionor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCapitalDistributionsApplyOfWorkflow extends DataSource
{


	public static CDCapitalDistributionsApplyOfWorkflow instance = null;

	public static CDCapitalDistributionsApplyOfWorkflow getInstance() {
		if(instance == null) {
			instance = new CDCapitalDistributionsApplyOfWorkflow("CDCapitalDistributionsApplyOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField titleField;
	private final DataSourceTextField otherNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField codeField;

	public CDCapitalDistributionsApplyOfWorkflow(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setRequired(false);
		businessIdField.setLength(11);
		businessIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "报销人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "借（增加）");
		borrowMoneyField.setRequired(true);
		borrowMoneyField.setLength(16);
		borrowMoneyField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		titleField = new DataSourceTextField("title", "主题");
		titleField.setRequired(false);
		titleField.setLength(255);
		titleField.setHidden(false);

		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setRequired(false);
		otherNameField.setLength(128);
		otherNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "报销部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setRequired(false);
		codeField.setLength(64);
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


		setFields(processTypeField, businessIdField, employeeIdField, companyIdField, contractNameField, borrowMoneyField, customerNameField, titleField, otherNameField, departmentIdField, codeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

