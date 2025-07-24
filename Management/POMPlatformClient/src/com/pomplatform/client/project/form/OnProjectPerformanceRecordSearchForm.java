package com.pomplatform.client.project.form;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnProjectPerformanceRecordSearchForm extends SearchForm
{

	private final TextItem businessNameItem;

	public OnProjectPerformanceRecordSearchForm() {
		setWidth100();
		setHeight100();
		businessNameItem = new TextItem("businessName", "业务名称");
		businessNameItem.setWidth("*");

		setItems(businessNameItem);

		setNumCols(3);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
