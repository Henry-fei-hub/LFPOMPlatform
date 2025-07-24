package com.pomplatform.client.poolmanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnloadPoolEmployeeData extends DBDataSource
{


	public static DSOnloadPoolEmployeeData instance = null;

	public static DSOnloadPoolEmployeeData getInstance() {
		if(instance == null) {
			instance = new DSOnloadPoolEmployeeData("DSOnloadPoolEmployeeData");
		}
		return instance;
	}

	private final DataSourceIntegerField poolManageIdField;
	private final DataSourceIntegerField poolManageEmployeeIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField genderField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField businessIdsField;
	private final DataSourceTextField businessNamesField;
	private final DataSourceTextField professionalIdsField;
	private final DataSourceTextField professionalNamesField;
	private final DataSourceTextField buttonField;

	public DSOnloadPoolEmployeeData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnloadPoolEmployeeData");


		poolManageIdField = new DataSourceIntegerField("poolManageId", "池子id");
		poolManageIdField.setLength(11);
		poolManageIdField.setRequired(false);
		poolManageIdField.setHidden(true);


		poolManageEmployeeIdField = new DataSourceIntegerField("poolManageEmployeeId", "主键编码");
		poolManageEmployeeIdField.setLength(11);
		poolManageEmployeeIdField.setPrimaryKey(true);
		poolManageEmployeeIdField.setRequired(true);
		poolManageEmployeeIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "人员");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(true);
		employeeNameField.setHidden(false);


		genderField = new DataSourceIntegerField("gender", "性别");
		genderField.setLength(11);
		genderField.setRequired(false);
		genderField.setHidden(false);
		genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));


		departmentIdField = new DataSourceIntegerField("departmentId", "部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));
		
		businessIdsField = new DataSourceTextField("businessIds", "业态ID集");
		businessIdsField.setLength(64);
		businessIdsField.setRequired(true);
		businessIdsField.setHidden(true);
		
		businessNamesField = new DataSourceTextField("businessNames", "业态");
		businessNamesField.setLength(64);
		businessNamesField.setRequired(true);
		businessNamesField.setHidden(false);
		
		professionalIdsField = new DataSourceTextField("professionalIds", "专业ID集");
		professionalIdsField.setLength(64);
		professionalIdsField.setRequired(true);
		professionalIdsField.setHidden(true);
		
		professionalNamesField = new DataSourceTextField("professionalNames", "专业");
		professionalNamesField.setLength(64);
		professionalNamesField.setRequired(true);
		professionalNamesField.setHidden(false);
		
		buttonField = new DataSourceTextField("button", "身份标签设置");
		buttonField.setLength(64);
		buttonField.setRequired(true);
		buttonField.setHidden(true);


		setFields(poolManageEmployeeIdField, poolManageIdField, employeeIdField, employeeNoField, employeeNameField, genderField, departmentIdField,businessIdsField,businessNamesField,professionalIdsField,professionalNamesField,buttonField);
	}


}

