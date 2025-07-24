package com.pomplatform.client.financialtransactionaccount.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSFinancialAccountInitAmount extends DBDataSource
{


	public static DSFinancialAccountInitAmount instance = null;

	public static DSFinancialAccountInitAmount getInstance() {
		if(instance == null) {
			instance = new DSFinancialAccountInitAmount("DSFinancialAccountInitAmount");
		}
		return instance;
	}

	private final DataSourceIntegerField financialAccountInitAmountIdField;
	private final DataSourceIntegerField financialTransactionAccountIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField currencyTypeField;
	private final DataSourceFloatField originalDebitField;
	private final DataSourceFloatField originalCreditField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceFloatField standardDebitField;
	private final DataSourceFloatField standardCreditField;
	private final DataSourceTextField summaryField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;

	public DSFinancialAccountInitAmount(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("FinancialAccountInitAmount");


		financialAccountInitAmountIdField = new DataSourceIntegerField("financialAccountInitAmountId", "主键编码");
		financialAccountInitAmountIdField.setLength(11);
		financialAccountInitAmountIdField.setPrimaryKey(true);
		financialAccountInitAmountIdField.setRequired(true);
		financialAccountInitAmountIdField.setHidden(false);


		financialTransactionAccountIdField = new DataSourceIntegerField("financialTransactionAccountId", "财务往来账户");
		financialTransactionAccountIdField.setLength(11);
		financialTransactionAccountIdField.setRequired(false);
		financialTransactionAccountIdField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		currencyTypeField = new DataSourceIntegerField("currencyType", "货币种类");
		currencyTypeField.setLength(11);
		currencyTypeField.setRequired(false);
		currencyTypeField.setHidden(false);


		originalDebitField = new DataSourceFloatField("originalDebit", "原币借");
		originalDebitField.setLength(18);
		originalDebitField.setDecimalPad(2);
		originalDebitField.setFormat("#,###,###,###,###,##0.00");
		originalDebitField.setRequired(false);
		originalDebitField.setHidden(false);


		originalCreditField = new DataSourceFloatField("originalCredit", "原币贷");
		originalCreditField.setLength(18);
		originalCreditField.setDecimalPad(2);
		originalCreditField.setFormat("#,###,###,###,###,##0.00");
		originalCreditField.setRequired(false);
		originalCreditField.setHidden(false);


		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(8);
		exchangeRateField.setDecimalPad(4);
		exchangeRateField.setFormat("#,##0.0000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(false);


		standardDebitField = new DataSourceFloatField("standardDebit", "本币借");
		standardDebitField.setLength(18);
		standardDebitField.setDecimalPad(2);
		standardDebitField.setFormat("#,###,###,###,###,##0.00");
		standardDebitField.setRequired(false);
		standardDebitField.setHidden(false);


		standardCreditField = new DataSourceFloatField("standardCredit", "本币贷");
		standardCreditField.setLength(18);
		standardCreditField.setDecimalPad(2);
		standardCreditField.setFormat("#,###,###,###,###,##0.00");
		standardCreditField.setRequired(false);
		standardCreditField.setHidden(false);


		summaryField = new DataSourceTextField("summary", "摘要");
		summaryField.setLength(255);
		summaryField.setRequired(false);
		summaryField.setHidden(false);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(false);


		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(false);


		setFields(financialAccountInitAmountIdField, financialTransactionAccountIdField, companyIdField, currencyTypeField, originalDebitField, originalCreditField, exchangeRateField, standardDebitField, standardCreditField, summaryField, attachmentIdField, operatorIdField, createTimeField, deleteFlagField);
	}


}

