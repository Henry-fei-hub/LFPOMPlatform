package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadSupplierData extends DataSource
{


	public static CDOnLoadSupplierData instance = null;

	public static CDOnLoadSupplierData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadSupplierData("CDOnLoadSupplierData");
		}
		return instance;
	}

	private final DataSourceTextField supplierCodeField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceIntegerField supplierTypeField;
	private final DataSourceIntegerField supplierLevelField;
	private final DataSourceIntegerField logisticsTypeField;
	private final DataSourceTextField majorContactPersonField;
	private final DataSourceIntegerField countryField;
	private final DataSourceIntegerField provinceField;
	private final DataSourceIntegerField cityField;
	private final DataSourceTextField addressField;

	public CDOnLoadSupplierData(String dataSourceID) {

		setID(dataSourceID);
		supplierCodeField = new DataSourceTextField("supplierCode", "供应商编号");
		supplierCodeField.setRequired(false);
		supplierCodeField.setLength(64);
		supplierCodeField.setHidden(false);

		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setRequired(false);
		supplierNameField.setLength(128);
		supplierNameField.setHidden(false);

		supplierTypeField = new DataSourceIntegerField("supplierType", "供应商类型对应字典表system_dictionary_187");
		supplierTypeField.setRequired(false);
		supplierTypeField.setLength(11);
		supplierTypeField.setHidden(false);
		supplierTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		supplierLevelField = new DataSourceIntegerField("supplierLevel", "供应商级别对应字典表system_dictionary_188");
		supplierLevelField.setRequired(false);
		supplierLevelField.setLength(11);
		supplierLevelField.setHidden(false);
		supplierLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		logisticsTypeField = new DataSourceIntegerField("logisticsType", "物流方式system_dictionary_189");
		logisticsTypeField.setRequired(false);
		logisticsTypeField.setLength(11);
		logisticsTypeField.setHidden(false);
		logisticsTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		majorContactPersonField = new DataSourceTextField("majorContactPerson", "主要联系人");
		majorContactPersonField.setRequired(false);
		majorContactPersonField.setLength(128);
		majorContactPersonField.setHidden(false);

		countryField = new DataSourceIntegerField("country", "供应商所在国家");
		countryField.setRequired(false);
		countryField.setLength(11);
		countryField.setHidden(false);
		countryField.setValueMap(KeyValueManager.getValueMap("countries"));

		provinceField = new DataSourceIntegerField("province", "供应商所在省份");
		provinceField.setRequired(false);
		provinceField.setLength(11);
		provinceField.setHidden(false);
		provinceField.setValueMap(new java.util.HashMap());

		cityField = new DataSourceIntegerField("city", "供应商所在城市");
		cityField.setRequired(false);
		cityField.setLength(11);
		cityField.setHidden(false);

		addressField = new DataSourceTextField("address", "供应商详细地址");
		addressField.setRequired(false);
		addressField.setLength(512);
		addressField.setHidden(false);

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


		setFields(supplierCodeField, supplierNameField, supplierTypeField, supplierLevelField, logisticsTypeField, majorContactPersonField, countryField, provinceField, cityField, addressField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

