package com.pomplatform.client.projectstages.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectstagecor extends DBDataSource
{


	public static DSSprojectstagecor instance = null;

	public static DSSprojectstagecor getInstance() {
		if(instance == null) {
			instance = new DSSprojectstagecor("DSSprojectstagecor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageIdField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceFloatField percentField;
	private final DataSourceTextField stageNameField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceFloatField projectAmountEdField;

	public DSSprojectstagecor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectstagecor");


		projectStageIdField = new DataSourceIntegerField("projectStageId", "项目阶段代码");
		projectStageIdField.setLength(11);
		projectStageIdField.setPrimaryKey(true);
		projectStageIdField.setRequired(true);
		projectStageIdField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "阶段代码");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);


		percentField = new DataSourceFloatField("percent", "占比(%)");
		percentField.setLength(18);
		percentField.setDecimalPad(2);
		percentField.setFormat("#,###,###,###,###,##0.00");
		percentField.setRequired(true);
		percentField.setHidden(false);


		stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(56);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "main_project_id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "合同id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		projectAmountField = new DataSourceFloatField("projectAmount", "未确认积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,###,###,##0.00");
		projectAmountField.setRequired(true);
		projectAmountField.setHidden(false);
	


		projectAmountEdField = new DataSourceFloatField("projectAmountEd", "已确认积分");
		projectAmountEdField.setLength(18);
		projectAmountEdField.setDecimalPad(5);
		projectAmountEdField.setFormat("#,###,###,###,##0.00");
		projectAmountEdField.setRequired(false);
		projectAmountEdField.setHidden(false);
		projectAmountEdField.setRootValue(0.0);


		setFields(projectStageIdField, stageIdField,  stageNameField,percentField, remarkField, mainProjectIdField, contractIdField, statusField, projectAmountField, projectAmountEdField);
	}


}

