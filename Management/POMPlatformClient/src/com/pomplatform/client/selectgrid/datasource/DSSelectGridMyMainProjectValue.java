package com.pomplatform.client.selectgrid.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSelectGridMyMainProjectValue extends DBDataSource
{


	public static DSSelectGridMyMainProjectValue instance = null;

	public static DSSelectGridMyMainProjectValue getInstance() {
		if(instance == null) {
			instance = new DSSelectGridMyMainProjectValue("DSSelectGridMyMainProjectValue");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;

	public DSSelectGridMyMainProjectValue(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SelectGridMyMainProjectValue");


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		setFields(mainProjectIdField, projectCodeField, projectNameField);
	}


}

