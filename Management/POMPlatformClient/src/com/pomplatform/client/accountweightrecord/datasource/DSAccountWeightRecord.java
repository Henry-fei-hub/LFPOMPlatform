package com.pomplatform.client.accountweightrecord.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAccountWeightRecord extends DBDataSource
{


	public static DSAccountWeightRecord instance = null;

	public static DSAccountWeightRecord getInstance() {
		if(instance == null) {
			instance = new DSAccountWeightRecord("DSAccountWeightRecord");
		}
		return instance;
	}

	private final DataSourceIntegerField accountWeightRecordIdField;
	private final DataSourceIntegerField typeIdField;
	private final DataSourceTextField typeNameField;
	private final DataSourceFloatField percentField;
	private final DataSourceTextField percentViewField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceIntegerField levelField;
	private final DataSourceIntegerField settlementLevelField;
	private final DataSourceIntegerField orderFlagField;
	private final DataSourceBooleanField enabledField;

	public DSAccountWeightRecord(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("AccountWeightRecord");


		accountWeightRecordIdField = new DataSourceIntegerField("accountWeightRecordId", "主键编码");
		accountWeightRecordIdField.setLength(11);
		accountWeightRecordIdField.setPrimaryKey(true);
		accountWeightRecordIdField.setRequired(true);
		accountWeightRecordIdField.setHidden(true);


		typeIdField = new DataSourceIntegerField("typeId", "类型编码");
		typeIdField.setLength(11);
		typeIdField.setRequired(false);
		typeIdField.setHidden(true);


		typeNameField = new DataSourceTextField("typeName", "类型名称");
		typeNameField.setLength(128);
		typeNameField.setRequired(false);
		typeNameField.setHidden(false);


		percentField = new DataSourceFloatField("percent", "权重比例");
		percentField.setLength(18);
		percentField.setDecimalPad(5);
		percentField.setFormat("#,###,###,###,##0.00000");
		percentField.setRequired(false);
		percentField.setHidden(true);


		percentViewField = new DataSourceTextField("percentView", "权重比例");
		percentViewField.setLength(128);
		percentViewField.setRequired(false);
		percentViewField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级编码");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setForeignKey(dataSourceID+".accountWeightRecordId");
		parentIdField.setRootValue("");
		parentIdField.setHidden(true);


		levelField = new DataSourceIntegerField("level", "级别(即几级节点)");
		levelField.setLength(11);
		levelField.setRequired(false);
		levelField.setHidden(true);


		settlementLevelField = new DataSourceIntegerField("settlementLevel", "计算级别(即计算优先级)");
		settlementLevelField.setLength(11);
		settlementLevelField.setRequired(false);
		settlementLevelField.setHidden(true);


		orderFlagField = new DataSourceIntegerField("orderFlag", "排序标示");
		orderFlagField.setLength(11);
		orderFlagField.setRequired(false);
		orderFlagField.setHidden(true);


		enabledField = new DataSourceBooleanField("enabled", "是否启用");
		enabledField.setRequired(false);
		enabledField.setHidden(true);


		setFields(accountWeightRecordIdField, typeIdField, typeNameField, percentField, percentViewField, parentIdField, levelField, settlementLevelField, orderFlagField, enabledField);
	}


}

