package com.pomplatform.client.customer.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class HolidayBlessSearchForm extends SearchForm
{
	private final TextItem holidayNameItem;
	private final SelectItem holidayTypeItem;
	private final SelectItem sendObjectItem;
	private final SelectItem objectTypeItem;

	public HolidayBlessSearchForm() {
		setWidth100();
		setHeight100();
		holidayNameItem = new TextItem("holidayName", "节日名称");
		holidayNameItem.setWidth("*");
		holidayTypeItem = new SelectItem("holidayType", "节日类型");
		holidayTypeItem.setWidth("*");
		holidayTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_125"));
		sendObjectItem = new SelectItem("sendObject", "推送对象");
		sendObjectItem.setWidth("*");
		sendObjectItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_126"));
		objectTypeItem = new SelectItem("objectType", "对象类型");
		objectTypeItem.setWidth("*");
		objectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_75"));
		setItems(holidayNameItem,holidayTypeItem,sendObjectItem,objectTypeItem);
		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
