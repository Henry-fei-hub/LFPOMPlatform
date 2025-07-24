package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOnEmployeeGradeTotalByDepartment;

public class ReportOnEmployeeGradeTotalByDepartmentSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final TextItem statusItem;
	private final TextItem plateIdItem;

	public ReportOnEmployeeGradeTotalByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOnEmployeeGradeTotalByDepartment.getInstance());
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");
		statusItem = new TextItem("status", "状态");
		plateIdItem = new TextItem("plateId", "业务部门");

		setItems(yearItem, monthItem, statusItem, plateIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
