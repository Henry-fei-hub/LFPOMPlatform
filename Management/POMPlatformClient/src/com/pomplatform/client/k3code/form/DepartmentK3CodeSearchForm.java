package com.pomplatform.client.k3code.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.k3code.datasource.CDDepartmentK3Code;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class DepartmentK3CodeSearchForm extends SearchForm
{


	private final ComboBoxItem businessIdItem;
	private final TextItem k3CodeItem;

	public DepartmentK3CodeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDDepartmentK3Code.getInstance());
		
		businessIdItem = new ComboBoxItem("businessId", "部门");
		businessIdItem.setChangeOnKeypress(false);
		businessIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		businessIdItem.setWidth("*");
		businessIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		
		k3CodeItem = new TextItem("k3Code", "K3代码");
		k3CodeItem.setWidth("*");

		setItems(businessIdItem, k3CodeItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
