package com.pomplatform.client.salary.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSalaryOfWorkYearsUpdate extends DBDataSource
{


	public static DSSalaryOfWorkYearsUpdate instance = null;

	public static DSSalaryOfWorkYearsUpdate getInstance() {
		if(instance == null) {
			instance = new DSSalaryOfWorkYearsUpdate("DSSalaryOfWorkYearsUpdate");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceTextField workMoneyField;

	public DSSalaryOfWorkYearsUpdate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SalaryOfWorkYear");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
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


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(64);
		yearField.setRequired(true);
		yearField.setHidden(false);
		
		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(64);
		monthField.setRequired(true);
		monthField.setHidden(false);
		
		workMoneyField = new DataSourceTextField("workMoney", "工龄工资");
		workMoneyField.setLength(64);
		workMoneyField.setRequired(true);
		workMoneyField.setHidden(false);

		setFields(employeeIdField, employeeNoField, employeeNameField,yearField,monthField,workMoneyField);
	}


}

