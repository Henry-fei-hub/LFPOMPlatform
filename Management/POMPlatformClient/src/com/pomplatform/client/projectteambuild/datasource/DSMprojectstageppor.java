package com.pomplatform.client.projectteambuild.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMprojectstageppor extends DBDataSource
{


	public static DSMprojectstageppor instance = null;

	public static DSMprojectstageppor getInstance() {
		if(instance == null) {
			instance = new DSMprojectstageppor("DSMprojectstageppor");
		}
		return instance;
	}

	private final DataSourceIntegerField projectStageIdField;
	private final DataSourceTextField projectIdField;
	private final DataSourceTextField stageIdField;
	private final DataSourceIntegerField percentField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceTextField stageNameField;
	private final DataSourceFloatField leftIntegralField;

	public DSMprojectstageppor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Mprojectstageppor");


		projectStageIdField = new DataSourceIntegerField("projectStageId", "项目阶段代码");
		projectStageIdField.setLength(11);
		projectStageIdField.setPrimaryKey(true);
		projectStageIdField.setRequired(true);
		projectStageIdField.setHidden(true);


		projectIdField = new DataSourceTextField("projectId", "项目名称");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);
		KeyValueManager.loadValueMap("projects",projectIdField);

		stageIdField = new DataSourceTextField("stageId", "阶段代码");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(false);
		stageIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_7"));

		percentField = new DataSourceIntegerField("percent", "占比(%)");
		percentField.setLength(11);
		percentField.setRequired(false);
		percentField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "阶段积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(56);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);


		leftIntegralField = new DataSourceFloatField("leftIntegral", "阶段剩余积分");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(true);
		leftIntegralField.setHidden(false);


		setFields(projectStageIdField, projectIdField, stageIdField, percentField, projectAmountField, stageNameField, leftIntegralField);
	}


}

