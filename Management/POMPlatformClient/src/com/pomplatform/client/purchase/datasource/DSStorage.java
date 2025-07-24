package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSStorage extends DBDataSource {

	public static DSStorage instance = null;

	public static DSStorage getInstance() {
		if (instance == null) {
			instance = new DSStorage("DSStorage");
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

	public DSStorage(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("Storage");

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

		storageAreaIdField = new DataSourceIntegerField("storageAreaId", "地区编码");
		storageAreaIdField.setLength(11);
		storageAreaIdField.setRequired(false);
		storageAreaIdField.setHidden(false);

		countryField = new DataSourceIntegerField("country", "所在国家");
		countryField.setLength(11);
		countryField.setRequired(false);
		countryField.setHidden(false);

		provinceField = new DataSourceIntegerField("province", "所在省份");
		provinceField.setLength(11);
		provinceField.setRequired(false);
		provinceField.setHidden(false);

		cityField = new DataSourceIntegerField("city", "所在城市");
		cityField.setLength(11);
		cityField.setRequired(false);
		cityField.setHidden(false);

		addressField = new DataSourceTextField("address", "详细地址");
		addressField.setLength(512);
		addressField.setRequired(false);
		addressField.setHidden(false);

		contactEmployeeIdField = new DataSourceIntegerField("contactEmployeeId", "联系人");
		contactEmployeeIdField.setLength(11);
		contactEmployeeIdField.setRequired(false);
		contactEmployeeIdField.setHidden(false);

		contactPhoneField = new DataSourceTextField("contactPhone", "联系电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级id");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		isEnabledField = new DataSourceBooleanField("isEnabled", "是否可用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);

		setFields(storageIdField, storageCodeField, storageNameField, storageTypeField, storageAreaIdField,
				countryField, provinceField, cityField, addressField, contactEmployeeIdField, contactPhoneField,
				parentIdField, createEmployeeIdField, createTimeField, isEnabledField, remarkField);
	}

}
