package com.pomplatform.client.financialtransactionaccount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDHandingTransDetailSummary extends DataSource
{


	public static CDHandingTransDetailSummary instance = null;

	public static CDHandingTransDetailSummary getInstance() {
		if(instance == null) {
			instance = new CDHandingTransDetailSummary("CDHandingTransDetailSummary");
		}
		return instance;
	}

	private final DataSourceIntegerField financialTransactionAccountIdField;
	private final DataSourceTextField financeNoField;
	private final DataSourceTextField accountNameField;
	private final DataSourceIntegerField accountTypeField;
	private final DataSourceIntegerField accountStatusField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceDateField initEndDateField;
	private final DataSourceIntegerField companyIdField;

	public CDHandingTransDetailSummary(String dataSourceID) {

		setID(dataSourceID);
		financialTransactionAccountIdField = new DataSourceIntegerField("financialTransactionAccountId", "财务往来账户");
		financialTransactionAccountIdField.setRequired(false);
		financialTransactionAccountIdField.setLength(11);
		financialTransactionAccountIdField.setHidden(false);

		financeNoField = new DataSourceTextField("financeNo", "财务编号");
		financeNoField.setRequired(false);
		financeNoField.setLength(64);
		financeNoField.setHidden(false);

		accountNameField = new DataSourceTextField("accountName", "名称");
		accountNameField.setRequired(false);
		accountNameField.setLength(256);
		accountNameField.setHidden(false);

		accountTypeField = new DataSourceIntegerField("accountType", "账户类型");
		accountTypeField.setRequired(false);
		accountTypeField.setLength(11);
		accountTypeField.setHidden(false);
		accountTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		accountStatusField = new DataSourceIntegerField("accountStatus", "账户状态");
		accountStatusField.setRequired(false);
		accountStatusField.setLength(11);
		accountStatusField.setHidden(false);
		accountStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "截止日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		initEndDateField = new DataSourceDateField("initEndDate", "期初截止日期");
		initEndDateField.setRequired(false);
		initEndDateField.setHidden(false);
		
		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

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


		setFields(financialTransactionAccountIdField, financeNoField, accountNameField, accountTypeField, accountStatusField, startDateField, endDateField, initEndDateField, companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

