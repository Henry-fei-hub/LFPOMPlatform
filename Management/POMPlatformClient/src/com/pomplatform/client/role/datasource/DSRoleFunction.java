package com.pomplatform.client.role.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSRoleFunction extends DBDataSource
{


	public static DSRoleFunction instance = null;

	public static DSRoleFunction getInstance() {
		if(instance == null) {
			instance = new DSRoleFunction("DSRoleFunction");
		}
		return instance;
	}

	private final DataSourceIntegerField roleFunctionIdField;
	private final DataSourceIntegerField roleIdField;
	private final DataSourceIntegerField functionIdField;

	public DSRoleFunction(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("RoleFunction");


		roleFunctionIdField = new DataSourceIntegerField("roleFunctionId", "角色功能编码");
		roleFunctionIdField.setLength(11);
		roleFunctionIdField.setPrimaryKey(true);
		roleFunctionIdField.setRequired(true);
		roleFunctionIdField.setHidden(false);


		roleIdField = new DataSourceIntegerField("roleId", "角色编码");
		roleIdField.setLength(11);
		roleIdField.setRequired(false);
		roleIdField.setHidden(false);


		functionIdField = new DataSourceIntegerField("functionId", "功能编码");
		functionIdField.setLength(11);
		functionIdField.setRequired(false);
		functionIdField.setHidden(false);


		setFields(roleFunctionIdField, roleIdField, functionIdField);
	}


}

