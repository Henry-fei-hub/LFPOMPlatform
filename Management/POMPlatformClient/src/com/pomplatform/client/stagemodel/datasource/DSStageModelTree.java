package com.pomplatform.client.stagemodel.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSStageModelTree extends DBDataSource
{


	public static DSStageModelTree instance = null;

	public static DSStageModelTree getInstance() {
		if(instance == null) {
			instance = new DSStageModelTree("DSStageModelTree");
		}
		return instance;
	}

	private final DataSourceIntegerField stageModelIdField;
	private final DataSourceTextField nameField;
	private final DataSourceFloatField percentField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceBooleanField leafNodeField;
	private final DataSourceIntegerField orderNoField;
	private final DataSourceBooleanField needManagerAuditField;
	private final DataSourceBooleanField needDesignDirectorAuditField;
	private final DataSourceTextField remarkField;

	public DSStageModelTree(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("StageModel");


		stageModelIdField = new DataSourceIntegerField("stageModelId", "主键编码");
		stageModelIdField.setLength(11);
		stageModelIdField.setPrimaryKey(true);
		stageModelIdField.setRequired(true);
		stageModelIdField.setHidden(true);


		nameField = new DataSourceTextField("stageModelName", "名称");
		nameField.setLength(128);
		nameField.setRequired(false);
		nameField.setHidden(false);


		percentField = new DataSourceFloatField("percent", "阶段百分比");
		percentField.setLength(5);
		percentField.setDecimalPad(4);
		percentField.setFormat("0.0000");
		percentField.setRequired(false);
		percentField.setHidden(false);


		parentIdField = new DataSourceIntegerField("parentId", "父级");
		parentIdField.setLength(11);
		parentIdField.setRequired(false);
		parentIdField.setHidden(true);
//		parentIdField.setValueMap(KeyValueManager.getValueMap("contracts_1"));
		KeyValueManager.loadValueMap("contracts_1", parentIdField);

		leafNodeField = new DataSourceBooleanField("leafNode", "是否为叶子结点");
		leafNodeField.setRequired(false);
		leafNodeField.setHidden(false);


		orderNoField = new DataSourceIntegerField("orderNo", "排序");
		orderNoField.setLength(11);
		orderNoField.setRequired(false);
		orderNoField.setHidden(false);

		
		needManagerAuditField = new DataSourceBooleanField("needManagerAudit", "需要项目经理审批");
		needManagerAuditField.setRequired(false);
		needManagerAuditField.setHidden(false);
		
		
		needDesignDirectorAuditField = new DataSourceBooleanField("needDesignDirectorAudit", "需要设计总监审批");
		needDesignDirectorAuditField.setRequired(false);
		needDesignDirectorAuditField.setHidden(false);
		
		
		remarkField = new DataSourceTextField("remark", "模板内容");
		remarkField.setLength(10240);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		

		setFields(stageModelIdField, nameField, percentField, parentIdField, leafNodeField, orderNoField, needManagerAuditField, needDesignDirectorAuditField, remarkField);
	}


}

