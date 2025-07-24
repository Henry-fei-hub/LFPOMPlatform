package com.pomplatform.client.cwdprojectpermission.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDCwdProjectPermission extends DataSource
{


	public static CDCwdProjectPermission instance = null;

	public static CDCwdProjectPermission getInstance() {
		if(instance == null) {
			instance = new CDCwdProjectPermission("CDCwdProjectPermission");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField permissionTypeField;
	private final DataSourceIntegerField operatePersonField;

	public CDCwdProjectPermission(String dataSourceID) {

		setID(dataSourceID);
		employeeIdField = new DataSourceIntegerField("employeeId", "职员");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		permissionTypeField = new DataSourceIntegerField("permissionType", "CDC项目查看权限");
		permissionTypeField.setRequired(false);
		permissionTypeField.setLength(11);
		permissionTypeField.setHidden(false);
		permissionTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		operatePersonField = new DataSourceIntegerField("operatePerson", "操作人");
		operatePersonField.setRequired(false);
		operatePersonField.setLength(11);
		operatePersonField.setHidden(false);
		operatePersonField.setValueMap(KeyValueManager.getValueMap("employees"));

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


		setFields(employeeIdField, permissionTypeField, operatePersonField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

