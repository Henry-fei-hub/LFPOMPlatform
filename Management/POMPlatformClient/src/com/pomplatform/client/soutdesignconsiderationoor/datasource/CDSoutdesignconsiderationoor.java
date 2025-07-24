package com.pomplatform.client.soutdesignconsiderationoor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSoutdesignconsiderationoor extends DataSource
{


	public static CDSoutdesignconsiderationoor instance = null;

	public static CDSoutdesignconsiderationoor getInstance() {
		if(instance == null) {
			instance = new CDSoutdesignconsiderationoor("CDSoutdesignconsiderationoor");
		}
		return instance;
	}

	private final DataSourceIntegerField outQuotationIdField;

	public CDSoutdesignconsiderationoor(String dataSourceID) {

		setID(dataSourceID);
		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单表编码");
		outQuotationIdField.setRequired(false);
		outQuotationIdField.setLength(11);
		outQuotationIdField.setHidden(false);

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

