package com.pomplatform.client.preprojects.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojects.datasource.CDTaskListOfPreProjectReport;

public class TaskListOfPreProjectReportSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final TextItem processTypeItem;
	private final SelectItem employeeIdItem;
	private final TextItem projectNameItem;
	private final SelectItem projectTypeItem;

	public TaskListOfPreProjectReportSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDTaskListOfPreProjectReport.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		statusItem.setHidden(true);
		
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		
		employeeIdItem = new SelectItem("employeeId", "知会人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setHidden(true);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		projectTypeItem = new SelectItem("projectType", "项目业态");
//		projectTypeItem.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		KeyValueManager.loadValueMap("pre_business_type",projectTypeItem);
		projectTypeItem.setWidth("*");

		setItems(statusItem, processTypeItem, employeeIdItem, projectNameItem, projectTypeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
