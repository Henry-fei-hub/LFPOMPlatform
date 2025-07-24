package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnSalaryTotalDataSummarize extends DBDataSource
{


	public static DSOnSalaryTotalDataSummarize instance = null;

	public static DSOnSalaryTotalDataSummarize getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryTotalDataSummarize("DSOnSalaryTotalDataSummarize");
		}
		return instance;
	}

	private final DataSourceIntegerField startyearField;
	private final DataSourceIntegerField startmonthField;
	private final DataSourceIntegerField endyearField;
	private final DataSourceIntegerField endmonthField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceTextField mobileField;
	private final DataSourceIntegerField onboardStatusField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceDateField resignationDateField;
	private final DataSourceTextField cardField;
	private final DataSourceIntegerField employeeIdField;
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
	private final DataSourceFloatField insteadDeductField;
	private final DataSourceFloatField insteadDeductIllField;
	private final DataSourceFloatField personalPensionField;
	private final DataSourceFloatField personalMedicalInsuranceField;
	private final DataSourceFloatField personalLargeMedicalInsuranceField;
	private final DataSourceFloatField personalUnemploymentInsuranceField;
	private final DataSourceFloatField personalHeatingField;
	private final DataSourceFloatField personalSeriousIllInsuranceField;
	private final DataSourceFloatField specialAdditionalDuductField;

	public DSOnSalaryTotalDataSummarize(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryTotalDataSummarize");


		startyearField = new DataSourceIntegerField("startyear", "年份");
		startyearField.setLength(11);
		startyearField.setRequired(true);
		startyearField.setHidden(false);


		startmonthField = new DataSourceIntegerField("startmonth", "开始月份");
		startmonthField.setLength(11);
		startmonthField.setRequired(true);
		startmonthField.setHidden(true);


		endyearField = new DataSourceIntegerField("endyear", "结束年份");
		endyearField.setLength(11);
		endyearField.setRequired(true);
		endyearField.setHidden(true);


		endmonthField = new DataSourceIntegerField("endmonth", "结束月份");
		endmonthField.setLength(11);
		endmonthField.setRequired(true);
		endmonthField.setHidden(true);


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);


		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));

		mobileField = new DataSourceTextField("mobile", "手机");
		mobileField.setLength(64);
		mobileField.setRequired(false);
		mobileField.setHidden(false);


		onboardStatusField = new DataSourceIntegerField("onboardStatus", "职员状态");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(false);
		onboardStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));

		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);


		positiveDateField = new DataSourceDateField("positiveDate", "转正日期");
		positiveDateField.setRequired(false);
		positiveDateField.setHidden(false);


		resignationDateField = new DataSourceDateField("resignationDate", "离职日期");
		resignationDateField.setRequired(false);
		resignationDateField.setHidden(false);


		cardField = new DataSourceTextField("card", "身份证号");
		cardField.setLength(64);
		cardField.setRequired(false);
		cardField.setHidden(true);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);


		monthBasicPayField = new DataSourceFloatField("monthBasicPay", "基本工资");
		monthBasicPayField.setLength(18);
		monthBasicPayField.setDecimalPad(2);
		monthBasicPayField.setFormat("#,###,###,###,###,##0.00");
		monthBasicPayField.setRequired(true);
		monthBasicPayField.setHidden(false);


		workMoneyField = new DataSourceFloatField("workMoney", "工龄工资");
		workMoneyField.setLength(18);
		workMoneyField.setDecimalPad(2);
		workMoneyField.setFormat("#,###,###,###,###,##0.00");
		workMoneyField.setRequired(true);
		workMoneyField.setHidden(false);


		fillSendDeductField = new DataSourceFloatField("fillSendDeduct", "补发补扣");
		fillSendDeductField.setLength(18);
		fillSendDeductField.setDecimalPad(2);
		fillSendDeductField.setFormat("#,###,###,###,###,##0.00");
		fillSendDeductField.setRequired(true);
		fillSendDeductField.setHidden(false);


		jobSubsidyField = new DataSourceFloatField("jobSubsidy", "岗位补贴");
		jobSubsidyField.setLength(18);
		jobSubsidyField.setDecimalPad(2);
		jobSubsidyField.setFormat("#,###,###,###,###,##0.00");
		jobSubsidyField.setRequired(true);
		jobSubsidyField.setHidden(false);


		attendanceDeductField = new DataSourceFloatField("attendanceDeduct", "考勤扣款");
		attendanceDeductField.setLength(18);
		attendanceDeductField.setDecimalPad(2);
		attendanceDeductField.setFormat("#,###,###,###,###,##0.00");
		attendanceDeductField.setRequired(true);
		attendanceDeductField.setHidden(false);


		performancePayField = new DataSourceFloatField("performancePay", "绩效工资");
		performancePayField.setLength(18);
		performancePayField.setDecimalPad(2);
		performancePayField.setFormat("#,###,###,###,###,##0.00");
		performancePayField.setRequired(true);
		performancePayField.setHidden(false);


		shouldSalaryField = new DataSourceFloatField("shouldSalary", "应发工资");
		shouldSalaryField.setLength(18);
		shouldSalaryField.setDecimalPad(2);
		shouldSalaryField.setFormat("#,###,###,###,###,##0.00");
		shouldSalaryField.setRequired(true);
		shouldSalaryField.setHidden(false);


		shouldBonusField = new DataSourceFloatField("shouldBonus", "应发奖金");
		shouldBonusField.setLength(18);
		shouldBonusField.setDecimalPad(2);
		shouldBonusField.setFormat("#,###,###,###,###,##0.00");
		shouldBonusField.setRequired(true);
		shouldBonusField.setHidden(false);


		shouldTotalField = new DataSourceFloatField("shouldTotal", "应发合计");
		shouldTotalField.setLength(18);
		shouldTotalField.setDecimalPad(2);
		shouldTotalField.setFormat("#,###,###,###,###,##0.00");
		shouldTotalField.setRequired(true);
		shouldTotalField.setHidden(false);


		alreadyBonusField = new DataSourceFloatField("alreadyBonus", "已发奖金");
		alreadyBonusField.setLength(18);
		alreadyBonusField.setDecimalPad(2);
		alreadyBonusField.setFormat("#,###,###,###,###,##0.00");
		alreadyBonusField.setRequired(true);
		alreadyBonusField.setHidden(false);


		otherBonusField = new DataSourceFloatField("otherBonus", "其他奖金");
		otherBonusField.setLength(18);
		otherBonusField.setDecimalPad(2);
		otherBonusField.setFormat("#,###,###,###,###,##0.00");
		otherBonusField.setRequired(true);
		otherBonusField.setHidden(false);


		shouldTaxAchieveField = new DataSourceFloatField("shouldTaxAchieve", "应纳税所得");
		shouldTaxAchieveField.setLength(18);
		shouldTaxAchieveField.setDecimalPad(2);
		shouldTaxAchieveField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxAchieveField.setRequired(true);
		shouldTaxAchieveField.setHidden(false);


		taxTotalField = new DataSourceFloatField("taxTotal", "个税总额");
		taxTotalField.setLength(18);
		taxTotalField.setDecimalPad(2);
		taxTotalField.setFormat("#,###,###,###,###,##0.00");
		taxTotalField.setRequired(true);
		taxTotalField.setHidden(false);


		deductTaxField = new DataSourceFloatField("deductTax", "已扣个税");
		deductTaxField.setLength(18);
		deductTaxField.setDecimalPad(2);
		deductTaxField.setFormat("#,###,###,###,###,##0.00");
		deductTaxField.setRequired(true);
		deductTaxField.setHidden(false);


		shouldTaxField = new DataSourceFloatField("shouldTax", "应纳个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(true);
		shouldTaxField.setHidden(false);


		totalInsuranceField = new DataSourceFloatField("totalInsurance", "社保");
		totalInsuranceField.setLength(18);
		totalInsuranceField.setDecimalPad(2);
		totalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		totalInsuranceField.setRequired(true);
		totalInsuranceField.setHidden(false);


		totalFundField = new DataSourceFloatField("totalFund", "公积金");
		totalFundField.setLength(18);
		totalFundField.setDecimalPad(2);
		totalFundField.setFormat("#,###,###,###,###,##0.00");
		totalFundField.setRequired(true);
		totalFundField.setHidden(false);


		unitTotalInsuranceField = new DataSourceFloatField("unitTotalInsurance", "单位社保");
		unitTotalInsuranceField.setLength(18);
		unitTotalInsuranceField.setDecimalPad(2);
		unitTotalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		unitTotalInsuranceField.setRequired(true);
		unitTotalInsuranceField.setHidden(false);


		unitTotalFundField = new DataSourceFloatField("unitTotalFund", "单位公积金");
		unitTotalFundField.setLength(18);
		unitTotalFundField.setDecimalPad(2);
		unitTotalFundField.setFormat("#,###,###,###,###,##0.00");
		unitTotalFundField.setRequired(true);
		unitTotalFundField.setHidden(false);


		leaveNoDeductTaxField = new DataSourceFloatField("leaveNoDeductTax", "离职补偿不扣税");
		leaveNoDeductTaxField.setLength(18);
		leaveNoDeductTaxField.setDecimalPad(2);
		leaveNoDeductTaxField.setFormat("#,###,###,###,###,##0.00");
		leaveNoDeductTaxField.setRequired(true);
		leaveNoDeductTaxField.setHidden(false);


		leaveDeductTaxField = new DataSourceFloatField("leaveDeductTax", "离职补偿扣税");
		leaveDeductTaxField.setLength(18);
		leaveDeductTaxField.setDecimalPad(2);
		leaveDeductTaxField.setFormat("#,###,###,###,###,##0.00");
		leaveDeductTaxField.setRequired(true);
		leaveDeductTaxField.setHidden(false);


		factSalaryField = new DataSourceFloatField("factSalary", "实付工资");
		factSalaryField.setLength(18);
		factSalaryField.setDecimalPad(2);
		factSalaryField.setFormat("#,###,###,###,###,##0.00");
		factSalaryField.setRequired(true);
		factSalaryField.setHidden(false);


		insteadDeductField = new DataSourceFloatField("insteadDeduct", "代扣款项");
		insteadDeductField.setLength(18);
		insteadDeductField.setDecimalPad(2);
		insteadDeductField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductField.setRequired(true);
		insteadDeductField.setHidden(false);


		insteadDeductIllField = new DataSourceFloatField("insteadDeductIll", "重疾险");
		insteadDeductIllField.setLength(18);
		insteadDeductIllField.setDecimalPad(2);
		insteadDeductIllField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductIllField.setRequired(true);
		insteadDeductIllField.setHidden(false);


		personalPensionField = new DataSourceFloatField("personalPension", "养老保险（个人）");
		personalPensionField.setLength(18);
		personalPensionField.setDecimalPad(2);
		personalPensionField.setFormat("#,###,###,###,###,##0.00");
		personalPensionField.setRequired(false);
		personalPensionField.setHidden(true);


		personalMedicalInsuranceField = new DataSourceFloatField("personalMedicalInsurance", "医疗保险（个人）");
		personalMedicalInsuranceField.setLength(18);
		personalMedicalInsuranceField.setDecimalPad(2);
		personalMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalMedicalInsuranceField.setRequired(false);
		personalMedicalInsuranceField.setHidden(true);


		personalLargeMedicalInsuranceField = new DataSourceFloatField("personalLargeMedicalInsurance", "大额医疗保险（个人）");
		personalLargeMedicalInsuranceField.setLength(18);
		personalLargeMedicalInsuranceField.setDecimalPad(2);
		personalLargeMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalLargeMedicalInsuranceField.setRequired(false);
		personalLargeMedicalInsuranceField.setHidden(true);


		personalUnemploymentInsuranceField = new DataSourceFloatField("personalUnemploymentInsurance", "失业保险（个人）");
		personalUnemploymentInsuranceField.setLength(18);
		personalUnemploymentInsuranceField.setDecimalPad(2);
		personalUnemploymentInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalUnemploymentInsuranceField.setRequired(false);
		personalUnemploymentInsuranceField.setHidden(true);


		personalHeatingField = new DataSourceFloatField("personalHeating", "采暖（个人）");
		personalHeatingField.setLength(18);
		personalHeatingField.setDecimalPad(2);
		personalHeatingField.setFormat("#,###,###,###,###,##0.00");
		personalHeatingField.setRequired(false);
		personalHeatingField.setHidden(true);


		personalSeriousIllInsuranceField = new DataSourceFloatField("personalSeriousIllInsurance", "大病医疗保险（个人）");
		personalSeriousIllInsuranceField.setLength(18);
		personalSeriousIllInsuranceField.setDecimalPad(2);
		personalSeriousIllInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalSeriousIllInsuranceField.setRequired(false);
		personalSeriousIllInsuranceField.setHidden(true);


		specialAdditionalDuductField = new DataSourceFloatField("specialAdditionalDuduct", "专项附加扣除");
		specialAdditionalDuductField.setLength(18);
		specialAdditionalDuductField.setDecimalPad(2);
		specialAdditionalDuductField.setFormat("#,###,###,###,###,##0.00");
		specialAdditionalDuductField.setRequired(false);
		specialAdditionalDuductField.setHidden(false);


		setFields(startyearField, startmonthField, endyearField, endmonthField, employeeNoField, employeeNameField, companyIdField, plateIdField, departmentIdField, mobileField, onboardStatusField, onboardDateField, positiveDateField, resignationDateField, cardField, employeeIdField, monthBasicPayField, workMoneyField, fillSendDeductField, jobSubsidyField, attendanceDeductField, performancePayField, shouldSalaryField, shouldBonusField, shouldTotalField, alreadyBonusField, otherBonusField, shouldTaxAchieveField, taxTotalField, deductTaxField, shouldTaxField, totalInsuranceField, totalFundField, unitTotalInsuranceField, unitTotalFundField, leaveNoDeductTaxField, leaveDeductTaxField, factSalaryField, insteadDeductField, insteadDeductIllField, personalPensionField, personalMedicalInsuranceField, personalLargeMedicalInsuranceField, personalUnemploymentInsuranceField, personalHeatingField, personalSeriousIllInsuranceField, specialAdditionalDuductField);
	}


}

