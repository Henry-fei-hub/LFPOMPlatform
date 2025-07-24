package com.pomplatform.client.attachment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnAttachmentLinkInvoices extends DBDataSource
{


	public static DSOnAttachmentLinkInvoices instance = null;

	public static DSOnAttachmentLinkInvoices getInstance() {
		if(instance == null) {
			instance = new DSOnAttachmentLinkInvoices("DSOnAttachmentLinkInvoices");
		}
		return instance;
	}

	private final DataSourceIntegerField invoiceIdField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceIntegerField ticketingCompanyField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField taxRateField;
	private final DataSourceFloatField noTaxAmountField;
	private final DataSourceFloatField outputTaxField;
	private final DataSourceDateTimeField invoiceDateField;
	private final DataSourceIntegerField flagTypeField;
	private final DataSourceIntegerField signField;
	private final DataSourceIntegerField bindAmountField;
	private final DataSourceIntegerField forAmountField;

	public DSOnAttachmentLinkInvoices(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnAttachmentLinkInvoices");


		invoiceIdField = new DataSourceIntegerField("invoiceId", "发票编码");
		invoiceIdField.setLength(11);
		invoiceIdField.setRequired(false);
		invoiceIdField.setHidden(true);


		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型");
		invoiceTypeField.setLength(11);
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setHidden(false);
		invoiceTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_52"));


		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码");
		invoiceCodeField.setLength(64);
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setHidden(false);


		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setLength(64);
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setHidden(false);


		ticketingCompanyField = new DataSourceIntegerField("ticketingCompany", "购票公司");
		ticketingCompanyField.setLength(11);
		ticketingCompanyField.setRequired(false);
		ticketingCompanyField.setHidden(false);
		ticketingCompanyField.setValueMap(KeyValueManager.getValueMap("system_dictionary_54"));

		customerIdField = new DataSourceIntegerField("customerId", "客户名称");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(false);
		KeyValueManager.loadValueMap("customers", customerIdField);


		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "开票金额");
		invoiceAmountField.setLength(16);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("##,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);


		taxRateField = new DataSourceFloatField("taxRate", "税率");
		taxRateField.setLength(16);
		taxRateField.setDecimalPad(4);
		taxRateField.setFormat("###,###,###,##0.0000");
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


		invoiceDateField = new DataSourceDateTimeField("invoiceDate", "开票日期");
		invoiceDateField.setRequired(false);
		invoiceDateField.setHidden(false);


		flagTypeField = new DataSourceIntegerField("flagType", "绑定状态");
		flagTypeField.setLength(11);
		flagTypeField.setRequired(true);
		flagTypeField.setHidden(false);
		
		java.util.Map<String,String> flagTypeValues = new java.util.HashMap<String,String>();
		flagTypeValues.put("2", "已绑定");
		flagTypeValues.put("1", "未绑定");
		flagTypeField.setValueMap(flagTypeValues);
		
		signField = new DataSourceIntegerField("sign", "发票状态");
		signField.setLength(11);
		signField.setRequired(true);
		signField.setHidden(false);
		signField.setValueMap(KeyValueManager.getValueMap("system_dictionary_53"));

		bindAmountField = new DataSourceIntegerField("bindAmount", "绑定确认函");
		bindAmountField.setLength(11);
		bindAmountField.setRequired(true);
		bindAmountField.setHidden(false);
		
		forAmountField = new DataSourceIntegerField("forAmount", "是否被负数");
		forAmountField.setLength(11);
		forAmountField.setRequired(true);
		forAmountField.setHidden(false);
		java.util.Map<String,String> map = new java.util.HashMap<String,String>();
		map.put("0", "否");
		map.put("1", "是");
		forAmountField.setValueMap(map);

		setFields(invoiceIdField, invoiceTypeField, invoiceCodeField, invoiceNumberField, ticketingCompanyField, customerIdField, invoiceAmountField, taxRateField, noTaxAmountField, outputTaxField, invoiceDateField, signField, flagTypeField, bindAmountField, forAmountField);
	}


}

