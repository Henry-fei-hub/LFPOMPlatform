package com.pomplatform.client.stage.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;

public class DSProjectStagetemplate extends DBDataSource {

	public static DSProjectStagetemplate instance = null;

	public static DSProjectStagetemplate getInstance() {
		if (instance == null) {
			instance = new DSProjectStagetemplate("DSProjectStagetemplate");
		}
		return instance;
	}
	public static DSProjectStagetemplate getInstance(String dataSourceID) {
		if (instance == null) {
			instance = new DSProjectStagetemplate(dataSourceID);
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField percentField;
    private final DataSourceTextField stageNameField;
    private final DataSourceFloatField projectAmountField;

	public DSProjectStagetemplate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectStage");

		projectStageIdField = new DataSourceIntegerField("projectStageId", "项目阶段代码");
		projectStageIdField.setLength(11);
		projectStageIdField.setPrimaryKey(true);
		projectStageIdField.setRequired(true);
		projectStageIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);
		projectIdField.setForeignKey("DSProjectManager.projectId");

		stageIdField = new DataSourceIntegerField("stageId", "阶段代码");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));
                
        stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(56);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);
		stageNameField.setCanEdit(false);

		percentField = new DataSourceIntegerField("percent", "阶段占比(%)");
		percentField.setLength(11);
		percentField.setRequired(false);
		percentField.setHidden(false);
		percentField.setCanEdit(false);
		
		projectAmountField = new DataSourceFloatField("projectAmount","阶段积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("##,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);
		projectAmountField.setCanEdit(false);

		setFields(projectStageIdField, projectIdField, stageIdField, stageNameField, percentField,projectAmountField);
	}

}
