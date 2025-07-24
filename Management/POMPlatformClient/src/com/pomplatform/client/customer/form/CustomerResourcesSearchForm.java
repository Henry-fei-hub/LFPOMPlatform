package com.pomplatform.client.customer.form;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CustomerResourcesSearchForm extends SearchForm
{
	private final TextItem companyNameItem;
	private final TextItem nameItem;

	public CustomerResourcesSearchForm() {
		setWidth100();
		setHeight100();
		companyNameItem = new TextItem("companyName", "公司名称");
		companyNameItem.setWidth("*");
		nameItem = new TextItem("name", "客户姓名");
		nameItem.setWidth("*");
		setItems(companyNameItem,nameItem);
		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
