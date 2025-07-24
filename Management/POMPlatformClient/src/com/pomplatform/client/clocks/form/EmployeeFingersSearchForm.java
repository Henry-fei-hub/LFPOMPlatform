package com.pomplatform.client.clocks.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.IPickTreeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class EmployeeFingersSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final IPickTreeItem departmentIdItem;

	public EmployeeFingersSearchForm() {
		setWidth100();
		setHeight100();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		departmentIdItem = new IPickTreeItem("departmentId", "部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		setItems(employeeNoItem, employeeIdItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
