package com.pomplatform.client.workflow.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.datasource.CDApplicationFiling;

public class ApplicationFilingSearchForm extends SearchForm
{


	private final TextItem departmentIdItem;
	private final TextItem employeeNoItem;

	public ApplicationFilingSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDApplicationFiling.getInstance());
		departmentIdItem = new TextItem("departmentId", "部门");
		employeeNoItem = new TextItem("employeeNo", "员工工号");

		setItems(departmentIdItem, employeeNoItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
