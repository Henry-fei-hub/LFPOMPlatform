package com.pomplatform.client.shift.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class OnCheckEmployeeShiftOfShiftSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;

	public OnCheckEmployeeShiftOfShiftSearchForm() {
		setWidth100();
		setHeight100();
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.hide();
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		monthItem = new SelectItem("month", "月份");
		monthItem.setValue(month);
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

		setItems(employeeIdItem, yearItem, monthItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
