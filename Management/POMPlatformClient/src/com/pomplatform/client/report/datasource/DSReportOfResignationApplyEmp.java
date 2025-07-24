package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOfResignationApplyEmp extends DBDataSource
{


	public static DSReportOfResignationApplyEmp instance = null;

	public static DSReportOfResignationApplyEmp getInstance() {
		if(instance == null) {
			instance = new DSReportOfResignationApplyEmp("DSReportOfResignationApplyEmp");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField endDateField;
	private final DataSourceTextField transportationField;
	private final DataSourceIntegerField targetProvinceField;
	private final DataSourceTextField unitField;

	public DSReportOfResignationApplyEmp(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOfResignationApplyEmp");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setLength(11);
		genderField.setRequired(false);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		endDateField = new DataSourceDateField("endDate", "考勤截止时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		transportationField = new DataSourceTextField("transportation", "离职考勤");
		transportationField.setLength(255);
		transportationField.setRequired(false);
		transportationField.setHidden(false);


		targetProvinceField = new DataSourceIntegerField("targetProvince", "离职绩效");
		targetProvinceField.setLength(11);
		targetProvinceField.setRequired(false);
		targetProvinceField.setHidden(false);
		targetProvinceField.setValueMap(KeyValueManager.getValueMap("system_dictionary_99"));


		unitField = new DataSourceTextField("unit", "社保/公积金停缴月");
		unitField.setLength(255);
		unitField.setRequired(false);
		unitField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, genderField, departmentIdField, endDateField, transportationField, targetProvinceField, unitField);
	}


}

