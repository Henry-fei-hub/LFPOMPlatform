package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSLoadSalaryTotal3 extends DBDataSource
{


	public static DSLoadSalaryTotal3 instance = null;

	public static DSLoadSalaryTotal3 getInstance() {
		if(instance == null) {
			instance = new DSLoadSalaryTotal3("DSLoadSalaryTotal3");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryTotalIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField specialAdditionalDuductField;
	private final DataSourceFloatField taxBeginField;
	private final DataSourceTextField shouldTaxAchieveField;
	private final DataSourceTextField shouldTotalField;
	private final DataSourceTextField alreadyBonusField;
	private final DataSourceTextField otherBonusField;
	private final DataSourceTextField leaveDeductTaxField;
	private final DataSourceTextField totalInsuranceField;
	private final DataSourceTextField totalFundField;
	private final DataSourceTextField insteadDeductIllField;
	private final DataSourceTextField shouldTaxAchieveSumField;

	public DSLoadSalaryTotal3(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("LoadSalaryTotal3");


		salaryTotalIdField = new DataSourceIntegerField("salaryTotalId", "主键编码");
		salaryTotalIdField.setLength(11);
		salaryTotalIdField.setPrimaryKey(true);
		salaryTotalIdField.setRequired(true);
		salaryTotalIdField.setHidden(false);


		employeeIdField = new DataSourceIntegerField("employeeId", "员工id");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);


		specialAdditionalDuductField = new DataSourceFloatField("specialAdditionalDuduct", "专项附加扣除");
		specialAdditionalDuductField.setLength(18);
		specialAdditionalDuductField.setDecimalPad(2);
		specialAdditionalDuductField.setFormat("#,###,###,###,###,##0.00");
		specialAdditionalDuductField.setRequired(false);
		specialAdditionalDuductField.setHidden(false);


		taxBeginField = new DataSourceFloatField("taxBegin", "个税起征点");
		taxBeginField.setLength(18);
		taxBeginField.setDecimalPad(2);
		taxBeginField.setFormat("#,###,###,###,###,##0.00");
		taxBeginField.setRequired(false);
		taxBeginField.setHidden(false);


		shouldTaxAchieveField = new DataSourceTextField("shouldTaxAchieve", "应纳税所得");
		shouldTaxAchieveField.setLength(64);
		shouldTaxAchieveField.setRequired(false);
		shouldTaxAchieveField.setHidden(false);


		shouldTotalField = new DataSourceTextField("shouldTotal", "应发合计");
		shouldTotalField.setLength(64);
		shouldTotalField.setRequired(false);
		shouldTotalField.setHidden(false);


		alreadyBonusField = new DataSourceTextField("alreadyBonus", "已发奖金");
		alreadyBonusField.setLength(64);
		alreadyBonusField.setRequired(false);
		alreadyBonusField.setHidden(false);


		otherBonusField = new DataSourceTextField("otherBonus", "其他奖金");
		otherBonusField.setLength(64);
		otherBonusField.setRequired(false);
		otherBonusField.setHidden(false);


		leaveDeductTaxField = new DataSourceTextField("leaveDeductTax", "离职补偿扣税");
		leaveDeductTaxField.setLength(64);
		leaveDeductTaxField.setRequired(false);
		leaveDeductTaxField.setHidden(false);


		totalInsuranceField = new DataSourceTextField("totalInsurance", "社保");
		totalInsuranceField.setLength(64);
		totalInsuranceField.setRequired(false);
		totalInsuranceField.setHidden(false);


		totalFundField = new DataSourceTextField("totalFund", "公积金");
		totalFundField.setLength(64);
		totalFundField.setRequired(false);
		totalFundField.setHidden(false);


		insteadDeductIllField = new DataSourceTextField("insteadDeductIll", "代扣重疾");
		insteadDeductIllField.setLength(64);
		insteadDeductIllField.setRequired(false);
		insteadDeductIllField.setHidden(false);


		shouldTaxAchieveSumField = new DataSourceTextField("shouldTaxAchieveSum", "should_tax_achieve_sum");
		shouldTaxAchieveSumField.setLength(64);
		shouldTaxAchieveSumField.setRequired(false);
		shouldTaxAchieveSumField.setHidden(false);


		setFields(salaryTotalIdField, employeeIdField, specialAdditionalDuductField, taxBeginField, shouldTaxAchieveField, shouldTotalField, alreadyBonusField, otherBonusField, leaveDeductTaxField, totalInsuranceField, totalFundField, insteadDeductIllField, shouldTaxAchieveSumField);
	}


}

