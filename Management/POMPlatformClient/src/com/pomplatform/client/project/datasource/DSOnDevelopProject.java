package com.pomplatform.client.project.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnDevelopProject extends DBDataSource
{


	public static DSOnDevelopProject instance = null;

	public static DSOnDevelopProject getInstance() {
		if(instance == null) {
			instance = new DSOnDevelopProject("DSOnDevelopProject");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField plateManagerIdField;
	private final DataSourceTextField departmentManagerIdField;
	private final DataSourceTextField projectManageIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField startDateField;
	private final DataSourceIntegerField projectFlagField;
	private final DataSourceIntegerField projectSetupFlagField;

	public DSOnDevelopProject(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnDevelopProject");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);

		contractCodeField = new DataSourceTextField("contractCode", "项目编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts", contractCodeField);	


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(true);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		projectTypeField = new DataSourceIntegerField("projectType", "项目类别");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);


		startDateField = new DataSourceDateField("startDate", "立项日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);
		
		createTimeField = new DataSourceDateTimeField("createTime", "操作时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		plateManagerIdField = new DataSourceTextField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);
		plateManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		departmentManagerIdField = new DataSourceTextField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(false);
		departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		projectManageIdField = new DataSourceTextField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(true);
		remarkField.setHidden(false);
		
		projectFlagField = new DataSourceIntegerField("projectFlag", "项目标示类型");
		projectFlagField.setLength(11);
		projectFlagField.setRequired(false);
		projectFlagField.setHidden(true);
		
		projectSetupFlagField = new DataSourceIntegerField("projectSetupFlag", "项目立项标示");
		projectSetupFlagField.setLength(11);
		projectSetupFlagField.setRequired(false);
		projectSetupFlagField.setHidden(true);


		setFields(projectIdField, contractCodeField, projectCodeField, projectNameField, plateIdField, projectLevelField, businessTypeField, projectTypeField, projectIntegralField,startDateField,createTimeField, departmentIdField, plateManagerIdField, departmentManagerIdField, projectManageIdField, remarkField,projectFlagField,projectSetupFlagField);
	}


}

