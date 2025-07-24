package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSelectGridEmployeeInDepartment extends DataSource
{


	public static CDSelectGridEmployeeInDepartment instance = null;

	public static CDSelectGridEmployeeInDepartment getInstance() {
		if(instance == null) {
			instance = new CDSelectGridEmployeeInDepartment("CDSelectGridEmployeeInDepartment");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceIntegerField employeeIdField;

	public CDSelectGridEmployeeInDepartment(String dataSourceID) {

		setID(dataSourceID);
		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		statusField = new DataSourceIntegerField("status", "4删除)");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		roleIdField = new DataSourceIntegerField("roleId", "角色");
		roleIdField.setRequired(false);
		roleIdField.setLength(11);
		roleIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(true);
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setHidden(true);
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


		setFields(departmentIdField, statusField, employeeNameField, roleIdField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

