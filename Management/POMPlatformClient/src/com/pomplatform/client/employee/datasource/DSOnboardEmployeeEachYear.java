package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnboardEmployeeEachYear extends DBDataSource
{


	public static DSOnboardEmployeeEachYear instance = null;

	public static DSOnboardEmployeeEachYear getInstance() {
		if(instance == null) {
			instance = new DSOnboardEmployeeEachYear("DSOnboardEmployeeEachYear");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceIntegerField numField;

	public DSOnboardEmployeeEachYear(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnboardEmployeeEachYear");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		numField = new DataSourceIntegerField("num", "入职人数");
		numField.setLength(11);
		numField.setRequired(true);
		numField.setHidden(false);


		setFields(plateIdField, yearField, numField);
	}


}

