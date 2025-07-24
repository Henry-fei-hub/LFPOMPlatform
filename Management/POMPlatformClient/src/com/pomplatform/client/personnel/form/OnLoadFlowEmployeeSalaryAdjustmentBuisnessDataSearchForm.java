package com.pomplatform.client.personnel.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.personnel.datasource.CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData;

public class OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final SelectItem targetProvinceItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem departmentIdItem;
	private final ComboBoxItem deferItem;

	public OnLoadFlowEmployeeSalaryAdjustmentBuisnessDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadFlowEmployeeSalaryAdjustmentBuisnessData.getInstance());
		yearItem = new SelectItem("year", "调薪日期年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "调薪日期月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));

		targetProvinceItem = new SelectItem("targetProvince", "业务部门");
		targetProvinceItem.setWidth("*");
		targetProvinceItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
	
		employeeIdItem = new ComboBoxItem("employeeId", "姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		employeeIdItem.hide();
		
		departmentIdItem = new TextItem("departmentId", "部门");
		departmentIdItem.hide();
		
		deferItem = new ComboBoxItem("employeeId", "姓名");
		deferItem.setValueMap(KeyValueManager.getValueMap("employees"));
		deferItem.setChangeOnKeypress(false);
		deferItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		deferItem.setWidth("*");
		deferItem.hide();

		setItems(yearItem, monthItem, targetProvinceItem, employeeIdItem, departmentIdItem, deferItem);

		setNumCols(12);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
