package com.pomplatform.client.projectteambuild.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDProjectEmployeePlanIntegralProgress extends DataSource
{


	public static CDProjectEmployeePlanIntegralProgress instance = null;

	public static CDProjectEmployeePlanIntegralProgress getInstance() {
		if(instance == null) {
			instance = new CDProjectEmployeePlanIntegralProgress("CDProjectEmployeePlanIntegralProgress");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public CDProjectEmployeePlanIntegralProgress(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);

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


		setFields(projectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

