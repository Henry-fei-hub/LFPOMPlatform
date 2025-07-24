package com.pomplatform.client.payment.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.DateTimeItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;

public class OnSalaryAnnualBonusByCompanySearchForm extends SearchForm
{
	private final ComboBoxItem companyIdItem;
	private final SelectItem yearItem;
	private final DateTimeItem startTimeItem;
	private final DateTimeItem endTimeItem;

	public OnSalaryAnnualBonusByCompanySearchForm() {
		setWidth100();
		setHeight100();
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		
		Date date = new Date();
		DateTimeFormat yearDf = DateTimeFormat.getFormat("yyyy");
		int year = BaseHelpUtils.getIntValue(yearDf.format(date));
		yearItem = new SelectItem("year", "年份");
		yearItem.setWidth("*");
		yearItem.setValue(year);
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		startTimeItem = new DateTimeItem("startTime", "发放时间");
		startTimeItem.setWidth("*");
		
		endTimeItem = new DateTimeItem("endTime", "发放时间");
		endTimeItem.setWidth("*");
		
		setItems(companyIdItem,yearItem,startTimeItem,endTimeItem);
		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
