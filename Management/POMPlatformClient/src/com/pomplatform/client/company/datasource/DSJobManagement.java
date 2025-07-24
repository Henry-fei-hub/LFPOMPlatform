package com.pomplatform.client.company.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSJobManagement extends DBDataSource
{


	public static DSJobManagement instance = null;

	public static DSJobManagement getInstance() {
		if(instance == null) {
			instance = new DSJobManagement("DSJobManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField dutyIdField;
	private final DataSourceTextField dutyNameField;

	public DSJobManagement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("JobManagement");


		dutyIdField = new DataSourceIntegerField("dutyId", "职位");
		dutyIdField.setLength(11);
		dutyIdField.setPrimaryKey(true);
		dutyIdField.setRequired(true);
		dutyIdField.setHidden(true);


		dutyNameField = new DataSourceTextField("dutyName", "职位名称");
		dutyNameField.setLength(128);
		dutyNameField.setRequired(false);
		dutyNameField.setHidden(false);


		setFields(dutyIdField, dutyNameField);
	}


}

