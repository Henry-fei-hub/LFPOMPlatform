package com.pomplatform.client.customer.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCustomerInfo extends DataSource
{


	public static CDCustomerInfo instance = null;

	public static CDCustomerInfo getInstance() {
		if(instance == null) {
			instance = new CDCustomerInfo("CDCustomerInfo");
		}
		return instance;
	}

	private final DataSourceTextField customerNameField;

	public CDCustomerInfo(String dataSourceID) {

		setID(dataSourceID);
		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(256);
		customerNameField.setHidden(false);

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


		setFields(customerNameField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

