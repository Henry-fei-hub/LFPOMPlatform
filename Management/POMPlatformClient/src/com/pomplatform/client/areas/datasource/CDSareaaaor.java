package com.pomplatform.client.areas.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSareaaaor extends DataSource
{


	public static CDSareaaaor instance = null;

	public static CDSareaaaor getInstance() {
		if(instance == null) {
			instance = new CDSareaaaor("CDSareaaaor");
		}
		return instance;
	}

	private final DataSourceTextField areaNameField;
	private final DataSourceIntegerField areaLevelField;

	public CDSareaaaor(String dataSourceID) {

		setID(dataSourceID);
		areaNameField = new DataSourceTextField("areaName", "区域名称");
		areaNameField.setRequired(true);
		areaNameField.setLength(256);
		areaNameField.setHidden(false);

		areaLevelField = new DataSourceIntegerField("areaLevel", "等级");
		areaLevelField.setRequired(false);
		areaLevelField.setLength(11);
		areaLevelField.setHidden(false);

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


		setFields(areaNameField, areaLevelField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

