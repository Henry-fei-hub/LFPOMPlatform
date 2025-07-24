package com.pomplatform.client.customer.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSCustomerInfo extends DBDataSource
{


	public static DSCustomerInfo instance = null;

	public static DSCustomerInfo getInstance() {
		if(instance == null) {
			instance = new DSCustomerInfo("DSCustomerInfo");
		}
		return instance;
	}

	private final DataSourceIntegerField customerIdField;
	private final DataSourceTextField customerNameField;
	private final DataSourceDateTimeField createTimeField;

	public DSCustomerInfo(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CustomerInfo");


		customerIdField = new DataSourceIntegerField("customerId", "主键编码");
		customerIdField.setLength(11);
		customerIdField.setPrimaryKey(true);
		customerIdField.setRequired(true);
		customerIdField.setHidden(true);


		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setLength(256);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(customerIdField, customerNameField, createTimeField);
	}


}

