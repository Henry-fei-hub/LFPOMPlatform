package com.pomplatform.client.employeemoneymanagespeemmepemmor.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeemoneymanagespeemmepemmor.datasource.CDEmployeeCaptionInfoSearch;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.*;

public class EmployeeCaptionInfoSearchSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final SelectItem statusItem;
	private final ComboBoxItem employeeIdItem;
	private final PickTreeItem departmentIdItem;
	private final TextItem roleIdItem;

	public EmployeeCaptionInfoSearchSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeCaptionInfoSearch.getInstance());
		employeeNoItem = new TextItem("employeeNo", "员工工号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setHidden(true);
		statusItem = new SelectItem("status", "状态");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
		statusItem.setWidth("*");
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
//		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",employeeIdItem);
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		departmentIdItem.setValueField("treeId");
		roleIdItem = new TextItem("roleId", "角色");
		roleIdItem.setHidden(true);

		setItems(employeeNoItem, employeeNameItem, statusItem, employeeIdItem, departmentIdItem, roleIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
