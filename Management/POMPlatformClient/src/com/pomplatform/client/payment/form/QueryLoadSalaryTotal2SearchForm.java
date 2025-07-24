package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDQueryLoadSalaryTotal2;

public class QueryLoadSalaryTotal2SearchForm extends SearchForm
{


	private final TextItem employeeIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public QueryLoadSalaryTotal2SearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDQueryLoadSalaryTotal2.getInstance());
		employeeIdItem = new TextItem("employeeId", "员工id");
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(employeeIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
