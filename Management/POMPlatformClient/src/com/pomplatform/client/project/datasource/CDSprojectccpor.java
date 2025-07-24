package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDSprojectccpor extends DataSource
{


	public static CDSprojectccpor instance = null;

	public static CDSprojectccpor getInstance() {
		if(instance == null) {
			instance = new CDSprojectccpor("CDSprojectccpor");
		}
		return instance;
	}

	private final DataSourceIntegerField designPhaseField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField projectLevelField;

	public CDSprojectccpor(String dataSourceID) {

		setID(dataSourceID);
		designPhaseField = new DataSourceIntegerField("designPhase", "设计阶段");
		designPhaseField.setRequired(false);
		designPhaseField.setLength(11);
		designPhaseField.setHidden(false);
		designPhaseField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setRequired(false);
		contractNameField.setLength(512);
		contractNameField.setHidden(false);

		customerNameField = new DataSourceTextField("customerName", "客户名称");
		customerNameField.setRequired(false);
		customerNameField.setLength(512);
		customerNameField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setRequired(false);
		projectNameField.setLength(512);
		projectNameField.setHidden(false);

		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setRequired(false);
		contractCodeField.setLength(64);
		contractCodeField.setHidden(false);

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setRequired(false);
		departmentIdField.setLength(11);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setRequired(false);
		projectTypeField.setLength(11);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setRequired(false);
		projectCodeField.setLength(64);
		projectCodeField.setHidden(false);

		startDateField = new DataSourceDateField("startDate", "项目开始日期");
		startDateField.setRequired(false);
		startDateField.setHidden(false);

		endDateField = new DataSourceDateField("endDate", "项目结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "项目状态");
		statusField.setRequired(false);
		statusField.setLength(11);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_4"));

		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setRequired(false);
		projectLevelField.setLength(11);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));

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


		setFields(designPhaseField, contractNameField, customerNameField, projectNameField, contractCodeField, departmentIdField, projectTypeField, projectCodeField, startDateField, endDateField, statusField, projectLevelField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

