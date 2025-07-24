package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDOnSalaryEmpBonusByDepartment;

public class OnSalaryEmpBonusByDepartmentSearchForm extends SearchForm
{


	private final SelectItem companyIdItem;
	private final SelectItem plateIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;
	private final SelectItem departmentIdItem;
	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;

	public OnSalaryEmpBonusByDepartmentSearchForm() {
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
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.hide();
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);

		setItems(yearItem, monthItem, companyIdItem, plateIdItem, departmentIdItem, employeeNoItem, employeeIdItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
