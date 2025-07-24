package com.pomplatform.client.selectgrid.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.selectgrid.datasource.CDSelectGridEmployeeInDepartment;

public class SelectGridEmployeeInDepartmentSearchForm extends SearchForm
{


	private final SelectItem departmentIdItem;
	private final SelectItem statusItem;
	private final TextItem employeeNameItem;
	private final TextItem roleIdItem;
	private final SelectItem employeeIdItem;

	public SelectGridEmployeeInDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSelectGridEmployeeInDepartment.getInstance());
		departmentIdItem = new SelectItem("departmentId", "部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		statusItem = new SelectItem("status", "4删除)");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		roleIdItem = new TextItem("roleId", "角色");
		employeeIdItem = new SelectItem("employeeId", "员工编码");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));

		setItems(departmentIdItem, statusItem, employeeNameItem, roleIdItem, employeeIdItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
