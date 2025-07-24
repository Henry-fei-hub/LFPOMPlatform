package com.pomplatform.client.customer.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.customer.datasource.CDCustomerInfo;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CustomerInfoSearchForm extends SearchForm
{


	private final TextItem customerNameItem;

	public CustomerInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDCustomerInfo.getInstance());
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		setItems(customerNameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
