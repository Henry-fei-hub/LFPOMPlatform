package com.pomplatform.client.supplierworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSupplierCooperation extends DBDataSource
{


	public static DSSupplierCooperation instance = null;

	public static DSSupplierCooperation getInstance() {
		if(instance == null) {
			instance = new DSSupplierCooperation("DSSupplierCooperation");
		}
		return instance;
	}

	private final DataSourceIntegerField supplierCooperationIdField;
	private final DataSourceIntegerField supplierIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectLeaderField;
	private final DataSourceTextField supplierEvaluateField;

	public DSSupplierCooperation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SupplierCooperation");


		supplierCooperationIdField = new DataSourceIntegerField("supplierCooperationId", "主键编码");
		supplierCooperationIdField.setLength(11);
		supplierCooperationIdField.setPrimaryKey(true);
		supplierCooperationIdField.setRequired(true);
		supplierCooperationIdField.setHidden(false);


		supplierIdField = new DataSourceIntegerField("supplierId", "供应商编码");
		supplierIdField.setLength(11);
		supplierIdField.setRequired(false);
		supplierIdField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "合作项目名称");
		projectNameField.setLength(255);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectLeaderField = new DataSourceTextField("projectLeader", "项目负责人");
		projectLeaderField.setLength(64);
		projectLeaderField.setRequired(false);
		projectLeaderField.setHidden(false);


		supplierEvaluateField = new DataSourceTextField("supplierEvaluate", "供应商评价");
		supplierEvaluateField.setLength(512);
		supplierEvaluateField.setRequired(false);
		supplierEvaluateField.setHidden(false);


		setFields(supplierCooperationIdField, supplierIdField, projectNameField, projectLeaderField, supplierEvaluateField);
	}


}

