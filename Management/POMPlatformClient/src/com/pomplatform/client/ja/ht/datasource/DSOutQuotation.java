package com.pomplatform.client.ja.ht.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOutQuotation extends DBDataSource
{


	public static DSOutQuotation instance = null;

	public static DSOutQuotation getInstance() {
		if(instance == null) {
			instance = new DSOutQuotation("DSOutQuotation");
		}
		return instance;
	}

	private final DataSourceIntegerField outQuotationIdField;
	private final DataSourceTextField quotationNumberField;
	private final DataSourceTextField quotationNameField;
	private final DataSourceFloatField moneySumField;
	private final DataSourceDateTimeField createTimeField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceIntegerField businessTypeField;
	private final DataSourceIntegerField projectTypeField;
	private final DataSourceLinkField quotationFilesField;
	private final DataSourceIntegerField quotationStatusField;
	private final DataSourceIntegerField disableTypeField;

	public DSOutQuotation(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("OutQuotation");


		outQuotationIdField = new DataSourceIntegerField("outQuotationId", "报价单编码");
		outQuotationIdField.setLength(11);
		outQuotationIdField.setPrimaryKey(true);
		outQuotationIdField.setRequired(true);
		outQuotationIdField.setHidden(true);
		outQuotationIdField.setForeignKey("DSOutQuotation.outQuotationId");  


		quotationNumberField = new DataSourceTextField("quotationNumber", "报价单编号");
		quotationNumberField.setLength(32);
		quotationNumberField.setRequired(false);
		quotationNumberField.setHidden(false);


		quotationNameField = new DataSourceTextField("quotationName", "报价单名称");
		quotationNameField.setLength(512);
		quotationNameField.setRequired(false);
		quotationNameField.setHidden(false);


		moneySumField = new DataSourceFloatField("moneySum", "报价单总金额(元)");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");
		moneySumField.setRequired(false);
		moneySumField.setHidden(true);


		createTimeField = new DataSourceDateTimeField("createTime", "报价单创建时间");
		createTimeField.setRequired(false);
		createTimeField.setHidden(false);


		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);
		infoCodeField.setHidden(true);


		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(64);
		projectCodeField.setRequired(false);
		projectCodeField.setHidden(true);


		businessTypeField = new DataSourceIntegerField("businessType", "业务类型");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
		businessTypeField.setHidden(false);
		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));


		projectTypeField = new DataSourceIntegerField("projectType", "项目类型");
		projectTypeField.setLength(11);
		projectTypeField.setRequired(false);
		projectTypeField.setHidden(false);
		projectTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_32"));


		quotationFilesField = new DataSourceLinkField("quotationFiles", "报价单(原附件)");
		quotationFilesField.setRequired(false);
		quotationFilesField.setHidden(false);

		quotationStatusField = new DataSourceIntegerField("quotationStatus", "报价单的状态");
		quotationStatusField.setLength(11);
		quotationStatusField.setRequired(false);
		quotationStatusField.setHidden(false);

		java.util.Map<String,String> quotationStatusValues = new java.util.HashMap<String,String>();
		quotationStatusValues.put("1", "成功");
		quotationStatusValues.put("2", "历史版本");
		quotationStatusValues.put("3", "报价中");
		quotationStatusField.setValueMap(quotationStatusValues);


		disableTypeField = new DataSourceIntegerField("disableType", "可操作状态");
		disableTypeField.setLength(11);
		disableTypeField.setRequired(false);
		disableTypeField.setHidden(true);

		java.util.Map<String,String> disableTypeValues = new java.util.HashMap<String,String>();
		disableTypeValues.put("1", "不可操作");
		disableTypeValues.put("0", "可操作");
		disableTypeField.setValueMap(disableTypeValues);


		setFields(outQuotationIdField, quotationNumberField, quotationNameField, moneySumField, createTimeField, infoCodeField, projectCodeField, businessTypeField, projectTypeField, quotationFilesField, quotationStatusField, disableTypeField);
	}


}

