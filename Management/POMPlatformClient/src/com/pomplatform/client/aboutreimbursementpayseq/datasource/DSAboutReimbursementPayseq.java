package com.pomplatform.client.aboutreimbursementpayseq.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAboutReimbursementPayseq extends DBDataSource
{


	public static DSAboutReimbursementPayseq instance = null;

	public static DSAboutReimbursementPayseq getInstance() {
		if(instance == null) {
			instance = new DSAboutReimbursementPayseq("DSAboutReimbursementPayseq");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField uploadEmployeeIdField;
	private final DataSourceDateTimeField uploadTimeField;
	private final DataSourceTextField uploadRemarkField;
	private final DataSourceFloatField payAmountField;
	private final DataSourceFloatField reimbursementAmountField;
	private final DataSourceFloatField reverseAmountField;
	private final DataSourceFloatField returnAmountField;
	private final DataSourceFloatField budgetContractAmountField;
	private final DataSourceFloatField budgetContractAmountUseField;
	private final DataSourceFloatField budgetContractAmountRestField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceTextField bddTypeField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField payPercentField;

	public DSAboutReimbursementPayseq(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AboutReimbursementPayseq");


		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "主键id");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setPrimaryKey(true);
		budgetAttachmentIdField.setRequired(true);
		budgetAttachmentIdField.setHidden(false);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setHidden(false);


		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(false);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(1024);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		uploadEmployeeIdField = new DataSourceIntegerField("uploadEmployeeId", "上传人员");
		uploadEmployeeIdField.setLength(11);
		uploadEmployeeIdField.setRequired(false);
		uploadEmployeeIdField.setHidden(false);


		uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(false);


		uploadRemarkField = new DataSourceTextField("uploadRemark", "附件备注");
		uploadRemarkField.setLength(2048);
		uploadRemarkField.setRequired(false);
		uploadRemarkField.setHidden(false);


		payAmountField = new DataSourceFloatField("payAmount", "付款序列金额");
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


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "供应商");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(false);


		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(true);


		bddTypeField = new DataSourceTextField("bddType", "预算类别");
		bddTypeField.setLength(32);
		bddTypeField.setRequired(false);
		bddTypeField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		payPercentField = new DataSourceTextField("payPercent", "付款比例");
		payPercentField.setLength(-1);
		payPercentField.setRequired(true);
		payPercentField.setHidden(true);


		setFields(budgetAttachmentIdField, budgetManagementIdField, fileIdField, attachmentNameField, uploadEmployeeIdField, uploadTimeField, uploadRemarkField, payAmountField, reimbursementAmountField, reverseAmountField, returnAmountField, budgetContractAmountField, budgetContractAmountUseField, budgetContractAmountRestField, receiveUnitManageIdField, fileUrlField, bddTypeField, projectIdField, payPercentField);
	}


}

