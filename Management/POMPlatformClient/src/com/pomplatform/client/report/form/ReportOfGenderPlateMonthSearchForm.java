package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOfGenderPlateMonth;

public class ReportOfGenderPlateMonthSearchForm extends SearchForm
{


	private final DateItem theDateItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public ReportOfGenderPlateMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOfGenderPlateMonth.getInstance());
		theDateItem = new DateItem("theDate", "日期");
		theDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, theDateItem);
			}
		});
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(theDateItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
