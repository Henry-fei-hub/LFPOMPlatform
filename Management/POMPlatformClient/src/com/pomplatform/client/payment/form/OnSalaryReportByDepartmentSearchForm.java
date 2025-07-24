package com.pomplatform.client.payment.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.types.TextMatchStyle;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.payment.datasource.CDOnSalaryReportByDepartment;

public class OnSalaryReportByDepartmentSearchForm extends SearchForm
{


	private final SelectItem companyIdItem;
	private final ComboBoxItem plateIdItem;
	private final SelectItem departmentIdItem;
	private final TextItem yearItem;
	private final TextItem monthItem;

	public OnSalaryReportByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDOnSalaryReportByDepartment.getInstance());
		companyIdItem = new SelectItem("companyId", "归属公司");
		companyIdItem.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		plateIdItem = new ComboBoxItem("plateId", "业务部门");
		plateIdItem.setWidth("*");
		plateIdItem.setTextMatchStyle(TextMatchStyle.SUBSTRING);
		plateIdItem.setValueMap(KeyValueManager.getValueMap("plate_records"));	
		departmentIdItem = new SelectItem("departmentId", "归属部门");
		departmentIdItem.setValueMap(KeyValueManager.getValueMap("departments"));
		yearItem = new TextItem("year", "年份");
		monthItem = new TextItem("month", "月份");

		setItems(companyIdItem, plateIdItem, departmentIdItem, yearItem, monthItem);

		setNumCols(10);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
