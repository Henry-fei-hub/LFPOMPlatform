package com.pomplatform.client.salaryemployeeevaluationrmmor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSsalaryemployeeperformancemmeor extends DataSource
{


	public static CDSsalaryemployeeperformancemmeor instance = null;

	public static CDSsalaryemployeeperformancemmeor getInstance() {
		if(instance == null) {
			instance = new CDSsalaryemployeeperformancemmeor("CDSsalaryemployeeperformancemmeor");
		}
		return instance;
	}

	private final DataSourceDateField minHappenDateField;
	private final DataSourceDateField maxHappenDateField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField salaryEmployeePerformanceIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField shouldDaysField;
	private final DataSourceFloatField factDaysField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceTextField gradeField;
	private final DataSourceFloatField proportionField;
	private final DataSourceFloatField workingCoefficientField;
	private final DataSourceFloatField actualPerformancePayField;

	public CDSsalaryemployeeperformancemmeor(String dataSourceID) {

		setID(dataSourceID);
		minHappenDateField = new DataSourceDateField("minHappenDate", "最早发生日期");
		minHappenDateField.setRequired(false);
		minHappenDateField.setHidden(false);

		maxHappenDateField = new DataSourceDateField("maxHappenDate", "最晚发生日期");
		maxHappenDateField.setRequired(false);
		maxHappenDateField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setRequired(false);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		salaryEmployeePerformanceIdField = new DataSourceIntegerField("salaryEmployeePerformanceId", "主键");
		salaryEmployeePerformanceIdField.setRequired(true);
		salaryEmployeePerformanceIdField.setLength(11);
		salaryEmployeePerformanceIdField.setPrimaryKey(true);
		salaryEmployeePerformanceIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工主键");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门编码");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		statusField = new DataSourceIntegerField("status", "员工状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		shouldDaysField = new DataSourceFloatField("shouldDays", "应到天数");
		shouldDaysField.setRequired(true);
		shouldDaysField.setLength(18);
		shouldDaysField.setHidden(false);

		factDaysField = new DataSourceFloatField("factDays", "实到天数");
		factDaysField.setRequired(true);
		factDaysField.setLength(18);
		factDaysField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		gradeField = new DataSourceTextField("grade", "等级");
		gradeField.setRequired(false);
		gradeField.setLength(255);
		gradeField.setHidden(false);

		proportionField = new DataSourceFloatField("proportion", "比例");
		proportionField.setRequired(true);
		proportionField.setLength(18);
		proportionField.setHidden(false);

		workingCoefficientField = new DataSourceFloatField("workingCoefficient", "工作系数");
		workingCoefficientField.setRequired(true);
		workingCoefficientField.setLength(18);
		workingCoefficientField.setHidden(false);

		actualPerformancePayField = new DataSourceFloatField("actualPerformancePay", "实发绩效");
		actualPerformancePayField.setRequired(true);
		actualPerformancePayField.setLength(18);
		actualPerformancePayField.setHidden(false);

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


		setFields(minHappenDateField, maxHappenDateField, employeeNoField, salaryEmployeePerformanceIdField, employeeIdField, plateIdField, departmentIdField, companyIdField, statusField, shouldDaysField, factDaysField, yearField, monthField, gradeField, proportionField, workingCoefficientField, actualPerformancePayField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

