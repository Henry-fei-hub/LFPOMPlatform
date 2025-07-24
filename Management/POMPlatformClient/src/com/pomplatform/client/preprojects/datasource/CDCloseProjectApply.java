package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCloseProjectApply extends DataSource
{


	public static CDCloseProjectApply instance = null;

	public static CDCloseProjectApply getInstance() {
		if(instance == null) {
			instance = new CDCloseProjectApply("CDCloseProjectApply");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectIdField;

	public CDCloseProjectApply(String dataSourceID) {

		setID(dataSourceID);
		preProjectIdField = new DataSourceIntegerField("preProjectId", "主键编码");
		preProjectIdField.setRequired(true);
		preProjectIdField.setLength(11);
		preProjectIdField.setPrimaryKey(true);
		preProjectIdField.setHidden(true);

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


		setFields(preProjectIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

