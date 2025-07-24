package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSReceiveUnitK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ReceiveUnitK3CodeNewForm extends AbstractWizadPage
{


	private final TextItem typeItem;
	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;

	public ReceiveUnitK3CodeNewForm() {
		DSReceiveUnitK3Code ds = DSReceiveUnitK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		typeItem = new TextItem("type", " 7收款方类型");
		typeItem.setDefaultValue(8);
		typeItem.hide();
		__formItems.add(typeItem);
		
		businessIdItem = new ComboBoxItem("businessId", "收款单位");
//		businessIdItem.setValueMap(KeyValueManager.getValueMap("receive_unit_manages_company"));
		KeyValueManager.loadValueMap("receive_unit_manages_company",businessIdItem);
		businessIdItem.setWidth("*");
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
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
		manager.setDataSource(DSReceiveUnitK3Code.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}


}
