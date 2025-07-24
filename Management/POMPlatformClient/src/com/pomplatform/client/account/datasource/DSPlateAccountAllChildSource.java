package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSPlateAccountAllChildSource extends DBDataSource {

	public static DSPlateAccountAllChildSource instance = null;

	public static DSPlateAccountAllChildSource getInstance() {
		if (instance == null) {
			instance = new DSPlateAccountAllChildSource("DSPlateAccountAllChildSource");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField projectSettlementField;
	private final DataSourceFloatField companySubsidyField;
	private final DataSourceFloatField employeeAchieveIntegralReturnField;
	private final DataSourceFloatField salaryReturnField;
	private final DataSourceFloatField violationChargesField;
	private final DataSourceFloatField collaborativeAchieveField;
	private final DataSourceFloatField companyAdvanceField;
	private final DataSourceFloatField attendanceDeductField;
	private final DataSourceFloatField projectPerformanceField;
	
	private final DataSourceFloatField salaryAdvanceField;
	private final DataSourceFloatField managerProjectIntegralField;
	private final DataSourceFloatField plateCostField;
	private final DataSourceFloatField projectAdvanceField;
	private final DataSourceFloatField companyFeeField;
	private final DataSourceFloatField collaborativePayField;
	private final DataSourceFloatField companyRefundField;
	private final DataSourceFloatField performanceBonusField;
	private final DataSourceFloatField developProjectField;
	private final DataSourceFloatField manageProjectField;
	private final DataSourceFloatField contractChangeField;
	private final DataSourceFloatField endProjectField;
	private final DataSourceFloatField saleIntegralField;
	private final DataSourceFloatField sendAchieveField;
	private final DataSourceFloatField sendPayField;
	private final DataSourceFloatField employeeCostField;
	private final DataSourceFloatField contractDistributionIncomeField;
	private final DataSourceFloatField contractDistributionExpenditureField;
	private final DataSourceFloatField projectPerformancePayField;
	private final DataSourceFloatField depDeployField;
	private final DataSourceFloatField outputAccountField;

	public DSPlateAccountAllChildSource(String dataSourceID) {

		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AccountManageProcess");
		
		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		leftIntegralField = new DataSourceFloatField("leftIntegral", "实时余额");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setEmptyDisplayValue("0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);
		
		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "积分余额");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setEmptyDisplayValue("0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);

		projectSettlementField = new DataSourceFloatField("projectSettlement", "项目结算");
		projectSettlementField.setLength(18);
		projectSettlementField.setDecimalPad(2);
		projectSettlementField.setFormat("#,###,###,###,###,##0.00");
		projectSettlementField.setEmptyDisplayValue("0.00");
		projectSettlementField.setRequired(false);
		projectSettlementField.setHidden(false);

		companySubsidyField = new DataSourceFloatField("companySubsidy", "公司补贴");
		companySubsidyField.setLength(18);
		companySubsidyField.setDecimalPad(2);
		companySubsidyField.setFormat("#,###,###,###,###,##0.00");
		companySubsidyField.setEmptyDisplayValue("0.00");
		companySubsidyField.setRequired(false);
		companySubsidyField.setHidden(false);

		employeeAchieveIntegralReturnField = new DataSourceFloatField("employeeAchieveIntegralReturn", "积分回收");
		employeeAchieveIntegralReturnField.setLength(18);
		employeeAchieveIntegralReturnField.setDecimalPad(2);
		employeeAchieveIntegralReturnField.setFormat("#,###,###,###,###,##0.00");
		employeeAchieveIntegralReturnField.setEmptyDisplayValue("0.00");
		employeeAchieveIntegralReturnField.setRequired(false);
		employeeAchieveIntegralReturnField.setHidden(false);

		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分还款");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setEmptyDisplayValue("0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);
		
		violationChargesField = new DataSourceFloatField("violationCharges", "资源绩效");
		violationChargesField.setLength(18);
		violationChargesField.setDecimalPad(2);
		violationChargesField.setFormat("#,###,###,###,###,##0.00");
		violationChargesField.setEmptyDisplayValue("0.00");
		violationChargesField.setRequired(false);
		violationChargesField.setHidden(false);

		collaborativeAchieveField = new DataSourceFloatField("collaborativeAchieve", "协作收入");
		collaborativeAchieveField.setLength(18);
		collaborativeAchieveField.setDecimalPad(2);
		collaborativeAchieveField.setFormat("#,###,###,###,###,##0.00");
		collaborativeAchieveField.setEmptyDisplayValue("0.00");
		collaborativeAchieveField.setRequired(false);
		collaborativeAchieveField.setHidden(false);
		
		companyAdvanceField = new DataSourceFloatField("companyAdvance", "公司借款");
		companyAdvanceField.setLength(18);
		companyAdvanceField.setDecimalPad(2);
		companyAdvanceField.setFormat("#,###,###,###,###,##0.00");
		companyAdvanceField.setEmptyDisplayValue("0.00");
		companyAdvanceField.setRequired(false);
		companyAdvanceField.setHidden(false);
		
		attendanceDeductField = new DataSourceFloatField("attendanceDeduct", "考勤扣款");
		attendanceDeductField.setLength(18);
		attendanceDeductField.setDecimalPad(2);
		attendanceDeductField.setFormat("#,###,###,###,###,##0.00");
		attendanceDeductField.setEmptyDisplayValue("0.00");
		attendanceDeductField.setRequired(false);
		attendanceDeductField.setHidden(false);
		
		

		salaryAdvanceField = new DataSourceFloatField("salaryAdvance", "积分借款");
		salaryAdvanceField.setLength(18);
		salaryAdvanceField.setDecimalPad(2);
		salaryAdvanceField.setFormat("#,###,###,###,###,##0.00");
		salaryAdvanceField.setEmptyDisplayValue("0.00");
		salaryAdvanceField.setRequired(false);
		salaryAdvanceField.setHidden(false);

		managerProjectIntegralField = new DataSourceFloatField("managerProjectIntegral", "奖金补贴");
		managerProjectIntegralField.setLength(18);
		managerProjectIntegralField.setDecimalPad(2);
		managerProjectIntegralField.setFormat("#,###,###,###,###,##0.00");
		managerProjectIntegralField.setEmptyDisplayValue("0.00");
		managerProjectIntegralField.setRequired(false);
		managerProjectIntegralField.setHidden(false);

		plateCostField = new DataSourceFloatField("plateCost", "运营成本");
		plateCostField.setLength(18);
		plateCostField.setDecimalPad(2);
		plateCostField.setFormat("#,###,###,###,###,##0.00");
		plateCostField.setEmptyDisplayValue("0.00");
		plateCostField.setRequired(false);
		plateCostField.setHidden(false);
		
		projectAdvanceField = new DataSourceFloatField("projectAdvance", "项目补贴");
		projectAdvanceField.setLength(18);
		projectAdvanceField.setDecimalPad(2);
		projectAdvanceField.setFormat("#,###,###,###,###,##0.00");
		projectAdvanceField.setEmptyDisplayValue("0.00");
		projectAdvanceField.setRequired(false);
		projectAdvanceField.setHidden(false);
		
		companyFeeField = new DataSourceFloatField("companyFee", "公司费用");
		companyFeeField.setLength(18);
		companyFeeField.setDecimalPad(2);
		companyFeeField.setFormat("#,###,###,###,###,##0.00");
		companyFeeField.setEmptyDisplayValue("0.00");
		companyFeeField.setRequired(false);
		companyFeeField.setHidden(false);
		
		collaborativePayField = new DataSourceFloatField("collaborativePay", "协作支出");
		collaborativePayField.setLength(18);
		collaborativePayField.setDecimalPad(2);
		collaborativePayField.setFormat("#,###,###,###,###,##0.00");
		collaborativePayField.setEmptyDisplayValue("0.00");
		collaborativePayField.setRequired(false);
		collaborativePayField.setHidden(false);
		
		companyRefundField = new DataSourceFloatField("companyRefund", "公司还款");
		companyRefundField.setLength(18);
		companyRefundField.setDecimalPad(2);
		companyRefundField.setFormat("#,###,###,###,###,##0.00");
		companyRefundField.setEmptyDisplayValue("0.00");
		companyRefundField.setRequired(false);
		companyRefundField.setHidden(false);
		
		performanceBonusField = new DataSourceFloatField("performanceBonus", "绩效奖金");
		performanceBonusField.setLength(18);
		performanceBonusField.setDecimalPad(2);
		performanceBonusField.setFormat("#,###,###,###,###,##0.00");
		performanceBonusField.setEmptyDisplayValue("0.00");
		performanceBonusField.setRequired(false);
		performanceBonusField.setHidden(false);
		
		developProjectField = new DataSourceFloatField("developProject", "研发项目");
		developProjectField.setLength(18);
		developProjectField.setDecimalPad(2);
		developProjectField.setFormat("#,###,###,###,###,##0.00");
		developProjectField.setEmptyDisplayValue("0.00");
		developProjectField.setRequired(false);
		developProjectField.setHidden(false);
		
		manageProjectField = new DataSourceFloatField("manageProject", "管理项目");
		manageProjectField.setLength(18);
		manageProjectField.setDecimalPad(2);
		manageProjectField.setFormat("#,###,###,###,###,##0.00");
		manageProjectField.setEmptyDisplayValue("0.00");
		manageProjectField.setRequired(false);
		manageProjectField.setHidden(false);
		
		contractChangeField = new DataSourceFloatField("contractChange", "合同变更");
		contractChangeField.setLength(18);
		contractChangeField.setDecimalPad(2);
		contractChangeField.setFormat("#,###,###,###,###,##0.00");
		contractChangeField.setEmptyDisplayValue("0.00");
		contractChangeField.setRequired(false);
		contractChangeField.setHidden(false);
		
		endProjectField = new DataSourceFloatField("endProject", "项目结项");
		endProjectField.setLength(18);
		endProjectField.setDecimalPad(2);
		endProjectField.setFormat("#,###,###,###,###,##0.00");
		endProjectField.setEmptyDisplayValue("0.00");
		endProjectField.setRequired(false);
		endProjectField.setHidden(false);

		saleIntegralField = new DataSourceFloatField("saleIntegral", "销售积分");
		saleIntegralField.setLength(18);
		saleIntegralField.setDecimalPad(2);
		saleIntegralField.setFormat("#,###,###,###,###,##0.00");
		saleIntegralField.setEmptyDisplayValue("0.00");
		saleIntegralField.setRequired(false);
		saleIntegralField.setHidden(false);
		
		sendAchieveField = new DataSourceFloatField("sendAchieve", "分配收入");
		sendAchieveField.setLength(18);
		sendAchieveField.setDecimalPad(2);
		sendAchieveField.setFormat("#,###,###,###,###,##0.00");
		sendAchieveField.setEmptyDisplayValue("0.00");
		sendAchieveField.setRequired(false);
		sendAchieveField.setHidden(false);
		
		sendPayField = new DataSourceFloatField("sendPay", "分配支出");
		sendPayField.setLength(18);
		sendPayField.setDecimalPad(2);
		sendPayField.setFormat("#,###,###,###,###,##0.00");
		sendPayField.setEmptyDisplayValue("0.00");
		sendPayField.setRequired(false);
		sendPayField.setHidden(false);
		
		employeeCostField = new DataSourceFloatField("employeeCost", "人工成本");
		employeeCostField.setLength(18);
		employeeCostField.setDecimalPad(2);
		employeeCostField.setFormat("#,###,###,###,###,##0.00");
		employeeCostField.setEmptyDisplayValue("0.00");
		employeeCostField.setRequired(false);
		employeeCostField.setHidden(false);
		
		
		contractDistributionIncomeField = new DataSourceFloatField("contractDistributionIncome", "提成收入");
		contractDistributionIncomeField.setLength(18);
		contractDistributionIncomeField.setDecimalPad(2);
		contractDistributionIncomeField.setFormat("#,###,###,###,###,##0.00");
		contractDistributionIncomeField.setEmptyDisplayValue("0.00");
		contractDistributionIncomeField.setRequired(false);
		contractDistributionIncomeField.setHidden(false);
		
		
		contractDistributionExpenditureField = new DataSourceFloatField("contractDistributionExpenditure", "提成支出");
		contractDistributionExpenditureField.setLength(18);
		contractDistributionExpenditureField.setDecimalPad(2);
		contractDistributionExpenditureField.setFormat("#,###,###,###,###,##0.00");
		contractDistributionExpenditureField.setEmptyDisplayValue("0.00");
		contractDistributionExpenditureField.setRequired(false);
		contractDistributionExpenditureField.setHidden(false);
		

		
		projectPerformanceField = new DataSourceFloatField("projectPerformance", "项目绩效收入");
		projectPerformanceField.setLength(18);
		projectPerformanceField.setDecimalPad(2);
		projectPerformanceField.setFormat("#,###,###,###,###,##0.00");
		projectPerformanceField.setEmptyDisplayValue("0.00");
		projectPerformanceField.setRequired(false);
		projectPerformanceField.setHidden(false);
		
		
		projectPerformancePayField = new DataSourceFloatField("projectPerformancePay", "项目绩效支出");
		projectPerformancePayField.setLength(18);
		projectPerformancePayField.setDecimalPad(2);
		projectPerformancePayField.setFormat("#,###,###,###,###,##0.00");
		projectPerformancePayField.setEmptyDisplayValue("0.00");
		projectPerformancePayField.setRequired(false);
		projectPerformancePayField.setHidden(false);

		depDeployField = new DataSourceFloatField("depDeploy", "部门调配");
		depDeployField.setLength(18);
		depDeployField.setDecimalPad(2);
		depDeployField.setFormat("#,###,###,###,###,##0.00");
		depDeployField.setEmptyDisplayValue("0.00");
		depDeployField.setRequired(false);
		depDeployField.setHidden(false);

		outputAccountField = new DataSourceFloatField("outputAccount", "产值结算");
		outputAccountField.setLength(18);
		outputAccountField.setDecimalPad(2);
		outputAccountField.setFormat("#,###,###,###,###,##0.00");
		outputAccountField.setEmptyDisplayValue("0.00");
		outputAccountField.setRequired(false);
		outputAccountField.setHidden(false);
		
		setFields(plateIdField,leftIntegralField,achieveIntegralField, projectSettlementField, companySubsidyField,
				employeeAchieveIntegralReturnField, salaryReturnField, violationChargesField,collaborativeAchieveField,companyAdvanceField,attendanceDeductField, salaryAdvanceField, managerProjectIntegralField,
				plateCostField, projectAdvanceField, companyFeeField,collaborativePayField,companyRefundField,performanceBonusField
				,developProjectField,manageProjectField,contractChangeField, endProjectField
				,saleIntegralField,sendAchieveField,sendPayField,employeeCostField,contractDistributionIncomeField,contractDistributionExpenditureField,projectPerformanceField,projectPerformancePayField,depDeployField,outputAccountField);
	}

}
