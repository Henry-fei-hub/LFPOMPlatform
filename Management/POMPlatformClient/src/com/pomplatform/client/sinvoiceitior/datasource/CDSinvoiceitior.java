package com.pomplatform.client.sinvoiceitior.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSinvoiceitior extends DataSource
{


	public static CDSinvoiceitior instance = null;

	public static CDSinvoiceitior getInstance() {
		if(instance == null) {
			instance = new CDSinvoiceitior("CDSinvoiceitior");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceIdField;
	private final DataSourceIntegerField ticketingCompanyField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceIntegerField disableTypeField;
	private final DataSourceIntegerField invoiceExpressIdField;
	private final DataSourceIntegerField signField;
	private final DataSourceTextField clientNameField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceDateTimeField minInStockDateField;
	private final DataSourceDateTimeField maxInStockDateField;
	private final DataSourceDateTimeField minInvoiceDateField;
	private final DataSourceDateTimeField maxInvoiceDateField;
	private final DataSourceFloatField minInvoiceAmountField;
	private final DataSourceFloatField maxInvoiceAmountField;

	public CDSinvoiceitior(String dataSourceID) {

		setID(dataSourceID);
		invoiceIdField = new DataSourceIntegerField("invoiceId", "开发票 编码");
		invoiceIdField.setRequired(true);
		invoiceIdField.setLength(11);
		invoiceIdField.setPrimaryKey(true);
		invoiceIdField.setHidden(true);

		ticketingCompanyField = new DataSourceIntegerField("ticketingCompany", "购票公司");
		ticketingCompanyField.setRequired(false);
		ticketingCompanyField.setLength(11);
		ticketingCompanyField.setHidden(false);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setRequired(false);
		infoCodeField.setLength(64);
		infoCodeField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同主编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型");
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setLength(11);
		invoiceTypeField.setHidden(false);

		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态");
		disableTypeField.setRequired(false);
		disableTypeField.setLength(11);
		disableTypeField.setHidden(false);

		invoiceExpressIdField = new DataSourceIntegerField("invoiceExpressId", "发票快递编码");
		invoiceExpressIdField.setRequired(false);
		invoiceExpressIdField.setLength(11);
		invoiceExpressIdField.setHidden(false);

		signField = new DataSourceIntegerField("sign", "发票状态");
		signField.setRequired(false);
		signField.setLength(11);
		signField.setHidden(false);

		clientNameField = new DataSourceTextField("clientName", "客户名称");
		clientNameField.setRequired(false);
		clientNameField.setLength(128);
		clientNameField.setHidden(false);

		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码");
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setLength(64);
		invoiceCodeField.setHidden(false);

		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setLength(64);
		invoiceNumberField.setHidden(false);

		minInStockDateField = new DataSourceDateTimeField("minInStockDate", "最早发票入库日期");
		minInStockDateField.setRequired(false);
		minInStockDateField.setHidden(false);

		maxInStockDateField = new DataSourceDateTimeField("maxInStockDate", "最晚发票入库日期");
		maxInStockDateField.setRequired(false);
		maxInStockDateField.setHidden(false);

		minInvoiceDateField = new DataSourceDateTimeField("minInvoiceDate", "最早开票日期");
		minInvoiceDateField.setRequired(false);
		minInvoiceDateField.setHidden(false);

		maxInvoiceDateField = new DataSourceDateTimeField("maxInvoiceDate", "最晚开票日期");
		maxInvoiceDateField.setRequired(false);
		maxInvoiceDateField.setHidden(false);

		minInvoiceAmountField = new DataSourceFloatField("minInvoiceAmount", "最小开票金额");
		minInvoiceAmountField.setRequired(true);
		minInvoiceAmountField.setLength(16);
		minInvoiceAmountField.setHidden(false);

		maxInvoiceAmountField = new DataSourceFloatField("maxInvoiceAmount", "最大开票金额");
		maxInvoiceAmountField.setRequired(true);
		maxInvoiceAmountField.setLength(16);
		maxInvoiceAmountField.setHidden(false);

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


		setFields(invoiceIdField, ticketingCompanyField, infoCodeField, projectCodeField, contractCodeField, invoiceTypeField, disableTypeField, invoiceExpressIdField, signField, clientNameField, invoiceCodeField, invoiceNumberField, minInStockDateField, maxInStockDateField, minInvoiceDateField, maxInvoiceDateField, minInvoiceAmountField, maxInvoiceAmountField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

