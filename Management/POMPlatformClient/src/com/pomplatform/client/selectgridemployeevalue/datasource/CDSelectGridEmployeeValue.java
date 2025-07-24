package com.pomplatform.client.selectgridemployeevalue.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridEmployeeValue extends DataSource
{


	public static CDSelectGridEmployeeValue instance = null;

	public static CDSelectGridEmployeeValue getInstance() {
		if(instance == null) {
			instance = new CDSelectGridEmployeeValue("CDSelectGridEmployeeValue");
		}
		return instance;
	}

	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNameEnField;

	public CDSelectGridEmployeeValue(String dataSourceID) {

		setID(dataSourceID);
		statusField = new DataSourceIntegerField("status", "员工状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		roleIdField = new DataSourceIntegerField("roleId", "角色");
		roleIdField.setRequired(false);
		roleIdField.setLength(11);
		roleIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		employeeNameEnField = new DataSourceTextField("employeeNameEn", "英文名");
		employeeNameEnField.setRequired(false);
		employeeNameEnField.setLength(64);
		employeeNameEnField.setHidden(false);

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


		setFields(statusField, employeeIdField, employeeNoField, roleIdField, employeeNameField, employeeNameEnField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

