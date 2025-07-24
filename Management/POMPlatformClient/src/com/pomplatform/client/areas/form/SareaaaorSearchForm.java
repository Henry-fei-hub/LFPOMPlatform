package com.pomplatform.client.areas.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.areas.datasource.CDSareaaaor;

public class SareaaaorSearchForm extends SearchForm
{


	private final TextItem areaNameItem;
	private final SelectItem areaLevelItem;

	public SareaaaorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSareaaaor.getInstance());
		
		areaNameItem = new TextItem("areaName", "区域名称");
		areaNameItem.setCanEdit(true);
		areaNameItem.setWidth("*");
		
		areaLevelItem = new SelectItem("areaLevel", "等级");
		areaLevelItem.setWidth("*");
		areaLevelItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_131"));

		setItems(areaNameItem, areaLevelItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
