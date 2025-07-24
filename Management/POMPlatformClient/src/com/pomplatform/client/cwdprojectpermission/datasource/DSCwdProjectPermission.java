package com.pomplatform.client.cwdprojectpermission.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;

public class DSCwdProjectPermission extends DBDataSource
{


	public static DSCwdProjectPermission instance = null;

	public static DSCwdProjectPermission getInstance() {
		if(instance == null) {
			instance = new DSCwdProjectPermission("DSCwdProjectPermission");
		}
		return instance;
	}

	private final DataSourceIntegerField cwdProjectPermissionIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField permissionTypeField;
	private final DataSourceIntegerField operatePersonField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField deleteFlagField;

	public DSCwdProjectPermission(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CwdProjectPermission");


		cwdProjectPermissionIdField = new DataSourceIntegerField("cwdProjectPermissionId", "主键编码");
		cwdProjectPermissionIdField.setLength(11);
		cwdProjectPermissionIdField.setPrimaryKey(true);
		cwdProjectPermissionIdField.setRequired(true);
		cwdProjectPermissionIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		permissionTypeField = new DataSourceIntegerField("permissionType", "CDC项目查看权限");
		permissionTypeField.setLength(11);
		permissionTypeField.setRequired(false);
		permissionTypeField.setHidden(false);
		permissionTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_238"));


		operatePersonField = new DataSourceIntegerField("operatePerson", "操作人");
		operatePersonField.setLength(11);
		operatePersonField.setRequired(false);
		operatePersonField.setHidden(false);
		operatePersonField.setValueMap(KeyValueManager.getValueMap("employees"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		deleteFlagField = new DataSourceIntegerField("deleteFlag", "删除状态");
		deleteFlagField.setLength(11);
		deleteFlagField.setRequired(false);
		deleteFlagField.setHidden(true);


		setFields(cwdProjectPermissionIdField, employeeIdField, permissionTypeField, operatePersonField, createTimeField, deleteFlagField);
	}


}

