package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSResidualwageData extends DBDataSource
{


	public static DSResidualwageData instance = null;

	public static DSResidualwageData getInstance() {
		if(instance == null) {
			instance = new DSResidualwageData("DSResidualwageData");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField factSalaryField;
	private final DataSourceFloatField issueMoneyField;
	private final DataSourceFloatField balanceField;

	public DSResidualwageData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ResidualwageData");


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("departments"));


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		factSalaryField = new DataSourceFloatField("factSalary", "factSalary");
		factSalaryField.setLength(18);
		factSalaryField.setDecimalPad(2);
		factSalaryField.setFormat("#,###,###,###,###,##0.00");
		factSalaryField.setRequired(true);
		factSalaryField.setHidden(false);


		issueMoneyField = new DataSourceFloatField("issueMoney", "发放钱数");
		issueMoneyField.setLength(64);
		issueMoneyField.setDecimalPad(2);
		issueMoneyField.setFormat("##,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,##0.00");
		issueMoneyField.setRequired(false);
		issueMoneyField.setHidden(false);


		balanceField = new DataSourceFloatField("balance", "balance");
		balanceField.setLength(18);
		balanceField.setDecimalPad(2);
		balanceField.setFormat("#,###,###,###,###,##0.00");
		balanceField.setRequired(true);
		balanceField.setHidden(false);



		setFields(companyIdField, employeeIdField, employeeNoField, employeeNameField, bankAccountField, yearField, monthField, factSalaryField, issueMoneyField, balanceField);
	}


}

