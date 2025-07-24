package pomplatform.shift.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnGetEmployeeMonthCheck extends GenericBase implements BaseFactory<BaseOnGetEmployeeMonthCheck>, Comparable<BaseOnGetEmployeeMonthCheck> 
{


	public static BaseOnGetEmployeeMonthCheck newInstance(){
		return new BaseOnGetEmployeeMonthCheck();
	}

	@Override
	public BaseOnGetEmployeeMonthCheck make(){
		BaseOnGetEmployeeMonthCheck b = new BaseOnGetEmployeeMonthCheck();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
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
	public final static java.lang.String CS_NUMBER_OF_LATE = "number_of_late" ;
	public final static java.lang.String CS_LATE_FOR_MINUTES = "late_for_minutes" ;
	public final static java.lang.String CS_NUMBER_OF_LEAVE = "number_of_leave" ;
	public final static java.lang.String CS_LEAVE_FOR_MINUTES = "leave_for_minutes" ;
	public final static java.lang.String CS_LATE_CHARGE = "late_charge" ;
	public final static java.lang.String CS_ADJUST = "adjust" ;
	public final static java.lang.String CS_ANNUAL_LEAVE = "annual_leave" ;
	public final static java.lang.String CS_WEDDING_LEAVE = "wedding_leave" ;
	public final static java.lang.String CS_MATERNITY_LEAVE = "maternity_leave" ;
	public final static java.lang.String CS_PRENATAL_CHECK_LEAVE = "prenatal_check_leave" ;
	public final static java.lang.String CS_MATERNITY_LEAVE_DAYS = "maternity_leave_days" ;
	public final static java.lang.String CS_FUNERAL_LEAVE = "funeral_leave" ;
	public final static java.lang.String CS_OUT_FOR_BUSINESS = "out_for_business" ;
	public final static java.lang.String CS_OVERTIME_PAY = "overtime_pay" ;
	public final static java.lang.String CS_OVERTIME_PAY_SUB = "overtime_pay_sub" ;
	public final static java.lang.String CS_OVERTIME_PAY_BEFORE = "overtime_pay_before" ;
	public final static java.lang.String CS_OVERTIME_PAY_SUB_BEFORE = "overtime_pay_sub_before" ;
	public final static java.lang.String CS_IS_FULL_TIME = "is_full_time" ;
	public final static java.lang.String CS_IS_LOCKED = "is_locked" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,员工编号,员工姓名,部门,在职状态,年份,月份,迟到/早退5分钟,迟到/早退10分钟,迟到/早退30分钟,扣款迟到/早退,事假次数,事假小时数,事假天数,病假次数,病假小时数,病假天数,其它假类次数,其它假类小时数,其它假类天数,平时加班小时数,周末加班小时数,节假日加班小时数,旷工天数,应到天数,实到天数,迟到次数,迟到分钟,早退次数,早退分钟,迟到扣款,调休假(小时),年假天数,婚假天数,产假天数,产检假天数,陪产假天数,丧假天数,因公外出次数,加班餐补(本月),加班补助(本月),加班餐补,加班补助,是否全勤,是否加锁";

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

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
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

	public java.math.BigDecimal getNumberOfLate() {
		return this.__number_of_late;
	}

	public void setNumberOfLate( java.math.BigDecimal value ) {
		this.__number_of_late = value;
	}

	public java.math.BigDecimal getLateForMinutes() {
		return this.__late_for_minutes;
	}

	public void setLateForMinutes( java.math.BigDecimal value ) {
		this.__late_for_minutes = value;
	}

	public java.math.BigDecimal getNumberOfLeave() {
		return this.__number_of_leave;
	}

	public void setNumberOfLeave( java.math.BigDecimal value ) {
		this.__number_of_leave = value;
	}

	public java.math.BigDecimal getLeaveForMinutes() {
		return this.__leave_for_minutes;
	}

	public void setLeaveForMinutes( java.math.BigDecimal value ) {
		this.__leave_for_minutes = value;
	}

	public java.math.BigDecimal getLateCharge() {
		return this.__late_charge;
	}

	public void setLateCharge( java.math.BigDecimal value ) {
		this.__late_charge = value;
	}

	public java.math.BigDecimal getAdjust() {
		return this.__adjust;
	}

	public void setAdjust( java.math.BigDecimal value ) {
		this.__adjust = value;
	}

	public java.math.BigDecimal getAnnualLeave() {
		return this.__annual_leave;
	}

	public void setAnnualLeave( java.math.BigDecimal value ) {
		this.__annual_leave = value;
	}

	public java.math.BigDecimal getWeddingLeave() {
		return this.__wedding_leave;
	}

	public void setWeddingLeave( java.math.BigDecimal value ) {
		this.__wedding_leave = value;
	}

	public java.math.BigDecimal getMaternityLeave() {
		return this.__maternity_leave;
	}

	public void setMaternityLeave( java.math.BigDecimal value ) {
		this.__maternity_leave = value;
	}

	public java.math.BigDecimal getPrenatalCheckLeave() {
		return this.__prenatal_check_leave;
	}

	public void setPrenatalCheckLeave( java.math.BigDecimal value ) {
		this.__prenatal_check_leave = value;
	}

	public java.math.BigDecimal getMaternityLeaveDays() {
		return this.__maternity_leave_days;
	}

	public void setMaternityLeaveDays( java.math.BigDecimal value ) {
		this.__maternity_leave_days = value;
	}

	public java.math.BigDecimal getFuneralLeave() {
		return this.__funeral_leave;
	}

	public void setFuneralLeave( java.math.BigDecimal value ) {
		this.__funeral_leave = value;
	}

	public java.math.BigDecimal getOutForBusiness() {
		return this.__out_for_business;
	}

	public void setOutForBusiness( java.math.BigDecimal value ) {
		this.__out_for_business = value;
	}

	public java.math.BigDecimal getOvertimePay() {
		return this.__overtime_pay;
	}

	public void setOvertimePay( java.math.BigDecimal value ) {
		this.__overtime_pay = value;
	}

	public java.math.BigDecimal getOvertimePaySub() {
		return this.__overtime_pay_sub;
	}

	public void setOvertimePaySub( java.math.BigDecimal value ) {
		this.__overtime_pay_sub = value;
	}

	public java.math.BigDecimal getOvertimePayBefore() {
		return this.__overtime_pay_before;
	}

	public void setOvertimePayBefore( java.math.BigDecimal value ) {
		this.__overtime_pay_before = value;
	}

	public java.math.BigDecimal getOvertimePaySubBefore() {
		return this.__overtime_pay_sub_before;
	}

	public void setOvertimePaySubBefore( java.math.BigDecimal value ) {
		this.__overtime_pay_sub_before = value;
	}

	public java.lang.Boolean getIsFullTime() {
		return this.__is_full_time;
	}

	public void setIsFullTime( java.lang.Boolean value ) {
		this.__is_full_time = value;
	}

	public java.lang.Boolean getIsLocked() {
		return this.__is_locked;
	}

	public void setIsLocked( java.lang.Boolean value ) {
		this.__is_locked = value;
	}

	public void cloneCopy(BaseOnGetEmployeeMonthCheck __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setStatus(getStatus());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
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
		__bean.setNumberOfLate(getNumberOfLate());
		__bean.setLateForMinutes(getLateForMinutes());
		__bean.setNumberOfLeave(getNumberOfLeave());
		__bean.setLeaveForMinutes(getLeaveForMinutes());
		__bean.setLateCharge(getLateCharge());
		__bean.setAdjust(getAdjust());
		__bean.setAnnualLeave(getAnnualLeave());
		__bean.setWeddingLeave(getWeddingLeave());
		__bean.setMaternityLeave(getMaternityLeave());
		__bean.setPrenatalCheckLeave(getPrenatalCheckLeave());
		__bean.setMaternityLeaveDays(getMaternityLeaveDays());
		__bean.setFuneralLeave(getFuneralLeave());
		__bean.setOutForBusiness(getOutForBusiness());
		__bean.setOvertimePay(getOvertimePay());
		__bean.setOvertimePaySub(getOvertimePaySub());
		__bean.setOvertimePayBefore(getOvertimePayBefore());
		__bean.setOvertimePaySubBefore(getOvertimePaySubBefore());
		__bean.setIsFullTime(getIsFullTime());
		__bean.setIsLocked(getIsLocked());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
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
		sb.append(getNumberOfLate() == null ? "" : getNumberOfLate());
		sb.append(",");
		sb.append(getLateForMinutes() == null ? "" : getLateForMinutes());
		sb.append(",");
		sb.append(getNumberOfLeave() == null ? "" : getNumberOfLeave());
		sb.append(",");
		sb.append(getLeaveForMinutes() == null ? "" : getLeaveForMinutes());
		sb.append(",");
		sb.append(getLateCharge() == null ? "" : getLateCharge());
		sb.append(",");
		sb.append(getAdjust() == null ? "" : getAdjust());
		sb.append(",");
		sb.append(getAnnualLeave() == null ? "" : getAnnualLeave());
		sb.append(",");
		sb.append(getWeddingLeave() == null ? "" : getWeddingLeave());
		sb.append(",");
		sb.append(getMaternityLeave() == null ? "" : getMaternityLeave());
		sb.append(",");
		sb.append(getPrenatalCheckLeave() == null ? "" : getPrenatalCheckLeave());
		sb.append(",");
		sb.append(getMaternityLeaveDays() == null ? "" : getMaternityLeaveDays());
		sb.append(",");
		sb.append(getFuneralLeave() == null ? "" : getFuneralLeave());
		sb.append(",");
		sb.append(getOutForBusiness() == null ? "" : getOutForBusiness());
		sb.append(",");
		sb.append(getOvertimePay() == null ? "" : getOvertimePay());
		sb.append(",");
		sb.append(getOvertimePaySub() == null ? "" : getOvertimePaySub());
		sb.append(",");
		sb.append(getOvertimePayBefore() == null ? "" : getOvertimePayBefore());
		sb.append(",");
		sb.append(getOvertimePaySubBefore() == null ? "" : getOvertimePaySubBefore());
		sb.append(",");
		sb.append(getIsFullTime() == null ? "" : getIsFullTime());
		sb.append(",");
		sb.append(getIsLocked() == null ? "" : getIsLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnGetEmployeeMonthCheck o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
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
		hash = 97 * hash + Objects.hashCode(this.__number_of_late);
		hash = 97 * hash + Objects.hashCode(this.__late_for_minutes);
		hash = 97 * hash + Objects.hashCode(this.__number_of_leave);
		hash = 97 * hash + Objects.hashCode(this.__leave_for_minutes);
		hash = 97 * hash + Objects.hashCode(this.__late_charge);
		hash = 97 * hash + Objects.hashCode(this.__adjust);
		hash = 97 * hash + Objects.hashCode(this.__annual_leave);
		hash = 97 * hash + Objects.hashCode(this.__wedding_leave);
		hash = 97 * hash + Objects.hashCode(this.__maternity_leave);
		hash = 97 * hash + Objects.hashCode(this.__prenatal_check_leave);
		hash = 97 * hash + Objects.hashCode(this.__maternity_leave_days);
		hash = 97 * hash + Objects.hashCode(this.__funeral_leave);
		hash = 97 * hash + Objects.hashCode(this.__out_for_business);
		hash = 97 * hash + Objects.hashCode(this.__overtime_pay);
		hash = 97 * hash + Objects.hashCode(this.__overtime_pay_sub);
		hash = 97 * hash + Objects.hashCode(this.__overtime_pay_before);
		hash = 97 * hash + Objects.hashCode(this.__overtime_pay_sub_before);
		hash = 97 * hash + Objects.hashCode(this.__is_full_time);
		hash = 97 * hash + Objects.hashCode(this.__is_locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnGetEmployeeMonthCheck o = (BaseOnGetEmployeeMonthCheck)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
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
		if(!Objects.equals(this.__number_of_late, o.getNumberOfLate())) return false;
		if(!Objects.equals(this.__late_for_minutes, o.getLateForMinutes())) return false;
		if(!Objects.equals(this.__number_of_leave, o.getNumberOfLeave())) return false;
		if(!Objects.equals(this.__leave_for_minutes, o.getLeaveForMinutes())) return false;
		if(!Objects.equals(this.__late_charge, o.getLateCharge())) return false;
		if(!Objects.equals(this.__adjust, o.getAdjust())) return false;
		if(!Objects.equals(this.__annual_leave, o.getAnnualLeave())) return false;
		if(!Objects.equals(this.__wedding_leave, o.getWeddingLeave())) return false;
		if(!Objects.equals(this.__maternity_leave, o.getMaternityLeave())) return false;
		if(!Objects.equals(this.__prenatal_check_leave, o.getPrenatalCheckLeave())) return false;
		if(!Objects.equals(this.__maternity_leave_days, o.getMaternityLeaveDays())) return false;
		if(!Objects.equals(this.__funeral_leave, o.getFuneralLeave())) return false;
		if(!Objects.equals(this.__out_for_business, o.getOutForBusiness())) return false;
		if(!Objects.equals(this.__overtime_pay, o.getOvertimePay())) return false;
		if(!Objects.equals(this.__overtime_pay_sub, o.getOvertimePaySub())) return false;
		if(!Objects.equals(this.__overtime_pay_before, o.getOvertimePayBefore())) return false;
		if(!Objects.equals(this.__overtime_pay_sub_before, o.getOvertimePaySubBefore())) return false;
		if(!Objects.equals(this.__is_full_time, o.getIsFullTime())) return false;
		if(!Objects.equals(this.__is_locked, o.getIsLocked())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
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
		if(getNumberOfLate() != null) sb.append(__wrapDecimal(count++, "numberOfLate", getNumberOfLate()));
		if(getLateForMinutes() != null) sb.append(__wrapDecimal(count++, "lateForMinutes", getLateForMinutes()));
		if(getNumberOfLeave() != null) sb.append(__wrapDecimal(count++, "numberOfLeave", getNumberOfLeave()));
		if(getLeaveForMinutes() != null) sb.append(__wrapDecimal(count++, "leaveForMinutes", getLeaveForMinutes()));
		if(getLateCharge() != null) sb.append(__wrapDecimal(count++, "lateCharge", getLateCharge()));
		if(getAdjust() != null) sb.append(__wrapDecimal(count++, "adjust", getAdjust()));
		if(getAnnualLeave() != null) sb.append(__wrapDecimal(count++, "annualLeave", getAnnualLeave()));
		if(getWeddingLeave() != null) sb.append(__wrapDecimal(count++, "weddingLeave", getWeddingLeave()));
		if(getMaternityLeave() != null) sb.append(__wrapDecimal(count++, "maternityLeave", getMaternityLeave()));
		if(getPrenatalCheckLeave() != null) sb.append(__wrapDecimal(count++, "prenatalCheckLeave", getPrenatalCheckLeave()));
		if(getMaternityLeaveDays() != null) sb.append(__wrapDecimal(count++, "maternityLeaveDays", getMaternityLeaveDays()));
		if(getFuneralLeave() != null) sb.append(__wrapDecimal(count++, "funeralLeave", getFuneralLeave()));
		if(getOutForBusiness() != null) sb.append(__wrapDecimal(count++, "outForBusiness", getOutForBusiness()));
		if(getOvertimePay() != null) sb.append(__wrapDecimal(count++, "overtimePay", getOvertimePay()));
		if(getOvertimePaySub() != null) sb.append(__wrapDecimal(count++, "overtimePaySub", getOvertimePaySub()));
		if(getOvertimePayBefore() != null) sb.append(__wrapDecimal(count++, "overtimePayBefore", getOvertimePayBefore()));
		if(getOvertimePaySubBefore() != null) sb.append(__wrapDecimal(count++, "overtimePaySubBefore", getOvertimePaySubBefore()));
		if(getIsFullTime() != null) sb.append(__wrapBoolean(count++, "isFullTime", getIsFullTime()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(count++, "isLocked", getIsLocked()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getEmployeeNo() != null) res.put("employeeNo", getEmployeeNo());
		if(getEmployeeName() != null) res.put("employeeName", getEmployeeName());
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getStatus() != null) res.put("status", getStatus());
		if(getYear() != null) res.put("year", getYear());
		if(getMonth() != null) res.put("month", getMonth());
		if(getLateLeave5m() != null) res.put("lateLeave5m", getLateLeave5m());
		if(getLateLeave10m() != null) res.put("lateLeave10m", getLateLeave10m());
		if(getLateLeave30m() != null) res.put("lateLeave30m", getLateLeave30m());
		if(getLateLeave() != null) res.put("lateLeave", getLateLeave());
		if(getThingLeaveTimes() != null) res.put("thingLeaveTimes", getThingLeaveTimes());
		if(getThingLeaveHours() != null) res.put("thingLeaveHours", getThingLeaveHours());
		if(getThingLeaveDays() != null) res.put("thingLeaveDays", getThingLeaveDays());
		if(getIllLeaveTimes() != null) res.put("illLeaveTimes", getIllLeaveTimes());
		if(getIllLeaveHours() != null) res.put("illLeaveHours", getIllLeaveHours());
		if(getIllLeaveDays() != null) res.put("illLeaveDays", getIllLeaveDays());
		if(getOtherLeaveTimes() != null) res.put("otherLeaveTimes", getOtherLeaveTimes());
		if(getOtherLeaveHours() != null) res.put("otherLeaveHours", getOtherLeaveHours());
		if(getOtherLeaveDays() != null) res.put("otherLeaveDays", getOtherLeaveDays());
		if(getNornalOvertimeHours() != null) res.put("nornalOvertimeHours", getNornalOvertimeHours());
		if(getWeekendOvertimeHours() != null) res.put("weekendOvertimeHours", getWeekendOvertimeHours());
		if(getHolidayOvertimeHours() != null) res.put("holidayOvertimeHours", getHolidayOvertimeHours());
		if(getAbsenceDays() != null) res.put("absenceDays", getAbsenceDays());
		if(getShouldDays() != null) res.put("shouldDays", getShouldDays());
		if(getFactDays() != null) res.put("factDays", getFactDays());
		if(getNumberOfLate() != null) res.put("numberOfLate", getNumberOfLate());
		if(getLateForMinutes() != null) res.put("lateForMinutes", getLateForMinutes());
		if(getNumberOfLeave() != null) res.put("numberOfLeave", getNumberOfLeave());
		if(getLeaveForMinutes() != null) res.put("leaveForMinutes", getLeaveForMinutes());
		if(getLateCharge() != null) res.put("lateCharge", getLateCharge());
		if(getAdjust() != null) res.put("adjust", getAdjust());
		if(getAnnualLeave() != null) res.put("annualLeave", getAnnualLeave());
		if(getWeddingLeave() != null) res.put("weddingLeave", getWeddingLeave());
		if(getMaternityLeave() != null) res.put("maternityLeave", getMaternityLeave());
		if(getPrenatalCheckLeave() != null) res.put("prenatalCheckLeave", getPrenatalCheckLeave());
		if(getMaternityLeaveDays() != null) res.put("maternityLeaveDays", getMaternityLeaveDays());
		if(getFuneralLeave() != null) res.put("funeralLeave", getFuneralLeave());
		if(getOutForBusiness() != null) res.put("outForBusiness", getOutForBusiness());
		if(getOvertimePay() != null) res.put("overtimePay", getOvertimePay());
		if(getOvertimePaySub() != null) res.put("overtimePaySub", getOvertimePaySub());
		if(getOvertimePayBefore() != null) res.put("overtimePayBefore", getOvertimePayBefore());
		if(getOvertimePaySubBefore() != null) res.put("overtimePaySubBefore", getOvertimePaySubBefore());
		if(getIsFullTime() != null) res.put("isFullTime", getIsFullTime());
		if(getIsLocked() != null) res.put("isLocked", getIsLocked());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
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
		if((val = values.get("numberOfLate")) != null) setNumberOfLate(__getDecimal(val));  
		if((val = values.get("lateForMinutes")) != null) setLateForMinutes(__getDecimal(val));  
		if((val = values.get("numberOfLeave")) != null) setNumberOfLeave(__getDecimal(val));  
		if((val = values.get("leaveForMinutes")) != null) setLeaveForMinutes(__getDecimal(val));  
		if((val = values.get("lateCharge")) != null) setLateCharge(__getDecimal(val));  
		if((val = values.get("adjust")) != null) setAdjust(__getDecimal(val));  
		if((val = values.get("annualLeave")) != null) setAnnualLeave(__getDecimal(val));  
		if((val = values.get("weddingLeave")) != null) setWeddingLeave(__getDecimal(val));  
		if((val = values.get("maternityLeave")) != null) setMaternityLeave(__getDecimal(val));  
		if((val = values.get("prenatalCheckLeave")) != null) setPrenatalCheckLeave(__getDecimal(val));  
		if((val = values.get("maternityLeaveDays")) != null) setMaternityLeaveDays(__getDecimal(val));  
		if((val = values.get("funeralLeave")) != null) setFuneralLeave(__getDecimal(val));  
		if((val = values.get("outForBusiness")) != null) setOutForBusiness(__getDecimal(val));  
		if((val = values.get("overtimePay")) != null) setOvertimePay(__getDecimal(val));  
		if((val = values.get("overtimePaySub")) != null) setOvertimePaySub(__getDecimal(val));  
		if((val = values.get("overtimePayBefore")) != null) setOvertimePayBefore(__getDecimal(val));  
		if((val = values.get("overtimePaySubBefore")) != null) setOvertimePaySubBefore(__getDecimal(val));  
		if((val = values.get("isFullTime")) != null) setIsFullTime(__getBoolean(val));
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
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
	protected java.math.BigDecimal  __number_of_late ;
	protected java.math.BigDecimal  __late_for_minutes ;
	protected java.math.BigDecimal  __number_of_leave ;
	protected java.math.BigDecimal  __leave_for_minutes ;
	protected java.math.BigDecimal  __late_charge ;
	protected java.math.BigDecimal  __adjust ;
	protected java.math.BigDecimal  __annual_leave ;
	protected java.math.BigDecimal  __wedding_leave ;
	protected java.math.BigDecimal  __maternity_leave ;
	protected java.math.BigDecimal  __prenatal_check_leave ;
	protected java.math.BigDecimal  __maternity_leave_days ;
	protected java.math.BigDecimal  __funeral_leave ;
	protected java.math.BigDecimal  __out_for_business ;
	protected java.math.BigDecimal  __overtime_pay ;
	protected java.math.BigDecimal  __overtime_pay_sub ;
	protected java.math.BigDecimal  __overtime_pay_before ;
	protected java.math.BigDecimal  __overtime_pay_sub_before ;
	protected java.lang.Boolean  __is_full_time ;
	protected java.lang.Boolean  __is_locked ;
}
