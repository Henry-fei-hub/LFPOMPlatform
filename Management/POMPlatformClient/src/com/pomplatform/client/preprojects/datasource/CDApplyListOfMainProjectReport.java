package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDApplyListOfMainProjectReport extends DataSource
{


	public static CDApplyListOfMainProjectReport instance = null;

	public static CDApplyListOfMainProjectReport getInstance() {
		if(instance == null) {
			instance = new CDApplyListOfMainProjectReport("CDApplyListOfMainProjectReport");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceBooleanField isOperationDepartmentField;
	private final DataSourceDateTimeField createTimeStartField;
	private final DataSourceDateTimeField createTimeEndField;

	public CDApplyListOfMainProjectReport(String dataSourceID) {

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

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setRequired(false);
		processStatusField.setLength(11);
		processStatusField.setHidden(false);

		projectSalesTeamField = new DataSourceTextField("projectSalesTeam", "项目营销团队");
		projectSalesTeamField.setRequired(false);
		projectSalesTeamField.setLength(32);
		projectSalesTeamField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(50);
		customerNameField.setHidden(false);

		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setRequired(false);
		provinceField.setLength(32);
		provinceField.setHidden(false);

		cityField = new DataSourceTextField("city", "城市");
		cityField.setRequired(false);
		cityField.setLength(32);
		cityField.setHidden(false);

		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setRequired(false);
		projectOriginationField.setLength(512);
		projectOriginationField.setHidden(false);

		isOperationDepartmentField = new DataSourceBooleanField("isOperationDepartment", "undefined");
		isOperationDepartmentField.setRequired(true);
		isOperationDepartmentField.setHidden(false);

		createTimeStartField = new DataSourceDateTimeField("createTimeStart", "创建时间");
		createTimeStartField.setRequired(false);
		createTimeStartField.setHidden(false);

		createTimeEndField = new DataSourceDateTimeField("createTimeEnd", "创建时间");
		createTimeEndField.setRequired(false);
		createTimeEndField.setHidden(false);

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


		setFields(processTypeField, projectNameField, projectTypeField, startDateField, endDateField, employeeIdField, processStatusField, projectSalesTeamField, customerNameField, provinceField, cityField, projectOriginationField, isOperationDepartmentField, createTimeStartField, createTimeEndField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

