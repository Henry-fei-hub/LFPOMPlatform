package com.pomplatform.client.attachmentapproval.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAttachmentApproval extends DBDataSource
{


	public static DSAttachmentApproval instance = null;

	public static DSAttachmentApproval getInstance() {
		if(instance == null) {
			instance = new DSAttachmentApproval("DSAttachmentApproval");
		}
		return instance;
	}

	private final DataSourceIntegerField budgetAttachmentIdField;
	private final DataSourceIntegerField budgetManagementIdField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceIntegerField uploadEmployeeIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateTimeField uploadTimeField;
	private final DataSourceTextField uploadRemarkField;
	private final DataSourceFloatField budgetContractAmountField;
	private final DataSourceFloatField budgetContractAmountUseField;
	private final DataSourceFloatField budgetContractAmountRestField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField inputTaxInvoiceIdField;
	private final DataSourceTextField bddTypeField;
	private final DataSourceIntegerField isApprovalField;

	public DSAttachmentApproval(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttachmentApproval");


		budgetAttachmentIdField = new DataSourceIntegerField("budgetAttachmentId", "主键id");
		budgetAttachmentIdField.setLength(11);
		budgetAttachmentIdField.setPrimaryKey(true);
		budgetAttachmentIdField.setRequired(true);
		budgetAttachmentIdField.setHidden(true);


		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setHidden(true);


		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(1024);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		uploadEmployeeIdField = new DataSourceIntegerField("uploadEmployeeId", "上传人员");
		uploadEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		uploadEmployeeIdField.setLength(11);
		uploadEmployeeIdField.setRequired(false);
		uploadEmployeeIdField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "上传人员归属部门");
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(false);


		uploadRemarkField = new DataSourceTextField("uploadRemark", "附件备注");
		uploadRemarkField.setLength(2048);
		uploadRemarkField.setRequired(false);
		uploadRemarkField.setHidden(false);


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
//		receiveUnitManageIdField.setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",receiveUnitManageIdField);
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目");
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "发票编码");
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setRequired(false);
		inputTaxInvoiceIdField.setHidden(true);


		bddTypeField = new DataSourceTextField("bddType", "预算类别");
		bddTypeField.setLength(255);
		bddTypeField.setRequired(false);
		bddTypeField.setHidden(false);


		isApprovalField = new DataSourceIntegerField("isApproval", "是否审批");
		isApprovalField.setValueMap(KeyValueManager.getValueMap("system_dictionary_192"));
		isApprovalField.setLength(11);
		isApprovalField.setRequired(false);
		isApprovalField.setHidden(true);


		setFields(budgetAttachmentIdField, budgetManagementIdField, fileIdField, attachmentNameField, uploadEmployeeIdField, departmentIdField, uploadTimeField, uploadRemarkField, budgetContractAmountField, budgetContractAmountUseField, budgetContractAmountRestField, receiveUnitManageIdField, projectIdField, inputTaxInvoiceIdField, bddTypeField, isApprovalField);
	}


}

