package com.pomplatform.client.minvoicettorunusecount.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMinvoicettorunusecount extends DataSource
{


	public static CDMinvoicettorunusecount instance = null;

	public static CDMinvoicettorunusecount getInstance() {
		if(instance == null) {
			instance = new CDMinvoicettorunusecount("CDMinvoicettorunusecount");
		}
		return instance;
	}

	private final DataSourceIntegerField ticketingCompanyField;

	public CDMinvoicettorunusecount(String dataSourceID) {

		setID(dataSourceID);
		ticketingCompanyField = new DataSourceIntegerField("ticketingCompany", "购票公司");
		ticketingCompanyField.setRequired(false);
		ticketingCompanyField.setLength(11);
		ticketingCompanyField.setHidden(false);

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


		setFields(ticketingCompanyField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

