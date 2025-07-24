package com.pomplatform.client.report.form;

import java.util.*;
import com.smartgwt.client.widgets.form.fields.*;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.KeyValueManager;
import com.pomplatform.client.report.datasource.CDReportOfGenderAnalysisByDepartment;

public class ReportOfGenderAnalysisByDepartmentSearchForm extends SearchForm
{


	private final TextItem plateIdItem;

	public ReportOfGenderAnalysisByDepartmentSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportOfGenderAnalysisByDepartment.getInstance());
		plateIdItem = new TextItem("plateId", "业务部门");

		setItems(plateIdItem);

		setNumCols(2);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

}
