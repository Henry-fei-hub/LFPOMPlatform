package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSoftwareUpdateVersionWithS extends DataSource
{


	public static CDSoftwareUpdateVersionWithS instance = null;

	public static CDSoftwareUpdateVersionWithS getInstance() {
		if(instance == null) {
			instance = new CDSoftwareUpdateVersionWithS("CDSoftwareUpdateVersionWithS");
		}
		return instance;
	}

	private final DataSourceTextField titleField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField sqlScriptField;
	private final DataSourceIntegerField softwareUpdateVersionIdField;
	private final DataSourceFloatField versionNoField;
	private final DataSourceIntegerField softwareTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceBooleanField isRebootField;

	public CDSoftwareUpdateVersionWithS(String dataSourceID) {

		setID(dataSourceID);
		titleField = new DataSourceTextField("title", "更新主题");
		titleField.setRequired(false);
		titleField.setLength(255);
		titleField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "更新详情描述,说明更新了什么内容");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		sqlScriptField = new DataSourceTextField("sqlScript", "sql脚本");
		sqlScriptField.setRequired(false);
		sqlScriptField.setLength(1024);
		sqlScriptField.setHidden(false);

		softwareUpdateVersionIdField = new DataSourceIntegerField("softwareUpdateVersionId", "主键");
		softwareUpdateVersionIdField.setRequired(true);
		softwareUpdateVersionIdField.setLength(11);
		softwareUpdateVersionIdField.setPrimaryKey(true);
		softwareUpdateVersionIdField.setHidden(true);

		versionNoField = new DataSourceFloatField("versionNo", "版本号唯一 初始1.0 每次加0.1");
		versionNoField.setRequired(true);
		versionNoField.setLength(8);
		versionNoField.setHidden(false);

		softwareTypeField = new DataSourceIntegerField("softwareType", "软件类型，1-本地文件服务器，2-本地存储服务器");
		softwareTypeField.setRequired(false);
		softwareTypeField.setLength(11);
		softwareTypeField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "操作人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		isRebootField = new DataSourceBooleanField("isReboot", "是否需要重启服务 true需要 false不需要");
		isRebootField.setRequired(false);
		isRebootField.setHidden(false);

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


		setFields(titleField, remarkField, sqlScriptField, softwareUpdateVersionIdField, versionNoField, softwareTypeField, employeeIdField, isRebootField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

