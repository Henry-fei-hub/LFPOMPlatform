package com.pomplatform.client.soutdesignconsiderationoor.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSoutdesignconsiderationoor extends DBDataSource
{


	public static DSSoutdesignconsiderationoor instance = null;

	public static DSSoutdesignconsiderationoor getInstance() {
		if(instance == null) {
			instance = new DSSoutdesignconsiderationoor("DSSoutdesignconsiderationoor");
		}
		return instance;
	}

	private final DataSourceTextField infoCodeField;
	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceIntegerField outTempletIdField;
	private final DataSourceTextField newCreateQuotationNameField;
//	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField dataCountField;
	private final DataSourceFloatField designAreaField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceFloatField interiorMoneySumField;
	private final DataSourceFloatField finalizedMoneyField;

	public DSSoutdesignconsiderationoor(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("Soutdesignconsiderationoor2");


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单表编码");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setHidden(true);
		outQuotationIdField.setForeignKey("DSOutQuotation.outQuotationId");

//		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
//		businessTypeField.setLength(11);
//		businessTypeField.setRequired(false);
//		businessTypeField.setHidden(true);
//		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		
		outTempletIdField= new DataSourceIntegerField("outTempletId", "模板");
		outTempletIdField.setLength(11);
		outTempletIdField.setRequired(false);
		outTempletIdField.setHidden(true);
		outTempletIdField.setValueMap(KeyValueManager.getValueMap("sys_templet_1"));
		
		
		newCreateQuotationNameField = new DataSourceTextField("newCreateQuotationName", "报价单标题");
		newCreateQuotationNameField.setLength(32);
		newCreateQuotationNameField.setRequired(false);

		dataCountField = new DataSourceIntegerField("dataCount", "报价单子项数量");
		dataCountField.setLength(8);
		dataCountField.setRequired(true);
		dataCountField.setHidden(false);


		designAreaField = new DataSourceFloatField("designArea", "设计面积(汇总)");
		designAreaField.setLength(16);
		designAreaField.setDecimalPad(2);
		designAreaField.setFormat("##,###,###,###,##0.00");
		designAreaField.setRequired(false);
		designAreaField.setHidden(true);


		moneySumField = new DataSourceFloatField("moneySum", "合同报价");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
//		moneySumField.setFormat("###,###,###,##0.0000");
		moneySumField.setRequired(false);
		moneySumField.setHidden(false);


		interiorMoneySumField = new DataSourceFloatField("interiorMoneySum", "产值");
		interiorMoneySumField.setLength(16);
		interiorMoneySumField.setDecimalPad(2);
//		interiorMoneySumField.setFormat("###,###,###");
		interiorMoneySumField.setRequired(false);
		interiorMoneySumField.setHidden(false);
		
		finalizedMoneyField = new DataSourceFloatField("finalizedMoney", "最终报价");
		finalizedMoneyField.setLength(16);
		finalizedMoneyField.setDecimalPad(2);
//		finalizedMoneyField.setFormat("###,###,###");
		finalizedMoneyField.setRequired(false);
		finalizedMoneyField.setHidden(true);

		setFields(infoCodeField, outQuotationIdField,newCreateQuotationNameField,outTempletIdField, dataCountField, designAreaField, moneySumField, interiorMoneySumField,finalizedMoneyField);
	}


}

