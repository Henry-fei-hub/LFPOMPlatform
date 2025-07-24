package com.pomplatform.client.productcategory.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProductCategory extends DBDataSource
{


	public static DSProductCategory instance = null;

	public static DSProductCategory getInstance() {
		if(instance == null) {
			instance = new DSProductCategory("DSProductCategory");
		}
		return instance;
	}

	private final DataSourceIntegerField categoryIdField;
	private final DataSourceTextField categoryNameField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceBooleanField isEnabledField;
	private final DataSourceIntegerField createEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceTextField remarkField;

	public DSProductCategory(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProductCategory");


		categoryIdField = new DataSourceIntegerField("categoryId", "主键编码");
		categoryIdField.setLength(11);
		categoryIdField.setPrimaryKey(true);
		categoryIdField.setRequired(true);
		categoryIdField.setHidden(true);


		categoryNameField = new DataSourceTextField("categoryName", "类别名称");
		categoryNameField.setLength(128);
		categoryNameField.setRequired(false);
		categoryNameField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级id");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".categoryId");
		parentIdField.setRootValue("0");
		parentIdField.setHidden(false);


		isEnabledField = new DataSourceBooleanField("isEnabled", "是否可用");
		isEnabledField.setRequired(false);
		isEnabledField.setHidden(false);


		createEmployeeIdField = new DataSourceIntegerField("createEmployeeId", "创建人");
		createEmployeeIdField.setLength(11);
		createEmployeeIdField.setRequired(false);
		createEmployeeIdField.setHidden(false);
		createEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


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


		setFields(categoryIdField, categoryNameField, parentIdField, isEnabledField, createEmployeeIdField, createTimeField, deleteFlagField, remarkField);
	}


}

