package com.pomplatform.client.customer.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.customer.datasource.DSCustomerInfo;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class CustomerInfoUpdateForm extends AbstractWizadPage
{


	private final TextItem customerIdItem;
	private final TextItem customerNameItem;
	private final DateTimeItem createTimeItem;

	public CustomerInfoUpdateForm() {
		DSCustomerInfo ds = DSCustomerInfo.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		customerIdItem = new TextItem("customerId", "主键编码");
		customerIdItem.setDisabled(true);
		customerIdItem.setRequired(true);
		customerIdItem.hide();
		IsIntegerValidator customerIdValidator = new IsIntegerValidator();
		customerIdItem.setValidators(customerIdValidator);
		__formItems.add(customerIdItem);
		customerNameItem = new TextItem("customerName", "客户名称");
		customerNameItem.setWidth("*");
		__formItems.add(customerNameItem);
		createTimeItem = new DateTimeItem("createTime", "创建时间");
		createTimeItem.setWidth("*");
		createTimeItem.setDisabled(true);
		__formItems.add(createTimeItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(2);
		ClientUtil.DynamicFormProcessAccordingToDevice(__form);
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSCustomerInfo.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
