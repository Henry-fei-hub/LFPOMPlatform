package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDEmployeesOrders;

public class EmployeesOrdersSearchForm extends SearchForm
{


	private final TextItem departmentIdItem;
	private final TextItem employeeNameItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem pstatusItem;

	public EmployeesOrdersSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeesOrders.getInstance());
		departmentIdItem = new ComboBoxItem("departmentId", "所属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		projectCodeItem = new TextItem("contractCode", "订单编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");
		pstatusItem = new ComboBoxItem("pstatus", "订单状态");
		pstatusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));
		pstatusItem.setWidth("*");

		setItems(departmentIdItem, employeeNameItem, projectCodeItem, projectNameItem, pstatusItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
