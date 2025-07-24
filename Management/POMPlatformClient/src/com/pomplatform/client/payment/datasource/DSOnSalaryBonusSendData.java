package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnSalaryBonusSendData extends DBDataSource
{


	public static DSOnSalaryBonusSendData instance = null;

	public static DSOnSalaryBonusSendData getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryBonusSendData("DSOnSalaryBonusSendData");
		}
		return instance;
	}

	private final DataSourceTextField companyIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField factBonusField;

	public DSOnSalaryBonusSendData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryBonusSendData");


		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		factBonusField = new DataSourceFloatField("factBonus", "实发奖金");
		factBonusField.setLength(18);
		factBonusField.setDecimalPad(2);
		factBonusField.setFormat("#,###,###,###,###,##0.00");
		factBonusField.setRequired(true);
		factBonusField.setHidden(false);


		setFields(companyIdField, employeeIdField, employeeNoField, employeeNameField, bankAccountField, yearField, monthField, factBonusField);
	}


}

