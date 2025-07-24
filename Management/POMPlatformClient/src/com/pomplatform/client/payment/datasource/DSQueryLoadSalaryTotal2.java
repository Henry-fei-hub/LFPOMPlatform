package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSQueryLoadSalaryTotal2 extends DBDataSource
{


	public static DSQueryLoadSalaryTotal2 instance = null;

	public static DSQueryLoadSalaryTotal2 getInstance() {
		if(instance == null) {
			instance = new DSQueryLoadSalaryTotal2("DSQueryLoadSalaryTotal2");
		}
		return instance;
	}

	private final DataSourceIntegerField salaryTotalIdField;
	private final DataSourceIntegerField employeeIdField;
	private final DataSourceFloatField specialAdditionalDuductField;
	private final DataSourceTextField shouldTaxAchieveField;
	private final DataSourceTextField totalFundField;
	private final DataSourceTextField totalInsuranceField;

	public DSQueryLoadSalaryTotal2(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("QueryLoadSalaryTotal2");


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


		setFields(salaryTotalIdField, employeeIdField, specialAdditionalDuductField, shouldTaxAchieveField, totalFundField, totalInsuranceField);
	}


}

