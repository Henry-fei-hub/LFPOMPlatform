package com.pomplatform.client.bonuspaymentbydetail.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSBonusPaymentByDetail extends DBDataSource
{


	public static DSBonusPaymentByDetail instance = null;

	public static DSBonusPaymentByDetail getInstance() {
		if(instance == null) {
			instance = new DSBonusPaymentByDetail("DSBonusPaymentByDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField payIntegralField;
	private final DataSourceDateField payDateField;

	public DSBonusPaymentByDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BonusPaymentByDetail");


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


		payDateField = new DataSourceDateField("payDate", "发放日期");
		payDateField.setRequired(false);
		payDateField.setHidden(false);


		setFields(employeeIdField, employeeNoField, payIntegralField, payDateField);
	}


}

