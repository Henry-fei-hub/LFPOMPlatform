package com.pomplatform.client.platecostrecord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDPlateCostMonthlyDetail extends DataSource
{


	public static CDPlateCostMonthlyDetail instance = null;

	public static CDPlateCostMonthlyDetail getInstance() {
		if(instance == null) {
			instance = new CDPlateCostMonthlyDetail("CDPlateCostMonthlyDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateField yearField;
	private final DataSourceDateField monthField;

	public CDPlateCostMonthlyDetail(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		yearField = new DataSourceDateField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceDateField("month", "月份");
		monthField.setRequired(false);
		monthField.setHidden(false);

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


		setFields(plateIdField, yearField, monthField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

