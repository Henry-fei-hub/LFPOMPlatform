package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnelbusiness.datasource.CDOnLoadTaskListOfSalaryAdjustment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class OnLoadTaskListOfSalaryAdjustmentSearchForm extends SearchForm
{


	private final SelectItem statusItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem plateIdItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem auditorItem;

	public OnLoadTaskListOfSalaryAdjustmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadTaskListOfSalaryAdjustment.getInstance());
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_16"));
		statusItem.hide();
		
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		employeeIdItem = new ComboBoxItem("employeeId", "姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		
		auditorItem = new SelectItem("auditor", "处理人");
		auditorItem.setValueMap(KeyValueManager.getValueMap("employees"));
		auditorItem.hide();

		setItems(statusItem, yearItem, monthItem, plateIdItem, employeeIdItem, auditorItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
