package com.pomplatform.client.taskmanage.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSCwdTaskTemplateDetail extends DBDataSource {

	public static DSCwdTaskTemplateDetail instance = null;

	public static DSCwdTaskTemplateDetail getInstance() {
		if (instance == null) {
			instance = new DSCwdTaskTemplateDetail("DSCwdTaskTemplateDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField cwdTaskTemplateDetailIdField;
	private final DataSourceIntegerField cwdTaskTemplateIdField;
	private final DataSourceTextField taskNameField;
	private final DataSourceTextField taskContentField;
	private final DataSourceTextField taskDemandField;
	private final DataSourceIntegerField numberOfDayField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField orderNumField;
	private final DataSourceIntegerField taskTypeField;
	private final DataSourceIntegerField taskLevelField;

	public DSCwdTaskTemplateDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("CwdTaskTemplateDetail");

		cwdTaskTemplateDetailIdField = new DataSourceIntegerField("cwdTaskTemplateDetailId", "主键");
		cwdTaskTemplateDetailIdField.setLength(11);
		cwdTaskTemplateDetailIdField.setPrimaryKey(true);
		cwdTaskTemplateDetailIdField.setRequired(true);
		cwdTaskTemplateDetailIdField.setHidden(false);

		cwdTaskTemplateIdField = new DataSourceIntegerField("cwdTaskTemplateId", "模板主键");
		cwdTaskTemplateIdField.setLength(11);
		cwdTaskTemplateIdField.setRequired(false);
		cwdTaskTemplateIdField.setHidden(true);

		taskNameField = new DataSourceTextField("taskName", "任务名称");
		taskNameField.setLength(255);
		taskNameField.setRequired(false);
		taskNameField.setHidden(false);

		taskContentField = new DataSourceTextField("taskContent", "任务内容");
		taskContentField.setLength(255);
		taskContentField.setRequired(false);
		taskContentField.setHidden(false);

		taskDemandField = new DataSourceTextField("taskDemand", "任务要求");
		taskDemandField.setLength(255);
		taskDemandField.setRequired(false);
		taskDemandField.setHidden(false);

		numberOfDayField = new DataSourceIntegerField("numberOfDay", "天数");
		numberOfDayField.setLength(11);
		numberOfDayField.setRequired(false);
		numberOfDayField.setHidden(false);

		parentIdField = new DataSourceIntegerField("parentId", "父级任务");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID + ".cwdTaskTemplateDetailId");
		parentIdField.setRootValue("0");
		parentIdField.setHidden(true);

		orderNumField = new DataSourceIntegerField("orderNum", "排序值  升序");
		orderNumField.setLength(11);
		orderNumField.setRequired(false);
		orderNumField.setHidden(true);

		taskTypeField = new DataSourceIntegerField("taskType", "任务类型");
		taskTypeField.setLength(11);
		taskTypeField.setRequired(false);
		taskTypeField.setHidden(false);
		taskTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_175"));

		taskLevelField = new DataSourceIntegerField("taskLevel", "任务级别");
		taskLevelField.setLength(11);
		taskLevelField.setRequired(false);
		taskLevelField.setHidden(false);
		taskLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_176"));

		setFields(cwdTaskTemplateDetailIdField, cwdTaskTemplateIdField, taskNameField, taskContentField,
				taskDemandField, numberOfDayField, parentIdField, orderNumField, taskTypeField, taskLevelField);
	}

}
