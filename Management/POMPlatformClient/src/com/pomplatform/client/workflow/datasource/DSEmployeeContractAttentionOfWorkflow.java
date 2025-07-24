package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSEmployeeContractAttentionOfWorkflow extends DBDataSource
{


	public static DSEmployeeContractAttentionOfWorkflow instance = null;

	public static DSEmployeeContractAttentionOfWorkflow getInstance() {
		if(instance == null) {
			instance = new DSEmployeeContractAttentionOfWorkflow("DSEmployeeContractAttentionOfWorkflow");
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
	private final DataSourceIntegerField employeeContractAttachmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField attachmentNameField;
	private final DataSourceTextField attachmentUrlField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceIntegerField contractTypeField;
	private final DataSourceIntegerField signTypeField;
	private final DataSourceDateField startDateField;
	private final DataSourceDateField endDateField;
	private final DataSourceIntegerField willEndField;
	private final DataSourceIntegerField attachmentIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceDateTimeField onboardDateField;
	private final DataSourceIntegerField employeeStatusField;

	public DSEmployeeContractAttentionOfWorkflow(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("EmployeeContractAttentionOfWorkflow");


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


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
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


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(true);


		employeeContractAttachmentIdField = new DataSourceIntegerField("employeeContractAttachmentId", "主键编码");
		employeeContractAttachmentIdField.setLength(11);
		employeeContractAttachmentIdField.setPrimaryKey(true);
		employeeContractAttachmentIdField.setRequired(true);
		employeeContractAttachmentIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		attachmentNameField = new DataSourceTextField("attachmentName", "合同名称");
		attachmentNameField.setLength(32);
		attachmentNameField.setRequired(false);
		attachmentNameField.setHidden(true);


		attachmentUrlField = new DataSourceTextField("attachmentUrl", "附件路径");
		attachmentUrlField.setLength(128);
		attachmentUrlField.setRequired(false);
		attachmentUrlField.setHidden(false);
		attachmentUrlField.setType(FieldType.LINK);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		contractTypeField = new DataSourceIntegerField("contractType", "合同类型");
		contractTypeField.setLength(22);
		contractTypeField.setRequired(false);
		contractTypeField.setHidden(false);
		contractTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_111"));


		signTypeField = new DataSourceIntegerField("signType", "签订类型");
		signTypeField.setLength(22);
		signTypeField.setRequired(false);
		signTypeField.setHidden(false);
		signTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_112"));


		startDateField = new DataSourceDateField("startDate", "开始日期");
		startDateField.setRequired(false);
		signTypeField.setLength(22);
		startDateField.setHidden(false);


		endDateField = new DataSourceDateField("endDate", "结束日期");
		endDateField.setRequired(false);
		endDateField.setHidden(false);


		willEndField = new DataSourceIntegerField("willEnd", "一个月到期(0未到期；1即将到期；2已过期)");
		willEndField.setLength(11);
		willEndField.setRequired(false);
		willEndField.setHidden(true);


		attachmentIdField = new DataSourceIntegerField("attachmentId", "附件编码");
		attachmentIdField.setLength(11);
		attachmentIdField.setRequired(false);
		attachmentIdField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		onboardDateField = new DataSourceDateTimeField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		employeeStatusField = new DataSourceIntegerField("employeeStatus", "职员状态");
		employeeStatusField.setLength(11);
		employeeStatusField.setRequired(false);
		employeeStatusField.setHidden(false);


		setFields(systemProcessAttentionIdField, processInstanceIdField, employeeContractAttachmentIdField, businessIdField, businessNameField, processActivityIdField, processIdField, backViewNameField, instanceActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, statusField, processTypeField, operateTimeField, processCommentField, employeeIdField, attachmentNameField, attachmentUrlField, operateEmployeeIdField, contractTypeField, signTypeField, startDateField, endDateField, willEndField, attachmentIdField, employeeNoField, departmentIdField, plateIdField, onboardDateField, employeeStatusField);
	}


}

