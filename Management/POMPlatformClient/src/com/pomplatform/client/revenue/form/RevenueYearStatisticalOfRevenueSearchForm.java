package com.pomplatform.client.revenue.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class RevenueYearStatisticalOfRevenueSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;
	private final SelectItem yearItem;

	public RevenueYearStatisticalOfRevenueSearchForm() {
		setWidth100();
		setHeight100();
		projectIdItem = new SelectItem("projectId", "项目编码");
		projectIdItem.hide();
		KeyValueManager.loadValueMap("projects",projectIdItem);
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(2017);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));

		setItems(projectIdItem, yearItem);

		setNumCols(3);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
