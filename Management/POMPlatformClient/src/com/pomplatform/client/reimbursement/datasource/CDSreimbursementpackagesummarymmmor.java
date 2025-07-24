package com.pomplatform.client.reimbursement.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSreimbursementpackagesummarymmmor extends DataSource
{


	public static CDSreimbursementpackagesummarymmmor instance = null;

	public static CDSreimbursementpackagesummarymmmor getInstance() {
		if(instance == null) {
			instance = new CDSreimbursementpackagesummarymmmor("CDSreimbursementpackagesummarymmmor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceDateTimeField minUpdateTimeField;
	private final DataSourceDateTimeField maxUpdateTimeField;
	private final DataSourceIntegerField otherNameField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField paymentAmountField;
	private final DataSourceFloatField strikeABalanceAmountField;
	private final DataSourceBooleanField isCompletedField;
	private final DataSourceTextField payeeNameField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceTextField otherBankNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField reimbursementPackageIdField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField payForField;
	private final DataSourceIntegerField employeeOrCompanyIdField;

	public CDSreimbursementpackagesummarymmmor(String dataSourceID) {

		setID(dataSourceID);
		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早开始时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚开始时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		minUpdateTimeField = new DataSourceDateTimeField("minUpdateTime", "最早修改时间");
		minUpdateTimeField.setRequired(false);
		minUpdateTimeField.setHidden(false);

		maxUpdateTimeField = new DataSourceDateTimeField("maxUpdateTime", "最晚修改时间");
		maxUpdateTimeField.setRequired(false);
		maxUpdateTimeField.setHidden(false);

		otherNameField = new DataSourceIntegerField("otherName", "付款方  system_dictionary_69");
		otherNameField.setRequired(false);
		otherNameField.setLength(11);
		otherNameField.setHidden(false);

		amountField = new DataSourceFloatField("amount", "总金额");
		amountField.setRequired(true);
		amountField.setLength(18);
		amountField.setHidden(false);

		paymentAmountField = new DataSourceFloatField("paymentAmount", "付款金额");
		paymentAmountField.setRequired(true);
		paymentAmountField.setLength(18);
		paymentAmountField.setHidden(false);

		strikeABalanceAmountField = new DataSourceFloatField("strikeABalanceAmount", "冲账金额");
		strikeABalanceAmountField.setRequired(true);
		strikeABalanceAmountField.setLength(18);
		strikeABalanceAmountField.setHidden(false);

		isCompletedField = new DataSourceBooleanField("isCompleted", "是否完成");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(false);

		payeeNameField = new DataSourceTextField("payeeName", "收款方");
		payeeNameField.setRequired(false);
		payeeNameField.setLength(128);
		payeeNameField.setHidden(false);

		selfBankNameField = new DataSourceTextField("selfBankName", "银行名称(收款方)");
		selfBankNameField.setRequired(false);
		selfBankNameField.setLength(128);
		selfBankNameField.setHidden(false);

		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setLength(128);
		selfBankAccountField.setHidden(false);

		otherBankNameField = new DataSourceTextField("otherBankName", "银行名称(付款方)");
		otherBankNameField.setRequired(false);
		otherBankNameField.setLength(128);
		otherBankNameField.setHidden(false);

		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setLength(128);
		otherBankAccountField.setHidden(false);

		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageSummaryIdField.setRequired(true);
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setPrimaryKey(true);
		reimbursementPackageSummaryIdField.setHidden(true);

		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setHidden(false);

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setLength(11);
		moneyAttributeField.setHidden(false);

		payForField = new DataSourceIntegerField("payFor", "1 员工  2收款单位");
		payForField.setRequired(false);
		payForField.setLength(11);
		payForField.setHidden(false);

		employeeOrCompanyIdField = new DataSourceIntegerField("employeeOrCompanyId", "员工或者收款单位Id");
		employeeOrCompanyIdField.setRequired(false);
		employeeOrCompanyIdField.setLength(11);
		employeeOrCompanyIdField.setHidden(false);

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


		setFields(minCreateTimeField, maxCreateTimeField, minUpdateTimeField, maxUpdateTimeField, otherNameField, amountField, paymentAmountField, strikeABalanceAmountField, isCompletedField, payeeNameField, selfBankNameField, selfBankAccountField, otherBankNameField, otherBankAccountField, reimbursementPackageSummaryIdField, reimbursementPackageIdField, moneyAttributeField, payForField, employeeOrCompanyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

