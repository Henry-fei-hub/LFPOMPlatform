package com.pomplatform.client.attachment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadAttachmentDataOfAttachment extends DBDataSource
{


	public static DSOnLoadAttachmentDataOfAttachment instance = null;

	public static DSOnLoadAttachmentDataOfAttachment getInstance() {
		if(instance == null) {
			instance = new DSOnLoadAttachmentDataOfAttachment("DSOnLoadAttachmentDataOfAttachment");
		}
		return instance;
	}

	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceLinkField attachmentAddressField;
	private final DataSourceTextField perfessionRemarkField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField returnAmountField;
	private final DataSourceBooleanField paymentSureField;
	private final DataSourceTextField paymentGradeDescriptionField;
	private final DataSourceIntegerField serialNumberField;
	private final DataSourceDateField recordDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceBooleanField haveVoucherField;
	private final DataSourceBooleanField confirmationLetterField;

	public DSOnLoadAttachmentDataOfAttachment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadAttachmentDataOfAttachment");


		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "主键编码");
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setPrimaryKey(true);
		attachmentManageIdField.setRequired(true);
		attachmentManageIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		attachmentCodeField = new DataSourceTextField("attachmentCode", "编号");
		attachmentCodeField.setLength(64);
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setHidden(false);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(128);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);


		attachmentAddressField = new DataSourceLinkField("attachmentAddress", "附件路径");
		attachmentAddressField.setLength(128);
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setHidden(false);


		perfessionRemarkField = new DataSourceTextField("perfessionRemark", "专业备注");
		perfessionRemarkField.setLength(128);
		perfessionRemarkField.setRequired(false);
		perfessionRemarkField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "金额");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		returnAmountField = new DataSourceFloatField("returnAmount", "回款金额");
		returnAmountField.setLength(18);
		returnAmountField.setDecimalPad(2);
		returnAmountField.setFormat("#,###,###,###,###,##0.00");
		returnAmountField.setRequired(false);
		returnAmountField.setHidden(false);


		paymentSureField = new DataSourceBooleanField("paymentSure", "收款确认");
		paymentSureField.setRequired(false);
		paymentSureField.setHidden(false);


		paymentGradeDescriptionField = new DataSourceTextField("paymentGradeDescription", "收款阶段描述");
		paymentGradeDescriptionField.setLength(512);
		paymentGradeDescriptionField.setRequired(false);
		paymentGradeDescriptionField.setHidden(false);


		serialNumberField = new DataSourceIntegerField("serialNumber", "序列号(生成编号的序号)");
		serialNumberField.setLength(11);
		serialNumberField.setRequired(false);
		serialNumberField.setHidden(true);


		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);
		
		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "绑定发票金额");
		invoiceAmountField.setLength(18);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("#,###,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);

		haveVoucherField = new DataSourceBooleanField("haveVoucher", "有无凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(false);

		confirmationLetterField = new DataSourceBooleanField("confirmationLetter", "是否回收");
		confirmationLetterField.setRequired(false);
		confirmationLetterField.setHidden(false);
		
		
		setFields(attachmentManageIdField, contractIdField, attachmentCodeField, attachmentNameField, attachmentAddressField, perfessionRemarkField, amountField, returnAmountField, invoiceAmountField, paymentSureField, paymentGradeDescriptionField, serialNumberField, recordDateField, operateEmployeeIdField, operateTimeField, remarkField, contractNameField,confirmationLetterField, haveVoucherField);
	}


}

