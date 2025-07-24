package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProjectEmpAndStage extends DataSource
{


	public static CDOnLoadProjectEmpAndStage instance = null;

	public static CDOnLoadProjectEmpAndStage getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectEmpAndStage("CDOnLoadProjectEmpAndStage");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField employeeIdField;

	public CDOnLoadProjectEmpAndStage(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "被审核人id");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

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

