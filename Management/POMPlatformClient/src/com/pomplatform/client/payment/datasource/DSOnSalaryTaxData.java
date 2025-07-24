package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnSalaryTaxData extends DBDataSource
{


	public static DSOnSalaryTaxData instance = null;

	public static DSOnSalaryTaxData getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryTaxData("DSOnSalaryTotalData");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceIntegerField genderField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceTextField cardField;
	private final DataSourceTextField mobileField;
	private final DataSourceTextField companyIdField;
	private final DataSourceTextField plateIdField;
	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField shouldSalaryField;
	private final DataSourceFloatField shouldBonusField;
	private final DataSourceFloatField alreadyBonusField;
	private final DataSourceFloatField otherBonusField;
	private final DataSourceFloatField shouldTaxAchieveField;
	private final DataSourceFloatField taxTotalField;
	private final DataSourceFloatField deductTaxField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField totalInsuranceField;
	private final DataSourceFloatField totalFundField;
	private final DataSourceFloatField insteadDeductIllField;
	private final DataSourceFloatField personalPensionField;
	private final DataSourceFloatField personalMedicalInsuranceField;
	private final DataSourceFloatField personalLargeMedicalInsuranceField;
	private final DataSourceFloatField personalSeriousIllInsuranceField;
	private final DataSourceFloatField personalUnemploymentInsuranceField;
	private final DataSourceFloatField personalHeatingField;
	private final DataSourceFloatField specialDuduct1Field;
	private final DataSourceFloatField specialDuduct2Field;
	private final DataSourceFloatField specialDuduct3Field;
	private final DataSourceFloatField specialDuduct4Field;
	private final DataSourceFloatField specialDuduct5Field;
	private final DataSourceFloatField specialDuduct6Field;
	private final DataSourceFloatField specialDuductSumField;
	private final DataSourceFloatField specialAdditionalDuductField;
	private final DataSourceDateField onboardDateField;
	private final DataSourceDateField positiveDateField;
	private final DataSourceDateField resignationDateField;

	public DSOnSalaryTaxData(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryTotalData");


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
		
        
        genderField = new DataSourceIntegerField("gender", "性别");
        genderField.setLength(11);
        genderField.setRequired(false);
        genderField.setHidden(false);
        genderField.setValueMap(KeyValueManager.getValueMap("system_dictionary_12"));
		
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

		companyIdField = new DataSourceTextField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(false);
		companyIdField.setCanEdit(false);
		companyIdField.setValueMap(KeyValueManager.getValueMap("company_records"));


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setCanEdit(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setCanEdit(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


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



		shouldTaxAchieveField = new DataSourceFloatField("shouldTaxAchieve", "应纳税所得");
		shouldTaxAchieveField.setLength(18);
		shouldTaxAchieveField.setDecimalPad(2);
		shouldTaxAchieveField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxAchieveField.setRequired(false);
		shouldTaxAchieveField.setHidden(false);


		taxTotalField = new DataSourceFloatField("taxTotal", "个税总额");
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


		shouldTaxField = new DataSourceFloatField("shouldTax", "应纳个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(false);
		shouldTaxField.setHidden(false);


		totalFundField = new DataSourceFloatField("totalFund", "公积金");
		totalFundField.setLength(18);
		totalFundField.setDecimalPad(2);
		totalFundField.setFormat("#,###,###,###,###,##0.00");
		totalFundField.setRequired(false);
		totalFundField.setHidden(false);


		insteadDeductIllField = new DataSourceFloatField("insteadDeductIll", "重疾险");
		insteadDeductIllField.setLength(18);
		insteadDeductIllField.setDecimalPad(2);
		insteadDeductIllField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductIllField.setHidden(false);
		
		personalPensionField = new DataSourceFloatField("personalPension", "养老保险");
		personalPensionField.setLength(18);
		personalPensionField.setDecimalPad(2);
		personalPensionField.setFormat("#,###,###,###,###,##0.00");
		personalPensionField.setRequired(false);
		personalPensionField.setHidden(false);


		personalMedicalInsuranceField = new DataSourceFloatField("personalMedicalInsurance", "医疗保险");
		personalMedicalInsuranceField.setLength(18);
		personalMedicalInsuranceField.setDecimalPad(2);
		personalMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalMedicalInsuranceField.setRequired(false);
		personalMedicalInsuranceField.setHidden(false);


		personalLargeMedicalInsuranceField = new DataSourceFloatField("personalLargeMedicalInsurance", "大额医疗保险");
		personalLargeMedicalInsuranceField.setLength(18);
		personalLargeMedicalInsuranceField.setDecimalPad(2);
		personalLargeMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalLargeMedicalInsuranceField.setRequired(false);
		personalLargeMedicalInsuranceField.setHidden(false);


		personalSeriousIllInsuranceField = new DataSourceFloatField("personalSeriousIllInsurance", "大病医疗保险");
		personalSeriousIllInsuranceField.setLength(18);
		personalSeriousIllInsuranceField.setDecimalPad(2);
		personalSeriousIllInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalSeriousIllInsuranceField.setRequired(false);
		personalSeriousIllInsuranceField.setHidden(false);


		personalUnemploymentInsuranceField = new DataSourceFloatField("personalUnemploymentInsurance", "失业保险");
		personalUnemploymentInsuranceField.setLength(18);
		personalUnemploymentInsuranceField.setDecimalPad(2);
		personalUnemploymentInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalUnemploymentInsuranceField.setRequired(false);
		personalUnemploymentInsuranceField.setHidden(false);


		personalHeatingField = new DataSourceFloatField("personalHeating", "采暖");
		personalHeatingField.setLength(18);
		personalHeatingField.setDecimalPad(2);
		personalHeatingField.setFormat("#,###,###,###,###,##0.00");
		personalHeatingField.setRequired(false);
		personalHeatingField.setHidden(false);
		
		totalInsuranceField = new DataSourceFloatField("totalInsurance", "社保合计");
		totalInsuranceField.setLength(18);
		totalInsuranceField.setDecimalPad(2);
		totalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		totalInsuranceField.setRequired(false);
		totalInsuranceField.setHidden(false);
		

		specialDuductSumField = new DataSourceFloatField("specialDuductSum", "累计专项扣除合计");
		specialDuductSumField.setLength(18);
		specialDuductSumField.setDecimalPad(2);
		specialDuductSumField.setFormat("#,###,###,###,###,##0.00");
		specialDuductSumField.setRequired(false);
		specialDuductSumField.setHidden(false);
		
		specialAdditionalDuductField = new DataSourceFloatField("specialAdditionalDuduct", "专项扣除合计");
		specialAdditionalDuductField.setLength(18);
		specialAdditionalDuductField.setDecimalPad(2);
		specialAdditionalDuductField.setFormat("#,###,###,###,###,##0.00");
		specialAdditionalDuductField.setRequired(false);
		specialAdditionalDuductField.setHidden(false);
		
		
		specialDuduct1Field = new DataSourceFloatField("specialDuduct1", "子女教育");
		specialDuduct1Field.setLength(18);
		specialDuduct1Field.setDecimalPad(2);
		specialDuduct1Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct1Field.setRequired(false);
		specialDuduct1Field.setHidden(false);


		specialDuduct2Field = new DataSourceFloatField("specialDuduct2", "继续教育");
		specialDuduct2Field.setLength(18);
		specialDuduct2Field.setDecimalPad(2);
		specialDuduct2Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct2Field.setRequired(false);
		specialDuduct2Field.setHidden(false);


		specialDuduct3Field = new DataSourceFloatField("specialDuduct3", "住房贷款利息");
		specialDuduct3Field.setLength(18);
		specialDuduct3Field.setDecimalPad(2);
		specialDuduct3Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct3Field.setRequired(false);
		specialDuduct3Field.setHidden(false);


		specialDuduct4Field = new DataSourceFloatField("specialDuduct4", "住房租金");
		specialDuduct4Field.setLength(18);
		specialDuduct4Field.setDecimalPad(2);
		specialDuduct4Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct4Field.setRequired(false);
		specialDuduct4Field.setHidden(false);


		specialDuduct5Field = new DataSourceFloatField("specialDuduct5", "赡养老人");
		specialDuduct5Field.setLength(18);
		specialDuduct5Field.setDecimalPad(2);
		specialDuduct5Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct5Field.setRequired(false);
		specialDuduct5Field.setHidden(false);


		specialDuduct6Field = new DataSourceFloatField("specialDuduct6", "大病医疗");
		specialDuduct6Field.setLength(18);
		specialDuduct6Field.setDecimalPad(2);
		specialDuduct6Field.setFormat("#,###,###,###,###,##0.00");
		specialDuduct6Field.setRequired(false);
		specialDuduct6Field.setHidden(false);
		
		setFields(employeeIdField, employeeNoField, employeeNameField,genderField,onboardDateField,positiveDateField,resignationDateField,cardField,mobileField,companyIdField, plateIdField, departmentIdField, yearField, monthField, shouldSalaryField, shouldBonusField,alreadyBonusField, otherBonusField, shouldTaxAchieveField, taxTotalField, deductTaxField, shouldTaxField, totalFundField,insteadDeductIllField, personalPensionField, personalMedicalInsuranceField, personalLargeMedicalInsuranceField, personalSeriousIllInsuranceField, personalUnemploymentInsuranceField, personalHeatingField, totalInsuranceField, specialDuduct1Field, specialDuduct2Field, specialDuduct3Field, specialDuduct4Field, specialDuduct5Field, specialDuduct6Field,specialAdditionalDuductField,specialDuductSumField);
	}


}

