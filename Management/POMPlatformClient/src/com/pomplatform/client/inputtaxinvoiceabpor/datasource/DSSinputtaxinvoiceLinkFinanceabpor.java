package com.pomplatform.client.inputtaxinvoiceabpor.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSinputtaxinvoiceLinkFinanceabpor extends DBDataSource {

	public static DSSinputtaxinvoiceLinkFinanceabpor instance = null;

	public static DSSinputtaxinvoiceLinkFinanceabpor getInstance() {
		if (instance == null) {
			instance = new DSSinputtaxinvoiceLinkFinanceabpor("DSSinputtaxinvoiceLinkFinanceabpor");
		}
		return instance;
	}

	private final DataSourceIntegerField inputTaxInvoiceLinkFinanceIdField;
	private final DataSourceIntegerField addTypeField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceDateField invoiceDateField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField taxRateField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField otherRemarkField;
	private final DataSourceTextField randomCodeField;
	private final DataSourceFloatField taxAmountField;
	private final DataSourceTextField codeField;

	public DSSinputtaxinvoiceLinkFinanceabpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sinputtaxinvoiceabpor");

		inputTaxInvoiceLinkFinanceIdField = new DataSourceIntegerField("inputTaxInvoiceLinkFinanceId", "主键");
		inputTaxInvoiceLinkFinanceIdField.setLength(11);
		inputTaxInvoiceLinkFinanceIdField.setPrimaryKey(true);
		inputTaxInvoiceLinkFinanceIdField.setRequired(true);
		inputTaxInvoiceLinkFinanceIdField.setHidden(false);

		addTypeField = new DataSourceIntegerField("addType", "添加类型");
		addTypeField.setLength(11);
		addTypeField.setRequired(false);
		addTypeField.setHidden(false);
		LinkedHashMap<String, String> addTypeMap = new LinkedHashMap<String, String>();
		addTypeMap.put("1", "手动添加");
		addTypeMap.put("2", "扫码添加");
		addTypeField.setValueMap(addTypeMap);

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

		invoiceDateField = new DataSourceDateField("invoiceDate", "开票日期");
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
		taxRateField.setDecimalPad(4);
		taxRateField.setFormat("###,###,###,##0.00");
		taxRateField.setRequired(false);
		taxRateField.setHidden(false);

		businessIdField = new DataSourceIntegerField("businessId", "流程业务主键");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);

		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实例主键");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(false);

		operatorField = new DataSourceIntegerField("operator", "operator");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态  0未删除  1被删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		otherRemarkField = new DataSourceTextField("otherRemark", "其他备注");
		otherRemarkField.setLength(255);
		otherRemarkField.setRequired(false);
		otherRemarkField.setHidden(true);

		randomCodeField = new DataSourceTextField("randomCode", "发票二维码随机字符串");
		randomCodeField.setLength(255);
		randomCodeField.setRequired(false);
		randomCodeField.setHidden(true);

		taxAmountField = new DataSourceFloatField("taxAmount", "税额");
		taxAmountField.setLength(16);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("##,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(true);
		
		codeField = new DataSourceTextField("code", "报销编号");
		codeField.setLength(255);
		codeField.setRequired(false);
		codeField.setHidden(true);

		setFields(codeField, inputTaxInvoiceLinkFinanceIdField, addTypeField, invoiceTypeField, invoiceCodeField, invoiceNumberField,
				invoiceDateField, invoiceAmountField, taxRateField, businessIdField, processTypeField,
				processInstanceIdField, operatorField, createTimeField, deleteFlagField, remarkField, otherRemarkField,
				randomCodeField, taxAmountField);
	}

}
