package com.pomplatform.client.employee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDResignEmployeeEachMonthDetail;

public class ResignEmployeeEachMonthDetailSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final DateItem yearItem;
	private final DateItem monthItem;

	public ResignEmployeeEachMonthDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDResignEmployeeEachMonthDetail.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		yearItem = new DateItem("year", "年份");
		yearItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, yearItem);
			}
		});
		monthItem = new DateItem("month", "月份");
		monthItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, monthItem);
			}
		});

		setItems(plateIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
