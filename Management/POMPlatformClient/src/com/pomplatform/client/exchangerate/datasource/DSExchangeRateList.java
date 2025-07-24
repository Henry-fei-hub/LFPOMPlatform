package com.pomplatform.client.exchangerate.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSExchangeRateList extends DBDataSource
{


	public static DSExchangeRateList instance = null;

	public static DSExchangeRateList getInstance() {
		if(instance == null) {
			instance = new DSExchangeRateList("DSExchangeRateList");
		}
		return instance;
	}

	private final DataSourceIntegerField exchangeRateIdField;
	private final DataSourceIntegerField currencyIdField;
	private final DataSourceFloatField exchangeRateField;
	private final DataSourceDateField exchangeDateField;

	public DSExchangeRateList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ExchangeRateList");


		exchangeRateIdField = new DataSourceIntegerField("exchangeRateId", "汇率表编码");
		exchangeRateIdField.setLength(11);
		exchangeRateIdField.setPrimaryKey(true);
		exchangeRateIdField.setRequired(true);
		exchangeRateIdField.setHidden(true);


		currencyIdField = new DataSourceIntegerField("currencyId", "货币类型");
		currencyIdField.setLength(11);
		currencyIdField.setRequired(false);
		currencyIdField.setHidden(false);
		currencyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_40"));


		exchangeRateField = new DataSourceFloatField("exchangeRate", "汇率");
		exchangeRateField.setLength(18);
		exchangeRateField.setDecimalPad(4);
		exchangeRateField.setFormat("##,###,###,###,##0.0000");
		exchangeRateField.setRequired(false);
		exchangeRateField.setHidden(false);


		exchangeDateField = new DataSourceDateField("exchangeDate", "兑换日期");
		exchangeDateField.setRequired(false);
		exchangeDateField.setHidden(false);


		setFields(exchangeRateIdField, currencyIdField, exchangeRateField, exchangeDateField);
	}


}

