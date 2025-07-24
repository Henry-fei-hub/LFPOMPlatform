package com.pomplatform.client.attachment.form;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnAttachmentSureSearchForm extends SearchForm
{
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem sheetCodeItem;
	private final TextItem sheetNameItem;

	public OnAttachmentSureSearchForm() {
		setWidth100();
		setHeight100();
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");
		sheetNameItem = new TextItem("sheetName", "订单名称");
		sheetNameItem.setWidth("*");

		setItems(contractCodeItem, contractNameItem,sheetCodeItem,sheetNameItem);
		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
