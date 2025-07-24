package com.pomplatform.client.splatesalaryadvanceeachmonthrecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.splatesalaryadvanceeachmonthrecord.datasource.CDSPlateSalaryAdvanceEachMonthRecord;

public class SPlateSalaryAdvanceEachMonthRecordSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public SPlateSalaryAdvanceEachMonthRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSPlateSalaryAdvanceEachMonthRecord.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, startDateItem);
			}
		});
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, endDateItem);
			}
		});

		setItems(plateIdItem, startDateItem, endDateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
