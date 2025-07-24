package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.cwd.datasource.CDOssConfigManage;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OssConfigManageSearchForm extends SearchForm
{


	private final TextItem ossAddressItem;
	private final TextItem ossBucketItem;
	private final TextItem ossAccessKeyIdItem;
	private final TextItem ossAccessKeySecretItem;

	public OssConfigManageSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOssConfigManage.getInstance());
		
		ossAddressItem = new TextItem("ossAddress", "oss地址");
		ossAddressItem.setWidth("*");
		
		ossBucketItem = new TextItem("ossBucket", "oss存储空间");
		ossBucketItem.setWidth("*");
		
		ossAccessKeyIdItem = new TextItem("ossAccessKeyId", "oss_access_key_id");
		ossAccessKeyIdItem.setWidth("*");
		
		ossAccessKeySecretItem = new TextItem("ossAccessKeySecret", "oss_access_key_secret");
		ossAccessKeySecretItem.setWidth("*");

		setItems(ossAddressItem, ossBucketItem, ossAccessKeyIdItem, ossAccessKeySecretItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
