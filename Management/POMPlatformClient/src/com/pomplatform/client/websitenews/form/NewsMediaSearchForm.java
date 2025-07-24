package com.pomplatform.client.websitenews.form;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.BooleanItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class NewsMediaSearchForm extends SearchForm
{
	private final TextItem nameZhItem;
	private final BooleanItem isAuditedItem;

	public NewsMediaSearchForm() {
		setWidth100();
		setHeight100();
		nameZhItem = new TextItem("nameZh", "名称");
		nameZhItem.setWidth("*");
		isAuditedItem = new BooleanItem("isAudited", "是否审核");
		isAuditedItem.setWidth("*");
		setItems(nameZhItem, isAuditedItem);
		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
