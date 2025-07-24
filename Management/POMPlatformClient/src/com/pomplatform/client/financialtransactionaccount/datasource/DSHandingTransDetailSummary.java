package com.pomplatform.client.financialtransactionaccount.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSHandingTransDetailSummary extends DBDataSource
{


	public static DSHandingTransDetailSummary instance = null;

	public static DSHandingTransDetailSummary getInstance() {
		if(instance == null) {
			instance = new DSHandingTransDetailSummary("DSHandingTransDetailSummary");
		}
		return instance;
	}

	private final DataSourceIntegerField financialTransactionAccountIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField accountTypeField;
	private final DataSourceTextField financeNoField;
	private final DataSourceTextField accountNameField;
	private final DataSourceBooleanField reimbursableField;
	private final DataSourceIntegerField accountStatusField;
	private final DataSourceFloatField initStandardDebitField;
	private final DataSourceFloatField initStandardCreditField;
	private final DataSourceFloatField standardDebitField;
	private final DataSourceFloatField standardCreditField;
	private final DataSourceFloatField endStandardDebitField;
	private final DataSourceFloatField endStandardCreditField;

	public DSHandingTransDetailSummary(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("HandingTransDetailSummary");


		financialTransactionAccountIdField = new DataSourceIntegerField("financialTransactionAccountId", "财务往来账户");
		financialTransactionAccountIdField.setLength(11);
		financialTransactionAccountIdField.setRequired(false);
		financialTransactionAccountIdField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		accountTypeField = new DataSourceIntegerField("accountType", "账户类型");
		accountTypeField.setLength(11);
		accountTypeField.setRequired(false);
		accountTypeField.setHidden(false);
		accountTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_230"));


		financeNoField = new DataSourceTextField("financeNo", "财务编号");
		financeNoField.setLength(64);
		financeNoField.setRequired(false);
		financeNoField.setHidden(false);


		accountNameField = new DataSourceTextField("accountName", "名称");
		accountNameField.setLength(256);
		accountNameField.setRequired(false);
		accountNameField.setHidden(false);


		reimbursableField = new DataSourceBooleanField("reimbursable", "能否报销");
		reimbursableField.setRequired(false);
		reimbursableField.setHidden(true);


		accountStatusField = new DataSourceIntegerField("accountStatus", "账户状态");
		accountStatusField.setLength(11);
		accountStatusField.setRequired(false);
		accountStatusField.setHidden(false);
		accountStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_217"));


		initStandardDebitField = new DataSourceFloatField("initStandardDebit", "期初借");
		initStandardDebitField.setLength(18);
		initStandardDebitField.setDecimalPad(2);
		initStandardDebitField.setFormat("#,###,###,###,###,##0.00");
		initStandardDebitField.setRequired(true);
		initStandardDebitField.setHidden(false);


		initStandardCreditField = new DataSourceFloatField("initStandardCredit", "期初贷");
		initStandardCreditField.setLength(18);
		initStandardCreditField.setDecimalPad(2);
		initStandardCreditField.setFormat("#,###,###,###,###,##0.00");
		initStandardCreditField.setRequired(true);
		initStandardCreditField.setHidden(false);


		standardDebitField = new DataSourceFloatField("standardDebit", "借方发生额");
		standardDebitField.setLength(18);
		standardDebitField.setDecimalPad(2);
		standardDebitField.setFormat("#,###,###,###,###,##0.00");
		standardDebitField.setRequired(false);
		standardDebitField.setHidden(false);


		standardCreditField = new DataSourceFloatField("standardCredit", "贷方发生额");
		standardCreditField.setLength(18);
		standardCreditField.setDecimalPad(2);
		standardCreditField.setFormat("#,###,###,###,###,##0.00");
		standardCreditField.setRequired(false);
		standardCreditField.setHidden(false);


		endStandardDebitField = new DataSourceFloatField("endStandardDebit", "期末借");
		endStandardDebitField.setLength(18);
		endStandardDebitField.setDecimalPad(2);
		endStandardDebitField.setFormat("#,###,###,###,###,##0.00");
		endStandardDebitField.setRequired(true);
		endStandardDebitField.setHidden(false);


		endStandardCreditField = new DataSourceFloatField("endStandardCredit", "期末贷");
		endStandardCreditField.setLength(18);
		endStandardCreditField.setDecimalPad(2);
		endStandardCreditField.setFormat("#,###,###,###,###,##0.00");
		endStandardCreditField.setRequired(true);
		endStandardCreditField.setHidden(false);


		setFields(financialTransactionAccountIdField, companyIdField, accountTypeField, financeNoField, accountNameField, reimbursableField, accountStatusField, initStandardDebitField, initStandardCreditField, standardDebitField, standardCreditField, endStandardDebitField, endStandardCreditField);
	}


}

