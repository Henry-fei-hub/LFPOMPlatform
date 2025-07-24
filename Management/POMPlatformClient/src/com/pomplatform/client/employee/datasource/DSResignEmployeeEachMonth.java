package com.pomplatform.client.employee.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSResignEmployeeEachMonth extends DBDataSource
{


	public static DSResignEmployeeEachMonth instance = null;

	public static DSResignEmployeeEachMonth getInstance() {
		if(instance == null) {
			instance = new DSResignEmployeeEachMonth("DSResignEmployeeEachMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField amountField;

	public DSResignEmployeeEachMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ResignEmployeeEachMonth");


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(true);
		monthField.setHidden(false);


		amountField = new DataSourceIntegerField("amount", "离职人数");
		amountField.setLength(8);
		amountField.setRequired(true);
		amountField.setHidden(false);


		setFields(departmentIdField, yearField, monthField, amountField);
	}


}

