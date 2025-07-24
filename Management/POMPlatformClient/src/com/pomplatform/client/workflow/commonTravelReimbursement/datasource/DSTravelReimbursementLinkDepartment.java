package com.pomplatform.client.workflow.commonTravelReimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSTravelReimbursementLinkDepartment extends DBDataSource {

	public static DSTravelReimbursementLinkDepartment instance = null;

	public static DSTravelReimbursementLinkDepartment getInstance() {
		if (instance == null) {
			instance = new DSTravelReimbursementLinkDepartment("DSTravelReimbursementLinkDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField travelReimbursementLinkDepartmentIdField;
	private final DataSourceIntegerField travelReimbursementIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField inputTaxField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceFloatField inputTaxRebateField;
	private final DataSourceIntegerField haveElectronicInvoiceField;
	private final DataSourceIntegerField invoiceLinkKeyField;

	public DSTravelReimbursementLinkDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("TravelReimbursementLinkDepartment");

		travelReimbursementLinkDepartmentIdField = new DataSourceIntegerField("travelReimbursementLinkDepartmentId",
				"主键编码");
		travelReimbursementLinkDepartmentIdField.setLength(11);
		travelReimbursementLinkDepartmentIdField.setPrimaryKey(true);
		travelReimbursementLinkDepartmentIdField.setRequired(true);
		travelReimbursementLinkDepartmentIdField.setHidden(true);

		travelReimbursementIdField = new DataSourceIntegerField("travelReimbursementId", "差旅报销详情编码");
		travelReimbursementIdField.setLength(11);
		travelReimbursementIdField.setRequired(false);
		travelReimbursementIdField.setHidden(true);
		travelReimbursementIdField.setForeignKey("DSTravelReimbursementsAttentionOfWorkflow.businessId");

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

		haveElectronicInvoiceField = new DataSourceIntegerField("haveElectronicInvoice", "是否有电子发票");
		haveElectronicInvoiceField.setRequired(false);
		haveElectronicInvoiceField.setHidden(true);

		invoiceLinkKeyField = new DataSourceIntegerField("invoiceLinkKey", "发票信息关联key");
		invoiceLinkKeyField.setRequired(false);
		invoiceLinkKeyField.setHidden(true);

		setFields(travelReimbursementLinkDepartmentIdField, travelReimbursementIdField, departmentIdField, amountField,
				inputTaxField, inputTaxRebateField, finalAmountField, haveElectronicInvoiceField, invoiceLinkKeyField);
	}

}
