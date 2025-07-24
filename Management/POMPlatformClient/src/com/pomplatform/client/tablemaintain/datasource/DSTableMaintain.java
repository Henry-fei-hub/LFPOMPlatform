package com.pomplatform.client.tablemaintain.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSTableMaintain extends DBDataSource
{


	public static DSTableMaintain instance = null;

	public static DSTableMaintain getInstance() {
		if(instance == null) {
			instance = new DSTableMaintain("DSTableMaintain");
		}
		return instance;
	}

	private final DataSourceIntegerField tableMaintainIdField;
	private final DataSourceTextField tableNameField;
	private final DataSourceTextField remarkField;

	public DSTableMaintain(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("TableMaintain");


		tableMaintainIdField = new DataSourceIntegerField("tableMaintainId", "数据库表维护主键");
		tableMaintainIdField.setLength(11);
		tableMaintainIdField.setPrimaryKey(true);
		tableMaintainIdField.setRequired(true);
		tableMaintainIdField.setHidden(true);


		tableNameField = new DataSourceTextField("tableName", "数据库名称");
		tableNameField.setLength(255);
		tableNameField.setRequired(false);
		tableNameField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(tableMaintainIdField, tableNameField, remarkField);
	}


}

