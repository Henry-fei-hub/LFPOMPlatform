package com.pomplatform.client.companyarea.form;

import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.companyarea.datasource.DSCompanyarea;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class CompanyareaNewForm extends AbstractWizadPage
{


	private final TextItem companyIdItem;
	private final ComboBoxItem areaIdItem;
	private final TextItem companyNameItem;
	private final TextItem companyCodeItem;
	private final CheckboxItem isEnabledItem;
	private final TextItem companyNoItem;
	private final TextItem companyNameSimpleItem;


	public CompanyareaNewForm() {
		DSCompanyarea ds = DSCompanyarea.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		companyIdItem = new TextItem("companyId", "公司");
		companyIdItem.hide();
		companyIdItem.setWidth("*");
		__formItems.add(companyIdItem);
		companyNameItem = new TextItem("companyName", "公司名称");
		companyNameItem.setWidth("*");
		__formItems.add(companyNameItem);
		companyNameSimpleItem = new TextItem("companyNameSimple", "公司简称");
		companyNameSimpleItem.setWidth("*");
		__formItems.add(companyNameSimpleItem);
		companyNoItem = new TextItem("companyNo", "公司编号");
		companyNoItem.setWidth("*");
		__formItems.add(companyNoItem);
		companyCodeItem = new TextItem("companyCode", "公司代码");
		companyCodeItem.setWidth("*");
		__formItems.add(companyCodeItem);
		areaIdItem = new ComboBoxItem("areaId", "区域");
		areaIdItem.setWidth("*");
		areaIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		areaIdItem.setValueMap(KeyValueManager.getValueMap("areas"));
		__formItems.add(areaIdItem);
		isEnabledItem = new CheckboxItem("isEnabled", "是否启用");
		isEnabledItem.setDefaultValue(true);
		__formItems.add(isEnabledItem);
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
		manager.setDataSource(DSCompanyarea.getInstance());
		manager.addMember(__form);
	}

	@Override
	public java.util.Map getValuesAsMap() {
		
		Map values = __form.getValues();
		values.put("optType", "saveorupdatecompany");
		values.put("saveorupdate", "save");
		return values;
	}


}
