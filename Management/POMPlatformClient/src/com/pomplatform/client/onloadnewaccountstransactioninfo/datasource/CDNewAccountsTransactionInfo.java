package com.pomplatform.client.onloadnewaccountstransactioninfo.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDNewAccountsTransactionInfo extends DataSource
{


	public static CDNewAccountsTransactionInfo instance = null;

	public static CDNewAccountsTransactionInfo getInstance() {
		if(instance == null) {
			instance = new CDNewAccountsTransactionInfo("CDNewAccountsTransactionInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField accountTransactionField;
	private final DataSourceIntegerField accountIdField;
	private final DataSourceFloatField originalCurrencyBorrowField;
	private final DataSourceFloatField originalCurrencyLoanField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceFloatField standardMoneyBorrowField;
	private final DataSourceFloatField standardMoneyLoanField;
	private final DataSourceIntegerField itemCategoryField;
	private final DataSourceTextField itemField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField recordDateField;
	private final DataSourceDateTimeField affiliationDateField;
	private final DataSourceTextField remarkField;

	public CDNewAccountsTransactionInfo(String dataSourceID) {

		setID(dataSourceID);
		accountTransactionField = new DataSourceIntegerField("accountTransaction", "主键");
		accountTransactionField.setRequired(true);
		accountTransactionField.setLength(11);
		accountTransactionField.setHidden(true);

		accountIdField = new DataSourceIntegerField("accountId", "关联账户编码");
		accountIdField.setRequired(false);
		accountIdField.setLength(11);
		accountIdField.setHidden(false);

		originalCurrencyBorrowField = new DataSourceFloatField("originalCurrencyBorrow", "原币借");
		originalCurrencyBorrowField.setRequired(true);
		originalCurrencyBorrowField.setLength(32);
		originalCurrencyBorrowField.setHidden(false);

		originalCurrencyLoanField = new DataSourceFloatField("originalCurrencyLoan", "原币借");
		originalCurrencyLoanField.setRequired(true);
		originalCurrencyLoanField.setLength(32);
		originalCurrencyLoanField.setHidden(false);

		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setRequired(true);
		exchangeRateField.setLength(24);
		exchangeRateField.setHidden(false);

		standardMoneyBorrowField = new DataSourceFloatField("standardMoneyBorrow", "本位币");
		standardMoneyBorrowField.setRequired(true);
		standardMoneyBorrowField.setLength(32);
		standardMoneyBorrowField.setHidden(false);

		standardMoneyLoanField = new DataSourceFloatField("standardMoneyLoan", "本位贷");
		standardMoneyLoanField.setRequired(true);
		standardMoneyLoanField.setLength(32);
		standardMoneyLoanField.setHidden(false);

		itemCategoryField = new DataSourceIntegerField("itemCategory", "事项类别");
		itemCategoryField.setRequired(false);
		itemCategoryField.setLength(11);
		itemCategoryField.setHidden(false);

		itemField = new DataSourceTextField("item", "事项");
		itemField.setRequired(false);
		itemField.setLength(255);
		itemField.setHidden(false);

		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "大项目");
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setLength(11);
		mainProjectIdField.setHidden(false);

		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门编码");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);

		recordDateField = new DataSourceDateTimeField("recordDate", "记录时间");
		recordDateField.setRequired(false);
		recordDateField.setHidden(false);

		affiliationDateField = new DataSourceDateTimeField("affiliationDate", "归属时间");
		affiliationDateField.setRequired(false);
		affiliationDateField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(255);
		remarkField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(accountTransactionField, accountIdField, originalCurrencyBorrowField, originalCurrencyLoanField, exchangeRateField, standardMoneyBorrowField, standardMoneyLoanField, itemCategoryField, itemField, mainProjectIdField, contractIdField, departmentIdField, plateIdField, employeeIdField, recordDateField, affiliationDateField, remarkField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

