package com.pomplatform.client.ja.ht.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSStandardQuote extends DBDataSource
{


	public static DSStandardQuote instance = null;

	public static DSStandardQuote getInstance() {
		if(instance == null) {
			instance = new DSStandardQuote("DSStandardQuote");
		}
		return instance;
	}

	private final DataSourceTextField outQuotationIdField;
	private final DataSourceTextField samePercentField;
	private final DataSourceTextField infoCodeField;
	private final DataSourceTextField projectCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField businessTypeField;
	private final DataSourceDateTimeField projectApprovalTimeField;
	private final DataSourceTextField projectBaseOnField;
	private final DataSourceTextField bidTypeField;
	private final DataSourceTextField clientNameField;
	private final DataSourceTextField provinceField;
	private final DataSourceTextField cityField;
	private final DataSourceTextField projectLevelField;
	private final DataSourceFloatField areaField;
	private final DataSourceFloatField moneySumField;

	public DSStandardQuote(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("StandardQuote");
		
		outQuotationIdField = new DataSourceTextField("outQuotationId", "报价单主键Id");
		outQuotationIdField.setLength(16);
		outQuotationIdField.setHidden(true);
		
		samePercentField = new DataSourceTextField("samePercent", "相似度(%)");
		samePercentField.setLength(16);

		infoCodeField = new DataSourceTextField("infoCode", "信息编号");
		infoCodeField.setLength(32);
		infoCodeField.setRequired(false);

		projectCodeField = new DataSourceTextField("projectCode", "项目编号");
		projectCodeField.setLength(32);
		projectCodeField.setRequired(false);

		projectNameField = new DataSourceTextField("projectName", "项目名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);


		businessTypeField = new DataSourceTextField("businessType", "业务类别");
		businessTypeField.setLength(11);
		businessTypeField.setRequired(false);
//		businessTypeField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));

		projectApprovalTimeField = new DataSourceDateTimeField("projectApprovalTime","立项时间");
		projectApprovalTimeField.setLength(64);
		
		projectBaseOnField = new DataSourceTextField("projectBaseOn","立项依据");
		projectBaseOnField.setLength(11);
		projectBaseOnField.setValueMap(KeyValueManager.getValueMap("system_dictionary_28"));
		
		bidTypeField = new DataSourceTextField("bidType", "投标结果");
		bidTypeField.setLength(11);
		bidTypeField.setRequired(false);
		bidTypeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_128"));
		
		clientNameField = new DataSourceTextField("clientName", "客户名称");
		clientNameField.setLength(50);
		clientNameField.setRequired(false);
		
		provinceField = new DataSourceTextField("province", "省份");
		provinceField.setLength(32);
		provinceField.setRequired(false);


		cityField = new DataSourceTextField("city", "城市");
		cityField.setLength(32);
		cityField.setRequired(false);
		
		projectLevelField = new DataSourceTextField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));
		
		areaField = new DataSourceFloatField("area", "面积");
		areaField.setLength(16);
		areaField.setDecimalPad(2);
		areaField.setFormat("##,###,###,###,##0.00");
		
		moneySumField = new DataSourceFloatField("moneySum", "金额");
		moneySumField.setLength(16);
		moneySumField.setDecimalPad(2);
		moneySumField.setFormat("##,###,###,###,##0.00");

		setFields(samePercentField,moneySumField,areaField,infoCodeField, projectCodeField,projectNameField, businessTypeField,projectApprovalTimeField,projectBaseOnField,bidTypeField
		,clientNameField,provinceField,cityField,projectLevelField);
	}


}

