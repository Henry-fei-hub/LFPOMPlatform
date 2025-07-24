package com.pomplatform.client.salaryemployeeevaluationrmmor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSsalaryemployeeevaluationrmmor extends DataSource
{


	public static CDSsalaryemployeeevaluationrmmor instance = null;

	public static CDSsalaryemployeeevaluationrmmor getInstance() {
		if(instance == null) {
			instance = new CDSsalaryemployeeevaluationrmmor("CDSsalaryemployeeevaluationrmmor");
		}
		return instance;
	}

	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField minOperateTimeField;
	private final DataSourceDateTimeField maxOperateTimeField;
	private final DataSourceDateField minHappenDateField;
	private final DataSourceDateField maxHappenDateField;
	private final DataSourceIntegerField salaryEmployeeEvaluationIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceTextField gradeField;
	private final DataSourceIntegerField operateEmployeeIdField;

	public CDSsalaryemployeeevaluationrmmor(String dataSourceID) {

		setID(dataSourceID);
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		minOperateTimeField = new DataSourceDateTimeField("minOperateTime", "最早操作时间");
		minOperateTimeField.setRequired(false);
		minOperateTimeField.setHidden(false);

		maxOperateTimeField = new DataSourceDateTimeField("maxOperateTime", "最晚操作时间");
		maxOperateTimeField.setRequired(false);
		maxOperateTimeField.setHidden(false);

		minHappenDateField = new DataSourceDateField("minHappenDate", "最早绩效发生时间");
		minHappenDateField.setRequired(false);
		minHappenDateField.setHidden(false);

		maxHappenDateField = new DataSourceDateField("maxHappenDate", "最晚绩效发生时间");
		maxHappenDateField.setRequired(false);
		maxHappenDateField.setHidden(false);

		salaryEmployeeEvaluationIdField = new DataSourceIntegerField("salaryEmployeeEvaluationId", "salary_employee_evaluation_id");
		salaryEmployeeEvaluationIdField.setRequired(true);
		salaryEmployeeEvaluationIdField.setLength(11);
		salaryEmployeeEvaluationIdField.setPrimaryKey(true);
		salaryEmployeeEvaluationIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工主键");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setRequired(false);
		yearField.setLength(11);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setRequired(false);
		monthField.setLength(11);
		monthField.setHidden(false);

		gradeField = new DataSourceTextField("grade", "grade");
		gradeField.setRequired(false);
		gradeField.setLength(255);
		gradeField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

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


		setFields(remarkField, minOperateTimeField, maxOperateTimeField, minHappenDateField, maxHappenDateField, salaryEmployeeEvaluationIdField, employeeIdField, yearField, monthField, gradeField, operateEmployeeIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

