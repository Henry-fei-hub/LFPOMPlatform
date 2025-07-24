package com.pomplatform.client.salaryemployeeevaluationrmmor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSsalaryemployeeevaluationrmmor extends DBDataSource {

	public static DSSsalaryemployeeevaluationrmmor instance = null;

	public static DSSsalaryemployeeevaluationrmmor getInstance() {
		if (instance == null) {
			instance = new DSSsalaryemployeeevaluationrmmor("DSSsalaryemployeeevaluationrmmor");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryEmployeeEvaluationIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceTextField gradeField;
	private final DataSourceDateField happenDateField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;

	public DSSsalaryemployeeevaluationrmmor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Ssalaryemployeeevaluationrmmor");

		salaryEmployeeEvaluationIdField = new DataSourceIntegerField("salaryEmployeeEvaluationId", "主键");
		salaryEmployeeEvaluationIdField.setLength(11);
		salaryEmployeeEvaluationIdField.setPrimaryKey(true);
		salaryEmployeeEvaluationIdField.setRequired(true);
		salaryEmployeeEvaluationIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);

		gradeField = new DataSourceTextField("grade", "等级");
		gradeField.setLength(255);
		gradeField.setRequired(false);
		gradeField.setHidden(false);

		happenDateField = new DataSourceDateField("happenDate", "绩效发生时间");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(false);
		operateEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		setFields(salaryEmployeeEvaluationIdField, employeeIdField, yearField, monthField, gradeField, happenDateField,
				operateEmployeeIdField, operateTimeField, remarkField);
	}

}
