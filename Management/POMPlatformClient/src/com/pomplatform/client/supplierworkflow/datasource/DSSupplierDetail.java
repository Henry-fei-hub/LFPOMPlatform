package com.pomplatform.client.supplierworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSupplierDetail extends DBDataSource
{


	public static DSSupplierDetail instance = null;

	public static DSSupplierDetail getInstance() {
		if(instance == null) {
			instance = new DSSupplierDetail("DSSupplierDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField supplierDetailIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectAddressField;
	private final DataSourceTextField supplierDutyField;

	public DSSupplierDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SupplierDetail");


		supplierDetailIdField = new DataSourceIntegerField("supplierDetailId", "主键编码");
		supplierDetailIdField.setLength(11);
		supplierDetailIdField.setPrimaryKey(true);
		supplierDetailIdField.setRequired(true);
		supplierDetailIdField.setHidden(false);


		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "供应商项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectAddressField = new DataSourceTextField("projectAddress", "供应商项目地址");
		projectAddressField.setLength(255);
		projectAddressField.setRequired(false);
		projectAddressField.setHidden(false);


		supplierDutyField = new DataSourceTextField("supplierDuty", "供应商负责内容");
		supplierDutyField.setLength(255);
		supplierDutyField.setRequired(false);
		supplierDutyField.setHidden(false);


		setFields(supplierDetailIdField, supplierIdField, projectNameField, projectAddressField, supplierDutyField);
	}


}

