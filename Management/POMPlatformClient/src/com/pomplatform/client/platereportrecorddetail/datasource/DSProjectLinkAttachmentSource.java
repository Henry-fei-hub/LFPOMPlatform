package com.pomplatform.client.platereportrecorddetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceLinkField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectLinkAttachmentSource extends DBDataSource {

	public static DSProjectLinkAttachmentSource instance = null;

	public static DSProjectLinkAttachmentSource getInstance() {
		if (instance == null) {
			instance = new DSProjectLinkAttachmentSource("DSProjectLinkAttachmentSource");
		}
		return instance;
	}

	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceTextField attachmentCodeField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceLinkField attachmentAddressField;

	public DSProjectLinkAttachmentSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("DSProjectLinkAttachment");

		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "主键ID");
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setRequired(false);
		attachmentManageIdField.setHidden(true);
		attachmentManageIdField.setCanEdit(false);

		attachmentCodeField = new DataSourceTextField("attachmentCode", "确认函编码");
		attachmentCodeField.setLength(18);
		attachmentCodeField.setCanEdit(false);
		
		attachmentNameField = new DataSourceTextField("attachmentName", "确认函名称");
		attachmentNameField.setLength(18);
		attachmentNameField.setCanEdit(false);
		
		attachmentAddressField = new DataSourceLinkField("attachmentAddress","确认函");
		attachmentAddressField.setLength(64);
		attachmentAddressField.setCanEdit(false);

		setFields(attachmentManageIdField, attachmentCodeField,attachmentNameField,attachmentAddressField);
	}

}
