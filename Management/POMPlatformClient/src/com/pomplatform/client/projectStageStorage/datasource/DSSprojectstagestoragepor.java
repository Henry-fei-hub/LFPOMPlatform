package com.pomplatform.client.projectStageStorage.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectstagestoragepor extends DBDataSource
{


	public static DSSprojectstagestoragepor instance = null;

	public static DSSprojectstagestoragepor getInstance() {
		if(instance == null) {
			instance = new DSSprojectstagestoragepor("DSSprojectstagestoragepor");
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

	public DSSprojectstagestoragepor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Sprojectstagestoragepor");


		projectStageStorageIdField = new DataSourceIntegerField("projectStageStorageId", "id");
		projectStageStorageIdField.setLength(11);
		projectStageStorageIdField.setPrimaryKey(true);
		projectStageStorageIdField.setRequired(true);
		projectStageStorageIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


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
		projectAmountField.setDecimalPad(5);
		projectAmountField.setFormat("#,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		stageNameField = new DataSourceTextField("stageName", "阶段名称");
		stageNameField.setLength(56);
		stageNameField.setRequired(false);
		stageNameField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(255);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(projectStageStorageIdField, projectIdField, stageIdField, stageNameField, percentField, projectAmountField, remarkField);
	}


}

