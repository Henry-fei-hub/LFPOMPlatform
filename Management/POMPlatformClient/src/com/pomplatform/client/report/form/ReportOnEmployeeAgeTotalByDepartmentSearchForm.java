package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOnEmployeeAgeTotalByDepartment;

public class ReportOnEmployeeAgeTotalByDepartmentSearchForm extends SearchForm
{


	private final SelectItem yearItem;
	private final SelectItem statusItem;
//	private final ComboBoxItem plateIdItem;

	public ReportOnEmployeeAgeTotalByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOnEmployeeAgeTotalByDepartment.getInstance());
		Date d = new Date();
		yearItem = new SelectItem("year", "年份");
		yearItem.setValue(d.getYear()+1900);
		yearItem.setWidth("*");
		yearItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));
		statusItem = new SelectItem("status", "状态");
		statusItem.setDefaultValue(0);// 默认显示在职的
		statusItem.setWidth("*");
		statusItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));
//		plateIdItem = new ComboBoxItem("plateId", "业务部门");
//		plateIdItem.setWidth("*");
//		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
//		plateIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		setItems(yearItem, statusItem);

		setNumCols(6);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
