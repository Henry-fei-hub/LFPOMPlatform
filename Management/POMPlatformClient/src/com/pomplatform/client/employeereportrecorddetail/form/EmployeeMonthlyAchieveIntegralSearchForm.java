package com.pomplatform.client.employeereportrecorddetail.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeereportrecorddetail.datasource.CDEmployeeMonthlyAchieveIntegral;

public class EmployeeMonthlyAchieveIntegralSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final DateItem recordDateItem;

	public EmployeeMonthlyAchieveIntegralSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeMonthlyAchieveIntegral.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		recordDateItem = new DateItem("recordDate", "记录产生时间");
		recordDateItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				Date val = (Date) event.getValue();
				com.delicacy.client.data.ClientUtil.searchDateFormat(val, recordDateItem);
			}
		});

		setItems(plateIdItem, recordDateItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
