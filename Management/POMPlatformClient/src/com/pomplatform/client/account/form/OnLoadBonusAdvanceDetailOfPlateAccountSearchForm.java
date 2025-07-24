package com.pomplatform.client.account.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.account.datasource.CDOnLoadBonusAdvanceDetailOfPlateAccount;

public class OnLoadBonusAdvanceDetailOfPlateAccountSearchForm extends SearchForm
{


	private final SelectItem plateIdItem;
	private final TextItem businessTypeIdItem;
	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final TextItem manageProjectNameItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public OnLoadBonusAdvanceDetailOfPlateAccountSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadBonusAdvanceDetailOfPlateAccount.getInstance());
		plateIdItem = new SelectItem("plateId", "业务部门");
		plateIdItem.hide();
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		businessTypeIdItem = new TextItem("businessTypeId", "11绩效奖金)");
		businessTypeIdItem.hide();
		employeeNoItem = new TextItem("employeeNo", "员工编号");
		employeeNoItem.setWidth("*");
		employeeNameItem = new TextItem("employeeName", "员工姓名");
		employeeNameItem.setWidth("*");
		manageProjectNameItem = new TextItem("manageProjectName", "项目名称");
		manageProjectNameItem.setWidth("*");
		yearItem = new TextItem("year", "年份");
		yearItem.hide();
		monthItem = new TextItem("month", "月份");
		monthItem.hide();

		setItems(plateIdItem, businessTypeIdItem, employeeNoItem, employeeNameItem, manageProjectNameItem, yearItem, monthItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
