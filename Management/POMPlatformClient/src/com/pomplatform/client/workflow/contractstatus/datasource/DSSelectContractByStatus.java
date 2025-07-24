package com.pomplatform.client.workflow.contractstatus.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSelectContractByStatus extends DBDataSource
{


	public static DSSelectContractByStatus instance = null;

	public static DSSelectContractByStatus getInstance() {
		if(instance == null) {
			instance = new DSSelectContractByStatus("DSSelectContractByStatus");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField contractMonthField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;

	public DSSelectContractByStatus(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SelectContractByStatus");


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractMonthField = new DataSourceIntegerField("contractMonth", "合同状态至今的月份数");
		contractMonthField.setLength(11);
		contractMonthField.setRequired(true);
		contractMonthField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		setFields(contractIdField, contractMonthField, contractCodeField, contractNameField);
	}


}

