package com.pomplatform.client.mcontracticcacccor.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMcontracticcacccor extends DBDataSource
{


	public static DSMcontracticcacccor instance = null;

	public static DSMcontracticcacccor getInstance() {
		if(instance == null) {
			instance = new DSMcontracticcacccor("DSMcontracticcacccor");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceTextField customerNameField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField unReciveMoneyField;
	private final DataSourceFloatField unReciveContractMoneyField;

	public DSMcontracticcacccor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mcontracticcacccor");


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "已开发票金额");
		invoiceAmountField.setLength(16);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("##,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "已收款金额");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		unReciveMoneyField = new DataSourceFloatField("unReciveMoney", "已开发票未收款金额");
		unReciveMoneyField.setLength(18);
		unReciveMoneyField.setDecimalPad(2);
		unReciveMoneyField.setFormat("#,###,###,###,###,##0.00");
		unReciveMoneyField.setRequired(true);
		unReciveMoneyField.setHidden(false);


		unReciveContractMoneyField = new DataSourceFloatField("unReciveContractMoney", "合同未收款金额");
		unReciveContractMoneyField.setLength(18);
		unReciveContractMoneyField.setDecimalPad(2);
		unReciveContractMoneyField.setFormat("#,###,###,###,###,##0.00");
		unReciveContractMoneyField.setRequired(true);
		unReciveContractMoneyField.setHidden(false);


		setFields(contractIdField, contractCodeField, contractNameField, signingMoneySumField, customerNameField, invoiceAmountField, borrowMoneyField, unReciveMoneyField, unReciveContractMoneyField);
	}


}

