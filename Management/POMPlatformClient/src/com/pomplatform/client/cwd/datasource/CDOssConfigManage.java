package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOssConfigManage extends DataSource
{


	public static CDOssConfigManage instance = null;

	public static CDOssConfigManage getInstance() {
		if(instance == null) {
			instance = new CDOssConfigManage("CDOssConfigManage");
		}
		return instance;
	}

	private final DataSourceTextField ossAddressField;
	private final DataSourceTextField ossBucketField;
	private final DataSourceTextField ossAccessKeyIdField;
	private final DataSourceTextField ossAccessKeySecretField;

	public CDOssConfigManage(String dataSourceID) {

		setID(dataSourceID);
		ossAddressField = new DataSourceTextField("ossAddress", "oss地址");
		ossAddressField.setRequired(false);
		ossAddressField.setLength(512);
		ossAddressField.setHidden(false);

		ossBucketField = new DataSourceTextField("ossBucket", "oss存储空间");
		ossBucketField.setRequired(false);
		ossBucketField.setLength(256);
		ossBucketField.setHidden(false);

		ossAccessKeyIdField = new DataSourceTextField("ossAccessKeyId", "oss_access_key_id");
		ossAccessKeyIdField.setRequired(false);
		ossAccessKeyIdField.setLength(256);
		ossAccessKeyIdField.setHidden(false);

		ossAccessKeySecretField = new DataSourceTextField("ossAccessKeySecret", "oss_access_key_secret");
		ossAccessKeySecretField.setRequired(false);
		ossAccessKeySecretField.setLength(256);
		ossAccessKeySecretField.setHidden(false);

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


		setFields(ossAddressField, ossBucketField, ossAccessKeyIdField, ossAccessKeySecretField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

