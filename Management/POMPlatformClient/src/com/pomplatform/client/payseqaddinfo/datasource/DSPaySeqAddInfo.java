package com.pomplatform.client.payseqaddinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPaySeqAddInfo extends DBDataSource
{


	public static DSPaySeqAddInfo instance = null;

	public static DSPaySeqAddInfo getInstance() {
		if(instance == null) {
			instance = new DSPaySeqAddInfo("DSPaySeqAddInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField paymentSequenceIdField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceFloatField payAmountField;
	private final DataSourceDateTimeField payDateField;
	private final DataSourceIntegerField payStatusField;
	private final DataSourceTextField psRemarkField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField processBillListIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField bindStatusField;
	private final DataSourceIntegerField payTypeField;
	private final DataSourceBooleanField isLockField;
	private final DataSourceFloatField reimbursementAmountField;
	private final DataSourceFloatField reverseAmountField;
	private final DataSourceDateTimeField applyPayDateField;
	private final DataSourceFloatField returnAmountField;
	private final DataSourceIntegerField payForField;
	private final DataSourceTextField payNameField;
	private final DataSourceTextField reimbursementCodeField;

	public DSPaySeqAddInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PaySeqAddInfo");


		paymentSequenceIdField = new DataSourceIntegerField("paymentSequenceId", "主键id");
		paymentSequenceIdField.setLength(11);
		paymentSequenceIdField.setPrimaryKey(true);
		paymentSequenceIdField.setRequired(true);
		paymentSequenceIdField.setHidden(false);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setHidden(false);


		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "预算附件id");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setRequired(false);
		budgetAttachmentIdField.setHidden(false);


		payAmountField = new DataSourceFloatField("payAmount", "付款金额");
		payAmountField.setLength(18);
		payAmountField.setDecimalPad(2);
		payAmountField.setFormat("#,###,###,###,###,##0.00");
		payAmountField.setRequired(false);
		payAmountField.setHidden(false);


		payDateField = new DataSourceDateTimeField("payDate", "付款日期");
		payDateField.setRequired(false);
		payDateField.setHidden(false);


		payStatusField = new DataSourceIntegerField("payStatus", "付款状态");
		payStatusField.setLength(11);
		payStatusField.setRequired(false);
		payStatusField.setHidden(false);


		psRemarkField = new DataSourceTextField("psRemark", "付款序列备注");
		psRemarkField.setLength(2048);
		psRemarkField.setRequired(false);
		psRemarkField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "年");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "收款单位编码");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(false);


		processBillListIdField = new DataSourceIntegerField("processBillListId", "流水编码");
		processBillListIdField.setLength(11);
		processBillListIdField.setRequired(false);
		processBillListIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "关联的项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		bindStatusField = new DataSourceIntegerField("bindStatus", "绑定状态 0.未绑定，1.已绑定");
		bindStatusField.setLength(11);
		bindStatusField.setRequired(false);
		bindStatusField.setHidden(false);


		payTypeField = new DataSourceIntegerField("payType", "付款类型");
		payTypeField.setLength(11);
		payTypeField.setRequired(false);
		payTypeField.setHidden(false);


		isLockField = new DataSourceBooleanField("isLock", "是否加锁");
		isLockField.setRequired(false);
		isLockField.setHidden(false);


		reimbursementAmountField = new DataSourceFloatField("reimbursementAmount", "报销金额");
		reimbursementAmountField.setLength(18);
		reimbursementAmountField.setDecimalPad(2);
		reimbursementAmountField.setFormat("#,###,###,###,###,##0.00");
		reimbursementAmountField.setRequired(false);
		reimbursementAmountField.setHidden(true);


		reverseAmountField = new DataSourceFloatField("reverseAmount", "冲账金额");
		reverseAmountField.setLength(18);
		reverseAmountField.setDecimalPad(2);
		reverseAmountField.setFormat("#,###,###,###,###,##0.00");
		reverseAmountField.setRequired(false);
		reverseAmountField.setHidden(true);


		applyPayDateField = new DataSourceDateTimeField("applyPayDate", "付款申请日期");
		applyPayDateField.setRequired(false);
		applyPayDateField.setHidden(true);


		returnAmountField = new DataSourceFloatField("returnAmount", "还款金额");
		returnAmountField.setLength(18);
		returnAmountField.setDecimalPad(2);
		returnAmountField.setFormat("#,###,###,###,###,##0.00");
		returnAmountField.setRequired(false);
		returnAmountField.setHidden(true);
		
		payForField = new DataSourceIntegerField("payType", "付款类型");
		payForField.setLength(11);
		payForField.setRequired(false);
		payForField.setHidden(false);

		
		payNameField = new DataSourceTextField("psRemark", "付款序列备注");
		payNameField.setLength(2048);
		payNameField.setRequired(false);
		payNameField.setHidden(false);
		
		reimbursementCodeField = new DataSourceTextField("reimbursementCode", "报销编号");
		reimbursementCodeField.setLength(64);
		reimbursementCodeField.setRequired(false);
		reimbursementCodeField.setHidden(true);

		setFields(paymentSequenceIdField, budgetManagementIdField, budgetAttachmentIdField, payAmountField, payDateField, payStatusField, psRemarkField, yearField, monthField, receiveUnitManageIdField, processBillListIdField, projectIdField, bindStatusField, payTypeField, isLockField, reimbursementAmountField, reverseAmountField, applyPayDateField, returnAmountField,payForField,payNameField,reimbursementCodeField);
	}


}

