package com.pomplatform.client.revenue.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDcontractSaveAnalyze extends DataSource
{


	public static CDcontractSaveAnalyze instance = null;

	public static CDcontractSaveAnalyze getInstance() {
		if(instance == null) {
			instance = new CDcontractSaveAnalyze("CDcontractSaveAnalyze");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;

	public CDcontractSaveAnalyze(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);

		plateIdField = new DataSourceIntegerField("plateId", "统计营收板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

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


		setFields(projectIdField, plateIdField, yearField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

