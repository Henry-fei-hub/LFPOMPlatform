package com.pomplatform.client.contractsrecords.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractsRecords extends DBDataSource
{


	public static DSContractsRecords instance = null;

	public static DSContractsRecords getInstance() {
		if(instance == null) {
			instance = new DSContractsRecords("DSContractsRecords");
		}
		return instance;
	}

	private final DataSourceIntegerField contractsRecordsIdField;
	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField trackDateField;
	private final DataSourceIntegerField registerEmployeeField;
	private final DataSourceDateTimeField registerDateField;
	private final DataSourceTextField relevantEmployeesField;
	private final DataSourceTextField relevantEmployeesNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField trackTypeField;

	public DSContractsRecords(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractsRecords");


		contractsRecordsIdField = new DataSourceIntegerField("contractsRecordsId", "主键id");
		contractsRecordsIdField.setLength(11);
		contractsRecordsIdField.setPrimaryKey(true);
		contractsRecordsIdField.setRequired(true);
		contractsRecordsIdField.setHidden(true);


		preProjectIdField = new DataSourceIntegerField("preProjectId", "主键编码");
		preProjectIdField.setLength(11);
		preProjectIdField.setPrimaryKey(true);
		preProjectIdField.setRequired(true);
		preProjectIdField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("#,###,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);


		contractStatusField = new DataSourceIntegerField("contractStatus", "合同签订状态");
		contractStatusField.setLength(11);
		KeyValueManager.loadValueMap("system_dictionary_139", contractStatusField);
		contractStatusField.setRequired(false);
		contractStatusField.setHidden(false);
		


		remarkField = new DataSourceTextField("remark", "跟踪情况描述");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		trackDateField = new DataSourceDateTimeField("trackDate", "跟踪时间");
		trackDateField.setRequired(false);
		trackDateField.setHidden(false);


		registerEmployeeField = new DataSourceIntegerField("registerEmployee", "登记人");
		KeyValueManager.loadValueMap("employees",registerEmployeeField);
		registerEmployeeField.setLength(11);
		registerEmployeeField.setRequired(false);
		registerEmployeeField.setHidden(false);


		registerDateField = new DataSourceDateTimeField("registerDate", "登记时间");
		registerDateField.setRequired(false);
		registerDateField.setHidden(false);


		relevantEmployeesField = new DataSourceTextField("relevantEmployees", "相关人员");
		relevantEmployeesField.setLength(255);
		relevantEmployeesField.setRequired(false);
		relevantEmployeesField.setHidden(true);


		relevantEmployeesNameField = new DataSourceTextField("relevantEmployeesName", "相关人员名称");
		relevantEmployeesNameField.setLength(1024);
		relevantEmployeesNameField.setRequired(false);
		relevantEmployeesNameField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		trackTypeField = new DataSourceIntegerField("trackType", "跟踪类型");
		trackTypeField.setLength(11);
		trackTypeField.setRequired(false);
		trackTypeField.setHidden(false);
		KeyValueManager.loadValueMap("system_dictionary_209",trackTypeField);


		setFields(contractsRecordsIdField, preProjectIdField, infoCodeField, projectNameField, contractIdField, contractNameField, contractCodeField,trackTypeField,customerNameField,contractAmountField, contractStatusField, remarkField, trackDateField, registerEmployeeField, registerDateField, relevantEmployeesField, relevantEmployeesNameField);
	}


}

