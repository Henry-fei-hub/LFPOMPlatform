package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDLoadSalaryTotal;

public class LoadSalaryTotalSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem employeeIdItem;

	public LoadSalaryTotalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDLoadSalaryTotal.getInstance());
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");
		employeeIdItem = new TextItem("employeeId", "员工id");

		setItems(yearItem, monthItem, employeeIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
