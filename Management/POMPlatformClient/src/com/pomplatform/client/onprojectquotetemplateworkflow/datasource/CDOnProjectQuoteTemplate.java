package com.pomplatform.client.onprojectquotetemplateworkflow.datasource;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;

public class CDOnProjectQuoteTemplate extends DataSource
{


	public static CDOnProjectQuoteTemplate instance = null;

	public static CDOnProjectQuoteTemplate getInstance() {
		if(instance == null) {
			instance = new CDOnProjectQuoteTemplate("CDOnProjectQuoteTemplate");
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

	public CDOnProjectQuoteTemplate(String dataSourceID) {

		setID(dataSourceID);
		projectQuoteIdField = new DataSourceIntegerField("projectQuoteId", "主键编码");
		projectQuoteIdField.setRequired(true);
		projectQuoteIdField.setLength(11);
		projectQuoteIdField.setPrimaryKey(true);
		projectQuoteIdField.setHidden(true);

		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setRequired(false);
		projectIdField.setLength(11);
		projectIdField.setHidden(false);

		titleNameField = new DataSourceTextField("titleName", "主题名称");
		titleNameField.setRequired(false);
		titleNameField.setLength(64);
		titleNameField.setHidden(false);

		fileIdField = new DataSourceIntegerField("fileId", "过往合作项目报价图片");
		fileIdField.setRequired(false);
		fileIdField.setLength(11);
		fileIdField.setHidden(false);

		versionNumberField = new DataSourceIntegerField("versionNumber", "版本号");
		versionNumberField.setRequired(false);
		versionNumberField.setLength(11);
		versionNumberField.setHidden(false);

		quoteStatusField = new DataSourceIntegerField("quoteStatus", "2已报价)");
		quoteStatusField.setRequired(false);
		quoteStatusField.setLength(11);
		quoteStatusField.setHidden(false);

		basicAmountField = new DataSourceFloatField("basicAmount", "基准总额");
		basicAmountField.setRequired(true);
		basicAmountField.setLength(18);
		basicAmountField.setHidden(false);

		totalAmountField = new DataSourceFloatField("totalAmount", "小计总额");
		totalAmountField.setRequired(true);
		totalAmountField.setLength(18);
		totalAmountField.setHidden(false);

		upAmountField = new DataSourceFloatField("upAmount", "上浮金额");
		upAmountField.setRequired(true);
		upAmountField.setLength(18);
		upAmountField.setHidden(false);

		upPercentField = new DataSourceFloatField("upPercent", "上浮系数");
		upPercentField.setRequired(true);
		upPercentField.setLength(18);
		upPercentField.setHidden(false);

		preferentialAmountField = new DataSourceFloatField("preferentialAmount", "优惠金额");
		preferentialAmountField.setRequired(true);
		preferentialAmountField.setLength(18);
		preferentialAmountField.setHidden(false);

		perferentialPercentField = new DataSourceFloatField("perferentialPercent", "优惠系数");
		perferentialPercentField.setRequired(true);
		perferentialPercentField.setLength(18);
		perferentialPercentField.setHidden(false);

		specialDiscountAmountField = new DataSourceFloatField("specialDiscountAmount", "特殊折扣金额");
		specialDiscountAmountField.setRequired(true);
		specialDiscountAmountField.setLength(18);
		specialDiscountAmountField.setHidden(false);

		specialDiscountPercentField = new DataSourceFloatField("specialDiscountPercent", "特殊折扣系数");
		specialDiscountPercentField.setRequired(true);
		specialDiscountPercentField.setLength(18);
		specialDiscountPercentField.setHidden(false);

		taxAmountField = new DataSourceFloatField("taxAmount", "税金");
		taxAmountField.setRequired(true);
		taxAmountField.setLength(18);
		taxAmountField.setHidden(false);

		otherTaxAmountField = new DataSourceFloatField("otherTaxAmount", "其它税金（采买）");
		otherTaxAmountField.setRequired(true);
		otherTaxAmountField.setLength(18);
		otherTaxAmountField.setHidden(false);

		finalPercentField = new DataSourceFloatField("finalPercent", "最终系数");
		finalPercentField.setRequired(true);
		finalPercentField.setLength(18);
		finalPercentField.setHidden(false);

		finalAmountField = new DataSourceFloatField("finalAmount", "不含税合计");
		finalAmountField.setRequired(true);
		finalAmountField.setLength(18);
		finalAmountField.setHidden(false);

		taxFinalAmountField = new DataSourceFloatField("taxFinalAmount", "含税合计");
		taxFinalAmountField.setRequired(true);
		taxFinalAmountField.setLength(18);
		taxFinalAmountField.setHidden(false);

		operateEmployeeIdField = new DataSourceIntegerField("operateEmployeeId", "操作人");
		operateEmployeeIdField.setRequired(false);
		operateEmployeeIdField.setLength(11);
		operateEmployeeIdField.setHidden(false);

		operateTimeField = new DataSourceDateTimeField("operateTime", "操作时间");
		operateTimeField.setRequired(false);
		operateTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setRequired(false);
		remarkField.setLength(2048);
		remarkField.setHidden(false);

		companyIdField = new DataSourceIntegerField("companyId", "公司id");
		companyIdField.setRequired(false);
		companyIdField.setLength(11);
		companyIdField.setHidden(false);

		DataSourceIntegerField currentPageField
			= new DataSourceIntegerField("currentPage", "当前页");
		currentPageField.setRequired(true);
		currentPageField.setLength(10);
		currentPageField.setHidden(true);

		DataSourceIntegerField pageLinesField
			= new DataSourceIntegerField("pageLines", "每页行数");
		pageLinesField.setRequired(true);
		pageLinesField.setLength(10);
		pageLinesField.setHidden(true);


		setFields(projectQuoteIdField, projectIdField, titleNameField, fileIdField, versionNumberField, quoteStatusField, basicAmountField, totalAmountField, upAmountField, upPercentField, preferentialAmountField, perferentialPercentField, specialDiscountAmountField, specialDiscountPercentField, taxAmountField, otherTaxAmountField, finalPercentField, finalAmountField, taxFinalAmountField, operateEmployeeIdField, operateTimeField, remarkField, companyIdField, currentPageField, pageLinesField);

		setClientOnly(true);
	}


}

