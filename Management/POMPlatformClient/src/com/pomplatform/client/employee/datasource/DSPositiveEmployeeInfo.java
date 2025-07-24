package com.pomplatform.client.employee.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPositiveEmployeeInfo extends DBDataSource
{


	public static DSPositiveEmployeeInfo instance = null;

	public static DSPositiveEmployeeInfo getInstance() {
		if(instance == null) {
			instance = new DSPositiveEmployeeInfo("DSPositiveEmployeeInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceIntegerField dutyIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceTextField tryTimePayField;
	private final DataSourceTextField positivePayField;
	private final DataSourceTextField annualPerformanceField;

	public DSPositiveEmployeeInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PositiveEmployeeInfo");


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


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		dutyIdField = new DataSourceIntegerField("dutyId", "职位名称");
		dutyIdField.setLength(11);
		dutyIdField.setRequired(false);
		dutyIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		positiveDateField = new DataSourceDateField("positiveDate", "转正日期");
		positiveDateField.setRequired(false);
		positiveDateField.setHidden(false);


		gradeIdField = new DataSourceIntegerField("gradeId", "职级");
		gradeIdField.setLength(11);
		gradeIdField.setRequired(false);
		gradeIdField.setHidden(true);


		tryTimePayField = new DataSourceTextField("tryTimePay", "试用期工资");
		tryTimePayField.setLength(64);
		tryTimePayField.setRequired(true);
		tryTimePayField.setHidden(true);
		
		
		positivePayField = new DataSourceTextField("positivePay", "转正工资");
		positivePayField.setLength(64);
		positivePayField.setRequired(true);
		positivePayField.setHidden(true);
		
		
		annualPerformanceField = new DataSourceTextField("annualPerformance", "年度绩效");
		annualPerformanceField.setLength(64);
		annualPerformanceField.setRequired(true);
		annualPerformanceField.setHidden(true);
		
		setFields(employeeIdField, employeeNoField, employeeNameField, departmentIdField, onboardDateField, dutyIdField, companyIdField, positiveDateField, gradeIdField, tryTimePayField, positivePayField, annualPerformanceField);
	}


}

