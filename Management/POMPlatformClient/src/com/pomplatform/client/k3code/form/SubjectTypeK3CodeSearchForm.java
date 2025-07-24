package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDSubjectTypeK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SubjectTypeK3CodeSearchForm extends SearchForm
{


	private final ComboBoxItem businessIdItem;
	private final SelectItem departmentTypeItem;
	private final TextItem k3CodeItem;

	public SubjectTypeK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSubjectTypeK3Code.getInstance());
		businessIdItem = new ComboBoxItem("businessId", "科目");
//		businessIdItem.setValueMap(KeyValueManager.getValueMap("subject_types"));
		KeyValueManager.loadValueMap("subject_types",businessIdItem );
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		businessIdItem.setWidth("*");
		
		departmentTypeItem = new SelectItem("departmentType", "部门类型");
		departmentTypeItem.setWidth("*");
		departmentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_93"));
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		setItems(departmentTypeItem, businessIdItem, k3CodeItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
