package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSUpdateActivityEmployee extends DBDataSource
{


	public static DSUpdateActivityEmployee instance = null;

	public static DSUpdateActivityEmployee getInstance() {
		if(instance == null) {
			instance = new DSUpdateActivityEmployee("DSUpdateActivityEmployee");
		}
		return instance;
	}

	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceIntegerField drafterField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField nodeIdField;
	private final DataSourceIntegerField nodeTypeField;

	public DSUpdateActivityEmployee(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("UpdateActivityEmployee");


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);
		businessIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));


		drafterField = new DataSourceIntegerField("drafter", "发起人");
		drafterField.setLength(11);
		drafterField.setRequired(true);
		drafterField.setHidden(false);
		drafterField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeIdField = new DataSourceIntegerField("employeeId", "节点审批人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		businessNameField = new DataSourceTextField("businessName", "摘要");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "节点状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_38"));


		nodeIdField = new DataSourceIntegerField("nodeId", "节点ID");
		nodeIdField.setLength(11);
		nodeIdField.setRequired(true);
		nodeIdField.setHidden(true);


		nodeTypeField = new DataSourceIntegerField("nodeType", "节点类型");
		nodeTypeField.setLength(11);
		nodeTypeField.setRequired(false);
		nodeTypeField.setHidden(false);

		java.util.Map<String,String> nodeTypeValues = new java.util.HashMap<String,String>();
		nodeTypeValues.put("1", "普通节点");
		nodeTypeValues.put("2", "任务池节点");
		nodeTypeField.setValueMap(nodeTypeValues);


		setFields(processTypeField, processIdField, processInstanceIdField, businessIdField, drafterField, employeeIdField, businessNameField, createTimeField, statusField, nodeIdField, nodeTypeField);
	}


}

