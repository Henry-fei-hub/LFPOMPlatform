package com.pomplatform.client.contract.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractManage extends DBDataSource
{


	public static DSContractManage instance = null;

	public static DSContractManage getInstance() {
		if(instance == null) {
			instance = new DSContractManage("DSContractManage");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceIntegerField signingCompanyNameField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceTextField financialContractCodeField;
	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField customerNameField;

	public DSContractManage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractManage");


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setPrimaryKey(true);
		contractIdField.setRequired(true);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractIdField);


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
		contractCodeField.setCanEdit(false);

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);
		contractNameField.setCanEdit(false);

		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);
		signingMoneySumField.setCanEdit(false);


		signingCompanyNameField = new DataSourceIntegerField("signingCompanyName", "签约公司");
		signingCompanyNameField.setLength(11);
		signingCompanyNameField.setRequired(false);
		signingCompanyNameField.setHidden(false);
		signingCompanyNameField.setCanEdit(false);
		signingCompanyNameField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);
		infoCodeField.setCanEdit(false);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);
		operatorField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));


		financialContractCodeField = new DataSourceTextField("financialContractCode", "财务合同编号");
		financialContractCodeField.setLength(64);
		financialContractCodeField.setRequired(false);
		financialContractCodeField.setHidden(false);
		
		
		customerIdField = new DataSourceIntegerField("customerId", "客户");
		customerIdField.setLength(11);
		customerIdField.setRequired(false);
		customerIdField.setHidden(false);
//		customerIdField.setValueMap(KeyValueManager.getValueMap("customers"));
		KeyValueManager.loadValueMap("customers",customerIdField);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(64);
		customerNameField.setRequired(false);
		customerNameField.setHidden(true);


		setFields(contractIdField, contractCodeField, financialContractCodeField, contractNameField, signingCompanyNameField, signingMoneySumField, updateTimeField, infoCodeField, operatorField, customerIdField, customerNameField);
	}


}

