package com.pomplatform.client.mainprojectinfo.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.mainprojectinfo.datasource.CDOnLoadAttentionListOfBidPaySheetProject;

public class OnLoadAttentionListOfBidPaySheetProjectSearchForm extends SearchForm
{


	private final TextItem employeeNameItem;
	private final TextItem employeeNoItem;
	public OnLoadAttentionListOfBidPaySheetProjectSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadAttentionListOfBidPaySheetProject.getInstance());
		employeeNameItem = new TextItem("employeeName", "职员姓名");
		employeeNameItem.setWidth("*");
		employeeNoItem = new TextItem("employeeNo", "职员编号");
		employeeNoItem.setWidth("*");

		setItems(employeeNameItem, employeeNoItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
