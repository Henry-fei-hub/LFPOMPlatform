package com.pomplatform.client.projectemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectemployee.datasource.CDOnLoadAuditListOfProjectEmployees;

public class OnLoadAuditListOfProjectEmployeesSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;

	public OnLoadAuditListOfProjectEmployeesSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAuditListOfProjectEmployees.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.setHidden(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		setItems(statusItem, projectNameItem, projectCodeItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
