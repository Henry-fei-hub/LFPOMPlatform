package com.pomplatform.client.onemployeedayplaterecords.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.onemployeedayplaterecords.datasource.CDOnEmployeeDayPlateRecords;

public class OnEmployeeDayPlateRecordsSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final ComboBoxItem plateIdItem;
	private final DateItem recordDateItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;

	public OnEmployeeDayPlateRecordsSearchForm() {
		setWidth100();
		setHeight100();
		
		employeeNoItem = new TextItem("employeeNo", "职员工号");
		employeeNoItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "职员姓名");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setWidth("*");
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		
		recordDateItem = new DateItem("recordDate", "记录日期");
		recordDateItem.setWidth("*");
		recordDateItem.setUseTextField(true);
		recordDateItem.setDefaultValue(new Date());
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setWidth("*");

		setItems(employeeNoItem, employeeIdItem, plateIdItem, recordDateItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
