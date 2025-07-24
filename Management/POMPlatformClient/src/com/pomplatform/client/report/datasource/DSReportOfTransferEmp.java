package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOfTransferEmp extends DBDataSource
{


	public static DSReportOfTransferEmp instance = null;

	public static DSReportOfTransferEmp getInstance() {
		if(instance == null) {
			instance = new DSReportOfTransferEmp("DSReportOfTransferEmp");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField oldPlateIdField;
	private final DataSourceIntegerField oldDepartmentIdField;
	private final DataSourceIntegerField newPlateIdField;
	private final DataSourceIntegerField newDepartmentIdField;
	private final DataSourceDateField endDateField;

	public DSReportOfTransferEmp(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOfTransferEmp");


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


		oldPlateIdField = new DataSourceIntegerField("oldPlateId", "业务部门");
		oldPlateIdField.setLength(11);
		oldPlateIdField.setRequired(true);
		oldPlateIdField.setHidden(false);
		oldPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		oldDepartmentIdField = new DataSourceIntegerField("oldDepartmentId", "所属部门");
		oldDepartmentIdField.setLength(11);
		oldDepartmentIdField.setRequired(true);
		oldDepartmentIdField.setHidden(false);
		oldDepartmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		newPlateIdField = new DataSourceIntegerField("newPlateId", "业务部门");
		newPlateIdField.setLength(11);
		newPlateIdField.setRequired(true);
		newPlateIdField.setHidden(false);
		newPlateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		newDepartmentIdField = new DataSourceIntegerField("newDepartmentId", "所属部门");
		newDepartmentIdField.setLength(11);
		newDepartmentIdField.setRequired(true);
		newDepartmentIdField.setHidden(false);
		newDepartmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		endDateField = new DataSourceDateField("endDate", "生效时间");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		setFields(employeeIdField, employeeNoField, employeeNameField, genderField, oldPlateIdField, oldDepartmentIdField, newPlateIdField, newDepartmentIdField, endDateField);
	}


}

