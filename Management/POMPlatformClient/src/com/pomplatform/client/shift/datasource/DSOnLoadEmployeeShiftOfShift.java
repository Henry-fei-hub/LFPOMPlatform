package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadEmployeeShiftOfShift extends DBDataSource
{


	public static DSOnLoadEmployeeShiftOfShift instance = null;

	public static DSOnLoadEmployeeShiftOfShift getInstance() {
		if(instance == null) {
			instance = new DSOnLoadEmployeeShiftOfShift("DSOnLoadEmployeeShiftOfShift");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceBooleanField isShiftField;
	private final DataSourceIntegerField countField;

	public DSOnLoadEmployeeShiftOfShift(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadEmployeeShiftOfShift");


		employeeIdField = new DataSourceIntegerField("employeeId", "职员编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setLength(11);
		genderField.setRequired(false);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		isShiftField = new DataSourceBooleanField("isShift", "本月是否排班");
		isShiftField.setRequired(true);
		isShiftField.setHidden(false);


		countField = new DataSourceIntegerField("count", "数目");
		countField.setLength(11);
		countField.setRequired(true);
		countField.setHidden(true);


		setFields(employeeIdField, employeeNoField, employeeNameField, genderField, departmentIdField, yearField, monthField, isShiftField, countField);
	}


}

