package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRefuseListOfMainProjectReport extends DataSource
{


	public static CDRefuseListOfMainProjectReport instance = null;

	public static CDRefuseListOfMainProjectReport getInstance() {
		if(instance == null) {
			instance = new CDRefuseListOfMainProjectReport("CDRefuseListOfMainProjectReport");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField employeeIdField;

	public CDRefuseListOfMainProjectReport(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(128);
		projectTypeField.setHidden(false);

		startDateField = new DataSourceDateTimeField("startDate", "创建时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "创建时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(processTypeField, processStatusField, projectNameField, projectTypeField, startDateField, endDateField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

