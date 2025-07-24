package com.pomplatform.client.poolmanage.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.poolmanage.datasource.CDOnloadPoolData;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnloadPoolDataSearchForm extends SearchForm
{


	private final TextItem poolNameItem;
	private final SelectItem poolTypeItem;

	public OnloadPoolDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnloadPoolData.getInstance());
		poolNameItem = new TextItem("poolName", "池子名称");
		poolNameItem.setWidth("*");
		poolTypeItem = new SelectItem("poolType", "池子类型");
		poolTypeItem.setWidth("*");
		poolTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_234"));

		setItems(poolNameItem, poolTypeItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
