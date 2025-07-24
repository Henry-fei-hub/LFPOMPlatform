package com.pomplatform.client.projectintegralchangerecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectintegralchangerecord.datasource.CDMprojectintegralchangerecord;

public class MprojectintegralchangerecordSearchForm extends SearchForm
{


	private final SelectItem projectIdItem;
	private final SelectItem plateIdItem;
	private final TextItem plateEmployeeIdItem;

	public MprojectintegralchangerecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojectintegralchangerecord.getInstance());
		projectIdItem = new SelectItem("projectId", "项目");
		KeyValueManager.loadValueMap("projects",projectIdItem);
		plateIdItem = new SelectItem("plateId", "板块");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateEmployeeIdItem = new TextItem("plateEmployeeId", "板块负责人");
		plateEmployeeIdItem.setWidth("*");

		setItems(projectIdItem, plateIdItem, plateEmployeeIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
