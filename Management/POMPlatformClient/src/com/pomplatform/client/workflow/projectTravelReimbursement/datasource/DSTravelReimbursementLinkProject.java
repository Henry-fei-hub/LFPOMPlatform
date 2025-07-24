package com.pomplatform.client.workflow.projectTravelReimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSTravelReimbursementLinkProject extends DBDataSource {

	public static DSTravelReimbursementLinkProject instance = null;

	public static DSTravelReimbursementLinkProject getInstance() {
		if (instance == null) {
			instance = new DSTravelReimbursementLinkProject("DSTravelReimbursementLinkProject");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementLinkProjectIdField;
	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField inputTaxRebateField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceIntegerField haveElectronicInvoiceField;
	private final DataSourceIntegerField invoiceLinkKeyField;

	public DSTravelReimbursementLinkProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TravelReimbursementLinkProject");

		travelReimbursementLinkProjectIdField = new DataSourceIntegerField("travelReimbursementLinkProjectId", "主键编码");
		travelReimbursementLinkProjectIdField.setLength(11);
		travelReimbursementLinkProjectIdField.setPrimaryKey(true);
		travelReimbursementLinkProjectIdField.setRequired(true);
		travelReimbursementLinkProjectIdField.setHidden(true);

		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅报销详情编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setRequired(false);
		travelReimbursementIdField.setHidden(true);
		travelReimbursementIdField.setForeignKey("DSTravelReimbursementsAttentionOfWorkflow.businessId");

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

		haveElectronicInvoiceField = new DataSourceIntegerField("haveElectronicInvoice", "是否有电子发票");
		haveElectronicInvoiceField.setRequired(false);
		haveElectronicInvoiceField.setHidden(true);

		invoiceLinkKeyField = new DataSourceIntegerField("invoiceLinkKey", "发票信息关联key");
		invoiceLinkKeyField.setRequired(false);
		invoiceLinkKeyField.setHidden(true);

		setFields(travelReimbursementLinkProjectIdField, travelReimbursementIdField, projectIdField, contractCodeField,
				plateIdField, amountField, inputTaxField, inputTaxRebateField, finalAmountField,
				haveElectronicInvoiceField, invoiceLinkKeyField);
	}

}
