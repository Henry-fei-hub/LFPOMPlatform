package com.pomplatform.client.employee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDOnboardEmployeeEachMonthDetail;

public class OnboardEmployeeEachMonthDetailSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public OnboardEmployeeEachMonthDetailSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnboardEmployeeEachMonthDetail.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(plateIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
