package com.pomplatform.client.onrevenue.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAttachmentRecord extends DBDataSource
{


	public static DSAttachmentRecord instance = null;

	public static DSAttachmentRecord getInstance() {
		if(instance == null) {
			instance = new DSAttachmentRecord("DSAttachmentRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField projectAttachmentIdField;
	private final DataSourceBooleanField isHandleField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceDateTimeField uploadTimeField;
	private final DataSourceLinkField attachmentFileField;

	public DSAttachmentRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AttachmentRecord");

		projectAttachmentIdField = new DataSourceIntegerField("projectAttachmentId", "ID");
		projectAttachmentIdField.setLength(11);
		projectAttachmentIdField.setRequired(false);
		projectAttachmentIdField.setHidden(true);
		
		isHandleField = new DataSourceBooleanField("isHandle", "是否处理");
		isHandleField.setLength(64);
		isHandleField.setHidden(true);
		isHandleField.setRequired(false);
		
		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);
		
		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(false);
		sheetCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(64);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);

		stageIdField = new DataSourceIntegerField("stageId", "上传阶段");
		stageIdField.setLength(64);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		uploadTimeField = new DataSourceDateTimeField("uploadTime", "上传时间");
		uploadTimeField.setLength(64);
		uploadTimeField.setRequired(false);
		uploadTimeField.setHidden(false);
		
		attachmentFileField = new DataSourceLinkField("attachmentFile", "文件路径");
		attachmentFileField.setLength(128);
		attachmentFileField.setRequired(false);
		attachmentFileField.setHidden(false);

		setFields(isHandleField,sheetCodeField, projectNameField, stageIdField, uploadTimeField,attachmentFileField);
	}


}

