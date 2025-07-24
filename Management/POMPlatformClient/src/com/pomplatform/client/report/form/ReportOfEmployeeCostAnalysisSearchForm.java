package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOfEmployeeCostAnalysis;

public class ReportOfEmployeeCostAnalysisSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem monthItem;

	public ReportOfEmployeeCostAnalysisSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOfEmployeeCostAnalysis.getInstance());
		
		Date currentDate = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		yearItem.setWidth("*");
		yearItem.setDefaultValue(currentDate.getYear()+1900);
		
		monthItem = new SelectItem("month", "月份");
		monthItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));
		monthItem.setWidth("*");
		monthItem.setDefaultValue(currentDate.getMonth()+1);

		setItems(yearItem, monthItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
