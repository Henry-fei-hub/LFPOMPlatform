package com.pomplatform.client.shift.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadEmployeeShiftDetailOfShift extends DBDataSource
{


	public static DSOnLoadEmployeeShiftDetailOfShift instance = null;

	public static DSOnLoadEmployeeShiftDetailOfShift getInstance() {
		if(instance == null) {
			instance = new DSOnLoadEmployeeShiftDetailOfShift("DSOnLoadEmployeeShiftDetailOfShift");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceBooleanField isShiftField;
	private final DataSourceIntegerField countField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;

	public DSOnLoadEmployeeShiftDetailOfShift(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadEmployeeShiftDetailOfShift");


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


		isShiftField = new DataSourceBooleanField("isShift", "是否排班");
		isShiftField.setRequired(true);
		isShiftField.setHidden(false);


		countField = new DataSourceIntegerField("count", "");
		countField.setLength(8);
		countField.setRequired(true);
		countField.setHidden(true);
		
		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setLength(64);
		startDateField.setRequired(true);
		startDateField.setHidden(true);
		
		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setLength(64);
		endDateField.setRequired(true);
		endDateField.setHidden(true);


		setFields(employeeIdField, employeeNoField, employeeNameField, genderField, departmentIdField, isShiftField, countField,startDateField,endDateField);
	}


}

