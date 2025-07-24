package com.pomplatform.client.sinvoiceorusecount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSinvoiceorusecount extends DataSource
{


	public static CDSinvoiceorusecount instance = null;

	public static CDSinvoiceorusecount getInstance() {
		if(instance == null) {
			instance = new CDSinvoiceorusecount("CDSinvoiceorusecount");
		}
		return instance;
	}


	public CDSinvoiceorusecount(String dataSourceID) {

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

