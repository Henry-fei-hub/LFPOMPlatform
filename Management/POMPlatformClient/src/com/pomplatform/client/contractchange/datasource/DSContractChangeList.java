package com.pomplatform.client.contractchange.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractChangeList extends DBDataSource
{


	public static DSContractChangeList instance = null;

	public static DSContractChangeList getInstance() {
		if(instance == null) {
			instance = new DSContractChangeList("DSContractChangeList");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceIntegerField flagField;
	private final DataSourceDateTimeField operateTimeField;

	public DSContractChangeList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractChangeList");


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


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		flagField = new DataSourceIntegerField("flag", "状态");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(false);

		java.util.Map<String,String> flagValues = new java.util.HashMap<String,String>();
		flagValues.put("2", "驳回");
		flagValues.put("3", "待审核");
		flagValues.put("1", "草稿");
		flagValues.put("4", "已审核");
		flagField.setValueMap(flagValues);
		
		operateTimeField = new DataSourceDateTimeField("operateTime","操作时间");
		operateTimeField.setLength(64);

		setFields(contractIdField, contractCodeField, contractNameField, customerNameField, signingMoneySumField, flagField,operateTimeField);
	}


}

