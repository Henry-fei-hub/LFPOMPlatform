package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDPositiveEmployeeInfo extends DataSource
{


	public static CDPositiveEmployeeInfo instance = null;

	public static CDPositiveEmployeeInfo getInstance() {
		if(instance == null) {
			instance = new CDPositiveEmployeeInfo("CDPositiveEmployeeInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField employeeIdField;

	public CDPositiveEmployeeInfo(String dataSourceID) {

		setID(dataSourceID);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		
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


		setFields(yearField, monthField, employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

