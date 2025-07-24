package com.pomplatform.client.project.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDStargetrecordbytor;

public class StargetrecordbytorSearchForm extends SearchForm
{


	private final SelectItem businessLineItem;
	private final SelectItem yearItem;
	private final SelectItem typeItem;

	public StargetrecordbytorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDStargetrecordbytor.getInstance());
		businessLineItem = new SelectItem("businessLine", "业务条线");
		businessLineItem.setWidth("*");
		businessLineItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		Date currentDate = new Date();
//		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		typeItem = new SelectItem("type", "指标类型");
		typeItem.setWidth("*");
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_211"));
		
		setItems(businessLineItem, yearItem, typeItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
