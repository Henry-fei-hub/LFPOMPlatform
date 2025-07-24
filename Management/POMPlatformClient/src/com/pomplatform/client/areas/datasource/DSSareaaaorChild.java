package com.pomplatform.client.areas.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSareaaaorChild extends DBDataSource
{


	public static DSSareaaaorChild instance = null;

	public static DSSareaaaorChild getInstance() {
		if(instance == null) {
			instance = new DSSareaaaorChild("DSSareaaaor");
		}
		return instance;
	}

	private final DataSourceIntegerField areaIdField;
	private final DataSourceTextField areaNameField;
	private final DataSourceTextField areaNameEnField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField allNameField;
	private final DataSourceIntegerField areaLevelField;

	public DSSareaaaorChild(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("GetAreaChildData");


		areaIdField = new DataSourceIntegerField("areaId", "区域");
		areaIdField.setLength(11);
		areaIdField.setPrimaryKey(true);
		areaIdField.setRequired(true);
		areaIdField.setHidden(true);


		areaNameField = new DataSourceTextField("areaName", "简称");
		areaNameField.setLength(128);
		areaNameField.setRequired(false);
		areaNameField.setHidden(false);
		areaNameField.setCanEdit(false);


		areaNameEnField = new DataSourceTextField("areaNameEn", "区域英文名称");
		areaNameEnField.setLength(128);
		areaNameEnField.setRequired(false);
		areaNameEnField.setHidden(true);
		areaNameEnField.setCanEdit(false);
		

		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
		parentIdField.setValueMap(KeyValueManager.getValueMap(""));


		allNameField = new DataSourceTextField("allName", "全名");
		allNameField.setLength(64);
		allNameField.setRequired(false);
		allNameField.setHidden(false);


		areaLevelField = new DataSourceIntegerField("areaLevel", "等级");
		areaLevelField.setLength(11);
		areaLevelField.setRequired(false);
		areaLevelField.setHidden(false);
		areaLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_131"));

		setFields(areaIdField, areaNameField, areaNameEnField, parentIdField, allNameField, areaLevelField);
	}


}

