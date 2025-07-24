package com.pomplatform.client.customer.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadCustomerData extends DataSource
{


	public static CDOnLoadCustomerData instance = null;

	public static CDOnLoadCustomerData getInstance() {
		if(instance == null) {
			instance = new CDOnLoadCustomerData("CDOnLoadCustomerData");
		}
		return instance;
	}

	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField companyAddressField;
	private final DataSourceIntegerField customerTypeField;
	private final DataSourceIntegerField customerLevelField;
	private final DataSourceIntegerField reportEmployeeIdField;
	private final DataSourceBooleanField isSureField;
	private final DataSourceBooleanField isWarehousField;
	private final DataSourceBooleanField isApplyQuoteField;
	private final DataSourceTextField companyProvinceField;
	private final DataSourceTextField companyCityField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField typeField;

	public CDOnLoadCustomerData(String dataSourceID) {

		setID(dataSourceID);
		customerIdField = new DataSourceIntegerField("customerId", "主键编码");
		customerIdField.setRequired(true);
		customerIdField.setLength(11);
		customerIdField.setPrimaryKey(true);
		customerIdField.setHidden(true);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(128);
		customerNameField.setHidden(false);

		companyAddressField = new DataSourceTextField("companyAddress", "客户地址");
		companyAddressField.setRequired(false);
		companyAddressField.setLength(128);
		companyAddressField.setHidden(false);

		customerTypeField = new DataSourceIntegerField("customerType", "客户类型");
		customerTypeField.setRequired(false);
		customerTypeField.setLength(11);
		customerTypeField.setHidden(false);
		customerTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		customerLevelField = new DataSourceIntegerField("customerLevel", "客户等级");
		customerLevelField.setRequired(false);
		customerLevelField.setLength(11);
		customerLevelField.setHidden(false);
		customerLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		reportEmployeeIdField = new DataSourceIntegerField("reportEmployeeId", "报备人员");
		reportEmployeeIdField.setRequired(false);
		reportEmployeeIdField.setLength(11);
		reportEmployeeIdField.setHidden(false);
		reportEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		isSureField = new DataSourceBooleanField("isSure", "是否确认");
		isSureField.setRequired(false);
		isSureField.setHidden(false);

		isWarehousField = new DataSourceBooleanField("isWarehous", "是否入库");
		isWarehousField.setRequired(false);
		isWarehousField.setHidden(false);

		isApplyQuoteField = new DataSourceBooleanField("isApplyQuote", "是否已提供战略报价");
		isApplyQuoteField.setRequired(false);
		isApplyQuoteField.setHidden(false);

		companyProvinceField = new DataSourceTextField("companyProvince", "省份");
		companyProvinceField.setRequired(false);
		companyProvinceField.setLength(64);
		companyProvinceField.setHidden(false);

		companyCityField = new DataSourceTextField("companyCity", "城市");
		companyCityField.setRequired(false);
		companyCityField.setLength(64);
		companyCityField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setRequired(false);
		parentIdField.setLength(11);
		parentIdField.setHidden(false);

		typeField = new DataSourceIntegerField("type", "3设计合作单位)");
		typeField.setRequired(false);
		typeField.setLength(11);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

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


		setFields(customerIdField, customerNameField, companyAddressField, customerTypeField, customerLevelField, reportEmployeeIdField, isSureField, isWarehousField, isApplyQuoteField, companyProvinceField, companyCityField, parentIdField, typeField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

