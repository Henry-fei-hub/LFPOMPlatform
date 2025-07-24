package com.pomplatform.client.calculateannualleave.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class CDTemporaryTime extends DataSource
{


	public static CDTemporaryTime instance = null;

	public static CDTemporaryTime getInstance() {
		if(instance == null) {
			instance = new CDTemporaryTime("CDTemporaryTime");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;

	public CDTemporaryTime(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "申请人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
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


		setFields(employeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

