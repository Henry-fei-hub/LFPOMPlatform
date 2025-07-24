package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSCustomerK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CustomerK3CodeNewForm extends AbstractWizadPage
{


	private final TextItem typeItem;
	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;
	private final TextItem departmentTypeItem;

	public CustomerK3CodeNewForm() {
		DSCustomerK3Code ds = DSCustomerK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		typeItem = new TextItem("type", " 8收款单位");
		typeItem.setDefaultValue(9);//客户
		typeItem.hide();
		__formItems.add(typeItem);
		
		businessIdItem = new ComboBoxItem("businessId", "客户");
		businessIdItem.setWidth("*");
//		businessIdItem.setValueMap(KeyValueManager.getValueMap("customers"));
		KeyValueManager.loadValueMap("customers",businessIdItem);
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		__formItems.add(businessIdItem);
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");
		__formItems.add(k3CodeItem);
		
		k3NameItem = new TextItem("k3Name", "K3名称");
		k3NameItem.setWidth("*");
		__formItems.add(k3NameItem);
		
		departmentTypeItem = new TextItem("departmentType", "部门类型");
		departmentTypeItem.hide();
		__formItems.add(departmentTypeItem);

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
		manager.setDataSource(DSCustomerK3Code.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
