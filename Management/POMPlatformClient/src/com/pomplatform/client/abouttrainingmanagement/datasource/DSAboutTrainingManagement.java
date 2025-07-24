package com.pomplatform.client.abouttrainingmanagement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAboutTrainingManagement extends DBDataSource
{


	public static DSAboutTrainingManagement instance = null;

	public static DSAboutTrainingManagement getInstance() {
		if(instance == null) {
			instance = new DSAboutTrainingManagement("DSAboutTrainingManagement");
		}
		return instance;
	}

	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField numberField;

	public DSAboutTrainingManagement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AboutTrainingManagement");


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(true);
		monthField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		numberField = new DataSourceIntegerField("number", "培训次数");
		numberField.setLength(11);
		numberField.setRequired(true);
		numberField.setHidden(false);


		setFields(yearField, monthField, departmentIdField, numberField);
	}


}

