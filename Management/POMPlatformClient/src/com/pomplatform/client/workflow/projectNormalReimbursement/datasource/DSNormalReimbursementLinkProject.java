package com.pomplatform.client.workflow.projectNormalReimbursement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSNormalReimbursementLinkProject extends DBDataSource {

	public static DSNormalReimbursementLinkProject instance = null;

	public static DSNormalReimbursementLinkProject getInstance() {
		if (instance == null) {
			instance = new DSNormalReimbursementLinkProject("DSNormalReimbursementLinkProject");
		}
		return instance;
	}

	private final DataSourceIntegerField normalReimbursementLinkProjectIdField;
	private final DataSourceIntegerField projectNormalReimbursementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceIntegerField mainItemIdField;
	private final DataSourceIntegerField subItemIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceFloatField inputTaxRebateField;
	private final DataSourceIntegerField haveElectronicInvoiceField;
	private final DataSourceIntegerField invoiceLinkKeyField;

	public DSNormalReimbursementLinkProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionName("NormalReimbursementLinkProject");
		setActionMode(ACTION_MODE_TABLE);

		normalReimbursementLinkProjectIdField = new DataSourceIntegerField("normalReimbursementLinkProjectId", "主键编码");
		normalReimbursementLinkProjectIdField.setLength(11);
		normalReimbursementLinkProjectIdField.setPrimaryKey(true);
		normalReimbursementLinkProjectIdField.setRequired(true);
		normalReimbursementLinkProjectIdField.setHidden(true);

		projectNormalReimbursementIdField = new DataSourceIntegerField("projectNormalReimbursementId", "日常报销编码");
		projectNormalReimbursementIdField.setLength(11);
		projectNormalReimbursementIdField.setRequired(false);
		projectNormalReimbursementIdField.setHidden(true);
		projectNormalReimbursementIdField.setForeignKey("DSNormalReimbursementsAttentionOfWorkflow.businessId");

		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		// KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("main_projects_name", projectIdField,false);

		contractCodeField = new DataSourceTextField("contractCode", "项目编号");
		contractCodeField.setLength(128);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
		// contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
//		KeyValueManager.loadValueMap("contracts", contractCodeField);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

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

		setFields(mainItemIdField, subItemIdField, normalReimbursementLinkProjectIdField,
				projectNormalReimbursementIdField, projectIdField, contractCodeField, plateIdField, amountField,
				inputTaxField, inputTaxRebateField, finalAmountField, remarkField, haveElectronicInvoiceField,
				invoiceLinkKeyField);
	}

}
