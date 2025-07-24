package com.pomplatform.client.attachmentapproval.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAttachmentApproval extends DataSource
{


	public static CDAttachmentApproval instance = null;

	public static CDAttachmentApproval getInstance() {
		if(instance == null) {
			instance = new CDAttachmentApproval("CDAttachmentApproval");
		}
		return instance;
	}

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

	public CDAttachmentApproval(String dataSourceID) {

		setID(dataSourceID);
		budgetManagementIdField = new DataSourceIntegerField("budgetManagementId", "预算管理id");
		budgetManagementIdField.setRequired(false);
		budgetManagementIdField.setLength(11);
		budgetManagementIdField.setHidden(false);

		fileIdField = new DataSourceIntegerField("fileId", "附件编码");
		fileIdField.setRequired(false);
		fileIdField.setLength(11);
		fileIdField.setHidden(false);

		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setRequired(false);
		attachmentNameField.setLength(1024);
		attachmentNameField.setHidden(false);

		uploadEmployeeIdField = new DataSourceIntegerField("uploadEmployeeId", "上传人员");
		uploadEmployeeIdField.setRequired(false);
		uploadEmployeeIdField.setLength(11);
		uploadEmployeeIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "上传人员归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(false);

		uploadRemarkField = new DataSourceTextField("uploadRemark", "附件备注");
		uploadRemarkField.setRequired(false);
		uploadRemarkField.setLength(2048);
		uploadRemarkField.setHidden(false);

		budgetContractAmountField = new DataSourceFloatField("budgetContractAmount", "合同金额");
		budgetContractAmountField.setRequired(true);
		budgetContractAmountField.setLength(18);
		budgetContractAmountField.setHidden(false);

		budgetContractAmountUseField = new DataSourceFloatField("budgetContractAmountUse", "合同已付款金额");
		budgetContractAmountUseField.setRequired(true);
		budgetContractAmountUseField.setLength(18);
		budgetContractAmountUseField.setHidden(false);

		budgetContractAmountRestField = new DataSourceFloatField("budgetContractAmountRest", "剩余合同金额");
		budgetContractAmountRestField.setRequired(true);
		budgetContractAmountRestField.setLength(18);
		budgetContractAmountRestField.setHidden(false);

		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "供应商");
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		inputTaxInvoiceIdField = new DataSourceIntegerField("inputTaxInvoiceId", "发票编码");
		inputTaxInvoiceIdField.setRequired(false);
		inputTaxInvoiceIdField.setLength(11);
		inputTaxInvoiceIdField.setHidden(false);

		bddTypeField = new DataSourceTextField("bddType", "预算类别  budget_detail_type");
		bddTypeField.setRequired(false);
		bddTypeField.setLength(255);
		bddTypeField.setHidden(false);

		isApprovalField = new DataSourceIntegerField("isApproval", "是否审批 0.未审批 1.已审批");
		isApprovalField.setRequired(false);
		isApprovalField.setLength(11);
		isApprovalField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(budgetManagementIdField, fileIdField, attachmentNameField, uploadEmployeeIdField, departmentIdField, uploadTimeField, uploadRemarkField, budgetContractAmountField, budgetContractAmountUseField, budgetContractAmountRestField, receiveUnitManageIdField, projectIdField, inputTaxInvoiceIdField, bddTypeField, isApprovalField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

