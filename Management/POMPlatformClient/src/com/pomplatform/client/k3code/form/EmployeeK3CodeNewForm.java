package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.employeerescord.datasource.DSEmployee;
import com.pomplatform.client.k3code.datasource.DSEmployeeK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGridField;

public class EmployeeK3CodeNewForm extends AbstractWizadPage
{


	private final TextItem typeItem;
	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;

	public EmployeeK3CodeNewForm() {
		DSEmployeeK3Code ds = DSEmployeeK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		typeItem = new TextItem("type", " 7收款方类型");
		typeItem.setDefaultValue(1);
		typeItem.hide();
		__formItems.add(typeItem);
		
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
		__formItems.add(businessIdItem);
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");
		__formItems.add(k3CodeItem);
		
		k3NameItem = new TextItem("k3Name", "K3名称");
		k3NameItem.setWidth("*");
		__formItems.add(k3NameItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
		else __form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSEmployeeK3Code.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
