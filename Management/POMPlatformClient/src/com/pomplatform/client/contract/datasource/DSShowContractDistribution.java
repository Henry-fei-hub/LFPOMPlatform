package com.pomplatform.client.contract.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.*;

public class DSShowContractDistribution extends DBDataSource
{


	public static DSShowContractDistribution instance = null;

	public static DSShowContractDistribution getInstance() {
		if(instance == null) {
			instance = new DSShowContractDistribution("DSShowContractDistribution");
		}
		return instance;
	}

	private final DataSourceIntegerField contractDistributionIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceFloatField  amountField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField updateTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceDateField contractDateField;
	private final DataSourceFloatField actualMoneyField;
	private final DataSourceTextField orderIdField;
	private final DataSourceIntegerField operationManagerIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceFloatField rateOfProgressField;

	public DSShowContractDistribution(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ShowContractDistributionNew");


		contractDistributionIdField = new DataSourceIntegerField("contractDistributionId", "主键编码");
		contractDistributionIdField.setLength(11);
		contractDistributionIdField.setPrimaryKey(true);
		contractDistributionIdField.setRequired(true);
		contractDistributionIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		amountField = new DataSourceFloatField("amount", "项目积分");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(false);
		amountField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		contractDateField = new DataSourceDateField("contractDate", "合同签订日期");
		contractDateField.setRequired(false);
		contractDateField.setHidden(true);


		actualMoneyField = new DataSourceFloatField("actualMoney", "实际参与分配的金额");
		actualMoneyField.setLength(18);
		actualMoneyField.setDecimalPad(2);
		actualMoneyField.setFormat("#,###,###,###,###,##0.00");
		actualMoneyField.setRequired(false);
		actualMoneyField.setHidden(true);


		orderIdField = new DataSourceTextField("orderId", "订单编号");
		orderIdField.setLength(32);
		orderIdField.setRequired(false);
		orderIdField.setHidden(false);


		operationManagerIdField = new DataSourceIntegerField("operationManagerId", "部门经理");
		operationManagerIdField.setLength(11);
		operationManagerIdField.setRequired(false);
		operationManagerIdField.setHidden(true);


		contractNameField = new DataSourceTextField("contractName", "项目名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "签约总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);
		
		rateOfProgressField = new DataSourceFloatField("rateOfProgress","项目进度(%)");
		rateOfProgressField.setLength(16);
		rateOfProgressField.setDecimalPad(2);
		rateOfProgressField.setFormat("##,###,###,###,##0.00");
		rateOfProgressField.setRequired(false);
		rateOfProgressField.setHidden(false);


		setFields(contractDistributionIdField, contractIdField, plateIdField, businessTypeField, operatorField, createTimeField, updateTimeField, deleteFlagField, contractDateField, actualMoneyField, orderIdField, operationManagerIdField, contractNameField, signingMoneySumField,rateOfProgressField, amountField);
	}


}

