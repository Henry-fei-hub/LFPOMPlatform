package com.pomplatform.client.k3code.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSCompanyK3Code;

public class CompanyK3CodeNewForm extends AbstractWizadPage
{


	private final TextItem typeItem;
	private final SelectItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;
	private final SelectItem parentIdItem;

	public CompanyK3CodeNewForm() {
		DSCompanyK3Code ds = DSCompanyK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		typeItem = new TextItem("type", " 7收款方类型");
		typeItem.setDefaultValue(2);//公司
		typeItem.hide();
		__formItems.add(typeItem);
		
		businessIdItem = new SelectItem("businessId", "公司");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		businessIdItem.setWidth("*");
		__formItems.add(businessIdItem);
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");
		__formItems.add(k3CodeItem);
		
		k3NameItem = new TextItem("k3Name", "K3名称");
		k3NameItem.setWidth("*");
		__formItems.add(k3NameItem);
		
		parentIdItem = new SelectItem("parentId", "父级id");
		parentIdItem.hide();
//		parentIdItem.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", parentIdItem);
		__formItems.add(parentIdItem);

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
		manager.setDataSource(DSCompanyK3Code.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
