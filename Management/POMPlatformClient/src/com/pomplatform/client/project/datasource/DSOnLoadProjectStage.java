package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadProjectStage extends DBDataSource
{


	public static DSOnLoadProjectStage instance = null;

	public static DSOnLoadProjectStage getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectStage("DSOnLoadProjectStage");
		}
		return instance;
	}

	private final DataSourceIntegerField stageIdField;

	public DSOnLoadProjectStage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectStage");


		stageIdField = new DataSourceIntegerField("stageId", "阶段id");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);


		setFields(stageIdField);
	}


}

