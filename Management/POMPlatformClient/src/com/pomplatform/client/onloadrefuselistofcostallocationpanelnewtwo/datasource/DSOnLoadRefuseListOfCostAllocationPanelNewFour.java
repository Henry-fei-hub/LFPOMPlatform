package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadRefuseListOfCostAllocationPanelNewFour extends DBDataSource
{


	public static DSOnLoadRefuseListOfCostAllocationPanelNewFour instance = null;

	public static DSOnLoadRefuseListOfCostAllocationPanelNewFour getInstance() {
		if(instance == null) {
			instance = new DSOnLoadRefuseListOfCostAllocationPanelNewFour("DSOnLoadRefuseListOfCostAllocationPanelNewFour");
		}
		return instance;
	}

	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
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
	private final DataSourceTextField processCommentField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField transferEmployeeIdField;
	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceIntegerField preProjectTransferRecordIdField;
	private final DataSourceDateTimeField operateTimeField;

	public DSOnLoadRefuseListOfCostAllocationPanelNewFour(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadRefuseListOfCostAllocationPanelNewFour");


		customerNameField = new DataSourceTextField("customerName", "开发商名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


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
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "原报备人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		transferEmployeeIdField = new DataSourceIntegerField("transferEmployeeId", "转交人");
		transferEmployeeIdField.setLength(11);
		transferEmployeeIdField.setRequired(false);
		transferEmployeeIdField.setHidden(false);
		transferEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		preProjectIdField = new DataSourceIntegerField("preProjectId", "项目id");
		preProjectIdField.setLength(11);
		preProjectIdField.setRequired(false);
		preProjectIdField.setHidden(true);


		preProjectTransferRecordIdField = new DataSourceIntegerField("preProjectTransferRecordId", "主键编码");
		preProjectTransferRecordIdField.setLength(11);
		preProjectTransferRecordIdField.setPrimaryKey(true);
		preProjectTransferRecordIdField.setRequired(true);
		preProjectTransferRecordIdField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "创建时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		setFields(statusField,systemProcessAttentionIdField, processInstanceIdField, preProjectTransferRecordIdField, customerNameField, projectNameField, provinceField, cityField, businessIdField, businessNameField, processActivityIdField, processIdField, backViewNameField, instanceActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField,  processTypeField, processCommentField, employeeIdField, transferEmployeeIdField, preProjectIdField, operateTimeField);
	}


}

