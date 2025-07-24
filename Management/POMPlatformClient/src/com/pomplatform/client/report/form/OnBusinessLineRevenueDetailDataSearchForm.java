package com.pomplatform.client.report.form;

import java.util.Date;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDOnBusinessLineRevenueDetailData;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;

public class OnBusinessLineRevenueDetailDataSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem businessLineItem;
	private final TextItem sheetCodeItem;
	private final TextItem projectNameItem;

	@SuppressWarnings("deprecation")
	public OnBusinessLineRevenueDetailDataSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnBusinessLineRevenueDetailData.getInstance());
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		Date currentDate = new Date();
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));	
		businessLineItem = new SelectItem("businessLine", "业务条线");
		businessLineItem.setWidth("*");
//		businessLineItem.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessLineItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));
		
		
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "订单名称");
		projectNameItem.setWidth("*");

		setItems(yearItem, plateIdItem, businessLineItem, sheetCodeItem, projectNameItem);

		setNumCols(11);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
