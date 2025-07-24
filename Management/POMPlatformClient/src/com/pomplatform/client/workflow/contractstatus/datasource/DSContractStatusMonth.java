package com.pomplatform.client.workflow.contractstatus.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractStatusMonth extends DBDataSource
{


	public static DSContractStatusMonth instance = null;

	public static DSContractStatusMonth getInstance() {
		if(instance == null) {
			instance = new DSContractStatusMonth("DSContractStatusMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField contractMonthField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceTextField departmentLeaderField;

	public DSContractStatusMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractStatusMonth");


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));


		contractMonthField = new DataSourceIntegerField("contractMonth", "月份数");
		contractMonthField.setLength(11);
		contractMonthField.setRequired(true);
		contractMonthField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentLeaderField = new DataSourceTextField("departmentLeader", "报备人所在部门负责人");
		departmentLeaderField.setLength(-1);
		departmentLeaderField.setRequired(true);
		departmentLeaderField.setHidden(false);


		setFields(contractIdField, contractMonthField, contractCodeField, contractNameField, applyEmployeeIdField, departmentLeaderField);
	}


}

