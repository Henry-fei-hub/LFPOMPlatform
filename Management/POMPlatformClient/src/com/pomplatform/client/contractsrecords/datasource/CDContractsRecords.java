package com.pomplatform.client.contractsrecords.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDContractsRecords extends DataSource
{


	public static CDContractsRecords instance = null;

	public static CDContractsRecords getInstance() {
		if(instance == null) {
			instance = new CDContractsRecords("CDContractsRecords");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField registerEmployeeField;
	private final DataSourceTextField relevantEmployeesField;
	private final DataSourceTextField relevantEmployeesNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceDateTimeField trackDateStartField;
	private final DataSourceDateTimeField trackDateEndField;
	private final DataSourceIntegerField trackTypeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameField;

	public CDContractsRecords(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同ID");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(true);
		contractNameField.setLength(128);
		contractNameField.setHidden(false);

		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setRequired(true);
		contractAmountField.setLength(128);
		contractAmountField.setHidden(false);

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同签订状态");
		contractStatusField.setRequired(true);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(true);
		remarkField.setLength(128);
		remarkField.setHidden(false);

		registerEmployeeField = new DataSourceIntegerField("registerEmployee", "登记人");
		registerEmployeeField.setRequired(true);
		registerEmployeeField.setLength(11);
		registerEmployeeField.setHidden(false);

		relevantEmployeesField = new DataSourceTextField("relevantEmployees", "相关人员ID");
		relevantEmployeesField.setRequired(true);
		relevantEmployeesField.setLength(128);
		relevantEmployeesField.setHidden(false);

		relevantEmployeesNameField = new DataSourceTextField("relevantEmployeesName", "相关人员名称");
		relevantEmployeesNameField.setRequired(true);
		relevantEmployeesNameField.setLength(128);
		relevantEmployeesNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(true);
		customerNameField.setLength(128);
		customerNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(true);
		contractCodeField.setLength(128);
		contractCodeField.setHidden(false);

		trackDateStartField = new DataSourceDateTimeField("trackDateStart", "跟踪开始日期");
		trackDateStartField.setRequired(true);
		trackDateStartField.setHidden(false);

		trackDateEndField = new DataSourceDateTimeField("trackDateEnd", "跟踪结束日期");
		trackDateEndField.setRequired(true);
		trackDateEndField.setHidden(false);

		trackTypeField = new DataSourceIntegerField("trackType", "跟踪类型");
		trackTypeField.setRequired(true);
		trackTypeField.setLength(128);
		trackTypeField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(true);
		infoCodeField.setLength(15);
		infoCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

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


		setFields(contractIdField, contractNameField, contractAmountField, contractStatusField, remarkField, registerEmployeeField, relevantEmployeesField, relevantEmployeesNameField, customerNameField, contractCodeField, trackDateStartField, trackDateEndField, trackTypeField, infoCodeField, projectNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

