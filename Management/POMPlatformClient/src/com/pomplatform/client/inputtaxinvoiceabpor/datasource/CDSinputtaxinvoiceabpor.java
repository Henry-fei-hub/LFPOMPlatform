package com.pomplatform.client.inputtaxinvoiceabpor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSinputtaxinvoiceabpor extends DataSource
{


	public static CDSinputtaxinvoiceabpor instance = null;

	public static CDSinputtaxinvoiceabpor getInstance() {
		if(instance == null) {
			instance = new CDSinputtaxinvoiceabpor("CDSinputtaxinvoiceabpor");
		}
		return instance;
	}

	private final DataSourceTextField remarkField;
	private final DataSourceTextField salesCodeField;
	private final DataSourceTextField salesNameField;
	private final DataSourceIntegerField inputTaxInvoiceIdField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField taxRateField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceBooleanField haveCheckField;

	public CDSinputtaxinvoiceabpor(String dataSourceID) {

		setID(dataSourceID);
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		salesCodeField = new DataSourceTextField("salesCode", "销方税号");
		salesCodeField.setRequired(false);
		salesCodeField.setLength(255);
		salesCodeField.setHidden(false);

		salesNameField = new DataSourceTextField("salesName", "销方名称");
		salesNameField.setRequired(false);
		salesNameField.setLength(255);
		salesNameField.setHidden(false);

		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "主键");
		inputTaxInvoiceIdField.setRequired(true);
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setPrimaryKey(true);
		inputTaxInvoiceIdField.setHidden(true);

		invoiceTypeField = new DataSourceIntegerField("invoiceType", "发票类型 1专票，2普票 ，3代开");
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setLength(11);
		invoiceTypeField.setHidden(false);

		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码(10位 每次批量录入是一样)");
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setLength(64);
		invoiceCodeField.setHidden(false);

		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码(8位)");
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setLength(64);
		invoiceNumberField.setHidden(false);

		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "开票金额(如 100)");
		invoiceAmountField.setRequired(true);
		invoiceAmountField.setLength(16);
		invoiceAmountField.setHidden(false);

		taxRateField = new DataSourceFloatField("taxRate", "税率(如 6%)");
		taxRateField.setRequired(true);
		taxRateField.setLength(16);
		taxRateField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setRequired(false);
		operatorField.setLength(11);
		operatorField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		haveCheckField = new DataSourceBooleanField("haveCheck", "是否勾选");
		haveCheckField.setRequired(false);
		haveCheckField.setHidden(false);

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


		setFields(remarkField, salesCodeField, salesNameField, inputTaxInvoiceIdField, invoiceTypeField, invoiceCodeField, invoiceNumberField, invoiceAmountField, taxRateField, operatorField, yearField, monthField, haveCheckField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

