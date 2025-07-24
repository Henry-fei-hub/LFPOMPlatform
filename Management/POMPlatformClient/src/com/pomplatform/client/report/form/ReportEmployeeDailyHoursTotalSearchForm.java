package com.pomplatform.client.report.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.report.datasource.CDReportEmployeeDailyHoursTotal;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

import java.util.Date;

public class ReportEmployeeDailyHoursTotalSearchForm extends SearchForm
{
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final DateItem startWorkDateItem;
	private final DateItem endWorkDateItem;

	public ReportEmployeeDailyHoursTotalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportEmployeeDailyHoursTotal.getInstance());
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		startWorkDateItem = new DateItem("startWorkDate", "开始日期");
		startWorkDateItem.setWidth("*");
		startWorkDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, startWorkDateItem);
			}
		});
		endWorkDateItem = new DateItem("endWorkDate", "结束日期");
		endWorkDateItem.setWidth("*");
		endWorkDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				ClientUtil.searchDateFormat(val, endWorkDateItem);
			}
		});

		setItems(employeeNoItem, employeeNameItem, startWorkDateItem, endWorkDateItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
