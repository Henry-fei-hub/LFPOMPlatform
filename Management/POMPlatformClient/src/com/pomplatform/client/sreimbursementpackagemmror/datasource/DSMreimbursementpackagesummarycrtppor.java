package com.pomplatform.client.sreimbursementpackagemmror.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMreimbursementpackagesummarycrtppor extends DBDataSource {

	public static DSMreimbursementpackagesummarycrtppor instance = null;

	public static DSMreimbursementpackagesummarycrtppor getInstance() {
		if (instance == null) {
			instance = new DSMreimbursementpackagesummarycrtppor("DSMreimbursementpackagesummarycrtppor");
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
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceIntegerField payTypeField;
	private final DataSourceIntegerField cmbcPaymentIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceTextField yurrefField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceIntegerField totalNumField;
	private final DataSourceIntegerField payStatusField;
	private final DataSourceIntegerField payResultField;
	private final DataSourceTextField errorMsgField;
	private final DataSourceDateTimeField epttimField;
	private final DataSourceIntegerField successTotalAmountField;
	private final DataSourceIntegerField successTotalNumField;
	private final DataSourceDateTimeField oprdatField;

	public DSMreimbursementpackagesummarycrtppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mreimbursementpackagesummarycrtppor");

		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "报销打包汇总表编码");
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setPrimaryKey(true);
		reimbursementPackageSummaryIdField.setRequired(true);
		reimbursementPackageSummaryIdField.setHidden(true);

		reimbursementPackageIdField = new DataSourceIntegerField("reimbursementPackageId", "报销打包表编码");
		reimbursementPackageIdField.setLength(11);
		reimbursementPackageIdField.setRequired(false);
		reimbursementPackageIdField.setHidden(true);
		reimbursementPackageIdField.setForeignKey("DSSreimbursementpackagemmror.reimbursementPackageId");

		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setLength(11);
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setHidden(true);

		payForField = new DataSourceIntegerField("payFor", "1 员工  2收款单位");
		payForField.setLength(11);
		payForField.setRequired(false);
		payForField.setHidden(true);

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
		selfBankNameField.setHidden(false);

		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(false);

		otherNameField = new DataSourceIntegerField("otherName", "付款方");
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
		strikeABalanceAmountField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "开始时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);

		isCompletedField = new DataSourceBooleanField("isCompleted", "是否完成");
		isCompletedField.setRequired(false);
		isCompletedField.setHidden(true);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

		yearField = new DataSourceIntegerField("year", "年(用于记录薪资与奖金的发放年份)");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(true);

		monthField = new DataSourceIntegerField("month", "月(用于记录薪资与奖金的发放月份)");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(true);

		payTypeField = new DataSourceIntegerField("payType", "付款类型 0普通付款 1薪资发放  2奖金发放");
		payTypeField.setLength(11);
		payTypeField.setRequired(false);
		payTypeField.setHidden(true);

		java.util.Map<String, String> payTypeValues = new java.util.HashMap<String, String>();
		payTypeValues.put("支付宝", "2");
		payTypeValues.put("Paypal", "1");
		payTypeField.setValueMap(payTypeValues);

		cmbcPaymentIdField = new DataSourceIntegerField("cmbcPaymentId", "多对1(支付主表编码)");
		cmbcPaymentIdField.setLength(11);
		cmbcPaymentIdField.setRequired(false);
		cmbcPaymentIdField.setHidden(true);

		typeField = new DataSourceIntegerField("type", "支付类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_133"));

		yurrefField = new DataSourceTextField("yurref", "业务参考号");
		yurrefField.setLength(255);
		yurrefField.setRequired(false);
		yurrefField.setHidden(false);

		totalAmountField = new DataSourceFloatField("totalAmount", "总金额(代发)");
		totalAmountField.setLength(16);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("##,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);

		totalNumField = new DataSourceIntegerField("totalNum", "总笔数(代发)");
		totalNumField.setLength(11);
		totalNumField.setRequired(false);
		totalNumField.setHidden(false);

		payStatusField = new DataSourceIntegerField("payStatus", "支付状态");
		payStatusField.setLength(11);
		payStatusField.setRequired(false);
		payStatusField.setHidden(false);
		payStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_135"));

		payResultField = new DataSourceIntegerField("payResult", "支付结果");
		payResultField.setLength(11);
		payResultField.setRequired(false);
		payResultField.setHidden(false);
		payResultField.setValueMap(KeyValueManager.getValueMap("system_dictionary_136"));

		errorMsgField = new DataSourceTextField("errorMsg", "提示信息");
		errorMsgField.setLength(1000);
		errorMsgField.setRequired(false);
		errorMsgField.setHidden(false);

		epttimField = new DataSourceDateTimeField("epttim", "期望时间");
		epttimField.setRequired(false);
		epttimField.setHidden(false);

		successTotalAmountField = new DataSourceIntegerField("successTotalAmount", "成功总金额(代发)");
		successTotalAmountField.setLength(255);
		successTotalAmountField.setRequired(true);
		successTotalAmountField.setHidden(false);

		successTotalNumField = new DataSourceIntegerField("successTotalNum", "成功总笔数(代发)");
		successTotalNumField.setLength(11);
		successTotalNumField.setRequired(false);
		successTotalNumField.setHidden(false);

		oprdatField = new DataSourceDateTimeField("oprdat", "经办日期");
		oprdatField.setRequired(false);
		oprdatField.setHidden(true);

		setFields(reimbursementPackageSummaryIdField, reimbursementPackageIdField, moneyAttributeField, payForField,
				employeeOrCompanyIdField, payeeNameField, selfBankNameField, selfBankAccountField, amountField,
				paymentAmountField, otherNameField, otherBankNameField, otherBankAccountField,
				strikeABalanceAmountField, createTimeField, updateTimeField, isCompletedField, companyIdField,
				yearField, monthField, payTypeField, cmbcPaymentIdField, typeField, yurrefField, totalAmountField,
				totalNumField, payStatusField, payResultField, errorMsgField, epttimField, successTotalAmountField,
				successTotalNumField, oprdatField);
	}

}
