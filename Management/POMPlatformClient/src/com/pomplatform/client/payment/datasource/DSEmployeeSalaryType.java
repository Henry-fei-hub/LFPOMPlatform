package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

import java.util.LinkedHashMap;

public class DSEmployeeSalaryType extends DBDataSource
{


	public static DSEmployeeSalaryType instance = null;

	public static DSEmployeeSalaryType getInstance() {
		if(instance == null) {
			instance = new DSEmployeeSalaryType("DSEmployeeSalaryType");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeSalaryTypeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField salaryTypeField;
	private final DataSourceIntegerField fundraisingProjectTypeField;
	private final DataSourceFloatField fundraisingProjectRateField;

	public DSEmployeeSalaryType(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeSalaryType");

		employeeSalaryTypeIdField = new DataSourceIntegerField("employeeSalaryTypeId", "员工工资发放类型表主键");
		employeeSalaryTypeIdField.setLength(11);
		employeeSalaryTypeIdField.setRequired(true);
		employeeSalaryTypeIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(255);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(32);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		salaryTypeField = new DataSourceIntegerField("salaryType", "类型");
		salaryTypeField.setLength(11);
		salaryTypeField.setRequired(false);
		salaryTypeField.setHidden(false);
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "募投项目");
		map.put(2, "研发项目");
		salaryTypeField.setValueMap(KeyValueManager.getValueMap("map"));


		fundraisingProjectTypeField = new DataSourceIntegerField("fundraisingProjectType", "募投项目类型");
		fundraisingProjectTypeField.setLength(11);
		fundraisingProjectTypeField.setRequired(false);
		fundraisingProjectTypeField.setHidden(false);
		fundraisingProjectTypeField.setValueMap(KeyValueManager.getValueMap("fundraising_project_types"));


		fundraisingProjectRateField = new DataSourceFloatField("fundraisingProjectRate", "募投比例");
		fundraisingProjectRateField.setLength(32);
		fundraisingProjectRateField.setDecimalPad(2);
		fundraisingProjectRateField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		fundraisingProjectRateField.setRequired(false);
		fundraisingProjectRateField.setHidden(false);


		setFields(employeeSalaryTypeIdField, employeeIdField, employeeNameField, employeeNoField, plateIdField, yearField, monthField, salaryTypeField, fundraisingProjectTypeField, fundraisingProjectRateField);
	}


}

