package com.pomplatform.client.reimbursement.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSreimbursementpackagesummarymmmor extends DBDataSource
{


	public static DSSreimbursementpackagesummarymmmor instance = null;

	public static DSSreimbursementpackagesummarymmmor getInstance() {
		if(instance == null) {
			instance = new DSSreimbursementpackagesummarymmmor("DSSreimbursementpackagesummarymmmor");
		}
		return instance;
	}

	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField payForField;
	private final DataSourceIntegerField employeeOrCompanyIdField;
	private final DataSourceTextField payeeNameField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceIntegerField otherNameField;
	private final DataSourceTextField otherBankNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField paymentAmountField;
	private final DataSourceFloatField strikeABalanceAmountField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceBooleanField isCompletedField;

	public DSSreimbursementpackagesummarymmmor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sreimbursementpackagesummarymmmor");


		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setPrimaryKey(true);
		reimbursementPackageSummaryIdField.setRequired(true);
		reimbursementPackageSummaryIdField.setHidden(true);


		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setHidden(true);


		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setLength(11);
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setHidden(true);


		payForField = new DataSourceIntegerField("payFor", "收款方类型");
		payForField.setLength(11);
		payForField.setRequired(false);
		payForField.setHidden(false);
		payForField.setValueMap(KeyValueManager.getValueMap("system_dictionary_67"));


		employeeOrCompanyIdField = new DataSourceIntegerField("employeeOrCompanyId", "员工或者收款单位Id");
		employeeOrCompanyIdField.setLength(11);
		employeeOrCompanyIdField.setRequired(false);
		employeeOrCompanyIdField.setHidden(true);


		payeeNameField = new DataSourceTextField("payeeName", "收款方");
		payeeNameField.setLength(128);
		payeeNameField.setRequired(false);
		payeeNameField.setHidden(false);


		selfBankNameField = new DataSourceTextField("selfBankName", "银行名称(收款方)");
		selfBankNameField.setLength(128);
		selfBankNameField.setRequired(false);
		selfBankNameField.setHidden(true);


		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(true);


		otherNameField = new DataSourceIntegerField("otherName", "付款方(公司)");
		otherNameField.setLength(11);
		otherNameField.setRequired(false);
		otherNameField.setHidden(false);  
		otherNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_69"));

		otherBankNameField = new DataSourceTextField("otherBankName", "银行名称(付款方)");
		otherBankNameField.setLength(128);
		otherBankNameField.setRequired(false);
		otherBankNameField.setHidden(false);


		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setLength(128);
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "总金额");
		amountField.setLength(18);
		amountField.setDecimalPad(5);
		amountField.setFormat("#,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		paymentAmountField = new DataSourceFloatField("paymentAmount", "付款金额");
		paymentAmountField.setLength(18);
		paymentAmountField.setDecimalPad(5);
		paymentAmountField.setFormat("#,###,###,###,##0.00");
		paymentAmountField.setRequired(false);
		paymentAmountField.setHidden(false);


		strikeABalanceAmountField = new DataSourceFloatField("strikeABalanceAmount", "冲账金额");
		strikeABalanceAmountField.setLength(18);
		strikeABalanceAmountField.setDecimalPad(5);
		strikeABalanceAmountField.setFormat("#,###,###,###,##0.00");
		strikeABalanceAmountField.setRequired(false);
		strikeABalanceAmountField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "开始时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "付款时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(false);


		isCompletedField = new DataSourceBooleanField("isCompleted", "是否完成");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(true);


		setFields(reimbursementPackageSummaryIdField, reimbursementPackageIdField, moneyAttributeField, payForField, employeeOrCompanyIdField, payeeNameField, selfBankNameField, selfBankAccountField, otherNameField, otherBankNameField, otherBankAccountField, amountField, paymentAmountField, strikeABalanceAmountField, createTimeField, updateTimeField, isCompletedField);
	}


}

