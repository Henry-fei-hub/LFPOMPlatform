package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.ui.AbstractWizadPage;
import com.pomplatform.client.k3code.datasource.DSSubjectTypeK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsIntegerValidator;

public class SubjectTypeK3CodeUpdateForm extends AbstractWizadPage
{


	private final TextItem k3CodeIdItem;
	private final TextItem typeItem;
	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;
	private final TextItem k3NameItem;
	private final SelectItem departmentTypeItem;

	public SubjectTypeK3CodeUpdateForm() {
		DSSubjectTypeK3Code ds = DSSubjectTypeK3Code.getInstance();
		__form.setWidth100();
		__form.setHeight100();
		k3CodeIdItem = new TextItem("k3CodeId", "主键编码");
		k3CodeIdItem.setDisabled(true);
		k3CodeIdItem.setRequired(true);
		k3CodeIdItem.hide();
		IsIntegerValidator k3CodeIdValidator = new IsIntegerValidator();
		k3CodeIdItem.setValidators(k3CodeIdValidator);
		__formItems.add(k3CodeIdItem);
		
		typeItem = new TextItem("type", " 7收款方类型");
		typeItem.hide();
		__formItems.add(typeItem);
		
		departmentTypeItem = new SelectItem("departmentType", "部门类型");
		departmentTypeItem.setWidth("*");
		departmentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_93"));
		__formItems.add(departmentTypeItem);
		
		businessIdItem = new ComboBoxItem("businessId", "科目");
		businessIdItem.setWidth("*");
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		businessIdItem.setValueMap(KeyValueManager.getValueMap("subject_types"));
		KeyValueManager.loadValueMap("subject_types",businessIdItem );
		businessIdItem.setCanEdit(false);
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
		setPageMode(PAGE_MODE_UPDATE);
		addMember(__form);
	}

	@Override
	public void startEdit() {
		if(getRecord() != null) __form.editRecord(getRecord());
	}

	@Override
	public void setValueManage(ValuesManager manager) {
		manager.setDataSource(DSSubjectTypeK3Code.getInstance());
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
