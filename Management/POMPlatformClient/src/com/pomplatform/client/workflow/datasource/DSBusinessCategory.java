package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBusinessCategory extends DBDataSource
{


	public static DSBusinessCategory instance = null;

	public static DSBusinessCategory getInstance() {
		if(instance == null) {
			instance = new DSBusinessCategory("DSBusinessCategory");
		}
		return instance;
	}

	private final DataSourceIntegerField businessCategoryIdField;
	private final DataSourceTextField businessCategoryNameField;
	private final DataSourceTextField businessCategoryCodeField;
	private final DataSourceIntegerField parentIdField;

	public DSBusinessCategory(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BusinessCategory");


		businessCategoryIdField = new DataSourceIntegerField("businessCategoryId", "主键编码");
		businessCategoryIdField.setLength(11);
		businessCategoryIdField.setPrimaryKey(true);
		businessCategoryIdField.setRequired(true);
		businessCategoryIdField.setHidden(false);


		businessCategoryNameField = new DataSourceTextField("businessCategoryName", "业务类别名称");
		businessCategoryNameField.setLength(255);
		businessCategoryNameField.setRequired(false);
		businessCategoryNameField.setHidden(false);


		businessCategoryCodeField = new DataSourceTextField("businessCategoryCode", "业务类别编码");
		businessCategoryCodeField.setLength(255);
		businessCategoryCodeField.setRequired(false);
		businessCategoryCodeField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父类编码（没有父类id则为0）");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(false);


		setFields(businessCategoryIdField, businessCategoryNameField, businessCategoryCodeField, parentIdField);
	}


}

