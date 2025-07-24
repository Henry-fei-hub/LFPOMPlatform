package com.pomplatform.client.receiveunit.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMreceiveunitmanagepsrbbor extends DBDataSource
{


	public static DSMreceiveunitmanagepsrbbor instance = null;

	public static DSMreceiveunitmanagepsrbbor getInstance() {
		if(instance == null) {
			instance = new DSMreceiveunitmanagepsrbbor("DSMreceiveunitmanagepsrbbor");
		}
		return instance;
	}

	private final DataSourceTextField receiveUnitField;
	private final DataSourceFloatField payMoneyField;
	private final DataSourceFloatField balanceAmountField;
	private final DataSourceFloatField initialBalanceField;
	private final DataSourceFloatField balanceField;

	public DSMreceiveunitmanagepsrbbor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mreceiveunitmanagepsrbbor");


		receiveUnitField = new DataSourceTextField("receiveUnit", "收款单位");
		receiveUnitField.setLength(128);
		receiveUnitField.setRequired(false);
		receiveUnitField.setHidden(false);


		payMoneyField = new DataSourceFloatField("payMoney", "付款金额");
		payMoneyField.setLength(16);
		payMoneyField.setDecimalPad(2);
		payMoneyField.setFormat("##,###,###,###,##0.00");
		payMoneyField.setRequired(false);
		payMoneyField.setHidden(false);


		balanceAmountField = new DataSourceFloatField("balanceAmount", "冲账金额");
		balanceAmountField.setLength(16);
		balanceAmountField.setDecimalPad(2);
		balanceAmountField.setFormat("##,###,###,###,##0.00");
		balanceAmountField.setRequired(false);
		balanceAmountField.setHidden(false);


		initialBalanceField = new DataSourceFloatField("initialBalance", "期初金额");
		initialBalanceField.setLength(16);
		initialBalanceField.setDecimalPad(2);
		initialBalanceField.setFormat("##,###,###,###,##0.00");
		initialBalanceField.setRequired(true);
		initialBalanceField.setHidden(false);


		balanceField = new DataSourceFloatField("balance", "余额");
		balanceField.setLength(18);
		balanceField.setDecimalPad(2);
		balanceField.setFormat("#,###,###,###,###,##0.00");
		balanceField.setRequired(true);
		balanceField.setHidden(false);


		setFields(receiveUnitField, initialBalanceField, payMoneyField, balanceAmountField, balanceField);
	}


}

