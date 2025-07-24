package com.pomplatform.client.totaltrainingmanagement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSTotalTrainingManagement extends DBDataSource
{


	public static DSTotalTrainingManagement instance = null;

	public static DSTotalTrainingManagement getInstance() {
		if(instance == null) {
			instance = new DSTotalTrainingManagement("DSTotalTrainingManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField numberField;

	public DSTotalTrainingManagement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("TotalTrainingManagement");


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		numberField = new DataSourceIntegerField("number", "培训次数");
		numberField.setLength(11);
		numberField.setRequired(true);
		numberField.setHidden(false);


		setFields(yearField, departmentIdField, numberField);
	}


}

