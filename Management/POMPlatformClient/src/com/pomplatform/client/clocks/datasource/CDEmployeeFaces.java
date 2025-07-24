package com.pomplatform.client.clocks.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeFaces extends DataSource
{


	public static CDEmployeeFaces instance = null;

	public static CDEmployeeFaces getInstance() {
		if(instance == null) {
			instance = new CDEmployeeFaces("CDemployeeFaces");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField departmentIdField;

	public CDEmployeeFaces(String dataSourceID) {

		setID(dataSourceID);
		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(new java.util.HashMap());

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


		setFields(employeeNoField, employeeIdField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

