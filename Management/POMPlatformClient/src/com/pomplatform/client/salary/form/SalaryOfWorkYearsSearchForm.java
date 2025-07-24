package com.pomplatform.client.salary.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.salary.datasource.CDSalaryOfWorkYears;

public class SalaryOfWorkYearsSearchForm extends SearchForm
{


	private final ComboBoxItem yearItem;
	private final ComboBoxItem employeeIdItem;
	private final TextItem employeeNoItem;
	private final IPickTreeItem departmentIdItem;
	private final ComboBoxItem monthItem;

	public SalaryOfWorkYearsSearchForm() {
		setWidth100();
		setHeight100();
		
		yearItem = new ComboBoxItem("year", "年份");
		yearItem.setWidth("*");
		Date currentDate = new Date();
		int year = currentDate.getYear()+1900;
		yearItem.setDefaultValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		monthItem = new ComboBoxItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		setItems(employeeNoItem, employeeIdItem, departmentIdItem,yearItem,monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
