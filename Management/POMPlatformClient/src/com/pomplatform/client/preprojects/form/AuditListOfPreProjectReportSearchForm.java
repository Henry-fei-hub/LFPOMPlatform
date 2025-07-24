package com.pomplatform.client.preprojects.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.preprojects.datasource.CDAuditListOfPreProjectReport;

public class AuditListOfPreProjectReportSearchForm extends SearchForm
{


	private final TextItem processTypeItem;
	private final SelectItem statusItem;
	private final SelectItem employeeIdItem;
	private final TextItem projectNameItem;
	private final SelectItem projectTypeItem;

	public AuditListOfPreProjectReportSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDAuditListOfPreProjectReport.getInstance());
		processTypeItem = new TextItem("processType", "流程类型");
		processTypeItem.setHidden(true);
		statusItem = new SelectItem("status", "状态");
		statusItem.setHidden(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		employeeIdItem = new SelectItem("employeeId", "审批人");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setHidden(true);
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		projectTypeItem = new SelectItem("projectType", "项目业态");
//		projectTypeItem.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		KeyValueManager.loadValueMap("pre_business_type",projectTypeItem);
		projectTypeItem.setWidth("*");

		setItems(processTypeItem, statusItem, employeeIdItem, projectNameItem, projectTypeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
