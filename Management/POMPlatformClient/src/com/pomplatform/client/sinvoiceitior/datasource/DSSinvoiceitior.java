package com.pomplatform.client.sinvoiceitior.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSinvoiceitior extends DBDataSource
{


	public static DSSinvoiceitior instance = null;

	public static DSSinvoiceitior getInstance() {
		if(instance == null) {
			instance = new DSSinvoiceitior("DSSinvoiceitior");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceIdField;
	private final DataSourceIntegerField ticketingCompanyField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceDateTimeField inStockDateField;
	private final DataSourceTextField invalidRemarkField;
	private final DataSourceIntegerField isInvalidOperatorField;
	private final DataSourceIntegerField storageOperatorField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField taxRateField;
	private final DataSourceFloatField noTaxAmountField;
	private final DataSourceFloatField outputTaxField;
	private final DataSourceIntegerField billingOperationField;
	private final DataSourceDateTimeField invoiceDateField;
	private final DataSourceDateTimeField registrationDateField;
	private final DataSourceIntegerField signField;
	private final DataSourceTextField primaryInvoiceCodeField;
	private final DataSourceTextField primaryInvoiceNumberField;
	private final DataSourceIntegerField contractReceivableIdField;
	private final DataSourceIntegerField invoiceExpressIdField;
	private final DataSourceIntegerField disableTypeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField customerIdField;

	public DSSinvoiceitior(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sinvoiceitior");
		
		contractIdField = new DataSourceIntegerField("contractId", "合同主鍵");
		contractIdField.setLength(11);
		contractIdField.setHidden(true);
		contractIdField.setRequired(false);
		contractIdField.setForeignKey("DSMcontracticcisiior.contractId");

		invoiceIdField = new DataSourceIntegerField("invoiceId", "发票编码");
		invoiceIdField.setLength(11);
		invoiceIdField.setPrimaryKey(true);
		invoiceIdField.setRequired(true);
		invoiceIdField.setHidden(true);


		ticketingCompanyField = new DataSourceIntegerField("ticketingCompany", "购票公司");
		ticketingCompanyField.setLength(11);
		ticketingCompanyField.setRequired(false);
		ticketingCompanyField.setHidden(false);
		ticketingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));

		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型");
		invoiceTypeField.setLength(11);
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setHidden(false);
		invoiceTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));

		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码");
		invoiceCodeField.setLength(11);
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setHidden(false);


		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setLength(11);
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setHidden(false);


		inStockDateField = new DataSourceDateTimeField("inStockDate", "发票入库日期");
		inStockDateField.setRequired(false);
		inStockDateField.setHidden(true);


		invalidRemarkField = new DataSourceTextField("invalidRemark", "备注");
		invalidRemarkField.setLength(512);
		invalidRemarkField.setRequired(false);
		invalidRemarkField.setHidden(false);


		isInvalidOperatorField = new DataSourceIntegerField("isInvalidOperator", "发票空白作废操作人");
		isInvalidOperatorField.setLength(11);
		isInvalidOperatorField.setRequired(false);
		isInvalidOperatorField.setHidden(true);


		storageOperatorField = new DataSourceIntegerField("storageOperator", "发票入库操作人");
		storageOperatorField.setLength(11);
		storageOperatorField.setRequired(false);
		storageOperatorField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(64);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "主合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "开票金额");
		invoiceAmountField.setLength(16);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("##,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);
		invoiceAmountField.setPluralTitle("开票金额");
		invoiceAmountField.setSummaryValueTitle("开票金额");

		taxRateField = new DataSourceFloatField("taxRate", "税率(%)");
		taxRateField.setLength(16);
		taxRateField.setDecimalPad(4);
		taxRateField.setFormat("###,###,###,##0.00");
		taxRateField.setRequired(false);
		taxRateField.setHidden(false);


		noTaxAmountField = new DataSourceFloatField("noTaxAmount", "不含税金额");
		noTaxAmountField.setLength(16);
		noTaxAmountField.setDecimalPad(2);
		noTaxAmountField.setFormat("##,###,###,###,##0.00");
		noTaxAmountField.setRequired(false);
		noTaxAmountField.setHidden(false);


		outputTaxField = new DataSourceFloatField("outputTax", "销项税");
		outputTaxField.setLength(16);
		outputTaxField.setDecimalPad(2);
		outputTaxField.setFormat("##,###,###,###,##0.00");
		outputTaxField.setRequired(false);
		outputTaxField.setHidden(false);


		billingOperationField = new DataSourceIntegerField("billingOperation", "开票操作人");
		billingOperationField.setLength(11);
		billingOperationField.setRequired(false);
		billingOperationField.setHidden(true);


		invoiceDateField = new DataSourceDateTimeField("invoiceDate", "开票日期");
		invoiceDateField.setRequired(false);
		invoiceDateField.setHidden(false);


		registrationDateField = new DataSourceDateTimeField("registrationDate", "开发票的登记日期");
		registrationDateField.setRequired(false);
		registrationDateField.setHidden(true);


		signField = new DataSourceIntegerField("sign", "发票状态");
		signField.setLength(11);
		signField.setRequired(false);
		signField.setHidden(false);
		signField.setValueMap(KeyValueManager.getValueMap("system_dictionary_53"));

		primaryInvoiceCodeField = new DataSourceTextField("primaryInvoiceCode", "原发票代码");
		primaryInvoiceCodeField.setLength(64);
		primaryInvoiceCodeField.setRequired(false);
		primaryInvoiceCodeField.setHidden(false);


		primaryInvoiceNumberField = new DataSourceTextField("primaryInvoiceNumber", "原发票号码");
		primaryInvoiceNumberField.setLength(64);
		primaryInvoiceNumberField.setRequired(false);
		primaryInvoiceNumberField.setHidden(false);


		contractReceivableIdField = new DataSourceIntegerField("contractReceivableId", "收款阶段");
		contractReceivableIdField.setLength(11);
		contractReceivableIdField.setRequired(false);
		contractReceivableIdField.setHidden(true);


		invoiceExpressIdField = new DataSourceIntegerField("invoiceExpressId", "快递ID");
		invoiceExpressIdField.setLength(11);
		invoiceExpressIdField.setRequired(false);
		invoiceExpressIdField.setHidden(true);
		invoiceExpressIdField.setForeignKey("DSMinvoiceexpresitssccmisiior.invoiceExpressId");


		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态");
		disableTypeField.setLength(11);
		disableTypeField.setRequired(false);
		disableTypeField.setHidden(true);
		
		customerIdField = new DataSourceIntegerField("customerId", "客户名称");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerIdField);


		setFields(contractIdField, invoiceIdField, ticketingCompanyField, invoiceTypeField, invoiceCodeField, invoiceNumberField, inStockDateField, invalidRemarkField, isInvalidOperatorField, storageOperatorField, infoCodeField, projectCodeField, contractCodeField, customerIdField, invoiceAmountField, taxRateField, noTaxAmountField, outputTaxField, billingOperationField, invoiceDateField, registrationDateField, signField, primaryInvoiceCodeField, primaryInvoiceNumberField, contractReceivableIdField, invoiceExpressIdField, disableTypeField);
	}


}

