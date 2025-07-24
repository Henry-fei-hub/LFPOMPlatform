package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnLoadProductInquirySupplierDetail extends DataSource
{


	public static CDOnLoadProductInquirySupplierDetail instance = null;

	public static CDOnLoadProductInquirySupplierDetail getInstance() {
		if(instance == null) {
			instance = new CDOnLoadProductInquirySupplierDetail("CDOnLoadProductInquirySupplierDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField priorityLevelField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField supplierContactIdField;
	private final DataSourceIntegerField productInquirySupplierDetailIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceIntegerField productInquiryDetailIdField;
	private final DataSourceIntegerField operatorIdField;

	public CDOnLoadProductInquirySupplierDetail(String dataSourceID) {

		setID(dataSourceID);
		priorityLevelField = new DataSourceIntegerField("priorityLevel", "优先级别");
		priorityLevelField.setRequired(false);
		priorityLevelField.setLength(11);
		priorityLevelField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		supplierContactIdField = new DataSourceIntegerField("supplierContactId", "供应商联系人主键");
		supplierContactIdField.setRequired(false);
		supplierContactIdField.setLength(11);
		supplierContactIdField.setHidden(false);

		productInquirySupplierDetailIdField = new DataSourceIntegerField("productInquirySupplierDetailId", "主键");
		productInquirySupplierDetailIdField.setRequired(true);
		productInquirySupplierDetailIdField.setLength(11);
		productInquirySupplierDetailIdField.setPrimaryKey(true);
		productInquirySupplierDetailIdField.setHidden(true);

		supplierIdField = new DataSourceIntegerField("supplierId", "供应商主键");
		supplierIdField.setRequired(false);
		supplierIdField.setLength(11);
		supplierIdField.setHidden(false);

		productInquiryDetailIdField = new DataSourceIntegerField("productInquiryDetailId", "询价详情表主键");
		productInquiryDetailIdField.setRequired(false);
		productInquiryDetailIdField.setLength(11);
		productInquiryDetailIdField.setHidden(false);

		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setRequired(false);
		operatorIdField.setLength(11);
		operatorIdField.setHidden(false);

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


		setFields(priorityLevelField, remarkField, supplierContactIdField, productInquirySupplierDetailIdField, supplierIdField, productInquiryDetailIdField, operatorIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

