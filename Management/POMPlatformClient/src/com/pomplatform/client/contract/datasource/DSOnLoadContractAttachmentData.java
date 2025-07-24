package com.pomplatform.client.contract.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadContractAttachmentData extends DBDataSource
{


	public static DSOnLoadContractAttachmentData instance = null;

	public static DSOnLoadContractAttachmentData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadContractAttachmentData("DSOnLoadContractAttachmentData");
		}
		return instance;
	}

	private final DataSourceIntegerField contractAttachmentIdField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField signingMoneySumField;
	private final DataSourceIntegerField uploadEmployeeIdField;
	private final DataSourceTextField uploadTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField isLinkField;
	private final DataSourceLinkField fileUrlField;

	public DSOnLoadContractAttachmentData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadContractAttachmentData");


		contractAttachmentIdField = new DataSourceIntegerField("contractAttachmentId", "主键编码");
		contractAttachmentIdField.setLength(11);
		contractAttachmentIdField.setPrimaryKey(true);
		contractAttachmentIdField.setRequired(true);
		contractAttachmentIdField.setHidden(true);


		fileIdField = new DataSourceIntegerField("fileId", "附件ID");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		attachmentCodeField = new DataSourceTextField("attachmentCode", "附件编号");
		attachmentCodeField.setLength(64);
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setHidden(false);


		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(64);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);
		
		companyIdField = new DataSourceTextField("companyId", "我方签约公司");
		companyIdField.setLength(64);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		signingMoneySumField = new DataSourceTextField("signingMoneySum", "合同金额");
		signingMoneySumField.setLength(64);
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);
		

		uploadEmployeeIdField = new DataSourceIntegerField("uploadEmployeeId", "上传人员");
		uploadEmployeeIdField.setLength(11);
		uploadEmployeeIdField.setRequired(false);
		uploadEmployeeIdField.setHidden(false);
		uploadEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		uploadTimeField = new DataSourceTextField("uploadTime", "上传时间");
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(2048);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		isLinkField = new DataSourceBooleanField("isLink", "是否已绑定合同");
		isLinkField.setRequired(true);
		isLinkField.setHidden(false);


		fileUrlField = new DataSourceLinkField("fileUrl", "文件路径");
		fileUrlField.setLength(1024);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		setFields(contractAttachmentIdField, fileIdField, attachmentCodeField, attachmentNameField,companyIdField,signingMoneySumField, uploadEmployeeIdField, uploadTimeField, remarkField, isLinkField, fileUrlField);
	}


}

