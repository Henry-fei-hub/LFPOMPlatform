package com.pomplatform.client.payment.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnSalaryReportByEmployeeSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem monthItem;
	private final SelectItem companyIdItem;
	private final SelectItem plateIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;

	public OnSalaryReportByEmployeeSearchForm() {
		setWidth100();
		setHeight100();
		yearItem = new TextItem("year", "年份");
		yearItem.hide();
		monthItem = new TextItem("month", "月份");
		monthItem.hide();
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.hide();
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.hide();
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");

		setItems(yearItem, monthItem, companyIdItem, plateIdItem, departmentIdItem, employeeNoItem, employeeNameItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
