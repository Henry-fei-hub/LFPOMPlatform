package com.pomplatform.client.workflow.contractstatus.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCanEndContractInfo extends DBDataSource
{


	public static DSCanEndContractInfo instance = null;

	public static DSCanEndContractInfo getInstance() {
		if(instance == null) {
			instance = new DSCanEndContractInfo("DSCanEndContractInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public DSCanEndContractInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("ContractStatusProcessor");


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		setFields(contractIdField, contractCodeField, contractNameField);
	}


}

