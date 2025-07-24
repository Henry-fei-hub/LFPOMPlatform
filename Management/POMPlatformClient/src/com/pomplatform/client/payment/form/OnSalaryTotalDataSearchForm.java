package com.pomplatform.client.payment.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnSalaryTotalDataSearchForm extends SearchForm
{


	private final ComboBoxItem employeeIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final ComboBoxItem companyIdItem;
	private final ComboBoxItem plateIdItem;
	private final IPickTreeItem departmentIdItem;

	public OnSalaryTotalDataSearchForm() {
		setWidth100();
		setHeight100();
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setChangeOnKeypress(false);
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
		monthItem.setWidth("*");
		monthItem.setValue(month);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		employeeNameItem.hide();
		
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setWidth("*");
		
		departmentIdItem = new IPickTreeItem("departmentId", "归属部门");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setWidth("*");
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));

		setItems(employeeIdItem, yearItem, monthItem, employeeNoItem, employeeNameItem, companyIdItem,plateIdItem, departmentIdItem);

		setNumCols(15);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
