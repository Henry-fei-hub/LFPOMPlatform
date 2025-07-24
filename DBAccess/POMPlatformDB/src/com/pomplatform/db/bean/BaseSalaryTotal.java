package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryTotal extends GenericBase implements BaseFactory<BaseSalaryTotal>, Comparable<BaseSalaryTotal> 
{


	public static BaseSalaryTotal newInstance(){
		return new BaseSalaryTotal();
	}

	@Override
	public BaseSalaryTotal make(){
		BaseSalaryTotal b = new BaseSalaryTotal();
		return b;
	}

	public final static java.lang.String CS_SALARY_TOTAL_ID = "salary_total_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_WORK_MONEY = "work_money" ;
	public final static java.lang.String CS_FILL_SEND_DEDUCT = "fill_send_deduct" ;
	public final static java.lang.String CS_JOB_SUBSIDY = "job_subsidy" ;
	public final static java.lang.String CS_ATTENDANCE_DEDUCT = "attendance_deduct" ;
	public final static java.lang.String CS_PERFORMANCE_PAY = "performance_pay" ;
	public final static java.lang.String CS_SHOULD_SALARY = "should_salary" ;
	public final static java.lang.String CS_SHOULD_BONUS = "should_bonus" ;
	public final static java.lang.String CS_SHOULD_TOTAL = "should_total" ;
	public final static java.lang.String CS_ALREADY_BONUS = "already_bonus" ;
	public final static java.lang.String CS_OTHER_BONUS = "other_bonus" ;
	public final static java.lang.String CS_TAX_BEGIN = "tax_begin" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE = "should_tax_achieve" ;
	public final static java.lang.String CS_TAX_TOTAL = "tax_total" ;
	public final static java.lang.String CS_DEDUCT_TAX = "deduct_tax" ;
	public final static java.lang.String CS_SHOULD_TAX = "should_tax" ;
	public final static java.lang.String CS_TOTAL_INSURANCE = "total_insurance" ;
	public final static java.lang.String CS_TOTAL_FUND = "total_fund" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_LEAVE_NO_DEDUCT_TAX = "leave_no_deduct_tax" ;
	public final static java.lang.String CS_LEAVE_DEDUCT_TAX = "leave_deduct_tax" ;
	public final static java.lang.String CS_FACT_SALARY = "fact_salary" ;
	public final static java.lang.String CS_AFFILIATED = "affiliated" ;
	public final static java.lang.String CS_VOTE_PROJECT = "vote_project" ;
	public final static java.lang.String CS_VOTE_PERCENT = "vote_percent" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_COST_ATTRIBUTION = "cost_attribution" ;
	public final static java.lang.String CS_DEVELOPMENT_PROJECT = "development_project" ;
	public final static java.lang.String CS_PERSONAL_PENSION = "personal_pension" ;
	public final static java.lang.String CS_PERSONAL_MEDICAL_INSURANCE = "personal_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_LARGE_MEDICAL_INSURANCE = "personal_large_medical_insurance" ;
	public final static java.lang.String CS_PERSONAL_UNEMPLOYMENT_INSURANCE = "personal_unemployment_insurance" ;
	public final static java.lang.String CS_PERSONAL_HEATING = "personal_heating" ;
	public final static java.lang.String CS_PERSONAL_SERIOUS_ILL_INSURANCE = "personal_serious_ill_insurance" ;
	public final static java.lang.String CS_SALARY_TYPE_NAME = "salary_type_name" ;
	public final static java.lang.String CS_SPECIAL_ADDITIONAL_DUDUCT = "special_additional_duduct" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_1 = "special_duduct_1" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_2 = "special_duduct_2" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_3 = "special_duduct_3" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_4 = "special_duduct_4" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_5 = "special_duduct_5" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_6 = "special_duduct_6" ;
	public final static java.lang.String CS_SPECIAL_DUDUCT_SUM = "special_duduct_sum" ;
	public final static java.lang.String CS_SHOULD_TAX_ACHIEVE_SUM = "should_tax_achieve_sum" ;
	public final static java.lang.String CS_INDIVIDUAL_INCOME_TAX_SUM = "individual_income_tax_sum" ;
	public final static java.lang.String CS_INSURANCE_FUND_SUM = "insurance_fund_sum" ;
	public final static java.lang.String CS_WITHHOLDING_TAX = "withholding_tax" ;
	public final static java.lang.String CS_REPLACEMENT_TAX = "replacement_tax" ;
	public final static java.lang.String CS_SUSPEND_BONUS = "suspend_bonus" ;
	public final static java.lang.String CS_OTHER_DEDUCTION = "other_deduction" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,员工编号,员工姓名,归属公司,业务部门,归属部门,银行账号,年份,月份,基本工资,工龄工资,补发补扣,岗位补贴,考勤扣款,绩效工资,应发工资,应发奖金,应发合计,已发奖金,其他奖金,个税起征点,应纳税所得,累计应纳税额（个税总额）,已扣个税,累计应纳税所得（应纳个税）,社保,公积金,单位社保,单位公积金,离职补偿不扣税,离职补偿扣税,实付工资,挂靠,募投项目,募投比例,代扣款项,代扣重疾,是否发放,操作人,操作时间,备注,费用归属(1IT人员,2管理人员,3设计人员,4研发人员,5营销人员),研发项目,养老保险（个人）,医疗保险（个人）,大额医疗保险（个人）,失业保险（个人）,采暖（个人）,大病医疗保险（个人）,工资类型名称,专项附加扣除,子女教育,继续教育,住房贷款利息,住房租金,赡养老人,大病医疗,累计专项附加扣除之和,累计应纳税所得,累计纳税起征点,累计社保公积金之和,累计已预缴纳税,补发个税,暂扣奖金,其他扣除";

	public java.lang.Integer getSalaryTotalId() {
		return this.__salary_total_id;
	}

	public void setSalaryTotalId( java.lang.Integer value ) {
		this.__salary_total_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.String getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.lang.String value ) {
		this.__month_basic_pay = value;
	}

	public java.lang.String getWorkMoney() {
		return this.__work_money;
	}

	public void setWorkMoney( java.lang.String value ) {
		this.__work_money = value;
	}

	public java.lang.String getFillSendDeduct() {
		return this.__fill_send_deduct;
	}

	public void setFillSendDeduct( java.lang.String value ) {
		this.__fill_send_deduct = value;
	}

	public java.lang.String getJobSubsidy() {
		return this.__job_subsidy;
	}

	public void setJobSubsidy( java.lang.String value ) {
		this.__job_subsidy = value;
	}

	public java.lang.String getAttendanceDeduct() {
		return this.__attendance_deduct;
	}

	public void setAttendanceDeduct( java.lang.String value ) {
		this.__attendance_deduct = value;
	}

	public java.lang.String getPerformancePay() {
		return this.__performance_pay;
	}

	public void setPerformancePay( java.lang.String value ) {
		this.__performance_pay = value;
	}

	public java.lang.String getShouldSalary() {
		return this.__should_salary;
	}

	public void setShouldSalary( java.lang.String value ) {
		this.__should_salary = value;
	}

	public java.lang.String getShouldBonus() {
		return this.__should_bonus;
	}

	public void setShouldBonus( java.lang.String value ) {
		this.__should_bonus = value;
	}

	public java.lang.String getShouldTotal() {
		return this.__should_total;
	}

	public void setShouldTotal( java.lang.String value ) {
		this.__should_total = value;
	}

	public java.lang.String getAlreadyBonus() {
		return this.__already_bonus;
	}

	public void setAlreadyBonus( java.lang.String value ) {
		this.__already_bonus = value;
	}

	public java.lang.String getOtherBonus() {
		return this.__other_bonus;
	}

	public void setOtherBonus( java.lang.String value ) {
		this.__other_bonus = value;
	}

	public java.math.BigDecimal getTaxBegin() {
		return this.__tax_begin;
	}

	public void setTaxBegin( java.math.BigDecimal value ) {
		this.__tax_begin = value;
	}

	public java.lang.String getShouldTaxAchieve() {
		return this.__should_tax_achieve;
	}

	public void setShouldTaxAchieve( java.lang.String value ) {
		this.__should_tax_achieve = value;
	}

	public java.lang.String getTaxTotal() {
		return this.__tax_total;
	}

	public void setTaxTotal( java.lang.String value ) {
		this.__tax_total = value;
	}

	public java.lang.String getDeductTax() {
		return this.__deduct_tax;
	}

	public void setDeductTax( java.lang.String value ) {
		this.__deduct_tax = value;
	}

	public java.lang.String getShouldTax() {
		return this.__should_tax;
	}

	public void setShouldTax( java.lang.String value ) {
		this.__should_tax = value;
	}

	public java.lang.String getTotalInsurance() {
		return this.__total_insurance;
	}

	public void setTotalInsurance( java.lang.String value ) {
		this.__total_insurance = value;
	}

	public java.lang.String getTotalFund() {
		return this.__total_fund;
	}

	public void setTotalFund( java.lang.String value ) {
		this.__total_fund = value;
	}

	public java.lang.String getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.lang.String value ) {
		this.__unit_total_insurance = value;
	}

	public java.lang.String getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.lang.String value ) {
		this.__unit_total_fund = value;
	}

	public java.lang.String getLeaveNoDeductTax() {
		return this.__leave_no_deduct_tax;
	}

	public void setLeaveNoDeductTax( java.lang.String value ) {
		this.__leave_no_deduct_tax = value;
	}

	public java.lang.String getLeaveDeductTax() {
		return this.__leave_deduct_tax;
	}

	public void setLeaveDeductTax( java.lang.String value ) {
		this.__leave_deduct_tax = value;
	}

	public java.lang.String getFactSalary() {
		return this.__fact_salary;
	}

	public void setFactSalary( java.lang.String value ) {
		this.__fact_salary = value;
	}

	public java.lang.Integer getAffiliated() {
		return this.__affiliated;
	}

	public void setAffiliated( java.lang.Integer value ) {
		this.__affiliated = value;
	}

	public java.lang.String getVoteProject() {
		return this.__vote_project;
	}

	public void setVoteProject( java.lang.String value ) {
		this.__vote_project = value;
	}

	public java.lang.String getVotePercent() {
		return this.__vote_percent;
	}

	public void setVotePercent( java.lang.String value ) {
		this.__vote_percent = value;
	}

	public java.lang.String getInsteadDeduct() {
		return this.__instead_deduct;
	}

	public void setInsteadDeduct( java.lang.String value ) {
		this.__instead_deduct = value;
	}

	public java.lang.String getInsteadDeductIll() {
		return this.__instead_deduct_ill;
	}

	public void setInsteadDeductIll( java.lang.String value ) {
		this.__instead_deduct_ill = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getCostAttribution() {
		return this.__cost_attribution;
	}

	public void setCostAttribution( java.lang.Integer value ) {
		this.__cost_attribution = value;
	}

	public java.lang.String getDevelopmentProject() {
		return this.__development_project;
	}

	public void setDevelopmentProject( java.lang.String value ) {
		this.__development_project = value;
	}

	public java.math.BigDecimal getPersonalPension() {
		return this.__personal_pension;
	}

	public void setPersonalPension( java.math.BigDecimal value ) {
		this.__personal_pension = value;
	}

	public java.math.BigDecimal getPersonalMedicalInsurance() {
		return this.__personal_medical_insurance;
	}

	public void setPersonalMedicalInsurance( java.math.BigDecimal value ) {
		this.__personal_medical_insurance = value;
	}

	public java.math.BigDecimal getPersonalLargeMedicalInsurance() {
		return this.__personal_large_medical_insurance;
	}

	public void setPersonalLargeMedicalInsurance( java.math.BigDecimal value ) {
		this.__personal_large_medical_insurance = value;
	}

	public java.math.BigDecimal getPersonalUnemploymentInsurance() {
		return this.__personal_unemployment_insurance;
	}

	public void setPersonalUnemploymentInsurance( java.math.BigDecimal value ) {
		this.__personal_unemployment_insurance = value;
	}

	public java.math.BigDecimal getPersonalHeating() {
		return this.__personal_heating;
	}

	public void setPersonalHeating( java.math.BigDecimal value ) {
		this.__personal_heating = value;
	}

	public java.math.BigDecimal getPersonalSeriousIllInsurance() {
		return this.__personal_serious_ill_insurance;
	}

	public void setPersonalSeriousIllInsurance( java.math.BigDecimal value ) {
		this.__personal_serious_ill_insurance = value;
	}

	public java.lang.String getSalaryTypeName() {
		return this.__salary_type_name;
	}

	public void setSalaryTypeName( java.lang.String value ) {
		this.__salary_type_name = value;
	}

	public java.math.BigDecimal getSpecialAdditionalDuduct() {
		return this.__special_additional_duduct;
	}

	public void setSpecialAdditionalDuduct( java.math.BigDecimal value ) {
		this.__special_additional_duduct = value;
	}

	public java.math.BigDecimal getSpecialDuduct1() {
		return this.__special_duduct_1;
	}

	public void setSpecialDuduct1( java.math.BigDecimal value ) {
		this.__special_duduct_1 = value;
	}

	public java.math.BigDecimal getSpecialDuduct2() {
		return this.__special_duduct_2;
	}

	public void setSpecialDuduct2( java.math.BigDecimal value ) {
		this.__special_duduct_2 = value;
	}

	public java.math.BigDecimal getSpecialDuduct3() {
		return this.__special_duduct_3;
	}

	public void setSpecialDuduct3( java.math.BigDecimal value ) {
		this.__special_duduct_3 = value;
	}

	public java.math.BigDecimal getSpecialDuduct4() {
		return this.__special_duduct_4;
	}

	public void setSpecialDuduct4( java.math.BigDecimal value ) {
		this.__special_duduct_4 = value;
	}

	public java.math.BigDecimal getSpecialDuduct5() {
		return this.__special_duduct_5;
	}

	public void setSpecialDuduct5( java.math.BigDecimal value ) {
		this.__special_duduct_5 = value;
	}

	public java.math.BigDecimal getSpecialDuduct6() {
		return this.__special_duduct_6;
	}

	public void setSpecialDuduct6( java.math.BigDecimal value ) {
		this.__special_duduct_6 = value;
	}

	public java.math.BigDecimal getSpecialDuductSum() {
		return this.__special_duduct_sum;
	}

	public void setSpecialDuductSum( java.math.BigDecimal value ) {
		this.__special_duduct_sum = value;
	}

	public java.lang.String getShouldTaxAchieveSum() {
		return this.__should_tax_achieve_sum;
	}

	public void setShouldTaxAchieveSum( java.lang.String value ) {
		this.__should_tax_achieve_sum = value;
	}

	public java.lang.String getIndividualIncomeTaxSum() {
		return this.__individual_income_tax_sum;
	}

	public void setIndividualIncomeTaxSum( java.lang.String value ) {
		this.__individual_income_tax_sum = value;
	}

	public java.lang.String getInsuranceFundSum() {
		return this.__insurance_fund_sum;
	}

	public void setInsuranceFundSum( java.lang.String value ) {
		this.__insurance_fund_sum = value;
	}

	public java.lang.String getWithholdingTax() {
		return this.__withholding_tax;
	}

	public void setWithholdingTax( java.lang.String value ) {
		this.__withholding_tax = value;
	}

	public java.lang.String getReplacementTax() {
		return this.__replacement_tax;
	}

	public void setReplacementTax( java.lang.String value ) {
		this.__replacement_tax = value;
	}

	public java.lang.String getSuspendBonus() {
		return this.__suspend_bonus;
	}

	public void setSuspendBonus( java.lang.String value ) {
		this.__suspend_bonus = value;
	}

	public java.lang.String getOtherDeduction() {
		return this.__other_deduction;
	}

	public void setOtherDeduction( java.lang.String value ) {
		this.__other_deduction = value;
	}

	public void cloneCopy(BaseSalaryTotal __bean){
		__bean.setSalaryTotalId(getSalaryTotalId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setBankAccount(getBankAccount());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setWorkMoney(getWorkMoney());
		__bean.setFillSendDeduct(getFillSendDeduct());
		__bean.setJobSubsidy(getJobSubsidy());
		__bean.setAttendanceDeduct(getAttendanceDeduct());
		__bean.setPerformancePay(getPerformancePay());
		__bean.setShouldSalary(getShouldSalary());
		__bean.setShouldBonus(getShouldBonus());
		__bean.setShouldTotal(getShouldTotal());
		__bean.setAlreadyBonus(getAlreadyBonus());
		__bean.setOtherBonus(getOtherBonus());
		__bean.setTaxBegin(getTaxBegin());
		__bean.setShouldTaxAchieve(getShouldTaxAchieve());
		__bean.setTaxTotal(getTaxTotal());
		__bean.setDeductTax(getDeductTax());
		__bean.setShouldTax(getShouldTax());
		__bean.setTotalInsurance(getTotalInsurance());
		__bean.setTotalFund(getTotalFund());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setLeaveNoDeductTax(getLeaveNoDeductTax());
		__bean.setLeaveDeductTax(getLeaveDeductTax());
		__bean.setFactSalary(getFactSalary());
		__bean.setAffiliated(getAffiliated());
		__bean.setVoteProject(getVoteProject());
		__bean.setVotePercent(getVotePercent());
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setIsSended(getIsSended());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setCostAttribution(getCostAttribution());
		__bean.setDevelopmentProject(getDevelopmentProject());
		__bean.setPersonalPension(getPersonalPension());
		__bean.setPersonalMedicalInsurance(getPersonalMedicalInsurance());
		__bean.setPersonalLargeMedicalInsurance(getPersonalLargeMedicalInsurance());
		__bean.setPersonalUnemploymentInsurance(getPersonalUnemploymentInsurance());
		__bean.setPersonalHeating(getPersonalHeating());
		__bean.setPersonalSeriousIllInsurance(getPersonalSeriousIllInsurance());
		__bean.setSalaryTypeName(getSalaryTypeName());
		__bean.setSpecialAdditionalDuduct(getSpecialAdditionalDuduct());
		__bean.setSpecialDuduct1(getSpecialDuduct1());
		__bean.setSpecialDuduct2(getSpecialDuduct2());
		__bean.setSpecialDuduct3(getSpecialDuduct3());
		__bean.setSpecialDuduct4(getSpecialDuduct4());
		__bean.setSpecialDuduct5(getSpecialDuduct5());
		__bean.setSpecialDuduct6(getSpecialDuduct6());
		__bean.setSpecialDuductSum(getSpecialDuductSum());
		__bean.setShouldTaxAchieveSum(getShouldTaxAchieveSum());
		__bean.setIndividualIncomeTaxSum(getIndividualIncomeTaxSum());
		__bean.setInsuranceFundSum(getInsuranceFundSum());
		__bean.setWithholdingTax(getWithholdingTax());
		__bean.setReplacementTax(getReplacementTax());
		__bean.setSuspendBonus(getSuspendBonus());
		__bean.setOtherDeduction(getOtherDeduction());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryTotalId() == null ? "" : getSalaryTotalId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getWorkMoney() == null ? "" : getWorkMoney());
		sb.append(",");
		sb.append(getFillSendDeduct() == null ? "" : getFillSendDeduct());
		sb.append(",");
		sb.append(getJobSubsidy() == null ? "" : getJobSubsidy());
		sb.append(",");
		sb.append(getAttendanceDeduct() == null ? "" : getAttendanceDeduct());
		sb.append(",");
		sb.append(getPerformancePay() == null ? "" : getPerformancePay());
		sb.append(",");
		sb.append(getShouldSalary() == null ? "" : getShouldSalary());
		sb.append(",");
		sb.append(getShouldBonus() == null ? "" : getShouldBonus());
		sb.append(",");
		sb.append(getShouldTotal() == null ? "" : getShouldTotal());
		sb.append(",");
		sb.append(getAlreadyBonus() == null ? "" : getAlreadyBonus());
		sb.append(",");
		sb.append(getOtherBonus() == null ? "" : getOtherBonus());
		sb.append(",");
		sb.append(getTaxBegin() == null ? "" : getTaxBegin());
		sb.append(",");
		sb.append(getShouldTaxAchieve() == null ? "" : getShouldTaxAchieve());
		sb.append(",");
		sb.append(getTaxTotal() == null ? "" : getTaxTotal());
		sb.append(",");
		sb.append(getDeductTax() == null ? "" : getDeductTax());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getLeaveNoDeductTax() == null ? "" : getLeaveNoDeductTax());
		sb.append(",");
		sb.append(getLeaveDeductTax() == null ? "" : getLeaveDeductTax());
		sb.append(",");
		sb.append(getFactSalary() == null ? "" : getFactSalary());
		sb.append(",");
		sb.append(getAffiliated() == null ? "" : getAffiliated());
		sb.append(",");
		sb.append(getVoteProject() == null ? "" : getVoteProject());
		sb.append(",");
		sb.append(getVotePercent() == null ? "" : getVotePercent());
		sb.append(",");
		sb.append(getInsteadDeduct() == null ? "" : getInsteadDeduct());
		sb.append(",");
		sb.append(getInsteadDeductIll() == null ? "" : getInsteadDeductIll());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getCostAttribution() == null ? "" : getCostAttribution());
		sb.append(",");
		sb.append(getDevelopmentProject() == null ? "" : getDevelopmentProject());
		sb.append(",");
		sb.append(getPersonalPension() == null ? "" : getPersonalPension());
		sb.append(",");
		sb.append(getPersonalMedicalInsurance() == null ? "" : getPersonalMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalLargeMedicalInsurance() == null ? "" : getPersonalLargeMedicalInsurance());
		sb.append(",");
		sb.append(getPersonalUnemploymentInsurance() == null ? "" : getPersonalUnemploymentInsurance());
		sb.append(",");
		sb.append(getPersonalHeating() == null ? "" : getPersonalHeating());
		sb.append(",");
		sb.append(getPersonalSeriousIllInsurance() == null ? "" : getPersonalSeriousIllInsurance());
		sb.append(",");
		sb.append(getSalaryTypeName() == null ? "" : getSalaryTypeName());
		sb.append(",");
		sb.append(getSpecialAdditionalDuduct() == null ? "" : getSpecialAdditionalDuduct());
		sb.append(",");
		sb.append(getSpecialDuduct1() == null ? "" : getSpecialDuduct1());
		sb.append(",");
		sb.append(getSpecialDuduct2() == null ? "" : getSpecialDuduct2());
		sb.append(",");
		sb.append(getSpecialDuduct3() == null ? "" : getSpecialDuduct3());
		sb.append(",");
		sb.append(getSpecialDuduct4() == null ? "" : getSpecialDuduct4());
		sb.append(",");
		sb.append(getSpecialDuduct5() == null ? "" : getSpecialDuduct5());
		sb.append(",");
		sb.append(getSpecialDuduct6() == null ? "" : getSpecialDuduct6());
		sb.append(",");
		sb.append(getSpecialDuductSum() == null ? "" : getSpecialDuductSum());
		sb.append(",");
		sb.append(getShouldTaxAchieveSum() == null ? "" : getShouldTaxAchieveSum());
		sb.append(",");
		sb.append(getIndividualIncomeTaxSum() == null ? "" : getIndividualIncomeTaxSum());
		sb.append(",");
		sb.append(getInsuranceFundSum() == null ? "" : getInsuranceFundSum());
		sb.append(",");
		sb.append(getWithholdingTax() == null ? "" : getWithholdingTax());
		sb.append(",");
		sb.append(getReplacementTax() == null ? "" : getReplacementTax());
		sb.append(",");
		sb.append(getSuspendBonus() == null ? "" : getSuspendBonus());
		sb.append(",");
		sb.append(getOtherDeduction() == null ? "" : getOtherDeduction());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryTotal o) {
		return __salary_total_id == null ? -1 : __salary_total_id.compareTo(o.getSalaryTotalId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_total_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__work_money);
		hash = 97 * hash + Objects.hashCode(this.__fill_send_deduct);
		hash = 97 * hash + Objects.hashCode(this.__job_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduct);
		hash = 97 * hash + Objects.hashCode(this.__performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__should_salary);
		hash = 97 * hash + Objects.hashCode(this.__should_bonus);
		hash = 97 * hash + Objects.hashCode(this.__should_total);
		hash = 97 * hash + Objects.hashCode(this.__already_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_bonus);
		hash = 97 * hash + Objects.hashCode(this.__tax_begin);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve);
		hash = 97 * hash + Objects.hashCode(this.__tax_total);
		hash = 97 * hash + Objects.hashCode(this.__deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__should_tax);
		hash = 97 * hash + Objects.hashCode(this.__total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__total_fund);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__leave_no_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__leave_deduct_tax);
		hash = 97 * hash + Objects.hashCode(this.__fact_salary);
		hash = 97 * hash + Objects.hashCode(this.__affiliated);
		hash = 97 * hash + Objects.hashCode(this.__vote_project);
		hash = 97 * hash + Objects.hashCode(this.__vote_percent);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__cost_attribution);
		hash = 97 * hash + Objects.hashCode(this.__development_project);
		hash = 97 * hash + Objects.hashCode(this.__personal_pension);
		hash = 97 * hash + Objects.hashCode(this.__personal_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_large_medical_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_unemployment_insurance);
		hash = 97 * hash + Objects.hashCode(this.__personal_heating);
		hash = 97 * hash + Objects.hashCode(this.__personal_serious_ill_insurance);
		hash = 97 * hash + Objects.hashCode(this.__salary_type_name);
		hash = 97 * hash + Objects.hashCode(this.__special_additional_duduct);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_1);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_2);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_3);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_4);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_5);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_6);
		hash = 97 * hash + Objects.hashCode(this.__special_duduct_sum);
		hash = 97 * hash + Objects.hashCode(this.__should_tax_achieve_sum);
		hash = 97 * hash + Objects.hashCode(this.__individual_income_tax_sum);
		hash = 97 * hash + Objects.hashCode(this.__insurance_fund_sum);
		hash = 97 * hash + Objects.hashCode(this.__withholding_tax);
		hash = 97 * hash + Objects.hashCode(this.__replacement_tax);
		hash = 97 * hash + Objects.hashCode(this.__suspend_bonus);
		hash = 97 * hash + Objects.hashCode(this.__other_deduction);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryTotal o = (BaseSalaryTotal)obj;
		if(!Objects.equals(this.__salary_total_id, o.getSalaryTotalId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__work_money, o.getWorkMoney())) return false;
		if(!Objects.equals(this.__fill_send_deduct, o.getFillSendDeduct())) return false;
		if(!Objects.equals(this.__job_subsidy, o.getJobSubsidy())) return false;
		if(!Objects.equals(this.__attendance_deduct, o.getAttendanceDeduct())) return false;
		if(!Objects.equals(this.__performance_pay, o.getPerformancePay())) return false;
		if(!Objects.equals(this.__should_salary, o.getShouldSalary())) return false;
		if(!Objects.equals(this.__should_bonus, o.getShouldBonus())) return false;
		if(!Objects.equals(this.__should_total, o.getShouldTotal())) return false;
		if(!Objects.equals(this.__already_bonus, o.getAlreadyBonus())) return false;
		if(!Objects.equals(this.__other_bonus, o.getOtherBonus())) return false;
		if(!Objects.equals(this.__tax_begin, o.getTaxBegin())) return false;
		if(!Objects.equals(this.__should_tax_achieve, o.getShouldTaxAchieve())) return false;
		if(!Objects.equals(this.__tax_total, o.getTaxTotal())) return false;
		if(!Objects.equals(this.__deduct_tax, o.getDeductTax())) return false;
		if(!Objects.equals(this.__should_tax, o.getShouldTax())) return false;
		if(!Objects.equals(this.__total_insurance, o.getTotalInsurance())) return false;
		if(!Objects.equals(this.__total_fund, o.getTotalFund())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__leave_no_deduct_tax, o.getLeaveNoDeductTax())) return false;
		if(!Objects.equals(this.__leave_deduct_tax, o.getLeaveDeductTax())) return false;
		if(!Objects.equals(this.__fact_salary, o.getFactSalary())) return false;
		if(!Objects.equals(this.__affiliated, o.getAffiliated())) return false;
		if(!Objects.equals(this.__vote_project, o.getVoteProject())) return false;
		if(!Objects.equals(this.__vote_percent, o.getVotePercent())) return false;
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__cost_attribution, o.getCostAttribution())) return false;
		if(!Objects.equals(this.__development_project, o.getDevelopmentProject())) return false;
		if(!Objects.equals(this.__personal_pension, o.getPersonalPension())) return false;
		if(!Objects.equals(this.__personal_medical_insurance, o.getPersonalMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_large_medical_insurance, o.getPersonalLargeMedicalInsurance())) return false;
		if(!Objects.equals(this.__personal_unemployment_insurance, o.getPersonalUnemploymentInsurance())) return false;
		if(!Objects.equals(this.__personal_heating, o.getPersonalHeating())) return false;
		if(!Objects.equals(this.__personal_serious_ill_insurance, o.getPersonalSeriousIllInsurance())) return false;
		if(!Objects.equals(this.__salary_type_name, o.getSalaryTypeName())) return false;
		if(!Objects.equals(this.__special_additional_duduct, o.getSpecialAdditionalDuduct())) return false;
		if(!Objects.equals(this.__special_duduct_1, o.getSpecialDuduct1())) return false;
		if(!Objects.equals(this.__special_duduct_2, o.getSpecialDuduct2())) return false;
		if(!Objects.equals(this.__special_duduct_3, o.getSpecialDuduct3())) return false;
		if(!Objects.equals(this.__special_duduct_4, o.getSpecialDuduct4())) return false;
		if(!Objects.equals(this.__special_duduct_5, o.getSpecialDuduct5())) return false;
		if(!Objects.equals(this.__special_duduct_6, o.getSpecialDuduct6())) return false;
		if(!Objects.equals(this.__special_duduct_sum, o.getSpecialDuductSum())) return false;
		if(!Objects.equals(this.__should_tax_achieve_sum, o.getShouldTaxAchieveSum())) return false;
		if(!Objects.equals(this.__individual_income_tax_sum, o.getIndividualIncomeTaxSum())) return false;
		if(!Objects.equals(this.__insurance_fund_sum, o.getInsuranceFundSum())) return false;
		if(!Objects.equals(this.__withholding_tax, o.getWithholdingTax())) return false;
		if(!Objects.equals(this.__replacement_tax, o.getReplacementTax())) return false;
		if(!Objects.equals(this.__suspend_bonus, o.getSuspendBonus())) return false;
		if(!Objects.equals(this.__other_deduction, o.getOtherDeduction())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryTotalId() != null) sb.append(__wrapNumber(count++, "salaryTotalId", getSalaryTotalId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getMonthBasicPay() != null) sb.append(__wrapString(count++, "monthBasicPay", getMonthBasicPay()));
		if(getWorkMoney() != null) sb.append(__wrapString(count++, "workMoney", getWorkMoney()));
		if(getFillSendDeduct() != null) sb.append(__wrapString(count++, "fillSendDeduct", getFillSendDeduct()));
		if(getJobSubsidy() != null) sb.append(__wrapString(count++, "jobSubsidy", getJobSubsidy()));
		if(getAttendanceDeduct() != null) sb.append(__wrapString(count++, "attendanceDeduct", getAttendanceDeduct()));
		if(getPerformancePay() != null) sb.append(__wrapString(count++, "performancePay", getPerformancePay()));
		if(getShouldSalary() != null) sb.append(__wrapString(count++, "shouldSalary", getShouldSalary()));
		if(getShouldBonus() != null) sb.append(__wrapString(count++, "shouldBonus", getShouldBonus()));
		if(getShouldTotal() != null) sb.append(__wrapString(count++, "shouldTotal", getShouldTotal()));
		if(getAlreadyBonus() != null) sb.append(__wrapString(count++, "alreadyBonus", getAlreadyBonus()));
		if(getOtherBonus() != null) sb.append(__wrapString(count++, "otherBonus", getOtherBonus()));
		if(getTaxBegin() != null) sb.append(__wrapDecimal(count++, "taxBegin", getTaxBegin()));
		if(getShouldTaxAchieve() != null) sb.append(__wrapString(count++, "shouldTaxAchieve", getShouldTaxAchieve()));
		if(getTaxTotal() != null) sb.append(__wrapString(count++, "taxTotal", getTaxTotal()));
		if(getDeductTax() != null) sb.append(__wrapString(count++, "deductTax", getDeductTax()));
		if(getShouldTax() != null) sb.append(__wrapString(count++, "shouldTax", getShouldTax()));
		if(getTotalInsurance() != null) sb.append(__wrapString(count++, "totalInsurance", getTotalInsurance()));
		if(getTotalFund() != null) sb.append(__wrapString(count++, "totalFund", getTotalFund()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapString(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getUnitTotalFund() != null) sb.append(__wrapString(count++, "unitTotalFund", getUnitTotalFund()));
		if(getLeaveNoDeductTax() != null) sb.append(__wrapString(count++, "leaveNoDeductTax", getLeaveNoDeductTax()));
		if(getLeaveDeductTax() != null) sb.append(__wrapString(count++, "leaveDeductTax", getLeaveDeductTax()));
		if(getFactSalary() != null) sb.append(__wrapString(count++, "factSalary", getFactSalary()));
		if(getAffiliated() != null) sb.append(__wrapNumber(count++, "affiliated", getAffiliated()));
		if(getVoteProject() != null) sb.append(__wrapString(count++, "voteProject", getVoteProject()));
		if(getVotePercent() != null) sb.append(__wrapString(count++, "votePercent", getVotePercent()));
		if(getInsteadDeduct() != null) sb.append(__wrapString(count++, "insteadDeduct", getInsteadDeduct()));
		if(getInsteadDeductIll() != null) sb.append(__wrapString(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getCostAttribution() != null) sb.append(__wrapNumber(count++, "costAttribution", getCostAttribution()));
		if(getDevelopmentProject() != null) sb.append(__wrapString(count++, "developmentProject", getDevelopmentProject()));
		if(getPersonalPension() != null) sb.append(__wrapDecimal(count++, "personalPension", getPersonalPension()));
		if(getPersonalMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalMedicalInsurance", getPersonalMedicalInsurance()));
		if(getPersonalLargeMedicalInsurance() != null) sb.append(__wrapDecimal(count++, "personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance()));
		if(getPersonalUnemploymentInsurance() != null) sb.append(__wrapDecimal(count++, "personalUnemploymentInsurance", getPersonalUnemploymentInsurance()));
		if(getPersonalHeating() != null) sb.append(__wrapDecimal(count++, "personalHeating", getPersonalHeating()));
		if(getPersonalSeriousIllInsurance() != null) sb.append(__wrapDecimal(count++, "personalSeriousIllInsurance", getPersonalSeriousIllInsurance()));
		if(getSalaryTypeName() != null) sb.append(__wrapString(count++, "salaryTypeName", getSalaryTypeName()));
		if(getSpecialAdditionalDuduct() != null) sb.append(__wrapDecimal(count++, "specialAdditionalDuduct", getSpecialAdditionalDuduct()));
		if(getSpecialDuduct1() != null) sb.append(__wrapDecimal(count++, "specialDuduct1", getSpecialDuduct1()));
		if(getSpecialDuduct2() != null) sb.append(__wrapDecimal(count++, "specialDuduct2", getSpecialDuduct2()));
		if(getSpecialDuduct3() != null) sb.append(__wrapDecimal(count++, "specialDuduct3", getSpecialDuduct3()));
		if(getSpecialDuduct4() != null) sb.append(__wrapDecimal(count++, "specialDuduct4", getSpecialDuduct4()));
		if(getSpecialDuduct5() != null) sb.append(__wrapDecimal(count++, "specialDuduct5", getSpecialDuduct5()));
		if(getSpecialDuduct6() != null) sb.append(__wrapDecimal(count++, "specialDuduct6", getSpecialDuduct6()));
		if(getSpecialDuductSum() != null) sb.append(__wrapDecimal(count++, "specialDuductSum", getSpecialDuductSum()));
		if(getShouldTaxAchieveSum() != null) sb.append(__wrapString(count++, "shouldTaxAchieveSum", getShouldTaxAchieveSum()));
		if(getIndividualIncomeTaxSum() != null) sb.append(__wrapString(count++, "individualIncomeTaxSum", getIndividualIncomeTaxSum()));
		if(getInsuranceFundSum() != null) sb.append(__wrapString(count++, "insuranceFundSum", getInsuranceFundSum()));
		if(getWithholdingTax() != null) sb.append(__wrapString(count++, "withholdingTax", getWithholdingTax()));
		if(getReplacementTax() != null) sb.append(__wrapString(count++, "replacementTax", getReplacementTax()));
		if(getSuspendBonus() != null) sb.append(__wrapString(count++, "suspendBonus", getSuspendBonus()));
		if(getOtherDeduction() != null) sb.append(__wrapString(count++, "otherDeduction", getOtherDeduction()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getSalaryTotalId() != null) res.put("salaryTotalId", getSalaryTotalId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getMonthBasicPay() != null) res.put("monthBasicPay", getMonthBasicPay());
		if(getWorkMoney() != null) res.put("workMoney", getWorkMoney());
		if(getFillSendDeduct() != null) res.put("fillSendDeduct", getFillSendDeduct());
		if(getJobSubsidy() != null) res.put("jobSubsidy", getJobSubsidy());
		if(getAttendanceDeduct() != null) res.put("attendanceDeduct", getAttendanceDeduct());
		if(getPerformancePay() != null) res.put("performancePay", getPerformancePay());
		if(getShouldSalary() != null) res.put("shouldSalary", getShouldSalary());
		if(getShouldBonus() != null) res.put("shouldBonus", getShouldBonus());
		if(getShouldTotal() != null) res.put("shouldTotal", getShouldTotal());
		if(getAlreadyBonus() != null) res.put("alreadyBonus", getAlreadyBonus());
		if(getOtherBonus() != null) res.put("otherBonus", getOtherBonus());
		if(getTaxBegin() != null) res.put("taxBegin", getTaxBegin());
		if(getShouldTaxAchieve() != null) res.put("shouldTaxAchieve", getShouldTaxAchieve());
		if(getTaxTotal() != null) res.put("taxTotal", getTaxTotal());
		if(getDeductTax() != null) res.put("deductTax", getDeductTax());
		if(getShouldTax() != null) res.put("shouldTax", getShouldTax());
		if(getTotalInsurance() != null) res.put("totalInsurance", getTotalInsurance());
		if(getTotalFund() != null) res.put("totalFund", getTotalFund());
		if(getUnitTotalInsurance() != null) res.put("unitTotalInsurance", getUnitTotalInsurance());
		if(getUnitTotalFund() != null) res.put("unitTotalFund", getUnitTotalFund());
		if(getLeaveNoDeductTax() != null) res.put("leaveNoDeductTax", getLeaveNoDeductTax());
		if(getLeaveDeductTax() != null) res.put("leaveDeductTax", getLeaveDeductTax());
		if(getFactSalary() != null) res.put("factSalary", getFactSalary());
		if(getAffiliated() != null) res.put("affiliated", getAffiliated());
		if(getVoteProject() != null) res.put("voteProject", getVoteProject());
		if(getVotePercent() != null) res.put("votePercent", getVotePercent());
		if(getInsteadDeduct() != null) res.put("insteadDeduct", getInsteadDeduct());
		if(getInsteadDeductIll() != null) res.put("insteadDeductIll", getInsteadDeductIll());
		if(getIsSended() != null) res.put("isSended", getIsSended());
		if(getOperateEmployeeId() != null) res.put("operateEmployeeId", getOperateEmployeeId());
		if(getOperateTime() != null) res.put("operateTime", getOperateTime());
		if(getRemark() != null) res.put("remark", getRemark());
		if(getCostAttribution() != null) res.put("costAttribution", getCostAttribution());
		if(getDevelopmentProject() != null) res.put("developmentProject", getDevelopmentProject());
		if(getPersonalPension() != null) res.put("personalPension", getPersonalPension());
		if(getPersonalMedicalInsurance() != null) res.put("personalMedicalInsurance", getPersonalMedicalInsurance());
		if(getPersonalLargeMedicalInsurance() != null) res.put("personalLargeMedicalInsurance", getPersonalLargeMedicalInsurance());
		if(getPersonalUnemploymentInsurance() != null) res.put("personalUnemploymentInsurance", getPersonalUnemploymentInsurance());
		if(getPersonalHeating() != null) res.put("personalHeating", getPersonalHeating());
		if(getPersonalSeriousIllInsurance() != null) res.put("personalSeriousIllInsurance", getPersonalSeriousIllInsurance());
		if(getSalaryTypeName() != null) res.put("salaryTypeName", getSalaryTypeName());
		if(getSpecialAdditionalDuduct() != null) res.put("specialAdditionalDuduct", getSpecialAdditionalDuduct());
		if(getSpecialDuduct1() != null) res.put("specialDuduct1", getSpecialDuduct1());
		if(getSpecialDuduct2() != null) res.put("specialDuduct2", getSpecialDuduct2());
		if(getSpecialDuduct3() != null) res.put("specialDuduct3", getSpecialDuduct3());
		if(getSpecialDuduct4() != null) res.put("specialDuduct4", getSpecialDuduct4());
		if(getSpecialDuduct5() != null) res.put("specialDuduct5", getSpecialDuduct5());
		if(getSpecialDuduct6() != null) res.put("specialDuduct6", getSpecialDuduct6());
		if(getSpecialDuductSum() != null) res.put("specialDuductSum", getSpecialDuductSum());
		if(getShouldTaxAchieveSum() != null) res.put("shouldTaxAchieveSum", getShouldTaxAchieveSum());
		if(getIndividualIncomeTaxSum() != null) res.put("individualIncomeTaxSum", getIndividualIncomeTaxSum());
		if(getInsuranceFundSum() != null) res.put("insuranceFundSum", getInsuranceFundSum());
		if(getWithholdingTax() != null) res.put("withholdingTax", getWithholdingTax());
		if(getReplacementTax() != null) res.put("replacementTax", getReplacementTax());
		if(getSuspendBonus() != null) res.put("suspendBonus", getSuspendBonus());
		if(getOtherDeduction() != null) res.put("otherDeduction", getOtherDeduction());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryTotalId")) != null) setSalaryTotalId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getString(val));
		if((val = values.get("workMoney")) != null) setWorkMoney(__getString(val));
		if((val = values.get("fillSendDeduct")) != null) setFillSendDeduct(__getString(val));
		if((val = values.get("jobSubsidy")) != null) setJobSubsidy(__getString(val));
		if((val = values.get("attendanceDeduct")) != null) setAttendanceDeduct(__getString(val));
		if((val = values.get("performancePay")) != null) setPerformancePay(__getString(val));
		if((val = values.get("shouldSalary")) != null) setShouldSalary(__getString(val));
		if((val = values.get("shouldBonus")) != null) setShouldBonus(__getString(val));
		if((val = values.get("shouldTotal")) != null) setShouldTotal(__getString(val));
		if((val = values.get("alreadyBonus")) != null) setAlreadyBonus(__getString(val));
		if((val = values.get("otherBonus")) != null) setOtherBonus(__getString(val));
		if((val = values.get("taxBegin")) != null) setTaxBegin(__getDecimal(val));  
		if((val = values.get("shouldTaxAchieve")) != null) setShouldTaxAchieve(__getString(val));
		if((val = values.get("taxTotal")) != null) setTaxTotal(__getString(val));
		if((val = values.get("deductTax")) != null) setDeductTax(__getString(val));
		if((val = values.get("shouldTax")) != null) setShouldTax(__getString(val));
		if((val = values.get("totalInsurance")) != null) setTotalInsurance(__getString(val));
		if((val = values.get("totalFund")) != null) setTotalFund(__getString(val));
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getString(val));
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getString(val));
		if((val = values.get("leaveNoDeductTax")) != null) setLeaveNoDeductTax(__getString(val));
		if((val = values.get("leaveDeductTax")) != null) setLeaveDeductTax(__getString(val));
		if((val = values.get("factSalary")) != null) setFactSalary(__getString(val));
		if((val = values.get("affiliated")) != null) setAffiliated(__getInt(val)); 
		if((val = values.get("voteProject")) != null) setVoteProject(__getString(val));
		if((val = values.get("votePercent")) != null) setVotePercent(__getString(val));
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getString(val));
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("costAttribution")) != null) setCostAttribution(__getInt(val)); 
		if((val = values.get("developmentProject")) != null) setDevelopmentProject(__getString(val));
		if((val = values.get("personalPension")) != null) setPersonalPension(__getDecimal(val));  
		if((val = values.get("personalMedicalInsurance")) != null) setPersonalMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalLargeMedicalInsurance")) != null) setPersonalLargeMedicalInsurance(__getDecimal(val));  
		if((val = values.get("personalUnemploymentInsurance")) != null) setPersonalUnemploymentInsurance(__getDecimal(val));  
		if((val = values.get("personalHeating")) != null) setPersonalHeating(__getDecimal(val));  
		if((val = values.get("personalSeriousIllInsurance")) != null) setPersonalSeriousIllInsurance(__getDecimal(val));  
		if((val = values.get("salaryTypeName")) != null) setSalaryTypeName(__getString(val));
		if((val = values.get("specialAdditionalDuduct")) != null) setSpecialAdditionalDuduct(__getDecimal(val));  
		if((val = values.get("specialDuduct1")) != null) setSpecialDuduct1(__getDecimal(val));  
		if((val = values.get("specialDuduct2")) != null) setSpecialDuduct2(__getDecimal(val));  
		if((val = values.get("specialDuduct3")) != null) setSpecialDuduct3(__getDecimal(val));  
		if((val = values.get("specialDuduct4")) != null) setSpecialDuduct4(__getDecimal(val));  
		if((val = values.get("specialDuduct5")) != null) setSpecialDuduct5(__getDecimal(val));  
		if((val = values.get("specialDuduct6")) != null) setSpecialDuduct6(__getDecimal(val));  
		if((val = values.get("specialDuductSum")) != null) setSpecialDuductSum(__getDecimal(val));  
		if((val = values.get("shouldTaxAchieveSum")) != null) setShouldTaxAchieveSum(__getString(val));
		if((val = values.get("individualIncomeTaxSum")) != null) setIndividualIncomeTaxSum(__getString(val));
		if((val = values.get("insuranceFundSum")) != null) setInsuranceFundSum(__getString(val));
		if((val = values.get("withholdingTax")) != null) setWithholdingTax(__getString(val));
		if((val = values.get("replacementTax")) != null) setReplacementTax(__getString(val));
		if((val = values.get("suspendBonus")) != null) setSuspendBonus(__getString(val));
		if((val = values.get("otherDeduction")) != null) setOtherDeduction(__getString(val));
	}

	protected java.lang.Integer  __salary_total_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.String  __bank_account ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.String  __month_basic_pay ;
	protected java.lang.String  __work_money ;
	protected java.lang.String  __fill_send_deduct ;
	protected java.lang.String  __job_subsidy ;
	protected java.lang.String  __attendance_deduct ;
	protected java.lang.String  __performance_pay ;
	protected java.lang.String  __should_salary ;
	protected java.lang.String  __should_bonus ;
	protected java.lang.String  __should_total ;
	protected java.lang.String  __already_bonus ;
	protected java.lang.String  __other_bonus ;
	protected java.math.BigDecimal  __tax_begin ;
	protected java.lang.String  __should_tax_achieve ;
	protected java.lang.String  __tax_total ;
	protected java.lang.String  __deduct_tax ;
	protected java.lang.String  __should_tax ;
	protected java.lang.String  __total_insurance ;
	protected java.lang.String  __total_fund ;
	protected java.lang.String  __unit_total_insurance ;
	protected java.lang.String  __unit_total_fund ;
	protected java.lang.String  __leave_no_deduct_tax ;
	protected java.lang.String  __leave_deduct_tax ;
	protected java.lang.String  __fact_salary ;
	protected java.lang.Integer  __affiliated ;
	protected java.lang.String  __vote_project ;
	protected java.lang.String  __vote_percent ;
	protected java.lang.String  __instead_deduct ;
	protected java.lang.String  __instead_deduct_ill ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __cost_attribution ;
	protected java.lang.String  __development_project ;
	protected java.math.BigDecimal  __personal_pension ;
	protected java.math.BigDecimal  __personal_medical_insurance ;
	protected java.math.BigDecimal  __personal_large_medical_insurance ;
	protected java.math.BigDecimal  __personal_unemployment_insurance ;
	protected java.math.BigDecimal  __personal_heating ;
	protected java.math.BigDecimal  __personal_serious_ill_insurance ;
	protected java.lang.String  __salary_type_name ;
	protected java.math.BigDecimal  __special_additional_duduct ;
	protected java.math.BigDecimal  __special_duduct_1 ;
	protected java.math.BigDecimal  __special_duduct_2 ;
	protected java.math.BigDecimal  __special_duduct_3 ;
	protected java.math.BigDecimal  __special_duduct_4 ;
	protected java.math.BigDecimal  __special_duduct_5 ;
	protected java.math.BigDecimal  __special_duduct_6 ;
	protected java.math.BigDecimal  __special_duduct_sum ;
	protected java.lang.String  __should_tax_achieve_sum ;
	protected java.lang.String  __individual_income_tax_sum ;
	protected java.lang.String  __insurance_fund_sum ;
	protected java.lang.String  __withholding_tax ;
	protected java.lang.String  __replacement_tax ;
	protected java.lang.String  __suspend_bonus ;
	protected java.lang.String  __other_deduction ;
}
