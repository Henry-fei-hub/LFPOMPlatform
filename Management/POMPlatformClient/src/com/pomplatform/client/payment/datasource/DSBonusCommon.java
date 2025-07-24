package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSBonusCommon extends DBDataSource
{


	public static DSBonusCommon instance = null;

	public static DSBonusCommon getInstance() {
		if(instance == null) {
			instance = new DSBonusCommon("DSBonusCommon");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceFloatField shouldBonusField;
	private final DataSourceFloatField shouldTaxField;
	private final DataSourceFloatField factBonusField;
	private final DataSourceFloatField otherBonusField;
	private final DataSourceFloatField projectBonusField;
	private final DataSourceIntegerField salaryTypeField;
	private final DataSourceIntegerField fundraisingProjectTypeField;
	private final DataSourceFloatField fundraisingProjectRateField;
	private final DataSourceIntegerField personnelBusinessIdField;

	public DSBonusCommon(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("BonusCommon");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(true);
		employeeNoField.setHidden(false);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		shouldBonusField = new DataSourceFloatField("shouldBonus", "应发奖金");
		shouldBonusField.setLength(18);
		shouldBonusField.setDecimalPad(2);
		shouldBonusField.setFormat("#,###,###,###,###,##0.00");
		shouldBonusField.setRequired(true);
		shouldBonusField.setHidden(true);


		shouldTaxField = new DataSourceFloatField("shouldTax", "应纳个税");
		shouldTaxField.setLength(18);
		shouldTaxField.setDecimalPad(2);
		shouldTaxField.setFormat("#,###,###,###,###,##0.00");
		shouldTaxField.setRequired(true);
		shouldTaxField.setHidden(true);


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
		otherBonusField.setRequired(false);
		otherBonusField.setHidden(true);


		projectBonusField = new DataSourceFloatField("projectBonus", "projectBonus");
		projectBonusField.setLength(18);
		projectBonusField.setDecimalPad(2);
		projectBonusField.setFormat("#,###,###,###,###,##0.00");
		projectBonusField.setRequired(true);
		projectBonusField.setHidden(true);


		salaryTypeField = new DataSourceIntegerField("salaryType", "类型（1.募投项目 2.研发项目）");
		salaryTypeField.setLength(11);
		salaryTypeField.setRequired(false);
		salaryTypeField.setHidden(true);


		fundraisingProjectTypeField = new DataSourceIntegerField("fundraisingProjectType", "募投项目类型");
		fundraisingProjectTypeField.setLength(11);
		fundraisingProjectTypeField.setRequired(false);
		fundraisingProjectTypeField.setHidden(true);


		fundraisingProjectRateField = new DataSourceFloatField("fundraisingProjectRate", "募投比例");
		fundraisingProjectRateField.setLength(32);
		fundraisingProjectRateField.setDecimalPad(2);
		fundraisingProjectRateField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		fundraisingProjectRateField.setRequired(false);
		fundraisingProjectRateField.setHidden(true);


		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程业务表Id");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);


		setFields(employeeIdField, employeeNoField, plateIdField, yearField, monthField, shouldBonusField, shouldTaxField, factBonusField, otherBonusField, projectBonusField, salaryTypeField, fundraisingProjectTypeField, fundraisingProjectRateField, personnelBusinessIdField);
	}


}

