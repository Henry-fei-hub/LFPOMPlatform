package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAllCapitalDistributionInfo extends DBDataSource
{


	public static DSAllCapitalDistributionInfo instance = null;

	public static DSAllCapitalDistributionInfo getInstance() {
		if(instance == null) {
			instance = new DSAllCapitalDistributionInfo("DSAllCapitalDistributionInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceDateField happenDateField;
	private final DataSourceTextField remarkField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceFloatField distributionAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateField createTimeField;

	public DSAllCapitalDistributionInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AllCapitalDistributionInfo");


		capitalIdField = new DataSourceIntegerField("capitalId", "资金表id");
		capitalIdField.setLength(11);
		capitalIdField.setPrimaryKey(true);
		capitalIdField.setRequired(true);
		capitalIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
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


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "回款金额");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		happenDateField = new DataSourceDateField("happenDate", "回款日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(true);


		distributionAmountField = new DataSourceFloatField("distributionAmount", "已分配金额");
		distributionAmountField.setLength(18);
		distributionAmountField.setDecimalPad(2);
		distributionAmountField.setFormat("#,###,###,###,###,##0.00");
		distributionAmountField.setRequired(false);
		distributionAmountField.setHidden(false);


		leftAmountField = new DataSourceFloatField("leftAmount", "剩余可分配金额");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,###,###,##0.00");
		leftAmountField.setRequired(true);
		leftAmountField.setHidden(false);


		operatorField = new DataSourceIntegerField("operator", "分配人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateField("createTime", "分配日期");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(capitalIdField, contractIdField, contractCodeField, contractNameField, happenDateField, borrowMoneyField, remarkField, lockedField, distributionAmountField, leftAmountField, operatorField, createTimeField);
	}


}

