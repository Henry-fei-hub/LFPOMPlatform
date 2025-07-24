package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSDepDeployDataSource extends DBDataSource
{


	public static DSDepDeployDataSource instance = null;

	public static DSDepDeployDataSource getInstance() {
		if(instance == null) {
			instance = new DSDepDeployDataSource("DSDepDeployDataSource");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceFloatField advanceIntegralField;

	public DSDepDeployDataSource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("Employee");


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

		advanceIntegralField = new DataSourceFloatField("advanceIntegral", "分配积分");
		advanceIntegralField.setLength(18);
		advanceIntegralField.setDecimalPad(2);
		advanceIntegralField.setFormat("#,###,###,###,###,##0.00");
		advanceIntegralField.setRequired(false);
		advanceIntegralField.setHidden(false);

		setFields(employeeIdField, employeeNoField, employeeNameField, genderField, departmentIdField,advanceIntegralField);
	}


}

