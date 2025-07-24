package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryOfWorkYear extends GenericBase implements BaseFactory<BaseSalaryOfWorkYear>, Comparable<BaseSalaryOfWorkYear> 
{


	public static BaseSalaryOfWorkYear newInstance(){
		return new BaseSalaryOfWorkYear();
	}

	@Override
	public BaseSalaryOfWorkYear make(){
		BaseSalaryOfWorkYear b = new BaseSalaryOfWorkYear();
		return b;
	}

	public final static java.lang.String CS_SALARY_OF_WORK_YEAR_ID = "salary_of_work_year_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_WORK_YEARS = "work_years" ;
	public final static java.lang.String CS_WORK_MONEY = "work_money" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工id,年份,月份,工龄,工龄工资";

	public java.lang.Integer getSalaryOfWorkYearId() {
		return this.__salary_of_work_year_id;
	}

	public void setSalaryOfWorkYearId( java.lang.Integer value ) {
		this.__salary_of_work_year_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.lang.String getWorkYears() {
		return this.__work_years;
	}

	public void setWorkYears( java.lang.String value ) {
		this.__work_years = value;
	}

	public java.lang.String getWorkMoney() {
		return this.__work_money;
	}

	public void setWorkMoney( java.lang.String value ) {
		this.__work_money = value;
	}

	public void cloneCopy(BaseSalaryOfWorkYear __bean){
		__bean.setSalaryOfWorkYearId(getSalaryOfWorkYearId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setWorkYears(getWorkYears());
		__bean.setWorkMoney(getWorkMoney());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryOfWorkYearId() == null ? "" : getSalaryOfWorkYearId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getWorkYears() == null ? "" : getWorkYears());
		sb.append(",");
		sb.append(getWorkMoney() == null ? "" : getWorkMoney());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryOfWorkYear o) {
		return __salary_of_work_year_id == null ? -1 : __salary_of_work_year_id.compareTo(o.getSalaryOfWorkYearId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_of_work_year_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__work_years);
		hash = 97 * hash + Objects.hashCode(this.__work_money);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryOfWorkYear o = (BaseSalaryOfWorkYear)obj;
		if(!Objects.equals(this.__salary_of_work_year_id, o.getSalaryOfWorkYearId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__work_years, o.getWorkYears())) return false;
		if(!Objects.equals(this.__work_money, o.getWorkMoney())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryOfWorkYearId() != null) sb.append(__wrapNumber(count++, "salaryOfWorkYearId", getSalaryOfWorkYearId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getWorkYears() != null) sb.append(__wrapString(count++, "workYears", getWorkYears()));
		if(getWorkMoney() != null) sb.append(__wrapString(count++, "workMoney", getWorkMoney()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryOfWorkYearId")) != null) setSalaryOfWorkYearId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("workYears")) != null) setWorkYears(__getString(val));
		if((val = values.get("workMoney")) != null) setWorkMoney(__getString(val));
	}

	protected java.lang.Integer  __salary_of_work_year_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.String  __work_years ;
	protected java.lang.String  __work_money ;
}
