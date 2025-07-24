package com.pomplatform.client.sinvoiceitiorcount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSinvoiceitiorcount extends DataSource
{


	public static CDSinvoiceitiorcount instance = null;

	public static CDSinvoiceitiorcount getInstance() {
		if(instance == null) {
			instance = new CDSinvoiceitiorcount("CDSinvoiceitiorcount");
		}
		return instance;
	}

	private final DataSourceIntegerField minSignField;
	private final DataSourceIntegerField maxSignField;
	private final DataSourceIntegerField invoiceIdField;
	private final DataSourceIntegerField ticketingCompanyField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceIntegerField disableTypeField;
	private final DataSourceIntegerField invoiceExpressIdField;
	private final DataSourceIntegerField signField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceDateTimeField minInStockDateField;
	private final DataSourceDateTimeField maxInStockDateField;
	private final DataSourceDateTimeField minInvoiceDateField;
	private final DataSourceDateTimeField maxInvoiceDateField;
	private final DataSourceFloatField minInvoiceAmountField;
	private final DataSourceFloatField maxInvoiceAmountField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceBooleanField haveVoucherField;

	public CDSinvoiceitiorcount(String dataSourceID) {

		setID(dataSourceID);
		minSignField = new DataSourceIntegerField("minSign", "发票状态开始");
		minSignField.setRequired(false);
		minSignField.setLength(11);
		minSignField.setHidden(false);

		maxSignField = new DataSourceIntegerField("maxSign", "发票状态结束");
		maxSignField.setRequired(false);
		maxSignField.setLength(11);
		maxSignField.setHidden(false);

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

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
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

		customerIdField = new DataSourceIntegerField("customerId", "客户名称");
		customerIdField.setRequired(false);
		customerIdField.setLength(128);
		customerIdField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerIdField);

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

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(true);
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setHidden(true);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);
		
		haveVoucherField = new DataSourceBooleanField("haveVoucher", "已有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(false);

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


		setFields(minSignField, maxSignField, invoiceIdField, ticketingCompanyField, infoCodeField, projectCodeField, contractCodeField, invoiceTypeField, disableTypeField, invoiceExpressIdField, signField, customerIdField, invoiceCodeField, invoiceNumberField, minInStockDateField, maxInStockDateField, minInvoiceDateField, maxInvoiceDateField, minInvoiceAmountField, maxInvoiceAmountField, contractIdField, contractNameField, haveVoucherField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

