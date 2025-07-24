package com.pomplatform.client.receiveunit.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.receiveunit.datasource.CDMreceiveunitmanagepsrbbor;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class MreceiveunitmanagepsrbborSearchForm extends SearchForm {

	private final TextItem receiveUnitItem;
	private final TextItem bankAccountItem;
	private final TextItem bankNameItem;

	public MreceiveunitmanagepsrbborSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDMreceiveunitmanagepsrbbor.getInstance());
		receiveUnitItem = new TextItem("receiveUnit", "收款单位");
		receiveUnitItem.setWidth("*");
		bankAccountItem = new TextItem("bankAccount", "银行账号");
		bankAccountItem.setWidth("*");
		bankNameItem = new TextItem("bankName", "开户行");
		bankNameItem.setWidth("*");

		setItems(receiveUnitItem, bankAccountItem, bankNameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
