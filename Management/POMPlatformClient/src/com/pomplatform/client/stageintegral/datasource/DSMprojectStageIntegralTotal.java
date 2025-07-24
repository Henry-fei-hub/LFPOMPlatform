package com.pomplatform.client.stageintegral.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMprojectStageIntegralTotal extends DBDataSource
{


	public static DSMprojectStageIntegralTotal instance = null;

	public static DSMprojectStageIntegralTotal getInstance() {
		if(instance == null) {
			instance = new DSMprojectStageIntegralTotal("DSMprojectStageIntegralTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageRecordIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceFloatField stageIntegralField;
	private final DataSourceFloatField stageSureIntegralField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField projectSureIntegralField;
	private final DataSourceFloatField stageFinalIntegralField;
	private final DataSourceFloatField projectFinalIntegralField;

	public DSMprojectStageIntegralTotal(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("MprojectStageIntegralTotal");


		projectStageRecordIdField = new DataSourceIntegerField("projectStageRecordId", "主键编码");
		projectStageRecordIdField.setLength(11);
		projectStageRecordIdField.setPrimaryKey(true);
		projectStageRecordIdField.setRequired(true);
		projectStageRecordIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
//		KeyValueManager.loadValueMap("projects",projectIdField);
        KeyValueManager.loadValueMap("projects",projectIdField);


		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);


		stageIntegralField = new DataSourceFloatField("stageIntegral", "阶段积分");
		stageIntegralField.setLength(18);
		stageIntegralField.setDecimalPad(2);
		stageIntegralField.setFormat("#,###,###,###,###,##0.00");
		stageIntegralField.setRequired(true);
		stageIntegralField.setHidden(false);


		stageSureIntegralField = new DataSourceFloatField("stageSureIntegral", "已确认阶段积分");
		stageSureIntegralField.setLength(18);
		stageSureIntegralField.setDecimalPad(2);
		stageSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		stageSureIntegralField.setRequired(true);
		stageSureIntegralField.setHidden(false);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(false);


		projectSureIntegralField = new DataSourceFloatField("projectSureIntegral", "已确认项目积分");
		projectSureIntegralField.setLength(18);
		projectSureIntegralField.setDecimalPad(2);
		projectSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectSureIntegralField.setRequired(true);
		projectSureIntegralField.setHidden(false);


		stageFinalIntegralField = new DataSourceFloatField("stageFinalIntegral", "未确认阶段积分");
		stageFinalIntegralField.setLength(18);
		stageFinalIntegralField.setDecimalPad(2);
		stageFinalIntegralField.setFormat("#,###,###,###,###,##0.00");
		stageFinalIntegralField.setRequired(true);
		stageFinalIntegralField.setHidden(false);


		projectFinalIntegralField = new DataSourceFloatField("projectFinalIntegral", "未确认项目积分");
		projectFinalIntegralField.setLength(18);
		projectFinalIntegralField.setDecimalPad(2);
		projectFinalIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectFinalIntegralField.setRequired(true);
		projectFinalIntegralField.setHidden(false);


		setFields(projectStageRecordIdField, projectIdField, stageIdField, stageIntegralField, stageSureIntegralField, projectIntegralField, projectSureIntegralField, stageFinalIntegralField, projectFinalIntegralField);
	}


}

