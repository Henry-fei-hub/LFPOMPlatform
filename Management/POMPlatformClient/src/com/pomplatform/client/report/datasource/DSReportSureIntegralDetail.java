package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportSureIntegralDetail extends DBDataSource
{


	public static DSReportSureIntegralDetail instance = null;

	public static DSReportSureIntegralDetail getInstance() {
		if(instance == null) {
			instance = new DSReportSureIntegralDetail("DSReportSureIntegralDetail");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField projectIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField projectNameField;
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
	private final DataSourceFloatField plateJanuaryRevenueField;
	private final DataSourceFloatField plateFebruaryRevenueField;
	private final DataSourceFloatField plateMarchRevenueField;
	private final DataSourceFloatField plateAprilRevenueField;
	private final DataSourceFloatField plateMayRevenueField;
	private final DataSourceFloatField plateJuneRevenueField;
	private final DataSourceFloatField plateJulyRevenueField;
	private final DataSourceFloatField plateAugustRevenueField;
	private final DataSourceFloatField plateSeptemberRevenueField;
	private final DataSourceFloatField plateOctoberRevenueField;
	private final DataSourceFloatField plateNovemberRevenueField;
	private final DataSourceFloatField plateDecemberRevenueField;

	public DSReportSureIntegralDetail(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportSureIntegralDetail");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		projectIdField = new DataSourceTextField("projectId", "项目代码");
		projectIdField.setLength(11);
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


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(false);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(true);
		yearField.setHidden(false);


		januaryRevenueField = new DataSourceFloatField("januaryRevenue", "项目组");
		januaryRevenueField.setLength(18);
		januaryRevenueField.setDecimalPad(2);
		januaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		januaryRevenueField.setRequired(true);
		januaryRevenueField.setHidden(false);


		februaryRevenueField = new DataSourceFloatField("februaryRevenue", "项目组");
		februaryRevenueField.setLength(18);
		februaryRevenueField.setDecimalPad(2);
		februaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		februaryRevenueField.setRequired(true);
		februaryRevenueField.setHidden(false);


		marchRevenueField = new DataSourceFloatField("marchRevenue", "项目组");
		marchRevenueField.setLength(18);
		marchRevenueField.setDecimalPad(2);
		marchRevenueField.setFormat("#,###,###,###,###,##0.00");
		marchRevenueField.setRequired(true);
		marchRevenueField.setHidden(false);


		aprilRevenueField = new DataSourceFloatField("aprilRevenue", "项目组");
		aprilRevenueField.setLength(18);
		aprilRevenueField.setDecimalPad(2);
		aprilRevenueField.setFormat("#,###,###,###,###,##0.00");
		aprilRevenueField.setRequired(true);
		aprilRevenueField.setHidden(false);


		mayRevenueField = new DataSourceFloatField("mayRevenue", "项目组");
		mayRevenueField.setLength(18);
		mayRevenueField.setDecimalPad(2);
		mayRevenueField.setFormat("#,###,###,###,###,##0.00");
		mayRevenueField.setRequired(true);
		mayRevenueField.setHidden(false);


		juneRevenueField = new DataSourceFloatField("juneRevenue", "项目组");
		juneRevenueField.setLength(18);
		juneRevenueField.setDecimalPad(2);
		juneRevenueField.setFormat("#,###,###,###,###,##0.00");
		juneRevenueField.setRequired(true);
		juneRevenueField.setHidden(false);


		julyRevenueField = new DataSourceFloatField("julyRevenue", "项目组");
		julyRevenueField.setLength(18);
		julyRevenueField.setDecimalPad(2);
		julyRevenueField.setFormat("#,###,###,###,###,##0.00");
		julyRevenueField.setRequired(true);
		julyRevenueField.setHidden(false);


		augustRevenueField = new DataSourceFloatField("augustRevenue", "项目组");
		augustRevenueField.setLength(18);
		augustRevenueField.setDecimalPad(2);
		augustRevenueField.setFormat("#,###,###,###,###,##0.00");
		augustRevenueField.setRequired(true);
		augustRevenueField.setHidden(false);


		septemberRevenueField = new DataSourceFloatField("septemberRevenue", "项目组");
		septemberRevenueField.setLength(18);
		septemberRevenueField.setDecimalPad(2);
		septemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		septemberRevenueField.setRequired(true);
		septemberRevenueField.setHidden(false);


		octoberRevenueField = new DataSourceFloatField("octoberRevenue", "项目组");
		octoberRevenueField.setLength(18);
		octoberRevenueField.setDecimalPad(2);
		octoberRevenueField.setFormat("#,###,###,###,###,##0.00");
		octoberRevenueField.setRequired(true);
		octoberRevenueField.setHidden(false);


		novemberRevenueField = new DataSourceFloatField("novemberRevenue", "项目组");
		novemberRevenueField.setLength(18);
		novemberRevenueField.setDecimalPad(2);
		novemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		novemberRevenueField.setRequired(true);
		novemberRevenueField.setHidden(false);


		decemberRevenueField = new DataSourceFloatField("decemberRevenue", "项目组");
		decemberRevenueField.setLength(18);
		decemberRevenueField.setDecimalPad(2);
		decemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		decemberRevenueField.setRequired(true);
		decemberRevenueField.setHidden(false);


		plateJanuaryRevenueField = new DataSourceFloatField("plateJanuaryRevenue", "部门");
		plateJanuaryRevenueField.setLength(18);
		plateJanuaryRevenueField.setDecimalPad(2);
		plateJanuaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateJanuaryRevenueField.setRequired(true);
		plateJanuaryRevenueField.setHidden(false);


		plateFebruaryRevenueField = new DataSourceFloatField("plateFebruaryRevenue", "部门");
		plateFebruaryRevenueField.setLength(18);
		plateFebruaryRevenueField.setDecimalPad(2);
		plateFebruaryRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateFebruaryRevenueField.setRequired(true);
		plateFebruaryRevenueField.setHidden(false);


		plateMarchRevenueField = new DataSourceFloatField("plateMarchRevenue", "部门");
		plateMarchRevenueField.setLength(18);
		plateMarchRevenueField.setDecimalPad(2);
		plateMarchRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateMarchRevenueField.setRequired(true);
		plateMarchRevenueField.setHidden(false);


		plateAprilRevenueField = new DataSourceFloatField("plateAprilRevenue", "部门");
		plateAprilRevenueField.setLength(18);
		plateAprilRevenueField.setDecimalPad(2);
		plateAprilRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateAprilRevenueField.setRequired(true);
		plateAprilRevenueField.setHidden(false);


		plateMayRevenueField = new DataSourceFloatField("plateMayRevenue", "部门");
		plateMayRevenueField.setLength(18);
		plateMayRevenueField.setDecimalPad(2);
		plateMayRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateMayRevenueField.setRequired(true);
		plateMayRevenueField.setHidden(false);


		plateJuneRevenueField = new DataSourceFloatField("plateJuneRevenue", "部门");
		plateJuneRevenueField.setLength(18);
		plateJuneRevenueField.setDecimalPad(2);
		plateJuneRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateJuneRevenueField.setRequired(true);
		plateJuneRevenueField.setHidden(false);


		plateJulyRevenueField = new DataSourceFloatField("plateJulyRevenue", "部门");
		plateJulyRevenueField.setLength(18);
		plateJulyRevenueField.setDecimalPad(2);
		plateJulyRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateJulyRevenueField.setRequired(true);
		plateJulyRevenueField.setHidden(false);


		plateAugustRevenueField = new DataSourceFloatField("plateAugustRevenue", "部门");
		plateAugustRevenueField.setLength(18);
		plateAugustRevenueField.setDecimalPad(2);
		plateAugustRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateAugustRevenueField.setRequired(true);
		plateAugustRevenueField.setHidden(false);


		plateSeptemberRevenueField = new DataSourceFloatField("plateSeptemberRevenue", "部门");
		plateSeptemberRevenueField.setLength(18);
		plateSeptemberRevenueField.setDecimalPad(2);
		plateSeptemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateSeptemberRevenueField.setRequired(true);
		plateSeptemberRevenueField.setHidden(false);


		plateOctoberRevenueField = new DataSourceFloatField("plateOctoberRevenue", "部门");
		plateOctoberRevenueField.setLength(18);
		plateOctoberRevenueField.setDecimalPad(2);
		plateOctoberRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateOctoberRevenueField.setRequired(true);
		plateOctoberRevenueField.setHidden(false);


		plateNovemberRevenueField = new DataSourceFloatField("plateNovemberRevenue", "部门");
		plateNovemberRevenueField.setLength(18);
		plateNovemberRevenueField.setDecimalPad(2);
		plateNovemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateNovemberRevenueField.setRequired(true);
		plateNovemberRevenueField.setHidden(false);


		plateDecemberRevenueField = new DataSourceFloatField("plateDecemberRevenue", "部门");
		plateDecemberRevenueField.setLength(18);
		plateDecemberRevenueField.setDecimalPad(2);
		plateDecemberRevenueField.setFormat("#,###,###,###,###,##0.00");
		plateDecemberRevenueField.setRequired(true);
		plateDecemberRevenueField.setHidden(false);


		setFields(plateIdField, projectIdField, sheetCodeField, projectNameField, sheetAmountField, yearField, januaryRevenueField, februaryRevenueField, marchRevenueField, aprilRevenueField, mayRevenueField, juneRevenueField, julyRevenueField, augustRevenueField, septemberRevenueField, octoberRevenueField, novemberRevenueField, decemberRevenueField, plateJanuaryRevenueField, plateFebruaryRevenueField, plateMarchRevenueField, plateAprilRevenueField, plateMayRevenueField, plateJuneRevenueField, plateJulyRevenueField, plateAugustRevenueField, plateSeptemberRevenueField, plateOctoberRevenueField, plateNovemberRevenueField, plateDecemberRevenueField);
	}


}

