package com.pomplatform.client.refuseprojectquotetemplate.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSRefuseProjectQuoteTemplate extends DBDataSource
{


	public static DSRefuseProjectQuoteTemplate instance = null;

	public static DSRefuseProjectQuoteTemplate getInstance() {
		if(instance == null) {
			instance = new DSRefuseProjectQuoteTemplate("DSRefuseProjectQuoteTemplate");
		}
		return instance;
	}

	private final DataSourceIntegerField processInstanceIdField;
	private final DataSourceIntegerField processTypeField;
	private final DataSourceIntegerField businessIdField;
	private final DataSourceTextField businessNameField;
	private final DataSourceIntegerField processIdField;
	private final DataSourceIntegerField processInstanceActivityIdField;
	private final DataSourceIntegerField processStatusField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceDateTimeField completeTimeField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField infoCodeField;
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
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField businessTypeField;

	public DSRefuseProjectQuoteTemplate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RefuseProjectQuoteTemplate");


		processInstanceIdField = new DataSourceIntegerField("processInstanceId", "主键编码");
		processInstanceIdField.setLength(11);
		processInstanceIdField.setPrimaryKey(true);
		processInstanceIdField.setRequired(true);
		processInstanceIdField.setHidden(false);


		processTypeField = new DataSourceIntegerField("processType", "流程类型");
		processTypeField.setLength(11);
		processTypeField.setRequired(false);
		processTypeField.setHidden(false);


		businessIdField = new DataSourceIntegerField("businessId", "业务编码");
		businessIdField.setLength(11);
		businessIdField.setRequired(false);
		businessIdField.setHidden(false);


		businessNameField = new DataSourceTextField("businessName", "业务名称");
		businessNameField.setLength(256);
		businessNameField.setRequired(false);
		businessNameField.setHidden(false);


		processIdField = new DataSourceIntegerField("processId", "流程编码");
		processIdField.setLength(11);
		processIdField.setRequired(false);
		processIdField.setHidden(false);


		processInstanceActivityIdField = new DataSourceIntegerField("processInstanceActivityId", "活动实列编码");
		processInstanceActivityIdField.setLength(11);
		processInstanceActivityIdField.setRequired(false);
		processInstanceActivityIdField.setHidden(false);


		processStatusField = new DataSourceIntegerField("processStatus", "流程状态");
		processStatusField.setLength(11);
		processStatusField.setRequired(false);
		processStatusField.setHidden(false);


		createTimeField = new DataSourceDateTimeField("createTime", "创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		completeTimeField = new DataSourceDateTimeField("completeTime", "完成时间");
		completeTimeField.setRequired(false);
		completeTimeField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "创建人");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(false);


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


		projectTypeField = new DataSourceTextField("projectType", "项目类别");
		projectTypeField.setLength(128);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);


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


		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(true);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(2048);
		remarkField.setRequired(false);
		remarkField.setHidden(true);



		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(true);


		setFields(processInstanceIdField, projectQuoteIdField, processTypeField, businessIdField, businessNameField, processIdField, processInstanceActivityIdField, processStatusField, createTimeField, completeTimeField, employeeIdField, infoCodeField, projectNameField, provinceField, cityField, projectTypeField, customerNameField, projectOriginationField, contactNameField, contactPhoneField, detailAddressField, totalBuildingAreasField, projectIdField, quoteStatusField, basicAmountField, totalAmountField, upAmountField, upPercentField, preferentialAmountField, perferentialPercentField, taxAmountField, otherTaxAmountField, finalAmountField, finalPercentField, taxFinalAmountField, operateEmployeeIdField, operateTimeField, remarkField,  businessTypeField);
	}


}

