package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDCompanyK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SpecificK3CodeSearchForm extends SearchForm {

	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;

	public SpecificK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCompanyK3Code.getInstance());

		businessIdItem = new ComboBoxItem("businessId", "特定科目代码");
		businessIdItem.setWidth("*");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_210"));
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		k3NameItem = new TextItem("k3Name", "K3名称");
		k3NameItem.setWidth("*");

		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		setItems(businessIdItem, k3NameItem, k3CodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
