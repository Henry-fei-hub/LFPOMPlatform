package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAnnualLeave extends GenericBase implements BaseFactory<BaseAnnualLeave>, Comparable<BaseAnnualLeave> 
{


	public static BaseAnnualLeave newInstance(){
		return new BaseAnnualLeave();
	}

	@Override
	public BaseAnnualLeave make(){
		BaseAnnualLeave b = new BaseAnnualLeave();
		return b;
	}

	public final static java.lang.String CS_ANNUAL_LEAVE_ID = "annual_leave_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_SECRETARY_YEAR = "secretary_year" ;
	public final static java.lang.String CS_LENGTH_OF_SERVICE = "length_of_service" ;
	public final static java.lang.String CS_TOTAL_ANNUAL_LEAVE = "total_annual_leave" ;
	public final static java.lang.String CS_USAGE_AMOUNT_ANNUAL = "usage_amount_annual" ;
	public final static java.lang.String CS_REMAINING_AMOUNT_ANNUAL = "remaining_amount_annual" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_TOTAL_WEALFARE_LEAVE = "total_wealfare_leave" ;
	public final static java.lang.String CS_USAGE_AMOUNT_WEALFARE = "usage_amount_wealfare" ;
	public final static java.lang.String CS_REMAINING_AMOUNT_WEALFARE = "remaining_amount_wealfare" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,员工编号,员工编码,员工部门,司龄(月份),工龄,年假总数,年假使用天数,年假剩余天数,年份,企业福利假总数,使用企业福利假数量,剩余企业福利假数量";

	public java.lang.Integer getAnnualLeaveId() {
		return this.__annual_leave_id;
	}

	public void setAnnualLeaveId( java.lang.Integer value ) {
		this.__annual_leave_id = value;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getSecretaryYear() {
		return this.__secretary_year;
	}

	public void setSecretaryYear( java.lang.Integer value ) {
		this.__secretary_year = value;
	}

	public java.lang.Integer getLengthOfService() {
		return this.__length_of_service;
	}

	public void setLengthOfService( java.lang.Integer value ) {
		this.__length_of_service = value;
	}

	public java.math.BigDecimal getTotalAnnualLeave() {
		return this.__total_annual_leave;
	}

	public void setTotalAnnualLeave( java.math.BigDecimal value ) {
		this.__total_annual_leave = value;
	}

	public java.math.BigDecimal getUsageAmountAnnual() {
		return this.__usage_amount_annual;
	}

	public void setUsageAmountAnnual( java.math.BigDecimal value ) {
		this.__usage_amount_annual = value;
	}

	public java.math.BigDecimal getRemainingAmountAnnual() {
		return this.__remaining_amount_annual;
	}

	public void setRemainingAmountAnnual( java.math.BigDecimal value ) {
		this.__remaining_amount_annual = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.math.BigDecimal getTotalWealfareLeave() {
		return this.__total_wealfare_leave;
	}

	public void setTotalWealfareLeave( java.math.BigDecimal value ) {
		this.__total_wealfare_leave = value;
	}

	public java.math.BigDecimal getUsageAmountWealfare() {
		return this.__usage_amount_wealfare;
	}

	public void setUsageAmountWealfare( java.math.BigDecimal value ) {
		this.__usage_amount_wealfare = value;
	}

	public java.math.BigDecimal getRemainingAmountWealfare() {
		return this.__remaining_amount_wealfare;
	}

	public void setRemainingAmountWealfare( java.math.BigDecimal value ) {
		this.__remaining_amount_wealfare = value;
	}

	public void cloneCopy(BaseAnnualLeave __bean){
		__bean.setAnnualLeaveId(getAnnualLeaveId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setSecretaryYear(getSecretaryYear());
		__bean.setLengthOfService(getLengthOfService());
		__bean.setTotalAnnualLeave(getTotalAnnualLeave());
		__bean.setUsageAmountAnnual(getUsageAmountAnnual());
		__bean.setRemainingAmountAnnual(getRemainingAmountAnnual());
		__bean.setYear(getYear());
		__bean.setTotalWealfareLeave(getTotalWealfareLeave());
		__bean.setUsageAmountWealfare(getUsageAmountWealfare());
		__bean.setRemainingAmountWealfare(getRemainingAmountWealfare());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAnnualLeaveId() == null ? "" : getAnnualLeaveId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getSecretaryYear() == null ? "" : getSecretaryYear());
		sb.append(",");
		sb.append(getLengthOfService() == null ? "" : getLengthOfService());
		sb.append(",");
		sb.append(getTotalAnnualLeave() == null ? "" : getTotalAnnualLeave());
		sb.append(",");
		sb.append(getUsageAmountAnnual() == null ? "" : getUsageAmountAnnual());
		sb.append(",");
		sb.append(getRemainingAmountAnnual() == null ? "" : getRemainingAmountAnnual());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getTotalWealfareLeave() == null ? "" : getTotalWealfareLeave());
		sb.append(",");
		sb.append(getUsageAmountWealfare() == null ? "" : getUsageAmountWealfare());
		sb.append(",");
		sb.append(getRemainingAmountWealfare() == null ? "" : getRemainingAmountWealfare());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAnnualLeave o) {
		return __annual_leave_id == null ? -1 : __annual_leave_id.compareTo(o.getAnnualLeaveId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__annual_leave_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__secretary_year);
		hash = 97 * hash + Objects.hashCode(this.__length_of_service);
		hash = 97 * hash + Objects.hashCode(this.__total_annual_leave);
		hash = 97 * hash + Objects.hashCode(this.__usage_amount_annual);
		hash = 97 * hash + Objects.hashCode(this.__remaining_amount_annual);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__total_wealfare_leave);
		hash = 97 * hash + Objects.hashCode(this.__usage_amount_wealfare);
		hash = 97 * hash + Objects.hashCode(this.__remaining_amount_wealfare);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAnnualLeave o = (BaseAnnualLeave)obj;
		if(!Objects.equals(this.__annual_leave_id, o.getAnnualLeaveId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__secretary_year, o.getSecretaryYear())) return false;
		if(!Objects.equals(this.__length_of_service, o.getLengthOfService())) return false;
		if(!Objects.equals(this.__total_annual_leave, o.getTotalAnnualLeave())) return false;
		if(!Objects.equals(this.__usage_amount_annual, o.getUsageAmountAnnual())) return false;
		if(!Objects.equals(this.__remaining_amount_annual, o.getRemainingAmountAnnual())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__total_wealfare_leave, o.getTotalWealfareLeave())) return false;
		if(!Objects.equals(this.__usage_amount_wealfare, o.getUsageAmountWealfare())) return false;
		if(!Objects.equals(this.__remaining_amount_wealfare, o.getRemainingAmountWealfare())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAnnualLeaveId() != null) sb.append(__wrapNumber(count++, "annualLeaveId", getAnnualLeaveId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getSecretaryYear() != null) sb.append(__wrapNumber(count++, "secretaryYear", getSecretaryYear()));
		if(getLengthOfService() != null) sb.append(__wrapNumber(count++, "lengthOfService", getLengthOfService()));
		if(getTotalAnnualLeave() != null) sb.append(__wrapDecimal(count++, "totalAnnualLeave", getTotalAnnualLeave()));
		if(getUsageAmountAnnual() != null) sb.append(__wrapDecimal(count++, "usageAmountAnnual", getUsageAmountAnnual()));
		if(getRemainingAmountAnnual() != null) sb.append(__wrapDecimal(count++, "remainingAmountAnnual", getRemainingAmountAnnual()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getTotalWealfareLeave() != null) sb.append(__wrapDecimal(count++, "totalWealfareLeave", getTotalWealfareLeave()));
		if(getUsageAmountWealfare() != null) sb.append(__wrapDecimal(count++, "usageAmountWealfare", getUsageAmountWealfare()));
		if(getRemainingAmountWealfare() != null) sb.append(__wrapDecimal(count++, "remainingAmountWealfare", getRemainingAmountWealfare()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getAnnualLeaveId() != null) res.put("annualLeaveId", getAnnualLeaveId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getSecretaryYear() != null) res.put("secretaryYear", getSecretaryYear());
		if(getLengthOfService() != null) res.put("lengthOfService", getLengthOfService());
		if(getTotalAnnualLeave() != null) res.put("totalAnnualLeave", getTotalAnnualLeave());
		if(getUsageAmountAnnual() != null) res.put("usageAmountAnnual", getUsageAmountAnnual());
		if(getRemainingAmountAnnual() != null) res.put("remainingAmountAnnual", getRemainingAmountAnnual());
		if(getYear() != null) res.put("year", getYear());
		if(getTotalWealfareLeave() != null) res.put("totalWealfareLeave", getTotalWealfareLeave());
		if(getUsageAmountWealfare() != null) res.put("usageAmountWealfare", getUsageAmountWealfare());
		if(getRemainingAmountWealfare() != null) res.put("remainingAmountWealfare", getRemainingAmountWealfare());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("annualLeaveId")) != null) setAnnualLeaveId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("secretaryYear")) != null) setSecretaryYear(__getInt(val)); 
		if((val = values.get("lengthOfService")) != null) setLengthOfService(__getInt(val)); 
		if((val = values.get("totalAnnualLeave")) != null) setTotalAnnualLeave(__getDecimal(val));  
		if((val = values.get("usageAmountAnnual")) != null) setUsageAmountAnnual(__getDecimal(val));  
		if((val = values.get("remainingAmountAnnual")) != null) setRemainingAmountAnnual(__getDecimal(val));  
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("totalWealfareLeave")) != null) setTotalWealfareLeave(__getDecimal(val));  
		if((val = values.get("usageAmountWealfare")) != null) setUsageAmountWealfare(__getDecimal(val));  
		if((val = values.get("remainingAmountWealfare")) != null) setRemainingAmountWealfare(__getDecimal(val));  
	}

	protected java.lang.Integer  __annual_leave_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __secretary_year ;
	protected java.lang.Integer  __length_of_service ;
	protected java.math.BigDecimal  __total_annual_leave ;
	protected java.math.BigDecimal  __usage_amount_annual ;
	protected java.math.BigDecimal  __remaining_amount_annual ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __total_wealfare_leave ;
	protected java.math.BigDecimal  __usage_amount_wealfare ;
	protected java.math.BigDecimal  __remaining_amount_wealfare ;
}
