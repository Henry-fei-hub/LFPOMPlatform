package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectpricechangedrecordgroupor extends DataSource
{


	public static CDSprojectpricechangedrecordgroupor instance = null;

	public static CDSprojectpricechangedrecordgroupor getInstance() {
		if(instance == null) {
			instance = new CDSprojectpricechangedrecordgroupor("CDSprojectpricechangedrecordgroupor");
		}
		return instance;
	}


	public CDSprojectpricechangedrecordgroupor(String dataSourceID) {

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

