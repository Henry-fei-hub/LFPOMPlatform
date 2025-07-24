package com.pomplatform.client.workflow.contractstatus.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSChangeContractStatus extends DBDataSource
{


	public static DSChangeContractStatus instance = null;

	public static DSChangeContractStatus getInstance() {
		if(instance == null) {
			instance = new DSChangeContractStatus("DSChangeContractStatus");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField revenueAmountField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceIntegerField workflowNumField;

	public DSChangeContractStatus(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ChangeContractStatus");


		contractIdField = new DataSourceIntegerField("contractId", "合同ID");
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


		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setLength(11);
		contractStatusField.setRequired(false);
		contractStatusField.setHidden(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		revenueAmountField = new DataSourceFloatField("revenueAmount", "累积含税营收");
		revenueAmountField.setLength(18);
		revenueAmountField.setDecimalPad(2);
		revenueAmountField.setFormat("#,###,###,###,###,##0.00");
		revenueAmountField.setRequired(true);
		revenueAmountField.setHidden(false);


		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "开票金额");
		invoiceAmountField.setLength(16);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("##,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "总回款金额");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		workflowNumField = new DataSourceIntegerField("workflowNum", "本合同正在进行中的合同变更流程数量");
		workflowNumField.setLength(8);
		workflowNumField.setRequired(true);
		workflowNumField.setHidden(false);


		setFields(contractIdField, contractCodeField, contractNameField, contractStatusField, signingMoneySumField, revenueAmountField, invoiceAmountField, borrowMoneyField, workflowNumField);
	}


}

