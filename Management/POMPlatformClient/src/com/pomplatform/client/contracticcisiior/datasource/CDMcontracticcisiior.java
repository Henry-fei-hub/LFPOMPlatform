package com.pomplatform.client.contracticcisiior.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMcontracticcisiior extends DataSource
{


	public static CDMcontracticcisiior instance = null;

	public static CDMcontracticcisiior getInstance() {
		if(instance == null) {
			instance = new CDMcontracticcisiior("CDMcontracticcisiior");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceIntegerField signField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;

	public CDMcontracticcisiior(String dataSourceID) {

		setID(dataSourceID);
		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型");
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setLength(11);
		invoiceTypeField.setHidden(false);

		signField = new DataSourceIntegerField("sign", "发票状态");
		signField.setRequired(false);
		signField.setLength(11);
		signField.setHidden(false);

		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码");
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setLength(64);
		invoiceCodeField.setHidden(false);

		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setLength(64);
		invoiceNumberField.setHidden(false);

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


		setFields(contractIdField, contractCodeField, contractNameField, invoiceTypeField, signField, invoiceCodeField, invoiceNumberField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

