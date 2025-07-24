package com.pomplatform.client.project.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadProjectStageSettlement2 extends DBDataSource
{


	public static DSOnLoadProjectStageSettlement2 instance = null;

	public static DSOnLoadProjectStageSettlement2 getInstance() {
		if(instance == null) {
			instance = new DSOnLoadProjectStageSettlement2("DSOnLoadProjectStageSettlement2");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField percentField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceTextField stageNameField;
	private final DataSourceFloatField settlementIntegralField;
	private final DataSourceIntegerField attachmentNumField;
	private final DataSourceIntegerField settlementNumField;
	private final DataSourceFloatField stagePlanIntegralField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField projectTemplateIdField;

	public DSOnLoadProjectStageSettlement2(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadProjectStageSettlement2");


		projectStageIdField = new DataSourceIntegerField("projectStageId", "项目阶段代码");
		projectStageIdField.setLength(11);
		projectStageIdField.setPrimaryKey(true);
		projectStageIdField.setRequired(true);
		projectStageIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(false);


		stageIdField = new DataSourceIntegerField("stageId", "阶段id");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);


		percentField = new DataSourceIntegerField("percent", "占比(%)");
		percentField.setLength(11);
		percentField.setRequired(false);
		percentField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "项目积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(5);
		projectAmountField.setFormat("#,###,###,###,##0.00000");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(56);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);


		settlementIntegralField = new DataSourceFloatField("settlementIntegral", "settlementIntegral");
		settlementIntegralField.setLength(18);
		settlementIntegralField.setDecimalPad(2);
		settlementIntegralField.setFormat("#,###,###,###,###,##0.00");
		settlementIntegralField.setRequired(true);
		settlementIntegralField.setHidden(false);


		attachmentNumField = new DataSourceIntegerField("attachmentNum", "attachmentNum");
		attachmentNumField.setLength(8);
		attachmentNumField.setRequired(true);
		attachmentNumField.setHidden(false);


		settlementNumField = new DataSourceIntegerField("settlementNum", "settlementNum");
		settlementNumField.setLength(8);
		settlementNumField.setRequired(true);
		settlementNumField.setHidden(false);


		stagePlanIntegralField = new DataSourceFloatField("stagePlanIntegral", "stagePlanIntegral");
		stagePlanIntegralField.setLength(18);
		stagePlanIntegralField.setDecimalPad(2);
		stagePlanIntegralField.setFormat("#,###,###,###,###,##0.00");
		stagePlanIntegralField.setRequired(true);
		stagePlanIntegralField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "结算原因");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		projectTemplateIdField = new DataSourceIntegerField("projectTemplateId", "项目阶段模板id （project_templates）");
		projectTemplateIdField.setLength(11);
		projectTemplateIdField.setRequired(false);
		projectTemplateIdField.setHidden(false);


		setFields(projectStageIdField, projectIdField, stageIdField, percentField, projectAmountField, stageNameField, settlementIntegralField, attachmentNumField, settlementNumField, stagePlanIntegralField, remarkField, projectTemplateIdField);
	}


}

