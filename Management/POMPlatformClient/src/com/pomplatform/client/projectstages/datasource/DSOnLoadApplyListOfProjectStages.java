package com.pomplatform.client.projectstages.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApplyListOfProjectStages extends DBDataSource
{


	public static DSOnLoadApplyListOfProjectStages instance = null;

	public static DSOnLoadApplyListOfProjectStages getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApplyListOfProjectStages("DSOnLoadApplyListOfProjectStages");
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
	private final DataSourceIntegerField projectStageProcessRecordIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceFloatField projectAmountSumField;
	private final DataSourceFloatField applyAmountField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceTextField remarkField;

	public DSOnLoadApplyListOfProjectStages(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApplyListOfProjectStages");


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


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
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


		projectStageProcessRecordIdField = new DataSourceIntegerField("projectStageProcessRecordId", "id");
		projectStageProcessRecordIdField.setLength(11);
		projectStageProcessRecordIdField.setPrimaryKey(true);
		projectStageProcessRecordIdField.setRequired(true);
		projectStageProcessRecordIdField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "contract_id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "main_project_id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(true);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(128);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(128);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectAmountSumField = new DataSourceFloatField("projectAmountSum", "订单积分");
		projectAmountSumField.setLength(12);
		projectAmountSumField.setDecimalPad(2);
		projectAmountSumField.setFormat("#,###,###,##0.00");
		projectAmountSumField.setRequired(false);
		projectAmountSumField.setHidden(true);


		applyAmountField = new DataSourceFloatField("applyAmount", "本次申请的积分");
		applyAmountField.setLength(12);
		applyAmountField.setDecimalPad(2);
		applyAmountField.setFormat("#,###,###,##0.00");
		applyAmountField.setRequired(false);
		applyAmountField.setHidden(true);


		fileIdField = new DataSourceIntegerField("fileId", "file_id");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "附件");
		fileUrlField.setLength(128);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(256);
		remarkField.setRequired(false);
		remarkField.setHidden(true);


		setFields(processInstanceIdField, projectStageProcessRecordIdField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, processTypeField, contractIdField, mainProjectIdField, projectNameField, projectCodeField, projectAmountSumField, applyAmountField, fileIdField, fileUrlField, remarkField, createTimeField, completeTimeField);
	}


}

