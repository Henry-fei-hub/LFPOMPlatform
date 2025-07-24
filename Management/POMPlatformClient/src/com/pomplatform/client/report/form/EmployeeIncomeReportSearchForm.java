package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDEmployeeIncomeReport;

public class EmployeeIncomeReportSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem plateIdItem;

	public EmployeeIncomeReportSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeIncomeReport.getInstance());
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");
		plateIdItem = new TextItem("plateId", "业务部门");

		setItems(yearItem, monthItem, plateIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
