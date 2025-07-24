package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSIntegralReturn extends DBDataSource
{


	public static DSIntegralReturn instance = null;

	public static DSIntegralReturn getInstance() {
		if(instance == null) {
			instance = new DSIntegralReturn("DSIntegralReturnOfPlate");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField gradeIdField;
	private final DataSourceFloatField achieveintegralField;

	public DSIntegralReturn(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadIntegralReturnOfAccount");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);

		achieveintegralField = new DataSourceFloatField("achieveintegral", "价值积分");
		achieveintegralField.setLength(18);
		achieveintegralField.setDecimalPad(2);
		achieveintegralField.setFormat("#,###,###,###,###,##0.00");
		achieveintegralField.setRequired(true);
		achieveintegralField.setHidden(false);
		
		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		
		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		gradeIdField = new DataSourceIntegerField("gradeId", "职级");
		gradeIdField.setLength(64);
		gradeIdField.setRequired(false);
		gradeIdField.setHidden(false);
		gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));
		
		setFields(employeeIdField, achieveintegralField, employeeNoField, employeeNameField, plateIdField,gradeIdField, statusField);
	}


}

