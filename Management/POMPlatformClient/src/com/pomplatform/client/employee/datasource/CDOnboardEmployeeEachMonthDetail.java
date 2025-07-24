package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnboardEmployeeEachMonthDetail extends DataSource
{


	public static CDOnboardEmployeeEachMonthDetail instance = null;

	public static CDOnboardEmployeeEachMonthDetail getInstance() {
		if(instance == null) {
			instance = new CDOnboardEmployeeEachMonthDetail("CDOnboardEmployeeEachMonthDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public CDOnboardEmployeeEachMonthDetail(String dataSourceID) {

		setID(dataSourceID);
		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(true);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(true);
		monthField.setLength(11);
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

