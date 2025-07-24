package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

import java.util.LinkedHashMap;

public class DSInvoiceAndPayment extends DBDataSource
{


	public static DSInvoiceAndPayment instance = null;

	public static DSInvoiceAndPayment getInstance() {
		if(instance == null) {
			instance = new DSInvoiceAndPayment("DSInvoiceAndPayment");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceIntegerField selfNameField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceTextField otherNameField;
	private final DataSourceTextField otherBankNameField;
	private final DataSourceTextField otherBankAccountField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField loanMoneyField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField happenDateField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceBooleanField hasInvoicesField;
	private final DataSourceBooleanField hasContractReceivableField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField hasDistributionCollectionField;
	private final DataSourceIntegerField capitalTypeField;
	private final DataSourceIntegerField reimbursementPackageSummaryIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceIntegerField capitalDistributionIdField;
	private final DataSourceBooleanField haveVoucherField;
	private final DataSourceBooleanField recordReceiveCapitalField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceFloatField originalCurrencyField;
	private final DataSourceIntegerField isPaybackField;
	private final DataSourceIntegerField isHavingInvoiceField;

	public DSInvoiceAndPayment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("InvoiceAndPayment");


		capitalIdField = new DataSourceIntegerField("capitalId", "资金表id");
		capitalIdField.setLength(11);
		capitalIdField.setPrimaryKey(true);
		capitalIdField.setRequired(true);
		capitalIdField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(64);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setLength(11);
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setHidden(true);


		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setLength(11);
		selfNameField.setRequired(false);
		selfNameField.setHidden(true);


		selfBankNameField = new DataSourceTextField("selfBankName", "银行名称(收款方)");
		selfBankNameField.setLength(128);
		selfBankNameField.setRequired(false);
		selfBankNameField.setHidden(false);


		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号(收款方)");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(false);


		otherNameField = new DataSourceTextField("otherName", "对方名称(付款方)");
		otherNameField.setLength(128);
		otherNameField.setRequired(false);
		otherNameField.setHidden(false);


		otherBankNameField = new DataSourceTextField("otherBankName", "银行名称(付款方)");
		otherBankNameField.setLength(128);
		otherBankNameField.setRequired(false);
		otherBankNameField.setHidden(true);


		otherBankAccountField = new DataSourceTextField("otherBankAccount", "银行账号(付款方)");
		otherBankAccountField.setLength(128);
		otherBankAccountField.setRequired(false);
		otherBankAccountField.setHidden(true);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "收款金额");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		loanMoneyField = new DataSourceFloatField("loanMoney", "贷（减少）");
		loanMoneyField.setLength(16);
		loanMoneyField.setDecimalPad(2);
		loanMoneyField.setFormat("##,###,###,###,##0.00");
		loanMoneyField.setRequired(false);
		loanMoneyField.setHidden(true);


		operatorField = new DataSourceIntegerField("operator", "操作人id");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);


		happenDateField = new DataSourceDateTimeField("happenDate", "发生日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		createDateField = new DataSourceDateTimeField("createDate", "登记日期");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		hasInvoicesField = new DataSourceBooleanField("hasInvoices", "是否绑定了发票");
		hasInvoicesField.setRequired(false);
		hasInvoicesField.setHidden(true);


		hasContractReceivableField = new DataSourceBooleanField("hasContractReceivable", "是否绑定了合同阶段付款");
		hasContractReceivableField.setRequired(false);
		hasContractReceivableField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(true);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("departments"));


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		hasDistributionCollectionField = new DataSourceBooleanField("hasDistributionCollection", "有分配回款");
		hasDistributionCollectionField.setRequired(false);
		hasDistributionCollectionField.setHidden(true);


		capitalTypeField = new DataSourceIntegerField("capitalType", "资金类型  1 流入  2 流出");
		capitalTypeField.setLength(11);
		capitalTypeField.setRequired(false);
		capitalTypeField.setHidden(true);


		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "打包汇总的流水编码");
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setRequired(false);
		reimbursementPackageSummaryIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 未处于流程  1审批中 2审批完成");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);


		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "回款分配编码");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setRequired(false);
		capitalDistributionIdField.setHidden(true);


		haveVoucherField = new DataSourceBooleanField("haveVoucher", "是否有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(true);


		recordReceiveCapitalField = new DataSourceBooleanField("recordReceiveCapital", "是否记录回款金  用作资金统计用 ture记录(进行统计)");
		recordReceiveCapitalField.setRequired(false);
		recordReceiveCapitalField.setHidden(true);


		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(16);
		exchangeRateField.setDecimalPad(6);
		exchangeRateField.setFormat("#,###,###,##0.000000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(true);


		originalCurrencyField = new DataSourceFloatField("originalCurrency", "原币金额");
		originalCurrencyField.setLength(16);
		originalCurrencyField.setDecimalPad(2);
		originalCurrencyField.setFormat("##,###,###,###,##0.00");
		originalCurrencyField.setRequired(false);
		originalCurrencyField.setHidden(true);

		isPaybackField = new DataSourceIntegerField("isPayback","是否回款");
		isPaybackField.setLength(16);
		isPaybackField.setHidden(true);

		isHavingInvoiceField = new DataSourceIntegerField("isHavingInvoice","是否对应发票");
		isHavingInvoiceField.setLength(30);
		isHavingInvoiceField.setHidden(false);
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "已对应");
		map.put(0, "未对应");
		isHavingInvoiceField.setValueMap(map);

		setFields(capitalIdField, infoCodeField, projectCodeField, contractIdField, contractNameField, contractCodeField, moneyAttributeField, selfNameField, selfBankNameField, selfBankAccountField, otherNameField, otherBankNameField, otherBankAccountField, borrowMoneyField, loanMoneyField, operatorField, happenDateField, createDateField, hasInvoicesField, hasContractReceivableField, employeeNameField, remarkField, hasDistributionCollectionField, capitalTypeField, reimbursementPackageSummaryIdField, processStatusField, capitalDistributionIdField, haveVoucherField, recordReceiveCapitalField, exchangeRateField, originalCurrencyField,isPaybackField,isHavingInvoiceField);
	}


}
