package com.pomplatform.client.attachment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSAttachmentEmp extends DBDataSource {

	public static DSAttachmentEmp instance = null;

	public static DSAttachmentEmp getInstance() {
		if (instance == null) {
			instance = new DSAttachmentEmp("DSAttachmentEmp");
		}
		return instance;
	}

	private final DataSourceIntegerField attachmentManageEmployeeIdField;
	private final DataSourceIntegerField attachmentManageIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField employeeTypeField;
	private final DataSourceIntegerField operatorField;

	public DSAttachmentEmp(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttachmentEmp");
 
		attachmentManageEmployeeIdField = new DataSourceIntegerField("attachmentManageEmployeeId", "主键编码");
		attachmentManageEmployeeIdField.setLength(11);
		attachmentManageEmployeeIdField.setRequired(true);
		attachmentManageEmployeeIdField.setHidden(false);

		attachmentManageIdField = new DataSourceIntegerField("attachmentManageId", "合同编码");
		attachmentManageIdField.setLength(11);
		attachmentManageIdField.setRequired(false);
		attachmentManageIdField.setHidden(true);
		
		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		employeeTypeField = new DataSourceIntegerField("employeeType", "员工类型");
		employeeTypeField.setLength(11);
		employeeTypeField.setRequired(false);
		employeeTypeField.setHidden(true);
		
		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);

		setFields(attachmentManageIdField, attachmentManageIdField, employeeIdField, employeeTypeField, operatorField);
	}

}
