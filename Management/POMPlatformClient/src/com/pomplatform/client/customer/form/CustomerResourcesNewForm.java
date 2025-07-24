package com.pomplatform.client.customer.form;

import java.util.Date;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.customer.datasource.DSCustomerResources;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CustomerResourcesNewForm extends AbstractWizadPage
{
	private final TextItem companyNameItem;
	private final TextItem companyAddressItem;
	private final TextItem nameItem;
	private final TextItem gradeItem;
	private final TextItem telephoneItem;
	private final TextItem emailItem;
	private final DateItem birthDateItem;
	private final SelectItem genderItem;
	public CustomerResourcesNewForm() {
		DSCustomerResources ds = DSCustomerResources.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		companyNameItem = new TextItem("companyName", "公司名称");
		companyNameItem.setWidth("*");
		__formItems.add(companyNameItem);
		
		companyAddressItem = new TextItem("companyAddress", "公司地址");
		companyAddressItem.setWidth("*");
		__formItems.add(companyAddressItem);
		
		nameItem = new TextItem("name", "客户名称");
		nameItem.setWidth("*");
		__formItems.add(nameItem);
		
		gradeItem = new TextItem("grade", "职位");
		gradeItem.setWidth("*");
		__formItems.add(gradeItem);
		
		emailItem = new TextItem("email", "邮箱");
		emailItem.setWidth("*");
		__formItems.add(emailItem);
		
		telephoneItem = new TextItem("telephone", "电话");
		telephoneItem.setWidth("*");
		__formItems.add(telephoneItem);
		
		birthDateItem = new DateItem("birthDate", "生日日期");
		birthDateItem.setWidth("*");
		birthDateItem.setUseTextField(true);
		__formItems.add(birthDateItem);
		
		genderItem = new SelectItem("gender", "性别");
		genderItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		genderItem.setWidth("*");
		__formItems.add(genderItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
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
		manager.setDataSource(DSCustomerResources.getInstance());
		manager.addMember(__form);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public java.util.Map getValuesAsMap() {
		Map value = __form.getValues();
		value.put("operateEmployeeId",ClientUtil.getEmployeeId());
		value.put("operateTime",new Date());
		return value;
	}


}
