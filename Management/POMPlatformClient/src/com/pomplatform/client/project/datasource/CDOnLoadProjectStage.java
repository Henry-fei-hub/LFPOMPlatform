package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProjectStage extends DataSource
{


	public static CDOnLoadProjectStage instance = null;

	public static CDOnLoadProjectStage getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectStage("CDOnLoadProjectStage");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField checkEmployeeIdField;

	public CDOnLoadProjectStage(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		checkEmployeeIdField = new DataSourceIntegerField("checkEmployeeId", "审核人id");
		checkEmployeeIdField.setRequired(false);
		checkEmployeeIdField.setLength(11);
		checkEmployeeIdField.setHidden(false);

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


		setFields(projectIdField, checkEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

