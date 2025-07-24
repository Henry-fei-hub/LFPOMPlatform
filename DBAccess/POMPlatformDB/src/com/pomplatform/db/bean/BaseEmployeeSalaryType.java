package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeSalaryType extends GenericBase implements BaseFactory<BaseEmployeeSalaryType>, Comparable<BaseEmployeeSalaryType> 
{


	public static BaseEmployeeSalaryType newInstance(){
		return new BaseEmployeeSalaryType();
	}

	@Override
	public BaseEmployeeSalaryType make(){
		BaseEmployeeSalaryType b = new BaseEmployeeSalaryType();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_SALARY_TYPE_ID = "employee_salary_type_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_SALARY_TYPE = "salary_type" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_TYPE = "fundraising_project_type" ;
	public final static java.lang.String CS_FUNDRAISING_PROJECT_RATE = "fundraising_project_rate" ;
	public final static java.lang.String CS_COMPANY_ID = "company_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工工资发放类型表主键,员工编码,员工姓名,员工工号,业务部门,年份,月份,类型（1.募投项目 2.研发项目,0正常薪资发放）,募投项目类型,募投比例,归属公司";

	public java.lang.Integer getEmployeeSalaryTypeId() {
		return this.__employee_salary_type_id;
	}

	public void setEmployeeSalaryTypeId( java.lang.Integer value ) {
		this.__employee_salary_type_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
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

	public java.lang.Integer getSalaryType() {
		return this.__salary_type;
	}

	public void setSalaryType( java.lang.Integer value ) {
		this.__salary_type = value;
	}

	public java.lang.Integer getFundraisingProjectType() {
		return this.__fundraising_project_type;
	}

	public void setFundraisingProjectType( java.lang.Integer value ) {
		this.__fundraising_project_type = value;
	}

	public java.math.BigDecimal getFundraisingProjectRate() {
		return this.__fundraising_project_rate;
	}

	public void setFundraisingProjectRate( java.math.BigDecimal value ) {
		this.__fundraising_project_rate = value;
	}

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public void cloneCopy(BaseEmployeeSalaryType __bean){
		__bean.setEmployeeSalaryTypeId(getEmployeeSalaryTypeId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setSalaryType(getSalaryType());
		__bean.setFundraisingProjectType(getFundraisingProjectType());
		__bean.setFundraisingProjectRate(getFundraisingProjectRate());
		__bean.setCompanyId(getCompanyId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeSalaryTypeId() == null ? "" : getEmployeeSalaryTypeId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getSalaryType() == null ? "" : getSalaryType());
		sb.append(",");
		sb.append(getFundraisingProjectType() == null ? "" : getFundraisingProjectType());
		sb.append(",");
		sb.append(getFundraisingProjectRate() == null ? "" : getFundraisingProjectRate());
		sb.append(",");
		sb.append(getCompanyId() == null ? "" : getCompanyId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeSalaryType o) {
		return __employee_salary_type_id == null ? -1 : __employee_salary_type_id.compareTo(o.getEmployeeSalaryTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_salary_type_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__salary_type);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_type);
		hash = 97 * hash + Objects.hashCode(this.__fundraising_project_rate);
		hash = 97 * hash + Objects.hashCode(this.__company_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeSalaryType o = (BaseEmployeeSalaryType)obj;
		if(!Objects.equals(this.__employee_salary_type_id, o.getEmployeeSalaryTypeId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__salary_type, o.getSalaryType())) return false;
		if(!Objects.equals(this.__fundraising_project_type, o.getFundraisingProjectType())) return false;
		if(!Objects.equals(this.__fundraising_project_rate, o.getFundraisingProjectRate())) return false;
		if(!Objects.equals(this.__company_id, o.getCompanyId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeSalaryTypeId() != null) sb.append(__wrapNumber(count++, "employeeSalaryTypeId", getEmployeeSalaryTypeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getSalaryType() != null) sb.append(__wrapNumber(count++, "salaryType", getSalaryType()));
		if(getFundraisingProjectType() != null) sb.append(__wrapNumber(count++, "fundraisingProjectType", getFundraisingProjectType()));
		if(getFundraisingProjectRate() != null) sb.append(__wrapDecimal(count++, "fundraisingProjectRate", getFundraisingProjectRate()));
		if(getCompanyId() != null) sb.append(__wrapNumber(count++, "companyId", getCompanyId()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeSalaryTypeId() != null) res.put("employeeSalaryTypeId", getEmployeeSalaryTypeId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getSalaryType() != null) res.put("salaryType", getSalaryType());
		if(getFundraisingProjectType() != null) res.put("fundraisingProjectType", getFundraisingProjectType());
		if(getFundraisingProjectRate() != null) res.put("fundraisingProjectRate", getFundraisingProjectRate());
		if(getCompanyId() != null) res.put("companyId", getCompanyId());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeSalaryTypeId")) != null) setEmployeeSalaryTypeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("salaryType")) != null) setSalaryType(__getInt(val)); 
		if((val = values.get("fundraisingProjectType")) != null) setFundraisingProjectType(__getInt(val)); 
		if((val = values.get("fundraisingProjectRate")) != null) setFundraisingProjectRate(__getDecimal(val));  
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
	}

	protected java.lang.Integer  __employee_salary_type_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_name ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __salary_type ;
	protected java.lang.Integer  __fundraising_project_type ;
	protected java.math.BigDecimal  __fundraising_project_rate ;
	protected java.lang.Integer  __company_id ;
}
