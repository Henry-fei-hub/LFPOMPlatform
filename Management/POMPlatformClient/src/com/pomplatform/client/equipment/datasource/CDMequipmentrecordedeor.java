package com.pomplatform.client.equipment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMequipmentrecordedeor extends DataSource
{


	public static CDMequipmentrecordedeor instance = null;

	public static CDMequipmentrecordedeor getInstance() {
		if(instance == null) {
			instance = new CDMequipmentrecordedeor("CDMequipmentrecordedeor");
		}
		return instance;
	}

	private final DataSourceIntegerField equipmentIdField;

	public CDMequipmentrecordedeor(String dataSourceID) {

		setID(dataSourceID);
		equipmentIdField = new DataSourceIntegerField("equipmentId", "物品id");
		equipmentIdField.setRequired(false);
		equipmentIdField.setLength(11);
		equipmentIdField.setHidden(false);

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


		setFields(equipmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

