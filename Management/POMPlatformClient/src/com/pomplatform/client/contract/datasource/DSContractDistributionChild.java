package com.pomplatform.client.contract.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSContractDistributionChild extends DBDataSource
{


	public static DSContractDistributionChild instance = null;

	public static DSContractDistributionChild getInstance() {
		if(instance == null) {
			instance = new DSContractDistributionChild("DSContractDistributionChild");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceFloatField commissionsRateField;
	private final DataSourceFloatField revenueIntegralField;
	private final DataSourceFloatField relativelyProgressField;
	private final DataSourceFloatField amountField;

	public DSContractDistributionChild(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractDistributionChild");


		projectIdField = new DataSourceIntegerField("projectId", "订单编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setForeignKey("DSContractDistributionNew.contractId");


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		businessTypeField = new DataSourceTextField("businessType", "业态");
		businessTypeField.setLength(32);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		projectAmountField = new DataSourceFloatField("projectAmount", "订单金额");
		projectAmountField.setLength(32);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		commissionsRateField = new DataSourceFloatField("commissionsRate", "提成系数");
		commissionsRateField.setLength(32);
		commissionsRateField.setDecimalPad(4);
		commissionsRateField.setFormat("#,###,###,###,###,###,###,###,###,##0.0000");
		commissionsRateField.setRequired(false);
		commissionsRateField.setHidden(false);


		revenueIntegralField = new DataSourceFloatField("revenueIntegral", "订单进度");
		revenueIntegralField.setLength(18);
		revenueIntegralField.setDecimalPad(2);
		revenueIntegralField.setFormat("#,###,###,###,###,##0.00");
		revenueIntegralField.setRequired(true);
		revenueIntegralField.setHidden(false);


		relativelyProgressField = new DataSourceFloatField("relativelyProgress", "提成进度");
		relativelyProgressField.setLength(32);
		relativelyProgressField.setDecimalPad(2);
		relativelyProgressField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		relativelyProgressField.setRequired(false);
		relativelyProgressField.setHidden(false);


		amountField = new DataSourceFloatField("amount", "提成金额");
		amountField.setLength(18);
		amountField.setDecimalPad(2);
		amountField.setFormat("#,###,###,###,###,##0.00");
		amountField.setRequired(true);
		amountField.setHidden(false);


		setFields(projectIdField, contractCodeField, contractIdField, projectNameField, businessTypeField, projectAmountField, commissionsRateField, revenueIntegralField, relativelyProgressField, amountField);
	}


}

