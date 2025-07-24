package com.pomplatform.client.clocks.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeFaces extends DBDataSource
{


	public static DSEmployeeFaces instance = null;

	public static DSEmployeeFaces getInstance() {
		if(instance == null) {
			instance = new DSEmployeeFaces("DSemployeeFaces");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField snField;
	private final DataSourceTextField empCodeField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;

	public DSEmployeeFaces(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeFaces");



		employeeIdField = new DataSourceIntegerField("employeeId", "考勤编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		snField = new DataSourceTextField("sn", "设备序列号");
		snField.setLength(32);
		snField.setRequired(false);
		snField.setHidden(false);


		empCodeField = new DataSourceTextField("empCode", "考勤号码");
		empCodeField.setLength(64);
		empCodeField.setRequired(false);
		empCodeField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		setFields(employeeIdField,employeeNoField, employeeNameField, departmentIdField,plateIdField, snField, empCodeField);
	}


}

