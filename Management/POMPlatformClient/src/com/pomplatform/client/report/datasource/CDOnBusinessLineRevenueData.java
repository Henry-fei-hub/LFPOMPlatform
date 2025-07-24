package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnBusinessLineRevenueData extends DataSource
{


	public static CDOnBusinessLineRevenueData instance = null;

	public static CDOnBusinessLineRevenueData getInstance() {
		if(instance == null) {
			instance = new CDOnBusinessLineRevenueData("CDOnBusinessLineRevenueData");
		}
		return instance;
	}

	private final DataSourceDateTimeField startDateField;
	private final DataSourceDateTimeField endDateField;
	private final DataSourceIntegerField plateIdField;

	public CDOnBusinessLineRevenueData(String dataSourceID) {

		setID(dataSourceID);
		startDateField = new DataSourceDateTimeField("startDate", "开始日期");
		startDateField.setRequired(true);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateTimeField("endDate", "结束日期");
		endDateField.setRequired(true);
		endDateField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

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


		setFields(startDateField, endDateField, plateIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

