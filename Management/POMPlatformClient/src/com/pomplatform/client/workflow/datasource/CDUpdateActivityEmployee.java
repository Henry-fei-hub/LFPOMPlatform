package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDUpdateActivityEmployee extends DataSource
{


	public static CDUpdateActivityEmployee instance = null;

	public static CDUpdateActivityEmployee getInstance() {
		if(instance == null) {
			instance = new CDUpdateActivityEmployee("CDUpdateActivityEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceDateTimeField createTimeStartField;
	private final DataSourceDateTimeField createTimeEndField;

	public CDUpdateActivityEmployee(String dataSourceID) {

		setID(dataSourceID);
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setRequired(false);
		processTypeField.setLength(11);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));

		drafterField = new DataSourceIntegerField("drafter", "发起人");
		drafterField.setRequired(false);
		drafterField.setLength(11);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeIdField = new DataSourceIntegerField("employeeId", "节点审批人");
		employeeIdField.setRequired(false);
		employeeIdField.setLength(11);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		businessNameField = new DataSourceTextField("businessName", "摘要");
		businessNameField.setRequired(false);
		businessNameField.setLength(256);
		businessNameField.setHidden(false);

		createTimeStartField = new DataSourceDateTimeField("createTimeStart", "创建时间（开始）");
		createTimeStartField.setRequired(false);
		createTimeStartField.setHidden(false);

		createTimeEndField = new DataSourceDateTimeField("createTimeEnd", "创建时间（截止）");
		createTimeEndField.setRequired(false);
		createTimeEndField.setHidden(false);

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


		setFields(processTypeField, drafterField, employeeIdField, businessNameField, createTimeStartField, createTimeEndField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

