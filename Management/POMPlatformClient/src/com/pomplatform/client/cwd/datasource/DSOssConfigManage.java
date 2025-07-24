package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOssConfigManage extends DBDataSource
{


	public static DSOssConfigManage instance = null;

	public static DSOssConfigManage getInstance() {
		if(instance == null) {
			instance = new DSOssConfigManage("DSOssConfigManage");
		}
		return instance;
	}

	private final DataSourceIntegerField ossConfigIdField;
	private final DataSourceTextField ossAddressField;
	private final DataSourceTextField ossBucketField;
	private final DataSourceTextField ossAccessKeyIdField;
	private final DataSourceTextField ossAccessKeySecretField;

	public DSOssConfigManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OssConfigManage");


		ossConfigIdField = new DataSourceIntegerField("ossConfigId", "oss_config_id");
		ossConfigIdField.setLength(11);
		ossConfigIdField.setPrimaryKey(true);
		ossConfigIdField.setRequired(true);
		ossConfigIdField.setHidden(true);


		ossAddressField = new DataSourceTextField("ossAddress", "oss地址");
		ossAddressField.setLength(512);
		ossAddressField.setRequired(false);
		ossAddressField.setHidden(false);


		ossBucketField = new DataSourceTextField("ossBucket", "oss存储空间");
		ossBucketField.setLength(256);
		ossBucketField.setRequired(false);
		ossBucketField.setHidden(false);


		ossAccessKeyIdField = new DataSourceTextField("ossAccessKeyId", "oss_access_key_id");
		ossAccessKeyIdField.setLength(256);
		ossAccessKeyIdField.setRequired(false);
		ossAccessKeyIdField.setHidden(false);


		ossAccessKeySecretField = new DataSourceTextField("ossAccessKeySecret", "oss_access_key_secret");
		ossAccessKeySecretField.setLength(256);
		ossAccessKeySecretField.setRequired(false);
		ossAccessKeySecretField.setHidden(false);


		setFields(ossConfigIdField, ossAddressField, ossBucketField, ossAccessKeyIdField, ossAccessKeySecretField);
	}


}

