package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProjectStageSettlement2 extends DataSource
{


	public static CDOnLoadProjectStageSettlement2 instance = null;

	public static CDOnLoadProjectStageSettlement2 getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectStageSettlement2("CDOnLoadProjectStageSettlement2");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField checkEmployeeIdField;

	public CDOnLoadProjectStageSettlement2(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		stageIdField = new DataSourceIntegerField("stageId", "阶段代码");
		stageIdField.setRequired(false);
		stageIdField.setLength(11);
		stageIdField.setHidden(false);

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


		setFields(projectIdField, stageIdField, checkEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

