package com.pomplatform.client.report.form;

import com.delicacy.client.data.ClientUtil;
import com.pomplatform.client.report.datasource.CDReportProjectWorkTime;
import com.smartgwt.client.widgets.form.SearchForm;
import com.smartgwt.client.widgets.form.fields.TextItem;


public class ReportProjectWorkTimeSearchForm extends SearchForm
{


	private final TextItem projectCodeItem;
	private final TextItem projectNameItem;

	public ReportProjectWorkTimeSearchForm() {
		setWidth100();
		setHeight100();
		setDataSource(CDReportProjectWorkTime.getInstance());
		projectCodeItem = new TextItem("projectCode", "项目编号");
		projectCodeItem.setWidth("*");
		projectNameItem = new TextItem("projectName", "项目名称");
		projectNameItem.setWidth("*");
		setItems(projectCodeItem, projectNameItem);

		setNumCols(4);
		ClientUtil.searchFormProcessAccordingToDevice(this);
	}

	@Override
	public void setHeight(int height) {
		super.setHeight(60);
	}
}
