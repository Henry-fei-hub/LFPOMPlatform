package com.pomplatform.client.capitaldistribution.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCapitalDifference extends DBDataSource
{


	public static DSCapitalDifference instance = null;

	public static DSCapitalDifference getInstance() {
		if(instance == null) {
			instance = new DSCapitalDifference("DSCapitalDifference");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalIdField;
	private final DataSourceDateField happenDateField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceIntegerField projectNumField;

	public DSCapitalDifference(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CapitalDifference");


		capitalIdField = new DataSourceIntegerField("capitalId", "资金表id");
		capitalIdField.setLength(11);
		capitalIdField.setPrimaryKey(true);
		capitalIdField.setRequired(true);
		capitalIdField.setHidden(true);


		happenDateField = new DataSourceDateField("happenDate", "发生日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "回款金额");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);
		
		
		leftAmountField = new DataSourceFloatField("leftAmount", "剩余可分配金额");
		leftAmountField.setLength(16);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("##,###,###,###,##0.00");
		leftAmountField.setRequired(false);
		leftAmountField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "回款备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


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


		projectNumField = new DataSourceIntegerField("projectNum", "订单数量");
		projectNumField.setLength(8);
		projectNumField.setRequired(true);
		projectNumField.setHidden(true);


		setFields(capitalIdField, happenDateField, borrowMoneyField, leftAmountField, remarkField, contractIdField, contractCodeField, contractNameField, projectNumField);
	}


}

