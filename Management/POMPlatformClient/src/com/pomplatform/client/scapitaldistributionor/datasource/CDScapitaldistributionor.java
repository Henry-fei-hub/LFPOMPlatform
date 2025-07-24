package com.pomplatform.client.scapitaldistributionor.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDScapitaldistributionor extends DataSource
{


	public static CDScapitaldistributionor instance = null;

	public static CDScapitaldistributionor getInstance() {
		if(instance == null) {
			instance = new CDScapitaldistributionor("CDScapitaldistributionor");
		}
		return instance;
	}

	private final DataSourceIntegerField capitalDistributionIdField;

	public CDScapitaldistributionor(String dataSourceID) {

		setID(dataSourceID);
		capitalDistributionIdField = new DataSourceIntegerField("capitalDistributionId", "主键");
		capitalDistributionIdField.setRequired(true);
		capitalDistributionIdField.setLength(11);
		capitalDistributionIdField.setPrimaryKey(true);
		capitalDistributionIdField.setHidden(true);

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


		setFields(capitalDistributionIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

