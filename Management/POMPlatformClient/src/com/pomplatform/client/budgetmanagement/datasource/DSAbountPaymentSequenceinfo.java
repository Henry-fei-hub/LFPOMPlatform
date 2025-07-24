package com.pomplatform.client.budgetmanagement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAbountPaymentSequenceinfo extends DBDataSource
{


	public static DSAbountPaymentSequenceinfo instance = null;

	public static DSAbountPaymentSequenceinfo getInstance() {
		if(instance == null) {
			instance = new DSAbountPaymentSequenceinfo("DSAbountPaymentSequenceinfo");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceFloatField payAmountField;
	private final DataSourceFloatField reimbursementAmountField;
	private final DataSourceFloatField reverseAmountField;
	private final DataSourceFloatField returnAmountField;
	private final DataSourceDateTimeField payDateField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField payTypeField;
	private final DataSourceTextField psRemarkField;
	private final DataSourceIntegerField payStatusField;
	private final DataSourceDateTimeField applyPayDateField;
	private final DataSourceFloatField budgetContractAmountField;
	private final DataSourceFloatField budgetContractAmountUseField;
	private final DataSourceFloatField budgetContractAmountRestField;
	private final DataSourceTextField payPercentField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField payForField;
	private final DataSourceTextField payNameField;
	private final DataSourceIntegerField paymentSequenceIdField;
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processIdField;
	public DSAbountPaymentSequenceinfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AbountPaymentSequenceinfo");


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setHidden(false);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(1024);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		payAmountField = new DataSourceFloatField("payAmount", "付款金额");
		payAmountField.setLength(18);
		payAmountField.setDecimalPad(2);
		payAmountField.setFormat("#,###,###,###,###,##0.00");
		payAmountField.setRequired(false);
		payAmountField.setHidden(false);


		reimbursementAmountField = new DataSourceFloatField("reimbursementAmount", "报销金额");
		reimbursementAmountField.setLength(18);
		reimbursementAmountField.setDecimalPad(2);
		reimbursementAmountField.setFormat("#,###,###,###,###,##0.00");
		reimbursementAmountField.setRequired(false);
		reimbursementAmountField.setHidden(false);


		reverseAmountField = new DataSourceFloatField("reverseAmount", "冲账金额");
		reverseAmountField.setLength(18);
		reverseAmountField.setDecimalPad(2);
		reverseAmountField.setFormat("#,###,###,###,###,##0.00");
		reverseAmountField.setRequired(false);
		reverseAmountField.setHidden(false);
		
		returnAmountField = new DataSourceFloatField("returnAmount", "还款金额");
		returnAmountField.setLength(18);
		returnAmountField.setDecimalPad(2);
		returnAmountField.setFormat("#,###,###,###,###,##0.00");
		returnAmountField.setRequired(false);
		returnAmountField.setHidden(false);


		payDateField = new DataSourceDateTimeField("payDate", "付款日期");
		payDateField.setRequired(false);
		payDateField.setHidden(false);


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "供应商");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(false);


		payTypeField = new DataSourceIntegerField("payType", "付款类型");
		payTypeField.setLength(11);
		payTypeField.setRequired(false);
		payTypeField.setHidden(false);


		psRemarkField = new DataSourceTextField("psRemark", "付款序列备注");
		psRemarkField.setLength(2048);
		psRemarkField.setRequired(false);
		psRemarkField.setHidden(false);


		payStatusField = new DataSourceIntegerField("payStatus", "付款状态");
		payStatusField.setLength(11);
		payStatusField.setRequired(false);
		payStatusField.setHidden(false);


		applyPayDateField = new DataSourceDateTimeField("applyPayDate", "付款申请日期");
		applyPayDateField.setRequired(false);
		applyPayDateField.setHidden(false);


		budgetContractAmountField = new DataSourceFloatField("budgetContractAmount", "合同金额");
		budgetContractAmountField.setLength(18);
		budgetContractAmountField.setDecimalPad(2);
		budgetContractAmountField.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountField.setRequired(false);
		budgetContractAmountField.setHidden(false);


		budgetContractAmountUseField = new DataSourceFloatField("budgetContractAmountUse", "合同已付款金额");
		budgetContractAmountUseField.setLength(18);
		budgetContractAmountUseField.setDecimalPad(2);
		budgetContractAmountUseField.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountUseField.setRequired(false);
		budgetContractAmountUseField.setHidden(false);


		budgetContractAmountRestField = new DataSourceFloatField("budgetContractAmountRest", "剩余合同金额");
		budgetContractAmountRestField.setLength(18);
		budgetContractAmountRestField.setDecimalPad(2);
		budgetContractAmountRestField.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountRestField.setRequired(false);
		budgetContractAmountRestField.setHidden(false);


		payPercentField = new DataSourceTextField("payPercent", "付款比例");
		payPercentField.setLength(-1);
		payPercentField.setRequired(true);
		payPercentField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "关联的项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
		
		payForField=new DataSourceIntegerField("payFor","收款方类型");
		payForField.setLength(11);
		payForField.setRequired(false);
		payForField.setHidden(true);
		
		payNameField = new DataSourceTextField("payName", "收款方名称");
		payNameField.setLength(-1);
		payNameField.setRequired(true);
		payNameField.setHidden(true);
		
		paymentSequenceIdField = new DataSourceIntegerField("paymentSequenceId", "主键id");
		paymentSequenceIdField.setLength(11);
		paymentSequenceIdField.setPrimaryKey(true);
		paymentSequenceIdField.setRequired(true);
		paymentSequenceIdField.setHidden(true);


		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "预算附件id");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setRequired(false);
		budgetAttachmentIdField.setHidden(true);

		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "process_id");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);
		setFields(budgetManagementIdField, attachmentNameField, fileUrlField, payAmountField, reimbursementAmountField, returnAmountField,reverseAmountField, payDateField, receiveUnitManageIdField, payTypeField, psRemarkField, payStatusField, applyPayDateField, budgetContractAmountField, budgetContractAmountUseField, budgetContractAmountRestField, payPercentField, projectIdField,payForField,payNameField,paymentSequenceIdField,budgetAttachmentIdField,processTypeField,processIdField);
	}


}

