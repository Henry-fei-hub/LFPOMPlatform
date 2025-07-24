package com.pomplatform.client.employeesalaryreturnrecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeSalaryReturnRecord extends DBDataSource
{


	public static DSEmployeeSalaryReturnRecord instance = null;

	public static DSEmployeeSalaryReturnRecord getInstance() {
		if(instance == null) {
			instance = new DSEmployeeSalaryReturnRecord("DSEmployeeSalaryReturnRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeSalaryReturnRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField salaryReturnField;
	private final DataSourceDateField recordDateField;

	public DSEmployeeSalaryReturnRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeSalaryReturnRecord");


		employeeSalaryReturnRecordIdField = new DataSourceIntegerField("employeeSalaryReturnRecordId", "编码");
		employeeSalaryReturnRecordIdField.setLength(11);
		employeeSalaryReturnRecordIdField.setPrimaryKey(true);
		employeeSalaryReturnRecordIdField.setRequired(true);
		employeeSalaryReturnRecordIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分回流");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "回流时间");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		setFields(employeeSalaryReturnRecordIdField, plateIdField, employeeIdField, employeeNameField, employeeNoField, salaryReturnField, recordDateField);
	}


}

