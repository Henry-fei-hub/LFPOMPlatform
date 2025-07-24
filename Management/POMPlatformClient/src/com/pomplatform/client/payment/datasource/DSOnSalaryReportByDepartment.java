package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnSalaryReportByDepartment extends DBDataSource
{


	public static DSOnSalaryReportByDepartment instance = null;

	public static DSOnSalaryReportByDepartment getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryReportByDepartment("DSOnSalaryReportByDepartment");
		}
		return instance;
	}

	private final DataSourceTextField departmentIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField shouldSalaryField;
	private final DataSourceFloatField leaveAdvanceField;
	private final DataSourceFloatField shouldBonusField;
	private final DataSourceFloatField shouldTotalField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField totalInsuranceField;
	private final DataSourceFloatField totalFundField;
	private final DataSourceFloatField insteadDeductField;
	private final DataSourceFloatField insteadDeductIllField;
	private final DataSourceFloatField factSalaryField;
	private final DataSourceIntegerField numField;
	private final DataSourceFloatField unitTotalInsuranceField;
	private final DataSourceFloatField unitTotalFundField;
	private final DataSourceFloatField replacementTaxField;

	public DSOnSalaryReportByDepartment(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryReportByDepartment");


		departmentIdField = new DataSourceTextField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(false);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		shouldSalaryField = new DataSourceFloatField("shouldSalary", "应付工资");
		shouldSalaryField.setLength(18);
		shouldSalaryField.setDecimalPad(2);
		shouldSalaryField.setFormat("#,###,###,###,###,##0.00");
		shouldSalaryField.setRequired(true);
		shouldSalaryField.setHidden(false);


		leaveAdvanceField = new DataSourceFloatField("leaveAdvance", "离职补偿");
		leaveAdvanceField.setLength(18);
		leaveAdvanceField.setDecimalPad(2);
		leaveAdvanceField.setFormat("#,###,###,###,###,##0.00");
		leaveAdvanceField.setRequired(true);
		leaveAdvanceField.setHidden(false);


		shouldBonusField = new DataSourceFloatField("shouldBonus", "应付奖金");
		shouldBonusField.setLength(18);
		shouldBonusField.setDecimalPad(2);
		shouldBonusField.setFormat("#,###,###,###,###,##0.00");
		shouldBonusField.setRequired(true);
		shouldBonusField.setHidden(false);


		shouldTotalField = new DataSourceFloatField("shouldTotal", "应付合计");
		shouldTotalField.setLength(18);
		shouldTotalField.setDecimalPad(2);
		shouldTotalField.setFormat("#,###,###,###,###,##0.00");
		shouldTotalField.setRequired(true);
		shouldTotalField.setHidden(false);


		shouldTaxField = new DataSourceFloatField("shouldTax", "代扣个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(true);
		shouldTaxField.setHidden(false);


		totalInsuranceField = new DataSourceFloatField("totalInsurance", "代扣社保");
		totalInsuranceField.setLength(18);
		totalInsuranceField.setDecimalPad(2);
		totalInsuranceField.setFormat("#,###,###,###,###,##0.00");
		totalInsuranceField.setRequired(true);
		totalInsuranceField.setHidden(false);


		totalFundField = new DataSourceFloatField("totalFund", "代扣公积金");
		totalFundField.setLength(18);
		totalFundField.setDecimalPad(2);
		totalFundField.setFormat("#,###,###,###,###,##0.00");
		totalFundField.setRequired(true);
		totalFundField.setHidden(false);


		insteadDeductField = new DataSourceFloatField("insteadDeduct", "代扣补贴");
		insteadDeductField.setLength(18);
		insteadDeductField.setDecimalPad(2);
		insteadDeductField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductField.setRequired(true);
		insteadDeductField.setHidden(false);


		insteadDeductIllField = new DataSourceFloatField("insteadDeductIll", "代扣重疾险");
		insteadDeductIllField.setLength(18);
		insteadDeductIllField.setDecimalPad(2);
		insteadDeductIllField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductIllField.setRequired(true);
		insteadDeductIllField.setHidden(false);

		replacementTaxField = new DataSourceFloatField("replacementTax", "应补退税");
		replacementTaxField.setLength(18);
		replacementTaxField.setDecimalPad(2);
		replacementTaxField.setFormat("#,###,###,###,###,##0.00");
		replacementTaxField.setRequired(true);
		replacementTaxField.setHidden(false);

		factSalaryField = new DataSourceFloatField("factSalary", "实发工资");
		factSalaryField.setLength(18);
		factSalaryField.setDecimalPad(2);
		factSalaryField.setFormat("#,###,###,###,###,##0.00");
		factSalaryField.setRequired(true);
		factSalaryField.setHidden(false);


		numField = new DataSourceIntegerField("num", "工资发放人数");
		numField.setLength(11);
		numField.setRequired(true);
		numField.setHidden(false);


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
		unitTotalFundField.setHidden(true);


		setFields(departmentIdField, yearField, monthField, shouldSalaryField, leaveAdvanceField, shouldBonusField, shouldTotalField, shouldTaxField, totalInsuranceField, totalFundField, insteadDeductField, insteadDeductIllField,replacementTaxField, factSalaryField, numField, unitTotalInsuranceField, unitTotalFundField);
	}


}

