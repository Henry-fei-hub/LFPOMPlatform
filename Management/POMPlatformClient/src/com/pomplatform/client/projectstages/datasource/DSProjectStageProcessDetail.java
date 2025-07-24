package com.pomplatform.client.projectstages.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectStageProcessDetail extends DBDataSource
{


	public static DSProjectStageProcessDetail instance = null;

	public static DSProjectStageProcessDetail getInstance() {
		if(instance == null) {
			instance = new DSProjectStageProcessDetail("DSProjectStageProcessDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageProcessDetailIdField;
	private final DataSourceIntegerField projectStageProcessRecordIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceFloatField percentField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceTextField stageNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField mainProjectIdField;

	public DSProjectStageProcessDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectStageProcessDetail");


		projectStageProcessDetailIdField = new DataSourceIntegerField("projectStageProcessDetailId", "id");
		projectStageProcessDetailIdField.setLength(11);
		projectStageProcessDetailIdField.setPrimaryKey(true);
		projectStageProcessDetailIdField.setRequired(true);
		projectStageProcessDetailIdField.setHidden(true);


		projectStageProcessRecordIdField = new DataSourceIntegerField("projectStageProcessRecordId", "project_stage_process_record_id");
		projectStageProcessRecordIdField.setLength(11);
		projectStageProcessRecordIdField.setRequired(false);
		projectStageProcessRecordIdField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "阶段id");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);


		percentField = new DataSourceFloatField("percent", "占比");
		percentField.setLength(12);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,##0.00");
		percentField.setRequired(false);
		percentField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "阶段积分");
		projectAmountField.setLength(12);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(128);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "contract_id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "main_project_id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);


		setFields(projectStageProcessDetailIdField, projectStageProcessRecordIdField, stageIdField, percentField, projectAmountField, stageNameField, contractIdField, mainProjectIdField);
	}


}

