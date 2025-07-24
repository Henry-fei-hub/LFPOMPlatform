package com.pomplatform.client.employeesalary.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeesalary.datasource.CDEmployeeSalaryDetailMonth;

public class EmployeeSalaryDetailMonthSearchForm extends SearchForm
{


	private final SelectItem employeeIdItem;
	private final SelectItem startYearItem;
	private final TextItem startYearStartMonthItem;
	private final TextItem startYearEndMonthItem;
	private final SelectItem bigThenStartYearItem;
	private final SelectItem lessThenEndYearItem;
	private final SelectItem endYearItem;
	private final SelectItem endMonthItem;

	public EmployeeSalaryDetailMonthSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeSalaryDetailMonth.getInstance());
		employeeIdItem = new SelectItem("employeeId", "职员编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		startYearItem = new SelectItem("startYear", "开始年份");
		startYearItem.setValueMap(KeyValueManager.getValueMap("employees"));
		startYearStartMonthItem = new TextItem("startYearStartMonth", "开始年份的开始月份");
		startYearEndMonthItem = new TextItem("startYearEndMonth", "开始年份的结束月份");
		bigThenStartYearItem = new SelectItem("bigThenStartYear", "大于开始年份");
		bigThenStartYearItem.setValueMap(KeyValueManager.getValueMap("employees"));
		lessThenEndYearItem = new SelectItem("lessThenEndYear", "小于结束年份");
		lessThenEndYearItem.setValueMap(KeyValueManager.getValueMap("employees"));
		endYearItem = new SelectItem("endYear", "结束年份");
		endYearItem.setValueMap(KeyValueManager.getValueMap("employees"));
		endMonthItem = new SelectItem("endMonth", "结束月份");
		endMonthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

		setItems(employeeIdItem, startYearItem, startYearStartMonthItem, startYearEndMonthItem, bigThenStartYearItem, lessThenEndYearItem, endYearItem, endMonthItem);

		setNumCols(16);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
