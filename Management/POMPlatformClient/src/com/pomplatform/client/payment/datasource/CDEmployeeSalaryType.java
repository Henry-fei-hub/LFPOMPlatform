package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDEmployeeSalaryType extends DataSource
{


	public static CDEmployeeSalaryType instance = null;

	public static CDEmployeeSalaryType getInstance() {
		if(instance == null) {
			instance = new CDEmployeeSalaryType("CDEmployeeSalaryType");
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

	public CDEmployeeSalaryType(String dataSourceID) {

		setID(dataSourceID);
		employeeSalaryTypeIdField = new DataSourceIntegerField("employeeSalaryTypeId", "员工工资发放类型表主键");
		employeeSalaryTypeIdField.setRequired(true);
		employeeSalaryTypeIdField.setLength(11);
		employeeSalaryTypeIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(false);
		employeeNameField.setLength(255);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("departments"));

		employeeNoField = new DataSourceTextField("employeeNo", "员工工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(32);
		employeeNoField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		salaryTypeField = new DataSourceIntegerField("salaryType", "类型（1.募投项目 2.研发项目）");
		salaryTypeField.setRequired(false);
		salaryTypeField.setLength(11);
		salaryTypeField.setHidden(false);

		fundraisingProjectTypeField = new DataSourceIntegerField("fundraisingProjectType", "募投项目类型");
		fundraisingProjectTypeField.setRequired(false);
		fundraisingProjectTypeField.setLength(11);
		fundraisingProjectTypeField.setHidden(false);

		fundraisingProjectRateField = new DataSourceFloatField("fundraisingProjectRate", "募投比例");
		fundraisingProjectRateField.setRequired(true);
		fundraisingProjectRateField.setLength(32);
		fundraisingProjectRateField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(employeeSalaryTypeIdField, employeeIdField, employeeNameField, employeeNoField, plateIdField, yearField, monthField, salaryTypeField, fundraisingProjectTypeField, fundraisingProjectRateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

