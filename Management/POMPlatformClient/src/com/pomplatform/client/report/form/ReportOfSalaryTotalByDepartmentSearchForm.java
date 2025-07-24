package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOfSalaryTotalByDepartment;

public class ReportOfSalaryTotalByDepartmentSearchForm extends SearchForm
{


	private final TextItem companyIdItem;
	private final TextItem plateIdItem;
	private final TextItem departmentIdItem;
	private final TextItem yearItem;

	public ReportOfSalaryTotalByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOfSalaryTotalByDepartment.getInstance());
		companyIdItem = new TextItem("companyId", "归属公司");
		plateIdItem = new TextItem("plateId", "业务部门");
		departmentIdItem = new TextItem("departmentId", "归属部门");
		yearItem = new TextItem("year", "年份");

		setItems(companyIdItem, plateIdItem, departmentIdItem, yearItem);

		setNumCols(8);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
