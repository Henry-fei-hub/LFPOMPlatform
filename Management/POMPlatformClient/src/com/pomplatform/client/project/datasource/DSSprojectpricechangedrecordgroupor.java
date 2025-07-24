package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectpricechangedrecordgroupor extends DBDataSource
{


	public static DSSprojectpricechangedrecordgroupor instance = null;

	public static DSSprojectpricechangedrecordgroupor getInstance() {
		if(instance == null) {
			instance = new DSSprojectpricechangedrecordgroupor("DSSprojectpricechangedrecordgroupor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;

	public DSSprojectpricechangedrecordgroupor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectpricechangedrecordgroupor");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);


		setFields(projectIdField);
	}


}

