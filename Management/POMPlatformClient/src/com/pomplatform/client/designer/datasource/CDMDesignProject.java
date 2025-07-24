package com.pomplatform.client.designer.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDMDesignProject extends DataSource
{


	public static CDMDesignProject instance = null;

	public static CDMDesignProject getInstance() {
		if(instance == null) {
			instance = new CDMDesignProject("CDMDesignProject");
		}
		return instance;
	}

	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField projectIdField;

	public CDMDesignProject(String dataSourceID) {

		setID(dataSourceID);
		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setRequired(false);
		stageIdField.setLength(11);
		stageIdField.setHidden(false);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
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


		setFields(stageIdField, employeeIdField, projectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

