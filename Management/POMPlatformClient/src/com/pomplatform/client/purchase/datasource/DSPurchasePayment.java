package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPurchasePayment extends DBDataSource {

	public static DSPurchasePayment instance = null;

	public static DSPurchasePayment getInstance() {
		if (instance == null) {
			instance = new DSPurchasePayment("DSPurchasePayment");
		}
		return instance;
	}

	private final DataSourceIntegerField purchasePaymentIdField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceDateField paymentDateField;
	private final DataSourceTextField paymentNameField;
	private final DataSourceTextField paymentConditionField;
	private final DataSourceFloatField paymentRatioField;
	private final DataSourceFloatField paymentAmountField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField purchaseContractIdField;

	public DSPurchasePayment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("PurchasePayment");

		purchasePaymentIdField = new DataSourceIntegerField("purchasePaymentId", "主键");
		purchasePaymentIdField.setLength(11);
		purchasePaymentIdField.setPrimaryKey(true);
		purchasePaymentIdField.setRequired(true);
		purchasePaymentIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程表主键");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		paymentDateField = new DataSourceDateField("paymentDate", "付款日期");
		paymentDateField.setRequired(true);
		paymentDateField.setHidden(false);

		paymentNameField = new DataSourceTextField("paymentName", "款项名称(预付款、第一次付款)");
		paymentNameField.setLength(255);
		paymentNameField.setRequired(true);
		paymentNameField.setHidden(false);

		paymentConditionField = new DataSourceTextField("paymentCondition", "付款条件");
		paymentConditionField.setLength(1204);
		paymentConditionField.setRequired(true);
		paymentConditionField.setHidden(false);

		paymentRatioField = new DataSourceFloatField("paymentRatio", "付款比例");
		paymentRatioField.setLength(16);
		paymentRatioField.setDecimalPad(2);
		paymentRatioField.setFormat("##,###,###,###,##0.00");
		paymentRatioField.setRequired(true);
		paymentRatioField.setHidden(false);

		paymentAmountField = new DataSourceFloatField("paymentAmount", "付款金额");
		paymentAmountField.setLength(16);
		paymentAmountField.setDecimalPad(2);
		paymentAmountField.setFormat("##,###,###,###,##0.00");
		paymentAmountField.setRequired(true);
		paymentAmountField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "采购合同表主键");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setRequired(false);
		purchaseContractIdField.setHidden(true);

		setFields(purchasePaymentIdField, personnelBusinessIdField, paymentDateField, paymentNameField,
				paymentConditionField, paymentRatioField, paymentAmountField, remarkField, createTimeField,
				purchaseContractIdField);
	}

}
