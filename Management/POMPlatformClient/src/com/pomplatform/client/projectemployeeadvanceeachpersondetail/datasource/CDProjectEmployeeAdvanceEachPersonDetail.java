package com.pomplatform.client.projectemployeeadvanceeachpersondetail.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectEmployeeAdvanceEachPersonDetail extends DataSource
{


	public static CDProjectEmployeeAdvanceEachPersonDetail instance = null;

	public static CDProjectEmployeeAdvanceEachPersonDetail getInstance() {
		if(instance == null) {
			instance = new CDProjectEmployeeAdvanceEachPersonDetail("CDProjectEmployeeAdvanceEachPersonDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;

	public CDProjectEmployeeAdvanceEachPersonDetail(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "补贴项目");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);

		employeeIdField = new DataSourceIntegerField("employeeId", "补贴成员");
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


		setFields(projectIdField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

