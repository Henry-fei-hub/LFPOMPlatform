package com.pomplatform.client.receivables.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMcapitalecoosmeor extends DBDataSource {

	public static DSMcapitalecoosmeor instance = null;

	public static DSMcapitalecoosmeor getInstance() {
		if (instance == null) {
			instance = new DSMcapitalecoosmeor("DSMcapitalecoosmeor");
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
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceFloatField originalCurrencyField;
	private final DataSourceTextField fileUrlField;
	private final DataSourceDateField issueDateField;
	private final DataSourceDateField expireDateField;
	private final DataSourceIntegerField receiveUnitIdField;
	private final DataSourceTextField receiveUnitField;
	private final DataSourceFloatField actualAmountField;
	private final DataSourceDateField actualReceiveDateField;

	public DSMcapitalecoosmeor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcapitalecoosmeor");

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

		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdField);
		contractIdField.setForeignKey("DSMItemCollection.contractId");

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
		moneyAttributeField.setHidden(false);
		moneyAttributeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));

		selfNameField = new DataSourceIntegerField("selfName", "内部公司(收款方)");
		selfNameField.setLength(11);
		selfNameField.setRequired(false);
		selfNameField.setHidden(false);
		selfNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));

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

		borrowMoneyField = new DataSourceFloatField("borrowMoney", "借（增加）");
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
		loanMoneyField.setHidden(false);

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
		hasInvoicesField.setHidden(false);

		hasContractReceivableField = new DataSourceBooleanField("hasContractReceivable", "是否绑定了合同阶段付款");
		hasContractReceivableField.setRequired(false);
		hasContractReceivableField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "登记人");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(64);
		remarkField.setRequired(true);
		remarkField.setHidden(false);

		hasDistributionCollectionField = new DataSourceBooleanField("hasDistributionCollection", "是否分配收款");
		hasDistributionCollectionField.setRequired(false);
		hasDistributionCollectionField.setHidden(false);

		capitalTypeField = new DataSourceIntegerField("capitalType", "款项类型");
		capitalTypeField.setLength(11);
		capitalTypeField.setRequired(false);
		capitalTypeField.setHidden(true);

		reimbursementPackageSummaryIdField = new DataSourceIntegerField("reimbursementPackageSummaryId", "打包汇总主键");
		reimbursementPackageSummaryIdField.setLength(11);
		reimbursementPackageSummaryIdField.setRequired(false);
		reimbursementPackageSummaryIdField.setHidden(true);

		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		map.put("0", "未分配");
		map.put("1", "分配中");
		map.put("2", "分配完成");
		map.put("3", "(财务)完成分配");
		processStatusField.setValueMap(map);

		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "分配主键");
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setRequired(false);
		capitalDistributionIdField.setHidden(true);

		haveVoucherField = new DataSourceBooleanField("haveVoucher", "已有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(false);

		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(16);
		exchangeRateField.setDecimalPad(6);
		exchangeRateField.setFormat("##,###,###,###,##0.0000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(true);
		
		originalCurrencyField = new DataSourceFloatField("originalCurrency", "原币金额");
		originalCurrencyField.setLength(16);
		originalCurrencyField.setDecimalPad(6);
		originalCurrencyField.setFormat("##,###,###,###,##0.00");
		originalCurrencyField.setRequired(false);
		originalCurrencyField.setHidden(false);

		fileUrlField = new DataSourceTextField("fileUrl" , "附件地址");
		fileUrlField.setHidden(false);
		
		issueDateField = new DataSourceDateField("issueDate", "出票日期");
		issueDateField.setRequired(false);
		issueDateField.setHidden(false);
		
		expireDateField = new DataSourceDateField("expireDate", "到期日");
		expireDateField.setRequired(false);
		expireDateField.setHidden(false);

		receiveUnitIdField = new DataSourceIntegerField("receiveUnitId", "实际客户ID");
		receiveUnitIdField.setLength(11);
		receiveUnitIdField.setRequired(false);
		receiveUnitIdField.setHidden(true);
		
		receiveUnitField = new DataSourceTextField("receiveUnit", "实际客户名称");
		receiveUnitField.setLength(64);
		receiveUnitField.setRequired(true);
		receiveUnitField.setHidden(false);
		
		actualAmountField = new DataSourceFloatField("actualAmount", "实际到账金额");
		actualAmountField.setLength(16);
		actualAmountField.setDecimalPad(2);
		actualAmountField.setFormat("##,###,###,###,##0.00");
		actualAmountField.setRequired(false);
		actualAmountField.setHidden(false);
		
		actualReceiveDateField = new DataSourceDateField("actualReceiveDate", "实际到账日期");
		actualReceiveDateField.setRequired(false);
		actualReceiveDateField.setHidden(false);

		setFields(capitalTypeField, haveVoucherField, reimbursementPackageSummaryIdField, capitalDistributionIdField,
				capitalIdField, infoCodeField, projectCodeField, contractIdField, contractNameField, contractCodeField,
				moneyAttributeField, selfNameField, selfBankNameField, selfBankAccountField, otherNameField,
				otherBankNameField, otherBankAccountField, borrowMoneyField, loanMoneyField, operatorField,
				happenDateField, createDateField, hasInvoicesField, hasContractReceivableField,
				hasDistributionCollectionField, processStatusField, employeeNameField, remarkField,
				exchangeRateField, originalCurrencyField,fileUrlField, issueDateField, expireDateField, 
				receiveUnitIdField, receiveUnitField, actualAmountField, actualReceiveDateField);
	}

}
