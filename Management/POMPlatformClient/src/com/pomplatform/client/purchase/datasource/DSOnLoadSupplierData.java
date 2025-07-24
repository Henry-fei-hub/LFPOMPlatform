package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadSupplierData extends DBDataSource
{


	public static DSOnLoadSupplierData instance = null;

	public static DSOnLoadSupplierData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadSupplierData("DSOnLoadSupplierData");
		}
		return instance;
	}

	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField supplierCodeField;
	private final DataSourceTextField supplierNameField;
	private final DataSourceIntegerField supplierTypeField;
	private final DataSourceIntegerField supplierLevelField;
	private final DataSourceTextField registeredAddressField;
	private final DataSourceDateField registeredDateField;
	private final DataSourceTextField registeredCapitalField;
	private final DataSourceTextField productionAddressField;
	private final DataSourceTextField majorContactPersonField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField emailField;
	private final DataSourceTextField faxField;
	private final DataSourceIntegerField paymentMethodField;
	private final DataSourceIntegerField countryField;
	private final DataSourceIntegerField provinceField;
	private final DataSourceIntegerField cityField;
	private final DataSourceTextField addressField;
	private final DataSourceTextField bankNameField;
	private final DataSourceTextField payNameField;
	private final DataSourceTextField payCodeField;
	private final DataSourceTextField taxCodeField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceTextField majorBusinessField;
	private final DataSourceIntegerField startOrderCountField;
	private final DataSourceIntegerField productionCycleField;
	private final DataSourceIntegerField logisticsCycleField;
	private final DataSourceIntegerField logisticsTypeField;
	private final DataSourceBooleanField isEnabledField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField abbreviatedNameField;
	private final DataSourceDateField startCoworkDateField;
	private final DataSourceTextField warrantyPeriodField;
	private final DataSourceBooleanField isIncludeInstallField;
	private final DataSourceTextField accountPeriodField;
	private final DataSourceTextField postCodeField;

	public DSOnLoadSupplierData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadSupplierData");


		supplierIdField = new DataSourceIntegerField("supplierId", "主键编码");
		supplierIdField.setLength(11);
		supplierIdField.setPrimaryKey(true);
		supplierIdField.setRequired(true);
		supplierIdField.setHidden(true);


		supplierCodeField = new DataSourceTextField("supplierCode", "供应商编号");
		supplierCodeField.setLength(64);
		supplierCodeField.setRequired(false);
		supplierCodeField.setHidden(true);


		supplierNameField = new DataSourceTextField("supplierName", "供应商名称");
		supplierNameField.setLength(128);
		supplierNameField.setRequired(false);
		supplierNameField.setHidden(false);


		supplierTypeField = new DataSourceIntegerField("supplierType", "供应商类型");
		supplierTypeField.setLength(11);
		supplierTypeField.setRequired(false);
		supplierTypeField.setHidden(false);
		supplierTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_187"));


		supplierLevelField = new DataSourceIntegerField("supplierLevel", "供应商级别");
		supplierLevelField.setLength(11);
		supplierLevelField.setRequired(false);
		supplierLevelField.setHidden(false);
		supplierLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_188"));


		registeredAddressField = new DataSourceTextField("registeredAddress", "注册地址");
		registeredAddressField.setLength(128);
		registeredAddressField.setRequired(false);
		registeredAddressField.setHidden(false);


		registeredDateField = new DataSourceDateField("registeredDate", "供应商注册日期");
		registeredDateField.setRequired(false);
		registeredDateField.setHidden(false);


		registeredCapitalField = new DataSourceTextField("registeredCapital", "注册资金");
		registeredCapitalField.setLength(64);
		registeredCapitalField.setRequired(false);
		registeredCapitalField.setHidden(false);


		productionAddressField = new DataSourceTextField("productionAddress", "生产地址");
		productionAddressField.setLength(512);
		productionAddressField.setRequired(false);
		productionAddressField.setHidden(false);


		majorContactPersonField = new DataSourceTextField("majorContactPerson", "主要联系人");
		majorContactPersonField.setLength(128);
		majorContactPersonField.setRequired(false);
		majorContactPersonField.setHidden(false);


		contactPhoneField = new DataSourceTextField("contactPhone", "联系电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);


		emailField = new DataSourceTextField("email", "邮箱");
		emailField.setLength(64);
		emailField.setRequired(false);
		emailField.setHidden(false);


		faxField = new DataSourceTextField("fax", "传真");
		faxField.setLength(64);
		faxField.setRequired(false);
		faxField.setHidden(false);


		paymentMethodField = new DataSourceIntegerField("paymentMethod", "供应商支付方式");
		paymentMethodField.setLength(11);
		paymentMethodField.setRequired(false);
		paymentMethodField.setHidden(true);


		countryField = new DataSourceIntegerField("country", "供应商所在国家");
		countryField.setLength(11);
		countryField.setRequired(false);
		countryField.setHidden(false);
		countryField.setValueMap(KeyValueManager.getValueMap("countries"));


		provinceField = new DataSourceIntegerField("province", "供应商所在省份");
		provinceField.setLength(11);
		provinceField.setRequired(false);
		provinceField.setValueMap(KeyValueManager.getValueMap("provinces"));


		cityField = new DataSourceIntegerField("city", "供应商所在城市");
		cityField.setLength(11);
		cityField.setRequired(false);
		cityField.setValueMap(KeyValueManager.getValueMap("areas"));


		addressField = new DataSourceTextField("address", "供应商详细地址");
		addressField.setLength(512);
		addressField.setRequired(false);
		addressField.setHidden(true);


		bankNameField = new DataSourceTextField("bankName", "银行名称");
		bankNameField.setLength(512);
		bankNameField.setRequired(false);
		bankNameField.setHidden(true);


		payNameField = new DataSourceTextField("payName", "账户名称");
		payNameField.setLength(512);
		payNameField.setRequired(false);
		payNameField.setHidden(true);


		payCodeField = new DataSourceTextField("payCode", "银行账号");
		payCodeField.setLength(512);
		payCodeField.setRequired(false);
		payCodeField.setHidden(true);


		taxCodeField = new DataSourceTextField("taxCode", "税号");
		taxCodeField.setLength(128);
		taxCodeField.setRequired(false);
		taxCodeField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父级供应商");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		majorBusinessField = new DataSourceTextField("majorBusiness", "主要业务");
		majorBusinessField.setLength(512);
		majorBusinessField.setRequired(false);
		majorBusinessField.setHidden(true);


		startOrderCountField = new DataSourceIntegerField("startOrderCount", "起订量");
		startOrderCountField.setLength(11);
		startOrderCountField.setRequired(false);
		startOrderCountField.setHidden(true);


		productionCycleField = new DataSourceIntegerField("productionCycle", "生产周期");
		productionCycleField.setLength(11);
		productionCycleField.setRequired(false);
		productionCycleField.setHidden(true);


		logisticsCycleField = new DataSourceIntegerField("logisticsCycle", "物流周期");
		logisticsCycleField.setLength(11);
		logisticsCycleField.setRequired(false);
		logisticsCycleField.setHidden(true);


		logisticsTypeField = new DataSourceIntegerField("logisticsType", "物流方式");
		logisticsTypeField.setLength(11);
		logisticsTypeField.setRequired(false);
		logisticsTypeField.setHidden(true);
		logisticsTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_189"));


		isEnabledField = new DataSourceBooleanField("isEnabled", "是否可用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(true);


		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(true);
		createEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);
		
		abbreviatedNameField = new DataSourceTextField("abbreviatedName", "供应商简称");
		abbreviatedNameField.setLength(128);
		abbreviatedNameField.setRequired(false);
		abbreviatedNameField.setHidden(true);


		startCoworkDateField = new DataSourceDateField("startCoworkDate", "开始合作日期");
		startCoworkDateField.setRequired(false);
		startCoworkDateField.setHidden(true);


		warrantyPeriodField = new DataSourceTextField("warrantyPeriod", "质保期");
		warrantyPeriodField.setLength(64);
		warrantyPeriodField.setRequired(false);
		warrantyPeriodField.setHidden(true);


		isIncludeInstallField = new DataSourceBooleanField("isIncludeInstall", "是否含安装");
		isIncludeInstallField.setRequired(false);
		isIncludeInstallField.setHidden(true);


		accountPeriodField = new DataSourceTextField("accountPeriod", "账期");
		accountPeriodField.setLength(64);
		accountPeriodField.setRequired(false);
		accountPeriodField.setHidden(true);


		postCodeField = new DataSourceTextField("postCode", "邮编");
		postCodeField.setLength(64);
		postCodeField.setRequired(false);
		postCodeField.setHidden(true);


		setFields(supplierIdField, supplierCodeField, supplierNameField, supplierTypeField, supplierLevelField, registeredAddressField, registeredDateField, registeredCapitalField, productionAddressField, majorContactPersonField, contactPhoneField, emailField, faxField, paymentMethodField, countryField, provinceField, cityField, addressField, bankNameField, payNameField, payCodeField, taxCodeField, parentIdField, majorBusinessField, startOrderCountField, productionCycleField, logisticsCycleField, logisticsTypeField, isEnabledField, createEmployeeIdField, createTimeField, remarkField, abbreviatedNameField, startCoworkDateField, warrantyPeriodField, isIncludeInstallField, accountPeriodField, postCodeField);
	}


}

