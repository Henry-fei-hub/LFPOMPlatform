package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseAttendanceRecord extends GenericBase implements BaseFactory<BaseAttendanceRecord>, Comparable<BaseAttendanceRecord> 
{


	public static BaseAttendanceRecord newInstance(){
		return new BaseAttendanceRecord();
	}

	@Override
	public BaseAttendanceRecord make(){
		BaseAttendanceRecord b = new BaseAttendanceRecord();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_DAY_CHECK_ID = "employee_day_check_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_SHIFT_MANAGE_ID = "shift_manage_id" ;
	public final static java.lang.String CS_CHECKIN = "checkin" ;
	public final static java.lang.String CS_CHECKOUT = "checkout" ;
	public final static java.lang.String CS_LATE_LEAVE_5M = "late_leave_5m" ;
	public final static java.lang.String CS_LATE_LEAVE_10M = "late_leave_10m" ;
	public final static java.lang.String CS_LATE_LEAVE_30M = "late_leave_30m" ;
	public final static java.lang.String CS_LATE_LEAVE = "late_leave" ;
	public final static java.lang.String CS_THING_LEAVE_TIMES = "thing_leave_times" ;
	public final static java.lang.String CS_THING_LEAVE_HOURS = "thing_leave_hours" ;
	public final static java.lang.String CS_THING_LEAVE_DAYS = "thing_leave_days" ;
	public final static java.lang.String CS_ILL_LEAVE_TIMES = "ill_leave_times" ;
	public final static java.lang.String CS_ILL_LEAVE_HOURS = "ill_leave_hours" ;
	public final static java.lang.String CS_ILL_LEAVE_DAYS = "ill_leave_days" ;
	public final static java.lang.String CS_OTHER_LEAVE_TIMES = "other_leave_times" ;
	public final static java.lang.String CS_OTHER_LEAVE_HOURS = "other_leave_hours" ;
	public final static java.lang.String CS_OTHER_LEAVE_DAYS = "other_leave_days" ;
	public final static java.lang.String CS_NORNAL_OVERTIME_HOURS = "nornal_overtime_hours" ;
	public final static java.lang.String CS_WEEKEND_OVERTIME_HOURS = "weekend_overtime_hours" ;
	public final static java.lang.String CS_HOLIDAY_OVERTIME_HOURS = "holiday_overtime_hours" ;
	public final static java.lang.String CS_ABSENCE_DAYS = "absence_days" ;
	public final static java.lang.String CS_SHOULD_DAYS = "should_days" ;
	public final static java.lang.String CS_FACT_DAYS = "fact_days" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,姓名,年份,月份,日期,班次,上班时间,下班时间,迟到/早退5分钟,迟到/早退10分钟,迟到/早退30分钟,扣款迟到/早退,事假次数,事假小时数,事假天数,病假次数,病假小时数,病假天数,其它假类次数,其它假类小时数,其它假类天数,平时加班小时数,周末加班小时数,节假日加班小时数,旷工天数,应到天数,实到天数,考勤状态,操作人,操作时间,备注";

	public java.lang.Integer getEmployeeDayCheckId() {
		return this.__employee_day_check_id;
	}

	public void setEmployeeDayCheckId( java.lang.Integer value ) {
		this.__employee_day_check_id = value;
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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getShiftManageId() {
		return this.__shift_manage_id;
	}

	public void setShiftManageId( java.lang.Integer value ) {
		this.__shift_manage_id = value;
	}

	public java.util.Date getCheckin() {
		return this.__checkin;
	}

	public void setCheckin( java.util.Date value ) {
		this.__checkin = value;
	}

	public java.util.Date getCheckout() {
		return this.__checkout;
	}

	public void setCheckout( java.util.Date value ) {
		this.__checkout = value;
	}

	public java.lang.Integer getLateLeave5m() {
		return this.__late_leave_5m;
	}

	public void setLateLeave5m( java.lang.Integer value ) {
		this.__late_leave_5m = value;
	}

	public java.lang.Integer getLateLeave10m() {
		return this.__late_leave_10m;
	}

	public void setLateLeave10m( java.lang.Integer value ) {
		this.__late_leave_10m = value;
	}

	public java.lang.Integer getLateLeave30m() {
		return this.__late_leave_30m;
	}

	public void setLateLeave30m( java.lang.Integer value ) {
		this.__late_leave_30m = value;
	}

	public java.lang.Integer getLateLeave() {
		return this.__late_leave;
	}

	public void setLateLeave( java.lang.Integer value ) {
		this.__late_leave = value;
	}

	public java.lang.Integer getThingLeaveTimes() {
		return this.__thing_leave_times;
	}

	public void setThingLeaveTimes( java.lang.Integer value ) {
		this.__thing_leave_times = value;
	}

	public java.math.BigDecimal getThingLeaveHours() {
		return this.__thing_leave_hours;
	}

	public void setThingLeaveHours( java.math.BigDecimal value ) {
		this.__thing_leave_hours = value;
	}

	public java.math.BigDecimal getThingLeaveDays() {
		return this.__thing_leave_days;
	}

	public void setThingLeaveDays( java.math.BigDecimal value ) {
		this.__thing_leave_days = value;
	}

	public java.lang.Integer getIllLeaveTimes() {
		return this.__ill_leave_times;
	}

	public void setIllLeaveTimes( java.lang.Integer value ) {
		this.__ill_leave_times = value;
	}

	public java.math.BigDecimal getIllLeaveHours() {
		return this.__ill_leave_hours;
	}

	public void setIllLeaveHours( java.math.BigDecimal value ) {
		this.__ill_leave_hours = value;
	}

	public java.math.BigDecimal getIllLeaveDays() {
		return this.__ill_leave_days;
	}

	public void setIllLeaveDays( java.math.BigDecimal value ) {
		this.__ill_leave_days = value;
	}

	public java.lang.Integer getOtherLeaveTimes() {
		return this.__other_leave_times;
	}

	public void setOtherLeaveTimes( java.lang.Integer value ) {
		this.__other_leave_times = value;
	}

	public java.math.BigDecimal getOtherLeaveHours() {
		return this.__other_leave_hours;
	}

	public void setOtherLeaveHours( java.math.BigDecimal value ) {
		this.__other_leave_hours = value;
	}

	public java.math.BigDecimal getOtherLeaveDays() {
		return this.__other_leave_days;
	}

	public void setOtherLeaveDays( java.math.BigDecimal value ) {
		this.__other_leave_days = value;
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

	public java.math.BigDecimal getAbsenceDays() {
		return this.__absence_days;
	}

	public void setAbsenceDays( java.math.BigDecimal value ) {
		this.__absence_days = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public void cloneCopy(BaseAttendanceRecord __bean){
		__bean.setEmployeeDayCheckId(getEmployeeDayCheckId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRecordDate(getRecordDate());
		__bean.setShiftManageId(getShiftManageId());
		__bean.setCheckin(getCheckin());
		__bean.setCheckout(getCheckout());
		__bean.setLateLeave5m(getLateLeave5m());
		__bean.setLateLeave10m(getLateLeave10m());
		__bean.setLateLeave30m(getLateLeave30m());
		__bean.setLateLeave(getLateLeave());
		__bean.setThingLeaveTimes(getThingLeaveTimes());
		__bean.setThingLeaveHours(getThingLeaveHours());
		__bean.setThingLeaveDays(getThingLeaveDays());
		__bean.setIllLeaveTimes(getIllLeaveTimes());
		__bean.setIllLeaveHours(getIllLeaveHours());
		__bean.setIllLeaveDays(getIllLeaveDays());
		__bean.setOtherLeaveTimes(getOtherLeaveTimes());
		__bean.setOtherLeaveHours(getOtherLeaveHours());
		__bean.setOtherLeaveDays(getOtherLeaveDays());
		__bean.setNornalOvertimeHours(getNornalOvertimeHours());
		__bean.setWeekendOvertimeHours(getWeekendOvertimeHours());
		__bean.setHolidayOvertimeHours(getHolidayOvertimeHours());
		__bean.setAbsenceDays(getAbsenceDays());
		__bean.setShouldDays(getShouldDays());
		__bean.setFactDays(getFactDays());
		__bean.setStatus(getStatus());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeDayCheckId() == null ? "" : getEmployeeDayCheckId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strYear = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_18", String.valueOf(getYear()));
		sb.append(strYear == null ? "" : strYear);
		sb.append(",");
		String strMonth = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_19", String.valueOf(getMonth()));
		sb.append(strMonth == null ? "" : strMonth);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getShiftManageId() == null ? "" : getShiftManageId());
		sb.append(",");
		sb.append(getCheckin() == null ? "" : sdf.format(getCheckin()));
		sb.append(",");
		sb.append(getCheckout() == null ? "" : sdf.format(getCheckout()));
		sb.append(",");
		sb.append(getLateLeave5m() == null ? "" : getLateLeave5m());
		sb.append(",");
		sb.append(getLateLeave10m() == null ? "" : getLateLeave10m());
		sb.append(",");
		sb.append(getLateLeave30m() == null ? "" : getLateLeave30m());
		sb.append(",");
		sb.append(getLateLeave() == null ? "" : getLateLeave());
		sb.append(",");
		sb.append(getThingLeaveTimes() == null ? "" : getThingLeaveTimes());
		sb.append(",");
		sb.append(getThingLeaveHours() == null ? "" : getThingLeaveHours());
		sb.append(",");
		sb.append(getThingLeaveDays() == null ? "" : getThingLeaveDays());
		sb.append(",");
		sb.append(getIllLeaveTimes() == null ? "" : getIllLeaveTimes());
		sb.append(",");
		sb.append(getIllLeaveHours() == null ? "" : getIllLeaveHours());
		sb.append(",");
		sb.append(getIllLeaveDays() == null ? "" : getIllLeaveDays());
		sb.append(",");
		sb.append(getOtherLeaveTimes() == null ? "" : getOtherLeaveTimes());
		sb.append(",");
		sb.append(getOtherLeaveHours() == null ? "" : getOtherLeaveHours());
		sb.append(",");
		sb.append(getOtherLeaveDays() == null ? "" : getOtherLeaveDays());
		sb.append(",");
		sb.append(getNornalOvertimeHours() == null ? "" : getNornalOvertimeHours());
		sb.append(",");
		sb.append(getWeekendOvertimeHours() == null ? "" : getWeekendOvertimeHours());
		sb.append(",");
		sb.append(getHolidayOvertimeHours() == null ? "" : getHolidayOvertimeHours());
		sb.append(",");
		sb.append(getAbsenceDays() == null ? "" : getAbsenceDays());
		sb.append(",");
		sb.append(getShouldDays() == null ? "" : getShouldDays());
		sb.append(",");
		sb.append(getFactDays() == null ? "" : getFactDays());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_16", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceRecord o) {
		return __employee_day_check_id == null ? -1 : __employee_day_check_id.compareTo(o.getEmployeeDayCheckId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_day_check_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__shift_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__checkin);
		hash = 97 * hash + Objects.hashCode(this.__checkout);
		hash = 97 * hash + Objects.hashCode(this.__late_leave_5m);
		hash = 97 * hash + Objects.hashCode(this.__late_leave_10m);
		hash = 97 * hash + Objects.hashCode(this.__late_leave_30m);
		hash = 97 * hash + Objects.hashCode(this.__late_leave);
		hash = 97 * hash + Objects.hashCode(this.__thing_leave_times);
		hash = 97 * hash + Objects.hashCode(this.__thing_leave_hours);
		hash = 97 * hash + Objects.hashCode(this.__thing_leave_days);
		hash = 97 * hash + Objects.hashCode(this.__ill_leave_times);
		hash = 97 * hash + Objects.hashCode(this.__ill_leave_hours);
		hash = 97 * hash + Objects.hashCode(this.__ill_leave_days);
		hash = 97 * hash + Objects.hashCode(this.__other_leave_times);
		hash = 97 * hash + Objects.hashCode(this.__other_leave_hours);
		hash = 97 * hash + Objects.hashCode(this.__other_leave_days);
		hash = 97 * hash + Objects.hashCode(this.__nornal_overtime_hours);
		hash = 97 * hash + Objects.hashCode(this.__weekend_overtime_hours);
		hash = 97 * hash + Objects.hashCode(this.__holiday_overtime_hours);
		hash = 97 * hash + Objects.hashCode(this.__absence_days);
		hash = 97 * hash + Objects.hashCode(this.__should_days);
		hash = 97 * hash + Objects.hashCode(this.__fact_days);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceRecord o = (BaseAttendanceRecord)obj;
		if(!Objects.equals(this.__employee_day_check_id, o.getEmployeeDayCheckId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__shift_manage_id, o.getShiftManageId())) return false;
		if(!Objects.equals(this.__checkin, o.getCheckin())) return false;
		if(!Objects.equals(this.__checkout, o.getCheckout())) return false;
		if(!Objects.equals(this.__late_leave_5m, o.getLateLeave5m())) return false;
		if(!Objects.equals(this.__late_leave_10m, o.getLateLeave10m())) return false;
		if(!Objects.equals(this.__late_leave_30m, o.getLateLeave30m())) return false;
		if(!Objects.equals(this.__late_leave, o.getLateLeave())) return false;
		if(!Objects.equals(this.__thing_leave_times, o.getThingLeaveTimes())) return false;
		if(!Objects.equals(this.__thing_leave_hours, o.getThingLeaveHours())) return false;
		if(!Objects.equals(this.__thing_leave_days, o.getThingLeaveDays())) return false;
		if(!Objects.equals(this.__ill_leave_times, o.getIllLeaveTimes())) return false;
		if(!Objects.equals(this.__ill_leave_hours, o.getIllLeaveHours())) return false;
		if(!Objects.equals(this.__ill_leave_days, o.getIllLeaveDays())) return false;
		if(!Objects.equals(this.__other_leave_times, o.getOtherLeaveTimes())) return false;
		if(!Objects.equals(this.__other_leave_hours, o.getOtherLeaveHours())) return false;
		if(!Objects.equals(this.__other_leave_days, o.getOtherLeaveDays())) return false;
		if(!Objects.equals(this.__nornal_overtime_hours, o.getNornalOvertimeHours())) return false;
		if(!Objects.equals(this.__weekend_overtime_hours, o.getWeekendOvertimeHours())) return false;
		if(!Objects.equals(this.__holiday_overtime_hours, o.getHolidayOvertimeHours())) return false;
		if(!Objects.equals(this.__absence_days, o.getAbsenceDays())) return false;
		if(!Objects.equals(this.__should_days, o.getShouldDays())) return false;
		if(!Objects.equals(this.__fact_days, o.getFactDays())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeDayCheckId() != null) sb.append(__wrapNumber(count++, "employeeDayCheckId", getEmployeeDayCheckId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getShiftManageId() != null) sb.append(__wrapNumber(count++, "shiftManageId", getShiftManageId()));
		if(getCheckin() != null) sb.append(__wrapDate(count++, "checkin", getCheckin()));
		if(getCheckout() != null) sb.append(__wrapDate(count++, "checkout", getCheckout()));
		if(getLateLeave5m() != null) sb.append(__wrapNumber(count++, "lateLeave5m", getLateLeave5m()));
		if(getLateLeave10m() != null) sb.append(__wrapNumber(count++, "lateLeave10m", getLateLeave10m()));
		if(getLateLeave30m() != null) sb.append(__wrapNumber(count++, "lateLeave30m", getLateLeave30m()));
		if(getLateLeave() != null) sb.append(__wrapNumber(count++, "lateLeave", getLateLeave()));
		if(getThingLeaveTimes() != null) sb.append(__wrapNumber(count++, "thingLeaveTimes", getThingLeaveTimes()));
		if(getThingLeaveHours() != null) sb.append(__wrapDecimal(count++, "thingLeaveHours", getThingLeaveHours()));
		if(getThingLeaveDays() != null) sb.append(__wrapDecimal(count++, "thingLeaveDays", getThingLeaveDays()));
		if(getIllLeaveTimes() != null) sb.append(__wrapNumber(count++, "illLeaveTimes", getIllLeaveTimes()));
		if(getIllLeaveHours() != null) sb.append(__wrapDecimal(count++, "illLeaveHours", getIllLeaveHours()));
		if(getIllLeaveDays() != null) sb.append(__wrapDecimal(count++, "illLeaveDays", getIllLeaveDays()));
		if(getOtherLeaveTimes() != null) sb.append(__wrapNumber(count++, "otherLeaveTimes", getOtherLeaveTimes()));
		if(getOtherLeaveHours() != null) sb.append(__wrapDecimal(count++, "otherLeaveHours", getOtherLeaveHours()));
		if(getOtherLeaveDays() != null) sb.append(__wrapDecimal(count++, "otherLeaveDays", getOtherLeaveDays()));
		if(getNornalOvertimeHours() != null) sb.append(__wrapDecimal(count++, "nornalOvertimeHours", getNornalOvertimeHours()));
		if(getWeekendOvertimeHours() != null) sb.append(__wrapDecimal(count++, "weekendOvertimeHours", getWeekendOvertimeHours()));
		if(getHolidayOvertimeHours() != null) sb.append(__wrapDecimal(count++, "holidayOvertimeHours", getHolidayOvertimeHours()));
		if(getAbsenceDays() != null) sb.append(__wrapDecimal(count++, "absenceDays", getAbsenceDays()));
		if(getShouldDays() != null) sb.append(__wrapDecimal(count++, "shouldDays", getShouldDays()));
		if(getFactDays() != null) sb.append(__wrapDecimal(count++, "factDays", getFactDays()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeDayCheckId")) != null) setEmployeeDayCheckId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("shiftManageId")) != null) setShiftManageId(__getInt(val)); 
		if((val = values.get("checkin")) != null) setCheckin(__getDate(val)); 
		if((val = values.get("checkout")) != null) setCheckout(__getDate(val)); 
		if((val = values.get("lateLeave5m")) != null) setLateLeave5m(__getInt(val)); 
		if((val = values.get("lateLeave10m")) != null) setLateLeave10m(__getInt(val)); 
		if((val = values.get("lateLeave30m")) != null) setLateLeave30m(__getInt(val)); 
		if((val = values.get("lateLeave")) != null) setLateLeave(__getInt(val)); 
		if((val = values.get("thingLeaveTimes")) != null) setThingLeaveTimes(__getInt(val)); 
		if((val = values.get("thingLeaveHours")) != null) setThingLeaveHours(__getDecimal(val));  
		if((val = values.get("thingLeaveDays")) != null) setThingLeaveDays(__getDecimal(val));  
		if((val = values.get("illLeaveTimes")) != null) setIllLeaveTimes(__getInt(val)); 
		if((val = values.get("illLeaveHours")) != null) setIllLeaveHours(__getDecimal(val));  
		if((val = values.get("illLeaveDays")) != null) setIllLeaveDays(__getDecimal(val));  
		if((val = values.get("otherLeaveTimes")) != null) setOtherLeaveTimes(__getInt(val)); 
		if((val = values.get("otherLeaveHours")) != null) setOtherLeaveHours(__getDecimal(val));  
		if((val = values.get("otherLeaveDays")) != null) setOtherLeaveDays(__getDecimal(val));  
		if((val = values.get("nornalOvertimeHours")) != null) setNornalOvertimeHours(__getDecimal(val));  
		if((val = values.get("weekendOvertimeHours")) != null) setWeekendOvertimeHours(__getDecimal(val));  
		if((val = values.get("holidayOvertimeHours")) != null) setHolidayOvertimeHours(__getDecimal(val));  
		if((val = values.get("absenceDays")) != null) setAbsenceDays(__getDecimal(val));  
		if((val = values.get("shouldDays")) != null) setShouldDays(__getDecimal(val));  
		if((val = values.get("factDays")) != null) setFactDays(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __employee_day_check_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __shift_manage_id ;
	protected java.util.Date  __checkin ;
	protected java.util.Date  __checkout ;
	protected java.lang.Integer  __late_leave_5m ;
	protected java.lang.Integer  __late_leave_10m ;
	protected java.lang.Integer  __late_leave_30m ;
	protected java.lang.Integer  __late_leave ;
	protected java.lang.Integer  __thing_leave_times ;
	protected java.math.BigDecimal  __thing_leave_hours ;
	protected java.math.BigDecimal  __thing_leave_days ;
	protected java.lang.Integer  __ill_leave_times ;
	protected java.math.BigDecimal  __ill_leave_hours ;
	protected java.math.BigDecimal  __ill_leave_days ;
	protected java.lang.Integer  __other_leave_times ;
	protected java.math.BigDecimal  __other_leave_hours ;
	protected java.math.BigDecimal  __other_leave_days ;
	protected java.math.BigDecimal  __nornal_overtime_hours ;
	protected java.math.BigDecimal  __weekend_overtime_hours ;
	protected java.math.BigDecimal  __holiday_overtime_hours ;
	protected java.math.BigDecimal  __absence_days ;
	protected java.math.BigDecimal  __should_days ;
	protected java.math.BigDecimal  __fact_days ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.String  __remark ;
}
