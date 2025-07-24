package com.pomplatform.client.projectStageStorage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectstagestorageor extends DataSource
{


	public static CDSprojectstagestorageor instance = null;

	public static CDSprojectstagestorageor getInstance() {
		if(instance == null) {
			instance = new CDSprojectstagestorageor("CDSprojectstagestorageor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageStorageIdField;

	public CDSprojectstagestorageor(String dataSourceID) {

		setID(dataSourceID);
		projectStageStorageIdField = new DataSourceIntegerField("projectStageStorageId", "id");
		projectStageStorageIdField.setRequired(true);
		projectStageStorageIdField.setLength(11);
		projectStageStorageIdField.setPrimaryKey(true);
		projectStageStorageIdField.setHidden(true);

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


		setFields(projectStageStorageIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

