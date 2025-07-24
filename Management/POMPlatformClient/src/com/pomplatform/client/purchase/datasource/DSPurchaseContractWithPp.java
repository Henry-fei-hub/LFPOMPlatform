package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSPurchaseContractWithPp extends DBDataSource {

	public static DSPurchaseContractWithPp instance = null;

	public static DSPurchaseContractWithPp getInstance() {
		if (instance == null) {
			instance = new DSPurchaseContractWithPp("DSPurchaseContractWithPp");
		}
		return instance;
	}

	private final DataSourceIntegerField purchaseContractIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField purchasePersonField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField qualityAssuranceField;
	private final DataSourceDateField contractDateField;
	private final DataSourceTextField termOfPaymentField;
	private final DataSourceTextField afterSaleRequirementsField;
	private final DataSourceFloatField amountPaidField;
	private final DataSourceFloatField amountUnpaidField;
	private final DataSourceFloatField haveInvoiceAmountField;
	private final DataSourceFloatField lackInvoiceAmountField;
	private final DataSourceIntegerField contractAttachmentField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceTextField abbreviatedNameField;
	private final DataSourceTextField majorContactPersonField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceField detailPurchasePayment;
	private final DataSourceField detailPurchaseProductDetail;
	

	public DSPurchaseContractWithPp(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mpurchasecontractppmssmor");

		purchaseContractIdField = new DataSourceIntegerField("purchaseContractId", "主键");
		purchaseContractIdField.setLength(11);
		purchaseContractIdField.setPrimaryKey(true);
		purchaseContractIdField.setRequired(true);
		purchaseContractIdField.setHidden(true);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(255);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(255);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(true);

		purchasePersonField = new DataSourceIntegerField("purchasePerson", "订购人");
		purchasePersonField.setLength(11);
		purchasePersonField.setRequired(false);
		purchasePersonField.setHidden(false);
		purchasePersonField.setValueMap(KeyValueManager.getValueMap("employees"));

		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setLength(16);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("##,###,###,###,##0.00");
		contractAmountField.setRequired(false);
		contractAmountField.setHidden(false);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "项目");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);

		qualityAssuranceField = new DataSourceTextField("qualityAssurance", "质保");
		qualityAssuranceField.setLength(255);
		qualityAssuranceField.setRequired(false);
		qualityAssuranceField.setHidden(false);

		contractDateField = new DataSourceDateField("contractDate", "合同签订日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(false);

		termOfPaymentField = new DataSourceTextField("termOfPayment", "付款条件");
		termOfPaymentField.setLength(1024);
		termOfPaymentField.setRequired(false);
		termOfPaymentField.setHidden(false);

		afterSaleRequirementsField = new DataSourceTextField("afterSaleRequirements", "售后要求");
		afterSaleRequirementsField.setLength(512);
		afterSaleRequirementsField.setRequired(false);
		afterSaleRequirementsField.setHidden(false);

		amountPaidField = new DataSourceFloatField("amountPaid", "已付金额");
		amountPaidField.setLength(16);
		amountPaidField.setDecimalPad(2);
		amountPaidField.setFormat("##,###,###,###,##0.00");
		amountPaidField.setRequired(false);
		amountPaidField.setHidden(true);

		amountUnpaidField = new DataSourceFloatField("amountUnpaid", "未付金额");
		amountUnpaidField.setLength(16);
		amountUnpaidField.setDecimalPad(2);
		amountUnpaidField.setFormat("##,###,###,###,##0.00");
		amountUnpaidField.setRequired(false);
		amountUnpaidField.setHidden(true);

		haveInvoiceAmountField = new DataSourceFloatField("haveInvoiceAmount", "已开票金额");
		haveInvoiceAmountField.setLength(16);
		haveInvoiceAmountField.setDecimalPad(2);
		haveInvoiceAmountField.setFormat("##,###,###,###,##0.00");
		haveInvoiceAmountField.setRequired(false);
		haveInvoiceAmountField.setHidden(true);

		lackInvoiceAmountField = new DataSourceFloatField("lackInvoiceAmount", "未开票金额");
		lackInvoiceAmountField.setLength(16);
		lackInvoiceAmountField.setDecimalPad(2);
		lackInvoiceAmountField.setFormat("##,###,###,###,##0.00");
		lackInvoiceAmountField.setRequired(false);
		lackInvoiceAmountField.setHidden(true);

		contractAttachmentField = new DataSourceIntegerField("contractAttachment", "合同附近-扫描件(关联file_manage)");
		contractAttachmentField.setLength(11);
		contractAttachmentField.setRequired(false);
		contractAttachmentField.setHidden(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程业务表主键");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

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
		majorContactPersonField.setHidden(true);

		contactPhoneField = new DataSourceTextField("contactPhone", "客户联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(true);
		
		fileUrlField = new DataSourceLinkField("fileUrl", "合同附件");

		detailPurchasePayment = new DataSourceField("detailPurchasePayment", FieldType.ANY);
		detailPurchasePayment.setChildrenProperty(true);
		detailPurchasePayment.setChildTagName("PurchasePayment");
		detailPurchasePayment.setRequired(false);
		detailPurchasePayment.setHidden(true);
		detailPurchaseProductDetail = new DataSourceField("detailPurchaseProductDetail", FieldType.ANY);
		detailPurchaseProductDetail.setChildrenProperty(true);
		detailPurchaseProductDetail.setChildTagName("PurchaseProductDetail");
		detailPurchaseProductDetail.setRequired(false);
		detailPurchaseProductDetail.setHidden(true);

		setFields(purchaseContractIdField, contractNameField, contractCodeField, supplierIdField, purchasePersonField,
				contractAmountField, mainProjectIdField, qualityAssuranceField, contractDateField, termOfPaymentField,
				afterSaleRequirementsField, amountPaidField, amountUnpaidField, haveInvoiceAmountField,
				lackInvoiceAmountField, contractAttachmentField, personnelBusinessIdField, createTimeField,
				projectNameField, projectCodeField, supplierNameField, abbreviatedNameField, majorContactPersonField,
				contactPhoneField, fileUrlField, detailPurchasePayment, detailPurchaseProductDetail);
	}

}
