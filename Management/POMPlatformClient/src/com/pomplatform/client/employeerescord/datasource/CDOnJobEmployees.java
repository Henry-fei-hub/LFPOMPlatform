package com.pomplatform.client.employeerescord.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnJobEmployees extends DataSource
{


	public static CDOnJobEmployees instance = null;

	public static CDOnJobEmployees getInstance() {
		if(instance == null) {
			instance = new CDOnJobEmployees("CDOnJobEmployees");
		}
		return instance;
	}


	public CDOnJobEmployees(String dataSourceID) {

		setID(dataSourceID);
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


		setFields(currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

