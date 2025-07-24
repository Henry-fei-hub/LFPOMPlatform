package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSLoadSalaryTotal extends DBDataSource
{


	public static DSLoadSalaryTotal instance = null;

	public static DSLoadSalaryTotal getInstance() {
		if(instance == null) {
			instance = new DSLoadSalaryTotal("DSLoadSalaryTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryTotalIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField specialAdditionalDuductField;
	private final DataSourceTextField shouldTaxAchieveField;
	private final DataSourceTextField totalFundField;
	private final DataSourceTextField totalInsuranceField;
	private final DataSourceTextField shouldTaxAchieveSumField;
	private final DataSourceTextField individualIncomeTaxSumField;
	private final DataSourceTextField insuranceFundSumField;
	private final DataSourceFloatField specialDuductSumField;

	public DSLoadSalaryTotal(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("LoadSalaryTotal");


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


		shouldTaxAchieveField = new DataSourceTextField("shouldTaxAchieve", "应纳税所得");
		shouldTaxAchieveField.setLength(64);
		shouldTaxAchieveField.setRequired(false);
		shouldTaxAchieveField.setHidden(false);


		totalFundField = new DataSourceTextField("totalFund", "公积金");
		totalFundField.setLength(64);
		totalFundField.setRequired(false);
		totalFundField.setHidden(false);


		totalInsuranceField = new DataSourceTextField("totalInsurance", "社保");
		totalInsuranceField.setLength(64);
		totalInsuranceField.setRequired(false);
		totalInsuranceField.setHidden(false);


		shouldTaxAchieveSumField = new DataSourceTextField("shouldTaxAchieveSum", "累计应纳税所得");
		shouldTaxAchieveSumField.setLength(18);
		shouldTaxAchieveSumField.setRequired(false);
		shouldTaxAchieveSumField.setHidden(false);


		individualIncomeTaxSumField = new DataSourceTextField("individualIncomeTaxSum", "累计个税起征点");
		individualIncomeTaxSumField.setLength(18);
		individualIncomeTaxSumField.setRequired(false);
		individualIncomeTaxSumField.setHidden(false);


		insuranceFundSumField = new DataSourceTextField("insuranceFundSum", "累计社保公积金");
		insuranceFundSumField.setLength(18);
		insuranceFundSumField.setRequired(false);
		insuranceFundSumField.setHidden(false);


		specialDuductSumField = new DataSourceFloatField("specialDuductSum", "累计专项附加扣除之和");
		specialDuductSumField.setLength(18);
		specialDuductSumField.setDecimalPad(2);
		specialDuductSumField.setFormat("#,###,###,###,###,##0.00");
		specialDuductSumField.setRequired(false);
		specialDuductSumField.setHidden(false);


		setFields(salaryTotalIdField, employeeIdField, specialAdditionalDuductField, shouldTaxAchieveField, totalFundField, totalInsuranceField, shouldTaxAchieveSumField, individualIncomeTaxSumField, insuranceFundSumField, specialDuductSumField);
	}


}

