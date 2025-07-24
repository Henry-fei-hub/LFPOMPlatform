package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAttentionListOfMainProjectReport extends DBDataSource
{


	public static DSAttentionListOfMainProjectReport instance = null;

	public static DSAttentionListOfMainProjectReport getInstance() {
		if(instance == null) {
			instance = new DSAttentionListOfMainProjectReport("DSAttentionListOfMainProjectReport");
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
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceTextField totalBuildingAreasField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceIntegerField customerTypeField;
	private final DataSourceBooleanField isWarehousField;
	private final DataSourceBooleanField isApplyQuoteField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectNameOneField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceBooleanField isModifyProjectField;
	private final DataSourceIntegerField mainProjectStageIdField;
	private final DataSourceTextField projectCodeField;

	public DSAttentionListOfMainProjectReport(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttentionListOfMainProjectReport");


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
		provinceField.setHidden(true);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(true);


		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		customerNameField = new DataSourceIntegerField("customerName", "客户名称");
		customerNameField.setLength(50);
		customerNameField.setRequired(false);
		customerNameField.setHidden(true);
		customerNameField.setValueMap(KeyValueManager.getValueMap("customers_name"));


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(false);
		projectOriginationField.setValueMap(KeyValueManager.getValueMap("system_dictionary_156"));


		contactNameField = new DataSourceTextField("contactName", "客户联系人");
		contactNameField.setLength(32);
		contactNameField.setRequired(false);
		contactNameField.setHidden(true);


		contactPhoneField = new DataSourceTextField("contactPhone", "客户联系人电话");
		contactPhoneField.setLength(64);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(true);


		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(64);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(true);


		totalBuildingAreasField = new DataSourceTextField("totalBuildingAreas", "建筑总面积");
		totalBuildingAreasField.setLength(100);
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(true);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "立项人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(false);
		applyEmployeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		customerTypeField = new DataSourceIntegerField("customerType", "4接洽过未合作客户)(对应于字典表151)");
		customerTypeField.setLength(11);
		customerTypeField.setRequired(false);
		customerTypeField.setHidden(true);


		isWarehousField = new DataSourceBooleanField("isWarehous", "是否入库");
		isWarehousField.setRequired(false);
		isWarehousField.setHidden(true);


		isApplyQuoteField = new DataSourceBooleanField("isApplyQuote", "是否已提供战略报价");
		isApplyQuoteField.setRequired(false);
		isApplyQuoteField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectNameOneField = new DataSourceTextField("projectNameOne", "报备申请时项目名称");
		projectNameOneField.setLength(255);
		projectNameOneField.setRequired(false);
		projectNameOneField.setHidden(true);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "主键编码");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setPrimaryKey(true);
		mainProjectIdField.setRequired(true);
		mainProjectIdField.setHidden(true);


		isModifyProjectField = new DataSourceBooleanField("isModifyProject", "是否修改项目");
		isModifyProjectField.setRequired(false);
		isModifyProjectField.setHidden(false);


		mainProjectStageIdField = new DataSourceIntegerField("mainProjectStageId", "立项类型");
		mainProjectStageIdField.setLength(11);
		mainProjectStageIdField.setRequired(false);
		mainProjectStageIdField.setHidden(false);
		mainProjectStageIdField.setValueMap(KeyValueManager.getValueMap("main_project_stages"));

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);


		setFields(systemProcessAttentionIdField, processInstanceIdField, mainProjectIdField, businessIdField, businessNameField, processActivityIdField, processIdField, backViewNameField, instanceActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, statusField, processTypeField, operateTimeField, processCommentField, projectCodeField, projectNameField, provinceField, cityField, isModifyProjectField, mainProjectStageIdField, projectTypeField, customerNameField, projectOriginationField, contactNameField, contactPhoneField, detailAddressField, totalBuildingAreasField, applyEmployeeIdField, customerTypeField, isWarehousField, isApplyQuoteField, infoCodeField, projectNameOneField);
	}


}

