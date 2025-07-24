package com.pomplatform.client.projectsuredaterecord.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSProjectSureDateRecord extends DBDataSource
{


	public static DSProjectSureDateRecord instance = null;

	public static DSProjectSureDateRecord getInstance() {
		if(instance == null) {
			instance = new DSProjectSureDateRecord("DSProjectSureDateRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceDateField sureDateField;

	public DSProjectSureDateRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectSureDateRecord");


		projectIdField = new DataSourceIntegerField("projectId", "ID");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);
//		KeyValueManager.loadValueMap("projects",projectIdField);
		KeyValueManager.loadValueMap("projects", projectIdField);


		contractCodeField = new DataSourceTextField("contractCode", "订单编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));

		KeyValueManager.loadValueMap("contracts",contractCodeField);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		sureDateField = new DataSourceDateField("sureDate", "最新确认日期");
		sureDateField.setLength(16);
		sureDateField.setRequired(true);
		sureDateField.setHidden(false);


		setFields(projectIdField, contractCodeField, projectNameField, plateIdField, projectManageIdField, sureDateField);
	}


}

