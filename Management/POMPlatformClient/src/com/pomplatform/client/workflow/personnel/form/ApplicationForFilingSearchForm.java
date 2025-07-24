package com.pomplatform.client.workflow.personnel.form;

import java.util.*;

import com.pomplatform.client.workflow.personnel.datasource.CDApplicationForFiling;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;


public class ApplicationForFilingSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;

	public ApplicationForFilingSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDApplicationForFiling.getInstance());
		employeeIdItem = new TextItem("employeeId", "员工编码");

		setItems(employeeIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
