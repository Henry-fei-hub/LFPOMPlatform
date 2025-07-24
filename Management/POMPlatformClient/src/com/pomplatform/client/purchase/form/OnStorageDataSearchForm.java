package com.pomplatform.client.purchase.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.purchase.datasource.CDOnStorageData;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnStorageDataSearchForm extends SearchForm
{
	private final TextItem storageCodeItem;
	private final TextItem storageNameItem;
	private final SelectItem storageTypeItem;
	private final SelectItem storageAreaIdItem;

	public OnStorageDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnStorageData.getInstance());
		storageCodeItem = new TextItem("storageCode", "仓库编号");
		storageCodeItem.setWidth("*");
		
		storageNameItem = new TextItem("storageName", "仓库名称");
		storageNameItem.setWidth("*");
		
		storageTypeItem = new SelectItem("storageType", "仓库类型");
		storageTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_209"));
		storageTypeItem.setWidth("*");
		
		storageAreaIdItem = new SelectItem("storageAreaId", "地区");
		storageAreaIdItem.setValueMap(KeyValueManager.getValueMap("storage_areas"));
		storageAreaIdItem.setWidth("*");

		setItems(storageCodeItem, storageNameItem, storageTypeItem, storageAreaIdItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
