package com.pomplatform.client.shift.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadEmployeeShiftOfShiftSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final IPickTreeItem departmentIdItem;
	private final SelectItem genderItem;

	public OnLoadEmployeeShiftOfShiftSearchForm() {
		setWidth100();
		setHeight100();
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
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		genderItem = new SelectItem("gender", "性别");
		genderItem.setWidth("*");
		genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));

		setItems(employeeNoItem, employeeNameItem, departmentIdItem, genderItem,yearItem, monthItem);

		setNumCols(13);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
