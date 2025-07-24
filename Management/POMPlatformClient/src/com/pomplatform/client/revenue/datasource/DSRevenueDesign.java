package com.pomplatform.client.revenue.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSRevenueDesign extends DBDataSource
{


	public static DSRevenueDesign instance = null;

	public static DSRevenueDesign getInstance() {
		if(instance == null) {
			instance = new DSRevenueDesign("DSRevenueDesign");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceFloatField totalPercentField;
	private final DataSourceTextField totalPercentStrField;
	private final DataSourceFloatField totalTaxRevenueField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceFloatField currentRevenueField;
	
	public DSRevenueDesign(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("RevenueStatisticalOfRevenue");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);
		KeyValueManager.loadValueMap("projects",projectIdField);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);

		sheetNameField = new DataSourceTextField("sheetName", "订单名称");
		sheetNameField.setLength(512);
		sheetNameField.setRequired(true);
		sheetNameField.setHidden(false);

		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		
		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);

		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(true);
		sheetAmountField.setHidden(false);


		totalPercentField = new DataSourceFloatField("totalPercent", "累计百分比");
		totalPercentField.setLength(18);
		totalPercentField.setDecimalPad(4);
		totalPercentField.setFormat("##,###,###,###,##0.0000");
		totalPercentField.setRequired(false);
		totalPercentField.setHidden(true);


		totalPercentStrField = new DataSourceTextField("totalPercentStr", "累计百分比");
		totalPercentStrField.setLength(18);
		totalPercentStrField.setRequired(true);
		totalPercentStrField.setHidden(false);
		
		totalTaxRevenueField = new DataSourceFloatField("totalTaxRevenue", "累积含税营收");
		totalTaxRevenueField.setLength(18);
		totalTaxRevenueField.setDecimalPad(2);
		totalTaxRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalTaxRevenueField.setRequired(false);
		totalTaxRevenueField.setHidden(false);
		
		totalRevenueField = new DataSourceFloatField("totalRevenue", "累计营收");
		totalRevenueField.setLength(18);
		totalRevenueField.setDecimalPad(2);
		totalRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalRevenueField.setRequired(false);
		totalRevenueField.setHidden(false);


		currentRevenueField = new DataSourceFloatField("currentRevenue", "本月营收");
		currentRevenueField.setLength(18);
		currentRevenueField.setDecimalPad(2);
		currentRevenueField.setFormat("#,###,###,###,###,##0.00");
		currentRevenueField.setRequired(false);
		currentRevenueField.setHidden(false);

		setFields(projectIdField, plateIdField, sheetCodeField, sheetNameField,yearField,monthField, sheetAmountField, totalPercentField, totalPercentStrField,totalTaxRevenueField, totalRevenueField,currentRevenueField);
	}


}

