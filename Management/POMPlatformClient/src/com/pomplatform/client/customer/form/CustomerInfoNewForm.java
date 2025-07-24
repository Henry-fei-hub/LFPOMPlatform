package com.pomplatform.client.customer.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.customer.datasource.DSCustomerInfo;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CustomerInfoNewForm extends AbstractWizadPage
{


	private final TextItem customerNameItem;

	public CustomerInfoNewForm() {
		DSCustomerInfo ds = DSCustomerInfo.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);

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
		manager.setDataSource(DSCustomerInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
