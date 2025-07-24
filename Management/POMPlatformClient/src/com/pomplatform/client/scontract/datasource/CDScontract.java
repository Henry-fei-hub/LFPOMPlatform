package com.pomplatform.client.scontract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScontract extends DataSource
{


	public static CDScontract instance = null;

	public static CDScontract getInstance() {
		if(instance == null) {
			instance = new CDScontract("CDScontract");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceTextField clientContractIdField;

	public CDScontract(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(32);
		infoCodeField.setHidden(false);

		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setRequired(false);
		contractStatusField.setLength(11);
		contractStatusField.setHidden(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		clientContractIdField = new DataSourceTextField("clientContractId", "客户合同编号");
		clientContractIdField.setRequired(false);
		clientContractIdField.setLength(64);
		clientContractIdField.setHidden(false);

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


		setFields(contractCodeField, contractNameField, infoCodeField, contractStatusField, clientContractIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

