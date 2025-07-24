package com.pomplatform.client.salary.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.DateItemSelectorFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.salary.datasource.CDSalaryOfShouldBonus;

public class SalaryOfShouldBonusSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final IPickTreeItem departmentIdItem;
	private final DateItem recordDateItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;

	public SalaryOfShouldBonusSearchForm() {
		setWidth100();
		setHeight100();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		recordDateItem = new DateItem("recordDate", "日期");
		recordDateItem.setUseTextField(true);
		recordDateItem.setSelectorFormat(DateItemSelectorFormat.YEAR_MONTH);
		recordDateItem.setWidth("*");

		yearItem = new SelectItem("year","年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
        
        monthItem = new SelectItem("month", "月份");
        monthItem.setWidth("*");
        monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		setItems(employeeNoItem, employeeIdItem, departmentIdItem, yearItem,monthItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
