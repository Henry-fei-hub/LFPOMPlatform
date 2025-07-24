package com.pomplatform.client.employeeachieveintegralreturnrecordbyemoloyee.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeAchieveIntegralReturnRecordByEmoloyee extends DBDataSource
{


	public static DSEmployeeAchieveIntegralReturnRecordByEmoloyee instance = null;

	public static DSEmployeeAchieveIntegralReturnRecordByEmoloyee getInstance() {
		if(instance == null) {
			instance = new DSEmployeeAchieveIntegralReturnRecordByEmoloyee("DSEmployeeAchieveIntegralReturnRecordByEmoloyee");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceIntegerField statusField;

	public DSEmployeeAchieveIntegralReturnRecordByEmoloyee(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeAchieveIntegralReturnRecordByEmoloyee");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(true);


		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "回收积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);
		
		statusField = new DataSourceIntegerField("status", "回收类型");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_37"));


		setFields(plateIdField, employeeIdField, employeeNoField, employeeNameField, achieveIntegralField, statusField);
	}


}

