package com.pomplatform.client.projectprogress.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectprogrespppor extends DataSource
{


	public static CDSprojectprogrespppor instance = null;

	public static CDSprojectprogrespppor getInstance() {
		if(instance == null) {
			instance = new CDSprojectprogrespppor("CDSprojectprogrespppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectProgressIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField designPhaseField;

	public CDSprojectprogrespppor(String dataSourceID) {

		setID(dataSourceID);
		projectProgressIdField = new DataSourceIntegerField("projectProgressId", "项目进度编码");
		projectProgressIdField.setRequired(true);
		projectProgressIdField.setLength(11);
		projectProgressIdField.setPrimaryKey(true);
		projectProgressIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目负责人编码");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);

		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setRequired(false);
		designPhaseField.setLength(11);
		designPhaseField.setHidden(false);
		designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

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


		setFields(projectProgressIdField, projectIdField, projectManageIdField, designPhaseField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

