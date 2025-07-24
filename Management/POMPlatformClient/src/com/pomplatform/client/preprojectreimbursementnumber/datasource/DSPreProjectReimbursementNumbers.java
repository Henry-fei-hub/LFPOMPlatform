package com.pomplatform.client.preprojectreimbursementnumber.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPreProjectReimbursementNumbers extends DBDataSource
{


	public static DSPreProjectReimbursementNumbers instance = null;

	public static DSPreProjectReimbursementNumbers getInstance() {
		if(instance == null) {
			instance = new DSPreProjectReimbursementNumbers("DSPreProjectReimbursementNumbers");
		}
		return instance;
	}

	private final DataSourceIntegerField preProjectReimbursementNumberIdField;
	private final DataSourceTextField customNumberField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField projectManagerField;
	private final DataSourceIntegerField operatorField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceTextField deptField;

	public DSPreProjectReimbursementNumbers(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("PreProjectReimbursementNumbers");


		preProjectReimbursementNumberIdField = new DataSourceIntegerField("preProjectReimbursementNumberId", "主键编码");
		preProjectReimbursementNumberIdField.setLength(11);
		preProjectReimbursementNumberIdField.setRequired(true);
		preProjectReimbursementNumberIdField.setHidden(true);


		customNumberField = new DataSourceTextField("customNumber", "前期项目信息编号");
		customNumberField.setLength(64);
		customNumberField.setRequired(false);
		customNumberField.setHidden(false);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "前期项目");
		mainProjectIdField.setLength(32);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);
//		mainProjectIdField.setValueMap(KeyValueManager.getValueMap("projects"));
		KeyValueManager.loadValueMap("projects", mainProjectIdField);


		projectManagerField = new DataSourceIntegerField("projectManager", "项目经理");
		projectManagerField.setLength(11);
		projectManagerField.setRequired(false);
		projectManagerField.setValueMap(KeyValueManager.getValueMap("employees"));


		operatorField = new DataSourceIntegerField("operator", "操作人");
		operatorField.setLength(11);
		operatorField.setRequired(false);
		operatorField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);


		businessTypeField = new DataSourceTextField("preBusinessType", "业务类别");
		businessTypeField.setLength(64);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		
		deptField = new DataSourceTextField("plateId", "部门");
		deptField.setLength(128);
		deptField.setRequired(false);
		deptField.setHidden(true);
		deptField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		projectTypeField = new DataSourceTextField("preProjectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_70"));


		setFields(preProjectReimbursementNumberIdField, customNumberField, mainProjectIdField,projectNameField, projectManagerField, operatorField, createTimeField, remarkField, projectCodeField, businessTypeField,deptField, projectTypeField);
	}


}

