package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDTeamMembers extends DataSource
{


	public static CDTeamMembers instance = null;

	public static CDTeamMembers getInstance() {
		if(instance == null) {
			instance = new CDTeamMembers("CDTeamMembers");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField employeeNameField;

	public CDTeamMembers(String dataSourceID) {

		setID(dataSourceID);
		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

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


		setFields(departmentIdField, employeeNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

