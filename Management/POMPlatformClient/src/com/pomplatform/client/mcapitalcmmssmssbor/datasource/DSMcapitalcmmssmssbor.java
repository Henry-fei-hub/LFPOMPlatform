package com.pomplatform.client.mcapitalcmmssmssbor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcapitalcmmssmssbor extends DBDataSource
{


	public static DSMcapitalcmmssmssbor instance = null;

	public static DSMcapitalcmmssmssbor getInstance() {
		if(instance == null) {
			instance = new DSMcapitalcmmssmssbor("DSMcapitalcmmssmssbor");
		}
		return instance;
	}

	private final DataSourceIntegerField selfNameField;
	private final DataSourceTextField bankAddressField;
	private final DataSourceTextField selfBankAccountField;
	private final DataSourceFloatField beforeMoneyField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField loanMoneyField;
	private final DataSourceFloatField balanceField;
	private final DataSourceIntegerField currencyTypeField;

	public DSMcapitalcmmssmssbor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcapitalcmmssmssbor");


		selfNameField = new DataSourceIntegerField("selfName", "内部公司");
		selfNameField.setLength(11);
		selfNameField.setRequired(false);
		selfNameField.setHidden(false);
		selfNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_69"));


		bankAddressField = new DataSourceTextField("bankAddress", "银行名称");
		bankAddressField.setLength(128);
		bankAddressField.setRequired(false);
		bankAddressField.setHidden(false);


		selfBankAccountField = new DataSourceTextField("selfBankAccount", "银行账号");
		selfBankAccountField.setLength(128);
		selfBankAccountField.setRequired(false);
		selfBankAccountField.setHidden(false);


		beforeMoneyField = new DataSourceFloatField("beforeMoney", "期初余额");
		beforeMoneyField.setLength(18);
		beforeMoneyField.setDecimalPad(2);
		beforeMoneyField.setFormat("#,###,###,###,###,##0.00");
		beforeMoneyField.setRequired(true);
		beforeMoneyField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "本期收入");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		loanMoneyField = new DataSourceFloatField("loanMoney", "本期支出");
		loanMoneyField.setLength(16);
		loanMoneyField.setDecimalPad(2);
		loanMoneyField.setFormat("##,###,###,###,##0.00");
		loanMoneyField.setRequired(false);
		loanMoneyField.setHidden(false);


		balanceField = new DataSourceFloatField("balance", "本期余额");
		balanceField.setLength(18);
		balanceField.setDecimalPad(2);
		balanceField.setFormat("#,###,###,###,###,##0.00");
		balanceField.setRequired(true);
		balanceField.setHidden(false);
		
		currencyTypeField = new DataSourceIntegerField("currencyType", "货币类型");
		currencyTypeField.setLength(11);
		currencyTypeField.setRequired(false);
		currencyTypeField.setHidden(false);
		currencyTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));


		setFields(selfNameField, bankAddressField, selfBankAccountField, beforeMoneyField, borrowMoneyField, loanMoneyField, balanceField, currencyTypeField);
	}


}

