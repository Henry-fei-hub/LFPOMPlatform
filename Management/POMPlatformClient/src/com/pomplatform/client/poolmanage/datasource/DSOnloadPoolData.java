package com.pomplatform.client.poolmanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnloadPoolData extends DBDataSource
{


	public static DSOnloadPoolData instance = null;

	public static DSOnloadPoolData getInstance() {
		if(instance == null) {
			instance = new DSOnloadPoolData("DSOnloadPoolData");
		}
		return instance;
	}

	private final DataSourceIntegerField poolManageIdField;
	private final DataSourceTextField poolNameField;
	private final DataSourceIntegerField poolTypeField;
	private final DataSourceIntegerField regionField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceTextField poolEmployeesField;
	private final DataSourceTextField remarkField;

	public DSOnloadPoolData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnloadPoolData");


		poolManageIdField = new DataSourceIntegerField("poolManageId", "池子id");
		poolManageIdField.setLength(11);
		poolManageIdField.setRequired(false);
		poolManageIdField.setHidden(true);


		poolNameField = new DataSourceTextField("poolName", "池子名称");
		poolNameField.setLength(64);
		poolNameField.setRequired(false);
		poolNameField.setHidden(false);
		
		poolTypeField = new DataSourceIntegerField("poolType", "池子类型");
		poolTypeField.setLength(11);
		poolTypeField.setRequired(false);
		poolTypeField.setHidden(false);
		poolTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_234"));


		regionField = new DataSourceIntegerField("region", "地区");
		regionField.setLength(11);
		regionField.setRequired(false);
		regionField.setHidden(false);
		regionField.setValueMap(KeyValueManager.getValueMap("system_dictionary_170"));
		regionField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业态");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		businessTypeField.setHidden(true);


		poolEmployeesField = new DataSourceTextField("poolEmployees", "成员");
		poolEmployeesField.setLength(64);
		poolEmployeesField.setRequired(true);
		poolEmployeesField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(poolManageIdField, poolNameField,poolTypeField, regionField, businessTypeField, poolEmployeesField, remarkField);
	}


}

