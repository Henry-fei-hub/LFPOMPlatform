package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSCompanyK3Code;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class CompanyK3CodeUpdateForm extends AbstractWizadPage
{


	private final TextItem k3CodeIdItem;
	private final TextItem typeItem;
	private final SelectItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;
	private final SelectItem parentIdItem;

	public CompanyK3CodeUpdateForm() {
		DSCompanyK3Code ds = DSCompanyK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		
		k3CodeIdItem = new TextItem("k3CodeId", "主键编码");
		k3CodeIdItem.setDisabled(true);
		k3CodeIdItem.setRequired(true);
		IsIntegerValidator k3CodeIdValidator = new IsIntegerValidator();
		k3CodeIdItem.setValidators(k3CodeIdValidator);
		k3CodeIdItem.hide();
		__formItems.add(k3CodeIdItem);
		
		typeItem = new TextItem("type", " 7收款方类型");
		typeItem.hide();
		__formItems.add(typeItem);
		
		businessIdItem = new SelectItem("businessId", "公司");
		businessIdItem.setWidth("*");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		businessIdItem.setCanEdit(false);
		__formItems.add(businessIdItem);
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");
		__formItems.add(k3CodeItem);
		
		k3NameItem = new TextItem("k3Name", "K3名称");
		k3NameItem.setWidth("*");
		__formItems.add(k3NameItem);
		
		parentIdItem = new SelectItem("parentId", "父级id");
		parentIdItem.hide();
		__formItems.add(parentIdItem);

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
		manager.setDataSource(DSCompanyK3Code.getInstance());
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
