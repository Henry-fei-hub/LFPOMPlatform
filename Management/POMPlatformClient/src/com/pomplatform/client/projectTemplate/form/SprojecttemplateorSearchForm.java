package com.pomplatform.client.projectTemplate.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.projectTemplate.datasource.CDSprojecttemplateor;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class SprojecttemplateorSearchForm extends SearchForm
{


	private final SelectItem projectTypeItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem businessTypeItem;

	public SprojecttemplateorSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSprojecttemplateor.getInstance());
		projectTypeItem = new SelectItem("projectType", "项目类别");
		projectTypeItem.setWidth("*");
		projectTypeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		businessTypeItem = new SelectItem("businessType", "业务类别");
		businessTypeItem.setWidth("*");
		businessTypeItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		setItems(businessTypeItem, plateIdItem ,projectTypeItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
