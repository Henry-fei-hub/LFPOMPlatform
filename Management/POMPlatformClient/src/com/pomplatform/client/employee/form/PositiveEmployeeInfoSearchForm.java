package com.pomplatform.client.employee.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDPositiveEmployeeInfo;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class PositiveEmployeeInfoSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem employeeIdItem;

	public PositiveEmployeeInfoSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDPositiveEmployeeInfo.getInstance());
		Date date = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		yearItem.setDefaultValue(date.getYear() + 1900);
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setWidth("*");
		monthItem.setDefaultValue(date.getMonth() + 1);
		
		employeeIdItem = new ComboBoxItem("employeeId", "姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);

		setItems(yearItem, monthItem, employeeIdItem);
		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
