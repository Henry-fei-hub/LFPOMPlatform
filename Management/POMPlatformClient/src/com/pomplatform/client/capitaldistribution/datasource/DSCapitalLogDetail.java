package com.pomplatform.client.capitaldistribution.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCapitalLogDetail extends DBDataSource
{


	public static DSCapitalLogDetail instance = null;

	public static DSCapitalLogDetail getInstance() {
		if(instance == null) {
			instance = new DSCapitalLogDetail("DSCapitalLogDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceIntegerField capitalLogIdField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceTextField logContentField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField capitalIdField;

	public DSCapitalLogDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CapitalLogDetail");


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


		capitalLogIdField = new DataSourceIntegerField("capitalLogId", "汇率表编码");
		capitalLogIdField.setLength(11);
		capitalLogIdField.setPrimaryKey(true);
		capitalLogIdField.setRequired(true);
		capitalLogIdField.setHidden(true);


		operatorField = new DataSourceIntegerField("operator", "操作者");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(false);
		operatorField.setValueMap(KeyValueManager.getValueMap("employees"));


		logContentField = new DataSourceTextField("logContent", "操作日志");
		logContentField.setLength(2048);
		logContentField.setRequired(false);
		logContentField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "操作时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		capitalIdField = new DataSourceIntegerField("capitalId", "回款编码");
		capitalIdField.setLength(11);
		capitalIdField.setRequired(false);
		capitalIdField.setHidden(true);


		setFields(capitalLogIdField, contractIdField, contractCodeField, contractNameField, borrowMoneyField, operatorField, createTimeField, logContentField, capitalIdField);
	}


}

