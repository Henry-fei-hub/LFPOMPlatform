package com.pomplatform.client.purchase.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.FieldType;

public class DSSproductmmpor extends DBDataSource {

	public static DSSproductmmpor instance = null;

	public static DSSproductmmpor getInstance() {
		if (instance == null) {
			instance = new DSSproductmmpor("DSSproductmmpor");
		}
		return instance;
	}

	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField categoryIdField;
	private final DataSourceTextField productNameField;
	private final DataSourceIntegerField productTypeField;
	private final DataSourceTextField productUnitField;
	private final DataSourceTextField productModelField;
	private final DataSourceTextField productSpecificationField;
	private final DataSourceTextField productSkinsSizeField;
	private final DataSourceBooleanField isEnabledField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceTextField remarkField;
	private final DataSourceField detailProductAttribute;

	public DSSproductmmpor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sproductmmpor");

		productIdField = new DataSourceIntegerField("productId", "主键编码");
		productIdField.setLength(11);
		productIdField.setPrimaryKey(true);
		productIdField.setRequired(true);
		productIdField.setHidden(true);
		productIdField.setRootValue("root");
		productIdField.setForeignKey("DSSproductmmpor.productId");

		categoryIdField = new DataSourceIntegerField("categoryId", "产品类别");
		categoryIdField.setLength(11);
		categoryIdField.setRequired(false);
		categoryIdField.setHidden(false);
		categoryIdField.setValueMap(KeyValueManager.getValueMap("product_categories"));

		productNameField = new DataSourceTextField("productName", "产品名称");
		productNameField.setLength(128);
		productNameField.setRequired(false);
		productNameField.setHidden(false);

		productTypeField = new DataSourceIntegerField("productType", "产品类型");
		productTypeField.setLength(11);
		productTypeField.setRequired(false);
		productTypeField.setHidden(false);
		productTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_192"));

		productUnitField = new DataSourceTextField("productUnit", "产品单位");
		productUnitField.setLength(128);
		productUnitField.setRequired(false);
		productUnitField.setHidden(false);

		productModelField = new DataSourceTextField("productModel", "产品型号");
		productModelField.setLength(128);
		productModelField.setRequired(false);
		productModelField.setHidden(false);

		productSpecificationField = new DataSourceTextField("productSpecification", "产品规格");
		productSpecificationField.setLength(64);
		productSpecificationField.setRequired(false);
		productSpecificationField.setHidden(false);

		productSkinsSizeField = new DataSourceTextField("productSkinsSize", "产品外观尺寸");
		productSkinsSizeField.setLength(64);
		productSkinsSizeField.setRequired(false);
		productSkinsSizeField.setHidden(false);

		isEnabledField = new DataSourceBooleanField("isEnabled", "是否可用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除标志 0未删除  1已删除");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		detailProductAttribute = new DataSourceField("detailProductAttribute", FieldType.ANY);
		detailProductAttribute.setChildrenProperty(true);
		detailProductAttribute.setChildTagName("ProductAttribute");
		detailProductAttribute.setRequired(false);
		detailProductAttribute.setHidden(true);

		setFields(productIdField, categoryIdField, productNameField, productTypeField, productUnitField,
				productModelField, productSpecificationField, productSkinsSizeField, isEnabledField,
				createEmployeeIdField, createTimeField, deleteFlagField, remarkField, detailProductAttribute);
	}

}
