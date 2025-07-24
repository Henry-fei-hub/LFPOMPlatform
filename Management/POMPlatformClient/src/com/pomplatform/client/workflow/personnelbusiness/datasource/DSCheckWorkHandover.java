package com.pomplatform.client.workflow.personnelbusiness.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCheckWorkHandover extends DBDataSource
{


	public static DSCheckWorkHandover instance = null;

	public static DSCheckWorkHandover getInstance() {
		if(instance == null) {
			instance = new DSCheckWorkHandover("DSCheckWorkHandover");
		}
		return instance;
	}

	private final DataSourceIntegerField workHandoverIdField;
	private final DataSourceIntegerField typeField;
	private final DataSourceIntegerField linkIdField;
	private final DataSourceTextField nameField;
	private final DataSourceTextField contentField;
	private final DataSourceIntegerField fromEmployeeIdField;
	private final DataSourceIntegerField toEmployeeIdField;
	private final DataSourceDateTimeField createTimeField;

	public DSCheckWorkHandover(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("CheckWorkHandover");


		workHandoverIdField = new DataSourceIntegerField("workHandoverId", "工作交接表编码");
		workHandoverIdField.setLength(11);
		workHandoverIdField.setPrimaryKey(true);
		workHandoverIdField.setRequired(true);
		workHandoverIdField.setHidden(true);


		typeField = new DataSourceIntegerField("type", "工作交接类型 ");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(false);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_100"));


		linkIdField = new DataSourceIntegerField("linkId", "关联编码");
		linkIdField.setLength(11);
		linkIdField.setRequired(false);
		linkIdField.setHidden(true);


		nameField = new DataSourceTextField("name", "名称");
		nameField.setLength(128);
		nameField.setRequired(false);
		nameField.setHidden(false);


		contentField = new DataSourceTextField("content", "主要内容");
		contentField.setLength(512);
		contentField.setRequired(false);
		contentField.setHidden(false);


		fromEmployeeIdField = new DataSourceIntegerField("fromEmployeeId", "交接者");
		fromEmployeeIdField.setLength(11);
		fromEmployeeIdField.setRequired(false);
		fromEmployeeIdField.setHidden(false);
		fromEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		toEmployeeIdField = new DataSourceIntegerField("toEmployeeId", "被交接者");
		toEmployeeIdField.setLength(11);
		toEmployeeIdField.setRequired(false);
		toEmployeeIdField.setHidden(false);
		toEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		setFields(workHandoverIdField, typeField, linkIdField, nameField, contentField, fromEmployeeIdField, toEmployeeIdField, createTimeField);
	}


}

