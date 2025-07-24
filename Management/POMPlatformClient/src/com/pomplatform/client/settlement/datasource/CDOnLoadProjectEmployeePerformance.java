package com.pomplatform.client.settlement.datasource;

import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDOnLoadProjectEmployeePerformance extends DataSource
{


	public static CDOnLoadProjectEmployeePerformance instance = null;

	public static CDOnLoadProjectEmployeePerformance getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProjectEmployeePerformance("CDOnLoadProjectEmployeePerformance");
		}
		return instance;
	}

	private final DataSourceIntegerField performanceFlagField;
	private final DataSourceIntegerField projectIdField;

	public CDOnLoadProjectEmployeePerformance(String dataSourceID) {

		setID(dataSourceID);
		performanceFlagField = new DataSourceIntegerField("performanceFlag", "2奖励");
		performanceFlagField.setRequired(false);
		performanceFlagField.setLength(11);
		performanceFlagField.setHidden(false);

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


		setFields(performanceFlagField, projectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

