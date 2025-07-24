package com.pomplatform.client.inputtaxinvoiceabpor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSinputtaxinvoiceabpor extends DBDataSource {

	public static DSSinputtaxinvoiceabpor instance = null;

	public static DSSinputtaxinvoiceabpor getInstance() {
		if (instance == null) {
			instance = new DSSinputtaxinvoiceabpor("DSSinputtaxinvoiceabpor");
		}
		return instance;
	}

	private final DataSourceIntegerField inputTaxInvoiceIdField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceDateTimeField invoiceDateField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField taxRateField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField otherRemarkField;
	private final DataSourceTextField salesCodeField;
	private final DataSourceFloatField taxAmountField;
	private final DataSourceTextField salesNameField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceBooleanField haveCheckField;

	public DSSinputtaxinvoiceabpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sinputtaxinvoiceabpor");

		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "主键");
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setPrimaryKey(true);
		inputTaxInvoiceIdField.setRequired(true);
		inputTaxInvoiceIdField.setHidden(true);

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

		invoiceDateField = new DataSourceDateTimeField("invoiceDate", "开票日期");
		invoiceDateField.setRequired(false);
		invoiceDateField.setHidden(false);

		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "开票金额");
		invoiceAmountField.setLength(16);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("##,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);

		taxRateField = new DataSourceFloatField("taxRate", "税率");
		taxRateField.setLength(16);
		taxRateField.setDecimalPad(2);
		taxRateField.setFormat("##,###,###,###,##0.00");
		taxRateField.setRequired(false);
		taxRateField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		otherRemarkField = new DataSourceTextField("otherRemark", "其他备注");
		otherRemarkField.setLength(255);
		otherRemarkField.setRequired(false);
		otherRemarkField.setHidden(true);

		salesCodeField = new DataSourceTextField("salesCode", "销方税号");
		salesCodeField.setLength(255);
		salesCodeField.setRequired(false);
		salesCodeField.setHidden(false);

		taxAmountField = new DataSourceFloatField("taxAmount", "税额");
		taxAmountField.setLength(16);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("##,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(false);

		salesNameField = new DataSourceTextField("salesName", "销方名称");
		salesNameField.setLength(255);
		salesNameField.setRequired(false);
		salesNameField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(true);

		monthField = new DataSourceIntegerField("month", "月");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(true);

		haveCheckField = new DataSourceBooleanField("haveCheck", "是否勾选");
		haveCheckField.setRequired(false);
		haveCheckField.setHidden(true);

		setFields(inputTaxInvoiceIdField, invoiceTypeField, invoiceCodeField, invoiceNumberField, invoiceDateField,
				invoiceAmountField, taxRateField, operatorField, remarkField, otherRemarkField, taxAmountField,
				salesNameField, salesCodeField, yearField, monthField, haveCheckField, createTimeField);
	}

}
