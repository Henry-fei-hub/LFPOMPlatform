package com.pomplatform.client.project.form;

import java.text.SimpleDateFormat;
import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.project.datasource.CDMprojecttrcccsyyyseyymmymmor;

public class MprojecttrcccsyyyseyymmymmorSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem startMonthItem;
	private final SelectItem endMonthItem;
	private final TextItem yearStrItem;
	private final TextItem monthStartStrItem;
	private final TextItem monthEndStrItem;

	public MprojecttrcccsyyyseyymmymmorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMprojecttrcccsyyyseyymmymmor.getInstance());
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		Date currentDate = new Date();
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		startMonthItem = new SelectItem("startMonth", "开始月份");
		startMonthItem.setWidth("*");
		startMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		startMonthItem.setDefaultValue(1);
		endMonthItem = new SelectItem("endMonth", "结束月份");
		endMonthItem.setWidth("*");
		endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		endMonthItem.setDefaultValue(12);
		
		yearStrItem = new TextItem("yearStr", "年份str");
		yearStrItem.hide();
		
		monthStartStrItem = new TextItem("monthStartStr", "开始月份str");
		monthStartStrItem.hide();
		
		monthEndStrItem = new TextItem("monthEndStr", "结束月份str");
		monthEndStrItem.hide();
		
		setItems(yearItem, startMonthItem, endMonthItem, yearStrItem, monthStartStrItem, monthEndStrItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
