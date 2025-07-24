package com.pomplatform.client.employee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDOnboardEmployeeEachMonth;

public class OnboardEmployeeEachMonthSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;
	private final TextItem yearItem;

	public OnboardEmployeeEachMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnboardEmployeeEachMonth.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		plateIdItem.hide();
		
		startDateItem = new DateItem("startDate", "开始日期");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);
		
		endDateItem = new DateItem("endDate", "截止日期");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);
		
		yearItem = new TextItem("year", "年份");
		yearItem.hide();

		setItems(plateIdItem, startDateItem, endDateItem, yearItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
