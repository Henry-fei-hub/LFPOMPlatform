package com.pomplatform.client.payment.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceDateTimeField;
import com.smartgwt.client.data.fields.DataSourceFloatField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnSalaryAnnualBonusByPlate extends DBDataSource
{


	public static DSOnSalaryAnnualBonusByPlate instance = null;

	public static DSOnSalaryAnnualBonusByPlate getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryAnnualBonusByPlate("DSOnSalaryAnnualBonusByPlate");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceFloatField thirteenBonusField;
	private final DataSourceFloatField yearPerformanceBonusField;
	private final DataSourceFloatField programBonusField;
	private final DataSourceFloatField transferAccountMoneyField;
	private final DataSourceFloatField depositDeductField;
	private final DataSourceFloatField shouldTotalField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField factBonusField;
	private final DataSourceFloatField totalPayField;
	private final DataSourceFloatField salaryDiffDeductField;
	private final DataSourceFloatField reimbursementDeductField;
	private final DataSourceFloatField otherDeductField;
	private final DataSourceDateTimeField sendTimeField;
	private final DataSourceTextField remarkField;
	private final DataSourceIntegerField personnelBusinessIdField;
	private final DataSourceFloatField oneToThreeRestField;
	private final DataSourceFloatField housingSubsidyField;
	private final DataSourceFloatField deductPerformanceBonusField;
	private final DataSourceFloatField insteadDeductField;

	public DSOnSalaryAnnualBonusByPlate(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryAnnualBonusByPlate");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		thirteenBonusField = new DataSourceFloatField("thirteenBonus", "应发13薪奖金");
		thirteenBonusField.setLength(18);
		thirteenBonusField.setDecimalPad(2);
		thirteenBonusField.setFormat("#,###,###,###,###,##0.00");
		thirteenBonusField.setRequired(true);
		thirteenBonusField.setHidden(true);


		yearPerformanceBonusField = new DataSourceFloatField("yearPerformanceBonus", "年度绩效工资");
		yearPerformanceBonusField.setLength(18);
		yearPerformanceBonusField.setDecimalPad(2);
		yearPerformanceBonusField.setFormat("#,###,###,###,###,##0.00");
		yearPerformanceBonusField.setRequired(true);
		yearPerformanceBonusField.setHidden(false);


		programBonusField = new DataSourceFloatField("programBonus", "本次应发奖金");
		programBonusField.setLength(18);
		programBonusField.setDecimalPad(2);
		programBonusField.setFormat("#,###,###,###,###,##0.00");
		programBonusField.setRequired(true);
		programBonusField.setHidden(false);


		transferAccountMoneyField = new DataSourceFloatField("transferAccountMoney", "调户押金返还");
		transferAccountMoneyField.setLength(18);
		transferAccountMoneyField.setDecimalPad(2);
		transferAccountMoneyField.setFormat("#,###,###,###,###,##0.00");
		transferAccountMoneyField.setRequired(true);
		transferAccountMoneyField.setHidden(false);


		depositDeductField = new DataSourceFloatField("depositDeduct", "调户押金扣除");
		depositDeductField.setLength(18);
		depositDeductField.setDecimalPad(2);
		depositDeductField.setFormat("#,###,###,###,###,##0.00");
		depositDeductField.setRequired(true);
		depositDeductField.setHidden(false);


		shouldTotalField = new DataSourceFloatField("shouldTotal", "应发合计");
		shouldTotalField.setLength(18);
		shouldTotalField.setDecimalPad(2);
		shouldTotalField.setFormat("#,###,###,###,###,##0.00");
		shouldTotalField.setRequired(true);
		shouldTotalField.setHidden(false);


		shouldTaxField = new DataSourceFloatField("shouldTax", "应纳个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(true);
		shouldTaxField.setHidden(false);


		factBonusField = new DataSourceFloatField("factBonus", "实发奖金");
		factBonusField.setLength(18);
		factBonusField.setDecimalPad(2);
		factBonusField.setFormat("#,###,###,###,###,##0.00");
		factBonusField.setRequired(true);
		factBonusField.setHidden(false);


		totalPayField = new DataSourceFloatField("totalPay", "全薪");
		totalPayField.setLength(18);
		totalPayField.setDecimalPad(2);
		totalPayField.setFormat("#,###,###,###,###,##0.00");
		totalPayField.setRequired(true);
		totalPayField.setHidden(true);
		
		salaryDiffDeductField = new DataSourceFloatField("salaryDiffDeduct", "汇率工资差额");
		salaryDiffDeductField.setLength(18);
		salaryDiffDeductField.setDecimalPad(2);
		salaryDiffDeductField.setFormat("#,###,###,###,###,##0.00");
		salaryDiffDeductField.setRequired(true);
		salaryDiffDeductField.setHidden(false);


		reimbursementDeductField = new DataSourceFloatField("reimbursementDeduct", "报销扣款");
		reimbursementDeductField.setLength(18);
		reimbursementDeductField.setDecimalPad(2);
		reimbursementDeductField.setFormat("#,###,###,###,###,##0.00");
		reimbursementDeductField.setRequired(true);
		reimbursementDeductField.setHidden(false);


		otherDeductField = new DataSourceFloatField("otherDeduct", "其他扣款");
		otherDeductField.setLength(18);
		otherDeductField.setDecimalPad(2);
		otherDeductField.setFormat("#,###,###,###,###,##0.00");
		otherDeductField.setRequired(true);
		otherDeductField.setHidden(false);
		
		sendTimeField = new DataSourceDateTimeField("sendTime", "发放时间");
		sendTimeField.setRequired(false);
		sendTimeField.setHidden(false);

		remarkField = new DataSourceTextField("remark", "备注");
		remarkField.setLength(1024);
		remarkField.setRequired(false);
		remarkField.setHidden(false);
		
		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "业务流程Id");
		personnelBusinessIdField.setLength(64);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);
		
		oneToThreeRestField = new DataSourceFloatField("oneToThreeRest", "1-3季度剩余奖金");
		oneToThreeRestField.setLength(18);
		oneToThreeRestField.setDecimalPad(2);
		oneToThreeRestField.setFormat("#,###,###,###,###,##0.00");
		oneToThreeRestField.setRequired(true);
		oneToThreeRestField.setHidden(false);


		housingSubsidyField = new DataSourceFloatField("housingSubsidy", "住房补贴");
		housingSubsidyField.setLength(18);
		housingSubsidyField.setDecimalPad(2);
		housingSubsidyField.setFormat("#,###,###,###,###,##0.00");
		housingSubsidyField.setRequired(true);
		housingSubsidyField.setHidden(false);


		deductPerformanceBonusField = new DataSourceFloatField("deductPerformanceBonus", "年度绩效扣款");
		deductPerformanceBonusField.setLength(18);
		deductPerformanceBonusField.setDecimalPad(2);
		deductPerformanceBonusField.setFormat("#,###,###,###,###,##0.00");
		deductPerformanceBonusField.setRequired(true);
		deductPerformanceBonusField.setHidden(false);

		
		insteadDeductField = new DataSourceFloatField("insteadDeduct", "代扣款项");
		insteadDeductField.setLength(18);
		insteadDeductField.setDecimalPad(2);
		insteadDeductField.setFormat("#,###,###,###,###,##0.00");
		insteadDeductField.setRequired(false);
		insteadDeductField.setHidden(false);
		insteadDeductField.setCanEdit(true);


		setFields(plateIdField, yearField, oneToThreeRestField,thirteenBonusField,programBonusField,yearPerformanceBonusField,housingSubsidyField,salaryDiffDeductField,deductPerformanceBonusField,transferAccountMoneyField, depositDeductField,reimbursementDeductField,otherDeductField, shouldTotalField, shouldTaxField,insteadDeductField, factBonusField, totalPayField,sendTimeField,remarkField,personnelBusinessIdField);
	}


}

