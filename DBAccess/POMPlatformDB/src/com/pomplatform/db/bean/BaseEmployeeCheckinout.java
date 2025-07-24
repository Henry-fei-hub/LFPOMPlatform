package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeCheckinout extends GenericBase implements BaseFactory<BaseEmployeeCheckinout>, Comparable<BaseEmployeeCheckinout> 
{


	public static BaseEmployeeCheckinout newInstance(){
		return new BaseEmployeeCheckinout();
	}

	@Override
	public BaseEmployeeCheckinout make(){
		BaseEmployeeCheckinout b = new BaseEmployeeCheckinout();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_CHECK_ID = "employee_check_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_CHECK_DATE = "check_date" ;
	public final static java.lang.String CS_CHECK_IN_TIME = "check_in_time" ;
	public final static java.lang.String CS_CHECK_OUT_TIME = "check_out_time" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_OA_EMPLOYEE_ID = "oa_employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_FINAL_STATUS = "final_status" ;
	public final static java.lang.String CS_DAY_OF_WEEK = "day_of_week" ;
	public final static java.lang.String CS_WEEK_OF_YEAR = "week_of_year" ;
	public final static java.lang.String CS_BIG_WEEK = "big_week" ;
	public final static java.lang.String CS_COMMENTS = "comments" ;
	public final static java.lang.String CS_LATE_TIME = "late_time" ;
	public final static java.lang.String CS_IS_WORK_DAY = "is_work_day" ;
	public final static java.lang.String CS_OVER_TIME = "over_time" ;
	public final static java.lang.String CS_LEAVE_DAYS = "leave_days" ;
	public final static java.lang.String CS_LEAVE_HOURS = "leave_hours" ;

	public final static java.lang.String ALL_CAPTIONS = ",员工代码,考勤日期,上班时间,下班时间,考勤状态,OA编码,员工号,正常,星期,年度周,大周,备注,迟到时间,工作日,加班时长,请假天数,请假小时";

	public java.lang.Integer getEmployeeCheckId() {
		return this.__employee_check_id;
	}

	public void setEmployeeCheckId( java.lang.Integer value ) {
		this.__employee_check_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getCheckDate() {
		return this.__check_date;
	}

	public void setCheckDate( java.util.Date value ) {
		this.__check_date = value;
	}

	public java.util.Date getCheckInTime() {
		return this.__check_in_time;
	}

	public void setCheckInTime( java.util.Date value ) {
		this.__check_in_time = value;
	}

	public java.util.Date getCheckOutTime() {
		return this.__check_out_time;
	}

	public void setCheckOutTime( java.util.Date value ) {
		this.__check_out_time = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getOaEmployeeId() {
		return this.__oa_employee_id;
	}

	public void setOaEmployeeId( java.lang.Integer value ) {
		this.__oa_employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Boolean getFinalStatus() {
		return this.__final_status;
	}

	public void setFinalStatus( java.lang.Boolean value ) {
		this.__final_status = value;
	}

	public java.lang.Integer getDayOfWeek() {
		return this.__day_of_week;
	}

	public void setDayOfWeek( java.lang.Integer value ) {
		this.__day_of_week = value;
	}

	public java.lang.Integer getWeekOfYear() {
		return this.__week_of_year;
	}

	public void setWeekOfYear( java.lang.Integer value ) {
		this.__week_of_year = value;
	}

	public java.lang.Boolean getBigWeek() {
		return this.__big_week;
	}

	public void setBigWeek( java.lang.Boolean value ) {
		this.__big_week = value;
	}

	public java.lang.String getComments() {
		return this.__comments;
	}

	public void setComments( java.lang.String value ) {
		this.__comments = value;
	}

	public java.lang.Integer getLateTime() {
		return this.__late_time;
	}

	public void setLateTime( java.lang.Integer value ) {
		this.__late_time = value;
	}

	public java.lang.Boolean getIsWorkDay() {
		return this.__is_work_day;
	}

	public void setIsWorkDay( java.lang.Boolean value ) {
		this.__is_work_day = value;
	}

	public java.math.BigDecimal getOverTime() {
		return this.__over_time;
	}

	public void setOverTime( java.math.BigDecimal value ) {
		this.__over_time = value;
	}

	public java.math.BigDecimal getLeaveDays() {
		return this.__leave_days;
	}

	public void setLeaveDays( java.math.BigDecimal value ) {
		this.__leave_days = value;
	}

	public java.math.BigDecimal getLeaveHours() {
		return this.__leave_hours;
	}

	public void setLeaveHours( java.math.BigDecimal value ) {
		this.__leave_hours = value;
	}

	public void cloneCopy(BaseEmployeeCheckinout __bean){
		__bean.setEmployeeCheckId(getEmployeeCheckId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setCheckDate(getCheckDate());
		__bean.setCheckInTime(getCheckInTime());
		__bean.setCheckOutTime(getCheckOutTime());
		__bean.setStatus(getStatus());
		__bean.setOaEmployeeId(getOaEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setFinalStatus(getFinalStatus());
		__bean.setDayOfWeek(getDayOfWeek());
		__bean.setWeekOfYear(getWeekOfYear());
		__bean.setBigWeek(getBigWeek());
		__bean.setComments(getComments());
		__bean.setLateTime(getLateTime());
		__bean.setIsWorkDay(getIsWorkDay());
		__bean.setOverTime(getOverTime());
		__bean.setLeaveDays(getLeaveDays());
		__bean.setLeaveHours(getLeaveHours());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeCheckId() == null ? "" : getEmployeeCheckId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getCheckDate() == null ? "" : sdf.format(getCheckDate()));
		sb.append(",");
		sb.append(getCheckInTime() == null ? "" : sdf.format(getCheckInTime()));
		sb.append(",");
		sb.append(getCheckOutTime() == null ? "" : sdf.format(getCheckOutTime()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getOaEmployeeId() == null ? "" : getOaEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getFinalStatus() == null ? "" : getFinalStatus());
		sb.append(",");
		sb.append(getDayOfWeek() == null ? "" : getDayOfWeek());
		sb.append(",");
		sb.append(getWeekOfYear() == null ? "" : getWeekOfYear());
		sb.append(",");
		sb.append(getBigWeek() == null ? "" : getBigWeek());
		sb.append(",");
		sb.append(getComments() == null ? "" : getComments());
		sb.append(",");
		sb.append(getLateTime() == null ? "" : getLateTime());
		sb.append(",");
		sb.append(getIsWorkDay() == null ? "" : getIsWorkDay());
		sb.append(",");
		sb.append(getOverTime() == null ? "" : getOverTime());
		sb.append(",");
		sb.append(getLeaveDays() == null ? "" : getLeaveDays());
		sb.append(",");
		sb.append(getLeaveHours() == null ? "" : getLeaveHours());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeCheckinout o) {
		return __employee_check_id == null ? -1 : __employee_check_id.compareTo(o.getEmployeeCheckId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_check_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__check_date);
		hash = 97 * hash + Objects.hashCode(this.__check_in_time);
		hash = 97 * hash + Objects.hashCode(this.__check_out_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__oa_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__final_status);
		hash = 97 * hash + Objects.hashCode(this.__day_of_week);
		hash = 97 * hash + Objects.hashCode(this.__week_of_year);
		hash = 97 * hash + Objects.hashCode(this.__big_week);
		hash = 97 * hash + Objects.hashCode(this.__comments);
		hash = 97 * hash + Objects.hashCode(this.__late_time);
		hash = 97 * hash + Objects.hashCode(this.__is_work_day);
		hash = 97 * hash + Objects.hashCode(this.__over_time);
		hash = 97 * hash + Objects.hashCode(this.__leave_days);
		hash = 97 * hash + Objects.hashCode(this.__leave_hours);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeCheckinout o = (BaseEmployeeCheckinout)obj;
		if(!Objects.equals(this.__employee_check_id, o.getEmployeeCheckId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__check_date, o.getCheckDate())) return false;
		if(!Objects.equals(this.__check_in_time, o.getCheckInTime())) return false;
		if(!Objects.equals(this.__check_out_time, o.getCheckOutTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__oa_employee_id, o.getOaEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__final_status, o.getFinalStatus())) return false;
		if(!Objects.equals(this.__day_of_week, o.getDayOfWeek())) return false;
		if(!Objects.equals(this.__week_of_year, o.getWeekOfYear())) return false;
		if(!Objects.equals(this.__big_week, o.getBigWeek())) return false;
		if(!Objects.equals(this.__comments, o.getComments())) return false;
		if(!Objects.equals(this.__late_time, o.getLateTime())) return false;
		if(!Objects.equals(this.__is_work_day, o.getIsWorkDay())) return false;
		if(!Objects.equals(this.__over_time, o.getOverTime())) return false;
		if(!Objects.equals(this.__leave_days, o.getLeaveDays())) return false;
		if(!Objects.equals(this.__leave_hours, o.getLeaveHours())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeCheckId() != null) sb.append(__wrapNumber(count++, "employeeCheckId", getEmployeeCheckId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getCheckDate() != null) sb.append(__wrapDate(count++, "checkDate", getCheckDate()));
		if(getCheckInTime() != null) sb.append(__wrapDate(count++, "checkInTime", getCheckInTime()));
		if(getCheckOutTime() != null) sb.append(__wrapDate(count++, "checkOutTime", getCheckOutTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOaEmployeeId() != null) sb.append(__wrapNumber(count++, "oaEmployeeId", getOaEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getFinalStatus() != null) sb.append(__wrapBoolean(count++, "finalStatus", getFinalStatus()));
		if(getDayOfWeek() != null) sb.append(__wrapNumber(count++, "dayOfWeek", getDayOfWeek()));
		if(getWeekOfYear() != null) sb.append(__wrapNumber(count++, "weekOfYear", getWeekOfYear()));
		if(getBigWeek() != null) sb.append(__wrapBoolean(count++, "bigWeek", getBigWeek()));
		if(getComments() != null) sb.append(__wrapString(count++, "comments", getComments()));
		if(getLateTime() != null) sb.append(__wrapNumber(count++, "lateTime", getLateTime()));
		if(getIsWorkDay() != null) sb.append(__wrapBoolean(count++, "isWorkDay", getIsWorkDay()));
		if(getOverTime() != null) sb.append(__wrapDecimal(count++, "overTime", getOverTime()));
		if(getLeaveDays() != null) sb.append(__wrapDecimal(count++, "leaveDays", getLeaveDays()));
		if(getLeaveHours() != null) sb.append(__wrapDecimal(count++, "leaveHours", getLeaveHours()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeCheckId")) != null) setEmployeeCheckId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("checkDate")) != null) setCheckDate(__getDate(val)); 
		if((val = values.get("checkInTime")) != null) setCheckInTime(__getDate(val)); 
		if((val = values.get("checkOutTime")) != null) setCheckOutTime(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("oaEmployeeId")) != null) setOaEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("finalStatus")) != null) setFinalStatus(__getBoolean(val));
		if((val = values.get("dayOfWeek")) != null) setDayOfWeek(__getInt(val)); 
		if((val = values.get("weekOfYear")) != null) setWeekOfYear(__getInt(val)); 
		if((val = values.get("bigWeek")) != null) setBigWeek(__getBoolean(val));
		if((val = values.get("comments")) != null) setComments(__getString(val));
		if((val = values.get("lateTime")) != null) setLateTime(__getInt(val)); 
		if((val = values.get("isWorkDay")) != null) setIsWorkDay(__getBoolean(val));
		if((val = values.get("overTime")) != null) setOverTime(__getDecimal(val));  
		if((val = values.get("leaveDays")) != null) setLeaveDays(__getDecimal(val));  
		if((val = values.get("leaveHours")) != null) setLeaveHours(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_check_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __check_date ;
	protected java.util.Date  __check_in_time ;
	protected java.util.Date  __check_out_time ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __oa_employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Boolean  __final_status ;
	protected java.lang.Integer  __day_of_week ;
	protected java.lang.Integer  __week_of_year ;
	protected java.lang.Boolean  __big_week ;
	protected java.lang.String  __comments ;
	protected java.lang.Integer  __late_time ;
	protected java.lang.Boolean  __is_work_day ;
	protected java.math.BigDecimal  __over_time ;
	protected java.math.BigDecimal  __leave_days ;
	protected java.math.BigDecimal  __leave_hours ;
}
