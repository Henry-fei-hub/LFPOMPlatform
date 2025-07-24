package com.pomplatform.client.projectemployee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadApplyListOfProjectEmployees extends DataSource
{


	public static CDOnLoadApplyListOfProjectEmployees instance = null;

	public static CDOnLoadApplyListOfProjectEmployees getInstance() {
		if(instance == null) {
			instance = new CDOnLoadApplyListOfProjectEmployees("CDOnLoadApplyListOfProjectEmployees");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;

	public CDOnLoadApplyListOfProjectEmployees(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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


		setFields(employeeIdField, projectNameField, projectCodeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

