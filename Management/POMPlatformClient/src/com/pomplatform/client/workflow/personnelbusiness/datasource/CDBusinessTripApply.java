package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDBusinessTripApply extends DataSource
{


	public static CDBusinessTripApply instance = null;

	public static CDBusinessTripApply getInstance() {
		if(instance == null) {
			instance = new CDBusinessTripApply("CDBusinessTripApply");
		}
		return instance;
	}


	public CDBusinessTripApply(String dataSourceID) {

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

