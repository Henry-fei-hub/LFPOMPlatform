package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportEmployeeWorkYearsByDepartment;

public class ReportEmployeeWorkYearsByDepartmentSearchForm extends SearchForm
{


	private final DateItem endDateItem;
	private final DateItem startDateItem;
	private final TextItem plateIdItem;
	private final TextItem plateTypeItem;
	private final TextItem departmentIdItem;

	public ReportEmployeeWorkYearsByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportEmployeeWorkYearsByDepartment.getInstance());
		endDateItem = new DateItem("endDate", "入职日期");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});
		startDateItem = new DateItem("startDate", "离职日期");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		plateIdItem = new TextItem("plateId", "业务部门");
		plateTypeItem = new TextItem("plateType", "3营销部)");
		departmentIdItem = new TextItem("departmentId", "归属部门");

		setItems(endDateItem, startDateItem, plateIdItem, plateTypeItem, departmentIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
