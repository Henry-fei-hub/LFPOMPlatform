package com.pomplatform.client.account.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSEmployeeAccountAll extends DBDataSource {

	public static DSEmployeeAccountAll instance = null;

	public static DSEmployeeAccountAll getInstance() {
		if (instance == null) {
			instance = new DSEmployeeAccountAll("DSEmployeeReportRecordDetail");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceFloatField leftIntegralField;
	private final DataSourceFloatField achieveIntegralField;
	private final DataSourceFloatField sureIntegralField;
	private final DataSourceFloatField managerProjectIntegralField;
	private final DataSourceFloatField salaryAdvanceField;
	private final DataSourceFloatField salaryReturnField;
	private final DataSourceFloatField salaryField;
	private final DataSourceFloatField projectCostField;
	private final DataSourceFloatField projectAdvanceField;
	private final DataSourceIntegerField statusField;
	private final DataSourceFloatField bonusPaymentField;
	private final DataSourceFloatField integralReturnField;
	private final DataSourceFloatField violationChargesField;
	private final DataSourceFloatField benefitsField;
	private final DataSourceFloatField benefitsYearField;
	private final DataSourceTextField gradeIdField;
	private final DataSourceFloatField performanceBonusField;
	private final DataSourceFloatField attendanceDeductField;
	private final DataSourceFloatField pmPerformanceAwardField;
	private final DataSourceFloatField pmPerformanceDeductField;
	private final DataSourceFloatField projectPerformanceField;
	private final DataSourceFloatField contractChangeField;
	private final DataSourceFloatField plateChangeAchieveField;
	private final DataSourceFloatField plateChangePayField;
	private final DataSourceFloatField projectPerformancePayField;
	private final DataSourceFloatField contractDistributionIncomeField;
	private final DataSourceFloatField contractDistributionExpenditureField;
	private final DataSourceFloatField depDeployField;
	private final DataSourceFloatField outputAccountField;

	public DSEmployeeAccountAll(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_CUSTOM);
		setActionName("AccountManageProcess");

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		employeeIdField = new DataSourceIntegerField("employeeId", "员工");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));

		employeeNameField = new DataSourceTextField("employeeName", "姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);

		employeeNoField = new DataSourceTextField("employeeNo", "工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);

		leftIntegralField = new DataSourceFloatField("leftIntegral", "实时余额");
		leftIntegralField.setLength(18);
		leftIntegralField.setDecimalPad(2);
		leftIntegralField.setFormat("#,###,###,###,###,##0.00");
		leftIntegralField.setRequired(false);
		leftIntegralField.setHidden(false);
		
		achieveIntegralField = new DataSourceFloatField("achieveIntegral", "积分余额");
		achieveIntegralField.setLength(18);
		achieveIntegralField.setDecimalPad(2);
		achieveIntegralField.setFormat("#,###,###,###,###,##0.00");
		achieveIntegralField.setRequired(false);
		achieveIntegralField.setHidden(false);

		sureIntegralField = new DataSourceFloatField("sureIntegral", "确认积分");
		sureIntegralField.setLength(18);
		sureIntegralField.setDecimalPad(2);
		sureIntegralField.setFormat("#,###,###,###,###,##0.00");
		sureIntegralField.setRequired(false);
		sureIntegralField.setHidden(false);

		managerProjectIntegralField = new DataSourceFloatField("managerProjectIntegral", "奖金补贴");
		managerProjectIntegralField.setLength(18);
		managerProjectIntegralField.setDecimalPad(2);
		managerProjectIntegralField.setFormat("#,###,###,###,###,##0.00");
		managerProjectIntegralField.setRequired(false);
		managerProjectIntegralField.setHidden(false);

		salaryAdvanceField = new DataSourceFloatField("salaryAdvance", "积分借款");
		salaryAdvanceField.setLength(18);
		salaryAdvanceField.setDecimalPad(2);
		salaryAdvanceField.setFormat("#,###,###,###,###,##0.00");
		salaryAdvanceField.setRequired(false);
		salaryAdvanceField.setHidden(false);

		salaryReturnField = new DataSourceFloatField("salaryReturn", "积分还款");
		salaryReturnField.setLength(18);
		salaryReturnField.setDecimalPad(2);
		salaryReturnField.setFormat("#,###,###,###,###,##0.00");
		salaryReturnField.setRequired(false);
		salaryReturnField.setHidden(false);

		salaryField = new DataSourceFloatField("salary", "人工成本");
		salaryField.setLength(18);
		salaryField.setDecimalPad(2);
		salaryField.setFormat("#,###,###,###,###,##0.00");
		salaryField.setRequired(false);
		salaryField.setHidden(false);

		projectCostField = new DataSourceFloatField("projectCost", "项目成本");
		projectCostField.setLength(18);
		projectCostField.setDecimalPad(2);
		projectCostField.setFormat("#,###,###,###,###,##0.00");
		projectCostField.setRequired(false);
		projectCostField.setHidden(false);

		projectAdvanceField = new DataSourceFloatField("projectAdvance", "项目补贴");
		projectAdvanceField.setLength(18);
		projectAdvanceField.setDecimalPad(2);
		projectAdvanceField.setFormat("#,###,###,###,###,##0.00");
		projectAdvanceField.setRequired(false);
		projectAdvanceField.setHidden(false);

		statusField = new DataSourceIntegerField("status", "在职状态");
		statusField.setLength(11);
		statusField.setRequired(false);
		statusField.setHidden(false);
		statusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_11"));

		bonusPaymentField = new DataSourceFloatField("bonusPayment", "奖金发放");
		bonusPaymentField.setLength(18);
		bonusPaymentField.setDecimalPad(2);
		bonusPaymentField.setFormat("#,###,###,###,###,##0.00");
		bonusPaymentField.setRequired(false);
		bonusPaymentField.setHidden(false);
		
		integralReturnField = new DataSourceFloatField("integralReturn", "积分回收");
		integralReturnField.setLength(18);
		integralReturnField.setDecimalPad(2);
		integralReturnField.setFormat("#,###,###,###,###,##0.00");
		integralReturnField.setRequired(false);
		integralReturnField.setHidden(false);
		
		violationChargesField = new DataSourceFloatField("violationCharges", "资源绩效");
		violationChargesField.setLength(18);
		violationChargesField.setDecimalPad(2);
		violationChargesField.setFormat("#,###,###,###,###,##0.00");
		violationChargesField.setRequired(false);
		violationChargesField.setHidden(false);
		
		benefitsField = new DataSourceFloatField("benefits", "个人效益指数");
		benefitsField.setLength(18);
		benefitsField.setDecimalPad(2);
		benefitsField.setFormat("#,###,###,###,###,##0.00");
		benefitsField.setRequired(false);
		benefitsField.setHidden(false);
		
		benefitsYearField = new DataSourceFloatField("benefitsYear", "年度效益指数");
		benefitsYearField.setLength(18);
		benefitsYearField.setDecimalPad(2);
		benefitsYearField.setFormat("#,###,###,###,###,##0.00");
		benefitsYearField.setRequired(false);
		benefitsYearField.setHidden(false);
		
		performanceBonusField = new DataSourceFloatField("performanceBonus", "绩效奖金");
		performanceBonusField.setLength(18);
		performanceBonusField.setDecimalPad(2);
		performanceBonusField.setFormat("#,###,###,###,###,##0.00");
		performanceBonusField.setRequired(false);
		performanceBonusField.setHidden(false);
		
		attendanceDeductField = new DataSourceFloatField("attendanceDeduct", "考勤扣款");
		attendanceDeductField.setLength(18);
		attendanceDeductField.setDecimalPad(2);
		attendanceDeductField.setFormat("#,###,###,###,###,##0.00");
		attendanceDeductField.setRequired(false);
		attendanceDeductField.setHidden(false);
		
		pmPerformanceAwardField = new DataSourceFloatField("pmPerformanceAward", "项目经理绩效奖励");
		pmPerformanceAwardField.setLength(18);
		pmPerformanceAwardField.setDecimalPad(2);
		pmPerformanceAwardField.setFormat("#,###,###,###,###,##0.00");
		pmPerformanceAwardField.setRequired(false);
		pmPerformanceAwardField.setHidden(false);
		
		pmPerformanceDeductField = new DataSourceFloatField("pmPerformanceDeduct", "项目经理绩效扣除");
		pmPerformanceDeductField.setLength(18);
		pmPerformanceDeductField.setDecimalPad(2);
		pmPerformanceDeductField.setFormat("#,###,###,###,###,##0.00");
		pmPerformanceDeductField.setRequired(false);
		pmPerformanceDeductField.setHidden(false);
		
		projectPerformanceField = new DataSourceFloatField("projectPerformance", "项目绩效收入");
		projectPerformanceField.setLength(18);
		projectPerformanceField.setDecimalPad(2);
		projectPerformanceField.setFormat("#,###,###,###,###,##0.00");
		projectPerformanceField.setRequired(false);
		projectPerformanceField.setHidden(false);
		
		contractChangeField = new DataSourceFloatField("contractChange", "合同变更");
		contractChangeField.setLength(18);
		contractChangeField.setDecimalPad(2);
		contractChangeField.setFormat("#,###,###,###,###,##0.00");
		contractChangeField.setRequired(false);
		contractChangeField.setHidden(false);
		
		plateChangeAchieveField = new DataSourceFloatField("plateChangeAchieve", "转岗结算收入");
		plateChangeAchieveField.setLength(18);
		plateChangeAchieveField.setDecimalPad(2);
		plateChangeAchieveField.setFormat("#,###,###,###,###,##0.00");
		plateChangeAchieveField.setRequired(false);
		plateChangeAchieveField.setHidden(false);
		
		plateChangePayField = new DataSourceFloatField("plateChangePay", "转岗结算支出");
		plateChangePayField.setLength(18);
		plateChangePayField.setDecimalPad(2);
		plateChangePayField.setFormat("#,###,###,###,###,##0.00");
		plateChangePayField.setRequired(false);
		plateChangePayField.setHidden(false);
		
		projectPerformancePayField = new DataSourceFloatField("projectPerformancePay", "项目绩效支出");
		projectPerformancePayField.setLength(18);
		projectPerformancePayField.setDecimalPad(2);
		projectPerformancePayField.setFormat("#,###,###,###,###,##0.00");
		projectPerformancePayField.setRequired(false);
		projectPerformancePayField.setHidden(false);
		
		contractDistributionIncomeField = new DataSourceFloatField("contractDistributionIncome", "提成收入");
		contractDistributionIncomeField.setLength(18);
		contractDistributionIncomeField.setDecimalPad(2);
		contractDistributionIncomeField.setFormat("#,###,###,###,###,##0.00");
		contractDistributionIncomeField.setRequired(false);
		contractDistributionIncomeField.setHidden(false);
		
		contractDistributionExpenditureField = new DataSourceFloatField("contractDistributionExpenditure", "提成支出");
		contractDistributionExpenditureField.setLength(18);
		contractDistributionExpenditureField.setDecimalPad(2);
		contractDistributionExpenditureField.setFormat("#,###,###,###,###,##0.00");
		contractDistributionExpenditureField.setRequired(false);
		contractDistributionExpenditureField.setHidden(false);

		depDeployField = new DataSourceFloatField("depDeploy", "部门调配");
		depDeployField.setLength(18);
		depDeployField.setDecimalPad(2);
		depDeployField.setFormat("#,###,###,###,###,##0.00");
		depDeployField.setRequired(false);
		depDeployField.setHidden(false);

		outputAccountField = new DataSourceFloatField("outputAccount", "产值结算");
		outputAccountField.setLength(18);
		outputAccountField.setDecimalPad(2);
		outputAccountField.setFormat("#,###,###,###,###,##0.00");
		outputAccountField.setRequired(false);
		outputAccountField.setHidden(false);
		
		gradeIdField = new DataSourceTextField("gradeId", "职级");
		gradeIdField.setLength(11);
		gradeIdField.setRequired(false);
		gradeIdField.setHidden(false);
		gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_3"));

		setFields(employeeIdField, employeeNoField, employeeNameField,leftIntegralField,achieveIntegralField,benefitsField,benefitsYearField,gradeIdField, statusField, plateIdField,
		sureIntegralField, managerProjectIntegralField, salaryAdvanceField, projectAdvanceField,
		salaryReturnField, salaryField, projectCostField, bonusPaymentField, integralReturnField, violationChargesField,performanceBonusField,attendanceDeductField
		,pmPerformanceAwardField,pmPerformanceDeductField,contractChangeField,projectPerformanceField,plateChangeAchieveField,plateChangePayField,projectPerformancePayField
		,contractDistributionIncomeField,contractDistributionExpenditureField,depDeployField,outputAccountField);
	}

}
