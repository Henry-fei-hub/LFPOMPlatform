package com.pomplatform.client.areas.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSareaaaor extends DBDataSource
{


	public static DSSareaaaor instance = null;

	public static DSSareaaaor getInstance() {
		if(instance == null) {
			instance = new DSSareaaaor("DSSareaaaor");
		}
		return instance;
	}

	private final DataSourceIntegerField areaIdField;
	private final DataSourceTextField areaNameField;
	private final DataSourceTextField areaNameEnField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField allNameField;
	private final DataSourceTextField areaLevelField;

	public DSSareaaaor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sareaaaor");


		areaIdField = new DataSourceIntegerField("areaId", "区域");
		areaIdField.setLength(11);
		areaIdField.setPrimaryKey(true);
		areaIdField.setRequired(true);
		areaIdField.setHidden(true);


		areaNameField = new DataSourceTextField("areaName", "区域简称");
		areaNameField.setLength(32);
		areaNameField.setRequired(false);
		areaNameField.setHidden(false);
		areaNameField.setCanEdit(true);


		areaNameEnField = new DataSourceTextField("areaNameEn", "区域英文名称");
		areaNameEnField.setLength(128);
		areaNameEnField.setRequired(false);
		areaNameEnField.setHidden(false);
		areaNameEnField.setCanEdit(true);
		

		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
		parentIdField.setValueMap(KeyValueManager.getValueMap(""));


		allNameField = new DataSourceTextField("allName", "区域全称");
		allNameField.setLength(32);
		allNameField.setRequired(false);
		allNameField.setHidden(false);


		areaLevelField = new DataSourceTextField("areaLevel", "等级");
		areaLevelField.setLength(64);
		areaLevelField.setRequired(false);
		areaLevelField.setHidden(false);
		areaLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_131"));

		setFields(areaIdField, areaNameField, areaNameEnField, parentIdField, allNameField, areaLevelField);
	}


}

