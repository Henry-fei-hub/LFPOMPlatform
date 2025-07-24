package com.pomplatform.client.payment.form;

import java.util.Date;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.pomplatform.client.payment.datasource.CDOnSalaryReportByPlate;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.SelectItem;

public class OnSalaryReportByPlateSearchForm extends SearchForm
{


	private final ComboBoxItem companyIdItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem yearItem;
	private final SelectItem monthItem;

	public OnSalaryReportByPlateSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnSalaryReportByPlate.getInstance());
		companyIdItem = new ComboBoxItem("companyId", "归属公司");
		companyIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		companyIdItem.setWidth("*");
		companyIdItem.hide();
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setWidth("*");
		
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
		monthItem.setHidden(false);
//		
//		startTimeItem = new DateTimeItem("startTime", "发放时间");
//		startTimeItem.setWidth("*");
//		
//		endTimeItem = new DateTimeItem("endTime", "发放时间");
//		endTimeItem.setWidth("*");


		setItems(companyIdItem, plateIdItem, yearItem, monthItem);

		setNumCols(9);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
