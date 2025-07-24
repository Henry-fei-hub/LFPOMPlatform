package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDEmployeeSalaryType;

public class EmployeeSalaryTypeSearchForm extends SearchForm
{


	private final TextItem employeeSalaryTypeIdItem;
	private final ComboBoxItem employeeIdItem;
	private final PickTreeItem employeeNameItem;
	private final TextItem employeeNoItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final SelectItem salaryTypeItem;
	private final SelectItem fundraisingProjectTypeItem;
	private final TextItem fundraisingProjectRateItem;

	public EmployeeSalaryTypeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeSalaryType.getInstance());

		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(0, "募投项目");
		map.put(1, "研发项目");

		employeeSalaryTypeIdItem = new TextItem("employeeSalaryTypeId", "员工工资发放类型表主键");
		employeeSalaryTypeIdItem.setWidth("*");
		employeeSalaryTypeIdItem.setHidden(true);

		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setHidden(false);
		KeyValueManager.loadValueMap("employees" , employeeIdItem);

		employeeNameItem = new PickTreeItem("employeeName", "员工姓名");
		employeeNameItem.setCanSelectParentItems(true);
		employeeNameItem.setValueField("treeId");
		employeeNameItem.setHidden(true);

		employeeNameItem.setValueTree(KeyValueManager.getTree("departments", ""));
		employeeNameItem.setWidth("*");
		employeeNameItem.setHidden(true);

		employeeNoItem = new TextItem("employeeNo", "员工工号");
		employeeNoItem.setWidth("*");
		employeeNoItem.setHidden(true);

		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setHidden(false);
		KeyValueManager.loadValueMap("system_dictionary_1" , plateIdItem);

		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setHidden(false);
		KeyValueManager.loadValueMap("system_dictionary_18" , yearItem);

		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setHidden(false);
		KeyValueManager.loadValueMap("system_dictionary_19" , monthItem);

		salaryTypeItem = new SelectItem("salaryType", "类型");
		salaryTypeItem.setWidth("*");
		salaryTypeItem.setHidden(false);
		salaryTypeItem.setValueMap(map);

		fundraisingProjectTypeItem = new SelectItem("fundraisingProjectType", "募投项目类型");
		fundraisingProjectTypeItem.setWidth("*");
		KeyValueManager.loadValueMap("fundraising_project_types" , fundraisingProjectTypeItem);
		fundraisingProjectTypeItem.setHidden(false);

		fundraisingProjectRateItem = new TextItem("fundraisingProjectRate", "募投比例");
		fundraisingProjectRateItem.setWidth("*");
		fundraisingProjectRateItem.setHidden(false);

		setItems(employeeSalaryTypeIdItem, employeeIdItem, employeeNameItem, employeeNoItem, plateIdItem, yearItem, monthItem, salaryTypeItem, fundraisingProjectTypeItem, fundraisingProjectRateItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
