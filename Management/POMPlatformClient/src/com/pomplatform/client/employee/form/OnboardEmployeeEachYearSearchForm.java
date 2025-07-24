package com.pomplatform.client.employee.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDOnboardEmployeeEachYear;

public class OnboardEmployeeEachYearSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem monthItem;

	public OnboardEmployeeEachYearSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnboardEmployeeEachYear.getInstance());
		
		Date currentDate = new Date();
		yearItem = new TextItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	

		monthItem = new SelectItem("month", "月份");
		monthItem.setAllowEmptyValue(true);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setWidth("*");
		
		setItems(plateIdItem,yearItem,monthItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
