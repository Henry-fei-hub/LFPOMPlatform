package com.pomplatform.client.templet.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOutTemplet extends DataSource
{


	public static CDOutTemplet instance = null;

	public static CDOutTemplet getInstance() {
		if(instance == null) {
			instance = new CDOutTemplet("CDOutTemplet");
		}
		return instance;
	}

	private final DataSourceIntegerField businessTypeField;

	public CDOutTemplet(String dataSourceID) {

		setID(dataSourceID);
		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(businessTypeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

