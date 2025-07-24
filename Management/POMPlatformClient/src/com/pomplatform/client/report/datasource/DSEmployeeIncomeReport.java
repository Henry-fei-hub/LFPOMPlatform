package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeIncomeReport extends DBDataSource
{


	public static DSEmployeeIncomeReport instance = null;

	public static DSEmployeeIncomeReport getInstance() {
		if(instance == null) {
			instance = new DSEmployeeIncomeReport("DSEmployeeIncomeReport");
		}
		return instance;
	}

	private final DataSourceFloatField yearField;
	private final DataSourceFloatField monthField;
	private final DataSourceIntegerField businessTypeIdField;
	private final DataSourceFloatField integralField;

	public DSEmployeeIncomeReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeIncomeReport");


		yearField = new DataSourceFloatField("year", "");
		yearField.setLength(8);
		yearField.setDecimalPad(0);
		yearField.setFormat("##,###,##0");
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceFloatField("month", "month");
		monthField.setLength(8);
		monthField.setDecimalPad(0);
		monthField.setFormat("##,###,##0");
		monthField.setRequired(true);
		monthField.setHidden(false);


		businessTypeIdField = new DataSourceIntegerField("businessTypeId", "10绩效奖金)");
		businessTypeIdField.setLength(11);
		businessTypeIdField.setRequired(false);
		businessTypeIdField.setHidden(false);


		integralField = new DataSourceFloatField("integral", "积分");
		integralField.setLength(18);
		integralField.setDecimalPad(2);
		integralField.setFormat("#,###,###,###,###,##0.00");
		integralField.setRequired(false);
		integralField.setHidden(false);


		setFields(yearField, monthField, businessTypeIdField, integralField);
	}


}

