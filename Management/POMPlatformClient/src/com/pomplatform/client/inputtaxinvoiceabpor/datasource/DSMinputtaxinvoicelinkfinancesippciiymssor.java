package com.pomplatform.client.inputtaxinvoiceabpor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMinputtaxinvoicelinkfinancesippciiymssor extends DBDataSource
{


	public static DSMinputtaxinvoicelinkfinancesippciiymssor instance = null;

	public static DSMinputtaxinvoicelinkfinancesippciiymssor getInstance() {
		if(instance == null) {
			instance = new DSMinputtaxinvoicelinkfinancesippciiymssor("DSMinputtaxinvoicelinkfinancesippciiymssor");
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
	private final DataSourceTextField rcodeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceFloatField taxAmountClField;
	private final DataSourceFloatField invoiceAmountClField;
	private final DataSourceBooleanField isCompleteField;

	public DSMinputtaxinvoicelinkfinancesippciiymssor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Minputtaxinvoicelinkfinancesippciiymssor");


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
		operatorField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


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
		salesCodeField.setHidden(true);


		taxAmountField = new DataSourceFloatField("taxAmount", "税额");
		taxAmountField.setLength(16);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("##,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(false);


		salesNameField = new DataSourceTextField("salesName", "销方名称");
		salesNameField.setLength(255);
		salesNameField.setRequired(false);
		salesNameField.setHidden(true);


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


		rcodeField = new DataSourceTextField("rcode", "报销编号");
		rcodeField.setLength(-1);
		rcodeField.setRequired(true);
		rcodeField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		taxAmountClField = new DataSourceFloatField("taxAmountCl", "税额");
		taxAmountClField.setLength(18);
		taxAmountClField.setDecimalPad(2);
		taxAmountClField.setFormat("#,###,###,###,###,##0.00");
		taxAmountClField.setRequired(true);
		taxAmountClField.setHidden(false);


		invoiceAmountClField = new DataSourceFloatField("invoiceAmountCl", "invoiceAmountCl");
		invoiceAmountClField.setLength(18);
		invoiceAmountClField.setDecimalPad(2);
		invoiceAmountClField.setFormat("#,###,###,###,###,##0.00");
		invoiceAmountClField.setRequired(true);
		invoiceAmountClField.setHidden(true);


		isCompleteField = new DataSourceBooleanField("isComplete", "是否核对无误");
		isCompleteField.setRequired(true);
		isCompleteField.setHidden(false);


		setFields(inputTaxInvoiceIdField, invoiceTypeField, invoiceCodeField, invoiceNumberField, invoiceDateField, invoiceAmountField, taxRateField, operatorField, createTimeField, remarkField, otherRemarkField, salesCodeField, taxAmountField, salesNameField, yearField, monthField, haveCheckField, rcodeField, companyIdField, taxAmountClField, invoiceAmountClField, isCompleteField);
	}


}

