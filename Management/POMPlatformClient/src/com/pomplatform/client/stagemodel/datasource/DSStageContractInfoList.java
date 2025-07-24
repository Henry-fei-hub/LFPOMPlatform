package com.pomplatform.client.stagemodel.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSStageContractInfoList extends DBDataSource
{


	public static DSStageContractInfoList instance = null;

	public static DSStageContractInfoList getInstance() {
		if(instance == null) {
			instance = new DSStageContractInfoList("DSStageContractInfoList");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceFloatField revenueField;
	private final DataSourceFloatField actualPercentField;
	private final DataSourceFloatField calculatePercentField;
	private final DataSourceFloatField invoiceAmountField;
	private final DataSourceFloatField capitalAmountField;
	private final DataSourceIntegerField recordNoField;
	private final DataSourceFloatField revenuePercentField;

	public DSStageContractInfoList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("StageContractInfoList");


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);

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


		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setLength(11);
		contractStatusField.setRequired(false);
		contractStatusField.setHidden(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));


		revenueField = new DataSourceFloatField("revenue", "累积营收");
		revenueField.setLength(18);
		revenueField.setDecimalPad(2);
		revenueField.setFormat("#,###,###,###,###,##0.00");
		revenueField.setRequired(true);
		revenueField.setHidden(false);


		actualPercentField = new DataSourceFloatField("actualPercent", "小节点百分比");
		actualPercentField.setLength(5);
		actualPercentField.setDecimalPad(4);
		actualPercentField.setFormat("#.0000");
		actualPercentField.setRequired(false);
		actualPercentField.setHidden(false);
		
		
		calculatePercentField = new DataSourceFloatField("calculatePercent", "计算出来的百分比");
		calculatePercentField.setLength(5);
		calculatePercentField.setDecimalPad(4);
		calculatePercentField.setFormat("#.0000");
		calculatePercentField.setRequired(false);
		calculatePercentField.setHidden(false);


		invoiceAmountField = new DataSourceFloatField("invoiceAmount", "累积发票");
		invoiceAmountField.setLength(16);
		invoiceAmountField.setDecimalPad(2);
		invoiceAmountField.setFormat("##,###,###,###,##0.00");
		invoiceAmountField.setRequired(false);
		invoiceAmountField.setHidden(false);


		capitalAmountField = new DataSourceFloatField("capitalAmount", "累积回款");
		capitalAmountField.setLength(18);
		capitalAmountField.setDecimalPad(2);
		capitalAmountField.setFormat("#,###,###,###,###,##0.00");
		capitalAmountField.setRequired(true);
		capitalAmountField.setHidden(false);


		recordNoField = new DataSourceIntegerField("recordNo", "业态数量");
		recordNoField.setLength(8);
		recordNoField.setRequired(true);
		recordNoField.setHidden(false);


		revenuePercentField = new DataSourceFloatField("revenuePercent", "营收百分比");
		revenuePercentField.setLength(6);
		revenuePercentField.setDecimalPad(4);
		revenuePercentField.setFormat("##.0000");
		revenuePercentField.setRequired(true);
		revenuePercentField.setHidden(false);


		setFields(contractIdField, contractCodeField, contractNameField, signingMoneySumField, contractStatusField, revenueField, actualPercentField, calculatePercentField, invoiceAmountField, capitalAmountField, recordNoField, revenuePercentField);
	}


}

