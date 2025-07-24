package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDCapitalDistributionAnalyze extends DataSource
{


	public static CDCapitalDistributionAnalyze instance = null;

	public static CDCapitalDistributionAnalyze getInstance() {
		if(instance == null) {
			instance = new CDCapitalDistributionAnalyze("CDCapitalDistributionAnalyze");
		}
		return instance;
	}

	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;

	public CDCapitalDistributionAnalyze(String dataSourceID) {

		setID(dataSourceID);

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

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


		setFields(startDateField, endDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

