package com.pomplatform.client.sureintegrl.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMprojectEmployeeSureIntegrl extends DataSource
{


	public static CDMprojectEmployeeSureIntegrl instance = null;

	public static CDMprojectEmployeeSureIntegrl getInstance() {
		if(instance == null) {
			instance = new CDMprojectEmployeeSureIntegrl("CDMprojectEmployeeSureIntegrl");
		}
		return instance;
	}

	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField projectIdField;

	public CDMprojectEmployeeSureIntegrl(String dataSourceID) {

		setID(dataSourceID);
		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setRequired(false);
		stageIdField.setLength(11);
		stageIdField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);
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


		setFields(stageIdField, projectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

