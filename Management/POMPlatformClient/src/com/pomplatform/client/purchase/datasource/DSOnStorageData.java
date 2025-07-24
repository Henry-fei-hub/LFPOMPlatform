package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnStorageData extends DBDataSource
{


	public static DSOnStorageData instance = null;

	public static DSOnStorageData getInstance() {
		if(instance == null) {
			instance = new DSOnStorageData("DSOnStorageData");
		}
		return instance;
	}

	private final DataSourceIntegerField storageIdField;
	private final DataSourceTextField storageCodeField;
	private final DataSourceTextField storageNameField;
	private final DataSourceIntegerField storageTypeField;
	private final DataSourceIntegerField storageAreaIdField;
	private final DataSourceIntegerField countryField;
	private final DataSourceIntegerField provinceField;
	private final DataSourceIntegerField cityField;
	private final DataSourceTextField addressField;
	private final DataSourceIntegerField contactEmployeeIdField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceBooleanField isEnabledField;
	private final DataSourceTextField remarkField;

	public DSOnStorageData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnStorageData");


		storageIdField = new DataSourceIntegerField("storageId", "主键编码");
		storageIdField.setLength(11);
		storageIdField.setPrimaryKey(true);
		storageIdField.setRequired(true);
		storageIdField.setHidden(true);


		storageCodeField = new DataSourceTextField("storageCode", "仓库编号");
		storageCodeField.setLength(64);
		storageCodeField.setRequired(false);
		storageCodeField.setHidden(false);


		storageNameField = new DataSourceTextField("storageName", "仓库名称");
		storageNameField.setLength(64);
		storageNameField.setRequired(false);
		storageNameField.setHidden(false);


		storageTypeField = new DataSourceIntegerField("storageType", "仓库类型");
		storageTypeField.setLength(11);
		storageTypeField.setRequired(false);
		storageTypeField.setHidden(false);
		storageTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_209"));


		storageAreaIdField = new DataSourceIntegerField("storageAreaId", "地区");
		storageAreaIdField.setLength(11);
		storageAreaIdField.setRequired(false);
		storageAreaIdField.setHidden(false);
		storageAreaIdField.setValueMap(KeyValueManager.getValueMap("storage_areas"));


		countryField = new DataSourceIntegerField("country", "所在国家");
		countryField.setLength(11);
		countryField.setRequired(false);
		countryField.setHidden(false);
		countryField.setValueMap(KeyValueManager.getValueMap("countries"));


		provinceField = new DataSourceIntegerField("province", "所在省份");
		provinceField.setLength(11);
		provinceField.setRequired(false);
		provinceField.setHidden(false);
		provinceField.setValueMap(KeyValueManager.getValueMap("areas"));


		cityField = new DataSourceIntegerField("city", "所在城市");
		cityField.setLength(11);
		cityField.setRequired(false);
		cityField.setHidden(false);
		cityField.setValueMap(KeyValueManager.getValueMap("areas"));


		addressField = new DataSourceTextField("address", "详细地址");
		addressField.setLength(512);
		addressField.setRequired(false);
		addressField.setHidden(false);


		contactEmployeeIdField = new DataSourceIntegerField("contactEmployeeId", "联系人");
		contactEmployeeIdField.setLength(11);
		contactEmployeeIdField.setRequired(false);
		contactEmployeeIdField.setHidden(false);
		contactEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		contactPhoneField = new DataSourceTextField("contactPhone", "联系电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级id");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);
		createEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		isEnabledField = new DataSourceBooleanField("isEnabled", "是否可用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(storageIdField, storageCodeField, storageNameField, storageTypeField, storageAreaIdField, countryField, provinceField, cityField, addressField, contactEmployeeIdField, contactPhoneField, parentIdField, createEmployeeIdField, createTimeField, isEnabledField, remarkField);
	}


}

