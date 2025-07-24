package com.pomplatform.client.employee.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.employee.datasource.CDUpdateFrozenIntegral;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class UpdateFrozenIntegralSearchForm extends SearchForm
{


	private final TextItem employeeNoItem;
	private final TextItem employeeNameItem;
	private final ComboBoxItem plateIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public UpdateFrozenIntegralSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDUpdateFrozenIntegral.getInstance());
		
		employeeNoItem = new TextItem("employeeNo", "工号");
		employeeNoItem.setWidth("*");
		
		employeeNameItem = new TextItem("employeeName", "姓名");
		employeeNameItem.setWidth("*");
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setWidth("*");
		plateIdItem.setChangeOnKeypress(false);
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		
		yearItem = new TextItem("year", "离职年份");
		yearItem.setWidth("*");
		
		monthItem = new TextItem("month", "离职月份");
		monthItem.setWidth("*");
		
		setItems(employeeNoItem, employeeNameItem, plateIdItem, yearItem, monthItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
