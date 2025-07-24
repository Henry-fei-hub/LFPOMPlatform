package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadApproveContractRunDry extends DBDataSource
{


	public static DSOnLoadApproveContractRunDry instance = null;

	public static DSOnLoadApproveContractRunDry getInstance() {
		if(instance == null) {
			instance = new DSOnLoadApproveContractRunDry("DSOnLoadApproveContractRunDry");
		}
		return instance;
	}

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
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField processCommentField;
	private final DataSourceIntegerField statusField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceTextField backViewNameField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField orderInfoIdField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceLinkField fileUrlField;
	private final DataSourceTextField flieNameField;

	public DSOnLoadApproveContractRunDry(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadApproveContractRunDry");


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "主键编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setPrimaryKey(true);
		processInstanceActivityIdField.setRequired(true);
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


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
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


		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(false);


		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(true);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(32);
		processCommentField.setRequired(false);
		processCommentField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(11);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);


		activityTypeField = new DataSourceIntegerField("activityType", "节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会");
		activityTypeField.setLength(11);
		activityTypeField.setRequired(false);
		activityTypeField.setHidden(true);


		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(true);


		contractIdField = new DataSourceIntegerField("contractId", "主订单编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		contractCodeField = new DataSourceTextField("contractCode", "主订单编号");
		contractCodeField.setLength(32);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "主订单名称");
		contractNameField.setLength(32);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		orderInfoIdField = new DataSourceIntegerField("orderInfoId", "订单信息编码");
		orderInfoIdField.setLength(11);
		orderInfoIdField.setPrimaryKey(true);
		orderInfoIdField.setRequired(true);
		orderInfoIdField.setHidden(true);

		fileIdField = new DataSourceIntegerField("fileId", "附件id");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(true);


		fileUrlField = new DataSourceLinkField("fileUrl", "启动函");
		fileUrlField.setLength(128);
		fileUrlField.setRequired(false);
		fileUrlField.setHidden(false);


		flieNameField = new DataSourceTextField("fileName", "附件名");
		flieNameField.setLength(512);
		flieNameField.setRequired(false);
		flieNameField.setHidden(true);


		setFields(contractIdField, contractCodeField, contractNameField,infoCodeField,processInstanceActivityIdField, orderInfoIdField, businessIdField, businessNameField, processActivityIdField, processIdField, processInstanceIdField, nodeTypeField, activityIdField, nextActivityIdField, mainActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, operateTimeField, processCommentField, statusField, activityTypeField, backViewNameField,projectCodeField,fileIdField,fileUrlField,flieNameField);
	}


}

