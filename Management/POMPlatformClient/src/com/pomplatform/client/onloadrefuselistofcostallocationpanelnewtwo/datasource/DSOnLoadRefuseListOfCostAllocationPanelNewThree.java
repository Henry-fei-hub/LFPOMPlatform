package com.pomplatform.client.onloadrefuselistofcostallocationpanelnewtwo.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadRefuseListOfCostAllocationPanelNewThree extends DBDataSource
{


	public static DSOnLoadRefuseListOfCostAllocationPanelNewThree instance = null;

	public static DSOnLoadRefuseListOfCostAllocationPanelNewThree getInstance() {
		if(instance == null) {
			instance = new DSOnLoadRefuseListOfCostAllocationPanelNewThree("DSOnLoadRefuseListOfCostAllocationPanelNewThree");
		}
		return instance;
	}

	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processActivityIdField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField nodeTypeField;
	private final DataSourceIntegerField activityIdField;
	private final DataSourceIntegerField nextActivityIdField;
	private final DataSourceIntegerField mainActivityIdField;
	private final DataSourceDateTimeField instanceActivityCreateTimeField;
	private final DataSourceDateTimeField instanceActivityStartTimeField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField processCommentField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField transferEmployeeIdField;
	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceIntegerField preProjectTransferRecordIdField;

	public DSOnLoadRefuseListOfCostAllocationPanelNewThree(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadRefuseListOfCostAllocationPanelNewThree");


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


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);


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


		nodeTypeField = new DataSourceIntegerField("nodeType", "附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人");
		nodeTypeField.setLength(11);
		nodeTypeField.setRequired(false);
		nodeTypeField.setHidden(true);


		activityIdField = new DataSourceIntegerField("activityId", "当前流程实例节点的内部编码");
		activityIdField.setLength(11);
		activityIdField.setRequired(false);
		activityIdField.setHidden(true);


		nextActivityIdField = new DataSourceIntegerField("nextActivityId", "下一个流程节点的编码");
		nextActivityIdField.setLength(11);
		nextActivityIdField.setRequired(false);
		nextActivityIdField.setHidden(true);


		mainActivityIdField = new DataSourceIntegerField("mainActivityId", "如果是知会节点，所依附的主节点");
		mainActivityIdField.setLength(11);
		mainActivityIdField.setRequired(false);
		mainActivityIdField.setHidden(true);


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
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_38"));


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "创建时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(true);


		activityTypeField = new DataSourceIntegerField("activityType", "节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会");
		activityTypeField.setLength(11);
		activityTypeField.setRequired(false);
		activityTypeField.setHidden(true);


		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);


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
		preProjectTransferRecordIdField.setHidden(true);


		setFields(statusField,processInstanceIdField, preProjectTransferRecordIdField, customerNameField, projectNameField, provinceField, cityField, processInstanceActivityIdField, businessIdField, businessNameField, processActivityIdField, processIdField, nodeTypeField, activityIdField, nextActivityIdField, mainActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField,  processTypeField,  processCommentField, activityTypeField, backViewNameField, employeeIdField, transferEmployeeIdField, operateTimeField,preProjectIdField);
	}


}

