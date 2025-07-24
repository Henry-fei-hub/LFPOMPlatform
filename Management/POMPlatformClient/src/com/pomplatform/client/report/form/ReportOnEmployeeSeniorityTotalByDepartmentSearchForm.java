package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOnEmployeeSeniorityTotalByDepartment;

public class ReportOnEmployeeSeniorityTotalByDepartmentSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem statusItem;
	private final TextItem plateIdItem;

	public ReportOnEmployeeSeniorityTotalByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOnEmployeeSeniorityTotalByDepartment.getInstance());
		yearItem = new TextItem("year", "年份");
		statusItem = new TextItem("status", "状态");
		plateIdItem = new TextItem("plateId", "业务部门");

		setItems(yearItem, statusItem, plateIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
