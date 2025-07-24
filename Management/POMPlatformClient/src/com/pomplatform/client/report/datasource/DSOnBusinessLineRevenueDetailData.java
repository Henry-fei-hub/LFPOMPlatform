package com.pomplatform.client.report.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnBusinessLineRevenueDetailData extends DBDataSource
{


	public static DSOnBusinessLineRevenueDetailData instance = null;

	public static DSOnBusinessLineRevenueDetailData getInstance() {
		if(instance == null) {
			instance = new DSOnBusinessLineRevenueDetailData("DSOnBusinessLineRevenueDetailData");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceTextField businessLineField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceTextField yearField;
	private final DataSourceFloatField januaryRevenueField;
	private final DataSourceFloatField februaryRevenueField;
	private final DataSourceFloatField marchRevenueField;
	private final DataSourceFloatField aprilRevenueField;
	private final DataSourceFloatField mayRevenueField;
	private final DataSourceFloatField juneRevenueField;
	private final DataSourceFloatField julyRevenueField;
	private final DataSourceFloatField augustRevenueField;
	private final DataSourceFloatField septemberRevenueField;
	private final DataSourceFloatField octoberRevenueField;
	private final DataSourceFloatField novemberRevenueField;
	private final DataSourceFloatField decemberRevenueField;

	public DSOnBusinessLineRevenueDetailData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnBusinessLineRevenueDetailData");


		projectIdField = new DataSourceIntegerField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		businessLineField = new DataSourceTextField("businessLine", "业务条线");
		businessLineField.setLength(11);
		businessLineField.setRequired(false);
		businessLineField.setHidden(false);
//		businessLineField.setValueMap(KeyValueManager.getValueMap("production_value_coefficient_type"));
		businessLineField.setValueMap(KeyValueManager.getValueMap("system_dictionary_205"));


		sheetAmountField = new DataSourceFloatField("sheetAmount", "合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		januaryRevenueField = new DataSourceFloatField("januaryRevenue", "1月");
		januaryRevenueField.setLength(18);
		januaryRevenueField.setDecimalPad(2);
		januaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		januaryRevenueField.setRequired(false);
		januaryRevenueField.setHidden(false);


		februaryRevenueField = new DataSourceFloatField("februaryRevenue", "2月");
		februaryRevenueField.setLength(18);
		februaryRevenueField.setDecimalPad(2);
		februaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		februaryRevenueField.setRequired(false);
		februaryRevenueField.setHidden(false);


		marchRevenueField = new DataSourceFloatField("marchRevenue", "3月");
		marchRevenueField.setLength(18);
		marchRevenueField.setDecimalPad(2);
		marchRevenueField.setFormat("#,###,###,###,###,##0.00");
		marchRevenueField.setRequired(false);
		marchRevenueField.setHidden(false);


		aprilRevenueField = new DataSourceFloatField("aprilRevenue", "4月");
		aprilRevenueField.setLength(18);
		aprilRevenueField.setDecimalPad(2);
		aprilRevenueField.setFormat("#,###,###,###,###,##0.00");
		aprilRevenueField.setRequired(false);
		aprilRevenueField.setHidden(false);


		mayRevenueField = new DataSourceFloatField("mayRevenue", "5月");
		mayRevenueField.setLength(18);
		mayRevenueField.setDecimalPad(2);
		mayRevenueField.setFormat("#,###,###,###,###,##0.00");
		mayRevenueField.setRequired(false);
		mayRevenueField.setHidden(false);


		juneRevenueField = new DataSourceFloatField("juneRevenue", "6月");
		juneRevenueField.setLength(18);
		juneRevenueField.setDecimalPad(2);
		juneRevenueField.setFormat("#,###,###,###,###,##0.00");
		juneRevenueField.setRequired(false);
		juneRevenueField.setHidden(false);


		julyRevenueField = new DataSourceFloatField("julyRevenue", "7月");
		julyRevenueField.setLength(18);
		julyRevenueField.setDecimalPad(2);
		julyRevenueField.setFormat("#,###,###,###,###,##0.00");
		julyRevenueField.setRequired(false);
		julyRevenueField.setHidden(false);


		augustRevenueField = new DataSourceFloatField("augustRevenue", "8月");
		augustRevenueField.setLength(18);
		augustRevenueField.setDecimalPad(2);
		augustRevenueField.setFormat("#,###,###,###,###,##0.00");
		augustRevenueField.setRequired(false);
		augustRevenueField.setHidden(false);


		septemberRevenueField = new DataSourceFloatField("septemberRevenue", "9月");
		septemberRevenueField.setLength(18);
		septemberRevenueField.setDecimalPad(2);
		septemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		septemberRevenueField.setRequired(false);
		septemberRevenueField.setHidden(false);


		octoberRevenueField = new DataSourceFloatField("octoberRevenue", "10月");
		octoberRevenueField.setLength(18);
		octoberRevenueField.setDecimalPad(2);
		octoberRevenueField.setFormat("#,###,###,###,###,##0.00");
		octoberRevenueField.setRequired(false);
		octoberRevenueField.setHidden(false);


		novemberRevenueField = new DataSourceFloatField("novemberRevenue", "11月");
		novemberRevenueField.setLength(18);
		novemberRevenueField.setDecimalPad(2);
		novemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		novemberRevenueField.setRequired(false);
		novemberRevenueField.setHidden(false);


		decemberRevenueField = new DataSourceFloatField("decemberRevenue", "12月");
		decemberRevenueField.setLength(18);
		decemberRevenueField.setDecimalPad(2);
		decemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		decemberRevenueField.setRequired(false);
		decemberRevenueField.setHidden(false);


		setFields(projectIdField, plateIdField, sheetCodeField, projectNameField, businessLineField, sheetAmountField, yearField, januaryRevenueField, februaryRevenueField, marchRevenueField, aprilRevenueField, mayRevenueField, juneRevenueField, julyRevenueField, augustRevenueField, septemberRevenueField, octoberRevenueField, novemberRevenueField, decemberRevenueField);
	}


}

