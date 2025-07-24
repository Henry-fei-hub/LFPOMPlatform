package com.pomplatform.client.employeeIntegralReturn.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeIntegralReturn extends DBDataSource
{


	public static DSEmployeeIntegralReturn instance = null;

	public static DSEmployeeIntegralReturn getInstance() {
		if(instance == null) {
			instance = new DSEmployeeIntegralReturn("DSEmployeeIntegralReturn");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceDateField recordDateField;

	public DSEmployeeIntegralReturn(String dataSourceID) {

		super();
		setID(dataSourceID);

		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "积分回收");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);


		recordDateField = new DataSourceDateField("recordDate", "回收日期");
		recordDateField.setLength(11);
		recordDateField.setRequired(true);
		recordDateField.setHidden(false);


		setFields(employeeIdField, employeeNoField, achieveIntegralField, recordDateField);
	}


}

