package com.pomplatform.client.onenewaccountstransationsinfo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOneNewAccountsTransationsInfo extends DBDataSource
{


	public static DSOneNewAccountsTransationsInfo instance = null;

	public static DSOneNewAccountsTransationsInfo getInstance() {
		if(instance == null) {
			instance = new DSOneNewAccountsTransationsInfo("DSOneNewAccountsTransationsInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField accountTransactionField;
	private final DataSourceIntegerField accountIdField;
	private final DataSourceIntegerField originalCurrencyDebitField;
	private final DataSourceIntegerField originalCurrencyLoanField;
	private final DataSourceIntegerField exchangeRateField;
	private final DataSourceIntegerField standardMoneyDebitField;
	private final DataSourceIntegerField standardMoneyLoanField;
	private final DataSourceIntegerField itemCategoryField;
	
	private final DataSourceIntegerField mainProjectCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField recordDateField;
	private final DataSourceDateTimeField affiliationDateField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField accountCodeField;

	public DSOneNewAccountsTransationsInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OneNewAccountsTransationsInfo");


		accountTransactionField = new DataSourceIntegerField("accountTransaction", "主键");
		accountTransactionField.setLength(11);
		accountTransactionField.setRequired(true);
		accountTransactionField.setHidden(true);


		accountIdField = new DataSourceIntegerField("accountId", "账户表主键");
		accountIdField.setLength(11);
		accountIdField.setPrimaryKey(true);
		accountIdField.setRequired(true);
		accountIdField.setHidden(true);


		originalCurrencyDebitField = new DataSourceIntegerField("originalCurrencyDebit", "原币借");
		originalCurrencyDebitField.setLength(32);
		originalCurrencyDebitField.setRequired(true);
		originalCurrencyDebitField.setHidden(false);


		originalCurrencyLoanField = new DataSourceIntegerField("originalCurrencyLoan", "原币贷");
		originalCurrencyLoanField.setLength(32);
		originalCurrencyLoanField.setRequired(true);
		originalCurrencyLoanField.setHidden(false);


		exchangeRateField = new DataSourceIntegerField("exchangeRate", "exchangeRate");
		exchangeRateField.setLength(24);
		exchangeRateField.setRequired(true);
		exchangeRateField.setHidden(false);


		standardMoneyDebitField = new DataSourceIntegerField("standardMoneyDebit", "本位借");
		standardMoneyDebitField.setLength(32);
		standardMoneyDebitField.setRequired(true);
		standardMoneyDebitField.setHidden(false);


		standardMoneyLoanField = new DataSourceIntegerField("standardMoneyLoan", "本位贷");
		standardMoneyLoanField.setLength(32);
		standardMoneyLoanField.setRequired(true);
		standardMoneyLoanField.setHidden(false);


		itemCategoryField = new DataSourceIntegerField("itemCategory", "事项类别");
		itemCategoryField.setLength(11);
		itemCategoryField.setRequired(false);
		itemCategoryField.setHidden(false);


		

		mainProjectCodeField = new DataSourceIntegerField("mainProjectCode", "大项目");
		mainProjectCodeField.setLength(11);
		mainProjectCodeField.setRequired(false);
		mainProjectCodeField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(20);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		recordDateField = new DataSourceDateTimeField("recordDate", "记录时间");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);


		affiliationDateField = new DataSourceDateTimeField("affiliationDate", "归属时间");
		affiliationDateField.setRequired(false);
		affiliationDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		accountCodeField = new DataSourceTextField("accountCode", "关联账号");
		accountCodeField.setLength(255);
		accountCodeField.setRequired(true);
		accountCodeField.setHidden(false);
		
		


		setFields(accountIdField, accountTransactionField, accountCodeField, originalCurrencyDebitField, originalCurrencyLoanField, exchangeRateField, standardMoneyDebitField, standardMoneyLoanField, itemCategoryField,mainProjectCodeField, contractIdField, departmentIdField, plateIdField, employeeIdField, recordDateField, affiliationDateField,remarkField);
	}


}

