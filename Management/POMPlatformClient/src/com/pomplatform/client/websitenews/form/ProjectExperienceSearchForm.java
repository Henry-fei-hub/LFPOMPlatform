package com.pomplatform.client.websitenews.form;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class ProjectExperienceSearchForm extends SearchForm
{
	private final TextItem nameZhItem;
	private final TextItem projectAddressZhItem;
	private final TextItem mainThemeZhItem;
	private final BooleanItem isAuditedItem;

	public ProjectExperienceSearchForm() {
		setWidth100();
		setHeight100();
		nameZhItem = new TextItem("nameZh", "名称");
		nameZhItem.setWidth("*");
		projectAddressZhItem = new TextItem("projectAddressZh", "项目地址");
		projectAddressZhItem.setWidth("*");
		mainThemeZhItem = new TextItem("mainThemeZh", "主要题材");
		mainThemeZhItem.setWidth("*");
		isAuditedItem = new BooleanItem("isAudited", "是否审核");
		isAuditedItem.setWidth("*");
		setItems(nameZhItem, projectAddressZhItem, mainThemeZhItem, isAuditedItem);
		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
