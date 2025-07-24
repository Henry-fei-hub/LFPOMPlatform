package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportPayChangeOnboardEmp extends DBDataSource
{


	public static DSReportPayChangeOnboardEmp instance = null;

	public static DSReportPayChangeOnboardEmp getInstance() {
		if(instance == null) {
			instance = new DSReportPayChangeOnboardEmp("DSReportPayChangeOnboardEmp");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceTextField tryTimePayField;
	private final DataSourceIntegerField educationField;
	private final DataSourceFloatField personalTotalFundField;
	private final DataSourceFloatField personalTotalInsuranceField;
	private final DataSourceIntegerField genderField;

	public DSReportPayChangeOnboardEmp(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportPayChangeOnboardEmp");


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


		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		tryTimePayField = new DataSourceTextField("tryTimePay", "试用期工资");
		tryTimePayField.setLength(64);
		tryTimePayField.setRequired(false);
		tryTimePayField.setHidden(false);


		educationField = new DataSourceIntegerField("education", "学历");
		educationField.setLength(11);
		educationField.setRequired(false);
		educationField.setHidden(false);
		educationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_80"));


		personalTotalFundField = new DataSourceFloatField("personalTotalFund", "公积金");
		personalTotalFundField.setLength(18);
		personalTotalFundField.setDecimalPad(2);
		personalTotalFundField.setFormat("#,###,###,###,###,##0.00");
		personalTotalFundField.setRequired(false);
		personalTotalFundField.setHidden(false);


		personalTotalInsuranceField = new DataSourceFloatField("personalTotalInsurance", "社保");
		personalTotalInsuranceField.setLength(18);
		personalTotalInsuranceField.setDecimalPad(2);
		personalTotalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalTotalInsuranceField.setRequired(false);
		personalTotalInsuranceField.setHidden(false);

		
		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setLength(11);
		genderField.setRequired(false);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		

		setFields(employeeIdField, employeeNoField, employeeNameField,genderField, plateIdField, departmentIdField, onboardDateField, tryTimePayField, personalTotalInsuranceField, personalTotalFundField, educationField);
	}


}

