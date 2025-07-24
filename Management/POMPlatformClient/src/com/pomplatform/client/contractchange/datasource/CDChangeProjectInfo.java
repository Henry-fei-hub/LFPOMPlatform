package com.pomplatform.client.contractchange.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDChangeProjectInfo extends DataSource
{


	public static CDChangeProjectInfo instance = null;

	public static CDChangeProjectInfo getInstance() {
		if(instance == null) {
			instance = new CDChangeProjectInfo("CDChangeProjectInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField flagField;

	public CDChangeProjectInfo(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);

		flagField = new DataSourceIntegerField("flag", "状态");
		flagField.setRequired(false);
		flagField.setLength(11);
		flagField.setHidden(false);

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


		setFields(projectIdField, flagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

