package com.pomplatform.client.sprojectintegralsumrecordpysor.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.sprojectintegralsumrecordpysor.datasource.CDSprojectintegralsumrecordpysor;

public class SprojectintegralsumrecordpysorSearchForm extends SearchForm
{


	private final ComboBoxItem plateIdItem;
	private final SelectItem yearItem;
	private final SelectItem startMonthItem;
	private final SelectItem endMonthItem;

	public SprojectintegralsumrecordpysorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojectintegralsumrecordpysor.getInstance());
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		startMonthItem = new SelectItem("startMonth", "开始月份");
		startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		endMonthItem = new SelectItem("endMonth", "截止月份");
		endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

		setItems(plateIdItem, yearItem, startMonthItem, endMonthItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
