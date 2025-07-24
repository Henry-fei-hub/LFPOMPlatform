package com.pomplatform.client.account.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.account.datasource.CDOnLoadProjectSettlementDetailOfPlateAccount;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadProjectSettlementDetailOfPlateAccountSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem businessTypeIdItem;
	private final TextItem sheetCodeItem;
	private final TextItem sheetNameItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public OnLoadProjectSettlementDetailOfPlateAccountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadProjectSettlementDetailOfPlateAccount.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.hide();
		businessTypeIdItem = new TextItem("businessTypeId", "11绩效奖金)");
		businessTypeIdItem.hide();
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");
		sheetNameItem = new TextItem("sheetName", "订单名称");
		sheetNameItem.setWidth("*");
		yearItem = new TextItem("year", "年份");
		yearItem.hide();
		monthItem = new TextItem("month", "月份");
		monthItem.hide();

		setItems(plateIdItem, businessTypeIdItem, sheetCodeItem, sheetNameItem, yearItem, monthItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
