package com.pomplatform.client.onprojectquotetemplateworkflow.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSProjectQuoteDetail extends DBDataSource
{


	public static DSProjectQuoteDetail instance = null;

	public static DSProjectQuoteDetail getInstance() {
		if(instance == null) {
			instance = new DSProjectQuoteDetail("DSProjectQuoteDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField projectQuoteDetailIdField;
	private final DataSourceIntegerField projectQuoteIdField;
	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceTextField designTypeNameField;
	private final DataSourceTextField designContentField;
	private final DataSourceIntegerField designStageField;
	private final DataSourceIntegerField areaTypeField;
	private final DataSourceFloatField areaField;
	private final DataSourceFloatField areaPriceField;
	private final DataSourceFloatField totalPriceField;
	private final DataSourceFloatField taxField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField companyIdField;

	public DSProjectQuoteDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("ProjectQuoteDetail");


		projectQuoteDetailIdField = new DataSourceIntegerField("projectQuoteDetailId", "主键编码");
		projectQuoteDetailIdField.setLength(11);
		projectQuoteDetailIdField.setPrimaryKey(true);
		projectQuoteDetailIdField.setRequired(true);
		projectQuoteDetailIdField.setHidden(false);


		projectQuoteIdField = new DataSourceIntegerField("projectQuoteId", "项目报价");
		projectQuoteIdField.setLength(11);
		projectQuoteIdField.setRequired(false);
		projectQuoteIdField.setHidden(false);


		projectIdField = new DataSourceIntegerField("projectId", "项目id");
		projectIdField.setLength(11);
		projectIdField.setRequired(false);
		projectIdField.setHidden(false);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);


		designTypeNameField = new DataSourceTextField("designTypeName", "设计类型名称");
		designTypeNameField.setLength(128);
		designTypeNameField.setRequired(false);
		designTypeNameField.setHidden(false);


		designContentField = new DataSourceTextField("designContent", "设计内容");
		designContentField.setLength(128);
		designContentField.setRequired(false);
		designContentField.setHidden(false);


		designStageField = new DataSourceIntegerField("designStage", "设计阶段");
		designStageField.setLength(11);
		designStageField.setRequired(false);
		designStageField.setHidden(false);


		areaTypeField = new DataSourceIntegerField("areaType", "面积类型");
		areaTypeField.setLength(11);
		areaTypeField.setRequired(false);
		areaTypeField.setHidden(false);


		areaField = new DataSourceFloatField("area", "面积");
		areaField.setLength(18);
		areaField.setDecimalPad(2);
		areaField.setFormat("#,###,###,###,###,##0.00");
		areaField.setRequired(false);
		areaField.setHidden(false);


		areaPriceField = new DataSourceFloatField("areaPrice", "单价");
		areaPriceField.setLength(18);
		areaPriceField.setDecimalPad(2);
		areaPriceField.setFormat("#,###,###,###,###,##0.00");
		areaPriceField.setRequired(false);
		areaPriceField.setHidden(false);


		totalPriceField = new DataSourceFloatField("totalPrice", "小计");
		totalPriceField.setLength(18);
		totalPriceField.setDecimalPad(2);
		totalPriceField.setFormat("#,###,###,###,###,##0.00");
		totalPriceField.setRequired(false);
		totalPriceField.setHidden(false);


		taxField = new DataSourceFloatField("tax", "税率");
		taxField.setLength(18);
		taxField.setDecimalPad(2);
		taxField.setFormat("#,###,###,###,###,##0.00");
		taxField.setRequired(false);
		taxField.setHidden(false);


		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(2048);
		remarkField.setRequired(false);
		remarkField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "公司编码");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);


		setFields(projectQuoteDetailIdField, projectQuoteIdField, projectIdField, businessTypeField, designTypeNameField, designContentField, designStageField, areaTypeField, areaField, areaPriceField, totalPriceField, taxField, remarkField, companyIdField);
	}


}

