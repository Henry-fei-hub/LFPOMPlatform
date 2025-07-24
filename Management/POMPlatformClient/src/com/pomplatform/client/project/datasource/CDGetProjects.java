package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDGetProjects extends DataSource
{


	public static CDGetProjects instance = null;

	public static CDGetProjects getInstance() {
		if(instance == null) {
			instance = new CDGetProjects("CDGetProjects");
		}
		return instance;
	}

	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField designTypeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField subContractIdField;
	private final DataSourceIntegerField projectSetupFlagField;
	private final DataSourceBooleanField isLockField;

	public CDGetProjects(String dataSourceID) {

		setID(dataSourceID);
		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setHidden(false);
		departmentManagerIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "板块负责人");
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setLength(11);
		plateManagerIdField.setHidden(true);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
        KeyValueManager.loadValueMap("contracts",contractCodeField);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);
//		projectCodeField.setValueMap(KeyValueManager.getValueMap("main_projects"));
		KeyValueManager.loadValueMap("main_projects",projectCodeField);
		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setRequired(true);
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects",projectIdField);

		plateIdField = new DataSourceIntegerField("plateId", "板块");
		plateIdField.setRequired(false);
		plateIdField.setLength(11);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		designTypeField = new DataSourceIntegerField("designType", "设计类别");
		designTypeField.setRequired(false);
		designTypeField.setLength(11);
		designTypeField.setHidden(false);
		designTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setRequired(false);
		projectManageIdField.setLength(11);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setRequired(false);
		businessTypeField.setLength(11);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary"));

		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setRequired(false);
		contractIdField.setLength(11);
		contractIdField.setHidden(false);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
        KeyValueManager.loadValueMap("contracts",contractIdField);

		subContractIdField = new DataSourceIntegerField("subContractId", "子合同编码");
		subContractIdField.setRequired(false);
		subContractIdField.setLength(11);
		subContractIdField.setHidden(false);
//		subContractIdField.setValueMap(KeyValueManager.getValueMap("sub_contracts"));
		KeyValueManager.loadValueMap("sub_contracts",subContractIdField);

		projectSetupFlagField = new DataSourceIntegerField("projectSetupFlag", ")");
		projectSetupFlagField.setRequired(false);
		projectSetupFlagField.setLength(11);
		projectSetupFlagField.setHidden(false);

		isLockField = new DataSourceBooleanField("isLock", "是否加锁");
		isLockField.setRequired(false);
		isLockField.setHidden(false);

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


		setFields(departmentManagerIdField, plateManagerIdField, contractCodeField, projectCodeField, projectNameField, projectIdField, plateIdField, designTypeField, departmentIdField, projectLevelField, statusField, projectManageIdField, businessTypeField, contractIdField, subContractIdField, projectSetupFlagField, isLockField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

