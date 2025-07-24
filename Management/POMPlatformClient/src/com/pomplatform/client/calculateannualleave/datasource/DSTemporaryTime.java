package com.pomplatform.client.calculateannualleave.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSTemporaryTime extends DBDataSource
{


	public static DSTemporaryTime instance = null;

	public static DSTemporaryTime getInstance() {
		if(instance == null) {
			instance = new DSTemporaryTime("DSTemporaryTime");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField departmentNameField;
	private final DataSourceFloatField hoursField;

	public DSTemporaryTime(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("TemporaryTime");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		KeyValueManager.loadValueMap("employees" , employeeIdField);


		employeeNoField = new DataSourceTextField("employeeNo", "员工工号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentNameField = new DataSourceTextField("departmentName", "部门名称");
		departmentNameField.setLength(64);
		departmentNameField.setRequired(true);
		departmentNameField.setHidden(false);


		hoursField = new DataSourceFloatField("hours", "剩余调休数(小时)");
		hoursField.setLength(3);
		hoursField.setDecimalPad(1);
		hoursField.setFormat("##.0");
		hoursField.setRequired(false);
		hoursField.setHidden(false);


		setFields(employeeIdField, employeeNoField, departmentNameField, hoursField);
	}


}

