package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeSalaryDetail extends GenericBase implements BaseFactory<BaseEmployeeSalaryDetail>, Comparable<BaseEmployeeSalaryDetail> 
{


	public static BaseEmployeeSalaryDetail newInstance(){
		return new BaseEmployeeSalaryDetail();
	}

	@Override
	public BaseEmployeeSalaryDetail make(){
		BaseEmployeeSalaryDetail b = new BaseEmployeeSalaryDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_SALARY_DETAIL_ID = "employee_salary_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_ENTRY_DATE = "entry_date" ;
	public final static java.lang.String CS_POSITIVE_DATE = "positive_date" ;
	public final static java.lang.String CS_ALL_SALARY = "all_salary" ;
	public final static java.lang.String CS_BASIC_PROPORTION = "basic_proportion" ;
	public final static java.lang.String CS_PERFORMANCE_BONUS = "performance_bonus" ;
	public final static java.lang.String CS_BASIC_SALARY = "basic_salary" ;
	public final static java.lang.String CS_WORK_SUBSIDIES = "work_subsidies" ;
	public final static java.lang.String CS_WORK_YEAR_SALARY = "work_year_salary" ;
	public final static java.lang.String CS_ANOTHER_PLACE_SUBSIDIES = "another_place_subsidies" ;
	public final static java.lang.String CS_DEDUCT_SALARY = "deduct_salary" ;
	public final static java.lang.String CS_POSITIVE_ACCOUNT = "positive_account" ;
	public final static java.lang.String CS_SHOULD_PAY_SALARY = "should_pay_salary" ;
	public final static java.lang.String CS_LAST_MONTH_ACHIEVEMENT_EFFECT = "last_month_achievement_effect" ;
	public final static java.lang.String CS_PROJECT_BONUS = "project_bonus" ;
	public final static java.lang.String CS_TAXABLE_INCOME = "taxable_income" ;
	public final static java.lang.String CS_INCOME_TOTAL = "income_total" ;
	public final static java.lang.String CS_DEDUCT_INCOME = "deduct_income" ;
	public final static java.lang.String CS_SHOULD_PAY_INCOME = "should_pay_income" ;
	public final static java.lang.String CS_SOCIAL_SECURITY = "social_security" ;
	public final static java.lang.String CS_RESERVED_FUNDS = "reserved_funds" ;
	public final static java.lang.String CS_WITHHOLD_BORROW = "withhold_borrow" ;
	public final static java.lang.String CS_LEAVE_SUBSIDIES = "leave_subsidies" ;
	public final static java.lang.String CS_FACT_PAY_SALARY = "fact_pay_salary" ;
	public final static java.lang.String CS_UNIT_SOCIAL_SECURITY = "unit_social_security" ;
	public final static java.lang.String CS_SECRET_KEY = "secret_key" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_SALARY_YEAR = "salary_year" ;
	public final static java.lang.String CS_SALARY_MONTH = "salary_month" ;
	public final static java.lang.String CS_IS_RETURN = "is_return" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,入职日期,全薪,转正日期,基本比例,绩效奖金,基本工资,工地补助,工龄工资,异地补发,扣病事假迟到,转正核算,应发工资,上月绩效,项目奖,应纳税所得,个税总额,已扣个税,应纳个税,社保,公积金,代扣借款,离职补偿,实付工资,单位社保,秘钥,银行账号,年份,月份,积分是否回收的标识，true回收； false不回收";

	public java.lang.Integer getEmployeeSalaryDetailId() {
		return this.__employee_salary_detail_id;
	}

	public void setEmployeeSalaryDetailId( java.lang.Integer value ) {
		this.__employee_salary_detail_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getEntryDate() {
		return this.__entry_date;
	}

	public void setEntryDate( java.util.Date value ) {
		this.__entry_date = value;
	}

	public java.util.Date getPositiveDate() {
		return this.__positive_date;
	}

	public void setPositiveDate( java.util.Date value ) {
		this.__positive_date = value;
	}

	public java.lang.String getAllSalary() {
		return this.__all_salary;
	}

	public void setAllSalary( java.lang.String value ) {
		this.__all_salary = value;
	}

	public java.lang.String getBasicProportion() {
		return this.__basic_proportion;
	}

	public void setBasicProportion( java.lang.String value ) {
		this.__basic_proportion = value;
	}

	public java.lang.String getPerformanceBonus() {
		return this.__performance_bonus;
	}

	public void setPerformanceBonus( java.lang.String value ) {
		this.__performance_bonus = value;
	}

	public java.lang.String getBasicSalary() {
		return this.__basic_salary;
	}

	public void setBasicSalary( java.lang.String value ) {
		this.__basic_salary = value;
	}

	public java.lang.String getWorkSubsidies() {
		return this.__work_subsidies;
	}

	public void setWorkSubsidies( java.lang.String value ) {
		this.__work_subsidies = value;
	}

	public java.lang.String getWorkYearSalary() {
		return this.__work_year_salary;
	}

	public void setWorkYearSalary( java.lang.String value ) {
		this.__work_year_salary = value;
	}

	public java.lang.String getAnotherPlaceSubsidies() {
		return this.__another_place_subsidies;
	}

	public void setAnotherPlaceSubsidies( java.lang.String value ) {
		this.__another_place_subsidies = value;
	}

	public java.lang.String getDeductSalary() {
		return this.__deduct_salary;
	}

	public void setDeductSalary( java.lang.String value ) {
		this.__deduct_salary = value;
	}

	public java.lang.String getPositiveAccount() {
		return this.__positive_account;
	}

	public void setPositiveAccount( java.lang.String value ) {
		this.__positive_account = value;
	}

	public java.lang.String getShouldPaySalary() {
		return this.__should_pay_salary;
	}

	public void setShouldPaySalary( java.lang.String value ) {
		this.__should_pay_salary = value;
	}

	public java.lang.String getLastMonthAchievementEffect() {
		return this.__last_month_achievement_effect;
	}

	public void setLastMonthAchievementEffect( java.lang.String value ) {
		this.__last_month_achievement_effect = value;
	}

	public java.lang.String getProjectBonus() {
		return this.__project_bonus;
	}

	public void setProjectBonus( java.lang.String value ) {
		this.__project_bonus = value;
	}

	public java.lang.String getTaxableIncome() {
		return this.__taxable_income;
	}

	public void setTaxableIncome( java.lang.String value ) {
		this.__taxable_income = value;
	}

	public java.lang.String getIncomeTotal() {
		return this.__income_total;
	}

	public void setIncomeTotal( java.lang.String value ) {
		this.__income_total = value;
	}

	public java.lang.String getDeductIncome() {
		return this.__deduct_income;
	}

	public void setDeductIncome( java.lang.String value ) {
		this.__deduct_income = value;
	}

	public java.lang.String getShouldPayIncome() {
		return this.__should_pay_income;
	}

	public void setShouldPayIncome( java.lang.String value ) {
		this.__should_pay_income = value;
	}

	public java.lang.String getSocialSecurity() {
		return this.__social_security;
	}

	public void setSocialSecurity( java.lang.String value ) {
		this.__social_security = value;
	}

	public java.lang.String getReservedFunds() {
		return this.__reserved_funds;
	}

	public void setReservedFunds( java.lang.String value ) {
		this.__reserved_funds = value;
	}

	public java.lang.String getWithholdBorrow() {
		return this.__withhold_borrow;
	}

	public void setWithholdBorrow( java.lang.String value ) {
		this.__withhold_borrow = value;
	}

	public java.lang.String getLeaveSubsidies() {
		return this.__leave_subsidies;
	}

	public void setLeaveSubsidies( java.lang.String value ) {
		this.__leave_subsidies = value;
	}

	public java.lang.String getFactPaySalary() {
		return this.__fact_pay_salary;
	}

	public void setFactPaySalary( java.lang.String value ) {
		this.__fact_pay_salary = value;
	}

	public java.lang.String getUnitSocialSecurity() {
		return this.__unit_social_security;
	}

	public void setUnitSocialSecurity( java.lang.String value ) {
		this.__unit_social_security = value;
	}

	public java.lang.String getSecretKey() {
		return this.__secret_key;
	}

	public void setSecretKey( java.lang.String value ) {
		this.__secret_key = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.Integer getSalaryYear() {
		return this.__salary_year;
	}

	public void setSalaryYear( java.lang.Integer value ) {
		this.__salary_year = value;
	}

	public java.lang.Integer getSalaryMonth() {
		return this.__salary_month;
	}

	public void setSalaryMonth( java.lang.Integer value ) {
		this.__salary_month = value;
	}

	public java.lang.Boolean getIsReturn() {
		return this.__is_return;
	}

	public void setIsReturn( java.lang.Boolean value ) {
		this.__is_return = value;
	}

	public void cloneCopy(BaseEmployeeSalaryDetail __bean){
		__bean.setEmployeeSalaryDetailId(getEmployeeSalaryDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEntryDate(getEntryDate());
		__bean.setPositiveDate(getPositiveDate());
		__bean.setAllSalary(getAllSalary());
		__bean.setBasicProportion(getBasicProportion());
		__bean.setPerformanceBonus(getPerformanceBonus());
		__bean.setBasicSalary(getBasicSalary());
		__bean.setWorkSubsidies(getWorkSubsidies());
		__bean.setWorkYearSalary(getWorkYearSalary());
		__bean.setAnotherPlaceSubsidies(getAnotherPlaceSubsidies());
		__bean.setDeductSalary(getDeductSalary());
		__bean.setPositiveAccount(getPositiveAccount());
		__bean.setShouldPaySalary(getShouldPaySalary());
		__bean.setLastMonthAchievementEffect(getLastMonthAchievementEffect());
		__bean.setProjectBonus(getProjectBonus());
		__bean.setTaxableIncome(getTaxableIncome());
		__bean.setIncomeTotal(getIncomeTotal());
		__bean.setDeductIncome(getDeductIncome());
		__bean.setShouldPayIncome(getShouldPayIncome());
		__bean.setSocialSecurity(getSocialSecurity());
		__bean.setReservedFunds(getReservedFunds());
		__bean.setWithholdBorrow(getWithholdBorrow());
		__bean.setLeaveSubsidies(getLeaveSubsidies());
		__bean.setFactPaySalary(getFactPaySalary());
		__bean.setUnitSocialSecurity(getUnitSocialSecurity());
		__bean.setSecretKey(getSecretKey());
		__bean.setBankAccount(getBankAccount());
		__bean.setSalaryYear(getSalaryYear());
		__bean.setSalaryMonth(getSalaryMonth());
		__bean.setIsReturn(getIsReturn());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeSalaryDetailId() == null ? "" : getEmployeeSalaryDetailId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEntryDate() == null ? "" : sdf.format(getEntryDate()));
		sb.append(",");
		sb.append(getPositiveDate() == null ? "" : sdf.format(getPositiveDate()));
		sb.append(",");
		sb.append(getAllSalary() == null ? "" : getAllSalary());
		sb.append(",");
		sb.append(getBasicProportion() == null ? "" : getBasicProportion());
		sb.append(",");
		sb.append(getPerformanceBonus() == null ? "" : getPerformanceBonus());
		sb.append(",");
		sb.append(getBasicSalary() == null ? "" : getBasicSalary());
		sb.append(",");
		sb.append(getWorkSubsidies() == null ? "" : getWorkSubsidies());
		sb.append(",");
		sb.append(getWorkYearSalary() == null ? "" : getWorkYearSalary());
		sb.append(",");
		sb.append(getAnotherPlaceSubsidies() == null ? "" : getAnotherPlaceSubsidies());
		sb.append(",");
		sb.append(getDeductSalary() == null ? "" : getDeductSalary());
		sb.append(",");
		sb.append(getPositiveAccount() == null ? "" : getPositiveAccount());
		sb.append(",");
		sb.append(getShouldPaySalary() == null ? "" : getShouldPaySalary());
		sb.append(",");
		sb.append(getLastMonthAchievementEffect() == null ? "" : getLastMonthAchievementEffect());
		sb.append(",");
		sb.append(getProjectBonus() == null ? "" : getProjectBonus());
		sb.append(",");
		sb.append(getTaxableIncome() == null ? "" : getTaxableIncome());
		sb.append(",");
		sb.append(getIncomeTotal() == null ? "" : getIncomeTotal());
		sb.append(",");
		sb.append(getDeductIncome() == null ? "" : getDeductIncome());
		sb.append(",");
		sb.append(getShouldPayIncome() == null ? "" : getShouldPayIncome());
		sb.append(",");
		sb.append(getSocialSecurity() == null ? "" : getSocialSecurity());
		sb.append(",");
		sb.append(getReservedFunds() == null ? "" : getReservedFunds());
		sb.append(",");
		sb.append(getWithholdBorrow() == null ? "" : getWithholdBorrow());
		sb.append(",");
		sb.append(getLeaveSubsidies() == null ? "" : getLeaveSubsidies());
		sb.append(",");
		sb.append(getFactPaySalary() == null ? "" : getFactPaySalary());
		sb.append(",");
		sb.append(getUnitSocialSecurity() == null ? "" : getUnitSocialSecurity());
		sb.append(",");
		sb.append(getSecretKey() == null ? "" : getSecretKey());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		String strSalaryYear = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getSalaryYear()));
		sb.append(strSalaryYear == null ? "" : strSalaryYear);
		sb.append(",");
		sb.append(getSalaryMonth() == null ? "" : getSalaryMonth());
		sb.append(",");
		sb.append(getIsReturn() == null ? "" : getIsReturn());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeSalaryDetail o) {
		return __employee_salary_detail_id == null ? -1 : __employee_salary_detail_id.compareTo(o.getEmployeeSalaryDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_salary_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__entry_date);
		hash = 97 * hash + Objects.hashCode(this.__positive_date);
		hash = 97 * hash + Objects.hashCode(this.__all_salary);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion);
		hash = 97 * hash + Objects.hashCode(this.__performance_bonus);
		hash = 97 * hash + Objects.hashCode(this.__basic_salary);
		hash = 97 * hash + Objects.hashCode(this.__work_subsidies);
		hash = 97 * hash + Objects.hashCode(this.__work_year_salary);
		hash = 97 * hash + Objects.hashCode(this.__another_place_subsidies);
		hash = 97 * hash + Objects.hashCode(this.__deduct_salary);
		hash = 97 * hash + Objects.hashCode(this.__positive_account);
		hash = 97 * hash + Objects.hashCode(this.__should_pay_salary);
		hash = 97 * hash + Objects.hashCode(this.__last_month_achievement_effect);
		hash = 97 * hash + Objects.hashCode(this.__project_bonus);
		hash = 97 * hash + Objects.hashCode(this.__taxable_income);
		hash = 97 * hash + Objects.hashCode(this.__income_total);
		hash = 97 * hash + Objects.hashCode(this.__deduct_income);
		hash = 97 * hash + Objects.hashCode(this.__should_pay_income);
		hash = 97 * hash + Objects.hashCode(this.__social_security);
		hash = 97 * hash + Objects.hashCode(this.__reserved_funds);
		hash = 97 * hash + Objects.hashCode(this.__withhold_borrow);
		hash = 97 * hash + Objects.hashCode(this.__leave_subsidies);
		hash = 97 * hash + Objects.hashCode(this.__fact_pay_salary);
		hash = 97 * hash + Objects.hashCode(this.__unit_social_security);
		hash = 97 * hash + Objects.hashCode(this.__secret_key);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__salary_year);
		hash = 97 * hash + Objects.hashCode(this.__salary_month);
		hash = 97 * hash + Objects.hashCode(this.__is_return);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeSalaryDetail o = (BaseEmployeeSalaryDetail)obj;
		if(!Objects.equals(this.__employee_salary_detail_id, o.getEmployeeSalaryDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__entry_date, o.getEntryDate())) return false;
		if(!Objects.equals(this.__positive_date, o.getPositiveDate())) return false;
		if(!Objects.equals(this.__all_salary, o.getAllSalary())) return false;
		if(!Objects.equals(this.__basic_proportion, o.getBasicProportion())) return false;
		if(!Objects.equals(this.__performance_bonus, o.getPerformanceBonus())) return false;
		if(!Objects.equals(this.__basic_salary, o.getBasicSalary())) return false;
		if(!Objects.equals(this.__work_subsidies, o.getWorkSubsidies())) return false;
		if(!Objects.equals(this.__work_year_salary, o.getWorkYearSalary())) return false;
		if(!Objects.equals(this.__another_place_subsidies, o.getAnotherPlaceSubsidies())) return false;
		if(!Objects.equals(this.__deduct_salary, o.getDeductSalary())) return false;
		if(!Objects.equals(this.__positive_account, o.getPositiveAccount())) return false;
		if(!Objects.equals(this.__should_pay_salary, o.getShouldPaySalary())) return false;
		if(!Objects.equals(this.__last_month_achievement_effect, o.getLastMonthAchievementEffect())) return false;
		if(!Objects.equals(this.__project_bonus, o.getProjectBonus())) return false;
		if(!Objects.equals(this.__taxable_income, o.getTaxableIncome())) return false;
		if(!Objects.equals(this.__income_total, o.getIncomeTotal())) return false;
		if(!Objects.equals(this.__deduct_income, o.getDeductIncome())) return false;
		if(!Objects.equals(this.__should_pay_income, o.getShouldPayIncome())) return false;
		if(!Objects.equals(this.__social_security, o.getSocialSecurity())) return false;
		if(!Objects.equals(this.__reserved_funds, o.getReservedFunds())) return false;
		if(!Objects.equals(this.__withhold_borrow, o.getWithholdBorrow())) return false;
		if(!Objects.equals(this.__leave_subsidies, o.getLeaveSubsidies())) return false;
		if(!Objects.equals(this.__fact_pay_salary, o.getFactPaySalary())) return false;
		if(!Objects.equals(this.__unit_social_security, o.getUnitSocialSecurity())) return false;
		if(!Objects.equals(this.__secret_key, o.getSecretKey())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__salary_year, o.getSalaryYear())) return false;
		if(!Objects.equals(this.__salary_month, o.getSalaryMonth())) return false;
		if(!Objects.equals(this.__is_return, o.getIsReturn())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeSalaryDetailId() != null) sb.append(__wrapNumber(count++, "employeeSalaryDetailId", getEmployeeSalaryDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEntryDate() != null) sb.append(__wrapDate(count++, "entryDate", getEntryDate()));
		if(getPositiveDate() != null) sb.append(__wrapDate(count++, "positiveDate", getPositiveDate()));
		if(getAllSalary() != null) sb.append(__wrapString(count++, "allSalary", getAllSalary()));
		if(getBasicProportion() != null) sb.append(__wrapString(count++, "basicProportion", getBasicProportion()));
		if(getPerformanceBonus() != null) sb.append(__wrapString(count++, "performanceBonus", getPerformanceBonus()));
		if(getBasicSalary() != null) sb.append(__wrapString(count++, "basicSalary", getBasicSalary()));
		if(getWorkSubsidies() != null) sb.append(__wrapString(count++, "workSubsidies", getWorkSubsidies()));
		if(getWorkYearSalary() != null) sb.append(__wrapString(count++, "workYearSalary", getWorkYearSalary()));
		if(getAnotherPlaceSubsidies() != null) sb.append(__wrapString(count++, "anotherPlaceSubsidies", getAnotherPlaceSubsidies()));
		if(getDeductSalary() != null) sb.append(__wrapString(count++, "deductSalary", getDeductSalary()));
		if(getPositiveAccount() != null) sb.append(__wrapString(count++, "positiveAccount", getPositiveAccount()));
		if(getShouldPaySalary() != null) sb.append(__wrapString(count++, "shouldPaySalary", getShouldPaySalary()));
		if(getLastMonthAchievementEffect() != null) sb.append(__wrapString(count++, "lastMonthAchievementEffect", getLastMonthAchievementEffect()));
		if(getProjectBonus() != null) sb.append(__wrapString(count++, "projectBonus", getProjectBonus()));
		if(getTaxableIncome() != null) sb.append(__wrapString(count++, "taxableIncome", getTaxableIncome()));
		if(getIncomeTotal() != null) sb.append(__wrapString(count++, "incomeTotal", getIncomeTotal()));
		if(getDeductIncome() != null) sb.append(__wrapString(count++, "deductIncome", getDeductIncome()));
		if(getShouldPayIncome() != null) sb.append(__wrapString(count++, "shouldPayIncome", getShouldPayIncome()));
		if(getSocialSecurity() != null) sb.append(__wrapString(count++, "socialSecurity", getSocialSecurity()));
		if(getReservedFunds() != null) sb.append(__wrapString(count++, "reservedFunds", getReservedFunds()));
		if(getWithholdBorrow() != null) sb.append(__wrapString(count++, "withholdBorrow", getWithholdBorrow()));
		if(getLeaveSubsidies() != null) sb.append(__wrapString(count++, "leaveSubsidies", getLeaveSubsidies()));
		if(getFactPaySalary() != null) sb.append(__wrapString(count++, "factPaySalary", getFactPaySalary()));
		if(getUnitSocialSecurity() != null) sb.append(__wrapString(count++, "unitSocialSecurity", getUnitSocialSecurity()));
		if(getSecretKey() != null) sb.append(__wrapString(count++, "secretKey", getSecretKey()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getSalaryYear() != null) sb.append(__wrapNumber(count++, "salaryYear", getSalaryYear()));
		if(getSalaryMonth() != null) sb.append(__wrapNumber(count++, "salaryMonth", getSalaryMonth()));
		if(getIsReturn() != null) sb.append(__wrapBoolean(count++, "isReturn", getIsReturn()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeSalaryDetailId")) != null) setEmployeeSalaryDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("entryDate")) != null) setEntryDate(__getDate(val)); 
		if((val = values.get("positiveDate")) != null) setPositiveDate(__getDate(val)); 
		if((val = values.get("allSalary")) != null) setAllSalary(__getString(val));
		if((val = values.get("basicProportion")) != null) setBasicProportion(__getString(val));
		if((val = values.get("performanceBonus")) != null) setPerformanceBonus(__getString(val));
		if((val = values.get("basicSalary")) != null) setBasicSalary(__getString(val));
		if((val = values.get("workSubsidies")) != null) setWorkSubsidies(__getString(val));
		if((val = values.get("workYearSalary")) != null) setWorkYearSalary(__getString(val));
		if((val = values.get("anotherPlaceSubsidies")) != null) setAnotherPlaceSubsidies(__getString(val));
		if((val = values.get("deductSalary")) != null) setDeductSalary(__getString(val));
		if((val = values.get("positiveAccount")) != null) setPositiveAccount(__getString(val));
		if((val = values.get("shouldPaySalary")) != null) setShouldPaySalary(__getString(val));
		if((val = values.get("lastMonthAchievementEffect")) != null) setLastMonthAchievementEffect(__getString(val));
		if((val = values.get("projectBonus")) != null) setProjectBonus(__getString(val));
		if((val = values.get("taxableIncome")) != null) setTaxableIncome(__getString(val));
		if((val = values.get("incomeTotal")) != null) setIncomeTotal(__getString(val));
		if((val = values.get("deductIncome")) != null) setDeductIncome(__getString(val));
		if((val = values.get("shouldPayIncome")) != null) setShouldPayIncome(__getString(val));
		if((val = values.get("socialSecurity")) != null) setSocialSecurity(__getString(val));
		if((val = values.get("reservedFunds")) != null) setReservedFunds(__getString(val));
		if((val = values.get("withholdBorrow")) != null) setWithholdBorrow(__getString(val));
		if((val = values.get("leaveSubsidies")) != null) setLeaveSubsidies(__getString(val));
		if((val = values.get("factPaySalary")) != null) setFactPaySalary(__getString(val));
		if((val = values.get("unitSocialSecurity")) != null) setUnitSocialSecurity(__getString(val));
		if((val = values.get("secretKey")) != null) setSecretKey(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("salaryYear")) != null) setSalaryYear(__getInt(val)); 
		if((val = values.get("salaryMonth")) != null) setSalaryMonth(__getInt(val)); 
		if((val = values.get("isReturn")) != null) setIsReturn(__getBoolean(val));
	}

	protected java.lang.Integer  __employee_salary_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __entry_date ;
	protected java.util.Date  __positive_date ;
	protected java.lang.String  __all_salary ;
	protected java.lang.String  __basic_proportion ;
	protected java.lang.String  __performance_bonus ;
	protected java.lang.String  __basic_salary ;
	protected java.lang.String  __work_subsidies ;
	protected java.lang.String  __work_year_salary ;
	protected java.lang.String  __another_place_subsidies ;
	protected java.lang.String  __deduct_salary ;
	protected java.lang.String  __positive_account ;
	protected java.lang.String  __should_pay_salary ;
	protected java.lang.String  __last_month_achievement_effect ;
	protected java.lang.String  __project_bonus ;
	protected java.lang.String  __taxable_income ;
	protected java.lang.String  __income_total ;
	protected java.lang.String  __deduct_income ;
	protected java.lang.String  __should_pay_income ;
	protected java.lang.String  __social_security ;
	protected java.lang.String  __reserved_funds ;
	protected java.lang.String  __withhold_borrow ;
	protected java.lang.String  __leave_subsidies ;
	protected java.lang.String  __fact_pay_salary ;
	protected java.lang.String  __unit_social_security ;
	protected java.lang.String  __secret_key ;
	protected java.lang.String  __bank_account ;
	protected java.lang.Integer  __salary_year ;
	protected java.lang.Integer  __salary_month ;
	protected java.lang.Boolean  __is_return ;
}
