package com.pomplatform.client.bonuspaymentbymonth.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSBonusPaymentByMonth extends DBDataSource
{


	public static DSBonusPaymentByMonth instance = null;

	public static DSBonusPaymentByMonth getInstance() {
		if(instance == null) {
			instance = new DSBonusPaymentByMonth("DSBonusPaymentByMonth");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField payIntegralField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;

	public DSBonusPaymentByMonth(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BonusPaymentByMonth");


		employeeIdField = new DataSourceIntegerField("employeeId", "姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		payIntegralField = new DataSourceFloatField("payIntegral", "发放积分");
		payIntegralField.setLength(12);
		payIntegralField.setDecimalPad(2);
		payIntegralField.setFormat("#,###,###,##0.00");
		payIntegralField.setRequired(false);
		payIntegralField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(true);
		monthField.setHidden(false);


		setFields(employeeIdField, employeeNoField, payIntegralField, yearField, monthField);
	}


}

