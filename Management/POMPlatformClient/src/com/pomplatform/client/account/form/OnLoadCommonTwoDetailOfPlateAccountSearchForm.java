package com.pomplatform.client.account.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.account.datasource.CDOnLoadCommonTwoDetailOfPlateAccount;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnLoadCommonTwoDetailOfPlateAccountSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem businessTypeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public OnLoadCommonTwoDetailOfPlateAccountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadCommonTwoDetailOfPlateAccount.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		businessTypeIdItem = new TextItem("businessTypeId", "11绩效奖金)");
		businessTypeIdItem.hide();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		yearItem = new TextItem("year", "年份");
		yearItem.hide();
		monthItem = new TextItem("month", "月份");
		monthItem.hide();

		setItems(plateIdItem, businessTypeIdItem, employeeNoItem, employeeNameItem, yearItem, monthItem);

		setNumCols(5);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
