package com.pomplatform.client.sprojectadvancerecord.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sprojectadvancerecord.datasource.CDSProjectAdvanceRecord;

public class SProjectAdvanceRecordSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final DateItem advanceYearItem;
	private final DateItem advanceMonthItem;

	public SProjectAdvanceRecordSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSProjectAdvanceRecord.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		advanceYearItem = new DateItem("advanceYear", "年份");
		advanceYearItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, advanceYearItem);
			}
		});
		advanceMonthItem = new DateItem("advanceMonth", "月份");
		advanceMonthItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, advanceMonthItem);
			}
		});

		setItems(plateIdItem, advanceYearItem, advanceMonthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
