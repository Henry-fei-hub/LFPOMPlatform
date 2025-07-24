package com.pomplatform.client.financialstatements.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSFinancicalCapitalAnalysis extends DBDataSource
{


	public static DSFinancicalCapitalAnalysis instance = null;

	public static DSFinancicalCapitalAnalysis getInstance() {
		if(instance == null) {
			instance = new DSFinancicalCapitalAnalysis("DSFinancicalCapitalAnalysis");
		}
		return instance;
	}

	private final DataSourceIntegerField companyIdField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceFloatField initialBalanceField;
	private final DataSourceFloatField contractMoneyField;
	private final DataSourceFloatField rentReceivablesField;
	private final DataSourceFloatField financingReceivablesField;
	private final DataSourceFloatField employeeRepaymentField;
	private final DataSourceFloatField preCollectionField;
	private final DataSourceFloatField otherReceivablesField;
	private final DataSourceFloatField internalCollectionField;
	private final DataSourceFloatField salaryField;
	private final DataSourceFloatField projectReimbursementField;
	private final DataSourceFloatField rentPaymentField;
	private final DataSourceFloatField assetPurchaseField;
	private final DataSourceFloatField financingPaymentField;
	private final DataSourceFloatField employeeLoanField;
	private final DataSourceFloatField prePaymentField;
	private final DataSourceFloatField otherPaymentField;
	private final DataSourceFloatField internalPaymentField;
	private final DataSourceFloatField closingBalanceField;

	public DSFinancicalCapitalAnalysis(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("FinancicalCapitalAnalysis");


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(255);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(true);


		initialBalanceField = new DataSourceFloatField("initialBalance", "期初余额");
		initialBalanceField.setLength(16);
		initialBalanceField.setDecimalPad(2);
		initialBalanceField.setFormat("##,###,###,###,##0.00");
		initialBalanceField.setRequired(false);
		initialBalanceField.setHidden(false);


		contractMoneyField = new DataSourceFloatField("contractMoney", "合同款");
		contractMoneyField.setLength(16);
		contractMoneyField.setDecimalPad(2);
		contractMoneyField.setFormat("##,###,###,###,##0.00");
		contractMoneyField.setRequired(false);
		contractMoneyField.setHidden(false);


		rentReceivablesField = new DataSourceFloatField("rentReceivables", "房租款");
		rentReceivablesField.setLength(16);
		rentReceivablesField.setDecimalPad(2);
		rentReceivablesField.setFormat("##,###,###,###,##0.00");
		rentReceivablesField.setRequired(false);
		rentReceivablesField.setHidden(false);


		financingReceivablesField = new DataSourceFloatField("financingReceivables", "融资收款");
		financingReceivablesField.setLength(16);
		financingReceivablesField.setDecimalPad(2);
		financingReceivablesField.setFormat("##,###,###,###,##0.00");
		financingReceivablesField.setRequired(false);
		financingReceivablesField.setHidden(false);


		employeeRepaymentField = new DataSourceFloatField("employeeRepayment", "员工还款");
		employeeRepaymentField.setLength(16);
		employeeRepaymentField.setDecimalPad(2);
		employeeRepaymentField.setFormat("##,###,###,###,##0.00");
		employeeRepaymentField.setRequired(false);
		employeeRepaymentField.setHidden(false);


		preCollectionField = new DataSourceFloatField("preCollection", "预收款");
		preCollectionField.setLength(16);
		preCollectionField.setDecimalPad(2);
		preCollectionField.setFormat("##,###,###,###,##0.00");
		preCollectionField.setRequired(false);
		preCollectionField.setHidden(false);


		otherReceivablesField = new DataSourceFloatField("otherReceivables", "其它收款");
		otherReceivablesField.setLength(16);
		otherReceivablesField.setDecimalPad(2);
		otherReceivablesField.setFormat("##,###,###,###,##0.00");
		otherReceivablesField.setRequired(false);
		otherReceivablesField.setHidden(false);


		internalCollectionField = new DataSourceFloatField("internalCollection", "内部收款");
		internalCollectionField.setLength(16);
		internalCollectionField.setDecimalPad(2);
		internalCollectionField.setFormat("##,###,###,###,##0.00");
		internalCollectionField.setRequired(false);
		internalCollectionField.setHidden(false);


		salaryField = new DataSourceFloatField("salary", "薪酬");
		salaryField.setLength(16);
		salaryField.setDecimalPad(2);
		salaryField.setFormat("##,###,###,###,##0.00");
		salaryField.setRequired(false);
		salaryField.setHidden(true);


		projectReimbursementField = new DataSourceFloatField("projectReimbursement", "项目报销");
		projectReimbursementField.setLength(16);
		projectReimbursementField.setDecimalPad(2);
		projectReimbursementField.setFormat("##,###,###,###,##0.00");
		projectReimbursementField.setRequired(false);
		projectReimbursementField.setHidden(false);


		rentPaymentField = new DataSourceFloatField("rentPayment", "房租物业付款");
		rentPaymentField.setLength(16);
		rentPaymentField.setDecimalPad(2);
		rentPaymentField.setFormat("##,###,###,###,##0.00");
		rentPaymentField.setRequired(false);
		rentPaymentField.setHidden(true);


		assetPurchaseField = new DataSourceFloatField("assetPurchase", "资产采购");
		assetPurchaseField.setLength(16);
		assetPurchaseField.setDecimalPad(2);
		assetPurchaseField.setFormat("##,###,###,###,##0.00");
		assetPurchaseField.setRequired(false);
		assetPurchaseField.setHidden(true);


		financingPaymentField = new DataSourceFloatField("financingPayment", "融资付款");
		financingPaymentField.setLength(16);
		financingPaymentField.setDecimalPad(2);
		financingPaymentField.setFormat("##,###,###,###,##0.00");
		financingPaymentField.setRequired(false);
		financingPaymentField.setHidden(true);


		employeeLoanField = new DataSourceFloatField("employeeLoan", "员工借款");
		employeeLoanField.setLength(16);
		employeeLoanField.setDecimalPad(2);
		employeeLoanField.setFormat("##,###,###,###,##0.00");
		employeeLoanField.setRequired(false);
		employeeLoanField.setHidden(false);


		prePaymentField = new DataSourceFloatField("prePayment", "预付款");
		prePaymentField.setLength(16);
		prePaymentField.setDecimalPad(2);
		prePaymentField.setFormat("##,###,###,###,##0.00");
		prePaymentField.setRequired(false);
		prePaymentField.setHidden(false);


		otherPaymentField = new DataSourceFloatField("otherPayment", "其它付款");
		otherPaymentField.setLength(16);
		otherPaymentField.setDecimalPad(2);
		otherPaymentField.setFormat("##,###,###,###,##0.00");
		otherPaymentField.setRequired(false);
		otherPaymentField.setHidden(false);


		internalPaymentField = new DataSourceFloatField("internalPayment", "内部付款");
		internalPaymentField.setLength(16);
		internalPaymentField.setDecimalPad(2);
		internalPaymentField.setFormat("##,###,###,###,##0.00");
		internalPaymentField.setRequired(false);
		internalPaymentField.setHidden(false);


		closingBalanceField = new DataSourceFloatField("closingBalance", "期末余额");
		closingBalanceField.setLength(16);
		closingBalanceField.setDecimalPad(2);
		closingBalanceField.setFormat("##,###,###,###,##0.00");
		closingBalanceField.setRequired(false);
		closingBalanceField.setHidden(false);


		setFields(companyIdField, bankAccountField, initialBalanceField, contractMoneyField, rentReceivablesField, financingReceivablesField, employeeRepaymentField, preCollectionField, otherReceivablesField, internalCollectionField, salaryField, projectReimbursementField, rentPaymentField, assetPurchaseField, financingPaymentField, employeeLoanField, prePaymentField, otherPaymentField, internalPaymentField, closingBalanceField);
	}


}

