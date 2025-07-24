package com.pomplatform.client.projectStageTemplate.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectstagetemplateor extends DataSource
{


	public static CDSprojectstagetemplateor instance = null;

	public static CDSprojectstagetemplateor getInstance() {
		if(instance == null) {
			instance = new CDSprojectstagetemplateor("CDSprojectstagetemplateor");
		}
		return instance;
	}


	public CDSprojectstagetemplateor(String dataSourceID) {

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

