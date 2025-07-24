package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAttentionListOfPreProjectReport extends DBDataSource
{


	public static DSAttentionListOfPreProjectReport instance = null;

	public static DSAttentionListOfPreProjectReport getInstance() {
		if(instance == null) {
			instance = new DSAttentionListOfPreProjectReport("DSAttentionListOfPreProjectReport");
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
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField projectTypeField;
	private final DataSourceIntegerField customerNameField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceIntegerField applyEmployeeIdField;

	public DSAttentionListOfPreProjectReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttentionListOfPreProjectReport");


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
		processInstanceIdField.setValueMap(new java.util.HashMap());


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
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_38"));


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


		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(false);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(false);


		projectTypeField = new DataSourceTextField("projectType", "项目业态");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);
//		projectTypeField.setValueMap(KeyValueManager.getValueMap("pre_business_type"));
		KeyValueManager.loadValueMap("pre_business_type",projectTypeField);

		customerNameField = new DataSourceIntegerField("customerName", "客户名称");
		customerNameField.setLength(50);
		customerNameField.setRequired(false);
		customerNameField.setHidden(false);
		customerNameField.setValueMap(KeyValueManager.getValueMap("customers_name"));


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);
		projectOriginationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		setFields(systemProcessAttentionIdField, processInstanceIdField, businessIdField, businessNameField, processActivityIdField, processIdField, backViewNameField, instanceActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, applyEmployeeIdField, projectNameField, provinceField, cityField, projectTypeField, customerNameField, projectOriginationField, statusField, processTypeField, processCommentField, operateTimeField);
	}


}

