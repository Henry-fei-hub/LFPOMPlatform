package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMemployeeSoftInstall extends DataSource
{


	public static CDMemployeeSoftInstall instance = null;

	public static CDMemployeeSoftInstall getInstance() {
		if(instance == null) {
			instance = new CDMemployeeSoftInstall("CDMemployeeSoftInstall");
		}
		return instance;
	}

	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField statusField;

	public CDMemployeeSoftInstall(String dataSourceID) {

		setID(dataSourceID);
		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setRequired(true);
		employeeNoField.setLength(64);
		employeeNoField.setHidden(false);

		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setRequired(true);
		employeeNameField.setLength(64);
		employeeNameField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		statusField = new DataSourceIntegerField("status", "安装状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);

		java.util.Map<String,String> statusValues = new java.util.HashMap<String,String>();
		statusValues.put("1", "未安装");
		statusValues.put("2", "已安装");
		statusField.setValueMap(statusValues);

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


		setFields(employeeNoField, employeeNameField, departmentIdField, statusField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

