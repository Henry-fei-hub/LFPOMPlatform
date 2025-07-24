package com.pomplatform.client.cwd.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSSoftwareUpdateVersionWithS extends DBDataSource {

	public static DSSoftwareUpdateVersionWithS instance = null;

	public static DSSoftwareUpdateVersionWithS getInstance() {
		if (instance == null) {
			instance = new DSSoftwareUpdateVersionWithS("DSSoftwareUpdateVersionWithS");
		}
		return instance;
	}

	private final DataSourceIntegerField softwareUpdateVersionIdField;
	private final DataSourceFloatField versionNoField;
	private final DataSourceTextField titleField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField softwareTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField sqlScriptField;
	private final DataSourceBooleanField isRebootField;
	private final DataSourceField detailSoftwareUpdateFile;

	public DSSoftwareUpdateVersionWithS(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SoftwareUpdateVersionWithS");

		softwareUpdateVersionIdField = new DataSourceIntegerField("softwareUpdateVersionId", "主键");
		softwareUpdateVersionIdField.setLength(11);
		softwareUpdateVersionIdField.setPrimaryKey(true);
		softwareUpdateVersionIdField.setRequired(true);
		softwareUpdateVersionIdField.setHidden(true);

		versionNoField = new DataSourceFloatField("versionNo", "版本号");
		versionNoField.setLength(8);
		versionNoField.setDecimalPad(1);
		versionNoField.setFormat("#,###,##0.0");
		versionNoField.setRequired(true);
		versionNoField.setHidden(false);

		titleField = new DataSourceTextField("title", "更新主题");
		titleField.setLength(255);
		titleField.setRequired(false);
		titleField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "更新详情描述,说明更新了什么内容");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		softwareTypeField = new DataSourceIntegerField("softwareType", "软件类型");
		softwareTypeField.setLength(11);
		softwareTypeField.setRequired(false);
		softwareTypeField.setHidden(false);
		softwareTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_201"));

		employeeIdField = new DataSourceIntegerField("employeeId", "操作人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		sqlScriptField = new DataSourceTextField("sqlScript", "sql脚本");
		sqlScriptField.setLength(1024);
		sqlScriptField.setRequired(false);
		sqlScriptField.setHidden(false);

		isRebootField = new DataSourceBooleanField("isReboot", "是否需要重启服务");
		isRebootField.setRequired(false);
		isRebootField.setHidden(false);

		detailSoftwareUpdateFile = new DataSourceField("detailSoftwareUpdateFile", FieldType.ANY);
		detailSoftwareUpdateFile.setChildrenProperty(true);
		detailSoftwareUpdateFile.setChildTagName("SoftwareUpdateFile");
		detailSoftwareUpdateFile.setRequired(false);
		detailSoftwareUpdateFile.setHidden(true);

		setFields(softwareUpdateVersionIdField, versionNoField, titleField, remarkField, softwareTypeField,
				employeeIdField, createTimeField, sqlScriptField, isRebootField, detailSoftwareUpdateFile);
	}

}
