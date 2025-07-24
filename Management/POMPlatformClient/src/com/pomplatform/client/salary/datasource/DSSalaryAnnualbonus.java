package com.pomplatform.client.salary.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceBooleanField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSSalaryAnnualbonus extends DBDataSource
{


	public static DSSalaryAnnualbonus instance = null;

	public static DSSalaryAnnualbonus getInstance() {
		if(instance == null) {
			instance = new DSSalaryAnnualbonus("DSSalaryAnnualbonus");
		}
		return instance;
	}

	private final DataSourceTextField bankAccountField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField cardField;
	private final DataSourceTextField mobileField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField onboardStatusField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceFloatField totalPayField;
	private final DataSourceFloatField yearShouldWorkDayField;
	private final DataSourceFloatField yearFactWorkDayField;
	private final DataSourceFloatField yearServiceNumField;
	private final DataSourceTextField yearTestLevelField;
	private final DataSourceFloatField testNumField;
	private final DataSourceFloatField thirteenBonusField;
	private final DataSourceFloatField yearPerformanceBonusField;
	private final DataSourceFloatField programBonusField;
	private final DataSourceFloatField salaryDiffDeductField;
	private final DataSourceFloatField transferAccountMoneyField;
	private final DataSourceFloatField depositDeductField;
	private final DataSourceFloatField reimbursementDeductField;
	private final DataSourceFloatField otherDeductField;
	private final DataSourceFloatField shouldTotalField;
	private final DataSourceFloatField alreadyBonusField;
	private final DataSourceFloatField shouldTaxAchieveField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField insteadDeductField;
	private final DataSourceFloatField factBonusField;
	private final DataSourceBooleanField isSendedField;
	private final DataSourceTextField remarkField;
	private final DataSourceDateTimeField sendTimeField;
	private final DataSourceFloatField oneToThreeRestField;
	private final DataSourceFloatField housingSubsidyField;
	private final DataSourceFloatField deductPerformanceBonusField;

	public DSSalaryAnnualbonus(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SalaryAnnualbonus");


		bankAccountField = new DataSourceTextField("bankAccount", "银行卡号");
		bankAccountField.setLength(64);
		bankAccountField.setRequired(false);
		bankAccountField.setHidden(false);
		bankAccountField.setCanEdit(false);


		employeeNoField = new DataSourceTextField("employeeNo", "员工工号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);
		employeeNoField.setCanEdit(false);

		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(true);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));
		employeeIdField.setCanEdit(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);
		employeeNameField.setCanEdit(false);
		
		cardField = new DataSourceTextField("card", "身份证号码");
		cardField.setLength(64);
		cardField.setRequired(false);
		cardField.setHidden(false);
		cardField.setCanEdit(false);
		
		mobileField = new DataSourceTextField("mobile", "手机号码");
		mobileField.setLength(64);
		mobileField.setRequired(false);
		mobileField.setHidden(false);
		mobileField.setCanEdit(false);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);
		yearField.setCanEdit(false);


		companyIdField = new DataSourceIntegerField("companyId", "所属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));
		companyIdField.setCanEdit(true);

		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));
		plateIdField.setCanEdit(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "所属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
//		departmentIdField.setValueMap(KeyValueManager.getValueMap("all_departments"));
        KeyValueManager.loadValueMap("all_departments",departmentIdField);
		departmentIdField.setCanEdit(true);


		onboardStatusField = new DataSourceIntegerField("onboardStatus", "属性");
		onboardStatusField.setLength(11);
		onboardStatusField.setRequired(false);
		onboardStatusField.setHidden(false);
		onboardStatusField.setValueMap(KeyValueManager.getValueMap("system_dictionary_96"));
		onboardStatusField.setCanEdit(false);

		onboardDateField = new DataSourceDateField("onboardDate", "入职日期");
		onboardDateField.setRequired(false);
		onboardDateField.setHidden(false);
		onboardDateField.setCanEdit(false);


		positiveDateField = new DataSourceDateField("positiveDate", "转正日期");
		positiveDateField.setRequired(false);
		positiveDateField.setHidden(false);
		positiveDateField.setCanEdit(false);


		totalPayField = new DataSourceFloatField("totalPay", "全薪");
		totalPayField.setLength(18);
		totalPayField.setDecimalPad(2);
		totalPayField.setFormat("#,###,###,###,###,##0.00");
		totalPayField.setRequired(false);
		totalPayField.setHidden(true);
		totalPayField.setCanEdit(false);


		yearShouldWorkDayField = new DataSourceFloatField("yearShouldWorkDay", "年度工作日");
		yearShouldWorkDayField.setLength(18);
		yearShouldWorkDayField.setDecimalPad(2);
		yearShouldWorkDayField.setFormat("#,###,###,###,###,##0.00");
		yearShouldWorkDayField.setRequired(false);
		yearShouldWorkDayField.setHidden(true);
		yearShouldWorkDayField.setCanEdit(false);


		yearFactWorkDayField = new DataSourceFloatField("yearFactWorkDay", "实际出勤工作日");
		yearFactWorkDayField.setLength(18);
		yearFactWorkDayField.setDecimalPad(2);
		yearFactWorkDayField.setFormat("#,###,###,###,###,##0.00");
		yearFactWorkDayField.setRequired(false);
		yearFactWorkDayField.setHidden(true);
		yearFactWorkDayField.setCanEdit(false);


		yearServiceNumField = new DataSourceFloatField("yearServiceNum", "年度服务系数");
		yearServiceNumField.setLength(18);
		yearServiceNumField.setDecimalPad(2);
		yearServiceNumField.setFormat("#,###,###,###,###,##0.00");
		yearServiceNumField.setRequired(false);
		yearServiceNumField.setHidden(true);


		yearTestLevelField = new DataSourceTextField("yearTestLevel", "年度考核等级");
		yearTestLevelField.setLength(64);
		yearTestLevelField.setRequired(false);
		yearTestLevelField.setHidden(true);


		testNumField = new DataSourceFloatField("testNum", "考核系数");
		testNumField.setLength(18);
		testNumField.setDecimalPad(2);
		testNumField.setFormat("#,###,###,###,###,##0.00");
		testNumField.setRequired(false);
		testNumField.setHidden(true);


		thirteenBonusField = new DataSourceFloatField("thirteenBonus", "应发13薪奖金");
		thirteenBonusField.setLength(18);
		thirteenBonusField.setDecimalPad(2);
		thirteenBonusField.setFormat("#,###,###,###,###,##0.00");
		thirteenBonusField.setRequired(false);
		thirteenBonusField.setHidden(true);
		thirteenBonusField.setCanEdit(false);

		yearPerformanceBonusField = new DataSourceFloatField("yearPerformanceBonus", "年度绩效工资");
		yearPerformanceBonusField.setLength(18);
		yearPerformanceBonusField.setDecimalPad(2);
		yearPerformanceBonusField.setFormat("#,###,###,###,###,##0.00");
		yearPerformanceBonusField.setRequired(false);
		yearPerformanceBonusField.setHidden(false);


		programBonusField = new DataSourceFloatField("programBonus", "本次应发奖金");
		programBonusField.setLength(18);
		programBonusField.setDecimalPad(2);
		programBonusField.setFormat("#,###,###,###,###,##0.00");
		programBonusField.setRequired(false);
		programBonusField.setHidden(false);
		
		salaryDiffDeductField = new DataSourceFloatField("salaryDiffDeduct", "汇率工资差额");
		salaryDiffDeductField.setLength(18);
		salaryDiffDeductField.setDecimalPad(2);
		salaryDiffDeductField.setFormat("#,###,###,###,###,##0.00");
		salaryDiffDeductField.setRequired(false);
		salaryDiffDeductField.setHidden(false);

		transferAccountMoneyField = new DataSourceFloatField("transferAccountMoney", "调户押金返还");
		transferAccountMoneyField.setLength(18);
		transferAccountMoneyField.setDecimalPad(2);
		transferAccountMoneyField.setFormat("#,###,###,###,###,##0.00");
		transferAccountMoneyField.setRequired(false);
		transferAccountMoneyField.setHidden(false);
		
		
		depositDeductField = new DataSourceFloatField("depositDeduct", "调户押金扣除");
		depositDeductField.setLength(18);
		depositDeductField.setDecimalPad(2);
		depositDeductField.setFormat("#,###,###,###,###,##0.00");
		depositDeductField.setRequired(false);
		depositDeductField.setHidden(false);
		
		reimbursementDeductField = new DataSourceFloatField("reimbursementDeduct", "报销扣款");
		reimbursementDeductField.setLength(18);
		reimbursementDeductField.setDecimalPad(2);
		reimbursementDeductField.setFormat("#,###,###,###,###,##0.00");
		reimbursementDeductField.setRequired(false);
		reimbursementDeductField.setHidden(false);
		
		otherDeductField = new DataSourceFloatField("otherDeduct", "其它扣款");
		otherDeductField.setLength(18);
		otherDeductField.setDecimalPad(2);
		otherDeductField.setFormat("#,###,###,###,###,##0.00");
		otherDeductField.setRequired(false);
		otherDeductField.setHidden(false);

		shouldTotalField = new DataSourceFloatField("shouldTotal", "应发合计");
		shouldTotalField.setLength(18);
		shouldTotalField.setDecimalPad(2);
		shouldTotalField.setFormat("#,###,###,###,###,##0.00");
		shouldTotalField.setRequired(false);
		shouldTotalField.setHidden(false);
		shouldTotalField.setCanEdit(false);
		
		alreadyBonusField = new DataSourceFloatField("alreadyBonus", "已发奖金");
		alreadyBonusField.setLength(18);
		alreadyBonusField.setDecimalPad(2);
		alreadyBonusField.setFormat("#,###,###,###,###,##0.00");
		alreadyBonusField.setRequired(false);
		alreadyBonusField.setHidden(false);
		
		shouldTaxAchieveField = new DataSourceFloatField("shouldTaxAchieve", "应纳税所得");
		shouldTaxAchieveField.setLength(18);
		shouldTaxAchieveField.setDecimalPad(2);
		shouldTaxAchieveField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxAchieveField.setRequired(false);
		shouldTaxAchieveField.setHidden(false);
		shouldTaxAchieveField.setCanEdit(false);
		
		shouldTaxField = new DataSourceFloatField("shouldTax", "应纳个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(false);
		shouldTaxField.setHidden(false);
		shouldTaxField.setCanEdit(false);
		
		insteadDeductField = new DataSourceFloatField("insteadDeduct", "代扣款项");
		insteadDeductField.setLength(18);
		insteadDeductField.setDecimalPad(2);
		insteadDeductField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductField.setRequired(false);
		insteadDeductField.setHidden(false);
		insteadDeductField.setCanEdit(true);

		factBonusField = new DataSourceFloatField("factBonus", "实发奖金");
		factBonusField.setLength(18);
		factBonusField.setDecimalPad(2);
		factBonusField.setFormat("#,###,###,###,###,##0.00");
		factBonusField.setRequired(false);
		factBonusField.setHidden(false);
		factBonusField.setCanEdit(false);
		
		sendTimeField = new DataSourceDateTimeField("sendTime", "发放时间");
		sendTimeField.setRequired(false);
		sendTimeField.setHidden(false);
		sendTimeField.setCanEdit(false);

		isSendedField = new DataSourceBooleanField("isSended", "是否发放");
		isSendedField.setRequired(false);
		isSendedField.setHidden(false);
		isSendedField.setCanEdit(false);
		
		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		remarkField.setCanEdit(true);
		
		oneToThreeRestField = new DataSourceFloatField("oneToThreeRest", "1-3季度剩余奖金");
		oneToThreeRestField.setLength(18);
		oneToThreeRestField.setDecimalPad(2);
		oneToThreeRestField.setFormat("#,###,###,###,###,##0.00");
		oneToThreeRestField.setRequired(false);
		oneToThreeRestField.setHidden(false);
		oneToThreeRestField.setCanEdit(false);


		housingSubsidyField = new DataSourceFloatField("housingSubsidy", "住房补贴");
		housingSubsidyField.setLength(18);
		housingSubsidyField.setDecimalPad(2);
		housingSubsidyField.setFormat("#,###,###,###,###,##0.00");
		housingSubsidyField.setRequired(false);
		housingSubsidyField.setHidden(false);
		housingSubsidyField.setCanEdit(false);


		deductPerformanceBonusField = new DataSourceFloatField("deductPerformanceBonus", "年度绩效扣款");
		deductPerformanceBonusField.setLength(18);
		deductPerformanceBonusField.setDecimalPad(2);
		deductPerformanceBonusField.setFormat("#,###,###,###,###,##0.00");
		deductPerformanceBonusField.setRequired(false);
		deductPerformanceBonusField.setHidden(false);
		deductPerformanceBonusField.setCanEdit(false);

		setFields(bankAccountField, employeeNoField, employeeIdField, employeeNameField,cardField,mobileField, yearField, companyIdField, plateIdField, departmentIdField, onboardStatusField, onboardDateField, positiveDateField, totalPayField, yearShouldWorkDayField, yearFactWorkDayField, yearServiceNumField, yearTestLevelField, testNumField, thirteenBonusField,oneToThreeRestField,programBonusField,yearPerformanceBonusField,housingSubsidyField,transferAccountMoneyField,salaryDiffDeductField,deductPerformanceBonusField,depositDeductField,reimbursementDeductField,otherDeductField, shouldTotalField,alreadyBonusField,shouldTaxAchieveField, shouldTaxField,insteadDeductField, factBonusField,sendTimeField, isSendedField,remarkField);
	}


}

