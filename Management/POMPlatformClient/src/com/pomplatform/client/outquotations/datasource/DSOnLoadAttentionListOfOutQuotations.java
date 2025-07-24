package com.pomplatform.client.outquotations.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnLoadAttentionListOfOutQuotations extends DBDataSource
{


	public static DSOnLoadAttentionListOfOutQuotations instance = null;

	public static DSOnLoadAttentionListOfOutQuotations getInstance() {
		if(instance == null) {
			instance = new DSOnLoadAttentionListOfOutQuotations("DSOnLoadAttentionListOfOutQuotations");
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
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField processCommentField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceTextField quotationNumberField;
	private final DataSourceTextField quotationNameField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceDateTimeField startTimeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceTextField quotationFilesField;
	private final DataSourceIntegerField quotationStatusField;
	private final DataSourceIntegerField disableTypeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField contractIdField;
	private final DataSourceDateTimeField updateTimeField;

	public DSOnLoadAttentionListOfOutQuotations(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnLoadAttentionListOfOutQuotations");


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


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		processCommentField = new DataSourceTextField("processComment", "提交意见");
		processCommentField.setLength(512);
		processCommentField.setRequired(false);
		processCommentField.setHidden(true);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(true);


		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单标题");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setPrimaryKey(true);
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setHidden(true);
		outQuotationIdField.setValueMap(KeyValueManager.getValueMap("out_design_considerations"));


		quotationNumberField = new DataSourceTextField("quotationNumber", "报价单编号");
		quotationNumberField.setLength(32);
		quotationNumberField.setRequired(false);
		quotationNumberField.setHidden(false);


		quotationNameField = new DataSourceTextField("quotationName", "报价单名称");
		quotationNameField.setLength(512);
		quotationNameField.setRequired(false);
		quotationNameField.setHidden(false);


		moneySumField = new DataSourceFloatField("moneySum", "报价单总金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(true);


		startTimeField = new DataSourceDateTimeField("startTime", "起草时间");
		startTimeField.setRequired(true);
		startTimeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(64);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);
		KeyValueManager.loadValueMap("contracts", projectNameField);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		quotationFilesField = new DataSourceTextField("quotationFiles", "报价单(原附件)");
		quotationFilesField.setLength(512);
		quotationFilesField.setRequired(false);
		quotationFilesField.setHidden(true);


		quotationStatusField = new DataSourceIntegerField("quotationStatus", "报价单的状态");
		quotationStatusField.setLength(11);
		quotationStatusField.setRequired(false);
		quotationStatusField.setHidden(false);
		java.util.Map<String,String> quotationStatusValues = new java.util.HashMap<String,String>();
		quotationStatusValues.put("1", "成功");
		quotationStatusValues.put("2", "历史版本");
		quotationStatusValues.put("3", "报价中");
		quotationStatusField.setValueMap(quotationStatusValues);


		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态 0可操作,1禁止操作");
		disableTypeField.setLength(11);
		disableTypeField.setRequired(false);
		disableTypeField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		contractIdField = new DataSourceIntegerField("contractId", "contract_id");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);


		updateTimeField = new DataSourceDateTimeField("updateTime", "修改时间");
		updateTimeField.setRequired(false);
		updateTimeField.setHidden(true);


		setFields(systemProcessAttentionIdField, processInstanceIdField, outQuotationIdField, businessIdField, businessNameField, processActivityIdField, processIdField, backViewNameField, instanceActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, statusField, operateTimeField, processCommentField, processTypeField, quotationNumberField, quotationNameField, moneySumField,  infoCodeField, projectCodeField,projectNameField, businessTypeField, projectTypeField, quotationFilesField, quotationStatusField, disableTypeField, employeeIdField, contractIdField, updateTimeField,startTimeField);
	}


}

