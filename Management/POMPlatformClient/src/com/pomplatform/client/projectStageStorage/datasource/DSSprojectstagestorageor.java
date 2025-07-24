package com.pomplatform.client.projectStageStorage.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectstagestorageor extends DBDataSource
{


	public static DSSprojectstagestorageor instance = null;

	public static DSSprojectstagestorageor getInstance() {
		if(instance == null) {
			instance = new DSSprojectstagestorageor("DSSprojectstagestorageor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageStorageIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField percentField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceTextField stageNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField riginalPlanField;
	private final DataSourceFloatField projectConfirmAmountField;
	private final DataSourceIntegerField tabAmountField;

	public DSSprojectstagestorageor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectstagestorageor");


		projectStageStorageIdField = new DataSourceIntegerField("projectStageStorageId", "id");
		projectStageStorageIdField.setLength(11);
		projectStageStorageIdField.setPrimaryKey(true);
		projectStageStorageIdField.setRequired(true);
		projectStageStorageIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		stageIdField = new DataSourceIntegerField("stageId", "阶段代码");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);


		percentField = new DataSourceIntegerField("percent", "占比(%)");
		percentField.setLength(11);
		percentField.setRequired(false);
		percentField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "项目积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(56);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		riginalPlanField = new DataSourceIntegerField("riginalPlan", "是否原策划阶段 0是  1否");
		riginalPlanField.setLength(11);
		riginalPlanField.setRequired(false);
		riginalPlanField.setHidden(false);


		projectConfirmAmountField = new DataSourceFloatField("projectConfirmAmount", "已确认积分");
		projectConfirmAmountField.setLength(18);
		projectConfirmAmountField.setDecimalPad(2);
		projectConfirmAmountField.setFormat("#,###,###,###,###,##0.00");
		projectConfirmAmountField.setRequired(false);
		projectConfirmAmountField.setHidden(false);


		tabAmountField = new DataSourceIntegerField("tabAmount", "是否跨阶段 0是  1否");
		tabAmountField.setLength(11);
		tabAmountField.setRequired(false);
		tabAmountField.setHidden(false);


		setFields(projectStageStorageIdField, projectIdField, stageIdField, percentField, projectAmountField, stageNameField, remarkField, riginalPlanField, projectConfirmAmountField, tabAmountField);
	}


}

