package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProductAttribute extends DBDataSource {

	public static DSProductAttribute instance = null;

	public static DSProductAttribute getInstance() {
		if (instance == null) {
			instance = new DSProductAttribute("DSProductAttribute");
		}
		return instance;
	}

	private final DataSourceIntegerField productAttributeIdField;
	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField attributeTypeField;
	private final DataSourceTextField attributeNameField;
	private final DataSourceTextField attributeValueField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;

	public DSProductAttribute(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProductAttribute");

		productAttributeIdField = new DataSourceIntegerField("productAttributeId", "主键编码");
		productAttributeIdField.setLength(11);
		productAttributeIdField.setPrimaryKey(true);
		productAttributeIdField.setRequired(true);
		productAttributeIdField.setHidden(true);

		productIdField = new DataSourceIntegerField("productId", "产品id");
		productIdField.setLength(11);
		productIdField.setRequired(false);
		productIdField.setHidden(true);
		productIdField.setForeignKey("DSSproductmmpor.productId");

		attributeTypeField = new DataSourceIntegerField("attributeType", "属性类型(预留)");
		attributeTypeField.setLength(11);
		attributeTypeField.setRequired(false);
		attributeTypeField.setHidden(true);

		attributeNameField = new DataSourceTextField("attributeName", "属性名称");
		attributeNameField.setLength(128);
		attributeNameField.setRequired(false);
		attributeNameField.setHidden(false);

		attributeValueField = new DataSourceTextField("attributeValue", "属性值");
		attributeValueField.setLength(1024);
		attributeValueField.setRequired(false);
		attributeValueField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(true);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		setFields(productAttributeIdField, productIdField, attributeTypeField, attributeNameField, attributeValueField,
				createEmployeeIdField, createTimeField, remarkField);
	}

}
