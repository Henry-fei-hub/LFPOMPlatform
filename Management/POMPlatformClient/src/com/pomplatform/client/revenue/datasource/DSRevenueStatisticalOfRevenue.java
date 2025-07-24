package com.pomplatform.client.revenue.datasource;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSRevenueStatisticalOfRevenue extends DBDataSource
{


	public static DSRevenueStatisticalOfRevenue instance = null;

	public static DSRevenueStatisticalOfRevenue getInstance() {
		if(instance == null) {
			instance = new DSRevenueStatisticalOfRevenue("DSRevenueStatisticalOfRevenue");
		}
		return instance;
	}

	private final DataSourceIntegerField projectIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceTextField sheetCodeField;
	private final DataSourceTextField sheetNameField;
	private final DataSourceTextField contractCodeField;
	
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceFloatField contractAmountField;
	
	private final DataSourceFloatField ratePercentField;
	private final DataSourceTextField ratePercentStrField;
	private final DataSourceFloatField sheetPercentField;
	private final DataSourceTextField sheetPercentStrField;
	private final DataSourceFloatField modifyPercentField;
	private final DataSourceTextField modifyPercentStrField;
	private final DataSourceFloatField totalPercentField;
	private final DataSourceTextField totalPercentStrField;

	private final DataSourceFloatField totalTaxRevenueField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceFloatField currentRevenueField;
	private final DataSourceFloatField lastMonthRevenueField;
	
	private final DataSourceIntegerField plateManagerIdField;
	private final DataSourceIntegerField departmentManagerIdField;
	private final DataSourceIntegerField projectManageIdField;
	private final DataSourceIntegerField revenueStatisticalRecordIdField;
	private final DataSourceTextField totalSurePercentStrField;
	private final DataSourceFloatField totalSureRevenueField;
	private final DataSourceIntegerField flagField;
	
	private final DataSourceFloatField contractSaveField;
	private final DataSourceFloatField contractSaveActiveField;
	private final DataSourceFloatField contractSaveActiveUnField;
	private final DataSourceFloatField contractSaveActivePauseField;
	private final DataSourceFloatField contractSaveActiveNeverField;
	private final DataSourceFloatField contractSaveOtherField;
	private final DataSourceFloatField projectIntegralField;

	public DSRevenueStatisticalOfRevenue(String dataSourceID) {

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


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(true);
//		contractCodeField.setValueMap(KeyValueManager.getValueMap("contracts"));
		KeyValueManager.loadValueMap("contracts",contractCodeField);
		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		
		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "项目总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(true);


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(true);
		sheetAmountField.setHidden(false);


		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setLength(18);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setLength(11);
		contractAmountField.setRequired(true);
		contractAmountField.setHidden(true);


		ratePercentField = new DataSourceFloatField("ratePercent", "税率");
		ratePercentField.setLength(18);
		ratePercentField.setDecimalPad(4);
		ratePercentField.setFormat("##,###,###,###,##0.0000");
		ratePercentField.setRequired(false);
		ratePercentField.setHidden(true);
		
		ratePercentStrField = new DataSourceTextField("ratePercentStr", "税率");
		ratePercentStrField.setLength(18);
		ratePercentStrField.setRequired(true);
		ratePercentStrField.setHidden(false);
		
		sheetPercentField = new DataSourceFloatField("sheetPercent", "订单生成百分比");
		sheetPercentField.setLength(18);
		sheetPercentField.setDecimalPad(4);
		sheetPercentField.setFormat("##,###,###,###,##0.0000");
		sheetPercentField.setRequired(false);
		sheetPercentField.setHidden(true);


		sheetPercentStrField = new DataSourceTextField("sheetPercentStr", "订单生成百分比");
		sheetPercentStrField.setLength(18);
		sheetPercentStrField.setRequired(true);
		sheetPercentStrField.setHidden(false);


		modifyPercentField = new DataSourceFloatField("modifyPercent", "运营调节百分比");
		modifyPercentField.setLength(18);
		modifyPercentField.setDecimalPad(4);
		modifyPercentField.setFormat("##,###,###,###,##0.0000");
		modifyPercentField.setRequired(false);
		modifyPercentField.setHidden(true);


		modifyPercentStrField = new DataSourceTextField("modifyPercentStr", "运营调节百分比");
		modifyPercentStrField.setLength(18);
		modifyPercentStrField.setRequired(true);
		modifyPercentStrField.setHidden(false);


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
		
		lastMonthRevenueField = new DataSourceFloatField("lastMonthRevenue", "上月累计营收");
		lastMonthRevenueField.setLength(18);
		lastMonthRevenueField.setDecimalPad(2);
		lastMonthRevenueField.setFormat("#,###,###,###,###,##0.00");
		lastMonthRevenueField.setRequired(false);
		lastMonthRevenueField.setHidden(true);



		plateManagerIdField = new DataSourceIntegerField("plateManagerId", "事业部负责人");
		plateManagerIdField.setLength(11);
		plateManagerIdField.setRequired(false);
		plateManagerIdField.setHidden(true);


		departmentManagerIdField = new DataSourceIntegerField("departmentManagerId", "部门经理");
		departmentManagerIdField.setLength(11);
		departmentManagerIdField.setRequired(false);
		departmentManagerIdField.setHidden(true);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "专业负责人");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		
		revenueStatisticalRecordIdField = new DataSourceIntegerField("revenueStatisticalRecordId", "统计营收主键");
		revenueStatisticalRecordIdField.setLength(11);
		revenueStatisticalRecordIdField.setRequired(false);
		revenueStatisticalRecordIdField.setHidden(true);
		
		totalSurePercentStrField = new DataSourceTextField("totalSurePercentStr", "累计确认百分比");
		totalSurePercentStrField.setLength(18);
		totalSurePercentStrField.setRequired(true);
		totalSurePercentStrField.setHidden(false);
		
		totalSureRevenueField = new DataSourceFloatField("totalSureRevenue", "累计确认营收");
		totalSureRevenueField.setLength(18);
		totalSureRevenueField.setDecimalPad(2);
		totalSureRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalSureRevenueField.setRequired(false);
		
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"已保存");
		map.put(2,"未保存");
		flagField = new DataSourceIntegerField("flag", "是否保存");
		flagField.setLength(11);
		flagField.setRequired(false);
		flagField.setHidden(false);
		flagField.setValueMap(map);

		contractSaveField = new DataSourceFloatField("contractSave","合同存量");
		contractSaveField.setLength(18);
		contractSaveField.setDecimalPad(2);
		contractSaveField.setFormat("#,###,###,###,###,##0.00");
		contractSaveField.setRequired(false);
		
		projectIntegralField = new DataSourceFloatField("projectIntegral","项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(true);
		
		
		contractSaveActiveField = new DataSourceFloatField("contractSaveActive","活跃合同存量");
		contractSaveActiveField.setLength(18);
		contractSaveActiveField.setDecimalPad(2);
		contractSaveActiveField.setFormat("#,###,###,###,###,##0.00");
		contractSaveActiveField.setRequired(false);
		
		contractSaveActiveUnField = new DataSourceFloatField("contractSaveActiveUn","非活跃合同存量");
		contractSaveActiveUnField.setLength(18);
		contractSaveActiveUnField.setDecimalPad(2);
		contractSaveActiveUnField.setFormat("#,###,###,###,###,##0.00");
		contractSaveActiveUnField.setRequired(false);
		
		contractSaveActivePauseField = new DataSourceFloatField("contractSaveActivePause","暂停合同存量");
		contractSaveActivePauseField.setLength(18);
		contractSaveActivePauseField.setDecimalPad(2);
		contractSaveActivePauseField.setFormat("#,###,###,###,###,##0.00");
		contractSaveActivePauseField.setRequired(false);
		
		contractSaveActiveNeverField = new DataSourceFloatField("contractSaveActiveNever","项目未启动合同存量");
		contractSaveActiveNeverField.setLength(18);
		contractSaveActiveNeverField.setDecimalPad(2);
		contractSaveActiveNeverField.setFormat("#,###,###,###,###,##0.00");
		contractSaveActiveNeverField.setRequired(false);
		
		contractSaveOtherField = new DataSourceFloatField("contractSaveOther","其他合同存量");
		contractSaveOtherField.setLength(18);
		contractSaveOtherField.setDecimalPad(2);
		contractSaveOtherField.setFormat("#,###,###,###,###,##0.00");
		contractSaveOtherField.setRequired(false);

		setFields(projectIdField, plateIdField, sheetCodeField, sheetNameField, contractCodeField,yearField,monthField, totalIntegralField, sheetAmountField, contractAmountField,ratePercentField, ratePercentStrField,sheetPercentField, sheetPercentStrField, modifyPercentField, modifyPercentStrField, totalPercentField, totalPercentStrField, totalTaxRevenueField, totalRevenueField, currentRevenueField,lastMonthRevenueField, plateManagerIdField, departmentManagerIdField, projectManageIdField,revenueStatisticalRecordIdField,totalSurePercentStrField,totalSureRevenueField,contractSaveField,contractSaveActiveField,contractSaveActiveUnField,contractSaveActivePauseField,contractSaveActiveNeverField,contractSaveOtherField,flagField,projectIntegralField);
	}


}

