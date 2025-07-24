package com.pomplatform.client.function.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.function.datasource.DSSfunctionffor;

public class SfunctionfforNewForm extends AbstractWizadPage {

	private final TextItem functionCodeItem;
	private final TextItem functionNameItem;
	private final CheckboxItem enabledItem;

	public SfunctionfforNewForm() {
		DSSfunctionffor ds = DSSfunctionffor.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		functionCodeItem = new TextItem("functionCode", "功能编号");
		functionCodeItem.setWidth("*");
		__formItems.add(functionCodeItem);
		
		functionNameItem = new TextItem("functionName", "功能名称");
		functionNameItem.setWidth("*");
		__formItems.add(functionNameItem);
		
		enabledItem = new CheckboxItem("enabled", "是否有效");
		__formItems.add(enabledItem);

		__form.setItems(getFormItemArray());

		__form.setDataSource(ds);
		__form.setNumCols(4);
		addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public void startEdit() {
		if (getRecord() != null) {
			__form.editRecord(getRecord());
		} else {
			__form.editNewRecord();
		}
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSfunctionffor.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		return __form.getValues();
	}
}
