package com.pomplatform.client.projectemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadAuditListOfProjectEmployees extends DataSource
{


	public static CDOnLoadAuditListOfProjectEmployees instance = null;

	public static CDOnLoadAuditListOfProjectEmployees getInstance() {
		if(instance == null) {
			instance = new CDOnLoadAuditListOfProjectEmployees("CDOnLoadAuditListOfProjectEmployees");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;

	public CDOnLoadAuditListOfProjectEmployees(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "处理人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(255);
		projectNameField.setHidden(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(255);
		projectCodeField.setHidden(false);

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


		setFields(statusField, employeeIdField, employeeNameField, employeeNoField, projectNameField, projectCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

