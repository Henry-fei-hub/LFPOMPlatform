package com.pomplatform.client.cdcmanage.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.cdcmanage.datasource.CDSmainprojectpppor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SmainprojectppporSearchForm extends SearchForm {

	private final SelectItem projectBaseOnItem;
	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;
	private final TextItem infoCodeItem;
	private final CheckboxItem onlyCDCItem;

	public SmainprojectppporSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDSmainprojectpppor.getInstance());
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		
		onlyCDCItem = new CheckboxItem("onlyCDC", "只显示在CDC存在的项目");
		onlyCDCItem.setWidth("*");
		
		projectBaseOnItem = new SelectItem("projectBaseOn", "立项依据");
		projectBaseOnItem.setWidth("*");
		projectBaseOnItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		
		infoCodeItem = new TextItem("infoCode", "信息编号");
		infoCodeItem.setWidth("*");
		
		setItems(projectCodeItem, projectNameItem, projectBaseOnItem, infoCodeItem, onlyCDCItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
