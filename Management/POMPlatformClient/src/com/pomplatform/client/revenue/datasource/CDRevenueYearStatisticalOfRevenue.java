package com.pomplatform.client.revenue.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRevenueYearStatisticalOfRevenue extends DataSource
{


	public static CDRevenueYearStatisticalOfRevenue instance = null;

	public static CDRevenueYearStatisticalOfRevenue getInstance() {
		if(instance == null) {
			instance = new CDRevenueYearStatisticalOfRevenue("CDRevenueYearStatisticalOfRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField yearField;

	public CDRevenueYearStatisticalOfRevenue(String dataSourceID) {

		setID(dataSourceID);
		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);

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


		setFields(projectIdField, yearField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

