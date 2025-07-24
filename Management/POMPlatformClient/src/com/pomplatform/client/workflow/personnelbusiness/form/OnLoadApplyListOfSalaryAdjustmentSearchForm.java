package com.pomplatform.client.workflow.personnelbusiness.form;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.workflow.personnelbusiness.datasource.CDOnLoadApplyListOfSalaryAdjustment;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class OnLoadApplyListOfSalaryAdjustmentSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem plateIdItem;
	private final ComboBoxItem employeeIdItem;
	private final SelectItem drafterItem;

	public OnLoadApplyListOfSalaryAdjustmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnLoadApplyListOfSalaryAdjustment.getInstance());
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		employeeIdItem = new ComboBoxItem("employeeId", "姓名");
		employeeIdItem.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdItem.setChangeOnKeypress(false);
		employeeIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		employeeIdItem.setWidth("*");
		
		drafterItem = new SelectItem("drafter", "起草人");
		drafterItem.setValueMap(KeyValueManager.getValueMap("employees"));
		drafterItem.hide();

		setItems(yearItem, monthItem, plateIdItem, employeeIdItem, drafterItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
