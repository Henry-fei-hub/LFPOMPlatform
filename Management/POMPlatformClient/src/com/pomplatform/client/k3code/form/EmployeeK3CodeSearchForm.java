package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.k3code.datasource.CDEmployeeK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class EmployeeK3CodeSearchForm extends SearchForm
{


	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;

	public EmployeeK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDEmployeeK3Code.getInstance());
		
		//员工信息字段
		ListGridField employeeIdField = new ListGridField("employeeId");
		ListGridField employeeNoField = new ListGridField("employeeNo");
		ListGridField employeeNameField = new ListGridField("employeeName");
		ListGridField departmentIdField = new ListGridField("departmentId");
        departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		
		businessIdItem = new ComboBoxItem("businessId", "员工");
		businessIdItem.setWidth("*");
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setOptionDataSource(DSEmployee.getInstance());
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		businessIdItem.setValueField(employeeIdField.getName());
		businessIdItem.setDisplayField(employeeNameField.getName());
		businessIdItem.setPickListFields(employeeNameField, employeeNoField, departmentIdField);
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		setItems(businessIdItem, k3CodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
