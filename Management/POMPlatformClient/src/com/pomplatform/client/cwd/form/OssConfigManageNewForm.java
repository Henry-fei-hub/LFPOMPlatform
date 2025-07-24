package com.pomplatform.client.cwd.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.cwd.datasource.DSOssConfigManage;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OssConfigManageNewForm extends AbstractWizadPage
{


	private final TextItem ossAddressItem;
	private final TextItem ossBucketItem;
	private final TextItem ossAccessKeyIdItem;
	private final TextItem ossAccessKeySecretItem;

	public OssConfigManageNewForm() {
		DSOssConfigManage ds = DSOssConfigManage.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		ossAddressItem = new TextItem("ossAddress", "oss地址");
		ossAddressItem.setWidth("*");
		__formItems.add(ossAddressItem);
		
		ossBucketItem = new TextItem("ossBucket", "oss存储空间");
		ossBucketItem.setWidth("*");
		__formItems.add(ossBucketItem);
		
		ossAccessKeyIdItem = new TextItem("ossAccessKeyId", "oss_access_key_id");
		ossAccessKeyIdItem.setWidth("*");
		__formItems.add(ossAccessKeyIdItem);
		
		ossAccessKeySecretItem = new TextItem("ossAccessKeySecret", "oss_access_key_secret");
		ossAccessKeySecretItem.setWidth("*");
		__formItems.add(ossAccessKeySecretItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSOssConfigManage.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
