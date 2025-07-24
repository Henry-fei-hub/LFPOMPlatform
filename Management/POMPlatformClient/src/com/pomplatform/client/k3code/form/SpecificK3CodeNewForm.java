package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.common.ClientStaticUtils;
import com.pomplatform.client.k3code.datasource.DSCompanyK3Code;
import com.pomplatform.client.k3code.datasource.DSSpecificK3Code;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SpecificK3CodeNewForm extends AbstractWizadPage {

	private final TextItem typeItem;
	private final SelectItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;

	public SpecificK3CodeNewForm() {
		DSSpecificK3Code ds = DSSpecificK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();

		typeItem = new TextItem("type", "类型");
		typeItem.setDefaultValue(ClientStaticUtils.K3_CODE_TYPE_0);// 其他/特定
		typeItem.hide();
		__formItems.add(typeItem);

		businessIdItem = new SelectItem("businessId", "特定科目");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_210"));
		businessIdItem.setWidth("*");
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
		if (getRecord() != null)
			__form.editRecord(getRecord());
		else
			__form.editNewRecord();
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSpecificK3Code.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}

}
