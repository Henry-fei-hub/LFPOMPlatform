package com.pomplatform.client.sealkeepers.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSsealKeepersWorkflow extends DBDataSource
{


	public static DSsealKeepersWorkflow instance = null;

	public static DSsealKeepersWorkflow getInstance() {
		if(instance == null) {
			instance = new DSsealKeepersWorkflow("DSsealKeepersWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField sealKeeperIdField;
	private final DataSourceTextField sealNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceDateTimeField creatTimeField;
	private final DataSourceIntegerField operatorIdField;
	private final DataSourceIntegerField deleteFlagField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField numberField;
	private final DataSourceIntegerField sealTypeField;
	private final DataSourceTextField remarksField;

	public DSsealKeepersWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("sealKeepersWorkflow");


		sealKeeperIdField = new DataSourceIntegerField("sealKeeperId", "id");
		sealKeeperIdField.setLength(11);
		sealKeeperIdField.setPrimaryKey(true);
		sealKeeperIdField.setRequired(true);
		sealKeeperIdField.setHidden(true);


		sealNameField = new DataSourceTextField("sealName", "印章名称");
		sealNameField.setLength(32);
		sealNameField.setRequired(true);
		sealNameField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "保管员");
		employeeIdField.setLength(32);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		creatTimeField = new DataSourceDateTimeField("creatTime", "创建时间");
		creatTimeField.setLength(64);
		creatTimeField.setRequired(false);
		creatTimeField.setHidden(false);


		operatorIdField = new DataSourceIntegerField("operatorId", "操作人");
		operatorIdField.setLength(32);
		operatorIdField.setRequired(false);
		operatorIdField.setHidden(false);
		operatorIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除标志 0未删除 1已删除");
		deleteFlagField.setLength(32);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(32);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_307"));

		numberField = new DataSourceIntegerField("number", "数量");
		numberField.setLength(32);
		numberField.setRequired(false);
		numberField.setHidden(false);


		sealTypeField = new DataSourceIntegerField("sealType", "保管部门");
		sealTypeField.setLength(32);
		sealTypeField.setRequired(false);
		sealTypeField.setHidden(false);
		sealTypeField.setValueMap(KeyValueManager.getValueMap("departments"));


		remarksField = new DataSourceTextField("remarks", "备注");
		remarksField.setLength(128);
		remarksField.setRequired(false);
		remarksField.setHidden(false);


		setFields(sealKeeperIdField, sealNameField, employeeIdField, creatTimeField, operatorIdField, deleteFlagField, companyIdField, numberField, sealTypeField, remarksField);
	}


}

