package com.pomplatform.client.financialtransactionaccount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDFinancialAccountInitAmount extends DataSource
{


	public static CDFinancialAccountInitAmount instance = null;

	public static CDFinancialAccountInitAmount getInstance() {
		if(instance == null) {
			instance = new CDFinancialAccountInitAmount("CDFinancialAccountInitAmount");
		}
		return instance;
	}

	private final DataSourceIntegerField financialAccountInitAmountIdField;

	public CDFinancialAccountInitAmount(String dataSourceID) {

		setID(dataSourceID);
		financialAccountInitAmountIdField = new DataSourceIntegerField("financialAccountInitAmountId", "主键编码");
		financialAccountInitAmountIdField.setRequired(true);
		financialAccountInitAmountIdField.setLength(11);
		financialAccountInitAmountIdField.setPrimaryKey(true);
		financialAccountInitAmountIdField.setHidden(true);

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


		setFields(financialAccountInitAmountIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

