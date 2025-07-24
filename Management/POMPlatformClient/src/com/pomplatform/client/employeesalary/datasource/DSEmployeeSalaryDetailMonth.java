package com.pomplatform.client.employeesalary.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeSalaryDetailMonth extends DBDataSource
{


	public static DSEmployeeSalaryDetailMonth instance = null;

	public static DSEmployeeSalaryDetailMonth getInstance() {
		if(instance == null) {
			instance = new DSEmployeeSalaryDetailMonth("DSEmployeeSalaryDetailMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField salaryYearField;
	private final DataSourceIntegerField salaryMonthField;
	private final DataSourceTextField basicSalaryField;

	public DSEmployeeSalaryDetailMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeSalaryDetailMonth");


		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		salaryYearField = new DataSourceIntegerField("salaryYear", "年份");
		salaryYearField.setLength(11);
		salaryYearField.setRequired(false);
		salaryYearField.setHidden(false);
		salaryYearField.setValueMap(KeyValueManager.getValueMap("employees"));


		salaryMonthField = new DataSourceIntegerField("salaryMonth", "月份");
		salaryMonthField.setLength(11);
		salaryMonthField.setRequired(false);
		salaryMonthField.setHidden(false);


		basicSalaryField = new DataSourceTextField("basicSalary", "基本工资");
		basicSalaryField.setLength(64);
		basicSalaryField.setRequired(false);
		basicSalaryField.setHidden(false);


		setFields(employeeIdField, salaryYearField, salaryMonthField, basicSalaryField);
	}


}

