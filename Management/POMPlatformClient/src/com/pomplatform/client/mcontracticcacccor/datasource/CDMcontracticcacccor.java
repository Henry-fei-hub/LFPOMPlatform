package com.pomplatform.client.mcontracticcacccor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcontracticcacccor extends DataSource
{


	public static CDMcontracticcacccor instance = null;

	public static CDMcontracticcacccor getInstance() {
		if(instance == null) {
			instance = new CDMcontracticcacccor("CDMcontracticcacccor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField contractNameField;

	public CDMcontracticcacccor(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

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


		setFields(contractIdField, contractCodeField, customerNameField, contractNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

