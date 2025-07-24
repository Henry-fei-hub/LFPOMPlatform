package com.pomplatform.client.clocks.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValue;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.clocks.datasource.CDEmployeeFaces;

public class EmployeeFacesSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final ComboBoxItem employeeIdItem;
	private final IPickTreeItem departmentIdItem;

	public EmployeeFacesSearchForm() {
		setWidth100();
		setHeight100();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		
		employeeIdItem = new ComboBoxItem("employeeId", "员工姓名");
		employeeIdItem.setWidth("*");
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		
		departmentIdItem = new IPickTreeItem("departmentId", "所属部门");
		departmentIdItem.setWidth("*");
		departmentIdItem.setCanSelectParentItems(true);
		departmentIdItem.setValueField("treeId");
		departmentIdItem.setValueTree(KeyValueManager.getTree("departments"));
		
		setItems(employeeNoItem, employeeIdItem, departmentIdItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
