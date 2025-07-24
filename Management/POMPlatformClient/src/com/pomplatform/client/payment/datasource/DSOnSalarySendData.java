package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnSalarySendData extends DBDataSource
{


	public static DSOnSalarySendData instance = null;

	public static DSOnSalarySendData getInstance() {
		if(instance == null) {
			instance = new DSOnSalarySendData("DSOnSalarySendData");
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
	private final DataSourceFloatField factSalaryField;
	private final DataSourceFloatField salaryIssueField;
	private final DataSourceFloatField loanIssueField;
	private final DataSourceFloatField balanceField;

	public DSOnSalarySendData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalarySendData");


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
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
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


		factSalaryField = new DataSourceFloatField("factSalary", "实发工资");
		factSalaryField.setLength(18);
		factSalaryField.setDecimalPad(2);
		factSalaryField.setFormat("#,###,###,###,###,##0.00");
		factSalaryField.setRequired(true);
		factSalaryField.setHidden(false);

		salaryIssueField = new DataSourceFloatField("salaryissue", "已发工资");
		salaryIssueField.setLength(18);
		salaryIssueField.setDecimalPad(2);
		salaryIssueField.setFormat("#,###,###,###,###,##0.00");
		salaryIssueField.setRequired(true);
		salaryIssueField.setHidden(false);

		loanIssueField = new DataSourceFloatField("loanissue", "借款金额");
		loanIssueField.setLength(18);
		loanIssueField.setDecimalPad(2);
		loanIssueField.setFormat("#,###,###,###,###,##0.00");
		loanIssueField.setRequired(true);
		loanIssueField.setHidden(false);

		balanceField = new DataSourceFloatField("balance", "剩余工资");
		balanceField.setLength(18);
		balanceField.setDecimalPad(2);
		balanceField.setFormat("#,###,###,###,###,##0.00");
		balanceField.setRequired(true);
		balanceField.setHidden(false);


		setFields(companyIdField, employeeIdField, employeeNoField, employeeNameField, bankAccountField, yearField, monthField, factSalaryField, salaryIssueField,loanIssueField, balanceField);
	}


}

