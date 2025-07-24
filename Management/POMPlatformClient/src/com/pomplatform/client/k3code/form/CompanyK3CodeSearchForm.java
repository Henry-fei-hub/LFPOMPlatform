package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDCompanyK3Code;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CompanyK3CodeSearchForm extends SearchForm
{


	private final SelectItem businessIdItem;
	private final TextItem k3CodeItem;

	public CompanyK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCompanyK3Code.getInstance());
		
		businessIdItem = new SelectItem("businessId", "公司");
		businessIdItem.setWidth("*");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		setItems(businessIdItem, k3CodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
