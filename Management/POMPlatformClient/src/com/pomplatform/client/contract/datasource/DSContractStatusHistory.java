package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractStatusHistory extends DBDataSource
{


	public static DSContractStatusHistory instance = null;

	public static DSContractStatusHistory getInstance() {
		if(instance == null) {
			instance = new DSContractStatusHistory("DSContractStatusHistory");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceIntegerField signingCompanyNameField;
	private final DataSourceIntegerField contractStatusField;
	private final DataSourceDateField operateTimeField;

	public DSContractStatusHistory(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractStatusHistory");


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractIdField);


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


		signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "我方签约公司");
		signingCompanyNameField.setLength(11);
		signingCompanyNameField.setRequired(false);
		signingCompanyNameField.setHidden(false);
		signingCompanyNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		contractStatusField = new DataSourceIntegerField("contractStatus", "合同状态");
		contractStatusField.setLength(11);
		contractStatusField.setRequired(false);
		contractStatusField.setHidden(false);
		contractStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));

		
		operateTimeField = new DataSourceDateField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		setFields(contractIdField, contractCodeField, contractNameField, customerNameField, signingMoneySumField, signingCompanyNameField, contractStatusField, operateTimeField);
	}


}

