package com.pomplatform.client.payment.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

import java.util.LinkedHashMap;

public class DSSalaryCommon extends DBDataSource
{


	public static DSSalaryCommon instance = null;

	public static DSSalaryCommon getInstance() {
		if(instance == null) {
			instance = new DSSalaryCommon("DSSalaryCommon");
		}
		return instance;
	}

	private final DataSourceIntegerField employeeIdField;
	private final DataSourceTextField employeeNoField;
	private final DataSourceTextField employeeNameField;
	private final DataSourceIntegerField companyIdField;
	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField departmentIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField monthField;
	private final DataSourceTextField monthBasicPayField;
	private final DataSourceTextField workMoneyField;
	private final DataSourceTextField fillSendDeductField;
	private final DataSourceTextField jobSubsidyField;
	private final DataSourceTextField attendanceDeductField;
	private final DataSourceTextField performancePayField;
	private final DataSourceTextField shouldBonusField;
	private final DataSourceTextField shouldTotalField;
	private final DataSourceTextField alreadyBonusField;
	private final DataSourceTextField otherBonusField;
	private final DataSourceTextField shouldTaxAchieveField;
	private final DataSourceTextField taxTotalField;
	private final DataSourceTextField deductTaxField;
	private final DataSourceTextField totalInsuranceField;
	private final DataSourceTextField totalFundField;
	private final DataSourceTextField leaveDeductTaxField;
	private final DataSourceTextField insteadDeductField;
	private final DataSourceTextField insteadDeductIllField;
	private final DataSourceTextField unitTotalInsuranceField;
	private final DataSourceTextField unitTotalFundField;
	private final DataSourceTextField replacementTaxField;
	private final DataSourceTextField factSalaryField;
	private final DataSourceTextField leaveNoDeductTaxField;
	private final DataSourceIntegerField salaryTypeField;
	private final DataSourceIntegerField fundraisingProjectTypeField;
	private final DataSourceFloatField fundraisingProjectRateField;
	private final DataSourceIntegerField personnelBusinessIdField;

