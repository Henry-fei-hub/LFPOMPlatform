package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnboardEmployeeEachMonth extends DBDataSource
{


	public static DSOnboardEmployeeEachMonth instance = null;

	public static DSOnboardEmployeeEachMonth getInstance() {
		if(instance == null) {
			instance = new DSOnboardEmployeeEachMonth("DSOnboardEmployeeEachMonth");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceIntegerField numField;

	public DSOnboardEmployeeEachMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnboardEmployeeEachMonth");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		
		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(true);
		monthField.setHidden(false);


		numField = new DataSourceIntegerField("num", "入职人数");
		numField.setLength(11);
		numField.setRequired(true);
		numField.setHidden(false);


		setFields(plateIdField,departmentIdField, yearField, monthField, numField);
	}


}

