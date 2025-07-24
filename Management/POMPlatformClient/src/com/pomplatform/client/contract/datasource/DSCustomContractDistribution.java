package com.pomplatform.client.contract.datasource;

import java.util.LinkedHashMap;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSCustomContractDistribution extends DBDataSource
{


	public static DSCustomContractDistribution instance = null;

	public static DSCustomContractDistribution getInstance() {
		if(instance == null) {
			instance = new DSCustomContractDistribution("DSCustomContractDistribution");
		}
		return instance;
	}

	private final DataSourceIntegerField contractDistributionIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField contractId2Field;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceFloatField amountField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField actualMoneyField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateField contractDateField;
	
	
	public DSCustomContractDistribution(String dataSourceID) {

		super();
		setID(dataSourceID);


		contractDistributionIdField = new DataSourceIntegerField("contractDistributionId", "合同分配团队表ID");
		contractDistributionIdField.setLength(11);
		contractDistributionIdField.setPrimaryKey(true);
		contractDistributionIdField.setRequired(true);
		contractDistributionIdField.setHidden(true);


		contractId2Field = new DataSourceIntegerField("contractId2", "合同编号");
		contractId2Field.setLength(11);
		contractId2Field.setRequired(false);
		contractId2Field.setHidden(false);
		contractId2Field.setCanEdit(false);
//		contractId2Field.setValueMap(KeyValueManager.getValueMap("contracts_2"));
		KeyValueManager.loadValueMap("contracts_2",contractId2Field);

		
		contractIdField = new DataSourceIntegerField("contractId", "合同名称");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
		contractIdField.setCanEdit(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", contractIdField);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setCanEdit(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);
		operatorField.setCanEdit(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		amountField = new DataSourceFloatField("amount", "提成");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);
		amountField.setCanEdit(false);
		
		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(18);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("#,###,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);
		signingMoneySumField.setCanEdit(false);
		
		actualMoneyField = new DataSourceFloatField("actualMoney", "分配金额");
		actualMoneyField.setLength(18);
		actualMoneyField.setDecimalPad(2);
		actualMoneyField.setFormat("#,###,###,###,###,##0.00");
		actualMoneyField.setRequired(false);
		actualMoneyField.setHidden(false);
		actualMoneyField.setCanEdit(true);

		
		plateIdField = new DataSourceIntegerField("plateId", "营销团队");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setCanEdit(true);
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(36, "营销一部");
		map.put(37, "营销八部");
		map.put(38, "营销五部");
		map.put(39, "营销二部");
		map.put(40, "营销三部");
		map.put(63, "营销六部");
		map.put(35, "轨交拓展一部");
		map.put(33, "营销四部");
		map.put(34, "营销七部");
		map.put(32, "轨交拓展二部");
		map.put(43, "投标组"); 
		plateIdField.setValueMap(map);
		
		
		contractDateField = new DataSourceDateField("contractDate", "合同签订日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(false);
		
		
		setFields(contractDistributionIdField, contractId2Field, contractIdField, signingMoneySumField, actualMoneyField, businessTypeField, plateIdField, amountField, operatorField, contractDateField);
	}


}

