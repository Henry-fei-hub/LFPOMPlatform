package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMemployeeSoftInstall extends DBDataSource
{


	public static DSMemployeeSoftInstall instance = null;

	public static DSMemployeeSoftInstall getInstance() {
		if(instance == null) {
			instance = new DSMemployeeSoftInstall("DSMemployeeSoftInstall");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;

	public DSMemployeeSoftInstall(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MemployeeSoftInstall");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工编码");
		employeeIdField.setLength(11);
		employeeIdField.setPrimaryKey(true);
		employeeIdField.setRequired(true);
		employeeIdField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		statusField = new DataSourceIntegerField("status", "安装状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);

		java.util.Map<String,String> statusValues = new java.util.HashMap<String,String>();
		statusValues.put("1", "未安装");
		statusValues.put("2", "已安装");
		statusField.setValueMap(statusValues);


		setFields(employeeIdField, employeeNameField, employeeNoField, departmentIdField, statusField);
	}


}

