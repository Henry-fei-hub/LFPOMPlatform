package com.pomplatform.client.workflow.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSReimbursementInvoiceInformation extends DBDataSource {

	public static DSReimbursementInvoiceInformation instance = null;

	public static DSReimbursementInvoiceInformation getInstance() {
		if (instance == null) {
			instance = new DSReimbursementInvoiceInformation("DSReimbursementInvoiceInformation");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementInvoiceInformationIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField detailIdField;
	private final DataSourceIntegerField invoiceTypeField;
	private final DataSourceTextField invoiceCodeField;
	private final DataSourceTextField invoiceNumberField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceIntegerField taxRateField;
	private final DataSourceFloatField taxAmountField;
	private final DataSourceFloatField subtractAmountField;
	private final DataSourceIntegerField creatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField subtractRemarkField;
	private final DataSourceIntegerField invoiceQuantityField;

	public DSReimbursementInvoiceInformation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ReimbursementInvoiceInformation");

		reimbursementInvoiceInformationIdField = new DataSourceIntegerField("reimbursementInvoiceInformationId", "主键");
		reimbursementInvoiceInformationIdField.setLength(11);
		reimbursementInvoiceInformationIdField.setPrimaryKey(true);
		reimbursementInvoiceInformationIdField.setRequired(true);
		reimbursementInvoiceInformationIdField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);

		businessIdField = new DataSourceIntegerField("businessId", "流程业务主键");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);

		detailIdField = new DataSourceIntegerField("detailId", "父表主键(实际主表)");
		detailIdField.setLength(11);
		detailIdField.setRequired(false);
		detailIdField.setHidden(true);

		invoiceTypeField = new DataSourceIntegerField("invoiceType", "票类");
		invoiceTypeField.setLength(11);
		invoiceTypeField.setRequired(false);
		invoiceTypeField.setHidden(false);
		invoiceTypeField.setValueMap(KeyValueManager.getValueMap("invoice_types"));

		invoiceCodeField = new DataSourceTextField("invoiceCode", "发票代码");
		invoiceCodeField.setLength(64);
		invoiceCodeField.setRequired(false);
		invoiceCodeField.setHidden(true);

		invoiceNumberField = new DataSourceTextField("invoiceNumber", "发票号码");
		invoiceNumberField.setLength(64);
		invoiceNumberField.setRequired(false);
		invoiceNumberField.setHidden(false);

		totalAmountField = new DataSourceFloatField("totalAmount", "票面金额(价税合计)");
		totalAmountField.setLength(16);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("##,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);

		taxRateField = new DataSourceIntegerField("taxRate", "税率");
		taxRateField.setLength(11);
		taxRateField.setRequired(false);
		taxRateField.setHidden(false);

		taxAmountField = new DataSourceFloatField("taxAmount", "进项税额");
		taxAmountField.setLength(16);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("##,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(false);

		subtractAmountField = new DataSourceFloatField("subtractAmount", "扣除金额");
		subtractAmountField.setLength(16);
		subtractAmountField.setDecimalPad(2);
		subtractAmountField.setFormat("##,###,###,###,##0.00");
		subtractAmountField.setRequired(false);
		subtractAmountField.setHidden(false);

		creatorField = new DataSourceIntegerField("creator", "创建人");
		creatorField.setLength(11);
		creatorField.setRequired(false);
		creatorField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		subtractRemarkField = new DataSourceTextField("subtractRemark", "扣除");
		subtractRemarkField.setRequired(false);
		
		invoiceQuantityField = new DataSourceIntegerField("invoiceQuantity", "发票数量");
		invoiceQuantityField.setLength(11);
		invoiceQuantityField.setRequired(false);
		invoiceQuantityField.setHidden(false);

		setFields(reimbursementInvoiceInformationIdField, processTypeField, businessIdField, detailIdField,
				invoiceTypeField, subtractRemarkField, invoiceCodeField, totalAmountField, subtractAmountField,
				taxRateField, taxAmountField, creatorField, createTimeField, invoiceNumberField, invoiceQuantityField);
	}

}
