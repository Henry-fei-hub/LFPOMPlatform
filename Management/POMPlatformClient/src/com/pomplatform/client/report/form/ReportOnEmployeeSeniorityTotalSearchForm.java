package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOnEmployeeAgeTotal;
import com.pomplatform.client.report.datasource.CDReportOnEmployeeSeniorityTotal;

public class ReportOnEmployeeSeniorityTotalSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final ComboBoxItem plateIdItem;

	public ReportOnEmployeeSeniorityTotalSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOnEmployeeAgeTotal.getInstance());
		Date d = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		setItems(yearItem, plateIdItem);

		setNumCols(7);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
