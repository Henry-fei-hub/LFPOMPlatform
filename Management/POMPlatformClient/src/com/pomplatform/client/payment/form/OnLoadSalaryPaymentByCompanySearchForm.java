package com.pomplatform.client.payment.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class OnLoadSalaryPaymentByCompanySearchForm extends SearchForm
{
	private final ComboBoxItem companyIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;
	private final SelectItem typeItem;

	public OnLoadSalaryPaymentByCompanySearchForm() {
		setWidth100();
		setHeight100();
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		DateTimeFormat monthDf = DateTimeFormat.getFormat("MM");
		int month = BaseHelpUtils.getIntValue(monthDf.format(date));
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setWidth("*");
		monthItem.setValue(month);
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		
		typeItem = new SelectItem("type", "类型");
		typeItem.setWidth("*");
		typeItem.setValue(1);
		typeItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_124"));
		setItems(companyIdItem, yearItem, monthItem, typeItem);
		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
