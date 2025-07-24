package com.pomplatform.client.contract.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.contract.datasource.CDShowOldProjectRevenue;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ShowOldProjectRevenueSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final SelectItem palteIdItem;

	public ShowOldProjectRevenueSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDShowOldProjectRevenue.getInstance());
		projectCodeItem = new TextItem("projectCode", "订单编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名");
		projectNameItem.setWidth("*");
		palteIdItem = new SelectItem("palteId", "业务部门");
		palteIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		palteIdItem.setWidth("*");

		setItems(projectCodeItem, projectNameItem, palteIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
