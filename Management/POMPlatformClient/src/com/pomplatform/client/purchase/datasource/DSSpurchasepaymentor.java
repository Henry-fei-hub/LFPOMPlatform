package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValue;

public class DSSpurchasepaymentor extends DBDataSource {

	public static DSSpurchasepaymentor instance = null;

	public static DSSpurchasepaymentor getInstance() {
		if (instance == null) {
			instance = new DSSpurchasepaymentor("DSSpurchasepaymentor");
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
	private final DataSourceIntegerField purchasePaymentStatusField;
	private final DataSourceIntegerField personInChargeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField realPaymentDateField;
	private final DataSourceFloatField realPaymentAmountField;
	private final DataSourceIntegerField processBusinessIdField;
	private final DataSourceIntegerField dealStatusField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceDateField contractDateField;
	private final DataSourceIntegerField purchasePersonField;
	private final DataSourceTextField afterSaleRequirementsField;
	private final DataSourceTextField qualityAssuranceField;
	private final DataSourceTextField termOfPaymentField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceTextField abbreviatedNameField;
	private final DataSourceTextField majorContactPersonField;
	private final DataSourceTextField contactPhoneField;

	public DSSpurchasepaymentor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Spurchasepaymentor");

		purchasePaymentIdField = new DataSourceIntegerField("purchasePaymentId", "主键");
		purchasePaymentIdField.setLength(11);
		purchasePaymentIdField.setPrimaryKey(true);
		purchasePaymentIdField.setRequired(true);
		purchasePaymentIdField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程表主键");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		paymentDateField = new DataSourceDateField("paymentDate", "计划付款日期");
		paymentDateField.setRequired(false);
		paymentDateField.setHidden(false);

		paymentNameField = new DataSourceTextField("paymentName", "款项名称");
		paymentNameField.setLength(255);
		paymentNameField.setRequired(false);
		paymentNameField.setHidden(false);

		paymentConditionField = new DataSourceTextField("paymentCondition", "付款条件");
		paymentConditionField.setLength(1204);
		paymentConditionField.setRequired(false);
		paymentConditionField.setHidden(false);

		paymentRatioField = new DataSourceFloatField("paymentRatio", "付款比例");
		paymentRatioField.setLength(16);
		paymentRatioField.setDecimalPad(2);
		paymentRatioField.setFormat("##,###,###,###,##0.00");
		paymentRatioField.setRequired(false);
		paymentRatioField.setHidden(false);

		paymentAmountField = new DataSourceFloatField("paymentAmount", "付款金额");
		paymentAmountField.setLength(16);
		paymentAmountField.setDecimalPad(2);
		paymentAmountField.setFormat("##,###,###,###,##0.00");
		paymentAmountField.setRequired(false);
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

		purchasePaymentStatusField = new DataSourceIntegerField("purchasePaymentStatus", "流程状态 0新建 3通过审批完成");
		purchasePaymentStatusField.setLength(11);
		purchasePaymentStatusField.setRequired(false);
		purchasePaymentStatusField.setHidden(true);

		personInChargeField = new DataSourceIntegerField("personInCharge", "订购人");
		personInChargeField.setLength(11);
		personInChargeField.setRequired(false);
		personInChargeField.setHidden(false);
		personInChargeField.setValueMap(KeyValueManager.getValueMap("employees"));

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(true);
		operatorIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		realPaymentDateField = new DataSourceDateTimeField("realPaymentDate", "真实付款时间");
		realPaymentDateField.setRequired(false);
		realPaymentDateField.setHidden(false);

		realPaymentAmountField = new DataSourceFloatField("realPaymentAmount", "真实付款金额");
		realPaymentAmountField.setLength(16);
		realPaymentAmountField.setDecimalPad(2);
		realPaymentAmountField.setFormat("##,###,###,###,##0.00");
		realPaymentAmountField.setRequired(false);
		realPaymentAmountField.setHidden(false);

		processBusinessIdField = new DataSourceIntegerField("processBusinessId", "流程业务表主键");
		processBusinessIdField.setLength(11);
		processBusinessIdField.setRequired(false);
		processBusinessIdField.setHidden(true);

		dealStatusField = new DataSourceIntegerField("dealStatus", "付款状态");
		dealStatusField.setLength(11);
		dealStatusField.setRequired(false);
		dealStatusField.setHidden(false);
		dealStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_208"));

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(255);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(255);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setLength(16);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("##,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);

		contractDateField = new DataSourceDateField("contractDate", "合同签订日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(true);

		purchasePersonField = new DataSourceIntegerField("purchasePerson", "订购人");
		purchasePersonField.setLength(11);
		purchasePersonField.setRequired(false);
		purchasePersonField.setHidden(true);

		afterSaleRequirementsField = new DataSourceTextField("afterSaleRequirements", "售后要求");
		afterSaleRequirementsField.setLength(512);
		afterSaleRequirementsField.setRequired(false);
		afterSaleRequirementsField.setHidden(true);

		qualityAssuranceField = new DataSourceTextField("qualityAssurance", "质保");
		qualityAssuranceField.setLength(255);
		qualityAssuranceField.setRequired(false);
		qualityAssuranceField.setHidden(true);

		termOfPaymentField = new DataSourceTextField("termOfPayment", "付款条件");
		termOfPaymentField.setLength(1024);
		termOfPaymentField.setRequired(false);
		termOfPaymentField.setHidden(true);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(true);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setLength(128);
		supplierNameField.setRequired(false);
		supplierNameField.setHidden(false);

		abbreviatedNameField = new DataSourceTextField("abbreviatedName", "供应商简称");
		abbreviatedNameField.setLength(128);
		abbreviatedNameField.setRequired(false);
		abbreviatedNameField.setHidden(true);

		majorContactPersonField = new DataSourceTextField("majorContactPerson", "主要联系人");
		majorContactPersonField.setLength(128);
		majorContactPersonField.setRequired(false);
		majorContactPersonField.setHidden(false);

		contactPhoneField = new DataSourceTextField("contactPhone", "客户联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);

		setFields(purchasePaymentIdField, personnelBusinessIdField, paymentNameField, paymentConditionField,
				paymentRatioField, remarkField, createTimeField, purchaseContractIdField, purchasePaymentStatusField,
				personInChargeField, operatorIdField, paymentDateField, paymentAmountField, realPaymentDateField,
				realPaymentAmountField, processBusinessIdField, contractNameField, contractCodeField,
				contractAmountField, contractDateField, purchasePersonField, afterSaleRequirementsField,
				qualityAssuranceField, termOfPaymentField, mainProjectIdField, projectNameField, projectCodeField,
				supplierIdField, supplierNameField, abbreviatedNameField, majorContactPersonField, contactPhoneField,
				dealStatusField);
	}

}
