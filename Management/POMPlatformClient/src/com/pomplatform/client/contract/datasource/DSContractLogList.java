package com.pomplatform.client.contract.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractLogList extends DBDataSource
{


	public static DSContractLogList instance = null;

	public static DSContractLogList getInstance() {
		if(instance == null) {
			instance = new DSContractLogList("DSContractLogList");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceIntegerField signingCompanyNameField;
	private final DataSourceIntegerField originalStatusField;
	private final DataSourceIntegerField newStatusField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateField operateTimeField;

	public DSContractLogList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractLogList");


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


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


		signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "我方签约公司名称");
		signingCompanyNameField.setLength(11);
		signingCompanyNameField.setRequired(false);
		signingCompanyNameField.setHidden(false);
		signingCompanyNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		originalStatusField = new DataSourceIntegerField("originalStatus", "原始合同状态");
		originalStatusField.setLength(11);
		originalStatusField.setRequired(false);
		originalStatusField.setHidden(false);
		originalStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));


		newStatusField = new DataSourceIntegerField("newStatus", "新合同状态");
		newStatusField.setLength(11);
		newStatusField.setRequired(false);
		newStatusField.setHidden(false);
		newStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_35"));


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		operateTimeField = new DataSourceDateField("operateTime", "操作日期");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		setFields(contractIdField, contractCodeField, contractNameField, customerNameField, signingMoneySumField, signingCompanyNameField, originalStatusField, newStatusField, operatorField, operateTimeField);
	}


}

