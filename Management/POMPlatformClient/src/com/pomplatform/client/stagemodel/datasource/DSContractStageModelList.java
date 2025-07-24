package com.pomplatform.client.stagemodel.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractStageModelList extends DBDataSource
{


	public static DSContractStageModelList instance = null;

	public static DSContractStageModelList getInstance() {
		if(instance == null) {
			instance = new DSContractStageModelList("DSContractStageModelList");
		}
		return instance;
	}

	private final DataSourceIntegerField contractStageModelIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField stageModelIdField;
	private final DataSourceTextField stageModelNameField;
	private final DataSourceFloatField percentField;
	private final DataSourceIntegerField parentIdField;
	private final DataSourceBooleanField leafNodeField;
	private final DataSourceIntegerField orderNoField;
	private final DataSourceBooleanField needManagerAuditField;
	private final DataSourceBooleanField needDesignDirectorAuditField;
	private final DataSourceFloatField actualPercentField;
	private final DataSourceTextField remarkField;
	private final DataSourceTextField managerCommentField;
	private final DataSourceIntegerField managerIdField;
	private final DataSourceDateField managerAuditDateField;
	private final DataSourceTextField designDirectorCommentField;
	private final DataSourceIntegerField designDirectorIdField;
	private final DataSourceDateField designDirectorAuditDateField;
	private final DataSourceBooleanField lockedField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateField confirmDateField;
	private final DataSourceIntegerField yearField;

	public DSContractStageModelList(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ContractStageModel");


		contractStageModelIdField = new DataSourceIntegerField("contractStageModelId", "主键编码");
		contractStageModelIdField.setLength(11);
		contractStageModelIdField.setPrimaryKey(true);
		contractStageModelIdField.setRequired(true);
		contractStageModelIdField.setHidden(false);


		contractIdField = new DataSourceIntegerField("contractId", "合同");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
//		contractIdField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractIdField);


		stageModelIdField = new DataSourceIntegerField("stageModelId", "阶段小节点模板");
		stageModelIdField.setLength(11);
		stageModelIdField.setRequired(false);
		stageModelIdField.setHidden(true);


		stageModelNameField = new DataSourceTextField("stageModelName", "名称");
		stageModelNameField.setLength(256);
		stageModelNameField.setRequired(false);
		stageModelNameField.setHidden(false);


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


		orderNoField = new DataSourceIntegerField("orderNo", "排序序号");
		orderNoField.setLength(11);
		orderNoField.setRequired(false);
		orderNoField.setHidden(false);


		needManagerAuditField = new DataSourceBooleanField("needManagerAudit", "需要项目经理审批");
		needManagerAuditField.setRequired(false);
		needManagerAuditField.setHidden(false);


		needDesignDirectorAuditField = new DataSourceBooleanField("needDesignDirectorAudit", "需要设计总监审批");
		needDesignDirectorAuditField.setRequired(false);
		needDesignDirectorAuditField.setHidden(false);


		actualPercentField = new DataSourceFloatField("actualPercent", "累积百分比");
		actualPercentField.setLength(5);
		actualPercentField.setDecimalPad(4);
		actualPercentField.setFormat("0.0000");
		actualPercentField.setRequired(false);
		actualPercentField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(10240);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		managerCommentField = new DataSourceTextField("managerComment", "项目经理意见");
		managerCommentField.setLength(10240);
		managerCommentField.setRequired(false);
		managerCommentField.setHidden(true);


		managerIdField = new DataSourceIntegerField("managerId", "项目经理");
		managerIdField.setLength(11);
		managerIdField.setRequired(false);
		managerIdField.setHidden(false);
		managerIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		managerAuditDateField = new DataSourceDateField("managerAuditDate", "项目经理审批日期");
		managerAuditDateField.setRequired(false);
		managerAuditDateField.setHidden(true);


		designDirectorCommentField = new DataSourceTextField("designDirectorComment", "设计总监意见");
		designDirectorCommentField.setLength(10240);
		designDirectorCommentField.setRequired(false);
		designDirectorCommentField.setHidden(true);


		designDirectorIdField = new DataSourceIntegerField("designDirectorId", "设计总监");
		designDirectorIdField.setLength(11);
		designDirectorIdField.setRequired(false);
		designDirectorIdField.setHidden(false);
		designDirectorIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		designDirectorAuditDateField = new DataSourceDateField("designDirectorAuditDate", "设计总监审批日期");
		designDirectorAuditDateField.setRequired(false);
		designDirectorAuditDateField.setHidden(true);


		lockedField = new DataSourceBooleanField("locked", "是否锁定");
		lockedField.setRequired(false);
		lockedField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态，默认新建，0新建，1运行中，3结束");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		confirmDateField = new DataSourceDateField("confirmDate", "确认日期");
		confirmDateField.setRequired(false);
		confirmDateField.setHidden(false);

		
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);

		
		setFields(contractStageModelIdField, contractIdField, stageModelIdField, stageModelNameField, percentField, parentIdField, leafNodeField, orderNoField, needManagerAuditField, needDesignDirectorAuditField, actualPercentField, remarkField, managerCommentField, managerIdField, managerAuditDateField, designDirectorCommentField, designDirectorIdField, designDirectorAuditDateField, lockedField, processStatusField, confirmDateField, yearField);
	}


}

