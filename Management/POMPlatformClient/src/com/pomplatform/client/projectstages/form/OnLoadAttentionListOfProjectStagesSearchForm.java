package com.pomplatform.client.projectstages.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectstages.datasource.CDOnLoadAttentionListOfProjectStages;

public class OnLoadAttentionListOfProjectStagesSearchForm extends SearchForm
{


	private final TextItem statusItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;

	public OnLoadAttentionListOfProjectStagesSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAttentionListOfProjectStages.getInstance());
		statusItem = new TextItem("status", "状态");
		statusItem.setHidden(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");

		setItems(statusItem, employeeNameItem, employeeNoItem, projectNameItem, projectCodeItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
