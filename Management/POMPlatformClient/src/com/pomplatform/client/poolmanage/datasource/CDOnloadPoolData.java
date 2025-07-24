package com.pomplatform.client.poolmanage.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnloadPoolData extends DataSource
{


	public static CDOnloadPoolData instance = null;

	public static CDOnloadPoolData getInstance() {
		if(instance == null) {
			instance = new CDOnloadPoolData("CDOnloadPoolData");
		}
		return instance;
	}

	private final DataSourceTextField poolNameField;
	private final DataSourceIntegerField regionField;
	private final DataSourceIntegerField businessTypeField;

	public CDOnloadPoolData(String dataSourceID) {

		setID(dataSourceID);
		poolNameField = new DataSourceTextField("poolName", "池子名称");
		poolNameField.setRequired(false);
		poolNameField.setLength(64);
		poolNameField.setHidden(false);

		regionField = new DataSourceIntegerField("region", "地区");
		regionField.setRequired(false);
		regionField.setLength(11);
		regionField.setHidden(false);
		regionField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		businessTypeField = new DataSourceIntegerField("businessType", "业态");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap(""));

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


		setFields(poolNameField, regionField, businessTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

