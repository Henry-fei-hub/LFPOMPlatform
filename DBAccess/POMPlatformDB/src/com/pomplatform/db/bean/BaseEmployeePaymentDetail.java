package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseEmployeePaymentDetail extends GenericBase implements BaseFactory<BaseEmployeePaymentDetail>, Comparable<BaseEmployeePaymentDetail> 
{


	public static BaseEmployeePaymentDetail newInstance(){
		return new BaseEmployeePaymentDetail();
	}

	@Override
	public BaseEmployeePaymentDetail make(){
		BaseEmployeePaymentDetail b = new BaseEmployeePaymentDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_PAYMENT_DETAIL_ID = "employee_payment_detail_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_DETAIL_DATE = "detail_date" ;
	public final static java.lang.String CS_DETAIL_WEEK = "detail_week" ;
	public final static java.lang.String CS_MONTH_PAY = "month_pay" ;
	public final static java.lang.String CS_BASIC_PROPORTION_STR = "basic_proportion_str" ;
	public final static java.lang.String CS_BASIC_PROPORTION = "basic_proportion" ;
	public final static java.lang.String CS_MONTH_BASIC_PAY = "month_basic_pay" ;
	public final static java.lang.String CS_MONTH_PERFORMANCE_PAY = "month_performance_pay" ;
	public final static java.lang.String CS_FOREMAN_PAY = "foreman_pay" ;
	public final static java.lang.String CS_MONTH_WORK_DAY = "month_work_day" ;
	public final static java.lang.String CS_MONTH_TOTAL_DAY = "month_total_day" ;
	public final static java.lang.String CS_DAY_WORK_TIME = "day_work_time" ;
	public final static java.lang.String CS_DAY_PAY = "day_pay" ;
	public final static java.lang.String CS_DAY_FOREMAN_PAY = "day_foreman_pay" ;
	public final static java.lang.String CS_DAY_COST = "day_cost" ;
	public final static java.lang.String CS_UNIT_TOTAL_FUND = "unit_total_fund" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_LATE_LEAVE_10M = "late_leave_10m" ;
	public final static java.lang.String CS_LATE_LEAVE_30M = "late_leave_30m" ;
	public final static java.lang.String CS_LATE_LEAVE = "late_leave" ;
	public final static java.lang.String CS_THING_LEAVE_DAYS = "thing_leave_days" ;
	public final static java.lang.String CS_THING_LEAVE_HOURS = "thing_leave_hours" ;
	public final static java.lang.String CS_ILL_LEAVE_DAYS = "ill_leave_days" ;
	public final static java.lang.String CS_ILL_PERCENT_STR = "ill_percent_str" ;
	public final static java.lang.String CS_ILL_PERCENT = "ill_percent" ;
	public final static java.lang.String CS_LATE_LEAVE_TOTAL = "late_leave_total" ;
	public final static java.lang.String CS_THING_TOTAL = "thing_total" ;
	public final static java.lang.String CS_ILL_TOTAL = "ill_total" ;
	public final static java.lang.String CS_DEDUCT_TOTAL = "deduct_total" ;
	public final static java.lang.String CS_ILL_LEAVE_HOURS = "ill_leave_hours" ;
	public final static java.lang.String CS_UNIT_TOTAL_INSURANCE = "unit_total_insurance" ;
	public final static java.lang.String CS_ALL_SALARY = "all_salary" ;
	public final static java.lang.String CS_DAY_ATTENDANCE_DEDUCTION = "day_attendance_deduction" ;
	public final static java.lang.String CS_IS_LOCKED = "is_locked" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,职员编码,日期,星期,月薪,基本比例（显示用）,基本比例（计算用）,月基本工资,月绩效工资,工龄工资,月工作日,月天数,日工作时间,日工资,日工龄工资,日成本,单位公积金合计,考勤备注,迟到/早退10分钟,迟到/早退30分钟,扣款迟到/早退,事假天数,事假小时数,病假天数,病假扣款比例(显示用),病假扣款比例(计算用),迟到小计,事假小计,病假小计,扣款小计,病假小时数,单位社保合计,全薪,日考勤扣款工资,是否加锁";

	public java.lang.Integer getEmployeePaymentDetailId() {
		return this.__employee_payment_detail_id;
	}

	public void setEmployeePaymentDetailId( java.lang.Integer value ) {
		this.__employee_payment_detail_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.util.Date getDetailDate() {
		return this.__detail_date;
	}

	public void setDetailDate( java.util.Date value ) {
		this.__detail_date = value;
	}

	public java.lang.Integer getDetailWeek() {
		return this.__detail_week;
	}

	public void setDetailWeek( java.lang.Integer value ) {
		this.__detail_week = value;
	}

	public java.math.BigDecimal getMonthPay() {
		return this.__month_pay;
	}

	public void setMonthPay( java.math.BigDecimal value ) {
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

	public java.math.BigDecimal getMonthBasicPay() {
		return this.__month_basic_pay;
	}

	public void setMonthBasicPay( java.math.BigDecimal value ) {
		this.__month_basic_pay = value;
	}

	public java.math.BigDecimal getMonthPerformancePay() {
		return this.__month_performance_pay;
	}

	public void setMonthPerformancePay( java.math.BigDecimal value ) {
		this.__month_performance_pay = value;
	}

	public java.math.BigDecimal getForemanPay() {
		return this.__foreman_pay;
	}

	public void setForemanPay( java.math.BigDecimal value ) {
		this.__foreman_pay = value;
	}

	public java.math.BigDecimal getMonthWorkDay() {
		return this.__month_work_day;
	}

	public void setMonthWorkDay( java.math.BigDecimal value ) {
		this.__month_work_day = value;
	}

	public java.math.BigDecimal getMonthTotalDay() {
		return this.__month_total_day;
	}

	public void setMonthTotalDay( java.math.BigDecimal value ) {
		this.__month_total_day = value;
	}

	public java.math.BigDecimal getDayWorkTime() {
		return this.__day_work_time;
	}

	public void setDayWorkTime( java.math.BigDecimal value ) {
		this.__day_work_time = value;
	}

	public java.math.BigDecimal getDayPay() {
		return this.__day_pay;
	}

	public void setDayPay( java.math.BigDecimal value ) {
		this.__day_pay = value;
	}

	public java.math.BigDecimal getDayForemanPay() {
		return this.__day_foreman_pay;
	}

	public void setDayForemanPay( java.math.BigDecimal value ) {
		this.__day_foreman_pay = value;
	}

	public java.math.BigDecimal getDayCost() {
		return this.__day_cost;
	}

	public void setDayCost( java.math.BigDecimal value ) {
		this.__day_cost = value;
	}

	public java.math.BigDecimal getUnitTotalFund() {
		return this.__unit_total_fund;
	}

	public void setUnitTotalFund( java.math.BigDecimal value ) {
		this.__unit_total_fund = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public java.math.BigDecimal getThingLeaveDays() {
		return this.__thing_leave_days;
	}

	public void setThingLeaveDays( java.math.BigDecimal value ) {
		this.__thing_leave_days = value;
	}

	public java.math.BigDecimal getThingLeaveHours() {
		return this.__thing_leave_hours;
	}

	public void setThingLeaveHours( java.math.BigDecimal value ) {
		this.__thing_leave_hours = value;
	}

	public java.math.BigDecimal getIllLeaveDays() {
		return this.__ill_leave_days;
	}

	public void setIllLeaveDays( java.math.BigDecimal value ) {
		this.__ill_leave_days = value;
	}

	public java.lang.String getIllPercentStr() {
		return this.__ill_percent_str;
	}

	public void setIllPercentStr( java.lang.String value ) {
		this.__ill_percent_str = value;
	}

	public java.math.BigDecimal getIllPercent() {
		return this.__ill_percent;
	}

	public void setIllPercent( java.math.BigDecimal value ) {
		this.__ill_percent = value;
	}

	public java.math.BigDecimal getLateLeaveTotal() {
		return this.__late_leave_total;
	}

	public void setLateLeaveTotal( java.math.BigDecimal value ) {
		this.__late_leave_total = value;
	}

	public java.math.BigDecimal getThingTotal() {
		return this.__thing_total;
	}

	public void setThingTotal( java.math.BigDecimal value ) {
		this.__thing_total = value;
	}

	public java.math.BigDecimal getIllTotal() {
		return this.__ill_total;
	}

	public void setIllTotal( java.math.BigDecimal value ) {
		this.__ill_total = value;
	}

	public java.math.BigDecimal getDeductTotal() {
		return this.__deduct_total;
	}

	public void setDeductTotal( java.math.BigDecimal value ) {
		this.__deduct_total = value;
	}

	public java.math.BigDecimal getIllLeaveHours() {
		return this.__ill_leave_hours;
	}

	public void setIllLeaveHours( java.math.BigDecimal value ) {
		this.__ill_leave_hours = value;
	}

	public java.math.BigDecimal getUnitTotalInsurance() {
		return this.__unit_total_insurance;
	}

	public void setUnitTotalInsurance( java.math.BigDecimal value ) {
		this.__unit_total_insurance = value;
	}

	public java.math.BigDecimal getAllSalary() {
		return this.__all_salary;
	}

	public void setAllSalary( java.math.BigDecimal value ) {
		this.__all_salary = value;
	}

	public java.math.BigDecimal getDayAttendanceDeduction() {
		return this.__day_attendance_deduction;
	}

	public void setDayAttendanceDeduction( java.math.BigDecimal value ) {
		this.__day_attendance_deduction = value;
	}

	public java.lang.Boolean getIsLocked() {
		return this.__is_locked;
	}

	public void setIsLocked( java.lang.Boolean value ) {
		this.__is_locked = value;
	}

	public void cloneCopy(BaseEmployeePaymentDetail __bean){
		__bean.setEmployeePaymentDetailId(getEmployeePaymentDetailId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDetailDate(getDetailDate());
		__bean.setDetailWeek(getDetailWeek());
		__bean.setMonthPay(getMonthPay());
		__bean.setBasicProportionStr(getBasicProportionStr());
		__bean.setBasicProportion(getBasicProportion());
		__bean.setMonthBasicPay(getMonthBasicPay());
		__bean.setMonthPerformancePay(getMonthPerformancePay());
		__bean.setForemanPay(getForemanPay());
		__bean.setMonthWorkDay(getMonthWorkDay());
		__bean.setMonthTotalDay(getMonthTotalDay());
		__bean.setDayWorkTime(getDayWorkTime());
		__bean.setDayPay(getDayPay());
		__bean.setDayForemanPay(getDayForemanPay());
		__bean.setDayCost(getDayCost());
		__bean.setUnitTotalFund(getUnitTotalFund());
		__bean.setRemark(getRemark());
		__bean.setLateLeave10m(getLateLeave10m());
		__bean.setLateLeave30m(getLateLeave30m());
		__bean.setLateLeave(getLateLeave());
		__bean.setThingLeaveDays(getThingLeaveDays());
		__bean.setThingLeaveHours(getThingLeaveHours());
		__bean.setIllLeaveDays(getIllLeaveDays());
		__bean.setIllPercentStr(getIllPercentStr());
		__bean.setIllPercent(getIllPercent());
		__bean.setLateLeaveTotal(getLateLeaveTotal());
		__bean.setThingTotal(getThingTotal());
		__bean.setIllTotal(getIllTotal());
		__bean.setDeductTotal(getDeductTotal());
		__bean.setIllLeaveHours(getIllLeaveHours());
		__bean.setUnitTotalInsurance(getUnitTotalInsurance());
		__bean.setAllSalary(getAllSalary());
		__bean.setDayAttendanceDeduction(getDayAttendanceDeduction());
		__bean.setIsLocked(getIsLocked());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeePaymentDetailId() == null ? "" : getEmployeePaymentDetailId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getDetailDate() == null ? "" : sdf.format(getDetailDate()));
		sb.append(",");
		sb.append(getDetailWeek() == null ? "" : getDetailWeek());
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
		sb.append(getForemanPay() == null ? "" : getForemanPay());
		sb.append(",");
		sb.append(getMonthWorkDay() == null ? "" : getMonthWorkDay());
		sb.append(",");
		sb.append(getMonthTotalDay() == null ? "" : getMonthTotalDay());
		sb.append(",");
		sb.append(getDayWorkTime() == null ? "" : getDayWorkTime());
		sb.append(",");
		sb.append(getDayPay() == null ? "" : getDayPay());
		sb.append(",");
		sb.append(getDayForemanPay() == null ? "" : getDayForemanPay());
		sb.append(",");
		sb.append(getDayCost() == null ? "" : getDayCost());
		sb.append(",");
		sb.append(getUnitTotalFund() == null ? "" : getUnitTotalFund());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getLateLeave10m() == null ? "" : getLateLeave10m());
		sb.append(",");
		sb.append(getLateLeave30m() == null ? "" : getLateLeave30m());
		sb.append(",");
		sb.append(getLateLeave() == null ? "" : getLateLeave());
		sb.append(",");
		sb.append(getThingLeaveDays() == null ? "" : getThingLeaveDays());
		sb.append(",");
		sb.append(getThingLeaveHours() == null ? "" : getThingLeaveHours());
		sb.append(",");
		sb.append(getIllLeaveDays() == null ? "" : getIllLeaveDays());
		sb.append(",");
		sb.append(getIllPercentStr() == null ? "" : getIllPercentStr());
		sb.append(",");
		sb.append(getIllPercent() == null ? "" : getIllPercent());
		sb.append(",");
		sb.append(getLateLeaveTotal() == null ? "" : getLateLeaveTotal());
		sb.append(",");
		sb.append(getThingTotal() == null ? "" : getThingTotal());
		sb.append(",");
		sb.append(getIllTotal() == null ? "" : getIllTotal());
		sb.append(",");
		sb.append(getDeductTotal() == null ? "" : getDeductTotal());
		sb.append(",");
		sb.append(getIllLeaveHours() == null ? "" : getIllLeaveHours());
		sb.append(",");
		sb.append(getUnitTotalInsurance() == null ? "" : getUnitTotalInsurance());
		sb.append(",");
		sb.append(getAllSalary() == null ? "" : getAllSalary());
		sb.append(",");
		sb.append(getDayAttendanceDeduction() == null ? "" : getDayAttendanceDeduction());
		sb.append(",");
		sb.append(getIsLocked() == null ? "" : getIsLocked());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeePaymentDetail o) {
		return __employee_payment_detail_id == null ? -1 : __employee_payment_detail_id.compareTo(o.getEmployeePaymentDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_payment_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__detail_date);
		hash = 97 * hash + Objects.hashCode(this.__detail_week);
		hash = 97 * hash + Objects.hashCode(this.__month_pay);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__basic_proportion);
		hash = 97 * hash + Objects.hashCode(this.__month_basic_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_performance_pay);
		hash = 97 * hash + Objects.hashCode(this.__foreman_pay);
		hash = 97 * hash + Objects.hashCode(this.__month_work_day);
		hash = 97 * hash + Objects.hashCode(this.__month_total_day);
		hash = 97 * hash + Objects.hashCode(this.__day_work_time);
		hash = 97 * hash + Objects.hashCode(this.__day_pay);
		hash = 97 * hash + Objects.hashCode(this.__day_foreman_pay);
		hash = 97 * hash + Objects.hashCode(this.__day_cost);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_fund);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__late_leave_10m);
		hash = 97 * hash + Objects.hashCode(this.__late_leave_30m);
		hash = 97 * hash + Objects.hashCode(this.__late_leave);
		hash = 97 * hash + Objects.hashCode(this.__thing_leave_days);
		hash = 97 * hash + Objects.hashCode(this.__thing_leave_hours);
		hash = 97 * hash + Objects.hashCode(this.__ill_leave_days);
		hash = 97 * hash + Objects.hashCode(this.__ill_percent_str);
		hash = 97 * hash + Objects.hashCode(this.__ill_percent);
		hash = 97 * hash + Objects.hashCode(this.__late_leave_total);
		hash = 97 * hash + Objects.hashCode(this.__thing_total);
		hash = 97 * hash + Objects.hashCode(this.__ill_total);
		hash = 97 * hash + Objects.hashCode(this.__deduct_total);
		hash = 97 * hash + Objects.hashCode(this.__ill_leave_hours);
		hash = 97 * hash + Objects.hashCode(this.__unit_total_insurance);
		hash = 97 * hash + Objects.hashCode(this.__all_salary);
		hash = 97 * hash + Objects.hashCode(this.__day_attendance_deduction);
		hash = 97 * hash + Objects.hashCode(this.__is_locked);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeePaymentDetail o = (BaseEmployeePaymentDetail)obj;
		if(!Objects.equals(this.__employee_payment_detail_id, o.getEmployeePaymentDetailId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__detail_date, o.getDetailDate())) return false;
		if(!Objects.equals(this.__detail_week, o.getDetailWeek())) return false;
		if(!Objects.equals(this.__month_pay, o.getMonthPay())) return false;
		if(!Objects.equals(this.__basic_proportion_str, o.getBasicProportionStr())) return false;
		if(!Objects.equals(this.__basic_proportion, o.getBasicProportion())) return false;
		if(!Objects.equals(this.__month_basic_pay, o.getMonthBasicPay())) return false;
		if(!Objects.equals(this.__month_performance_pay, o.getMonthPerformancePay())) return false;
		if(!Objects.equals(this.__foreman_pay, o.getForemanPay())) return false;
		if(!Objects.equals(this.__month_work_day, o.getMonthWorkDay())) return false;
		if(!Objects.equals(this.__month_total_day, o.getMonthTotalDay())) return false;
		if(!Objects.equals(this.__day_work_time, o.getDayWorkTime())) return false;
		if(!Objects.equals(this.__day_pay, o.getDayPay())) return false;
		if(!Objects.equals(this.__day_foreman_pay, o.getDayForemanPay())) return false;
		if(!Objects.equals(this.__day_cost, o.getDayCost())) return false;
		if(!Objects.equals(this.__unit_total_fund, o.getUnitTotalFund())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__late_leave_10m, o.getLateLeave10m())) return false;
		if(!Objects.equals(this.__late_leave_30m, o.getLateLeave30m())) return false;
		if(!Objects.equals(this.__late_leave, o.getLateLeave())) return false;
		if(!Objects.equals(this.__thing_leave_days, o.getThingLeaveDays())) return false;
		if(!Objects.equals(this.__thing_leave_hours, o.getThingLeaveHours())) return false;
		if(!Objects.equals(this.__ill_leave_days, o.getIllLeaveDays())) return false;
		if(!Objects.equals(this.__ill_percent_str, o.getIllPercentStr())) return false;
		if(!Objects.equals(this.__ill_percent, o.getIllPercent())) return false;
		if(!Objects.equals(this.__late_leave_total, o.getLateLeaveTotal())) return false;
		if(!Objects.equals(this.__thing_total, o.getThingTotal())) return false;
		if(!Objects.equals(this.__ill_total, o.getIllTotal())) return false;
		if(!Objects.equals(this.__deduct_total, o.getDeductTotal())) return false;
		if(!Objects.equals(this.__ill_leave_hours, o.getIllLeaveHours())) return false;
		if(!Objects.equals(this.__unit_total_insurance, o.getUnitTotalInsurance())) return false;
		if(!Objects.equals(this.__all_salary, o.getAllSalary())) return false;
		if(!Objects.equals(this.__day_attendance_deduction, o.getDayAttendanceDeduction())) return false;
		if(!Objects.equals(this.__is_locked, o.getIsLocked())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeePaymentDetailId() != null) sb.append(__wrapNumber(count++, "employeePaymentDetailId", getEmployeePaymentDetailId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDetailDate() != null) sb.append(__wrapDate(count++, "detailDate", getDetailDate()));
		if(getDetailWeek() != null) sb.append(__wrapNumber(count++, "detailWeek", getDetailWeek()));
		if(getMonthPay() != null) sb.append(__wrapDecimal(count++, "monthPay", getMonthPay()));
		if(getBasicProportionStr() != null) sb.append(__wrapString(count++, "basicProportionStr", getBasicProportionStr()));
		if(getBasicProportion() != null) sb.append(__wrapDecimal(count++, "basicProportion", getBasicProportion()));
		if(getMonthBasicPay() != null) sb.append(__wrapDecimal(count++, "monthBasicPay", getMonthBasicPay()));
		if(getMonthPerformancePay() != null) sb.append(__wrapDecimal(count++, "monthPerformancePay", getMonthPerformancePay()));
		if(getForemanPay() != null) sb.append(__wrapDecimal(count++, "foremanPay", getForemanPay()));
		if(getMonthWorkDay() != null) sb.append(__wrapDecimal(count++, "monthWorkDay", getMonthWorkDay()));
		if(getMonthTotalDay() != null) sb.append(__wrapDecimal(count++, "monthTotalDay", getMonthTotalDay()));
		if(getDayWorkTime() != null) sb.append(__wrapDecimal(count++, "dayWorkTime", getDayWorkTime()));
		if(getDayPay() != null) sb.append(__wrapDecimal(count++, "dayPay", getDayPay()));
		if(getDayForemanPay() != null) sb.append(__wrapDecimal(count++, "dayForemanPay", getDayForemanPay()));
		if(getDayCost() != null) sb.append(__wrapDecimal(count++, "dayCost", getDayCost()));
		if(getUnitTotalFund() != null) sb.append(__wrapDecimal(count++, "unitTotalFund", getUnitTotalFund()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getLateLeave10m() != null) sb.append(__wrapNumber(count++, "lateLeave10m", getLateLeave10m()));
		if(getLateLeave30m() != null) sb.append(__wrapNumber(count++, "lateLeave30m", getLateLeave30m()));
		if(getLateLeave() != null) sb.append(__wrapNumber(count++, "lateLeave", getLateLeave()));
		if(getThingLeaveDays() != null) sb.append(__wrapDecimal(count++, "thingLeaveDays", getThingLeaveDays()));
		if(getThingLeaveHours() != null) sb.append(__wrapDecimal(count++, "thingLeaveHours", getThingLeaveHours()));
		if(getIllLeaveDays() != null) sb.append(__wrapDecimal(count++, "illLeaveDays", getIllLeaveDays()));
		if(getIllPercentStr() != null) sb.append(__wrapString(count++, "illPercentStr", getIllPercentStr()));
		if(getIllPercent() != null) sb.append(__wrapDecimal(count++, "illPercent", getIllPercent()));
		if(getLateLeaveTotal() != null) sb.append(__wrapDecimal(count++, "lateLeaveTotal", getLateLeaveTotal()));
		if(getThingTotal() != null) sb.append(__wrapDecimal(count++, "thingTotal", getThingTotal()));
		if(getIllTotal() != null) sb.append(__wrapDecimal(count++, "illTotal", getIllTotal()));
		if(getDeductTotal() != null) sb.append(__wrapDecimal(count++, "deductTotal", getDeductTotal()));
		if(getIllLeaveHours() != null) sb.append(__wrapDecimal(count++, "illLeaveHours", getIllLeaveHours()));
		if(getUnitTotalInsurance() != null) sb.append(__wrapDecimal(count++, "unitTotalInsurance", getUnitTotalInsurance()));
		if(getAllSalary() != null) sb.append(__wrapDecimal(count++, "allSalary", getAllSalary()));
		if(getDayAttendanceDeduction() != null) sb.append(__wrapDecimal(count++, "dayAttendanceDeduction", getDayAttendanceDeduction()));
		if(getIsLocked() != null) sb.append(__wrapBoolean(count++, "isLocked", getIsLocked()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeePaymentDetailId")) != null) setEmployeePaymentDetailId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("detailDate")) != null) setDetailDate(__getDate(val)); 
		if((val = values.get("detailWeek")) != null) setDetailWeek(__getInt(val)); 
		if((val = values.get("monthPay")) != null) setMonthPay(__getDecimal(val));  
		if((val = values.get("basicProportionStr")) != null) setBasicProportionStr(__getString(val));
		if((val = values.get("basicProportion")) != null) setBasicProportion(__getDecimal(val));  
		if((val = values.get("monthBasicPay")) != null) setMonthBasicPay(__getDecimal(val));  
		if((val = values.get("monthPerformancePay")) != null) setMonthPerformancePay(__getDecimal(val));  
		if((val = values.get("foremanPay")) != null) setForemanPay(__getDecimal(val));  
		if((val = values.get("monthWorkDay")) != null) setMonthWorkDay(__getDecimal(val));  
		if((val = values.get("monthTotalDay")) != null) setMonthTotalDay(__getDecimal(val));  
		if((val = values.get("dayWorkTime")) != null) setDayWorkTime(__getDecimal(val));  
		if((val = values.get("dayPay")) != null) setDayPay(__getDecimal(val));  
		if((val = values.get("dayForemanPay")) != null) setDayForemanPay(__getDecimal(val));  
		if((val = values.get("dayCost")) != null) setDayCost(__getDecimal(val));  
		if((val = values.get("unitTotalFund")) != null) setUnitTotalFund(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("lateLeave10m")) != null) setLateLeave10m(__getInt(val)); 
		if((val = values.get("lateLeave30m")) != null) setLateLeave30m(__getInt(val)); 
		if((val = values.get("lateLeave")) != null) setLateLeave(__getInt(val)); 
		if((val = values.get("thingLeaveDays")) != null) setThingLeaveDays(__getDecimal(val));  
		if((val = values.get("thingLeaveHours")) != null) setThingLeaveHours(__getDecimal(val));  
		if((val = values.get("illLeaveDays")) != null) setIllLeaveDays(__getDecimal(val));  
		if((val = values.get("illPercentStr")) != null) setIllPercentStr(__getString(val));
		if((val = values.get("illPercent")) != null) setIllPercent(__getDecimal(val));  
		if((val = values.get("lateLeaveTotal")) != null) setLateLeaveTotal(__getDecimal(val));  
		if((val = values.get("thingTotal")) != null) setThingTotal(__getDecimal(val));  
		if((val = values.get("illTotal")) != null) setIllTotal(__getDecimal(val));  
		if((val = values.get("deductTotal")) != null) setDeductTotal(__getDecimal(val));  
		if((val = values.get("illLeaveHours")) != null) setIllLeaveHours(__getDecimal(val));  
		if((val = values.get("unitTotalInsurance")) != null) setUnitTotalInsurance(__getDecimal(val));  
		if((val = values.get("allSalary")) != null) setAllSalary(__getDecimal(val));  
		if((val = values.get("dayAttendanceDeduction")) != null) setDayAttendanceDeduction(__getDecimal(val));  
		if((val = values.get("isLocked")) != null) setIsLocked(__getBoolean(val));
	}

	protected java.lang.Integer  __employee_payment_detail_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.util.Date  __detail_date ;
	protected java.lang.Integer  __detail_week ;
	protected java.math.BigDecimal  __month_pay ;
	protected java.lang.String  __basic_proportion_str ;
	protected java.math.BigDecimal  __basic_proportion ;
	protected java.math.BigDecimal  __month_basic_pay ;
	protected java.math.BigDecimal  __month_performance_pay ;
	protected java.math.BigDecimal  __foreman_pay ;
	protected java.math.BigDecimal  __month_work_day ;
	protected java.math.BigDecimal  __month_total_day ;
	protected java.math.BigDecimal  __day_work_time ;
	protected java.math.BigDecimal  __day_pay ;
	protected java.math.BigDecimal  __day_foreman_pay ;
	protected java.math.BigDecimal  __day_cost ;
	protected java.math.BigDecimal  __unit_total_fund ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __late_leave_10m ;
	protected java.lang.Integer  __late_leave_30m ;
	protected java.lang.Integer  __late_leave ;
	protected java.math.BigDecimal  __thing_leave_days ;
	protected java.math.BigDecimal  __thing_leave_hours ;
	protected java.math.BigDecimal  __ill_leave_days ;
	protected java.lang.String  __ill_percent_str ;
	protected java.math.BigDecimal  __ill_percent ;
	protected java.math.BigDecimal  __late_leave_total ;
	protected java.math.BigDecimal  __thing_total ;
	protected java.math.BigDecimal  __ill_total ;
	protected java.math.BigDecimal  __deduct_total ;
	protected java.math.BigDecimal  __ill_leave_hours ;
	protected java.math.BigDecimal  __unit_total_insurance ;
	protected java.math.BigDecimal  __all_salary ;
	protected java.math.BigDecimal  __day_attendance_deduction ;
	protected java.lang.Boolean  __is_locked ;
}
