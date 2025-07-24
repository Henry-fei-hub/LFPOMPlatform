package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadFlowAuditListOfMainProjectBuisnessData extends DataSource
{


	public static CDOnLoadFlowAuditListOfMainProjectBuisnessData instance = null;

	public static CDOnLoadFlowAuditListOfMainProjectBuisnessData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadFlowAuditListOfMainProjectBuisnessData("CDOnLoadFlowAuditListOfMainProjectBuisnessData");
		}
		return instance;
	}

	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceTextField projectSalesTeamField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceBooleanField isOperationDepartmentField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceDateTimeField createTimeStartField;
	private final DataSourceDateTimeField createTimeEndField;

	public CDOnLoadFlowAuditListOfMainProjectBuisnessData(String dataSourceID) {

		setID(dataSourceID);
		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
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

		isOperationDepartmentField = new DataSourceBooleanField("isOperationDepartment", "是否运营组分配项目");
		isOperationDepartmentField.setRequired(false);
		isOperationDepartmentField.setHidden(false);

		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setHidden(false);

		createTimeStartField = new DataSourceDateTimeField("createTimeStart", "报备时间");
		createTimeStartField.setRequired(false);
		createTimeStartField.setHidden(false);

		createTimeEndField = new DataSourceDateTimeField("createTimeEnd", "报备时间");
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


		setFields(processStatusField, employeeIdField, statusField, processTypeField, projectNameField, projectTypeField, projectSalesTeamField, customerNameField, provinceField, cityField, projectOriginationField, isOperationDepartmentField, applyEmployeeIdField, createTimeStartField, createTimeEndField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

