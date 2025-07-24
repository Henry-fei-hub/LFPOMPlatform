package com.pomplatform.client.project.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnLoadInAchieveDetailSearchForm extends SearchForm
{


	private final SelectItem lastYearItem;
	private final SelectItem lastMonthItem;
	private final SelectItem projectIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final ComboBoxItem plateIdItem;
	private final TextItem contractCodeItem;
	private final TextItem contractNameItem;
	private final TextItem sheetCodeItem;
	private final TextItem sheetNameItem;

	public OnLoadInAchieveDetailSearchForm() {
		setWidth100();
		setHeight100();
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
		int lastYear = 0;
		int lastMonth = 0;
		if(month == 1){
			lastYear = year - 1;
			lastMonth = 12;
		}else{
			lastYear = year;
			lastMonth = month - 1;
		}
		lastYearItem = new SelectItem("lastYear", "年份");
		lastYearItem.hide();
		lastYearItem.setDefaultValue(lastYear);
		lastMonthItem = new SelectItem("lastMonth", "月份");
		lastMonthItem.hide();
		lastMonthItem.setDefaultValue(lastMonth);
		projectIdItem = new SelectItem("projectId", "项目编码");
		projectIdItem.hide();
//		KeyValueManager.loadValueMap("projects",projectIdItem);
		KeyValueManager.loadValueMap("projects", projectIdItem);
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int chooseYear = BaseHelpUtils.getIntValue(event.getValue());
				int chooseMonth = BaseHelpUtils.getIntValue(monthItem.getValue());
				if(chooseMonth == 1){
					lastYearItem.setValue(chooseYear-1);
					lastMonthItem.setValue(12);
				}else{
					lastYearItem.setValue(chooseYear);
					lastMonthItem.setValue(chooseMonth-1);
				}
			}
		});
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValue(month);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.addChangedHandler(new ChangedHandler() {
			@Override
			public void onChanged(ChangedEvent event) {
				int chooseMonth = BaseHelpUtils.getIntValue(event.getValue());
				int chooseYear = BaseHelpUtils.getIntValue(yearItem.getValue());
				if(chooseMonth == 1){
					lastYearItem.setValue(chooseYear-1);
					lastMonthItem.setValue(12);
				}else{
					lastYearItem.setValue(chooseYear);
					lastMonthItem.setValue(chooseMonth-1);
				}
			}
		});
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		contractCodeItem = new TextItem("contractCode", "合同编号");
		contractCodeItem.setWidth("*");
		contractNameItem = new TextItem("contractName", "合同名称");
		contractNameItem.setWidth("*");
		sheetCodeItem = new TextItem("sheetCode", "订单编号");
		sheetCodeItem.setWidth("*");
		sheetNameItem = new TextItem("sheetName", "订单名称");
		sheetNameItem.setWidth("*");

		setItems(lastYearItem, lastMonthItem, projectIdItem, plateIdItem, yearItem, monthItem, contractCodeItem, contractNameItem, sheetCodeItem, sheetNameItem);

		setNumCols(15);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
