package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnLoadSalaryPaymentByPlate extends DBDataSource
{


	public static DSOnLoadSalaryPaymentByPlate instance = null;

	public static DSOnLoadSalaryPaymentByPlate getInstance() {
		if(instance == null) {
			instance = new DSOnLoadSalaryPaymentByPlate("DSOnLoadSalaryPaymentByPlate");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField shouldSalaryField;
	private final DataSourceFloatField leaveAdvanceField;
	private final DataSourceFloatField shouldBonusField;
	private final DataSourceFloatField shouldTotalField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField totalInsuranceField;
	private final DataSourceFloatField personalPensionField;
	private final DataSourceFloatField personalMedicalInsuranceField;
	private final DataSourceFloatField personalUnemploymentInsuranceField;
	private final DataSourceFloatField personalLargeMedicalInsuranceField;
	private final DataSourceFloatField personalHeatingField;
	private final DataSourceFloatField totalFundField;
	private final DataSourceFloatField insteadDeductField;
	private final DataSourceFloatField insteadDeductIllField;
	private final DataSourceFloatField factSalaryField;
	private final DataSourceIntegerField numField;
	private final DataSourceTextField typeField;

	public DSOnLoadSalaryPaymentByPlate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("SalaryTotalRecord");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		shouldSalaryField = new DataSourceFloatField("shouldSalary", "应发工资");
		shouldSalaryField.setLength(18);
		shouldSalaryField.setDecimalPad(2);
		shouldSalaryField.setFormat("#,###,###,###,###,##0.00");
		shouldSalaryField.setRequired(false);
		shouldSalaryField.setHidden(false);


		leaveAdvanceField = new DataSourceFloatField("leaveAdvance", "离职补偿");
		leaveAdvanceField.setLength(18);
		leaveAdvanceField.setDecimalPad(2);
		leaveAdvanceField.setFormat("#,###,###,###,###,##0.00");
		leaveAdvanceField.setRequired(false);
		leaveAdvanceField.setHidden(false);


		shouldBonusField = new DataSourceFloatField("shouldBonus", "应付奖金");
		shouldBonusField.setLength(18);
		shouldBonusField.setDecimalPad(2);
		shouldBonusField.setFormat("#,###,###,###,###,##0.00");
		shouldBonusField.setRequired(false);
		shouldBonusField.setHidden(false);


		shouldTotalField = new DataSourceFloatField("shouldTotal", "应付合计");
		shouldTotalField.setLength(18);
		shouldTotalField.setDecimalPad(2);
		shouldTotalField.setFormat("#,###,###,###,###,##0.00");
		shouldTotalField.setRequired(false);
		shouldTotalField.setHidden(false);


		shouldTaxField = new DataSourceFloatField("shouldTax", "代扣个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(false);
		shouldTaxField.setHidden(false);


		totalInsuranceField = new DataSourceFloatField("totalInsurance", "代扣社保");
		totalInsuranceField.setLength(18);
		totalInsuranceField.setDecimalPad(2);
		totalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		totalInsuranceField.setRequired(false);
		totalInsuranceField.setHidden(false);


		personalPensionField = new DataSourceFloatField("personalPension", "代扣养老");
		personalPensionField.setLength(18);
		personalPensionField.setDecimalPad(2);
		personalPensionField.setFormat("#,###,###,###,###,##0.00");
		personalPensionField.setRequired(false);
		personalPensionField.setHidden(false);


		personalMedicalInsuranceField = new DataSourceFloatField("personalMedicalInsurance", "代扣医疗");
		personalMedicalInsuranceField.setLength(18);
		personalMedicalInsuranceField.setDecimalPad(2);
		personalMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalMedicalInsuranceField.setRequired(false);
		personalMedicalInsuranceField.setHidden(false);


		personalUnemploymentInsuranceField = new DataSourceFloatField("personalUnemploymentInsurance", "代扣失业");
		personalUnemploymentInsuranceField.setLength(18);
		personalUnemploymentInsuranceField.setDecimalPad(2);
		personalUnemploymentInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalUnemploymentInsuranceField.setRequired(false);
		personalUnemploymentInsuranceField.setHidden(false);


		personalLargeMedicalInsuranceField = new DataSourceFloatField("personalLargeMedicalInsurance", "代扣大额");
		personalLargeMedicalInsuranceField.setLength(18);
		personalLargeMedicalInsuranceField.setDecimalPad(2);
		personalLargeMedicalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		personalLargeMedicalInsuranceField.setRequired(false);
		personalLargeMedicalInsuranceField.setHidden(false);


		personalHeatingField = new DataSourceFloatField("personalHeating", "代扣采暖");
		personalHeatingField.setLength(18);
		personalHeatingField.setDecimalPad(2);
		personalHeatingField.setFormat("#,###,###,###,###,##0.00");
		personalHeatingField.setRequired(false);
		personalHeatingField.setHidden(false);


		totalFundField = new DataSourceFloatField("totalFund", "代扣公积金");
		totalFundField.setLength(18);
		totalFundField.setDecimalPad(2);
		totalFundField.setFormat("#,###,###,###,###,##0.00");
		totalFundField.setRequired(false);
		totalFundField.setHidden(false);


		insteadDeductField = new DataSourceFloatField("insteadDeduct", "代扣其他");
		insteadDeductField.setLength(18);
		insteadDeductField.setDecimalPad(2);
		insteadDeductField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductField.setRequired(false);
		insteadDeductField.setHidden(false);


		insteadDeductIllField = new DataSourceFloatField("insteadDeductIll", "重疾险");
		insteadDeductIllField.setLength(18);
		insteadDeductIllField.setDecimalPad(2);
		insteadDeductIllField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductIllField.setRequired(false);
		insteadDeductIllField.setHidden(false);


		factSalaryField = new DataSourceFloatField("factSalary", "实发工资");
		factSalaryField.setLength(18);
		factSalaryField.setDecimalPad(2);
		factSalaryField.setFormat("#,###,###,###,###,##0.00");
		factSalaryField.setRequired(false);
		factSalaryField.setHidden(false);


		numField = new DataSourceIntegerField("num", "工资发放人数");
		numField.setLength(11);
		numField.setRequired(true);
		numField.setHidden(false);


		typeField = new DataSourceTextField("type", "类型");
		typeField.setLength(11);
		typeField.setRequired(false);
		typeField.setHidden(true);
		typeField.setValueMap(KeyValueManager.getValueMap("system_dictionary_124"));


		setFields(plateIdField, yearField, monthField, shouldSalaryField, leaveAdvanceField, shouldBonusField, shouldTotalField, shouldTaxField, totalInsuranceField, personalPensionField, personalMedicalInsuranceField, personalUnemploymentInsuranceField, personalLargeMedicalInsuranceField, personalHeatingField, totalFundField, insteadDeductField, insteadDeductIllField, factSalaryField, numField, typeField);
	}


}

