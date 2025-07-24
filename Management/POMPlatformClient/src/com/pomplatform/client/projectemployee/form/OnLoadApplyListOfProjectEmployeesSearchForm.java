package com.pomplatform.client.projectemployee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectemployee.datasource.CDOnLoadApplyListOfProjectEmployees;

public class OnLoadApplyListOfProjectEmployeesSearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem projectNameItem;
	private final TextItem projectCodeItem;

	public OnLoadApplyListOfProjectEmployeesSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfProjectEmployees.getInstance());
		employeeIdItem = new TextItem("employeeId", "创建人");
		employeeIdItem.hide();
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");

		setItems(employeeIdItem, projectNameItem, projectCodeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
