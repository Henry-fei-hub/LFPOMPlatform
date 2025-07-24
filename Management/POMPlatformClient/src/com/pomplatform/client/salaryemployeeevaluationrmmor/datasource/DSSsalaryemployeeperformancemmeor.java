package com.pomplatform.client.salaryemployeeevaluationrmmor.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSsalaryemployeeperformancemmeor extends DBDataSource {

	public static DSSsalaryemployeeperformancemmeor instance = null;

	public static DSSsalaryemployeeperformancemmeor getInstance() {
		if (instance == null) {
			instance = new DSSsalaryemployeeperformancemmeor("DSSsalaryemployeeperformancemmeor");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryEmployeePerformanceIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField monthPayField;
	private final DataSourceTextField basicProportionStrField;
	private final DataSourceFloatField basicProportionField;
	private final DataSourceFloatField monthBasicPayField;
	private final DataSourceFloatField monthPerformancePayField;
	private final DataSourceFloatField shouldDaysField;
	private final DataSourceFloatField factDaysField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceDateField happenDateField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField gradeField;
	private final DataSourceFloatField proportionField;
	private final DataSourceFloatField workingCoefficientField;
	private final DataSourceFloatField actualPerformancePayField;

	public DSSsalaryemployeeperformancemmeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Ssalaryemployeeperformancemmeor");

		salaryEmployeePerformanceIdField = new DataSourceIntegerField("salaryEmployeePerformanceId", "主键");
		salaryEmployeePerformanceIdField.setLength(11);
		salaryEmployeePerformanceIdField.setPrimaryKey(true);
		salaryEmployeePerformanceIdField.setRequired(true);
		salaryEmployeePerformanceIdField.setHidden(true);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		statusField = new DataSourceIntegerField("status", "员工状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

		monthPayField = new DataSourceFloatField("monthPay", "月薪");
		monthPayField.setLength(18);
		monthPayField.setDecimalPad(2);
		monthPayField.setFormat("#,###,###,###,###,##0.00");
		monthPayField.setRequired(false);
		monthPayField.setHidden(false);

		basicProportionStrField = new DataSourceTextField("basicProportionStr", "基本比例");
		basicProportionStrField.setLength(64);
		basicProportionStrField.setRequired(false);
		basicProportionStrField.setHidden(false);

		basicProportionField = new DataSourceFloatField("basicProportion", "基本比例");
		basicProportionField.setLength(18);
		basicProportionField.setDecimalPad(4);
		basicProportionField.setFormat("##,###,###,###,##0.0000");
		basicProportionField.setRequired(false);
		basicProportionField.setHidden(true);

		monthBasicPayField = new DataSourceFloatField("monthBasicPay", "月基本工资");
		monthBasicPayField.setLength(18);
		monthBasicPayField.setDecimalPad(2);
		monthBasicPayField.setFormat("#,###,###,###,###,##0.00");
		monthBasicPayField.setRequired(false);
		monthBasicPayField.setHidden(false);

		monthPerformancePayField = new DataSourceFloatField("monthPerformancePay", "月绩效工资");
		monthPerformancePayField.setLength(18);
		monthPerformancePayField.setDecimalPad(2);
		monthPerformancePayField.setFormat("#,###,###,###,###,##0.00");
		monthPerformancePayField.setRequired(false);
		monthPerformancePayField.setHidden(false);

		shouldDaysField = new DataSourceFloatField("shouldDays", "应到天数");
		shouldDaysField.setLength(18);
		shouldDaysField.setDecimalPad(2);
		shouldDaysField.setFormat("#,###,###,###,###,##0.00");
		shouldDaysField.setRequired(false);
		shouldDaysField.setHidden(false);

		factDaysField = new DataSourceFloatField("factDays", "实到天数");
		factDaysField.setLength(18);
		factDaysField.setDecimalPad(2);
		factDaysField.setFormat("#,###,###,###,###,##0.00");
		factDaysField.setRequired(false);
		factDaysField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);

		monthField = new DataSourceIntegerField("month", "月");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);

		happenDateField = new DataSourceDateField("happenDate", "发生日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建日期");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		gradeField = new DataSourceTextField("grade", "等级");
		gradeField.setLength(255);
		gradeField.setRequired(false);
		gradeField.setHidden(false);

		proportionField = new DataSourceFloatField("proportion", "比例");
		proportionField.setLength(18);
		proportionField.setDecimalPad(2);
		proportionField.setFormat("#,###,###,###,###,##0.00");
		proportionField.setRequired(false);
		proportionField.setHidden(false);

		workingCoefficientField = new DataSourceFloatField("workingCoefficient", "工作系数");
		workingCoefficientField.setLength(18);
		workingCoefficientField.setDecimalPad(2);
		workingCoefficientField.setFormat("#,###,###,###,###,##0.00");
		workingCoefficientField.setRequired(false);
		workingCoefficientField.setHidden(false);

		actualPerformancePayField = new DataSourceFloatField("actualPerformancePay", "实发绩效");
		actualPerformancePayField.setLength(18);
		actualPerformancePayField.setDecimalPad(2);
		actualPerformancePayField.setFormat("#,###,###,###,###,##0.00");
		actualPerformancePayField.setRequired(false);
		actualPerformancePayField.setHidden(false);

		setFields(salaryEmployeePerformanceIdField, employeeNoField, employeeIdField, plateIdField, departmentIdField,
				companyIdField, statusField, yearField, monthField, monthPayField, basicProportionStrField, basicProportionField,
				monthBasicPayField, monthPerformancePayField, shouldDaysField, factDaysField,
				happenDateField, createTimeField, gradeField, proportionField, workingCoefficientField,
				actualPerformancePayField);
	}

}
