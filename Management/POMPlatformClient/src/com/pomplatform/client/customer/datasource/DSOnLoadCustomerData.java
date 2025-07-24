package com.pomplatform.client.customer.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadCustomerData extends DBDataSource
{


	public static DSOnLoadCustomerData instance = null;

	public static DSOnLoadCustomerData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadCustomerData("DSOnLoadCustomerData");
		}
		return instance;
	}

	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField companyAddressField;
	private final DataSourceTextField companyMobileField;
	private final DataSourceIntegerField customerTypeField;
	private final DataSourceIntegerField customerLevelField;
	private final DataSourceIntegerField reportEmployeeIdField;
	private final DataSourceBooleanField isSureField;
	private final DataSourceBooleanField isWarehousField;
	private final DataSourceBooleanField isApplyQuoteField;
	private final DataSourceTextField companyProvinceField;
	private final DataSourceTextField companyCityField;
	private final DataSourceTextField postCodeField;
	private final DataSourceTextField webSiteField;
	private final DataSourceTextField companyFaxField;
	private final DataSourceTextField companyStockCodeField;
	private final DataSourceIntegerField companyEmployeeNumField;
	private final DataSourceDateField companySetupField;
	private final DataSourceTextField companyNatureField;
	private final DataSourceTextField companyQualificationField;
	private final DataSourceTextField companyOrganizationalField;
	private final DataSourceTextField companyBriefField;
	private final DataSourceTextField companyParentNameField;
	private final DataSourceTextField companyParentAddressField;
	private final DataSourceTextField companyChildNameField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;

	public DSOnLoadCustomerData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadCustomerData");


		customerIdField = new DataSourceIntegerField("customerId", "主键编码");
		customerIdField.setLength(11);
		customerIdField.setPrimaryKey(true);
		customerIdField.setRequired(true);
		customerIdField.setHidden(true);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(128);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		companyAddressField = new DataSourceTextField("companyAddress", "客户地址");
		companyAddressField.setLength(128);
		companyAddressField.setRequired(false);
		companyAddressField.setHidden(false);


		companyMobileField = new DataSourceTextField("companyMobile", "联系电话");
		companyMobileField.setLength(64);
		companyMobileField.setRequired(false);
		companyMobileField.setHidden(false);


		customerTypeField = new DataSourceIntegerField("customerType", "客户类型");
		customerTypeField.setLength(11);
		customerTypeField.setRequired(false);
		customerTypeField.setHidden(false);
		customerTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_151"));


		customerLevelField = new DataSourceIntegerField("customerLevel", "客户等级");
		customerLevelField.setLength(11);
		customerLevelField.setRequired(false);
		customerLevelField.setHidden(false);
		customerLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_145"));


		reportEmployeeIdField = new DataSourceIntegerField("reportEmployeeId", "报备人员");
		reportEmployeeIdField.setLength(11);
		reportEmployeeIdField.setRequired(false);
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
		companyProvinceField.setLength(64);
		companyProvinceField.setRequired(false);
		companyProvinceField.setHidden(false);


		companyCityField = new DataSourceTextField("companyCity", "城市");
		companyCityField.setLength(64);
		companyCityField.setRequired(false);
		companyCityField.setHidden(false);


		postCodeField = new DataSourceTextField("postCode", "邮编");
		postCodeField.setLength(64);
		postCodeField.setRequired(false);
		postCodeField.setHidden(true);


		webSiteField = new DataSourceTextField("webSite", "网站");
		webSiteField.setLength(64);
		webSiteField.setRequired(false);
		webSiteField.setHidden(true);


		companyFaxField = new DataSourceTextField("companyFax", "传真");
		companyFaxField.setLength(64);
		companyFaxField.setRequired(false);
		companyFaxField.setHidden(true);


		companyStockCodeField = new DataSourceTextField("companyStockCode", "股票代码");
		companyStockCodeField.setLength(64);
		companyStockCodeField.setRequired(false);
		companyStockCodeField.setHidden(true);


		companyEmployeeNumField = new DataSourceIntegerField("companyEmployeeNum", "公司人数");
		companyEmployeeNumField.setLength(11);
		companyEmployeeNumField.setRequired(false);
		companyEmployeeNumField.setHidden(true);


		companySetupField = new DataSourceDateField("companySetup", "公司成立日期");
		companySetupField.setRequired(false);
		companySetupField.setHidden(true);


		companyNatureField = new DataSourceTextField("companyNature", "企业性质");
		companyNatureField.setLength(64);
		companyNatureField.setRequired(false);
		companyNatureField.setHidden(true);


		companyQualificationField = new DataSourceTextField("companyQualification", "企业资质");
		companyQualificationField.setLength(64);
		companyQualificationField.setRequired(false);
		companyQualificationField.setHidden(true);


		companyOrganizationalField = new DataSourceTextField("companyOrganizational", "组织架构");
		companyOrganizationalField.setLength(512);
		companyOrganizationalField.setRequired(false);
		companyOrganizationalField.setHidden(true);


		companyBriefField = new DataSourceTextField("companyBrief", "公司简介");
		companyBriefField.setLength(10240);
		companyBriefField.setRequired(false);
		companyBriefField.setHidden(true);


		companyParentNameField = new DataSourceTextField("companyParentName", "客户集团公司名称");
		companyParentNameField.setLength(64);
		companyParentNameField.setRequired(false);
		companyParentNameField.setHidden(true);


		companyParentAddressField = new DataSourceTextField("companyParentAddress", "客户集团公司地址");
		companyParentAddressField.setLength(64);
		companyParentAddressField.setRequired(false);
		companyParentAddressField.setHidden(true);


		companyChildNameField = new DataSourceTextField("companyChildName", "分支机构");
		companyChildNameField.setLength(64);
		companyChildNameField.setRequired(false);
		companyChildNameField.setHidden(true);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "客户分类");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_159"));


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(customerIdField, customerNameField, companyAddressField, companyMobileField, customerTypeField, customerLevelField, reportEmployeeIdField, companyProvinceField, companyCityField, typeField, isSureField, isWarehousField, isApplyQuoteField, postCodeField, webSiteField, companyFaxField, companyStockCodeField, companyEmployeeNumField, companySetupField, companyNatureField, companyQualificationField, companyOrganizationalField, companyBriefField, companyParentNameField, companyParentAddressField, companyChildNameField, parentIdField, operateEmployeeIdField, createTimeField, remarkField);
	}


}

