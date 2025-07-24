package com.pomplatform.client.budgetmanagement.panel;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBudgetAttachmentDetail extends DBDataSource
{


	public static DSBudgetAttachmentDetail instance = null;

	public static DSBudgetAttachmentDetail getInstance() {
		if(instance == null) {
			instance = new DSBudgetAttachmentDetail("DSBudgetAttachmentDetail");
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
	private final DataSourceFloatField budgetContractAmountField;
	private final DataSourceIntegerField receiveUnitManageIdField;
	private final DataSourceLinkField  fileUrlField;

	public DSBudgetAttachmentDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BudgetAttachmentDetail");


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


		budgetContractAmountField = new DataSourceFloatField("budgetContractAmount", "合同金额");
		budgetContractAmountField.setLength(18);
		budgetContractAmountField.setDecimalPad(2);
		budgetContractAmountField.setFormat("#,###,###,###,###,##0.00");
		budgetContractAmountField.setRequired(false);
		budgetContractAmountField.setHidden(false);


		receiveUnitManageIdField = new DataSourceIntegerField("receiveUnitManageId", "供应商");
		receiveUnitManageIdField.setLength(11);
		receiveUnitManageIdField.setRequired(false);
		receiveUnitManageIdField.setHidden(false);


		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		setFields(budgetAttachmentIdField, budgetManagementIdField, fileIdField, attachmentNameField, uploadEmployeeIdField, uploadTimeField, uploadRemarkField, budgetContractAmountField, receiveUnitManageIdField, fileUrlField);
	}


}

