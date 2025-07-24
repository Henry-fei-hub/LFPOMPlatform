package com.pomplatform.client.companyarea.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.fields.events.*;
import com.smartgwt.client.widgets.form.validator.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.*;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.companyarea.datasource.DSCompanyarea;

public class CompanyareaUpdateForm extends AbstractWizadPage
{


	private final TextItem companyAreaIdItem;
	private final TextItem companyIdItem;
	private final ComboBoxItem areaIdItem;
	private final TextItem companyNameItem;
	private final TextItem companyCodeItem;
	private final CheckboxItem isEnabledItem;
	private final TextItem companyNoItem;
	private final TextItem companyNameSimpleItem;


	public CompanyareaUpdateForm() {
		DSCompanyarea ds = DSCompanyarea.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		companyAreaIdItem = new TextItem("companyAreaId", "主键");
		companyAreaIdItem.setDisabled(true);
		companyAreaIdItem.setRequired(true);
		companyAreaIdItem.hide();
		companyAreaIdItem.setWidth("*");
		IsIntegerValidator companyAreaIdValidator = new IsIntegerValidator();
		companyAreaIdItem.setValidators(companyAreaIdValidator);
		__formItems.add(companyAreaIdItem);
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
		__formItems.add(isEnabledItem);

		__form.setItems(getFormItemArray());
		__form.setDataSource(ds);
		__form.setNumCols(4);
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
		manager.setDataSource(DSCompanyarea.getInstance());
		manager.addMember(__form);
	}

	@Override
	public boolean checkData() {
		return true;
	}

	@Override
	public java.util.Map getValuesAsMap() {
		Map values = __form.getValues();
		values.put("optType", "saveorupdatecompany");
		values.put("saveorupdate", "update");
		return values;
	}


}