	public DSSalaryCommon(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("SalaryCommon");


		employeeIdField = new DataSourceIntegerField("employeeId", "员工姓名");
		employeeIdField.setLength(11);
		employeeIdField.setRequired(false);
		employeeIdField.setHidden(false);
		employeeIdField.setValueMap(KeyValueManager.getValueMap("employees"));


		employeeNoField = new DataSourceTextField("employeeNo", "员工编号");
		employeeNoField.setLength(64);
		employeeNoField.setRequired(false);
		employeeNoField.setHidden(false);


		employeeNameField = new DataSourceTextField("employeeName", "员工姓名");
		employeeNameField.setLength(64);
		employeeNameField.setRequired(false);
		employeeNameField.setHidden(false);
		employeeNameField.setHidden(true);

		companyIdField = new DataSourceIntegerField("companyId", "归属公司");
		companyIdField.setLength(11);
		companyIdField.setRequired(false);
		companyIdField.setHidden(true);


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(true);


		departmentIdField = new DataSourceIntegerField("departmentId", "归属部门");
		departmentIdField.setLength(11);
		departmentIdField.setRequired(false);
		departmentIdField.setHidden(true);
		departmentIdField.setValueMap(KeyValueManager.getValueMap("departments"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		monthField = new DataSourceIntegerField("month", "月份");
		monthField.setLength(11);
		monthField.setRequired(false);
		monthField.setHidden(false);


		monthBasicPayField = new DataSourceTextField("monthBasicPay", "基本工资");
		monthBasicPayField.setLength(64);
		monthBasicPayField.setRequired(false);
		monthBasicPayField.setHidden(true);


		workMoneyField = new DataSourceTextField("workMoney", "工龄工资");
		workMoneyField.setLength(64);
		workMoneyField.setRequired(false);
		workMoneyField.setHidden(true);


		fillSendDeductField = new DataSourceTextField("fillSendDeduct", "补发补扣");
		fillSendDeductField.setLength(64);
		fillSendDeductField.setRequired(false);
		fillSendDeductField.setHidden(true);


		jobSubsidyField = new DataSourceTextField("jobSubsidy", "岗位补贴");
		jobSubsidyField.setLength(64);
		jobSubsidyField.setRequired(false);
		jobSubsidyField.setHidden(true);


		attendanceDeductField = new DataSourceTextField("attendanceDeduct", "考勤扣款");
		attendanceDeductField.setLength(64);
		attendanceDeductField.setRequired(false);
		attendanceDeductField.setHidden(true);


		performancePayField = new DataSourceTextField("performancePay", "绩效工资");
		performancePayField.setLength(64);
		performancePayField.setRequired(false);
		performancePayField.setHidden(true);


		shouldBonusField = new DataSourceTextField("shouldBonus", "应发奖金");
		shouldBonusField.setLength(64);
		shouldBonusField.setRequired(false);
		shouldBonusField.setHidden(true);


		shouldTotalField = new DataSourceTextField("shouldTotal", "应发合计");
		shouldTotalField.setLength(64);
		shouldTotalField.setRequired(false);
		shouldTotalField.setHidden(true);


		alreadyBonusField = new DataSourceTextField("alreadyBonus", "已发奖金");
		alreadyBonusField.setLength(64);
		alreadyBonusField.setRequired(false);
		alreadyBonusField.setHidden(true);


		otherBonusField = new DataSourceTextField("otherBonus", "其他奖金");
		otherBonusField.setLength(64);
		otherBonusField.setRequired(false);
		otherBonusField.setHidden(true);


		shouldTaxAchieveField = new DataSourceTextField("shouldTaxAchieve", "应纳税所得");
		shouldTaxAchieveField.setLength(64);
		shouldTaxAchieveField.setRequired(false);
		shouldTaxAchieveField.setHidden(true);


		taxTotalField = new DataSourceTextField("taxTotal", "累计应纳税额（个税总额）");
		taxTotalField.setLength(64);
		taxTotalField.setRequired(false);
		taxTotalField.setHidden(true);


		deductTaxField = new DataSourceTextField("deductTax", "已扣个税");
		deductTaxField.setLength(64);
		deductTaxField.setRequired(false);
		deductTaxField.setHidden(true);


		totalInsuranceField = new DataSourceTextField("totalInsurance", "社保");
		totalInsuranceField.setLength(64);
		totalInsuranceField.setRequired(false);
		totalInsuranceField.setHidden(true);


		totalFundField = new DataSourceTextField("totalFund", "公积金");
		totalFundField.setLength(64);
		totalFundField.setRequired(false);
		totalFundField.setHidden(true);


		leaveDeductTaxField = new DataSourceTextField("leaveDeductTax", "离职补偿扣税");
		leaveDeductTaxField.setLength(64);
		leaveDeductTaxField.setRequired(false);
		leaveDeductTaxField.setHidden(true);


		insteadDeductField = new DataSourceTextField("insteadDeduct", "代扣款项");
		insteadDeductField.setLength(64);
		insteadDeductField.setRequired(false);
		insteadDeductField.setHidden(true);


		insteadDeductIllField = new DataSourceTextField("insteadDeductIll", "代扣重疾");
		insteadDeductIllField.setLength(64);
		insteadDeductIllField.setRequired(false);
		insteadDeductIllField.setHidden(true);


		unitTotalInsuranceField = new DataSourceTextField("unitTotalInsurance", "单位社保");
		unitTotalInsuranceField.setLength(64);
		unitTotalInsuranceField.setRequired(false);
		unitTotalInsuranceField.setHidden(true);


		unitTotalFundField = new DataSourceTextField("unitTotalFund", "单位公积金");
		unitTotalFundField.setLength(64);
		unitTotalFundField.setRequired(false);
		unitTotalFundField.setHidden(true);


		replacementTaxField = new DataSourceTextField("replacementTax", "补发个税");
		replacementTaxField.setLength(64);
		replacementTaxField.setRequired(false);
		replacementTaxField.setHidden(true);


		factSalaryField = new DataSourceTextField("factSalary", "实付工资");
		factSalaryField.setLength(64);
		factSalaryField.setRequired(false);
		factSalaryField.setHidden(false);

		leaveNoDeductTaxField = new DataSourceTextField("leaveNoDeductTax", "离职补偿不扣税");
		leaveNoDeductTaxField.setLength(64);
		leaveNoDeductTaxField.setRequired(false);
		leaveNoDeductTaxField.setHidden(true);


		salaryTypeField = new DataSourceIntegerField("salaryType", "类型");
		salaryTypeField.setLength(11);
		salaryTypeField.setRequired(false);
		salaryTypeField.setHidden(false);
		LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
		map.put(0, "非募投项目");
		map.put(1, "募投项目");
		salaryTypeField.setValueMap(map);


		fundraisingProjectTypeField = new DataSourceIntegerField("fundraisingProjectType", "募投项目类型");
		fundraisingProjectTypeField.setLength(11);
		fundraisingProjectTypeField.setRequired(false);
		fundraisingProjectTypeField.setHidden(false);
		fundraisingProjectTypeField.setValueMap(KeyValueManager.getValueMap("fundraising_project_types"));


		fundraisingProjectRateField = new DataSourceFloatField("fundraisingProjectRate", "发放比例(%)");
		fundraisingProjectRateField.setLength(32);
		fundraisingProjectRateField.setDecimalPad(2);
		fundraisingProjectRateField.setFormat("###,###,###,###,###,###,###,###,###,##0.00");
		fundraisingProjectRateField.setRequired(false);
		fundraisingProjectRateField.setHidden(false);
		fundraisingProjectRateField.setCanEdit(true);

		personnelBusinessIdField = new DataSourceIntegerField("personnelBusinessId", "流程业务表Id");
		personnelBusinessIdField.setLength(11);
		personnelBusinessIdField.setRequired(false);
		personnelBusinessIdField.setHidden(true);

		setFields(employeeIdField, employeeNoField, employeeNameField, companyIdField, plateIdField, departmentIdField, yearField, monthField, monthBasicPayField, workMoneyField, fillSendDeductField, jobSubsidyField, attendanceDeductField, performancePayField, shouldBonusField, shouldTotalField, alreadyBonusField, otherBonusField, shouldTaxAchieveField, taxTotalField, deductTaxField, totalInsuranceField, totalFundField, leaveDeductTaxField, insteadDeductField, insteadDeductIllField, unitTotalInsuranceField, unitTotalFundField, replacementTaxField, factSalaryField, leaveNoDeductTaxField, salaryTypeField, fundraisingProjectTypeField, fundraisingProjectRateField, personnelBusinessIdField);
	}


}

