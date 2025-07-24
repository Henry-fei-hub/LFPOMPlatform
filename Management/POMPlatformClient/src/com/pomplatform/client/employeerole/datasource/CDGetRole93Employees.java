package com.pomplatform.client.employeerole.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGetRole93Employees extends DataSource
{


	public static CDGetRole93Employees instance = null;

	public static CDGetRole93Employees getInstance() {
		if(instance == null) {
			instance = new CDGetRole93Employees("CDGetRole93Employees");
		}
		return instance;
	}


	public CDGetRole93Employees(String dataSourceID) {

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

