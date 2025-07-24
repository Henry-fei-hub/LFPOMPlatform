package com.pomplatform.client.workflow.datasource;

import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSMyWorkflowDatasource extends DBDataSource {

	public static DSMyWorkflowDatasource instance = null;

	public static DSMyWorkflowDatasource getInstance() {
		if (instance == null) {
			instance = new DSMyWorkflowDatasource("DSMyWorkflowDatasource");
		}
		return instance;
	}

	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceIntegerField processTypeField;

	public DSMyWorkflowDatasource(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("MyWorkflowDatasource");

		businessNameField = new DataSourceTextField("businessName", "事件类型");
		businessNameField.setLength(255);
		businessNameField.setHidden(false);

		activityTypeField = new DataSourceIntegerField("activityType", "模块类型");
		activityTypeField.setLength(11);
		activityTypeField.setHidden(true);
		
		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setHidden(true);

		setFields(businessNameField,activityTypeField, processTypeField);
	}

}
