package com.pomplatform.client.projectStageStorage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectstagestoragepor extends DataSource
{


	public static CDSprojectstagestoragepor instance = null;

	public static CDSprojectstagestoragepor getInstance() {
		if(instance == null) {
			instance = new CDSprojectstagestoragepor("CDSprojectstagestoragepor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageStorageIdField;

	public CDSprojectstagestoragepor(String dataSourceID) {

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

