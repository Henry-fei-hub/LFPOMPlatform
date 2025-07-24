package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportCapitaProjectDetail extends DBDataSource
{


	public static DSReportCapitaProjectDetail instance = null;

	public static DSReportCapitaProjectDetail getInstance() {
		if(instance == null) {
			instance = new DSReportCapitaProjectDetail("DSReportCapitaProjectDetail");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField projectIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceIntegerField yearField;
	private final DataSourceFloatField beforeMoneyField;
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

	public DSReportCapitaProjectDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportCapitaProjectDetail");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectIdField = new DataSourceTextField("projectId", "项目编码");
		projectIdField.setLength(11);
		projectIdField.setPrimaryKey(true);
		projectIdField.setRequired(true);
		projectIdField.setHidden(true);


		sheetCodeField = new DataSourceTextField("sheetCode", "订单编号");
		sheetCodeField.setLength(64);
		sheetCodeField.setRequired(true);
		sheetCodeField.setHidden(false);


		projectNameField = new DataSourceTextField("projectName", "订单名称");
		projectNameField.setLength(512);
		projectNameField.setRequired(false);
		projectNameField.setHidden(false);


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		beforeMoneyField = new DataSourceFloatField("beforeMoney", "期初累计现金流");
		beforeMoneyField.setLength(18);
		beforeMoneyField.setDecimalPad(2);
		beforeMoneyField.setFormat("#,###,###,###,###,##0.00");
		beforeMoneyField.setRequired(true);
		beforeMoneyField.setHidden(false);


		januaryRevenueField = new DataSourceFloatField("januaryRevenue", "1月");
		januaryRevenueField.setLength(18);
		januaryRevenueField.setDecimalPad(2);
		januaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		januaryRevenueField.setRequired(true);
		januaryRevenueField.setHidden(false);


		februaryRevenueField = new DataSourceFloatField("februaryRevenue", "2月");
		februaryRevenueField.setLength(18);
		februaryRevenueField.setDecimalPad(2);
		februaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		februaryRevenueField.setRequired(true);
		februaryRevenueField.setHidden(false);


		marchRevenueField = new DataSourceFloatField("marchRevenue", "3月");
		marchRevenueField.setLength(18);
		marchRevenueField.setDecimalPad(2);
		marchRevenueField.setFormat("#,###,###,###,###,##0.00");
		marchRevenueField.setRequired(true);
		marchRevenueField.setHidden(false);


		aprilRevenueField = new DataSourceFloatField("aprilRevenue", "4月");
		aprilRevenueField.setLength(18);
		aprilRevenueField.setDecimalPad(2);
		aprilRevenueField.setFormat("#,###,###,###,###,##0.00");
		aprilRevenueField.setRequired(true);
		aprilRevenueField.setHidden(false);


		mayRevenueField = new DataSourceFloatField("mayRevenue", "5月");
		mayRevenueField.setLength(18);
		mayRevenueField.setDecimalPad(2);
		mayRevenueField.setFormat("#,###,###,###,###,##0.00");
		mayRevenueField.setRequired(true);
		mayRevenueField.setHidden(false);


		juneRevenueField = new DataSourceFloatField("juneRevenue", "6月");
		juneRevenueField.setLength(18);
		juneRevenueField.setDecimalPad(2);
		juneRevenueField.setFormat("#,###,###,###,###,##0.00");
		juneRevenueField.setRequired(true);
		juneRevenueField.setHidden(false);


		julyRevenueField = new DataSourceFloatField("julyRevenue", "7月");
		julyRevenueField.setLength(18);
		julyRevenueField.setDecimalPad(2);
		julyRevenueField.setFormat("#,###,###,###,###,##0.00");
		julyRevenueField.setRequired(true);
		julyRevenueField.setHidden(false);


		augustRevenueField = new DataSourceFloatField("augustRevenue", "8月");
		augustRevenueField.setLength(18);
		augustRevenueField.setDecimalPad(2);
		augustRevenueField.setFormat("#,###,###,###,###,##0.00");
		augustRevenueField.setRequired(true);
		augustRevenueField.setHidden(false);


		septemberRevenueField = new DataSourceFloatField("septemberRevenue", "9月");
		septemberRevenueField.setLength(18);
		septemberRevenueField.setDecimalPad(2);
		septemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		septemberRevenueField.setRequired(true);
		septemberRevenueField.setHidden(false);


		octoberRevenueField = new DataSourceFloatField("octoberRevenue", "10月");
		octoberRevenueField.setLength(18);
		octoberRevenueField.setDecimalPad(2);
		octoberRevenueField.setFormat("#,###,###,###,###,##0.00");
		octoberRevenueField.setRequired(true);
		octoberRevenueField.setHidden(false);


		novemberRevenueField = new DataSourceFloatField("novemberRevenue", "11月");
		novemberRevenueField.setLength(18);
		novemberRevenueField.setDecimalPad(2);
		novemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		novemberRevenueField.setRequired(true);
		novemberRevenueField.setHidden(false);


		decemberRevenueField = new DataSourceFloatField("decemberRevenue", "12月");
		decemberRevenueField.setLength(18);
		decemberRevenueField.setDecimalPad(2);
		decemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		decemberRevenueField.setRequired(true);
		decemberRevenueField.setHidden(false);


		setFields(projectIdField, plateIdField, sheetCodeField, projectNameField, sheetAmountField, yearField, beforeMoneyField, januaryRevenueField, februaryRevenueField, marchRevenueField, aprilRevenueField, mayRevenueField, juneRevenueField, julyRevenueField, augustRevenueField, septemberRevenueField, octoberRevenueField, novemberRevenueField, decemberRevenueField);
	}


}

