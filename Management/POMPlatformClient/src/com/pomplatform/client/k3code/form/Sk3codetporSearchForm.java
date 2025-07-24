package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDSk3codetpor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class Sk3codetporSearchForm extends SearchForm
{


	private final TextItem typeItem;
	private final SelectItem departmentTypeItem;

	public Sk3codetporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSk3codetpor.getInstance());
		typeItem = new TextItem("type", " 7收款方类型");
		departmentTypeItem = new SelectItem("departmentType", "部门类型");
		departmentTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_93"));

		setItems(typeItem, departmentTypeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
