package com.pomplatform.client.shift.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnCheckEmployeeShiftOfShift extends DBDataSource
{


	public static DSOnCheckEmployeeShiftOfShift instance = null;

	public static DSOnCheckEmployeeShiftOfShift getInstance() {
		if(instance == null) {
			instance = new DSOnCheckEmployeeShiftOfShift("DSOnCheckEmployeeShiftOfShift");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeShiftManageIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField shiftManageIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceDateField recordDateField;

	public DSOnCheckEmployeeShiftOfShift(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnCheckEmployeeShiftOfShift");

		employeeShiftManageIdField = new DataSourceIntegerField("employeeShiftManageId", "班次ID");
		employeeShiftManageIdField.setLength(11);
		employeeShiftManageIdField.setRequired(false);
		employeeShiftManageIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
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


		shiftManageIdField = new DataSourceIntegerField("shiftManageId", "班次");
		shiftManageIdField.setLength(11);
		shiftManageIdField.setRequired(false);
		shiftManageIdField.setHidden(false);
//		shiftManageIdField.setValueMap(KeyValueManager.getValueMap("shift_manages"));
		KeyValueManager.loadValueMap("shift_manages",shiftManageIdField);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "记录日期");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		setFields(employeeShiftManageIdField,employeeIdField, employeeNoField, employeeNameField, genderField, departmentIdField, shiftManageIdField, yearField, monthField, recordDateField);
	}


}

