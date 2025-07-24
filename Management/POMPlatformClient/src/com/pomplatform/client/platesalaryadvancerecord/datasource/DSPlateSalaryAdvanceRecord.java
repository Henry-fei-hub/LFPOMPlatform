package com.pomplatform.client.platesalaryadvancerecord.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSPlateSalaryAdvanceRecord extends DBDataSource
{


	public static DSPlateSalaryAdvanceRecord instance = null;

	public static DSPlateSalaryAdvanceRecord getInstance() {
		if(instance == null) {
			instance = new DSPlateSalaryAdvanceRecord("DSPlateSalaryAdvanceRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField plateSalaryAdvanceRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField salaryReturnField;
	private final DataSourceDateField recordDateField;

	public DSPlateSalaryAdvanceRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PlateSalaryAdvanceRecord");


		plateSalaryAdvanceRecordIdField = new DataSourceIntegerField("plateSalaryAdvanceRecordId", "编码");
		plateSalaryAdvanceRecordIdField.setLength(11);
		plateSalaryAdvanceRecordIdField.setPrimaryKey(true);
		plateSalaryAdvanceRecordIdField.setRequired(true);
		plateSalaryAdvanceRecordIdField.setHidden(true);


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


		salaryReturnField = new DataSourceFloatField("salaryReturn", "人工成本补偿积分");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "操作时间");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		setFields(plateSalaryAdvanceRecordIdField, plateIdField, employeeIdField, employeeNameField, employeeNoField, salaryReturnField, recordDateField);
	}


}

