package com.pomplatform.client.exchangerate.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDExchangeRateList extends DataSource
{


	public static CDExchangeRateList instance = null;

	public static CDExchangeRateList getInstance() {
		if(instance == null) {
			instance = new CDExchangeRateList("CDExchangeRateList");
		}
		return instance;
	}

	private final DataSourceIntegerField currencyIdField;
	private final DataSourceDateField exchangeDateField;

	public CDExchangeRateList(String dataSourceID) {

		setID(dataSourceID);
		currencyIdField = new DataSourceIntegerField("currencyId", "货币类型");
		currencyIdField.setRequired(false);
		currencyIdField.setLength(11);
		currencyIdField.setHidden(false);
		currencyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		exchangeDateField = new DataSourceDateField("exchangeDate", "兑换日期");
		exchangeDateField.setRequired(false);
		exchangeDateField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(currencyIdField, exchangeDateField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

