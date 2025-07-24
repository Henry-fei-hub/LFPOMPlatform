package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSIncomeMoneyForWeek extends DBDataSource
{


	public static DSIncomeMoneyForWeek instance = null;

	public static DSIncomeMoneyForWeek getInstance() {
		if(instance == null) {
			instance = new DSIncomeMoneyForWeek("DSIncomeMoneyForWeek");
		}
		return instance;
	}

	private final DataSourceTextField moneyAttributeField;
	private final DataSourceTextField contractIdField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField signingMoneySumField;
	private final DataSourceTextField percentField;
	private final DataSourceTextField otherNameField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField happenDateField;

	public DSIncomeMoneyForWeek(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("IncomeMoneyForWeek");


		moneyAttributeField = new DataSourceTextField("moneyAttribute", "款项属性");
		moneyAttributeField.setLength(11);
		moneyAttributeField.setRequired(false);
		moneyAttributeField.setHidden(false);
		moneyAttributeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_55"));


		contractIdField = new DataSourceTextField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);


		contractNameField = new DataSourceTextField("contractName", "项目名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		signingMoneySumField = new DataSourceFloatField("signingMoneySum", "项目总金额");
		signingMoneySumField.setLength(16);
		signingMoneySumField.setDecimalPad(2);
		signingMoneySumField.setFormat("##,###,###,###,##0.00");
		signingMoneySumField.setRequired(false);
		signingMoneySumField.setHidden(false);


		percentField = new DataSourceTextField("percent", "项目收款进度");
		percentField.setLength(-1);
		percentField.setRequired(true);
		percentField.setHidden(false);


		otherNameField = new DataSourceTextField("otherName", "付款方");
		otherNameField.setLength(128);
		otherNameField.setRequired(false);
		otherNameField.setHidden(false);


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "收款金额");
		borrowMoneyField.setLength(16);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("##,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		happenDateField = new DataSourceDateTimeField("happenDate", "发生日期");
		happenDateField.setRequired(false);
		happenDateField.setHidden(false);


		setFields(moneyAttributeField, contractIdField, contractNameField, signingMoneySumField, percentField, otherNameField, borrowMoneyField, remarkField, happenDateField);
	}


}

