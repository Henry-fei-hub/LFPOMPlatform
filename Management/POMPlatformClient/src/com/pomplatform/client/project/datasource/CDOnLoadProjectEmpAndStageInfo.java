package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProjectEmpAndStageInfo extends DataSource
{


	public static CDOnLoadProjectEmpAndStageInfo instance = null;

	public static CDOnLoadProjectEmpAndStageInfo getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectEmpAndStageInfo("CDOnLoadProjectEmpAndStageInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public CDOnLoadProjectEmpAndStageInfo(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

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

