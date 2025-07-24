package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryEmployeePerformance extends GenericBase implements BaseFactory<BaseSalaryEmployeePerformance>, Comparable<BaseSalaryEmployeePerformance> 
{


	public static BaseSalaryEmployeePerformance newInstance(){
		return new BaseSalaryEmployeePerformance();
	}

	@Override
	public BaseSalaryEmployeePerformance make(){
		BaseSalaryEmployeePerformance b = new BaseSalaryEmployeePerformance();
		return b;
	}

	public final static java.lang.String CS_SALARY_EMPLOYEE_PERFORMANCE_ID = "salary_employee_performance_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_BASIC_PROPORTION_STR = "basic_proportion_str" ;
	public final static java.lang.String CS_BASIC_PROPORTION = "basic_proportion" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY = "month_performance_pay" ;
	public final static java.lang.String CS_SHOULD_DAYS = "should_days" ;
	public final static java.lang.String CS_FACT_DAYS = "fact_days" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_HAPPEN_DATE = "happen_date" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_GRADE = "grade" ;
	public final static java.lang.String CS_PROPORTION = "proportion" ;
	public final static java.lang.String CS_WORKING_COEFFICIENT = "working_coefficient" ;
	public final static java.lang.String CS_ACTUAL_PERFORMANCE_PAY = "actual_performance_pay" ;
	public final static java.lang.String CS_IS_SENDED = "is_sended" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,工号,员工主键,业务部门编码,所属部门,归属公司,员工状态,月薪,基本比例（显示用）,基本比例（计算用）,月基本工资,月绩效工资,应到天数,实到天数,年,,发生日期,创建日期,等级,比例,工作系数,实发绩效,是否发放";

	public java.lang.Integer getSalaryEmployeePerformanceId() {
		return this.__salary_employee_performance_id;
	}

	public void setSalaryEmployeePerformanceId( java.lang.Integer value ) {
		this.__salary_employee_performance_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.lang.String value ) {
		this.__month_pay = value;
	}

	public java.lang.String getBasicProportionStr() {
		return this.__basic_proportion_str;
	}

	public void setBasicProportionStr( java.lang.String value ) {
		this.__basic_proportion_str = value;
	}

	public java.math.BigDecimal getBasicProportion() {
		return this.__basic_proportion;
	}

	public void setBasicProportion( java.math.BigDecimal value ) {
		this.__basic_proportion = value;
	}

	public java.lang.String getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.lang.String value ) {
		this.__month_basic_pay = value;
	}

	public java.lang.String getMonthPerformancePay() {
		return this.__month_performance_pay;
	}

	public void setMonthPerformancePay( java.lang.String value ) {
		this.__month_performance_pay = value;
	}

	public java.math.BigDecimal getShouldDays() {
		return this.__should_days;
	}

	public void setShouldDays( java.math.BigDecimal value ) {
		this.__should_days = value;
	}

	public java.math.BigDecimal getFactDays() {
		return this.__fact_days;
	}

	public void setFactDays( java.math.BigDecimal value ) {
		this.__fact_days = value;
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

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getGrade() {
		return this.__grade;
	}

	public void setGrade( java.lang.String value ) {
		this.__grade = value;
	}

	public java.math.BigDecimal getProportion() {
		return this.__proportion;
	}

	public void setProportion( java.math.BigDecimal value ) {
		this.__proportion = value;
	}

	public java.math.BigDecimal getWorkingCoefficient() {
		return this.__working_coefficient;
	}

	public void setWorkingCoefficient( java.math.BigDecimal value ) {
		this.__working_coefficient = value;
	}

	public java.math.BigDecimal getActualPerformancePay() {
		return this.__actual_performance_pay;
	}

	public void setActualPerformancePay( java.math.BigDecimal value ) {
		this.__actual_performance_pay = value;
	}

	public java.lang.Boolean getIsSended() {
		return this.__is_sended;
	}

	public void setIsSended( java.lang.Boolean value ) {
		this.__is_sended = value;
	}

	public void cloneCopy(BaseSalaryEmployeePerformance __bean){
		__bean.setSalaryEmployeePerformanceId(getSalaryEmployeePerformanceId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setCompanyId(getCompanyId());
		__bean.setStatus(getStatus());
		__bean.setMonthPay(getMonthPay());
		__bean.setBasicProportionStr(getBasicProportionStr());
		__bean.setBasicProportion(getBasicProportion());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setMonthPerformancePay(getMonthPerformancePay());
		__bean.setShouldDays(getShouldDays());
		__bean.setFactDays(getFactDays());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setHappenDate(getHappenDate());
		__bean.setCreateTime(getCreateTime());
		__bean.setGrade(getGrade());
		__bean.setProportion(getProportion());
		__bean.setWorkingCoefficient(getWorkingCoefficient());
		__bean.setActualPerformancePay(getActualPerformancePay());
		__bean.setIsSended(getIsSended());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryEmployeePerformanceId() == null ? "" : getSalaryEmployeePerformanceId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_26", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_39", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getMonthPay() == null ? "" : getMonthPay());
		sb.append(",");
		sb.append(getBasicProportionStr() == null ? "" : getBasicProportionStr());
		sb.append(",");
		sb.append(getBasicProportion() == null ? "" : getBasicProportion());
		sb.append(",");
		sb.append(getMonthBasicPay() == null ? "" : getMonthBasicPay());
		sb.append(",");
		sb.append(getMonthPerformancePay() == null ? "" : getMonthPerformancePay());
		sb.append(",");
		sb.append(getShouldDays() == null ? "" : getShouldDays());
		sb.append(",");
		sb.append(getFactDays() == null ? "" : getFactDays());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getHappenDate() == null ? "" : sdf.format(getHappenDate()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getGrade() == null ? "" : getGrade());
		sb.append(",");
		sb.append(getProportion() == null ? "" : getProportion());
		sb.append(",");
		sb.append(getWorkingCoefficient() == null ? "" : getWorkingCoefficient());
		sb.append(",");
		sb.append(getActualPerformancePay() == null ? "" : getActualPerformancePay());
		sb.append(",");
		sb.append(getIsSended() == null ? "" : getIsSended());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryEmployeePerformance o) {
		return __salary_employee_performance_id == null ? -1 : __salary_employee_performance_id.compareTo(o.getSalaryEmployeePerformanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_employee_performance_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__should_days);
		hash = 97 * hash + Objects.hashCode(this.__fact_days);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__happen_date);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__grade);
		hash = 97 * hash + Objects.hashCode(this.__proportion);
		hash = 97 * hash + Objects.hashCode(this.__working_coefficient);
		hash = 97 * hash + Objects.hashCode(this.__actual_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__is_sended);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryEmployeePerformance o = (BaseSalaryEmployeePerformance)obj;
		if(!Objects.equals(this.__salary_employee_performance_id, o.getSalaryEmployeePerformanceId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__basic_proportion_str, o.getBasicProportionStr())) return false;
		if(!Objects.equals(this.__basic_proportion, o.getBasicProportion())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__month_performance_pay, o.getMonthPerformancePay())) return false;
		if(!Objects.equals(this.__should_days, o.getShouldDays())) return false;
		if(!Objects.equals(this.__fact_days, o.getFactDays())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__happen_date, o.getHappenDate())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__grade, o.getGrade())) return false;
		if(!Objects.equals(this.__proportion, o.getProportion())) return false;
		if(!Objects.equals(this.__working_coefficient, o.getWorkingCoefficient())) return false;
		if(!Objects.equals(this.__actual_performance_pay, o.getActualPerformancePay())) return false;
		if(!Objects.equals(this.__is_sended, o.getIsSended())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryEmployeePerformanceId() != null) sb.append(__wrapNumber(count++, "salaryEmployeePerformanceId", getSalaryEmployeePerformanceId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getMonthPay() != null) sb.append(__wrapString(count++, "monthPay", getMonthPay()));
		if(getBasicProportionStr() != null) sb.append(__wrapString(count++, "basicProportionStr", getBasicProportionStr()));
		if(getBasicProportion() != null) sb.append(__wrapDecimal(count++, "basicProportion", getBasicProportion()));
		if(getMonthBasicPay() != null) sb.append(__wrapString(count++, "monthBasicPay", getMonthBasicPay()));
		if(getMonthPerformancePay() != null) sb.append(__wrapString(count++, "monthPerformancePay", getMonthPerformancePay()));
		if(getShouldDays() != null) sb.append(__wrapDecimal(count++, "shouldDays", getShouldDays()));
		if(getFactDays() != null) sb.append(__wrapDecimal(count++, "factDays", getFactDays()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getHappenDate() != null) sb.append(__wrapDate(count++, "happenDate", getHappenDate()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getGrade() != null) sb.append(__wrapString(count++, "grade", getGrade()));
		if(getProportion() != null) sb.append(__wrapDecimal(count++, "proportion", getProportion()));
		if(getWorkingCoefficient() != null) sb.append(__wrapDecimal(count++, "workingCoefficient", getWorkingCoefficient()));
		if(getActualPerformancePay() != null) sb.append(__wrapDecimal(count++, "actualPerformancePay", getActualPerformancePay()));
		if(getIsSended() != null) sb.append(__wrapBoolean(count++, "isSended", getIsSended()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryEmployeePerformanceId")) != null) setSalaryEmployeePerformanceId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("monthPay")) != null) setMonthPay(__getString(val));
		if((val = values.get("basicProportionStr")) != null) setBasicProportionStr(__getString(val));
		if((val = values.get("basicProportion")) != null) setBasicProportion(__getDecimal(val));  
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getString(val));
		if((val = values.get("monthPerformancePay")) != null) setMonthPerformancePay(__getString(val));
		if((val = values.get("shouldDays")) != null) setShouldDays(__getDecimal(val));  
		if((val = values.get("factDays")) != null) setFactDays(__getDecimal(val));  
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("proportion")) != null) setProportion(__getDecimal(val));  
		if((val = values.get("workingCoefficient")) != null) setWorkingCoefficient(__getDecimal(val));  
		if((val = values.get("actualPerformancePay")) != null) setActualPerformancePay(__getDecimal(val));  
		if((val = values.get("isSended")) != null) setIsSended(__getBoolean(val));
	}

	protected java.lang.Integer  __salary_employee_performance_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __company_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __month_pay ;
	protected java.lang.String  __basic_proportion_str ;
	protected java.math.BigDecimal  __basic_proportion ;
	protected java.lang.String  __month_basic_pay ;
	protected java.lang.String  __month_performance_pay ;
	protected java.math.BigDecimal  __should_days ;
	protected java.math.BigDecimal  __fact_days ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __happen_date ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __grade ;
	protected java.math.BigDecimal  __proportion ;
	protected java.math.BigDecimal  __working_coefficient ;
	protected java.math.BigDecimal  __actual_performance_pay ;
	protected java.lang.Boolean  __is_sended ;
}
