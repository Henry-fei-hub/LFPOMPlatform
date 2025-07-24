package com.pomplatform.client.attentionprojectquotetemplate.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSAttentionProjectQuoteTemplate extends DBDataSource
{


	public static DSAttentionProjectQuoteTemplate instance = null;

	public static DSAttentionProjectQuoteTemplate getInstance() {
		if(instance == null) {
			instance = new DSAttentionProjectQuoteTemplate("DSAttentionProjectQuoteTemplate");
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
	private final DataSourceTextField customerNameField;
	private final DataSourceTextField projectOriginationField;
	private final DataSourceTextField contactNameField;
	private final DataSourceTextField contactPhoneField;
	private final DataSourceTextField detailAddressField;
	private final DataSourceFloatField totalBuildingAreasField;
	private final DataSourceIntegerField applyEmployeeIdField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField projectQuoteIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField quoteStatusField;
	private final DataSourceFloatField basicAmountField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField upAmountField;
	private final DataSourceFloatField upPercentField;
	private final DataSourceFloatField preferentialAmountField;
	private final DataSourceFloatField perferentialPercentField;
	private final DataSourceFloatField taxAmountField;
	private final DataSourceFloatField otherTaxAmountField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceFloatField finalPercentField;
	private final DataSourceFloatField taxFinalAmountField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField businessTypeField;

	public DSAttentionProjectQuoteTemplate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("AttentionProjectQuoteTemplate");


		systemProcessAttentionIdField = new DataSourceIntegerField("systemProcessAttentionId", "主键编码");
		systemProcessAttentionIdField.setLength(11);
		systemProcessAttentionIdField.setPrimaryKey(true);
		systemProcessAttentionIdField.setRequired(true);
		systemProcessAttentionIdField.setHidden(false);


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


		backViewNameField = new DataSourceTextField("backViewName", "返回数据集");
		backViewNameField.setLength(64);
		backViewNameField.setRequired(false);
		backViewNameField.setHidden(false);


		instanceActivityIdField = new DataSourceIntegerField("instanceActivityId", "流程实例节点编码");
		instanceActivityIdField.setLength(11);
		instanceActivityIdField.setRequired(false);
		instanceActivityIdField.setHidden(false);


		instanceActivityCreateTimeField = new DataSourceDateTimeField("instanceActivityCreateTime", "流程实例节点创建时间");
		instanceActivityCreateTimeField.setRequired(false);
		instanceActivityCreateTimeField.setHidden(false);


		instanceActivityStartTimeField = new DataSourceDateTimeField("instanceActivityStartTime", "流程实例节点开始处于活动时间");
		instanceActivityStartTimeField.setRequired(false);
		instanceActivityStartTimeField.setHidden(false);


		statusField = new DataSourceIntegerField("status", "状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);


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


		provinceField = new DataSourceTextField("province", "项目地址（省）");
		provinceField.setLength(32);
		provinceField.setRequired(false);
		provinceField.setHidden(true);


		cityField = new DataSourceTextField("city", "项目地址（市）");
		cityField.setLength(32);
		cityField.setRequired(false);
		cityField.setHidden(true);


		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(true);


		customerNameField = new DataSourceTextField("customerName", "开发商名称");
		customerNameField.setLength(512);
		customerNameField.setRequired(false);
		customerNameField.setHidden(true);


		projectOriginationField = new DataSourceTextField("projectOrigination", "项目来源渠道");
		projectOriginationField.setLength(512);
		projectOriginationField.setRequired(false);
		projectOriginationField.setHidden(true);


		contactNameField = new DataSourceTextField("contactName", "联系人");
		contactNameField.setLength(64);
		contactNameField.setRequired(false);
		contactNameField.setHidden(true);


		contactPhoneField = new DataSourceTextField("contactPhone", "联系电话");
		contactPhoneField.setLength(128);
		contactPhoneField.setRequired(false);
		contactPhoneField.setHidden(true);


		detailAddressField = new DataSourceTextField("detailAddress", "详细地址");
		detailAddressField.setLength(512);
		detailAddressField.setRequired(false);
		detailAddressField.setHidden(true);


		totalBuildingAreasField = new DataSourceFloatField("totalBuildingAreas", "项目面积");
		totalBuildingAreasField.setLength(18);
		totalBuildingAreasField.setDecimalPad(2);
		totalBuildingAreasField.setFormat("#,###,###,###,###,##0.00");
		totalBuildingAreasField.setRequired(false);
		totalBuildingAreasField.setHidden(true);


		applyEmployeeIdField = new DataSourceIntegerField("applyEmployeeId", "报备人");
		applyEmployeeIdField.setLength(11);
		applyEmployeeIdField.setRequired(false);
		applyEmployeeIdField.setHidden(true);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectQuoteIdField = new DataSourceIntegerField("projectQuoteId", "主键编码");
		projectQuoteIdField.setLength(11);
		projectQuoteIdField.setPrimaryKey(true);
		projectQuoteIdField.setRequired(true);
		projectQuoteIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(true);


		quoteStatusField = new DataSourceIntegerField("quoteStatus", "报价状态");
		quoteStatusField.setLength(11);
		quoteStatusField.setRequired(false);
		quoteStatusField.setHidden(true);


		basicAmountField = new DataSourceFloatField("basicAmount", "基准总额");
		basicAmountField.setLength(18);
		basicAmountField.setDecimalPad(2);
		basicAmountField.setFormat("#,###,###,###,###,##0.00");
		basicAmountField.setRequired(false);
		basicAmountField.setHidden(true);


		totalAmountField = new DataSourceFloatField("totalAmount", "小计总额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(true);


		upAmountField = new DataSourceFloatField("upAmount", "上浮金额");
		upAmountField.setLength(18);
		upAmountField.setDecimalPad(2);
		upAmountField.setFormat("#,###,###,###,###,##0.00");
		upAmountField.setRequired(false);
		upAmountField.setHidden(true);


		upPercentField = new DataSourceFloatField("upPercent", "上浮系数");
		upPercentField.setLength(18);
		upPercentField.setDecimalPad(2);
		upPercentField.setFormat("#,###,###,###,###,##0.00");
		upPercentField.setRequired(false);
		upPercentField.setHidden(true);


		preferentialAmountField = new DataSourceFloatField("preferentialAmount", "优惠金额");
		preferentialAmountField.setLength(18);
		preferentialAmountField.setDecimalPad(2);
		preferentialAmountField.setFormat("#,###,###,###,###,##0.00");
		preferentialAmountField.setRequired(false);
		preferentialAmountField.setHidden(true);


		perferentialPercentField = new DataSourceFloatField("perferentialPercent", "优惠系数");
		perferentialPercentField.setLength(18);
		perferentialPercentField.setDecimalPad(2);
		perferentialPercentField.setFormat("#,###,###,###,###,##0.00");
		perferentialPercentField.setRequired(false);
		perferentialPercentField.setHidden(true);


		taxAmountField = new DataSourceFloatField("taxAmount", "税金");
		taxAmountField.setLength(18);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("#,###,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(true);


		otherTaxAmountField = new DataSourceFloatField("otherTaxAmount", "其它税金（采买）");
		otherTaxAmountField.setLength(18);
		otherTaxAmountField.setDecimalPad(2);
		otherTaxAmountField.setFormat("#,###,###,###,###,##0.00");
		otherTaxAmountField.setRequired(false);
		otherTaxAmountField.setHidden(true);


		finalAmountField = new DataSourceFloatField("finalAmount", "不含税合计");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(2);
		finalAmountField.setFormat("#,###,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(true);


		finalPercentField = new DataSourceFloatField("finalPercent", "最终系数");
		finalPercentField.setLength(18);
		finalPercentField.setDecimalPad(2);
		finalPercentField.setFormat("#,###,###,###,###,##0.00");
		finalPercentField.setRequired(false);
		finalPercentField.setHidden(true);


		taxFinalAmountField = new DataSourceFloatField("taxFinalAmount", "含税合计");
		taxFinalAmountField.setLength(18);
		taxFinalAmountField.setDecimalPad(2);
		taxFinalAmountField.setFormat("#,###,###,###,###,##0.00");
		taxFinalAmountField.setRequired(false);
		taxFinalAmountField.setHidden(true);


		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(2048);
		remarkField.setRequired(false);
		remarkField.setHidden(true);



		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		setFields(systemProcessAttentionIdField, projectQuoteIdField, businessIdField, businessNameField, processActivityIdField, processIdField, processInstanceIdField, backViewNameField, instanceActivityIdField, instanceActivityCreateTimeField, instanceActivityStartTimeField, statusField, processTypeField, operateTimeField, processCommentField, projectNameField, provinceField, cityField, projectTypeField, customerNameField, projectOriginationField, contactNameField, contactPhoneField, detailAddressField, totalBuildingAreasField, applyEmployeeIdField, infoCodeField, projectIdField, quoteStatusField, basicAmountField, totalAmountField, upAmountField, upPercentField, preferentialAmountField, perferentialPercentField, taxAmountField, otherTaxAmountField, finalAmountField, finalPercentField, taxFinalAmountField, operateEmployeeIdField, remarkField, businessTypeField);
	}


}

