package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mainprojectinfo.datasource.CDOnLoadAuditListOfBidPaySheetProject;

public class OnLoadAuditListOfBidPaySheetProjectSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;

	public OnLoadAuditListOfBidPaySheetProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAuditListOfBidPaySheetProject.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setHidden(true);
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_61"));
		employeeNameItem = new TextItem("employeeName", "职员姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");
		setItems(statusItem, employeeNameItem, employeeNoItem);
		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
