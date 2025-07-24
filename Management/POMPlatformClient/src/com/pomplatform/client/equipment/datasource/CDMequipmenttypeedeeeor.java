package com.pomplatform.client.equipment.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMequipmenttypeedeeeor extends DataSource
{


	public static CDMequipmenttypeedeeeor instance = null;

	public static CDMequipmenttypeedeeeor getInstance() {
		if(instance == null) {
			instance = new CDMequipmenttypeedeeeor("CDMequipmenttypeedeeeor");
		}
		return instance;
	}

	private final DataSourceTextField nameField;
	private final DataSourceIntegerField typeField;
	private final DataSourceBooleanField enabledField;

	public CDMequipmenttypeedeeeor(String dataSourceID) {

		setID(dataSourceID);
		nameField = new DataSourceTextField("name", "名称");
		nameField.setRequired(false);
		nameField.setLength(128);
		nameField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "物品类型");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_254"));

		enabledField = new DataSourceBooleanField("enabled", "是否启用");
		enabledField.setRequired(false);
		enabledField.setHidden(false);

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


		setFields(nameField, typeField, enabledField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

