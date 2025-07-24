package com.pomplatform.client.workflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadMsgEmployeeBusinessData extends DBDataSource
{


	public static DSOnLoadMsgEmployeeBusinessData instance = null;

	public static DSOnLoadMsgEmployeeBusinessData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadMsgEmployeeBusinessData("DSOnLoadMsgEmployeeBusinessData");
		}
		return instance;
	}

	private final DataSourceTextField processTypeNameField;
	private final DataSourceIntegerField processPooledTaskIdField;
	private final DataSourceIntegerField typeFlagField;
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
	private final DataSourceIntegerField employee1Field;
	private final DataSourceIntegerField employee2Field;
	private final DataSourceIntegerField employeeStatusField;
	private final DataSourceTextField companyWeixinField;
	private final DataSourceTextField activityNameField;
	private final DataSourceIntegerField timeOutActionField;
	private final DataSourceIntegerField message1Field;
	private final DataSourceIntegerField message2Field;

	public DSOnLoadMsgEmployeeBusinessData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadMsgEmployeeBusinessData");


		processTypeNameField = new DataSourceTextField("processTypeName", "流程类型名称");
		processTypeNameField.setLength(64);
		processTypeNameField.setRequired(false);
		processTypeNameField.setHidden(false);


		processPooledTaskIdField = new DataSourceIntegerField("processPooledTaskId", "主键编码");
		processPooledTaskIdField.setLength(11);
		processPooledTaskIdField.setPrimaryKey(true);
		processPooledTaskIdField.setRequired(true);
		processPooledTaskIdField.setHidden(false);


		typeFlagField = new DataSourceIntegerField("typeFlag", "");
		typeFlagField.setLength(11);
		typeFlagField.setRequired(true);
		typeFlagField.setHidden(false);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "主键编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setPrimaryKey(true);
		processInstanceActivityIdField.setRequired(true);
		processInstanceActivityIdField.setHidden(false);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(false);


		processActivityIdField = new DataSourceIntegerField("processActivityId", "活动编码");
		processActivityIdField.setLength(11);
		processActivityIdField.setRequired(false);
		processActivityIdField.setHidden(false);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(false);


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "流程实列编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setRequired(false);
		processInstanceIdField.setHidden(false);


		nodeTypeField = new DataSourceIntegerField("nodeType", "附加节点，说明节点是预定义的节点还是动态加的节点， 0 - 正常定义的节点， 1 - 申请人或者审批人加的处理人或者审批人");
		nodeTypeField.setLength(11);
		nodeTypeField.setRequired(false);
		nodeTypeField.setHidden(false);


		activityIdField = new DataSourceIntegerField("activityId", "当前流程实例节点的内部编码");
		activityIdField.setLength(11);
		activityIdField.setRequired(false);
		activityIdField.setHidden(false);


		nextActivityIdField = new DataSourceIntegerField("nextActivityId", "下一个流程节点的编码");
		nextActivityIdField.setLength(11);
		nextActivityIdField.setRequired(false);
		nextActivityIdField.setHidden(false);


		mainActivityIdField = new DataSourceIntegerField("mainActivityId", "如果是知会节点，所依附的主节点");
		mainActivityIdField.setLength(11);
		mainActivityIdField.setRequired(false);
		mainActivityIdField.setHidden(false);


		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程实例节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(false);


		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(false);


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(true);


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


		employee1Field = new DataSourceIntegerField("employee1", "");
		employee1Field.setLength(11);
		employee1Field.setRequired(true);
		employee1Field.setHidden(true);


		employee2Field = new DataSourceIntegerField("employee2", "");
		employee2Field.setLength(11);
		employee2Field.setRequired(true);
		employee2Field.setHidden(true);


		employeeStatusField = new DataSourceIntegerField("employeeStatus", "");
		employeeStatusField.setLength(11);
		employeeStatusField.setRequired(true);
		employeeStatusField.setHidden(true);


		companyWeixinField = new DataSourceTextField("companyWeixin", "企业微信账号");
		companyWeixinField.setLength(255);
		companyWeixinField.setRequired(false);
		companyWeixinField.setHidden(true);


		activityNameField = new DataSourceTextField("activityName", "活动节点名称");
		activityNameField.setLength(64);
		activityNameField.setRequired(false);
		activityNameField.setHidden(true);


		timeOutActionField = new DataSourceIntegerField("timeOutAction", "活动时限");
		timeOutActionField.setLength(11);
		timeOutActionField.setRequired(false);
		timeOutActionField.setHidden(true);


		message1Field = new DataSourceIntegerField("message1", "message1");
		message1Field.setLength(11);
		message1Field.setRequired(true);
		message1Field.setHidden(true);


		message2Field = new DataSourceIntegerField("message2", "message2");
		message2Field.setLength(11);
		message2Field.setRequired(true);
		message2Field.setHidden(true);


		setFields(processPooledTaskIdField, processInstanceActivityIdField, processTypeNameField, typeFlagField, businessIdField, businessNameField, processActivityIdField, processIdField, processInstanceIdField, nodeTypeField, activityIdField, nextActivityIdField, mainActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, operateTimeField, processCommentField, statusField, activityTypeField, backViewNameField, employee1Field, employee2Field, employeeStatusField, companyWeixinField, activityNameField, timeOutActionField, message1Field, message2Field);
	}


}

