package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSCompanyK3Code;
import com.pomplatform.client.k3code.datasource.DSPlateAreaK3Code;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class PlateAreaK3CodeNewForm extends AbstractWizadPage {

	private final TextItem typeItem;
	private final SelectItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;
	private final SelectItem additionalBusinessIdItem;

	public PlateAreaK3CodeNewForm() {
		DSPlateAreaK3Code ds = DSPlateAreaK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		typeItem = new TextItem("type", "类型");
		typeItem.setDefaultValue(10);// 板块与区域
		typeItem.hide();
		__formItems.add(typeItem);

		businessIdItem = new SelectItem("businessId", "业务类别");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessIdItem.setWidth("*");
		__formItems.add(businessIdItem);

		additionalBusinessIdItem = new SelectItem("additionalBusinessId", "区域");
		additionalBusinessIdItem.setWidth("*");
		additionalBusinessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_116"));
		__formItems.add(additionalBusinessIdItem);

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
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
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
