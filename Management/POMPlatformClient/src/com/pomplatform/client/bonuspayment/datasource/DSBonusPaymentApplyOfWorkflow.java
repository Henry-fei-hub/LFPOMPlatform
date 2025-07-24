package com.pomplatform.client.bonuspayment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBonusPaymentApplyOfWorkflow extends DBDataSource
{


	public static DSBonusPaymentApplyOfWorkflow instance = null;

	public static DSBonusPaymentApplyOfWorkflow getInstance() {
		if(instance == null) {
			instance = new DSBonusPaymentApplyOfWorkflow("DSBonusPaymentApplyOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField bonusPaymentRecordIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceFloatField payIntegralField;
	private final DataSourceDateField payDateField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField applicantField;
	private final DataSourceDateTimeField applyTimeField;
	private final DataSourceIntegerField stateField;
	private final DataSourceIntegerField auditorField;
	private final DataSourceDateTimeField auditingTimeField;
	private final DataSourceTextField opinionField;
	private final DataSourceBooleanField isLevelTwoField;

	public DSBonusPaymentApplyOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BonusPaymentApplyOfWorkflow");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);

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


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态 ");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);
		processStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_120"));


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(true);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(true);

		bonusPaymentRecordIdField = new DataSourceIntegerField("bonusPaymentRecordId", "主键编码");
		bonusPaymentRecordIdField.setLength(11);
		bonusPaymentRecordIdField.setPrimaryKey(true);
		bonusPaymentRecordIdField.setRequired(true);
		bonusPaymentRecordIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));

		payIntegralField = new DataSourceFloatField("payIntegral", "发放积分");
		payIntegralField.setLength(12);
		payIntegralField.setDecimalPad(2);
		payIntegralField.setFormat("#,###,###,##0.00");
		payIntegralField.setRequired(false);
		payIntegralField.setHidden(false);

		payDateField = new DataSourceDateField("payDate", "发放年月");
		payDateField.setRequired(false);
		payDateField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);

		applicantField = new DataSourceIntegerField("applicant", "申请人");
		applicantField.setLength(11);
		applicantField.setRequired(false);
		applicantField.setHidden(false);
		applicantField.setValueMap(KeyValueManager.getValueMap("employees"));

		applyTimeField = new DataSourceDateTimeField("applyTime", "申请时间");
		applyTimeField.setRequired(false);
		applyTimeField.setHidden(false);


		stateField = new DataSourceIntegerField("state", "审核状态  0未审核   1审核通过    2审核不通过");
		stateField.setLength(11);
		stateField.setRequired(false);
		stateField.setHidden(true);


		auditorField = new DataSourceIntegerField("auditor", "审核人");
		auditorField.setLength(11);
		auditorField.setRequired(false);
		auditorField.setHidden(true);


		auditingTimeField = new DataSourceDateTimeField("auditingTime", "审核时间");
		auditingTimeField.setRequired(false);
		auditingTimeField.setHidden(true);


		opinionField = new DataSourceTextField("opinion", "审核意见");
		opinionField.setLength(512);
		opinionField.setRequired(false);
		opinionField.setHidden(true);


		isLevelTwoField = new DataSourceBooleanField("isLevelTwo", "是否二级部门提交的");
		isLevelTwoField.setRequired(false);
		isLevelTwoField.setHidden(true);



		setFields(processInstanceIdField, bonusPaymentRecordIdField, processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, createTimeField, completeTimeField, plateIdField, payIntegralField, payDateField, remarkField, applicantField, applyTimeField, stateField, auditorField, auditingTimeField, opinionField, isLevelTwoField);
	}


}

