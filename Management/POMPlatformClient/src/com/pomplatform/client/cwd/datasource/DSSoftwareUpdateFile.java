package com.pomplatform.client.cwd.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSoftwareUpdateFile extends DBDataSource {

	public static DSSoftwareUpdateFile instance = null;

	public static DSSoftwareUpdateFile getInstance() {
		if (instance == null) {
			instance = new DSSoftwareUpdateFile("DSSoftwareUpdateFile");
		}
		return instance;
	}

	private final DataSourceIntegerField softwareUpdateFileIdField;
	private final DataSourceTextField toFilePathField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField softwareUpdateVersionIdField;

	public DSSoftwareUpdateFile(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SoftwareUpdateFile");

		softwareUpdateFileIdField = new DataSourceIntegerField("softwareUpdateFileId", "软件文件更新编码");
		softwareUpdateFileIdField.setLength(11);
		softwareUpdateFileIdField.setPrimaryKey(true);
		softwareUpdateFileIdField.setRequired(true);
		softwareUpdateFileIdField.setHidden(true);

		toFilePathField = new DataSourceTextField("toFilePath", "相对文件路径");
		toFilePathField.setLength(1024);
		toFilePathField.setRequired(true);
		toFilePathField.setHidden(false);

		fileIdField = new DataSourceIntegerField("fileId", "文件管理表主键");
		fileIdField.setLength(11);
		fileIdField.setRequired(true);
		fileIdField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		softwareUpdateVersionIdField = new DataSourceIntegerField("softwareUpdateVersionId", "更新版本主键");
		softwareUpdateVersionIdField.setLength(11);
		softwareUpdateVersionIdField.setRequired(false);
		softwareUpdateVersionIdField.setHidden(true);

		setFields(softwareUpdateFileIdField, toFilePathField, fileIdField, remarkField, softwareUpdateVersionIdField);
	}

}
