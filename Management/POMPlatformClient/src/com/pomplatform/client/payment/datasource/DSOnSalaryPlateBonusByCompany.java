package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSOnSalaryPlateBonusByCompany extends DBDataSource
{


	public static DSOnSalaryPlateBonusByCompany instance = null;

	public static DSOnSalaryPlateBonusByCompany getInstance() {
		if(instance == null) {
			instance = new DSOnSalaryPlateBonusByCompany("DSOnSalaryPlateBonusByCompany");
		}
		return instance;
	}

	private final DataSourceTextField plateIdField;
	private final DataSourceTextField yearField;
	private final DataSourceTextField monthField;
	private final DataSourceFloatField shouldBonusField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField factBonusField;
	private final DataSourceFloatField otherBonusField;
	private final DataSourceFloatField projectBonusField;

	public DSOnSalaryPlateBonusByCompany(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("OnSalaryPlateBonusByCompany");


		plateIdField = new DataSourceTextField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		yearField = new DataSourceTextField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceTextField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		shouldBonusField = new DataSourceFloatField("shouldBonus", "应发奖金");
		shouldBonusField.setLength(18);
		shouldBonusField.setDecimalPad(2);
		shouldBonusField.setFormat("#,###,###,###,###,##0.00");
		shouldBonusField.setRequired(true);
		shouldBonusField.setHidden(false);


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
		
		otherBonusField = new DataSourceFloatField("otherBonus", "其他奖金");
		otherBonusField.setLength(18);
		otherBonusField.setDecimalPad(2);
		otherBonusField.setFormat("#,###,###,###,###,##0.00");
		otherBonusField.setRequired(true);
		otherBonusField.setHidden(false);
		
		projectBonusField = new DataSourceFloatField("projectBonus", "项目奖金");
		projectBonusField.setLength(18);
		projectBonusField.setDecimalPad(2);
		projectBonusField.setFormat("#,###,###,###,###,##0.00");
		projectBonusField.setRequired(true);
		projectBonusField.setHidden(false);


		setFields(plateIdField, yearField, monthField,projectBonusField,otherBonusField, shouldBonusField, shouldTaxField, factBonusField);
	}


}

