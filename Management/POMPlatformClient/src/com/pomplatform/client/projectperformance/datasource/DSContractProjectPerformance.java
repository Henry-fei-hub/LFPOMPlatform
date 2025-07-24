package com.pomplatform.client.projectperformance.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSContractProjectPerformance extends DBDataSource
{


	public static DSContractProjectPerformance instance = null;

	public static DSContractProjectPerformance getInstance() {
		if(instance == null) {
			instance = new DSContractProjectPerformance("DSContractProjectPerformance");
		}
		return instance;
	}

	private final DataSourceIntegerField contractIdField;
	private final DataSourceTextField contractCodeField;
	private final DataSourceTextField contractNameField;
	private final DataSourceFloatField contractAmountField;
	private final DataSourceIntegerField projectLevelField;
	private final DataSourceFloatField sheetAmountField;
	private final DataSourceFloatField totalIntegralField;
	private final DataSourceFloatField projectIntegralField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField totalRevenueField;
	private final DataSourceFloatField gainMoneyField;
	private final DataSourceFloatField leftMoneyField;
	private final DataSourceTextField finishPercentField;
	private final DataSourceFloatField projectManageIntegralField;
	private final DataSourceFloatField projectManageSureIntegralField;
	private final DataSourceFloatField deductIntegralField;
	private final DataSourceFloatField awardIntegralField;
	private final DataSourceFloatField sheetPerformanceAchieveField;
	private final DataSourceFloatField sheetPerformancePayField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceIntegerField projectManageIdField;

	public DSContractProjectPerformance(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ContractProjectPerformance");


		contractIdField = new DataSourceIntegerField("contractId", "合同编码");
		contractIdField.setLength(11);
		contractIdField.setRequired(false);
		contractIdField.setHidden(true);
		contractIdField.setRootValue("root");
		contractIdField.setForeignKey("DSContractProjectPerformance.contractId");


		contractCodeField = new DataSourceTextField("contractCode", "合同编号");
		contractCodeField.setLength(64);
		contractCodeField.setRequired(false);
		contractCodeField.setHidden(false);


		contractNameField = new DataSourceTextField("contractName", "合同名称");
		contractNameField.setLength(512);
		contractNameField.setRequired(false);
		contractNameField.setHidden(false);


		contractAmountField = new DataSourceFloatField("contractAmount", "合同金额");
		contractAmountField.setLength(16);
		contractAmountField.setDecimalPad(2);
		contractAmountField.setFormat("##,###,###,###,##0.00");
		contractAmountField.setRequired(true);
		contractAmountField.setHidden(false);


		projectLevelField = new DataSourceIntegerField("projectLevel", "项目等级");
		projectLevelField.setLength(11);
		projectLevelField.setRequired(false);
		projectLevelField.setHidden(false);
		projectLevelField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));


		sheetAmountField = new DataSourceFloatField("sheetAmount", "订单合同金额");
		sheetAmountField.setLength(18);
		sheetAmountField.setDecimalPad(2);
		sheetAmountField.setFormat("#,###,###,###,###,##0.00");
		sheetAmountField.setRequired(false);
		sheetAmountField.setHidden(true);


		totalIntegralField = new DataSourceFloatField("totalIntegral", "订单总积分");
		totalIntegralField.setLength(18);
		totalIntegralField.setDecimalPad(2);
		totalIntegralField.setFormat("#,###,###,###,###,##0.00");
		totalIntegralField.setRequired(false);
		totalIntegralField.setHidden(true);


		projectIntegralField = new DataSourceFloatField("projectIntegral", "项目积分");
		projectIntegralField.setLength(18);
		projectIntegralField.setDecimalPad(2);
		projectIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectIntegralField.setRequired(false);
		projectIntegralField.setHidden(true);


		projectCostField = new DataSourceFloatField("projectCost", "项目成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(true);
		projectCostField.setHidden(true);


		totalRevenueField = new DataSourceFloatField("totalRevenue", "累计营收");
		totalRevenueField.setLength(18);
		totalRevenueField.setDecimalPad(2);
		totalRevenueField.setFormat("#,###,###,###,###,##0.00");
		totalRevenueField.setRequired(true);
		totalRevenueField.setHidden(false);


		gainMoneyField = new DataSourceFloatField("gainMoney", "已收款金额");
		gainMoneyField.setLength(18);
		gainMoneyField.setDecimalPad(2);
		gainMoneyField.setFormat("#,###,###,###,###,##0.00");
		gainMoneyField.setRequired(true);
		gainMoneyField.setHidden(true);


		leftMoneyField = new DataSourceFloatField("leftMoney", "剩余收款金额");
		leftMoneyField.setLength(18);
		leftMoneyField.setDecimalPad(2);
		leftMoneyField.setFormat("#,###,###,###,###,##0.00");
		leftMoneyField.setRequired(true);
		leftMoneyField.setHidden(true);


		finishPercentField = new DataSourceTextField("finishPercent", "项目完工比");
		finishPercentField.setLength(-1);
		finishPercentField.setRequired(true);
		finishPercentField.setHidden(false);


		projectManageIntegralField = new DataSourceFloatField("projectManageIntegral", "项目管理费");
		projectManageIntegralField.setLength(18);
		projectManageIntegralField.setDecimalPad(2);
		projectManageIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectManageIntegralField.setRequired(true);
		projectManageIntegralField.setHidden(false);
		
		
		projectManageSureIntegralField = new DataSourceFloatField("projectManageSureIntegral", "项目管理费确认积分");
		projectManageSureIntegralField.setLength(18);
		projectManageSureIntegralField.setDecimalPad(2);
		projectManageSureIntegralField.setFormat("#,###,###,###,###,##0.00");
		projectManageSureIntegralField.setRequired(true);
		projectManageSureIntegralField.setHidden(false);


		deductIntegralField = new DataSourceFloatField("deductIntegral", "已扣积分");
		deductIntegralField.setLength(18);
		deductIntegralField.setDecimalPad(2);
		deductIntegralField.setEmptyDisplayValue("0.00");
		deductIntegralField.setFormat("#,###,###,###,###,##0.00");
		deductIntegralField.setRequired(true);
		deductIntegralField.setHidden(false);


		awardIntegralField = new DataSourceFloatField("awardIntegral", "已奖积分");
		awardIntegralField.setLength(18);
		awardIntegralField.setDecimalPad(2);
		awardIntegralField.setEmptyDisplayValue("0.00");
		awardIntegralField.setFormat("#,###,###,###,###,##0.00");
		awardIntegralField.setRequired(true);
		awardIntegralField.setHidden(false);
		
		sheetPerformanceAchieveField = new DataSourceFloatField("sheetPerformanceAchieve", "订单绩效收入");
		sheetPerformanceAchieveField.setLength(18);
		sheetPerformanceAchieveField.setDecimalPad(2);
		sheetPerformanceAchieveField.setEmptyDisplayValue("0.00");
		sheetPerformanceAchieveField.setFormat("#,###,###,###,###,##0.00");
		sheetPerformanceAchieveField.setRequired(true);
		sheetPerformanceAchieveField.setHidden(false);
		
		sheetPerformancePayField = new DataSourceFloatField("sheetPerformancePay", "订单绩效支出");
		sheetPerformancePayField.setLength(18);
		sheetPerformancePayField.setDecimalPad(2);
		sheetPerformancePayField.setEmptyDisplayValue("0.00");
		sheetPerformancePayField.setFormat("#,###,###,###,###,##0.00");
		sheetPerformancePayField.setRequired(true);
		sheetPerformancePayField.setHidden(false);
		
		
		leftIntegralField = new DataSourceFloatField("leftIntegral", "订单绩效剩余积分");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(true);
		leftIntegralField.setHidden(false);


		projectManageIdField = new DataSourceIntegerField("projectManageId", "项目经理");
		projectManageIdField.setLength(11);
		projectManageIdField.setRequired(false);
		projectManageIdField.setHidden(false);
//		projectManageIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		KeyValueManager.loadValueMap("employees",projectManageIdField);

		setFields(contractIdField, contractCodeField, contractNameField, contractAmountField, projectLevelField, sheetAmountField, totalIntegralField, projectIntegralField
		, projectCostField, totalRevenueField, gainMoneyField, leftMoneyField, finishPercentField, projectManageIntegralField, deductIntegralField, awardIntegralField
		,sheetPerformanceAchieveField,sheetPerformancePayField,leftIntegralField, projectManageIdField);
	}


}

