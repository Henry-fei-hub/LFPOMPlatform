package com.pomplatform.client.k3voucher.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSGenerateCapitalVoucher extends DBDataSource
{


	public static DSGenerateCapitalVoucher instance = null;

	public static DSGenerateCapitalVoucher getInstance() {
		if(instance == null) {
			instance = new DSGenerateCapitalVoucher("DSGenerateCapitalVoucher");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField moneyAttributeField;
	private final DataSourceBooleanField haveVoucherField;
	private final DataSourceTextField selfBankNameField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceTextField otherNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField loanMoneyField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceFloatField originalCurrencyField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceDateField happenDateField;
	private final DataSourceDateField createDateField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField remarkField;

	public DSGenerateCapitalVoucher(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("GenerateCapitalVoucher");


		capitalIdField = new DataSourceIntegerField("capitalId", "资金表id");
		capitalIdField.setLength(11);
		capitalIdField.setPrimaryKey(true);
		capitalIdField.setRequired(true);
		capitalIdField.setHidden(true);


		moneyAttributeField = new DataSourceIntegerField("moneyAttribute", "款项属性");
		moneyAttributeField.setLength(11);
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setHidden(false);
		moneyAttributeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));


		haveVoucherField = new DataSourceBooleanField("haveVoucher", "是否有凭证");
		haveVoucherField.setRequired(false);
		haveVoucherField.setHidden(true);


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


		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(16);
		exchangeRateField.setDecimalPad(6);
		exchangeRateField.setFormat("#,###,###,##0.000000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(false);


		originalCurrencyField = new DataSourceFloatField("originalCurrency", "原币金额");
		originalCurrencyField.setLength(16);
		originalCurrencyField.setDecimalPad(2);
		originalCurrencyField.setFormat("##,###,###,###,##0.00");
		originalCurrencyField.setRequired(false);
		originalCurrencyField.setHidden(false);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		happenDateField = new DataSourceDateField("happenDate", "发生日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		createDateField = new DataSourceDateField("createDate", "登记日期");
		createDateField.setRequired(false);
		createDateField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "登记人");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);
		employeeNameField.setValueMap(KeyValueManager.getValueMap("employees"));


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(capitalIdField, moneyAttributeField, haveVoucherField, selfBankNameField, selfBankAccountField, otherNameField, borrowMoneyField, loanMoneyField, exchangeRateField, originalCurrencyField, contractCodeField, happenDateField, createDateField, employeeNameField, remarkField);
	}


}

