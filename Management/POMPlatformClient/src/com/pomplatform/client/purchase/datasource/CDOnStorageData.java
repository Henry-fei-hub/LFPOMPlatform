package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnStorageData extends DataSource
{


	public static CDOnStorageData instance = null;

	public static CDOnStorageData getInstance() {
		if(instance == null) {
			instance = new CDOnStorageData("CDOnStorageData");
		}
		return instance;
	}

	private final DataSourceTextField storageCodeField;
	private final DataSourceTextField storageNameField;
	private final DataSourceIntegerField storageTypeField;
	private final DataSourceIntegerField storageAreaIdField;
	private final DataSourceIntegerField countryField;
	private final DataSourceIntegerField provinceField;
	private final DataSourceIntegerField cityField;

	public CDOnStorageData(String dataSourceID) {

		setID(dataSourceID);
		storageCodeField = new DataSourceTextField("storageCode", "仓库编号");
		storageCodeField.setRequired(false);
		storageCodeField.setLength(64);
		storageCodeField.setHidden(false);

		storageNameField = new DataSourceTextField("storageName", "仓库名称");
		storageNameField.setRequired(false);
		storageNameField.setLength(64);
		storageNameField.setHidden(false);

		storageTypeField = new DataSourceIntegerField("storageType", "仓库类型(对应字典表system_dictionary_209)");
		storageTypeField.setRequired(false);
		storageTypeField.setLength(11);
		storageTypeField.setHidden(false);
		storageTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		storageAreaIdField = new DataSourceIntegerField("storageAreaId", "地区编码");
		storageAreaIdField.setRequired(false);
		storageAreaIdField.setLength(11);
		storageAreaIdField.setHidden(false);
		storageAreaIdField.setValueMap(KeyValueManager.getValueMap("storage_areas"));

		countryField = new DataSourceIntegerField("country", "所在国家");
		countryField.setRequired(false);
		countryField.setLength(11);
		countryField.setHidden(false);
		countryField.setValueMap(KeyValueManager.getValueMap("countries"));

		provinceField = new DataSourceIntegerField("province", "所在省份");
		provinceField.setRequired(false);
		provinceField.setLength(11);
		provinceField.setHidden(false);
		provinceField.setValueMap(KeyValueManager.getValueMap("areas"));

		cityField = new DataSourceIntegerField("city", "所在城市");
		cityField.setRequired(false);
		cityField.setLength(11);
		cityField.setHidden(false);
		cityField.setValueMap(KeyValueManager.getValueMap("areas"));

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


		setFields(storageCodeField, storageNameField, storageTypeField, storageAreaIdField, countryField, provinceField, cityField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

