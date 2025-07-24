package com.pomplatform.client.invoiceexpresitssccmisiior.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMinvoiceexpresitssccmisiior extends DataSource
{


	public static CDMinvoiceexpresitssccmisiior instance = null;

	public static CDMinvoiceexpresitssccmisiior getInstance() {
		if(instance == null) {
			instance = new CDMinvoiceexpresitssccmisiior("CDMinvoiceexpresitssccmisiior");
		}
		return instance;
	}

	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField clientNameField;
	private final DataSourceIntegerField courierTypeField;
	private final DataSourceDateTimeField minCourierDateField;
	private final DataSourceDateTimeField maxCourierDateField;
	private final DataSourceDateTimeField minSignDateField;
	private final DataSourceDateTimeField maxSignDateField;
	private final DataSourceTextField telField;
	private final DataSourceIntegerField signStatusField;
	private final DataSourceTextField signNameField;
	private final DataSourceTextField courierNumberField;
	private final DataSourceTextField mailingAddressField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceIntegerField signField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceIntegerField contactIdField;

	public CDMinvoiceexpresitssccmisiior(String dataSourceID) {

		setID(dataSourceID);
		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		clientNameField = new DataSourceTextField("clientName", "联系人姓名");
		clientNameField.setRequired(false);
		clientNameField.setLength(64);
		clientNameField.setHidden(false);

		courierTypeField = new DataSourceIntegerField("courierType", "快递类型");
		courierTypeField.setRequired(false);
		courierTypeField.setLength(11);
		courierTypeField.setHidden(false);

		minCourierDateField = new DataSourceDateTimeField("minCourierDate", "最早快递日期");
		minCourierDateField.setRequired(false);
		minCourierDateField.setHidden(false);

		maxCourierDateField = new DataSourceDateTimeField("maxCourierDate", "最晚快递日期");
		maxCourierDateField.setRequired(false);
		maxCourierDateField.setHidden(false);

		minSignDateField = new DataSourceDateTimeField("minSignDate", "最早签收日期");
		minSignDateField.setRequired(false);
		minSignDateField.setHidden(false);

		maxSignDateField = new DataSourceDateTimeField("maxSignDate", "最晚签收日期");
		maxSignDateField.setRequired(false);
		maxSignDateField.setHidden(false);

		telField = new DataSourceTextField("tel", "电话");
		telField.setRequired(false);
		telField.setLength(16);
		telField.setHidden(false);

		signStatusField = new DataSourceIntegerField("signStatus", "快递状态");
		signStatusField.setRequired(false);
		signStatusField.setLength(11);
		signStatusField.setHidden(false);

		signNameField = new DataSourceTextField("signName", "签收签名");
		signNameField.setRequired(false);
		signNameField.setLength(64);
		signNameField.setHidden(false);

		courierNumberField = new DataSourceTextField("courierNumber", "快递单号");
		courierNumberField.setRequired(false);
		courierNumberField.setLength(64);
		courierNumberField.setHidden(false);

		mailingAddressField = new DataSourceTextField("mailingAddress", "寄件地址");
		mailingAddressField.setRequired(false);
		mailingAddressField.setLength(512);
		mailingAddressField.setHidden(false);

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

		contactIdField = new DataSourceIntegerField("contactId", "联系人主键   对应  client 表 主键");
		contactIdField.setRequired(false);
		contactIdField.setLength(11);
		contactIdField.setHidden(false);

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


		setFields(contractCodeField, contractNameField, contractIdField, clientNameField, courierTypeField, minCourierDateField, maxCourierDateField, minSignDateField, maxSignDateField, telField, signStatusField, signNameField, courierNumberField, mailingAddressField, invoiceTypeField, signField, invoiceCodeField, invoiceNumberField, contactIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

