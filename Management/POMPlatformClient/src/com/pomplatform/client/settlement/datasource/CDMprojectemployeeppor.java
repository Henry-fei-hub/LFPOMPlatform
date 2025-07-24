package com.pomplatform.client.settlement.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDMprojectemployeeppor extends DataSource
{


	public static CDMprojectemployeeppor instance = null;

	public static CDMprojectemployeeppor getInstance() {
		if(instance == null) {
			instance = new CDMprojectemployeeppor("CDMprojectemployeeppor");
		}
		return instance;
	}

	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField projectIdField;

	public CDMprojectemployeeppor(String dataSourceID) {

		setID(dataSourceID);
		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setRequired(false);
		stageIdField.setLength(11);
		stageIdField.setHidden(false);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);

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

