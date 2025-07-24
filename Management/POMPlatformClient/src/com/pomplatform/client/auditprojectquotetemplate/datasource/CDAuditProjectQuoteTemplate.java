package com.pomplatform.client.auditprojectquotetemplate.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDAuditProjectQuoteTemplate extends DataSource
{


	public static CDAuditProjectQuoteTemplate instance = null;

	public static CDAuditProjectQuoteTemplate getInstance() {
		if(instance == null) {
			instance = new CDAuditProjectQuoteTemplate("CDAuditProjectQuoteTemplate");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField businessTypeField;

	public CDAuditProjectQuoteTemplate(String dataSourceID) {

		setID(dataSourceID);
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

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

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);

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


		setFields(processStatusField, employeeIdField, statusField, processTypeField, projectNameField, projectTypeField, operateEmployeeIdField, businessTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

