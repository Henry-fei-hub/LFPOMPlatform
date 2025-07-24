package pomplatform.payment.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseOnSalaryTotalData extends GenericBase implements BaseFactory<BaseOnSalaryTotalData>, Comparable<BaseOnSalaryTotalData> 
{


	public static BaseOnSalaryTotalData newInstance(){
		return new BaseOnSalaryTotalData();
	}

	@Override
	public BaseOnSalaryTotalData make(){
		BaseOnSalaryTotalData b = new BaseOnSalaryTotalData();
		return b;
	}

	public final static java.lang.String CS_SALARY_TOTAL_ID = "salary_total_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_MOBILE = "mobile" ;
	public final static java.lang.String CS_ONBOARD_STATUS = "onboard_status" ;
	public final static java.lang.String CS_ONBOARD_DATE = "onboard_date" ;
	public final static java.lang.String CS_POSITIVE_DATE = "positive_date" ;
	public final static java.lang.String CS_RESIGNATION_DATE = "resignation_date" ;
	public final static java.lang.String CS_GENDER = "gender" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
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
	public final static java.lang.String CS_INSTEAD_DEDUCT = "instead_deduct" ;
	public final static java.lang.String CS_INSTEAD_DEDUCT_ILL = "instead_deduct_ill" ;
	public final static java.lang.String CS_VOTE_PROJECT = "vote_project" ;
	public final static java.lang.String CS_VOTE_PERCENT = "vote_percent" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;
	public final static java.lang.String CS_COST_ATTRIBUTION = "cost_attribution" ;
	public final static java.lang.String CS_DEVELOPMENT_PROJECT = "development_project" ;
	public final static java.lang.String CS_CARD = "card" ;
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

	public final static java.lang.String ALL_CAPTIONS = "员工编号,员工姓名,性别,入职时间,转正时间,离职时间,身份证号码,手机号码,归属公司,业务部门,归属部门,年份,月份,应发工资,应发奖金,已发奖金,其他奖金,应纳税所得,个税总额,已扣个税,应纳个税,公积金,重疾险,养老保险（个人）,医疗保险（个人）,大额医疗保险（个人）,大病医疗保险（个人）,失业保险（个人）,采暖（个人）,社保合计,子女教育,继续教育,住房贷款利息,住房租金,赡养老人,大病医疗,当月专项扣除,累计专项扣除,暂扣奖金,其他扣除";
	public final static java.lang.String EXPORT_CAPTIONS = "员工编号,员工姓名,归属公司,业务部门,归属部门,手机,职员状态,入职日期,转正日期,离职日期,年份,月份,银行账号,基本工资,工龄工资,补发补扣,岗位补贴,考勤扣款,绩效工资,应发工资,应发奖金,应发合计,已发奖金,其他奖金,个税起征点,其他扣除,累计个税起征点,应纳税所得,累计应纳税所得,累计应纳税额,累计已预缴税额,已扣个税,暂扣奖金,累计应补(退)税额,社保,公积金,累计社保公积金,离职补偿不扣税,离职补偿扣税,代扣款项,重疾险,单位社保,单位公积金,本月专项附加扣除,累计专项附加扣除,应补退税,实付工资,募投项目,募投比例,费用归属,是否发放,工资类型名称";
	
	

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

	public java.lang.String getMobile() {
		return this.__mobile;
	}

	public void setMobile( java.lang.String value ) {
		this.__mobile = value;
	}

	public java.lang.Integer getOnboardStatus() {
		return this.__onboard_status;
	}

	public void setOnboardStatus( java.lang.Integer value ) {
		this.__onboard_status = value;
	}

	public java.util.Date getOnboardDate() {
		return this.__onboard_date;
	}

	public void setOnboardDate( java.util.Date value ) {
		this.__onboard_date = value;
	}

	public java.util.Date getPositiveDate() {
		return this.__positive_date;
	}

	public void setPositiveDate( java.util.Date value ) {
		this.__positive_date = value;
	}

	public java.util.Date getResignationDate() {
		return this.__resignation_date;
	}

	public void setResignationDate( java.util.Date value ) {
		this.__resignation_date = value;
	}

	public java.lang.Integer getGender() {
		return this.__gender;
	}

	public void setGender( java.lang.Integer value ) {
		this.__gender = value;
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

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
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

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
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

	public java.lang.String getCard() {
		return this.__card;
	}

	public void setCard( java.lang.String value ) {
		this.__card = value;
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

	public void cloneCopy(BaseOnSalaryTotalData __bean){
		__bean.setSalaryTotalId(getSalaryTotalId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCompanyId(getCompanyId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setMobile(getMobile());
		__bean.setOnboardStatus(getOnboardStatus());
		__bean.setOnboardDate(getOnboardDate());
		__bean.setPositiveDate(getPositiveDate());
		__bean.setResignationDate(getResignationDate());
		__bean.setGender(getGender());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setBankAccount(getBankAccount());
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
		__bean.setInsteadDeduct(getInsteadDeduct());
		__bean.setInsteadDeductIll(getInsteadDeductIll());
		__bean.setVoteProject(getVoteProject());
		__bean.setVotePercent(getVotePercent());
		__bean.setIsSended(getIsSended());
		__bean.setCostAttribution(getCostAttribution());
		__bean.setDevelopmentProject(getDevelopmentProject());
		__bean.setCard(getCard());
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

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getMobile() == null ? "" : getMobile()+"\t");
		sb.append(",");
		String strOnboardStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_96", String.valueOf(getOnboardStatus()));
		sb.append(strOnboardStatus == null ? "" : strOnboardStatus);
		sb.append(",");
		sb.append(getOnboardDate() == null ? "" : sdf.format(getOnboardDate()));
		sb.append(",");
		sb.append(getPositiveDate() == null ? "" : sdf.format(getPositiveDate()));
		sb.append(",");
		sb.append(getResignationDate() == null ? "" : sdf.format(getResignationDate()));
		sb.append(",");
/*		sb.append(getGender() == null ? "" : getGender());
		sb.append(",");*/
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount()+"\t");
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
		sb.append(getOtherDeduction() == null ? "" : getOtherDeduction());
		sb.append(",");
		sb.append(getIndividualIncomeTaxSum() == null ? "" : getIndividualIncomeTaxSum());
		sb.append(",");
		sb.append(getShouldTaxAchieve() == null ? "" : getShouldTaxAchieve());
		sb.append(",");
		sb.append(getShouldTaxAchieveSum() == null ? "" : getShouldTaxAchieveSum());
		sb.append(",");
		sb.append(getTaxTotal() == null ? "" : getTaxTotal());
		sb.append(",");
		sb.append(getWithholdingTax() == null ? "" : getWithholdingTax());
		sb.append(",");
		sb.append(getDeductTax() == null ? "" : getDeductTax());
		sb.append(",");
		sb.append(getSuspendBonus() == null ? "" : getSuspendBonus());
		sb.append(",");
		sb.append(getShouldTax() == null ? "" : getShouldTax());
		sb.append(",");
		sb.append(getTotalInsurance() == null ? "" : getTotalInsurance());
		sb.append(",");
		sb.append(getTotalFund() == null ? "" : getTotalFund());
		sb.append(",");
		sb.append(getInsuranceFundSum() == null ? "" : getInsuranceFundSum());
		sb.append(",");
		sb.append(getLeaveNoDeductTax() == null ? "" : getLeaveNoDeductTax());
		sb.append(",");
		sb.append(getLeaveDeductTax() == null ? "" : getLeaveDeductTax());
		sb.append(",");
		sb.append(getInsteadDeduct() == null ? "" : getInsteadDeduct());
		sb.append(",");
		sb.append(getInsteadDeductIll() == null ? "" : getInsteadDeductIll());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getSpecialAdditionalDuduct() == null ? "" : getSpecialAdditionalDuduct());
		sb.append(",");
		sb.append(getSpecialDuductSum() == null ? "" : getSpecialDuductSum());
		sb.append(",");
		sb.append(getReplacementTax() == null ? "" : getReplacementTax());
		sb.append(",");
		sb.append(getFactSalary() == null ? "" : getFactSalary());
		sb.append(",");
		sb.append(getVoteProject() == null ? "" : getVoteProject());
		sb.append(",");
		sb.append(getVotePercent() == null ? "" : getVotePercent());
		sb.append(",");
		String strCostAttribution = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_114", String.valueOf(getCostAttribution()));
		sb.append(strCostAttribution == null ? "" : strCostAttribution);
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		sb.append(",");
		sb.append(getSalaryTypeName() == null ? "" : getSalaryTypeName());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSalaryTotalData o) {
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
		hash = 97 * hash + Objects.hashCode(this.__mobile);
		hash = 97 * hash + Objects.hashCode(this.__onboard_status);
		hash = 97 * hash + Objects.hashCode(this.__onboard_date);
		hash = 97 * hash + Objects.hashCode(this.__positive_date);
		hash = 97 * hash + Objects.hashCode(this.__resignation_date);
		hash = 97 * hash + Objects.hashCode(this.__gender);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
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
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct);
		hash = 97 * hash + Objects.hashCode(this.__instead_deduct_ill);
		hash = 97 * hash + Objects.hashCode(this.__vote_project);
		hash = 97 * hash + Objects.hashCode(this.__vote_percent);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		hash = 97 * hash + Objects.hashCode(this.__cost_attribution);
		hash = 97 * hash + Objects.hashCode(this.__development_project);
		hash = 97 * hash + Objects.hashCode(this.__card);
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
		final BaseOnSalaryTotalData o = (BaseOnSalaryTotalData)obj;
		if(!Objects.equals(this.__salary_total_id, o.getSalaryTotalId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__mobile, o.getMobile())) return false;
		if(!Objects.equals(this.__onboard_status, o.getOnboardStatus())) return false;
		if(!Objects.equals(this.__onboard_date, o.getOnboardDate())) return false;
		if(!Objects.equals(this.__positive_date, o.getPositiveDate())) return false;
		if(!Objects.equals(this.__resignation_date, o.getResignationDate())) return false;
		if(!Objects.equals(this.__gender, o.getGender())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
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
		if(!Objects.equals(this.__instead_deduct, o.getInsteadDeduct())) return false;
		if(!Objects.equals(this.__instead_deduct_ill, o.getInsteadDeductIll())) return false;
		if(!Objects.equals(this.__vote_project, o.getVoteProject())) return false;
		if(!Objects.equals(this.__vote_percent, o.getVotePercent())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		if(!Objects.equals(this.__cost_attribution, o.getCostAttribution())) return false;
		if(!Objects.equals(this.__development_project, o.getDevelopmentProject())) return false;
		if(!Objects.equals(this.__card, o.getCard())) return false;
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
		if(getMobile() != null) sb.append(__wrapString(count++, "mobile", getMobile()));
		if(getOnboardStatus() != null) sb.append(__wrapNumber(count++, "onboardStatus", getOnboardStatus()));
		if(getOnboardDate() != null) sb.append(__wrapDate(count++, "onboardDate", getOnboardDate()));
		if(getPositiveDate() != null) sb.append(__wrapDate(count++, "positiveDate", getPositiveDate()));
		if(getResignationDate() != null) sb.append(__wrapDate(count++, "resignationDate", getResignationDate()));
		if(getGender() != null) sb.append(__wrapNumber(count++, "gender", getGender()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
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
		if(getInsteadDeduct() != null) sb.append(__wrapString(count++, "insteadDeduct", getInsteadDeduct()));
		if(getInsteadDeductIll() != null) sb.append(__wrapString(count++, "insteadDeductIll", getInsteadDeductIll()));
		if(getVoteProject() != null) sb.append(__wrapString(count++, "voteProject", getVoteProject()));
		if(getVotePercent() != null) sb.append(__wrapString(count++, "votePercent", getVotePercent()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		if(getCostAttribution() != null) sb.append(__wrapNumber(count++, "costAttribution", getCostAttribution()));
		if(getDevelopmentProject() != null) sb.append(__wrapString(count++, "developmentProject", getDevelopmentProject()));
		if(getCard() != null) sb.append(__wrapString(count++, "card", getCard()));
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
		if(getMobile() != null) res.put("mobile", getMobile());
		if(getOnboardStatus() != null) res.put("onboardStatus", getOnboardStatus());
		if(getOnboardDate() != null) res.put("onboardDate", getOnboardDate());
		if(getPositiveDate() != null) res.put("positiveDate", getPositiveDate());
		if(getResignationDate() != null) res.put("resignationDate", getResignationDate());
		if(getGender() != null) res.put("gender", getGender());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getBankAccount() != null) res.put("bankAccount", getBankAccount());
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
		if(getInsteadDeduct() != null) res.put("insteadDeduct", getInsteadDeduct());
		if(getInsteadDeductIll() != null) res.put("insteadDeductIll", getInsteadDeductIll());
		if(getVoteProject() != null) res.put("voteProject", getVoteProject());
		if(getVotePercent() != null) res.put("votePercent", getVotePercent());
		if(getIsSended() != null) res.put("isSended", getIsSended());
		if(getCostAttribution() != null) res.put("costAttribution", getCostAttribution());
		if(getDevelopmentProject() != null) res.put("developmentProject", getDevelopmentProject());
		if(getCard() != null) res.put("card", getCard());
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
		if((val = values.get("mobile")) != null) setMobile(__getString(val));
		if((val = values.get("onboardStatus")) != null) setOnboardStatus(__getInt(val)); 
		if((val = values.get("onboardDate")) != null) setOnboardDate(__getDate(val)); 
		if((val = values.get("positiveDate")) != null) setPositiveDate(__getDate(val)); 
		if((val = values.get("resignationDate")) != null) setResignationDate(__getDate(val)); 
		if((val = values.get("gender")) != null) setGender(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
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
		if((val = values.get("insteadDeduct")) != null) setInsteadDeduct(__getString(val));
		if((val = values.get("insteadDeductIll")) != null) setInsteadDeductIll(__getString(val));
		if((val = values.get("voteProject")) != null) setVoteProject(__getString(val));
		if((val = values.get("votePercent")) != null) setVotePercent(__getString(val));
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
		if((val = values.get("costAttribution")) != null) setCostAttribution(__getInt(val)); 
		if((val = values.get("developmentProject")) != null) setDevelopmentProject(__getString(val));
		if((val = values.get("card")) != null) setCard(__getString(val));
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
	protected java.lang.String  __mobile ;
	protected java.lang.Integer  __onboard_status ;
	protected java.util.Date  __onboard_date ;
	protected java.util.Date  __positive_date ;
	protected java.util.Date  __resignation_date ;
	protected java.lang.Integer  __gender ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.String  __bank_account ;
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
	protected java.lang.String  __instead_deduct ;
	protected java.lang.String  __instead_deduct_ill ;
	protected java.lang.String  __vote_project ;
	protected java.lang.String  __vote_percent ;
	protected java.lang.Boolean  __is_sended ;
	protected java.lang.Integer  __cost_attribution ;
	protected java.lang.String  __development_project ;
	protected java.lang.String  __card ;
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
