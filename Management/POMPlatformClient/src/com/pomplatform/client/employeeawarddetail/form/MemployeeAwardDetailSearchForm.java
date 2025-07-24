package com.pomplatform.client.employeeawarddetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeawarddetail.datasource.CDMemployeeAwardDetail;

public class MemployeeAwardDetailSearchForm extends SearchForm
{


	private final TextItem yearsItem;
	private final TextItem monthsItem;
	private final SelectItem projectIdItem;
	private final SelectItem employeeIdItem;
	private final SelectItem plateIdItem;
	private final TextItem employeeNameItem;

	public MemployeeAwardDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMemployeeAwardDetail.getInstance());
		yearsItem = new TextItem("years", "年份");
		yearsItem.setWidth("*");
		monthsItem = new TextItem("months", "月份");
		monthsItem.setWidth("*");
		projectIdItem = new SelectItem("projectId", "项目");
		KeyValueManager.loadValueMap("projects",projectIdItem);
		employeeIdItem = new SelectItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		plateIdItem = new SelectItem("plateId", "板块");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");

		setItems(yearsItem, monthsItem, projectIdItem, employeeIdItem, plateIdItem, employeeNameItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
