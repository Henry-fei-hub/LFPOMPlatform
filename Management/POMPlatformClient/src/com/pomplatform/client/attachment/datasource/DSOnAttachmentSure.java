package com.pomplatform.client.attachment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnAttachmentSure extends DBDataSource
{


	public static DSOnAttachmentSure instance = null;

	public static DSOnAttachmentSure getInstance() {
		if(instance == null) {
			instance = new DSOnAttachmentSure("DSOnAttachmentSure");
		}
		return instance;
	}

	private final DataSourceIntegerField projectLinkAttachmentRecordIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceLinkField attachmentAddressField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSOnAttachmentSure(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectLinkAttachmentRecord");


		projectLinkAttachmentRecordIdField = new DataSourceIntegerField("projectLinkAttachmentRecordId", "主键编码");
		projectLinkAttachmentRecordIdField.setLength(11);
		projectLinkAttachmentRecordIdField.setPrimaryKey(true);
		projectLinkAttachmentRecordIdField.setRequired(true);
		projectLinkAttachmentRecordIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(128);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);
		
		
		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(false);
		sheetCodeField.setHidden(false);
		
		
		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setLength(128);
		sheetNameField.setRequired(false);
		sheetNameField.setHidden(false);
		
		
		attachmentCodeField = new DataSourceTextField("attachmentCode", "附件编号");
		attachmentCodeField.setLength(64);
		attachmentCodeField.setRequired(false);
		attachmentCodeField.setHidden(false);
		
		
		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(128);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(false);


		attachmentAddressField = new DataSourceLinkField("attachmentAddress", "附件路径");
		attachmentAddressField.setLength(512);
		attachmentAddressField.setRequired(false);
		attachmentAddressField.setHidden(false);


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

		setFields(projectLinkAttachmentRecordIdField, contractCodeField, contractNameField,sheetCodeField,sheetNameField,attachmentCodeField, attachmentNameField, attachmentAddressField, operateEmployeeIdField, operateTimeField, remarkField);
	}


}

