package com.pomplatform.client.onprojectquotetemplateworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnProjectQuoteTemplate extends DBDataSource
{


	public static DSOnProjectQuoteTemplate instance = null;

	public static DSOnProjectQuoteTemplate getInstance() {
		if(instance == null) {
			instance = new DSOnProjectQuoteTemplate("DSOnProjectQuoteTemplate");
		}
		return instance;
	}

	private final DataSourceIntegerField projectQuoteIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField titleNameField;
	private final DataSourceIntegerField fileIdField;
	private final DataSourceIntegerField versionNumberField;
	private final DataSourceIntegerField quoteStatusField;
	private final DataSourceFloatField basicAmountField;
	private final DataSourceFloatField totalAmountField;
	private final DataSourceFloatField upAmountField;
	private final DataSourceFloatField upPercentField;
	private final DataSourceFloatField preferentialAmountField;
	private final DataSourceFloatField perferentialPercentField;
	private final DataSourceFloatField specialDiscountAmountField;
	private final DataSourceFloatField specialDiscountPercentField;
	private final DataSourceFloatField taxAmountField;
	private final DataSourceFloatField otherTaxAmountField;
	private final DataSourceFloatField finalPercentField;
	private final DataSourceFloatField finalAmountField;
	private final DataSourceFloatField taxFinalAmountField;
	private final DataSourceIntegerField operateEmployeeIdField;
	private final DataSourceDateTimeField operateTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceField detailProjectQuoteDetail;

	public DSOnProjectQuoteTemplate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnProjectQuoteTemplate");


		projectQuoteIdField = new DataSourceIntegerField("projectQuoteId", "主键编码");
		projectQuoteIdField.setLength(11);
		projectQuoteIdField.setPrimaryKey(true);
		projectQuoteIdField.setRequired(true);
		projectQuoteIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		titleNameField = new DataSourceTextField("titleName", "主题名称");
		titleNameField.setLength(64);
		titleNameField.setRequired(false);
		titleNameField.setHidden(false);


		fileIdField = new DataSourceIntegerField("fileId", "过往合作项目报价图片");
		fileIdField.setLength(11);
		fileIdField.setRequired(false);
		fileIdField.setHidden(false);


		versionNumberField = new DataSourceIntegerField("versionNumber", "版本号");
		versionNumberField.setLength(11);
		versionNumberField.setRequired(false);
		versionNumberField.setHidden(false);


		quoteStatusField = new DataSourceIntegerField("quoteStatus", "2已报价)");
		quoteStatusField.setLength(11);
		quoteStatusField.setRequired(false);
		quoteStatusField.setHidden(false);


		basicAmountField = new DataSourceFloatField("basicAmount", "基准总额");
		basicAmountField.setLength(18);
		basicAmountField.setDecimalPad(2);
		basicAmountField.setFormat("#,###,###,###,###,##0.00");
		basicAmountField.setRequired(false);
		basicAmountField.setHidden(false);


		totalAmountField = new DataSourceFloatField("totalAmount", "小计总额");
		totalAmountField.setLength(18);
		totalAmountField.setDecimalPad(2);
		totalAmountField.setFormat("#,###,###,###,###,##0.00");
		totalAmountField.setRequired(false);
		totalAmountField.setHidden(false);


		upAmountField = new DataSourceFloatField("upAmount", "上浮金额");
		upAmountField.setLength(18);
		upAmountField.setDecimalPad(2);
		upAmountField.setFormat("#,###,###,###,###,##0.00");
		upAmountField.setRequired(false);
		upAmountField.setHidden(false);


		upPercentField = new DataSourceFloatField("upPercent", "上浮系数");
		upPercentField.setLength(18);
		upPercentField.setDecimalPad(2);
		upPercentField.setFormat("#,###,###,###,###,##0.00");
		upPercentField.setRequired(false);
		upPercentField.setHidden(false);


		preferentialAmountField = new DataSourceFloatField("preferentialAmount", "优惠金额");
		preferentialAmountField.setLength(18);
		preferentialAmountField.setDecimalPad(2);
		preferentialAmountField.setFormat("#,###,###,###,###,##0.00");
		preferentialAmountField.setRequired(false);
		preferentialAmountField.setHidden(false);


		perferentialPercentField = new DataSourceFloatField("perferentialPercent", "优惠系数");
		perferentialPercentField.setLength(18);
		perferentialPercentField.setDecimalPad(2);
		perferentialPercentField.setFormat("#,###,###,###,###,##0.00");
		perferentialPercentField.setRequired(false);
		perferentialPercentField.setHidden(false);


		specialDiscountAmountField = new DataSourceFloatField("specialDiscountAmount", "特殊折扣金额");
		specialDiscountAmountField.setLength(18);
		specialDiscountAmountField.setDecimalPad(2);
		specialDiscountAmountField.setFormat("#,###,###,###,###,##0.00");
		specialDiscountAmountField.setRequired(false);
		specialDiscountAmountField.setHidden(false);


		specialDiscountPercentField = new DataSourceFloatField("specialDiscountPercent", "特殊折扣系数");
		specialDiscountPercentField.setLength(18);
		specialDiscountPercentField.setDecimalPad(2);
		specialDiscountPercentField.setFormat("#,###,###,###,###,##0.00");
		specialDiscountPercentField.setRequired(false);
		specialDiscountPercentField.setHidden(false);


		taxAmountField = new DataSourceFloatField("taxAmount", "税金");
		taxAmountField.setLength(18);
		taxAmountField.setDecimalPad(2);
		taxAmountField.setFormat("#,###,###,###,###,##0.00");
		taxAmountField.setRequired(false);
		taxAmountField.setHidden(false);


		otherTaxAmountField = new DataSourceFloatField("otherTaxAmount", "其它税金（采买）");
		otherTaxAmountField.setLength(18);
		otherTaxAmountField.setDecimalPad(2);
		otherTaxAmountField.setFormat("#,###,###,###,###,##0.00");
		otherTaxAmountField.setRequired(false);
		otherTaxAmountField.setHidden(true);


		finalPercentField = new DataSourceFloatField("finalPercent", "最终系数");
		finalPercentField.setLength(18);
		finalPercentField.setDecimalPad(2);
		finalPercentField.setFormat("#,###,###,###,###,##0.00");
		finalPercentField.setRequired(false);
		finalPercentField.setHidden(true);


		finalAmountField = new DataSourceFloatField("finalAmount", "不含税合计");
		finalAmountField.setLength(18);
		finalAmountField.setDecimalPad(2);
		finalAmountField.setFormat("#,###,###,###,###,##0.00");
		finalAmountField.setRequired(false);
		finalAmountField.setHidden(true);


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


		companyIdField = new DataSourceIntegerField("companyId", "公司id");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);

		detailProjectQuoteDetail = new DataSourceField("detailProjectQuoteDetail", FieldType.ANY);
		detailProjectQuoteDetail.setChildrenProperty(true);
		detailProjectQuoteDetail.setChildTagName("ProjectQuoteDetail");
		detailProjectQuoteDetail.setRequired(false);
		detailProjectQuoteDetail.setHidden(true);

		setFields(projectQuoteIdField, projectIdField, titleNameField, fileIdField, versionNumberField, quoteStatusField, basicAmountField, totalAmountField, upAmountField, upPercentField, preferentialAmountField, perferentialPercentField, specialDiscountAmountField, specialDiscountPercentField, taxAmountField, otherTaxAmountField, finalPercentField, finalAmountField, taxFinalAmountField, operateEmployeeIdField, operateTimeField, remarkField, companyIdField, detailProjectQuoteDetail);
	}


}

