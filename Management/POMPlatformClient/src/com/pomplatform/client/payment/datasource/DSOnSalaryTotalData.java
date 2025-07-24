package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnSalaryTotalData extends DBDataSource
{


	public static DSOnSalaryTotalData instance = null;

	public static DSOnSalaryTotalData getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryTotalData("DSOnSalaryTotalData");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryTotalIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField mobileField;
	private final DataSourceTextField onboardStatusField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceDateField resignationDateField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceTextField bankAccountField;
	private final DataSourceFloatField monthBasicPayField;
	private final DataSourceFloatField workMoneyField;
	private final DataSourceFloatField fillSendDeductField;
	private final DataSourceFloatField jobSubsidyField;
	private final DataSourceFloatField attendanceDeductField;
	private final DataSourceFloatField performancePayField;
	private final DataSourceFloatField shouldSalaryField;
	private final DataSourceFloatField shouldBonusField;
	private final DataSourceFloatField shouldTotalField;
	private final DataSourceFloatField alreadyBonusField;
	private final DataSourceFloatField otherBonusField;
	private final DataSourceFloatField taxBeginField;
	private final DataSourceFloatField shouldTaxAchieveField;
	private final DataSourceFloatField taxTotalField;
	private final DataSourceFloatField deductTaxField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField totalInsuranceField;
	private final DataSourceFloatField totalFundField;
	private final DataSourceFloatField unitTotalInsuranceField;
	private final DataSourceFloatField unitTotalFundField;
	private final DataSourceFloatField leaveNoDeductTaxField;
	private final DataSourceFloatField leaveDeductTaxField;
	private final DataSourceFloatField factSalaryField;
	private final DataSourceIntegerField affiliatedField;
	private final DataSourceTextField voteProjectField;
	private final DataSourceTextField votePercentField;
	private final DataSourceFloatField insteadDeductField;
	private final DataSourceFloatField insteadDeductIllField;
	private final DataSourceBooleanField isSendedField;
	private final DataSourceTextField costAttributionField;
	private final DataSourceTextField developmentProjectField;
	private final DataSourceTextField salaryTypeNameField;
	private final DataSourceFloatField specialAdditionalDuductField;
	private final DataSourceFloatField specialDuductSumField;
	private final DataSourceFloatField shouldTaxAchieveSumField;
	private final DataSourceFloatField individualIncomeTaxSumField;
	private final DataSourceFloatField insuranceFundSumField;
	private final DataSourceFloatField withholdingTaxField;
	private final DataSourceFloatField replacementTaxField;
	private final DataSourceFloatField suspendBonusField;
	private final DataSourceFloatField otherDeductionField;

	public DSOnSalaryTotalData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryTotalData");


		salaryTotalIdField = new DataSourceIntegerField("salaryTotalId", "主键编码");
		salaryTotalIdField.setLength(11);
		salaryTotalIdField.setPrimaryKey(true);
		salaryTotalIdField.setRequired(true);
		salaryTotalIdField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);
		employeeNameField.setCanEdit(false);


		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setCanEdit(true);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setCanEdit(true);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setCanEdit(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		mobileField = new DataSourceTextField("mobile", "手机");
		mobileField.setLength(64);
		mobileField.setRequired(false);
		mobileField.setHidden(false);
		mobileField.setCanEdit(false);


		onboardStatusField = new DataSourceTextField("onboardStatus", "职员状态");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(false);
		onboardStatusField.setCanEdit(false);
		onboardStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));

		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);
		onboardDateField.setCanEdit(false);


		positiveDateField = new DataSourceDateField("positiveDate", "转正日期");
		positiveDateField.setRequired(false);
		positiveDateField.setHidden(false);
		positiveDateField.setCanEdit(false);


		resignationDateField = new DataSourceDateField("resignationDate", "离职日期");
		resignationDateField.setRequired(false);
		resignationDateField.setHidden(false);
		resignationDateField.setCanEdit(false);


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		yearField.setCanEdit(false);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);
		monthField.setCanEdit(false);


		bankAccountField = new DataSourceTextField("bankAccount", "银行账号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);
		bankAccountField.setCanEdit(false);


		monthBasicPayField = new DataSourceFloatField("monthBasicPay", "基本工资");
		monthBasicPayField.setLength(18);
		monthBasicPayField.setDecimalPad(2);
		monthBasicPayField.setFormat("#,###,###,###,###,##0.00");
		monthBasicPayField.setRequired(false);
		monthBasicPayField.setHidden(false);


		workMoneyField = new DataSourceFloatField("workMoney", "工龄工资");
		workMoneyField.setLength(18);
		workMoneyField.setDecimalPad(2);
		workMoneyField.setFormat("#,###,###,###,###,##0.00");
		workMoneyField.setRequired(false);
		workMoneyField.setHidden(false);


		fillSendDeductField = new DataSourceFloatField("fillSendDeduct", "补发补扣");
		fillSendDeductField.setLength(18);
		fillSendDeductField.setDecimalPad(2);
		fillSendDeductField.setFormat("#,###,###,###,###,##0.00");
		fillSendDeductField.setRequired(false);
		fillSendDeductField.setHidden(false);


		jobSubsidyField = new DataSourceFloatField("jobSubsidy", "岗位补贴");
		jobSubsidyField.setLength(18);
		jobSubsidyField.setDecimalPad(2);
		jobSubsidyField.setFormat("#,###,###,###,###,##0.00");
		jobSubsidyField.setRequired(false);
		jobSubsidyField.setHidden(false);


		attendanceDeductField = new DataSourceFloatField("attendanceDeduct", "考勤扣款");
		attendanceDeductField.setLength(18);
		attendanceDeductField.setDecimalPad(2);
		attendanceDeductField.setFormat("#,###,###,###,###,##0.00");
		attendanceDeductField.setRequired(false);
		attendanceDeductField.setHidden(false);


		performancePayField = new DataSourceFloatField("performancePay", "绩效工资");
		performancePayField.setLength(18);
		performancePayField.setDecimalPad(2);
		performancePayField.setFormat("#,###,###,###,###,##0.00");
		performancePayField.setRequired(false);
		performancePayField.setHidden(false);


		shouldSalaryField = new DataSourceFloatField("shouldSalary", "应发工资");
		shouldSalaryField.setLength(18);
		shouldSalaryField.setDecimalPad(2);
		shouldSalaryField.setFormat("#,###,###,###,###,##0.00");
		shouldSalaryField.setRequired(false);
		shouldSalaryField.setHidden(false);


		shouldBonusField = new DataSourceFloatField("shouldBonus", "应发奖金");
		shouldBonusField.setLength(18);
		shouldBonusField.setDecimalPad(2);
		shouldBonusField.setFormat("#,###,###,###,###,##0.00");
		shouldBonusField.setRequired(false);
		shouldBonusField.setHidden(false);


		shouldTotalField = new DataSourceFloatField("shouldTotal", "应发合计");
		shouldTotalField.setLength(18);
		shouldTotalField.setDecimalPad(2);
		shouldTotalField.setFormat("#,###,###,###,###,##0.00");
		shouldTotalField.setRequired(false);
		shouldTotalField.setHidden(false);


		alreadyBonusField = new DataSourceFloatField("alreadyBonus", "已发奖金");
		alreadyBonusField.setLength(18);
		alreadyBonusField.setDecimalPad(2);
		alreadyBonusField.setFormat("#,###,###,###,###,##0.00");
		alreadyBonusField.setRequired(false);
		alreadyBonusField.setHidden(false);


		otherBonusField = new DataSourceFloatField("otherBonus", "其他奖金");
		otherBonusField.setLength(18);
		otherBonusField.setDecimalPad(2);
		otherBonusField.setFormat("#,###,###,###,###,##0.00");
		otherBonusField.setRequired(false);
		otherBonusField.setHidden(false);


		taxBeginField = new DataSourceFloatField("taxBegin", "个税起征点");
		taxBeginField.setLength(18);
		taxBeginField.setDecimalPad(2);
		taxBeginField.setFormat("#,###,###,###,###,##0.00");
		taxBeginField.setRequired(false);
		taxBeginField.setHidden(false);


		shouldTaxAchieveField = new DataSourceFloatField("shouldTaxAchieve", "应纳税所得");
		shouldTaxAchieveField.setLength(18);
		shouldTaxAchieveField.setDecimalPad(2);
		shouldTaxAchieveField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxAchieveField.setRequired(false);
		shouldTaxAchieveField.setHidden(false);


		taxTotalField = new DataSourceFloatField("taxTotal", "累计应纳税额");
		taxTotalField.setLength(18);
		taxTotalField.setDecimalPad(2);
		taxTotalField.setFormat("#,###,###,###,###,##0.00");
		taxTotalField.setRequired(false);
		taxTotalField.setHidden(false);


		deductTaxField = new DataSourceFloatField("deductTax", "已扣个税");
		deductTaxField.setLength(18);
		deductTaxField.setDecimalPad(2);
		deductTaxField.setFormat("#,###,###,###,###,##0.00");
		deductTaxField.setRequired(false);
		deductTaxField.setHidden(false);


		shouldTaxField = new DataSourceFloatField("shouldTax", "累计应补(退)税额");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(false);
		shouldTaxField.setHidden(false);


		totalInsuranceField = new DataSourceFloatField("totalInsurance", "社保");
		totalInsuranceField.setLength(18);
		totalInsuranceField.setDecimalPad(2);
		totalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		totalInsuranceField.setRequired(false);
		totalInsuranceField.setHidden(false);


		totalFundField = new DataSourceFloatField("totalFund", "公积金");
		totalFundField.setLength(18);
		totalFundField.setDecimalPad(2);
		totalFundField.setFormat("#,###,###,###,###,##0.00");
		totalFundField.setRequired(false);
		totalFundField.setHidden(false);


		leaveNoDeductTaxField = new DataSourceFloatField("leaveNoDeductTax", "离职补偿不扣税");
		leaveNoDeductTaxField.setLength(18);
		leaveNoDeductTaxField.setDecimalPad(2);
		leaveNoDeductTaxField.setFormat("#,###,###,###,###,##0.00");
		leaveNoDeductTaxField.setHidden(false);


		leaveDeductTaxField = new DataSourceFloatField("leaveDeductTax", "离职补偿扣税");
		leaveDeductTaxField.setLength(18);
		leaveDeductTaxField.setDecimalPad(2);
		leaveDeductTaxField.setFormat("#,###,###,###,###,##0.00");
		leaveDeductTaxField.setHidden(false);


		factSalaryField = new DataSourceFloatField("factSalary", "实付工资");
		factSalaryField.setLength(18);
		factSalaryField.setDecimalPad(2);
		factSalaryField.setFormat("#,###,###,###,###,##0.00");
		factSalaryField.setHidden(false);


		affiliatedField = new DataSourceIntegerField("affiliated", "挂靠");
		affiliatedField.setLength(11);
		affiliatedField.setRequired(false);
		affiliatedField.setHidden(true);
		
		insteadDeductField = new DataSourceFloatField("insteadDeduct", "代扣款项");
		insteadDeductField.setLength(18);
		insteadDeductField.setDecimalPad(2);
		insteadDeductField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductField.setHidden(false);
		
		insteadDeductIllField = new DataSourceFloatField("insteadDeductIll", "重疾险");
		insteadDeductIllField.setLength(18);
		insteadDeductIllField.setDecimalPad(2);
		insteadDeductIllField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductIllField.setHidden(false);
		
		unitTotalInsuranceField = new DataSourceFloatField("unitTotalInsurance", "单位社保");
		unitTotalInsuranceField.setLength(18);
		unitTotalInsuranceField.setDecimalPad(2);
		unitTotalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitTotalInsuranceField.setRequired(false);
		unitTotalInsuranceField.setHidden(false);


		unitTotalFundField = new DataSourceFloatField("unitTotalFund", "单位公积金");
		unitTotalFundField.setLength(18);
		unitTotalFundField.setDecimalPad(2);
		unitTotalFundField.setFormat("#,###,###,###,###,##0.00");
		unitTotalFundField.setRequired(false);
		unitTotalFundField.setHidden(false);


		voteProjectField = new DataSourceTextField("voteProject", "募投项目");
		voteProjectField.setLength(64);
		voteProjectField.setHidden(false);


		votePercentField = new DataSourceTextField("votePercent", "募投比例");
		votePercentField.setLength(64);
		votePercentField.setHidden(false);
		
		costAttributionField = new DataSourceTextField("costAttribution", "费用归属");
		costAttributionField.setLength(11);
		costAttributionField.setRequired(false);
		costAttributionField.setHidden(false);
		costAttributionField.setCanEdit(false);
		costAttributionField.setValueMap(KeyValueManager.getValueMap("system_dictionary_114"));


		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setCanEdit(false);
		
		developmentProjectField = new DataSourceTextField("developmentProject", "研发项目");
		developmentProjectField.setLength(64);
		developmentProjectField.setHidden(false);
		developmentProjectField.setCanEdit(true);
		
		salaryTypeNameField = new DataSourceTextField("salaryTypeName", "工资类型");
		salaryTypeNameField.setLength(64);
		salaryTypeNameField.setRequired(false);


		specialAdditionalDuductField = new DataSourceFloatField("specialAdditionalDuduct", "本月专项附加扣除");
		specialAdditionalDuductField.setLength(18);
		specialAdditionalDuductField.setDecimalPad(2);
		specialAdditionalDuductField.setFormat("#,###,###,###,###,##0.00");
		specialAdditionalDuductField.setRequired(true);
		specialAdditionalDuductField.setHidden(false);
		
		specialDuductSumField = new DataSourceFloatField("specialDuductSum", "累计专项附加扣除");
		specialDuductSumField.setLength(18);
		specialDuductSumField.setDecimalPad(2);
		specialDuductSumField.setFormat("#,###,###,###,###,##0.00");
		specialDuductSumField.setRequired(false);
		

		shouldTaxAchieveSumField = new DataSourceFloatField("shouldTaxAchieveSum", "累计应纳税所得");
		shouldTaxAchieveSumField.setLength(18);
		shouldTaxAchieveSumField.setDecimalPad(2);
		shouldTaxAchieveSumField.setRequired(false);
		shouldTaxAchieveSumField.setHidden(false);


		individualIncomeTaxSumField = new DataSourceFloatField("individualIncomeTaxSum", "累计个税起征点");
		individualIncomeTaxSumField.setLength(18);
		individualIncomeTaxSumField.setDecimalPad(2);
		individualIncomeTaxSumField.setRequired(false);
		individualIncomeTaxSumField.setHidden(false);


		insuranceFundSumField = new DataSourceFloatField("insuranceFundSum", "累计社保公积金");
		insuranceFundSumField.setLength(18);
		insuranceFundSumField.setDecimalPad(2);
		insuranceFundSumField.setRequired(false);
		insuranceFundSumField.setHidden(false);
		
		
		withholdingTaxField = new DataSourceFloatField("withholdingTax", "累计已预缴税额");
		withholdingTaxField.setLength(64);
		withholdingTaxField.setDecimalPad(2);
		withholdingTaxField.setRequired(false);
		withholdingTaxField.setHidden(false);


		replacementTaxField = new DataSourceFloatField("replacementTax", "应补退税");
		replacementTaxField.setLength(64);
		replacementTaxField.setDecimalPad(2);
		replacementTaxField.setRequired(false);
		replacementTaxField.setHidden(false);
		

		suspendBonusField = new DataSourceFloatField("suspendBonus", "暂扣奖金");
		suspendBonusField.setLength(128);
		suspendBonusField.setDecimalPad(2);
		suspendBonusField.setFormat("#,###,###,###,###,##0.00");
		suspendBonusField.setRequired(false);
		suspendBonusField.setHidden(false);


		otherDeductionField = new DataSourceFloatField("otherDeduction", "其他扣除");
		otherDeductionField.setLength(128);
		otherDeductionField.setDecimalPad(2);
		otherDeductionField.setFormat("#,###,###,###,###,##0.00");
		otherDeductionField.setRequired(false);
		otherDeductionField.setHidden(false);
		
		
		setFields(salaryTotalIdField, employeeIdField,salaryTypeNameField, employeeNoField, employeeNameField, companyIdField, plateIdField, departmentIdField, mobileField, onboardStatusField, onboardDateField, positiveDateField, resignationDateField, yearField, monthField, bankAccountField, monthBasicPayField, workMoneyField, fillSendDeductField, jobSubsidyField, attendanceDeductField, performancePayField, shouldSalaryField, shouldBonusField, shouldTotalField, alreadyBonusField, otherBonusField, taxBeginField,otherDeductionField,individualIncomeTaxSumField, shouldTaxAchieveField,shouldTaxAchieveSumField, taxTotalField,withholdingTaxField, deductTaxField,suspendBonusField, shouldTaxField, totalInsuranceField, totalFundField,insuranceFundSumField, leaveNoDeductTaxField, leaveDeductTaxField, affiliatedField,insteadDeductField,insteadDeductIllField, unitTotalInsuranceField, unitTotalFundField,specialAdditionalDuductField,specialDuductSumField,replacementTaxField, factSalaryField, voteProjectField, votePercentField,developmentProjectField,costAttributionField,isSendedField);
	}


}

