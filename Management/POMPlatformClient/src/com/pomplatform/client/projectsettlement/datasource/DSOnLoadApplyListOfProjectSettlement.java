package com.pomplatform.client.projectsettlement.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfProjectSettlement extends DBDataSource
{


	public static DSOnLoadApplyListOfProjectSettlement instance = null;

	public static DSOnLoadApplyListOfProjectSettlement getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfProjectSettlement("DSOnLoadApplyListOfProjectSettlement");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField settlementIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateField settlementDateField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField totalCostField;
	private final DataSourceFloatField projectAmountField;
	private final DataSourceFloatField leftAmountField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField stageIdField;
	private final DataSourceIntegerField settlementStatusField;
	private final DataSourceIntegerField flagField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;

	public DSOnLoadApplyListOfProjectSettlement(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfProjectSettlement");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "主键编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setPrimaryKey(true);
		processInstanceActivityIdField.setRequired(true);
		processInstanceActivityIdField.setHidden(true);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 0 发起中  1");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		settlementIdField = new DataSourceIntegerField("settlementId", "结算代码");
		settlementIdField.setLength(11);
		settlementIdField.setPrimaryKey(true);
		settlementIdField.setRequired(true);
		settlementIdField.setHidden(true);


		projectIdField = new DataSourceIntegerField("projectId", "项目代码");
		projectIdField.setLength(11);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		remarkField = new DataSourceTextField("remark", "结算原因");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		settlementDateField = new DataSourceDateField("settlementDate", "结算日期");
		settlementDateField.setRequired(false);
		settlementDateField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "确认积分");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		totalCostField = new DataSourceFloatField("totalCost", "项目成本");
		totalCostField.setLength(18);
		totalCostField.setDecimalPad(2);
		totalCostField.setFormat("#,###,###,###,###,##0.00");
		totalCostField.setRequired(false);
		totalCostField.setHidden(false);


		projectAmountField = new DataSourceFloatField("projectAmount", "项目积分");
		projectAmountField.setLength(18);
		projectAmountField.setDecimalPad(2);
		projectAmountField.setFormat("#,###,###,###,###,##0.00");
		projectAmountField.setRequired(false);
		projectAmountField.setHidden(false);


		leftAmountField = new DataSourceFloatField("leftAmount", "项目结余积分");
		leftAmountField.setLength(18);
		leftAmountField.setDecimalPad(2);
		leftAmountField.setFormat("#,###,###,###,###,##0.00");
		leftAmountField.setRequired(false);
		leftAmountField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "结算状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		stageIdField = new DataSourceIntegerField("stageId", "项目阶段");
		stageIdField.setLength(11);
		stageIdField.setRequired(false);
		stageIdField.setHidden(true);


		settlementStatusField = new DataSourceIntegerField("settlementStatus", "3已驳回");
		settlementStatusField.setLength(11);
		settlementStatusField.setRequired(false);
		settlementStatusField.setHidden(true);


		flagField = new DataSourceIntegerField("flag", "1历史数据结算；2新方式数据结算");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		setFields(processInstanceIdField, processInstanceActivityIdField, settlementIdField, businessIdField, businessNameField, processIdField, processStatusField, processTypeField, projectIdField, projectCodeField, projectNameField, projectManageIdField, totalAmountField, totalCostField, projectAmountField, leftAmountField, remarkField, settlementDateField, statusField, stageIdField, settlementStatusField, flagField, createTimeField, completeTimeField);
	}


}

