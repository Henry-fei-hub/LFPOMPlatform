package com.pomplatform.client.refuseprojectquotetemplate.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRefuseProjectQuoteTemplate extends DataSource
{


	public static CDRefuseProjectQuoteTemplate instance = null;

	public static CDRefuseProjectQuoteTemplate getInstance() {
		if(instance == null) {
			instance = new CDRefuseProjectQuoteTemplate("CDRefuseProjectQuoteTemplate");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceTextField projectNameField;
	private final DataSourceDateTimeField createTimeStartField;
	private final DataSourceDateTimeField createTimeEndField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField businessTypeField;

	public CDRefuseProjectQuoteTemplate(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		createTimeStartField = new DataSourceDateTimeField("createTimeStart", "创建时间");
		createTimeStartField.setRequired(false);
		createTimeStartField.setHidden(false);

		createTimeEndField = new DataSourceDateTimeField("createTimeEnd", "创建时间");
		createTimeEndField.setRequired(false);
		createTimeEndField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "公司id");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

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


		setFields(processTypeField, processStatusField, projectNameField, createTimeStartField, createTimeEndField, employeeIdField, operateEmployeeIdField, companyIdField, businessTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

