package com.pomplatform.client.employeeachieveintegralreturnrecordbymonth.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeAchieveIntegralReturnRecordByMonth extends DBDataSource
{


	public static DSEmployeeAchieveIntegralReturnRecordByMonth instance = null;

	public static DSEmployeeAchieveIntegralReturnRecordByMonth getInstance() {
		if(instance == null) {
			instance = new DSEmployeeAchieveIntegralReturnRecordByMonth("DSEmployeeAchieveIntegralReturnRecordByMonth");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceIntegerField recordYearField;
	private final DataSourceIntegerField recordMonthField;
	private final DataSourceFloatField achieveIntegralField;

	public DSEmployeeAchieveIntegralReturnRecordByMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeAchieveIntegralReturnRecordByMonth");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		recordYearField = new DataSourceIntegerField("recordYear", "年份");
		recordYearField.setLength(11);
		recordYearField.setRequired(true);
		recordYearField.setHidden(false);


		recordMonthField = new DataSourceIntegerField("recordMonth", "月份");
		recordMonthField.setLength(11);
		recordMonthField.setRequired(true);
		recordMonthField.setHidden(false);


		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "回流积分");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);


		setFields(plateIdField, recordYearField, recordMonthField, achieveIntegralField);
	}


}

