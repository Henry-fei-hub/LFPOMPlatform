package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadProductInquirySupplierDetail extends DBDataSource {

	public static DSOnLoadProductInquirySupplierDetail instance = null;

	public static DSOnLoadProductInquirySupplierDetail getInstance() {
		if (instance == null) {
			instance = new DSOnLoadProductInquirySupplierDetail("DSOnLoadProductInquirySupplierDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField productInquirySupplierDetailIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField productInquiryDetailIdField;
	private final DataSourceFloatField productPriceField;
	private final DataSourceFloatField totalPriceField;
	private final DataSourceFloatField taxPointsField;
	private final DataSourceIntegerField priorityLevelField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField inquiryDateField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceIntegerField supplierContactIdField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPositionField;
	private final DataSourceIntegerField contactGenderField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField contactEmailField;
	private final DataSourceTextField contactFaxField;
	private final DataSourceIntegerField contactTypeField;
	private final DataSourceBooleanField isSelectField;

	public DSOnLoadProductInquirySupplierDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProductInquirySupplierDetail");

		productInquirySupplierDetailIdField = new DataSourceIntegerField("productInquirySupplierDetailId", "主键");
		productInquirySupplierDetailIdField.setLength(11);
		productInquirySupplierDetailIdField.setPrimaryKey(true);
		productInquirySupplierDetailIdField.setRequired(true);
		productInquirySupplierDetailIdField.setHidden(true);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商主键");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(false);
		supplierIdField.setValueMap(KeyValueManager.getValueMap("suppliers"));

		productInquiryDetailIdField = new DataSourceIntegerField("productInquiryDetailId", "询价详情表主键");
		productInquiryDetailIdField.setLength(11);
		productInquiryDetailIdField.setRequired(false);
		productInquiryDetailIdField.setHidden(true);
		productInquiryDetailIdField.setForeignKey("DSProductInquiryDetail.productInquiryDetailId");

		productPriceField = new DataSourceFloatField("productPrice", "单价");
		productPriceField.setLength(16);
		productPriceField.setDecimalPad(2);
		productPriceField.setFormat("##,###,###,###,##0.00");
		productPriceField.setRequired(false);
		productPriceField.setHidden(false);

		totalPriceField = new DataSourceFloatField("totalPrice", "总价");
		totalPriceField.setLength(16);
		totalPriceField.setDecimalPad(2);
		totalPriceField.setFormat("##,###,###,###,##0.00");
		totalPriceField.setRequired(false);
		totalPriceField.setHidden(false);

		taxPointsField = new DataSourceFloatField("taxPoints", "含税点");
		taxPointsField.setLength(16);
		taxPointsField.setDecimalPad(2);
		taxPointsField.setFormat("##,###,###,###,##0.00");
		taxPointsField.setRequired(false);
		taxPointsField.setHidden(false);

		priorityLevelField = new DataSourceIntegerField("priorityLevel", "优先级别");
		priorityLevelField.setLength(11);
		priorityLevelField.setRequired(false);
		priorityLevelField.setHidden(false);
		priorityLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_193"));

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		inquiryDateField = new DataSourceDateField("inquiryDate", "询价日期");
		inquiryDateField.setRequired(false);
		inquiryDateField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建日期");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(11);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(true);

		supplierContactIdField = new DataSourceIntegerField("supplierContactId", "供应商联系人主键");
		supplierContactIdField.setLength(11);
		supplierContactIdField.setRequired(false);
		supplierContactIdField.setHidden(true);

		contactNameField = new DataSourceTextField("contactName", "联系人姓名");
		contactNameField.setLength(128);
		contactNameField.setRequired(false);
		contactNameField.setHidden(false);

		contactPositionField = new DataSourceTextField("contactPosition", "联系人职位");
		contactPositionField.setLength(128);
		contactPositionField.setRequired(false);
		contactPositionField.setHidden(true);

		contactGenderField = new DataSourceIntegerField("contactGender", "2女)");
		contactGenderField.setLength(11);
		contactGenderField.setRequired(false);
		contactGenderField.setHidden(true);

		contactPhoneField = new DataSourceTextField("contactPhone", "联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(false);

		contactEmailField = new DataSourceTextField("contactEmail", "联系人邮箱");
		contactEmailField.setLength(64);
		contactEmailField.setRequired(false);
		contactEmailField.setHidden(true);

		contactFaxField = new DataSourceTextField("contactFax", "联系人传真");
		contactFaxField.setLength(64);
		contactFaxField.setRequired(false);
		contactFaxField.setHidden(true);

		contactTypeField = new DataSourceIntegerField("contactType", "2其他)");
		contactTypeField.setLength(11);
		contactTypeField.setRequired(false);
		contactTypeField.setHidden(true);

		isSelectField = new DataSourceBooleanField("isSelect", "是否为最终报价");
		isSelectField.setRequired(false);
		
		setFields(productInquirySupplierDetailIdField, supplierIdField, productInquiryDetailIdField, productPriceField,
				totalPriceField, taxPointsField, priorityLevelField, remarkField, inquiryDateField, createTimeField,
				operatorIdField, supplierContactIdField, contactNameField, contactPositionField, contactGenderField,
				contactPhoneField, contactEmailField, contactFaxField, contactTypeField, isSelectField);
	}

}
