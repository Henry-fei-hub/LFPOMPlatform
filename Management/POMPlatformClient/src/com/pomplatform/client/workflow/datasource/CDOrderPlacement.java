package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOrderPlacement extends DataSource
{


	public static CDOrderPlacement instance = null;

	public static CDOrderPlacement getInstance() {
		if(instance == null) {
			instance = new CDOrderPlacement("CDOrderPlacement");
		}
		return instance;
	}

	private final DataSourceIntegerField orderInfoIdField;

	public CDOrderPlacement(String dataSourceID) {

		setID(dataSourceID);
		orderInfoIdField = new DataSourceIntegerField("orderInfoId", "订单信息编码");
		orderInfoIdField.setRequired(true);
		orderInfoIdField.setLength(11);
		orderInfoIdField.setPrimaryKey(true);
		orderInfoIdField.setHidden(true);

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


		setFields(orderInfoIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

