package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeeMonthlyCheck extends GenericBase implements BaseFactory<BaseEmployeeMonthlyCheck>, Comparable<BaseEmployeeMonthlyCheck> 
{


	public static BaseEmployeeMonthlyCheck newInstance(){
		return new BaseEmployeeMonthlyCheck();
	}

	@Override
	public BaseEmployeeMonthlyCheck make(){
		BaseEmployeeMonthlyCheck b = new BaseEmployeeMonthlyCheck();
		return b;
	}

	public final static java.lang.String CS_MONTH_CHECK_ID = "month_check_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_EMPLOYEE_TYPE = "employee_type" ;
	public final static java.lang.String CS_ON_BOARD = "on_board" ;
	public final static java.lang.String CS_DUTY_DATE = "duty_date" ;
	public final static java.lang.String CS_LATE_5M = "late_5m" ;
	public final static java.lang.String CS_LATE_10M = "late_10m" ;
	public final static java.lang.String CS_LATE_30M = "late_30m" ;
	public final static java.lang.String CS_LATE = "late" ;
	public final static java.lang.String CS_THING_LEAVE = "thing_leave" ;
	public final static java.lang.String CS_THING_HOURS = "thing_hours" ;
	public final static java.lang.String CS_ILL_LEAVE = "ill_leave" ;
	public final static java.lang.String CS_OTHER_LEAVE = "other_leave" ;
	public final static java.lang.String CS_WORK_DAYS = "work_days" ;
	public final static java.lang.String CS_NORMAL_OVERTIME = "normal_overtime" ;
	public final static java.lang.String CS_WEEKEND_OVERTIME = "weekend_overtime" ;
	public final static java.lang.String CS_HOLIDAY_OVERTIME = "holiday_overtime" ;
	public final static java.lang.String CS_NORNAL_OVERTIME_HOURS = "nornal_overtime_hours" ;
	public final static java.lang.String CS_WEEKEND_OVERTIME_HOURS = "weekend_overtime_hours" ;
	public final static java.lang.String CS_HOLIDAY_OVERTIME_HOURS = "holiday_overtime_hours" ;
	public final static java.lang.String CS_ABSENCE_DAYS = "absence_days" ;
	public final static java.lang.String CS_THING_DAYS = "thing_days" ;
	public final static java.lang.String CS_ILL_HOURS = "ill_hours" ;
	public final static java.lang.String CS_ILL_DAYS = "ill_days" ;
	public final static java.lang.String CS_OTHER_HOURS = "other_hours" ;
	public final static java.lang.String CS_OTHER_DAYS = "other_days" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,年,月,员工编码,员工号,部门,员工类型,入职日期,转正日期,迟到5分钟,迟到10分钟,迟到30分钟,扣款迟到,事假,事假小时,病假,其他假期,应到天数,平时加班天数,周末加班天数,放假加班天数,平时加班小时,周末加班小时,节假日加班小时,矿工天数,事假天数,病假小时,病假天数,其它假类小时,其它假类天数";

	public java.lang.Integer getMonthCheckId() {
		return this.__month_check_id;
	}

	public void setMonthCheckId( java.lang.Integer value ) {
		this.__month_check_id = value;
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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getEmployeeType() {
		return this.__employee_type;
	}

	public void setEmployeeType( java.lang.Integer value ) {
		this.__employee_type = value;
	}

	public java.util.Date getOnBoard() {
		return this.__on_board;
	}

	public void setOnBoard( java.util.Date value ) {
		this.__on_board = value;
	}

	public java.util.Date getDutyDate() {
		return this.__duty_date;
	}

	public void setDutyDate( java.util.Date value ) {
		this.__duty_date = value;
	}

	public java.lang.Integer getLate5m() {
		return this.__late_5m;
	}

	public void setLate5m( java.lang.Integer value ) {
		this.__late_5m = value;
	}

	public java.lang.Integer getLate10m() {
		return this.__late_10m;
	}

	public void setLate10m( java.lang.Integer value ) {
		this.__late_10m = value;
	}

	public java.lang.Integer getLate30m() {
		return this.__late_30m;
	}

	public void setLate30m( java.lang.Integer value ) {
		this.__late_30m = value;
	}

	public java.lang.Integer getLate() {
		return this.__late;
	}

	public void setLate( java.lang.Integer value ) {
		this.__late = value;
	}

	public java.lang.Integer getThingLeave() {
		return this.__thing_leave;
	}

	public void setThingLeave( java.lang.Integer value ) {
		this.__thing_leave = value;
	}

	public java.math.BigDecimal getThingHours() {
		return this.__thing_hours;
	}

	public void setThingHours( java.math.BigDecimal value ) {
		this.__thing_hours = value;
	}

	public java.lang.Integer getIllLeave() {
		return this.__ill_leave;
	}

	public void setIllLeave( java.lang.Integer value ) {
		this.__ill_leave = value;
	}

	public java.lang.Integer getOtherLeave() {
		return this.__other_leave;
	}

	public void setOtherLeave( java.lang.Integer value ) {
		this.__other_leave = value;
	}

	public java.lang.Integer getWorkDays() {
		return this.__work_days;
	}

	public void setWorkDays( java.lang.Integer value ) {
		this.__work_days = value;
	}

	public java.lang.Integer getNormalOvertime() {
		return this.__normal_overtime;
	}

	public void setNormalOvertime( java.lang.Integer value ) {
		this.__normal_overtime = value;
	}

	public java.lang.Integer getWeekendOvertime() {
		return this.__weekend_overtime;
	}

	public void setWeekendOvertime( java.lang.Integer value ) {
		this.__weekend_overtime = value;
	}

	public java.lang.Integer getHolidayOvertime() {
		return this.__holiday_overtime;
	}

	public void setHolidayOvertime( java.lang.Integer value ) {
		this.__holiday_overtime = value;
	}

	public java.math.BigDecimal getNornalOvertimeHours() {
		return this.__nornal_overtime_hours;
	}

	public void setNornalOvertimeHours( java.math.BigDecimal value ) {
		this.__nornal_overtime_hours = value;
	}

	public java.math.BigDecimal getWeekendOvertimeHours() {
		return this.__weekend_overtime_hours;
	}

	public void setWeekendOvertimeHours( java.math.BigDecimal value ) {
		this.__weekend_overtime_hours = value;
	}

	public java.math.BigDecimal getHolidayOvertimeHours() {
		return this.__holiday_overtime_hours;
	}

	public void setHolidayOvertimeHours( java.math.BigDecimal value ) {
		this.__holiday_overtime_hours = value;
	}

	public java.lang.Integer getAbsenceDays() {
		return this.__absence_days;
	}

	public void setAbsenceDays( java.lang.Integer value ) {
		this.__absence_days = value;
	}

	public java.math.BigDecimal getThingDays() {
		return this.__thing_days;
	}

	public void setThingDays( java.math.BigDecimal value ) {
		this.__thing_days = value;
	}

	public java.math.BigDecimal getIllHours() {
		return this.__ill_hours;
	}

	public void setIllHours( java.math.BigDecimal value ) {
		this.__ill_hours = value;
	}

	public java.math.BigDecimal getIllDays() {
		return this.__ill_days;
	}

	public void setIllDays( java.math.BigDecimal value ) {
		this.__ill_days = value;
	}

	public java.math.BigDecimal getOtherHours() {
		return this.__other_hours;
	}

	public void setOtherHours( java.math.BigDecimal value ) {
		this.__other_hours = value;
	}

	public java.math.BigDecimal getOtherDays() {
		return this.__other_days;
	}

	public void setOtherDays( java.math.BigDecimal value ) {
		this.__other_days = value;
	}

	public void cloneCopy(BaseEmployeeMonthlyCheck __bean){
		__bean.setMonthCheckId(getMonthCheckId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setEmployeeType(getEmployeeType());
		__bean.setOnBoard(getOnBoard());
		__bean.setDutyDate(getDutyDate());
		__bean.setLate5m(getLate5m());
		__bean.setLate10m(getLate10m());
		__bean.setLate30m(getLate30m());
		__bean.setLate(getLate());
		__bean.setThingLeave(getThingLeave());
		__bean.setThingHours(getThingHours());
		__bean.setIllLeave(getIllLeave());
		__bean.setOtherLeave(getOtherLeave());
		__bean.setWorkDays(getWorkDays());
		__bean.setNormalOvertime(getNormalOvertime());
		__bean.setWeekendOvertime(getWeekendOvertime());
		__bean.setHolidayOvertime(getHolidayOvertime());
		__bean.setNornalOvertimeHours(getNornalOvertimeHours());
		__bean.setWeekendOvertimeHours(getWeekendOvertimeHours());
		__bean.setHolidayOvertimeHours(getHolidayOvertimeHours());
		__bean.setAbsenceDays(getAbsenceDays());
		__bean.setThingDays(getThingDays());
		__bean.setIllHours(getIllHours());
		__bean.setIllDays(getIllDays());
		__bean.setOtherHours(getOtherHours());
		__bean.setOtherDays(getOtherDays());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMonthCheckId() == null ? "" : getMonthCheckId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getEmployeeType() == null ? "" : getEmployeeType());
		sb.append(",");
		sb.append(getOnBoard() == null ? "" : sdf.format(getOnBoard()));
		sb.append(",");
		sb.append(getDutyDate() == null ? "" : sdf.format(getDutyDate()));
		sb.append(",");
		sb.append(getLate5m() == null ? "" : getLate5m());
		sb.append(",");
		sb.append(getLate10m() == null ? "" : getLate10m());
		sb.append(",");
		sb.append(getLate30m() == null ? "" : getLate30m());
		sb.append(",");
		sb.append(getLate() == null ? "" : getLate());
		sb.append(",");
		sb.append(getThingLeave() == null ? "" : getThingLeave());
		sb.append(",");
		sb.append(getThingHours() == null ? "" : getThingHours());
		sb.append(",");
		sb.append(getIllLeave() == null ? "" : getIllLeave());
		sb.append(",");
		sb.append(getOtherLeave() == null ? "" : getOtherLeave());
		sb.append(",");
		sb.append(getWorkDays() == null ? "" : getWorkDays());
		sb.append(",");
		sb.append(getNormalOvertime() == null ? "" : getNormalOvertime());
		sb.append(",");
		sb.append(getWeekendOvertime() == null ? "" : getWeekendOvertime());
		sb.append(",");
		sb.append(getHolidayOvertime() == null ? "" : getHolidayOvertime());
		sb.append(",");
		sb.append(getNornalOvertimeHours() == null ? "" : getNornalOvertimeHours());
		sb.append(",");
		sb.append(getWeekendOvertimeHours() == null ? "" : getWeekendOvertimeHours());
		sb.append(",");
		sb.append(getHolidayOvertimeHours() == null ? "" : getHolidayOvertimeHours());
		sb.append(",");
		sb.append(getAbsenceDays() == null ? "" : getAbsenceDays());
		sb.append(",");
		sb.append(getThingDays() == null ? "" : getThingDays());
		sb.append(",");
		sb.append(getIllHours() == null ? "" : getIllHours());
		sb.append(",");
		sb.append(getIllDays() == null ? "" : getIllDays());
		sb.append(",");
		sb.append(getOtherHours() == null ? "" : getOtherHours());
		sb.append(",");
		sb.append(getOtherDays() == null ? "" : getOtherDays());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeMonthlyCheck o) {
		return __month_check_id == null ? -1 : __month_check_id.compareTo(o.getMonthCheckId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__month_check_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_type);
		hash = 97 * hash + Objects.hashCode(this.__on_board);
		hash = 97 * hash + Objects.hashCode(this.__duty_date);
		hash = 97 * hash + Objects.hashCode(this.__late_5m);
		hash = 97 * hash + Objects.hashCode(this.__late_10m);
		hash = 97 * hash + Objects.hashCode(this.__late_30m);
		hash = 97 * hash + Objects.hashCode(this.__late);
		hash = 97 * hash + Objects.hashCode(this.__thing_leave);
		hash = 97 * hash + Objects.hashCode(this.__thing_hours);
		hash = 97 * hash + Objects.hashCode(this.__ill_leave);
		hash = 97 * hash + Objects.hashCode(this.__other_leave);
		hash = 97 * hash + Objects.hashCode(this.__work_days);
		hash = 97 * hash + Objects.hashCode(this.__normal_overtime);
		hash = 97 * hash + Objects.hashCode(this.__weekend_overtime);
		hash = 97 * hash + Objects.hashCode(this.__holiday_overtime);
		hash = 97 * hash + Objects.hashCode(this.__nornal_overtime_hours);
		hash = 97 * hash + Objects.hashCode(this.__weekend_overtime_hours);
		hash = 97 * hash + Objects.hashCode(this.__holiday_overtime_hours);
		hash = 97 * hash + Objects.hashCode(this.__absence_days);
		hash = 97 * hash + Objects.hashCode(this.__thing_days);
		hash = 97 * hash + Objects.hashCode(this.__ill_hours);
		hash = 97 * hash + Objects.hashCode(this.__ill_days);
		hash = 97 * hash + Objects.hashCode(this.__other_hours);
		hash = 97 * hash + Objects.hashCode(this.__other_days);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeMonthlyCheck o = (BaseEmployeeMonthlyCheck)obj;
		if(!Objects.equals(this.__month_check_id, o.getMonthCheckId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__employee_type, o.getEmployeeType())) return false;
		if(!Objects.equals(this.__on_board, o.getOnBoard())) return false;
		if(!Objects.equals(this.__duty_date, o.getDutyDate())) return false;
		if(!Objects.equals(this.__late_5m, o.getLate5m())) return false;
		if(!Objects.equals(this.__late_10m, o.getLate10m())) return false;
		if(!Objects.equals(this.__late_30m, o.getLate30m())) return false;
		if(!Objects.equals(this.__late, o.getLate())) return false;
		if(!Objects.equals(this.__thing_leave, o.getThingLeave())) return false;
		if(!Objects.equals(this.__thing_hours, o.getThingHours())) return false;
		if(!Objects.equals(this.__ill_leave, o.getIllLeave())) return false;
		if(!Objects.equals(this.__other_leave, o.getOtherLeave())) return false;
		if(!Objects.equals(this.__work_days, o.getWorkDays())) return false;
		if(!Objects.equals(this.__normal_overtime, o.getNormalOvertime())) return false;
		if(!Objects.equals(this.__weekend_overtime, o.getWeekendOvertime())) return false;
		if(!Objects.equals(this.__holiday_overtime, o.getHolidayOvertime())) return false;
		if(!Objects.equals(this.__nornal_overtime_hours, o.getNornalOvertimeHours())) return false;
		if(!Objects.equals(this.__weekend_overtime_hours, o.getWeekendOvertimeHours())) return false;
		if(!Objects.equals(this.__holiday_overtime_hours, o.getHolidayOvertimeHours())) return false;
		if(!Objects.equals(this.__absence_days, o.getAbsenceDays())) return false;
		if(!Objects.equals(this.__thing_days, o.getThingDays())) return false;
		if(!Objects.equals(this.__ill_hours, o.getIllHours())) return false;
		if(!Objects.equals(this.__ill_days, o.getIllDays())) return false;
		if(!Objects.equals(this.__other_hours, o.getOtherHours())) return false;
		if(!Objects.equals(this.__other_days, o.getOtherDays())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMonthCheckId() != null) sb.append(__wrapNumber(count++, "monthCheckId", getMonthCheckId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getEmployeeType() != null) sb.append(__wrapNumber(count++, "employeeType", getEmployeeType()));
		if(getOnBoard() != null) sb.append(__wrapDate(count++, "onBoard", getOnBoard()));
		if(getDutyDate() != null) sb.append(__wrapDate(count++, "dutyDate", getDutyDate()));
		if(getLate5m() != null) sb.append(__wrapNumber(count++, "late5m", getLate5m()));
		if(getLate10m() != null) sb.append(__wrapNumber(count++, "late10m", getLate10m()));
		if(getLate30m() != null) sb.append(__wrapNumber(count++, "late30m", getLate30m()));
		if(getLate() != null) sb.append(__wrapNumber(count++, "late", getLate()));
		if(getThingLeave() != null) sb.append(__wrapNumber(count++, "thingLeave", getThingLeave()));
		if(getThingHours() != null) sb.append(__wrapDecimal(count++, "thingHours", getThingHours()));
		if(getIllLeave() != null) sb.append(__wrapNumber(count++, "illLeave", getIllLeave()));
		if(getOtherLeave() != null) sb.append(__wrapNumber(count++, "otherLeave", getOtherLeave()));
		if(getWorkDays() != null) sb.append(__wrapNumber(count++, "workDays", getWorkDays()));
		if(getNormalOvertime() != null) sb.append(__wrapNumber(count++, "normalOvertime", getNormalOvertime()));
		if(getWeekendOvertime() != null) sb.append(__wrapNumber(count++, "weekendOvertime", getWeekendOvertime()));
		if(getHolidayOvertime() != null) sb.append(__wrapNumber(count++, "holidayOvertime", getHolidayOvertime()));
		if(getNornalOvertimeHours() != null) sb.append(__wrapDecimal(count++, "nornalOvertimeHours", getNornalOvertimeHours()));
		if(getWeekendOvertimeHours() != null) sb.append(__wrapDecimal(count++, "weekendOvertimeHours", getWeekendOvertimeHours()));
		if(getHolidayOvertimeHours() != null) sb.append(__wrapDecimal(count++, "holidayOvertimeHours", getHolidayOvertimeHours()));
		if(getAbsenceDays() != null) sb.append(__wrapNumber(count++, "absenceDays", getAbsenceDays()));
		if(getThingDays() != null) sb.append(__wrapDecimal(count++, "thingDays", getThingDays()));
		if(getIllHours() != null) sb.append(__wrapDecimal(count++, "illHours", getIllHours()));
		if(getIllDays() != null) sb.append(__wrapDecimal(count++, "illDays", getIllDays()));
		if(getOtherHours() != null) sb.append(__wrapDecimal(count++, "otherHours", getOtherHours()));
		if(getOtherDays() != null) sb.append(__wrapDecimal(count++, "otherDays", getOtherDays()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("monthCheckId")) != null) setMonthCheckId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeType")) != null) setEmployeeType(__getInt(val)); 
		if((val = values.get("onBoard")) != null) setOnBoard(__getDate(val)); 
		if((val = values.get("dutyDate")) != null) setDutyDate(__getDate(val)); 
		if((val = values.get("late5m")) != null) setLate5m(__getInt(val)); 
		if((val = values.get("late10m")) != null) setLate10m(__getInt(val)); 
		if((val = values.get("late30m")) != null) setLate30m(__getInt(val)); 
		if((val = values.get("late")) != null) setLate(__getInt(val)); 
		if((val = values.get("thingLeave")) != null) setThingLeave(__getInt(val)); 
		if((val = values.get("thingHours")) != null) setThingHours(__getDecimal(val));  
		if((val = values.get("illLeave")) != null) setIllLeave(__getInt(val)); 
		if((val = values.get("otherLeave")) != null) setOtherLeave(__getInt(val)); 
		if((val = values.get("workDays")) != null) setWorkDays(__getInt(val)); 
		if((val = values.get("normalOvertime")) != null) setNormalOvertime(__getInt(val)); 
		if((val = values.get("weekendOvertime")) != null) setWeekendOvertime(__getInt(val)); 
		if((val = values.get("holidayOvertime")) != null) setHolidayOvertime(__getInt(val)); 
		if((val = values.get("nornalOvertimeHours")) != null) setNornalOvertimeHours(__getDecimal(val));  
		if((val = values.get("weekendOvertimeHours")) != null) setWeekendOvertimeHours(__getDecimal(val));  
		if((val = values.get("holidayOvertimeHours")) != null) setHolidayOvertimeHours(__getDecimal(val));  
		if((val = values.get("absenceDays")) != null) setAbsenceDays(__getInt(val)); 
		if((val = values.get("thingDays")) != null) setThingDays(__getDecimal(val));  
		if((val = values.get("illHours")) != null) setIllHours(__getDecimal(val));  
		if((val = values.get("illDays")) != null) setIllDays(__getDecimal(val));  
		if((val = values.get("otherHours")) != null) setOtherHours(__getDecimal(val));  
		if((val = values.get("otherDays")) != null) setOtherDays(__getDecimal(val));  
	}

	protected java.lang.Integer  __month_check_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __employee_type ;
	protected java.util.Date  __on_board ;
	protected java.util.Date  __duty_date ;
	protected java.lang.Integer  __late_5m ;
	protected java.lang.Integer  __late_10m ;
	protected java.lang.Integer  __late_30m ;
	protected java.lang.Integer  __late ;
	protected java.lang.Integer  __thing_leave ;
	protected java.math.BigDecimal  __thing_hours ;
	protected java.lang.Integer  __ill_leave ;
	protected java.lang.Integer  __other_leave ;
	protected java.lang.Integer  __work_days ;
	protected java.lang.Integer  __normal_overtime ;
	protected java.lang.Integer  __weekend_overtime ;
	protected java.lang.Integer  __holiday_overtime ;
	protected java.math.BigDecimal  __nornal_overtime_hours ;
	protected java.math.BigDecimal  __weekend_overtime_hours ;
	protected java.math.BigDecimal  __holiday_overtime_hours ;
	protected java.lang.Integer  __absence_days ;
	protected java.math.BigDecimal  __thing_days ;
	protected java.math.BigDecimal  __ill_hours ;
	protected java.math.BigDecimal  __ill_days ;
	protected java.math.BigDecimal  __other_hours ;
	protected java.math.BigDecimal  __other_days ;
}
