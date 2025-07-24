package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOnEmployeeNumTotalByDepartment;

public class ReportOnEmployeeNumTotalByDepartmentSearchForm extends SearchForm
{


	private final TextItem yearItem;
	private final TextItem plateIdItem;

	public ReportOnEmployeeNumTotalByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOnEmployeeNumTotalByDepartment.getInstance());
		yearItem = new TextItem("year", "年份");
		plateIdItem = new TextItem("plateId", "业务部门");

		setItems(yearItem, plateIdItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
