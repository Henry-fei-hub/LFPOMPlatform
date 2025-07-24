package com.pomplatform.client.cwd.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDMsoftwareoperationlogeoseedor extends DataSource
{


	public static CDMsoftwareoperationlogeoseedor instance = null;

	public static CDMsoftwareoperationlogeoseedor getInstance() {
		if(instance == null) {
			instance = new CDMsoftwareoperationlogeoseedor("CDMsoftwareoperationlogeoseedor");
		}
		return instance;
	}

	private final DataSourceIntegerField operationTypeField;
	private final DataSourceIntegerField softwareTypeField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField departmentIdField;

	public CDMsoftwareoperationlogeoseedor(String dataSourceID) {

		setID(dataSourceID);
		operationTypeField = new DataSourceIntegerField("operationType", "操作类型");
		operationTypeField.setRequired(false);
		operationTypeField.setLength(11);
		operationTypeField.setHidden(false);

		java.util.Map<String,String> operationTypeValues = new java.util.HashMap<String,String>();
		operationTypeValues.put("1", "安装");
		operationTypeValues.put("2", "卸载");
		operationTypeValues.put("3", "更新");
		operationTypeField.setValueMap(operationTypeValues);

		softwareTypeField = new DataSourceIntegerField("softwareType", "软件类型");
		softwareTypeField.setRequired(false);
		softwareTypeField.setLength(11);
		softwareTypeField.setHidden(false);

		java.util.Map<String,String> softwareTypeValues = new java.util.HashMap<String,String>();
		softwareTypeValues.put("1", "本地文件服务");
		softwareTypeValues.put("2", "本地存储服务");
		softwareTypeField.setValueMap(softwareTypeValues);

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


		setFields(operationTypeField, softwareTypeField, employeeNoField, employeeNameField, departmentIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

