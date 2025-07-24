package com.pomplatform.client.personnel.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadFlowEmployeeMoneyApplyBuisnessData extends DBDataSource
{


	public static DSOnLoadFlowEmployeeMoneyApplyBuisnessData instance = null;

	public static DSOnLoadFlowEmployeeMoneyApplyBuisnessData getInstance() {
		if(instance == null) {
			instance = new DSOnLoadFlowEmployeeMoneyApplyBuisnessData("DSOnLoadFlowEmployeeMoneyApplyBuisnessData");
		}
		return instance;
	}

	private final DataSourceTextField processTypeNameField;
	private final DataSourceIntegerField processPooledTaskIdField;
	private final DataSourceIntegerField typeFlagField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processTypeField;
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
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField borrowMoneyField;
	private final DataSourceTextField codeField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField activityTypeField;
	private final DataSourceTextField titleField;
	private final DataSourceTextField reasonField;
	
	public DSOnLoadFlowEmployeeMoneyApplyBuisnessData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadFlowEmployeeMoneyApplyBuisnessData");


		processTypeNameField = new DataSourceTextField("processTypeName", "流程类型名称");
		processTypeNameField.setLength(64);
		processTypeNameField.setRequired(false);
		processTypeNameField.setHidden(false);


		processPooledTaskIdField = new DataSourceIntegerField("processPooledTaskId", "主键编码");
		processPooledTaskIdField.setLength(11);
		processPooledTaskIdField.setPrimaryKey(true);
		processPooledTaskIdField.setRequired(true);
		processPooledTaskIdField.setHidden(true);


		typeFlagField = new DataSourceIntegerField("typeFlag", "typeFlag");
		typeFlagField.setLength(11);
		typeFlagField.setRequired(true);
		typeFlagField.setHidden(true);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);
		processTypeField.setValueMap(KeyValueManager.getValueMap("system_process_types"));


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


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(true);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_39"));


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		employeeIdField = new DataSourceIntegerField("employeeId", "发起人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		borrowMoneyField = new DataSourceFloatField("borrowMoney", "金额");
		borrowMoneyField.setLength(18);
		borrowMoneyField.setDecimalPad(2);
		borrowMoneyField.setFormat("#,###,###,###,##0.00");
		borrowMoneyField.setRequired(false);
		borrowMoneyField.setHidden(false);


		codeField = new DataSourceTextField("code", "编号");
		codeField.setLength(64);
		codeField.setRequired(false);
		codeField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_26"));
		
		activityTypeField = new DataSourceIntegerField("activityType", "节点类型 0 - 开始 1 - 结束 2 - 审批 3 - 处理 4 - 知会");
		activityTypeField.setLength(11);
		activityTypeField.setRequired(false);
		activityTypeField.setHidden(true);
		
		titleField = new DataSourceTextField("title", "主题");
		titleField.setLength(512);
		titleField.setRequired(false);
		titleField.setHidden(false);
		
		reasonField = new DataSourceTextField("reason", "申请缘由");
		reasonField.setLength(512);
		reasonField.setRequired(false);
		reasonField.setHidden(false);

		setFields(processInstanceIdField, processInstanceActivityIdField, processTypeField, businessIdField, businessNameField, processActivityIdField, processIdField, nodeTypeField, activityIdField, nextActivityIdField, mainActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, statusField, codeField, employeeIdField, departmentIdField, borrowMoneyField, companyIdField, reasonField, titleField, operateTimeField, processCommentField,activityTypeField);
	}


}

