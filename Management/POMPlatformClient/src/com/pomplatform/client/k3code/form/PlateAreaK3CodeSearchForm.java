package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDCompanyK3Code;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class PlateAreaK3CodeSearchForm extends SearchForm {

	private final SelectItem businessIdItem;
	private final TextItem k3CodeItem;
	private final SelectItem additionalBusinessIdItem;

	public PlateAreaK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCompanyK3Code.getInstance());

		businessIdItem = new SelectItem("businessId", "业务部门");
		businessIdItem.setWidth("*");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		
		additionalBusinessIdItem = new SelectItem("additionalBusinessId", "区域");
		additionalBusinessIdItem.setWidth("*");
		additionalBusinessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_116"));

		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		setItems(businessIdItem, additionalBusinessIdItem, k3CodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
