package com.pomplatform.client.sealkeepers.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDRankMaintenance extends DataSource
{


	public static CDRankMaintenance instance = null;

	public static CDRankMaintenance getInstance() {
		if(instance == null) {
			instance = new CDRankMaintenance("CDRankMaintenance");
		}
		return instance;
	}

	private final DataSourceTextField dicTypeValueField;

	public CDRankMaintenance(String dataSourceID) {

		setID(dataSourceID);
		dicTypeValueField = new DataSourceTextField("dicTypeValue", "数据值");
		dicTypeValueField.setRequired(false);
		dicTypeValueField.setLength(64);
		dicTypeValueField.setHidden(false);

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


		setFields(dicTypeValueField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

