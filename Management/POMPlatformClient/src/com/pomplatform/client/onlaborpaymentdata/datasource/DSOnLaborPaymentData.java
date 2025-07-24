package com.pomplatform.client.onlaborpaymentdata.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLaborPaymentData extends DBDataSource
{


	public static DSOnLaborPaymentData instance = null;

	public static DSOnLaborPaymentData getInstance() {
		if(instance == null) {
			instance = new DSOnLaborPaymentData("DSOnLaborPaymentData");
		}
		return instance;
	}

	private final DataSourceIntegerField laborPaymentEmployeeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public DSOnLaborPaymentData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLaborPaymentData");

		laborPaymentEmployeeIdField = new DataSourceIntegerField("laborPaymentEmployeeId", "主键id");
		laborPaymentEmployeeIdField.setLength(11);
		laborPaymentEmployeeIdField.setPrimaryKey(true);
		laborPaymentEmployeeIdField.setRequired(false);
		laborPaymentEmployeeIdField.setHidden(true);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employee_list"));

		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		departmentIdField.setCanEdit(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setCanEdit(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setCanEdit(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		yearField.setValueMap(KeyValueManager.getValueMap("system_dictionary_18"));

		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);
		monthField.setValueMap(KeyValueManager.getValueMap("system_dictionary_19"));


		setFields(laborPaymentEmployeeIdField,employeeIdField, employeeNoField, employeeNameField, departmentIdField, plateIdField, companyIdField, yearField, monthField);
	}


}

