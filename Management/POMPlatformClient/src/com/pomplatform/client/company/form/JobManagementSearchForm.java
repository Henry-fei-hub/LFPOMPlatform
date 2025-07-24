package com.pomplatform.client.company.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.company.datasource.CDJobManagement;

public class JobManagementSearchForm extends SearchForm
{


	private final TextItem dutyNameItem;

	public JobManagementSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDJobManagement.getInstance());
		dutyNameItem = new TextItem("dutyName", "职位名称");
		dutyNameItem.setWidth("*");

		setItems(dutyNameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
