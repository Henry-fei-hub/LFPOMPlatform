package com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.datasource.CDEmployeeAchieveIntegralReturnRecordByEmoloyee;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class EmployeeAchieveIntegralReturnRecordByEmoloyeeSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem recordYearItem;
	private final TextItem recordMonthItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final SelectItem statusItem;

	public EmployeeAchieveIntegralReturnRecordByEmoloyeeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeAchieveIntegralReturnRecordByEmoloyee.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		recordYearItem = new TextItem("recordYear", "年份");
		recordYearItem.hide();
		recordMonthItem = new TextItem("recordMonth", "月份");
		recordMonthItem.hide();
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "姓名");
		employeeNameItem.setWidth("*");
		statusItem = new SelectItem("status", "回收状态");
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_37"));

		setItems(plateIdItem, recordYearItem, recordMonthItem, employeeNoItem, employeeNameItem, statusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
