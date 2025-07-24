package com.pomplatform.client.check.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.check.datasource.CDSemployeemonthlycheckymor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class SemployeemonthlycheckymorSearchForm extends SearchForm {

	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem employeeIdItem;
	private final IPickTreeItem departmentIdItem;

	public SemployeemonthlycheckymorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSemployeemonthlycheckymor.getInstance());
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		monthItem = new SelectItem("month", "月份");
		monthItem.setValue(month);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		employeeIdItem = new ComboBoxItem("employeeId", "员工编码");
                employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		setItems(yearItem, monthItem, departmentIdItem, employeeIdItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
