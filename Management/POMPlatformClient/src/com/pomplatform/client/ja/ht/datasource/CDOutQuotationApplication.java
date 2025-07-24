package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOutQuotationApplication extends DataSource
{


	public static CDOutQuotationApplication instance = null;

	public static CDOutQuotationApplication getInstance() {
		if(instance == null) {
			instance = new CDOutQuotationApplication("CDOutQuotationApplication");
		}
		return instance;
	}

	private final DataSourceIntegerField outQuotationIdField;

	public CDOutQuotationApplication(String dataSourceID) {

		setID(dataSourceID);
		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单编码");
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setLength(11);
		outQuotationIdField.setPrimaryKey(true);
		outQuotationIdField.setHidden(true);

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


		setFields(outQuotationIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

