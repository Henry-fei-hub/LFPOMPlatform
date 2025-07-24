package com.pomplatform.client.purchase.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSproductmmpor extends DataSource
{


	public static CDSproductmmpor instance = null;

	public static CDSproductmmpor getInstance() {
		if(instance == null) {
			instance = new CDSproductmmpor("CDSproductmmpor");
		}
		return instance;
	}

	private final DataSourceDateTimeField minCreateTimeField;
	private final DataSourceDateTimeField maxCreateTimeField;
	private final DataSourceTextField productModelField;
	private final DataSourceTextField productSpecificationField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField productIdField;
	private final DataSourceIntegerField categoryIdField;
	private final DataSourceIntegerField productTypeField;
	private final DataSourceBooleanField isEnabledField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceIntegerField deleteFlagField;

	public CDSproductmmpor(String dataSourceID) {

		setID(dataSourceID);
		minCreateTimeField = new DataSourceDateTimeField("minCreateTime", "最早创建时间");
		minCreateTimeField.setRequired(false);
		minCreateTimeField.setHidden(false);

		maxCreateTimeField = new DataSourceDateTimeField("maxCreateTime", "最晚创建时间");
		maxCreateTimeField.setRequired(false);
		maxCreateTimeField.setHidden(false);

		productModelField = new DataSourceTextField("productModel", "产品型号");
		productModelField.setRequired(false);
		productModelField.setLength(128);
		productModelField.setHidden(false);

		productSpecificationField = new DataSourceTextField("productSpecification", "产品规格");
		productSpecificationField.setRequired(false);
		productSpecificationField.setLength(64);
		productSpecificationField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(1024);
		remarkField.setHidden(false);

		productIdField = new DataSourceIntegerField("productId", "主键编码");
		productIdField.setRequired(true);
		productIdField.setLength(11);
		productIdField.setPrimaryKey(true);
		productIdField.setHidden(true);

		categoryIdField = new DataSourceIntegerField("categoryId", "产品类别id");
		categoryIdField.setRequired(false);
		categoryIdField.setLength(11);
		categoryIdField.setHidden(false);

		productTypeField = new DataSourceIntegerField("productType", "产品类型");
		productTypeField.setRequired(false);
		productTypeField.setLength(11);
		productTypeField.setHidden(false);

		isEnabledField = new DataSourceBooleanField("isEnabled", "是否可用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(false);

		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setHidden(false);

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除标志 0未删除  1已删除");
		deleteFlagField.setRequired(false);
		deleteFlagField.setLength(11);
		deleteFlagField.setHidden(false);

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


		setFields(minCreateTimeField, maxCreateTimeField, productModelField, productSpecificationField, remarkField, productIdField, categoryIdField, productTypeField, isEnabledField, createEmployeeIdField, deleteFlagField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

