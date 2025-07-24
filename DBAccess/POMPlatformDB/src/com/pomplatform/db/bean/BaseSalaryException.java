package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryException extends GenericBase implements BaseFactory<BaseSalaryException>, Comparable<BaseSalaryException> 
{


	public static BaseSalaryException newInstance(){
		return new BaseSalaryException();
	}

	@Override
	public BaseSalaryException make(){
		BaseSalaryException b = new BaseSalaryException();
		return b;
	}

	public final static java.lang.String CS_SALARY_EXCEPTION_ID = "salary_exception_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_PERSONNEL_BUSINESS_ID = "personnel_business_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_ATTENDANCE_DEDUCTION = "attendance_deduction" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_IS_APPLY = "is_apply" ;
	public final static java.lang.String CS_ACTUALLY_DEDUCTION = "actually_deduction" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,年份,月份,人事业务编码,员工编码,扣款原因,考勤扣除金额,考勤异常日期,操作时间,备注,是否已申请,实际扣除金额";

	public java.lang.Integer getSalaryExceptionId() {
		return this.__salary_exception_id;
	}

	public void setSalaryExceptionId( java.lang.Integer value ) {
		this.__salary_exception_id = value;
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

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.math.BigDecimal getAttendanceDeduction() {
		return this.__attendance_deduction;
	}

	public void setAttendanceDeduction( java.math.BigDecimal value ) {
		this.__attendance_deduction = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
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

	public java.lang.Boolean getIsApply() {
		return this.__is_apply;
	}

	public void setIsApply( java.lang.Boolean value ) {
		this.__is_apply = value;
	}

	public java.math.BigDecimal getActuallyDeduction() {
		return this.__actually_deduction;
	}

	public void setActuallyDeduction( java.math.BigDecimal value ) {
		this.__actually_deduction = value;
	}

	public void cloneCopy(BaseSalaryException __bean){
		__bean.setSalaryExceptionId(getSalaryExceptionId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setPersonnelBusinessId(getPersonnelBusinessId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setReason(getReason());
		__bean.setAttendanceDeduction(getAttendanceDeduction());
		__bean.setRecordDate(getRecordDate());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
		__bean.setIsApply(getIsApply());
		__bean.setActuallyDeduction(getActuallyDeduction());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryExceptionId() == null ? "" : getSalaryExceptionId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getPersonnelBusinessId() == null ? "" : getPersonnelBusinessId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getAttendanceDeduction() == null ? "" : getAttendanceDeduction());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getIsApply() == null ? "" : getIsApply());
		sb.append(",");
		sb.append(getActuallyDeduction() == null ? "" : getActuallyDeduction());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryException o) {
		return __salary_exception_id == null ? -1 : __salary_exception_id.compareTo(o.getSalaryExceptionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_exception_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__personnel_business_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduction);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__is_apply);
		hash = 97 * hash + Objects.hashCode(this.__actually_deduction);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryException o = (BaseSalaryException)obj;
		if(!Objects.equals(this.__salary_exception_id, o.getSalaryExceptionId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__personnel_business_id, o.getPersonnelBusinessId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__attendance_deduction, o.getAttendanceDeduction())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__is_apply, o.getIsApply())) return false;
		if(!Objects.equals(this.__actually_deduction, o.getActuallyDeduction())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryExceptionId() != null) sb.append(__wrapNumber(count++, "salaryExceptionId", getSalaryExceptionId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(count++, "personnelBusinessId", getPersonnelBusinessId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getAttendanceDeduction() != null) sb.append(__wrapDecimal(count++, "attendanceDeduction", getAttendanceDeduction()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getIsApply() != null) sb.append(__wrapBoolean(count++, "isApply", getIsApply()));
		if(getActuallyDeduction() != null) sb.append(__wrapDecimal(count++, "actuallyDeduction", getActuallyDeduction()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryExceptionId")) != null) setSalaryExceptionId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("attendanceDeduction")) != null) setAttendanceDeduction(__getDecimal(val));  
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("isApply")) != null) setIsApply(__getBoolean(val));
		if((val = values.get("actuallyDeduction")) != null) setActuallyDeduction(__getDecimal(val));  
	}

	protected java.lang.Integer  __salary_exception_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __personnel_business_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __reason ;
	protected java.math.BigDecimal  __attendance_deduction ;
	protected java.util.Date  __record_date ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
	protected java.lang.Boolean  __is_apply ;
	protected java.math.BigDecimal  __actually_deduction ;
}
