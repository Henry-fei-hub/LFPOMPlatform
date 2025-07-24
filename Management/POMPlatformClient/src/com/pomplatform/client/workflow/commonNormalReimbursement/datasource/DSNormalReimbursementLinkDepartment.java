package com.pomplatform.client.workflow.commonNormalReimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSNormalReimbursementLinkDepartment extends DBDataSource {

	public static DSNormalReimbursementLinkDepartment instance = null;

	public static DSNormalReimbursementLinkDepartment getInstance() {
		if (instance == null) {
			instance = new DSNormalReimbursementLinkDepartment("DSNormalReimbursementLinkDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField normalReimbursementLinkDepartmentIdField;
	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceIntegerField mainItemIdField;
	private final DataSourceIntegerField subItemIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField inputTaxRebateField;
	private final DataSourceIntegerField haveElectronicInvoiceField;
	private final DataSourceIntegerField invoiceLinkKeyField;

	public DSNormalReimbursementLinkDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("NormalReimbursementLinkDepartment");

		normalReimbursementLinkDepartmentIdField = new DataSourceIntegerField("normalReimbursementLinkDepartmentId",
				"主键编码");
		normalReimbursementLinkDepartmentIdField.setLength(11);
		normalReimbursementLinkDepartmentIdField.setPrimaryKey(true);
		normalReimbursementLinkDepartmentIdField.setRequired(true);
		normalReimbursementLinkDepartmentIdField.setHidden(true);

		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "日常报销编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setRequired(false);
		projectNormalReimbursementIdField.setHidden(true);
		projectNormalReimbursementIdField.setForeignKey("DSNormalReimbursementsAttentionOfWorkflow.businessId");

		departmentIdField = new DataSourceTextField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		amountField = new DataSourceFloatField("amount", "费用");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);

		inputTaxField = new DataSourceFloatField("inputTax", "进项税");
		inputTaxField.setLength(18);
		inputTaxField.setDecimalPad(5);
		inputTaxField.setFormat("#,###,###,###,##0.00");
		inputTaxField.setRequired(false);
		inputTaxField.setHidden(false);

		inputTaxRebateField = new DataSourceFloatField("inputTaxRebate", "进项税转出");
		inputTaxRebateField.setLength(18);
		inputTaxRebateField.setDecimalPad(5);
		inputTaxRebateField.setFormat("#,###,###,###,##0.00");
		inputTaxRebateField.setRequired(false);
		inputTaxRebateField.setHidden(false);

		finalAmountField = new DataSourceFloatField("finalAmount", "成本");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(5);
		finalAmountField.setFormat("#,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(false);

		mainItemIdField = new DataSourceIntegerField("mainItemId", "报销科目");
		mainItemIdField.setLength(18);
		mainItemIdField.setRequired(false);
		// mainItemIdField.setValueMap(KeyValueManager.getValueMap("parent_subject_types"));
		KeyValueManager.loadValueMap("parent_subject_types", mainItemIdField);
		mainItemIdField.setHidden(false);

		subItemIdField = new DataSourceIntegerField("subItemId", "报销选项");
		subItemIdField.setLength(18);
		subItemIdField.setRequired(false);
		// subItemIdField.setValueMap(KeyValueManager.getValueMap("subject_types"));
		KeyValueManager.loadValueMap("subject_types", subItemIdField);
		subItemIdField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "摘要");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		haveElectronicInvoiceField = new DataSourceIntegerField("haveElectronicInvoice", "是否有电子发票");
		haveElectronicInvoiceField.setRequired(false);
		haveElectronicInvoiceField.setHidden(true);
		
		invoiceLinkKeyField = new DataSourceIntegerField("invoiceLinkKey", "发票信息关联key");
		invoiceLinkKeyField.setRequired(false);
		invoiceLinkKeyField.setHidden(true);

		setFields(mainItemIdField, subItemIdField, normalReimbursementLinkDepartmentIdField,
				projectNormalReimbursementIdField, departmentIdField, amountField, inputTaxField, inputTaxRebateField,
				finalAmountField, remarkField, haveElectronicInvoiceField, invoiceLinkKeyField);
	}

}
