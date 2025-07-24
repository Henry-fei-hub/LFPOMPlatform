package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDApplyListOfPreProjectReport extends DataSource
{


	public static CDApplyListOfPreProjectReport instance = null;

	public static CDApplyListOfPreProjectReport getInstance() {
		if(instance == null) {
			instance = new CDApplyListOfPreProjectReport("CDApplyListOfPreProjectReport");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField employeeIdField;

	public CDApplyListOfPreProjectReport(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(128);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startDateField = new DataSourceDateTimeField("startDate", "开始时间");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "截止时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(processTypeField, projectNameField, projectTypeField, startDateField, endDateField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

