package com.pomplatform.client.account.form;

import com.delicacy.client.data.ClientUtil;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class SheetAccountAllSearchForm extends SearchForm {

	private final TextItem sheetCodeItem;
	private final TextItem sheetNameItem;
	private final DateItem startDateItem;
	private final DateItem endDateItem;

	public SheetAccountAllSearchForm() {
		setWidth100();
		setHeight100();
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");
		sheetNameItem = new TextItem("sheetName", "订单名称");
		sheetNameItem.setWidth("*");
		startDateItem = new DateItem("startDate", "开始时间");
		startDateItem.setWidth("*");
		startDateItem.setUseTextField(true);  
		endDateItem = new DateItem("endDate", "截止时间");
		endDateItem.setWidth("*");
		endDateItem.setUseTextField(true);  

		setItems(sheetCodeItem, sheetNameItem,startDateItem, endDateItem);
		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
