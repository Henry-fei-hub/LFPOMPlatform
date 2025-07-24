package com.pomplatform.client.projectstages.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectStagesProcessApplication extends DBDataSource
{


	public static DSProjectStagesProcessApplication instance = null;

	public static DSProjectStagesProcessApplication getInstance() {
		if(instance == null) {
			instance = new DSProjectStagesProcessApplication("DSProjectStagesProcessApplication");
		}
		return instance;
	}

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
	private final DataSourceField detailProjectStageProcessDetail;
	
	private final DataSourceLinkField attachmentField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceDateTimeField createTimeField;

	private final DataSourceFloatField remainingAmountField;
	private final DataSourceTextField applyRateField;
	private final DataSourceTextField currentApplyRateField;
	private final DataSourceTextField remainingRateField;

	public DSProjectStagesProcessApplication(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ProjectStagesProcessApplication");


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



		employeeIdField = new DataSourceTextField("employeeId", "申请人");
		employeeIdField.setLength(128);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		KeyValueManager.loadValueMap("employees", employeeIdField);

		employeeNoField = new DataSourceTextField("employeeNo", "申请人工号");
		employeeNoField.setLength(128);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		KeyValueManager.loadValueMap("employees", employeeNoField);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(128);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(128);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		projectAmountSumField = new DataSourceFloatField("projectAmountSum", "项目产值");
		projectAmountSumField.setLength(12);
		projectAmountSumField.setDecimalPad(2);
		projectAmountSumField.setFormat("#,###,###,##0.00");
		projectAmountSumField.setRequired(false);
		projectAmountSumField.setHidden(false);

		remainingAmountField = new DataSourceFloatField("remainingAmount", "剩余积分");
		remainingAmountField.setLength(12);
		remainingAmountField.setDecimalPad(2);
		remainingAmountField.setFormat("#,###,###,##0.00");
		remainingAmountField.setRequired(false);
		remainingAmountField.setHidden(false);


		applyAmountField = new DataSourceFloatField("applyAmount", "本次申请的积分");
		applyAmountField.setLength(12);
		applyAmountField.setDecimalPad(2);
		applyAmountField.setFormat("#,###,###,##0.00");
		applyAmountField.setRequired(false);
		applyAmountField.setHidden(false);

		applyRateField = new DataSourceTextField("applyRate", "已申请比例");
		applyRateField.setLength(12);
		applyRateField.setDecimalPad(2);
		applyRateField.setFormat("#,###,###,##0.00");
		applyRateField.setRequired(false);
		applyRateField.setHidden(false);

		currentApplyRateField = new DataSourceTextField("currentApplyRate", "本次申请比例");
		currentApplyRateField.setLength(12);
		currentApplyRateField.setRequired(false);
		currentApplyRateField.setHidden(false);

		remainingRateField = new DataSourceTextField("remainingRate", "剩余比例");
		remainingRateField.setLength(12);
		remainingRateField.setRequired(false);
		remainingRateField.setHidden(false);


		fileIdField = new DataSourceIntegerField("fileId", "file_id");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "附件");
		fileUrlField.setLength(128);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);

		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setLength(64);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(256);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		detailProjectStageProcessDetail = new DataSourceField("detailProjectStageProcessDetail", FieldType.ANY);
		detailProjectStageProcessDetail.setChildrenProperty(true);
		detailProjectStageProcessDetail.setChildTagName("ProjectStageProcessDetail");
		detailProjectStageProcessDetail.setRequired(false);
		detailProjectStageProcessDetail.setHidden(true);
		

		attachmentField = new DataSourceLinkField("fileUrl", "附件");
		attachmentField.setLength(512);
		attachmentField.setRequired(false);
		attachmentField.setHidden(true);

		attachmentIdField = new DataSourceIntegerField("fileId", "附件ID");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);
		
		attachmentNameField = new DataSourceTextField("attachmentName", "附件名称");
		attachmentNameField.setLength(512);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);
		

		setFields(projectStageProcessRecordIdField, contractIdField, mainProjectIdField, employeeIdField,employeeNoField,projectNameField, projectCodeField, projectAmountSumField, applyAmountField,remainingAmountField,applyRateField,currentApplyRateField,remainingRateField, fileIdField, fileUrlField,createTimeField, remarkField, detailProjectStageProcessDetail,attachmentField,attachmentIdField,attachmentNameField);
	}


}

