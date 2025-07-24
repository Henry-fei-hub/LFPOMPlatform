package com.pomplatform.client.receivables.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDInvoiceReportDetail extends DataSource
{


	public static CDInvoiceReportDetail instance = null;

	public static CDInvoiceReportDetail getInstance() {
		if(instance == null) {
			instance = new CDInvoiceReportDetail("CDInvoiceReportDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectManagerIdField;

	public CDInvoiceReportDetail(String dataSourceID) {

		setID(dataSourceID);
		projectManagerIdField = new DataSourceIntegerField("projectManagerId", "项目经理编码");
		projectManagerIdField.setRequired(false);
		projectManagerIdField.setLength(11);
		projectManagerIdField.setHidden(false);

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


		setFields(projectManagerIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

