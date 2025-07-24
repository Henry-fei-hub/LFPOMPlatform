package com.pomplatform.client.specialdeduction.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSpecialDeductionRecordsAttentionOfWorkflow extends DBDataSource
{


	public static DSSpecialDeductionRecordsAttentionOfWorkflow instance = null;

	public static DSSpecialDeductionRecordsAttentionOfWorkflow getInstance() {
		if(instance == null) {
			instance = new DSSpecialDeductionRecordsAttentionOfWorkflow("DSSpecialDeductionRecordsAttentionOfWorkflow");
		}
		return instance;
	}

	private final DataSourceIntegerField systemProcessAttentionIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processActivityIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceIntegerField instanceActivityIdField;
	private final DataSourceDateTimeField instanceActivityCreateTimeField;
	private final DataSourceDateTimeField instanceActivityStartTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField processCommentField;
	private final DataSourceIntegerField specialDeductionRecordIdField;
	private final DataSourceIntegerField employeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceDateTimeField createDateField;
	private final DataSourceBooleanField isEnableField;
	private final DataSourceTextField remarkField;

	public DSSpecialDeductionRecordsAttentionOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SpecialDeductionRecordsAttentionOfWorkflow");


		systemProcessAttentionIdField = new DataSourceIntegerField("systemProcessAttentionId", "主键编码");
		systemProcessAttentionIdField.setLength(11);
		systemProcessAttentionIdField.setPrimaryKey(true);
		systemProcessAttentionIdField.setRequired(true);
		systemProcessAttentionIdField.setHidden(true);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(true);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(true);


		processActivityIdField = new DataSourceIntegerField("processActivityId", "活动编码");
		processActivityIdField.setLength(11);
		processActivityIdField.setRequired(false);
		processActivityIdField.setHidden(true);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(true);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(true);


		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);


		instanceActivityIdField = new DataSourceIntegerField("instanceActivityId", "流程实例节点编码");
		instanceActivityIdField.setLength(11);
		instanceActivityIdField.setRequired(false);
		instanceActivityIdField.setHidden(true);


		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程实例节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(true);


		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(false);


		specialDeductionRecordIdField = new DataSourceIntegerField("specialDeductionRecordId", "id");
		specialDeductionRecordIdField.setLength(11);
		specialDeductionRecordIdField.setPrimaryKey(true);
		specialDeductionRecordIdField.setRequired(true);
		specialDeductionRecordIdField.setHidden(true);


		employeIdField = new DataSourceIntegerField("employeId", "纳税申请人");
		employeIdField.setLength(11);
		employeIdField.setRequired(true);
		employeIdField.setHidden(false);
		employeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

		createDateField = new DataSourceDateTimeField("createDate", "创建时间");
		createDateField.setRequired(false);
		createDateField.setHidden(true);


		isEnableField = new DataSourceBooleanField("isEnable", "是否可用");
		isEnableField.setRequired(false);
		isEnableField.setHidden(true);


		employeeNameField = new DataSourceTextField("employeeName", "扣除年度");
		employeeNameField.setLength(512);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);
		
		
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(512);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		setFields(systemProcessAttentionIdField, specialDeductionRecordIdField, businessIdField, businessNameField, processActivityIdField, processIdField, processInstanceIdField, backViewNameField, instanceActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField,employeeNameField, employeIdField, plateIdField, companyIdField,  createDateField, isEnableField, statusField, processTypeField, operateTimeField, processCommentField, remarkField);
	}


}

