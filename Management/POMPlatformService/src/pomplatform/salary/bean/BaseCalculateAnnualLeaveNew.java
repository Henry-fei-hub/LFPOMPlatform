package pomplatform.salary.bean;

import java.util.*;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCalculateAnnualLeaveNew extends GenericBase implements BaseFactory<BaseCalculateAnnualLeaveNew>, Comparable<BaseCalculateAnnualLeaveNew> 
{


	public static BaseCalculateAnnualLeaveNew newInstance(){
		return new BaseCalculateAnnualLeaveNew();
	}

	@Override
	public BaseCalculateAnnualLeaveNew make(){
		BaseCalculateAnnualLeaveNew b = new BaseCalculateAnnualLeaveNew();
		return b;
	}

	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_DEPARTMENT_NAME = "department_name" ;
	public final static String CS_CURRENT_YEAR_TOTAL_ANNUAL_LEAVE = "current_year_total_annual_leave" ;
	public final static String CS_CURRENT_YEAR_USAGE_AMOUNT_ANNUAL = "current_year_usage_amount_annual" ;
	public final static String CS_CURRENT_REMAINING_AMOUNT_ANNUAL = "current_remaining_amount_annual" ;
	public final static String CS_CURRENT_YEAR_TOTAL_WEALFARE_LEAVE = "current_year_total_wealfare_leave" ;
	public final static String CS_CURRENT_YEAR_USAGE_AMOUNT_WEALFARE = "current_year_usage_amount_wealfare" ;
	public final static String CS_CURRENT_REMAINING_AMOUNT_WEALFARE = "current_remaining_amount_wealfare" ;
	public final static String CS_LAST_YEAR_TOTAL_ANNUAL_LEAVE = "last_year_total_annual_leave" ;
	public final static String CS_LAST_YEAR_USAGE_AMOUNT_ANNUAL = "last_year_usage_amount_annual" ;
	public final static String CS_LAST_REMAINING_AMOUNT_ANNUAL = "last_remaining_amount_annual" ;
	public final static String CS_LAST_YEAR_TOTAL_WEALFARE_LEAVE = "last_year_total_wealfare_leave" ;
	public final static String CS_LAST_YEAR_USAGE_AMOUNT_WEALFARE = "last_year_usage_amount_wealfare" ;
	public final static String CS_LAST_REMAINING_AMOUNT_WEALFARE = "last_remaining_amount_wealfare" ;
	public final static String CS_LAST_REMAINING_LEAVE = "last_remaining_leave" ;
	public final static String CS_CURRENT_YEAR_LEAVE = "current_year_leave" ;
	public final static String CS_CURRENT_YEAR_USEDTIME = "current_year_usedtime" ;
	public final static String CS_REMAINING_OVERTIME = "remaining_overtime" ;
	public final static String CS_USED = "used" ;
	public final static String CS_OVERTIME_HOURS = "overtime_hours" ;
	public final static String CS_USED_Y = "used_y" ;
	public final static String CS_OVERTIME_HOURS_Y = "overtime_hours_y" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_YEAR = "year" ;

	public final static String NAME_EMPLOYEE_NAME = "employeeName" ;
	public final static String NAME_EMPLOYEE_NO = "employeeNo" ;
	public final static String NAME_DEPARTMENT_NAME = "departmentName" ;
	public final static String NAME_CURRENT_YEAR_TOTAL_ANNUAL_LEAVE = "currentYearTotalAnnualLeave" ;
	public final static String NAME_CURRENT_YEAR_USAGE_AMOUNT_ANNUAL = "currentYearUsageAmountAnnual" ;
	public final static String NAME_CURRENT_REMAINING_AMOUNT_ANNUAL = "currentRemainingAmountAnnual" ;
	public final static String NAME_CURRENT_YEAR_TOTAL_WEALFARE_LEAVE = "currentYearTotalWealfareLeave" ;
	public final static String NAME_CURRENT_YEAR_USAGE_AMOUNT_WEALFARE = "currentYearUsageAmountWealfare" ;
	public final static String NAME_CURRENT_REMAINING_AMOUNT_WEALFARE = "currentRemainingAmountWealfare" ;
	public final static String NAME_LAST_YEAR_TOTAL_ANNUAL_LEAVE = "lastYearTotalAnnualLeave" ;
	public final static String NAME_LAST_YEAR_USAGE_AMOUNT_ANNUAL = "lastYearUsageAmountAnnual" ;
	public final static String NAME_LAST_REMAINING_AMOUNT_ANNUAL = "lastRemainingAmountAnnual" ;
	public final static String NAME_LAST_YEAR_TOTAL_WEALFARE_LEAVE = "lastYearTotalWealfareLeave" ;
	public final static String NAME_LAST_YEAR_USAGE_AMOUNT_WEALFARE = "lastYearUsageAmountWealfare" ;
	public final static String NAME_LAST_REMAINING_AMOUNT_WEALFARE = "lastRemainingAmountWealfare" ;
	public final static String NAME_LAST_REMAINING_LEAVE = "lastRemainingLeave" ;
	public final static String NAME_CURRENT_YEAR_LEAVE = "currentYearLeave" ;
	public final static String NAME_CURRENT_YEAR_USEDTIME = "currentYearUsedtime" ;
	public final static String NAME_REMAINING_OVERTIME = "remainingOvertime" ;
	public final static String NAME_USED = "used" ;
	public final static String NAME_OVERTIME_HOURS = "overtimeHours" ;
	public final static String NAME_USED_Y = "usedY" ;
	public final static String NAME_OVERTIME_HOURS_Y = "overtimeHoursY" ;
	public final static String NAME_EMPLOYEE_ID = "employeeId" ;
	public final static String NAME_DEPARTMENT_ID = "departmentId" ;
	public final static String NAME_PLATE_ID = "plateId" ;
	public final static String NAME_YEAR = "year" ;

	public final static java.lang.String ALL_CAPTIONS = "员工姓名,员工编号,部门名称,,,,,,,,,,,,,,,,,,,,,员工编码,部门,板块,年份";

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

	public java.lang.String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( java.lang.String value ) {
		this.__department_name = value;
	}

	public java.math.BigDecimal getCurrentYearTotalAnnualLeave() {
		return this.__current_year_total_annual_leave;
	}

	public void setCurrentYearTotalAnnualLeave( java.math.BigDecimal value ) {
		this.__current_year_total_annual_leave = value;
	}

	public java.math.BigDecimal getCurrentYearUsageAmountAnnual() {
		return this.__current_year_usage_amount_annual;
	}

	public void setCurrentYearUsageAmountAnnual( java.math.BigDecimal value ) {
		this.__current_year_usage_amount_annual = value;
	}

	public java.math.BigDecimal getCurrentRemainingAmountAnnual() {
		return this.__current_remaining_amount_annual;
	}

	public void setCurrentRemainingAmountAnnual( java.math.BigDecimal value ) {
		this.__current_remaining_amount_annual = value;
	}

	public java.math.BigDecimal getCurrentYearTotalWealfareLeave() {
		return this.__current_year_total_wealfare_leave;
	}

	public void setCurrentYearTotalWealfareLeave( java.math.BigDecimal value ) {
		this.__current_year_total_wealfare_leave = value;
	}

	public java.math.BigDecimal getCurrentYearUsageAmountWealfare() {
		return this.__current_year_usage_amount_wealfare;
	}

	public void setCurrentYearUsageAmountWealfare( java.math.BigDecimal value ) {
		this.__current_year_usage_amount_wealfare = value;
	}

	public java.math.BigDecimal getCurrentRemainingAmountWealfare() {
		return this.__current_remaining_amount_wealfare;
	}

	public void setCurrentRemainingAmountWealfare( java.math.BigDecimal value ) {
		this.__current_remaining_amount_wealfare = value;
	}

	public java.math.BigDecimal getLastYearTotalAnnualLeave() {
		return this.__last_year_total_annual_leave;
	}

	public void setLastYearTotalAnnualLeave( java.math.BigDecimal value ) {
		this.__last_year_total_annual_leave = value;
	}

	public java.math.BigDecimal getLastYearUsageAmountAnnual() {
		return this.__last_year_usage_amount_annual;
	}

	public void setLastYearUsageAmountAnnual( java.math.BigDecimal value ) {
		this.__last_year_usage_amount_annual = value;
	}

	public java.math.BigDecimal getLastRemainingAmountAnnual() {
		return this.__last_remaining_amount_annual;
	}

	public void setLastRemainingAmountAnnual( java.math.BigDecimal value ) {
		this.__last_remaining_amount_annual = value;
	}

	public java.math.BigDecimal getLastYearTotalWealfareLeave() {
		return this.__last_year_total_wealfare_leave;
	}

	public void setLastYearTotalWealfareLeave( java.math.BigDecimal value ) {
		this.__last_year_total_wealfare_leave = value;
	}

	public java.math.BigDecimal getLastYearUsageAmountWealfare() {
		return this.__last_year_usage_amount_wealfare;
	}

	public void setLastYearUsageAmountWealfare( java.math.BigDecimal value ) {
		this.__last_year_usage_amount_wealfare = value;
	}

	public java.math.BigDecimal getLastRemainingAmountWealfare() {
		return this.__last_remaining_amount_wealfare;
	}

	public void setLastRemainingAmountWealfare( java.math.BigDecimal value ) {
		this.__last_remaining_amount_wealfare = value;
	}

	public java.math.BigDecimal getLastRemainingLeave() {
		return this.__last_remaining_leave;
	}

	public void setLastRemainingLeave( java.math.BigDecimal value ) {
		this.__last_remaining_leave = value;
	}

	public java.math.BigDecimal getCurrentYearLeave() {
		return this.__current_year_leave;
	}

	public void setCurrentYearLeave( java.math.BigDecimal value ) {
		this.__current_year_leave = value;
	}

	public java.math.BigDecimal getCurrentYearUsedtime() {
		return this.__current_year_usedtime;
	}

	public void setCurrentYearUsedtime( java.math.BigDecimal value ) {
		this.__current_year_usedtime = value;
	}

	public java.math.BigDecimal getRemainingOvertime() {
		return this.__remaining_overtime;
	}

	public void setRemainingOvertime( java.math.BigDecimal value ) {
		this.__remaining_overtime = value;
	}

	public java.math.BigDecimal getUsed() {
		return this.__used;
	}

	public void setUsed( java.math.BigDecimal value ) {
		this.__used = value;
	}

	public java.math.BigDecimal getOvertimeHours() {
		return this.__overtime_hours;
	}

	public void setOvertimeHours( java.math.BigDecimal value ) {
		this.__overtime_hours = value;
	}

	public java.math.BigDecimal getUsedY() {
		return this.__used_y;
	}

	public void setUsedY( java.math.BigDecimal value ) {
		this.__used_y = value;
	}

	public java.math.BigDecimal getOvertimeHoursY() {
		return this.__overtime_hours_y;
	}

	public void setOvertimeHoursY( java.math.BigDecimal value ) {
		this.__overtime_hours_y = value;
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

	public static String getKeyColumnName() {
		String name ="";
		name = CS_EMPLOYEE_ID;
		return name;
	}

	public void cloneCopy(BaseCalculateAnnualLeaveNew __bean){
		__bean.setEmployeeName(getEmployeeName());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setCurrentYearTotalAnnualLeave(getCurrentYearTotalAnnualLeave());
		__bean.setCurrentYearUsageAmountAnnual(getCurrentYearUsageAmountAnnual());
		__bean.setCurrentRemainingAmountAnnual(getCurrentRemainingAmountAnnual());
		__bean.setCurrentYearTotalWealfareLeave(getCurrentYearTotalWealfareLeave());
		__bean.setCurrentYearUsageAmountWealfare(getCurrentYearUsageAmountWealfare());
		__bean.setCurrentRemainingAmountWealfare(getCurrentRemainingAmountWealfare());
		__bean.setLastYearTotalAnnualLeave(getLastYearTotalAnnualLeave());
		__bean.setLastYearUsageAmountAnnual(getLastYearUsageAmountAnnual());
		__bean.setLastRemainingAmountAnnual(getLastRemainingAmountAnnual());
		__bean.setLastYearTotalWealfareLeave(getLastYearTotalWealfareLeave());
		__bean.setLastYearUsageAmountWealfare(getLastYearUsageAmountWealfare());
		__bean.setLastRemainingAmountWealfare(getLastRemainingAmountWealfare());
		__bean.setLastRemainingLeave(getLastRemainingLeave());
		__bean.setCurrentYearLeave(getCurrentYearLeave());
		__bean.setCurrentYearUsedtime(getCurrentYearUsedtime());
		__bean.setRemainingOvertime(getRemainingOvertime());
		__bean.setUsed(getUsed());
		__bean.setOvertimeHours(getOvertimeHours());
		__bean.setUsedY(getUsedY());
		__bean.setOvertimeHoursY(getOvertimeHoursY());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setPageLines(getPageLines());
		__bean.setCurrentPage(getCurrentPage());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getEmployeeName()));
		sb.append(strEmployeeName == null ? "" : strEmployeeName);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
		sb.append(",");
		sb.append(getCurrentYearTotalAnnualLeave() == null ? "" : getCurrentYearTotalAnnualLeave());
		sb.append(",");
		sb.append(getCurrentYearUsageAmountAnnual() == null ? "" : getCurrentYearUsageAmountAnnual());
		sb.append(",");
		sb.append(getCurrentRemainingAmountAnnual() == null ? "" : getCurrentRemainingAmountAnnual());
		sb.append(",");
		sb.append(getCurrentYearTotalWealfareLeave() == null ? "" : getCurrentYearTotalWealfareLeave());
		sb.append(",");
		sb.append(getCurrentYearUsageAmountWealfare() == null ? "" : getCurrentYearUsageAmountWealfare());
		sb.append(",");
		sb.append(getCurrentRemainingAmountWealfare() == null ? "" : getCurrentRemainingAmountWealfare());
		sb.append(",");
		sb.append(getLastYearTotalAnnualLeave() == null ? "" : getLastYearTotalAnnualLeave());
		sb.append(",");
		sb.append(getLastYearUsageAmountAnnual() == null ? "" : getLastYearUsageAmountAnnual());
		sb.append(",");
		sb.append(getLastRemainingAmountAnnual() == null ? "" : getLastRemainingAmountAnnual());
		sb.append(",");
		sb.append(getLastYearTotalWealfareLeave() == null ? "" : getLastYearTotalWealfareLeave());
		sb.append(",");
		sb.append(getLastYearUsageAmountWealfare() == null ? "" : getLastYearUsageAmountWealfare());
		sb.append(",");
		sb.append(getLastRemainingAmountWealfare() == null ? "" : getLastRemainingAmountWealfare());
		sb.append(",");
		sb.append(getLastRemainingLeave() == null ? "" : getLastRemainingLeave());
		sb.append(",");
		sb.append(getCurrentYearLeave() == null ? "" : getCurrentYearLeave());
		sb.append(",");
		sb.append(getCurrentYearUsedtime() == null ? "" : getCurrentYearUsedtime());
		sb.append(",");
		sb.append(getRemainingOvertime() == null ? "" : getRemainingOvertime());
		sb.append(",");
		sb.append(getUsed() == null ? "" : getUsed());
		sb.append(",");
		sb.append(getOvertimeHours() == null ? "" : getOvertimeHours());
		sb.append(",");
		sb.append(getUsedY() == null ? "" : getUsedY());
		sb.append(",");
		sb.append(getOvertimeHoursY() == null ? "" : getOvertimeHoursY());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCalculateAnnualLeaveNew o) {
		return __employee_id == null || o.getEmployeeId() == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__current_year_total_annual_leave);
		hash = 97 * hash + Objects.hashCode(this.__current_year_usage_amount_annual);
		hash = 97 * hash + Objects.hashCode(this.__current_remaining_amount_annual);
		hash = 97 * hash + Objects.hashCode(this.__current_year_total_wealfare_leave);
		hash = 97 * hash + Objects.hashCode(this.__current_year_usage_amount_wealfare);
		hash = 97 * hash + Objects.hashCode(this.__current_remaining_amount_wealfare);
		hash = 97 * hash + Objects.hashCode(this.__last_year_total_annual_leave);
		hash = 97 * hash + Objects.hashCode(this.__last_year_usage_amount_annual);
		hash = 97 * hash + Objects.hashCode(this.__last_remaining_amount_annual);
		hash = 97 * hash + Objects.hashCode(this.__last_year_total_wealfare_leave);
		hash = 97 * hash + Objects.hashCode(this.__last_year_usage_amount_wealfare);
		hash = 97 * hash + Objects.hashCode(this.__last_remaining_amount_wealfare);
		hash = 97 * hash + Objects.hashCode(this.__last_remaining_leave);
		hash = 97 * hash + Objects.hashCode(this.__current_year_leave);
		hash = 97 * hash + Objects.hashCode(this.__current_year_usedtime);
		hash = 97 * hash + Objects.hashCode(this.__remaining_overtime);
		hash = 97 * hash + Objects.hashCode(this.__used);
		hash = 97 * hash + Objects.hashCode(this.__overtime_hours);
		hash = 97 * hash + Objects.hashCode(this.__used_y);
		hash = 97 * hash + Objects.hashCode(this.__overtime_hours_y);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCalculateAnnualLeaveNew o = (BaseCalculateAnnualLeaveNew)obj;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__current_year_total_annual_leave, o.getCurrentYearTotalAnnualLeave())) return false;
		if(!Objects.equals(this.__current_year_usage_amount_annual, o.getCurrentYearUsageAmountAnnual())) return false;
		if(!Objects.equals(this.__current_remaining_amount_annual, o.getCurrentRemainingAmountAnnual())) return false;
		if(!Objects.equals(this.__current_year_total_wealfare_leave, o.getCurrentYearTotalWealfareLeave())) return false;
		if(!Objects.equals(this.__current_year_usage_amount_wealfare, o.getCurrentYearUsageAmountWealfare())) return false;
		if(!Objects.equals(this.__current_remaining_amount_wealfare, o.getCurrentRemainingAmountWealfare())) return false;
		if(!Objects.equals(this.__last_year_total_annual_leave, o.getLastYearTotalAnnualLeave())) return false;
		if(!Objects.equals(this.__last_year_usage_amount_annual, o.getLastYearUsageAmountAnnual())) return false;
		if(!Objects.equals(this.__last_remaining_amount_annual, o.getLastRemainingAmountAnnual())) return false;
		if(!Objects.equals(this.__last_year_total_wealfare_leave, o.getLastYearTotalWealfareLeave())) return false;
		if(!Objects.equals(this.__last_year_usage_amount_wealfare, o.getLastYearUsageAmountWealfare())) return false;
		if(!Objects.equals(this.__last_remaining_amount_wealfare, o.getLastRemainingAmountWealfare())) return false;
		if(!Objects.equals(this.__last_remaining_leave, o.getLastRemainingLeave())) return false;
		if(!Objects.equals(this.__current_year_leave, o.getCurrentYearLeave())) return false;
		if(!Objects.equals(this.__current_year_usedtime, o.getCurrentYearUsedtime())) return false;
		if(!Objects.equals(this.__remaining_overtime, o.getRemainingOvertime())) return false;
		if(!Objects.equals(this.__used, o.getUsed())) return false;
		if(!Objects.equals(this.__overtime_hours, o.getOvertimeHours())) return false;
		if(!Objects.equals(this.__used_y, o.getUsedY())) return false;
		if(!Objects.equals(this.__overtime_hours_y, o.getOvertimeHoursY())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		return toJSONString(false);
	}

	@Override
	public java.lang.String toJSONString(boolean outDefault) {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeName() != null || outDefault) sb.append(__wrapString(count++, NAME_EMPLOYEE_NAME, getEmployeeName()));
		if(getEmployeeNo() != null || outDefault) sb.append(__wrapString(count++, NAME_EMPLOYEE_NO, getEmployeeNo()));
		if(getDepartmentName() != null || outDefault) sb.append(__wrapString(count++, NAME_DEPARTMENT_NAME, getDepartmentName()));
		if(getCurrentYearTotalAnnualLeave() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_YEAR_TOTAL_ANNUAL_LEAVE, getCurrentYearTotalAnnualLeave()));
		if(getCurrentYearUsageAmountAnnual() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_YEAR_USAGE_AMOUNT_ANNUAL, getCurrentYearUsageAmountAnnual()));
		if(getCurrentRemainingAmountAnnual() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_REMAINING_AMOUNT_ANNUAL, getCurrentRemainingAmountAnnual()));
		if(getCurrentYearTotalWealfareLeave() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_YEAR_TOTAL_WEALFARE_LEAVE, getCurrentYearTotalWealfareLeave()));
		if(getCurrentYearUsageAmountWealfare() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_YEAR_USAGE_AMOUNT_WEALFARE, getCurrentYearUsageAmountWealfare()));
		if(getCurrentRemainingAmountWealfare() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_REMAINING_AMOUNT_WEALFARE, getCurrentRemainingAmountWealfare()));
		if(getLastYearTotalAnnualLeave() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_LAST_YEAR_TOTAL_ANNUAL_LEAVE, getLastYearTotalAnnualLeave()));
		if(getLastYearUsageAmountAnnual() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_LAST_YEAR_USAGE_AMOUNT_ANNUAL, getLastYearUsageAmountAnnual()));
		if(getLastRemainingAmountAnnual() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_LAST_REMAINING_AMOUNT_ANNUAL, getLastRemainingAmountAnnual()));
		if(getLastYearTotalWealfareLeave() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_LAST_YEAR_TOTAL_WEALFARE_LEAVE, getLastYearTotalWealfareLeave()));
		if(getLastYearUsageAmountWealfare() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_LAST_YEAR_USAGE_AMOUNT_WEALFARE, getLastYearUsageAmountWealfare()));
		if(getLastRemainingAmountWealfare() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_LAST_REMAINING_AMOUNT_WEALFARE, getLastRemainingAmountWealfare()));
		if(getLastRemainingLeave() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_LAST_REMAINING_LEAVE, getLastRemainingLeave()));
		if(getCurrentYearLeave() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_YEAR_LEAVE, getCurrentYearLeave()));
		if(getCurrentYearUsedtime() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_CURRENT_YEAR_USEDTIME, getCurrentYearUsedtime()));
		if(getRemainingOvertime() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_REMAINING_OVERTIME, getRemainingOvertime()));
		if(getUsed() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_USED, getUsed()));
		if(getOvertimeHours() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_OVERTIME_HOURS, getOvertimeHours()));
		if(getUsedY() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_USED_Y, getUsedY()));
		if(getOvertimeHoursY() != null || outDefault) sb.append(__wrapDecimal(count++, NAME_OVERTIME_HOURS_Y, getOvertimeHoursY()));
		if(getEmployeeId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_EMPLOYEE_ID, getEmployeeId()));
		if(getDepartmentId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_DEPARTMENT_ID, getDepartmentId()));
		if(getPlateId() != null || outDefault) sb.append(__wrapNumber(count++, NAME_PLATE_ID, getPlateId()));
		if(getYear() != null || outDefault) sb.append(__wrapNumber(count++, NAME_YEAR, getYear()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getEmployeeName() != null) res.put(NAME_EMPLOYEE_NAME, getEmployeeName());
		if(getEmployeeNo() != null) res.put(NAME_EMPLOYEE_NO, getEmployeeNo());
		if(getDepartmentName() != null) res.put(NAME_DEPARTMENT_NAME, getDepartmentName());
		if(getCurrentYearTotalAnnualLeave() != null) res.put(NAME_CURRENT_YEAR_TOTAL_ANNUAL_LEAVE, getCurrentYearTotalAnnualLeave());
		if(getCurrentYearUsageAmountAnnual() != null) res.put(NAME_CURRENT_YEAR_USAGE_AMOUNT_ANNUAL, getCurrentYearUsageAmountAnnual());
		if(getCurrentRemainingAmountAnnual() != null) res.put(NAME_CURRENT_REMAINING_AMOUNT_ANNUAL, getCurrentRemainingAmountAnnual());
		if(getCurrentYearTotalWealfareLeave() != null) res.put(NAME_CURRENT_YEAR_TOTAL_WEALFARE_LEAVE, getCurrentYearTotalWealfareLeave());
		if(getCurrentYearUsageAmountWealfare() != null) res.put(NAME_CURRENT_YEAR_USAGE_AMOUNT_WEALFARE, getCurrentYearUsageAmountWealfare());
		if(getCurrentRemainingAmountWealfare() != null) res.put(NAME_CURRENT_REMAINING_AMOUNT_WEALFARE, getCurrentRemainingAmountWealfare());
		if(getLastYearTotalAnnualLeave() != null) res.put(NAME_LAST_YEAR_TOTAL_ANNUAL_LEAVE, getLastYearTotalAnnualLeave());
		if(getLastYearUsageAmountAnnual() != null) res.put(NAME_LAST_YEAR_USAGE_AMOUNT_ANNUAL, getLastYearUsageAmountAnnual());
		if(getLastRemainingAmountAnnual() != null) res.put(NAME_LAST_REMAINING_AMOUNT_ANNUAL, getLastRemainingAmountAnnual());
		if(getLastYearTotalWealfareLeave() != null) res.put(NAME_LAST_YEAR_TOTAL_WEALFARE_LEAVE, getLastYearTotalWealfareLeave());
		if(getLastYearUsageAmountWealfare() != null) res.put(NAME_LAST_YEAR_USAGE_AMOUNT_WEALFARE, getLastYearUsageAmountWealfare());
		if(getLastRemainingAmountWealfare() != null) res.put(NAME_LAST_REMAINING_AMOUNT_WEALFARE, getLastRemainingAmountWealfare());
		if(getLastRemainingLeave() != null) res.put(NAME_LAST_REMAINING_LEAVE, getLastRemainingLeave());
		if(getCurrentYearLeave() != null) res.put(NAME_CURRENT_YEAR_LEAVE, getCurrentYearLeave());
		if(getCurrentYearUsedtime() != null) res.put(NAME_CURRENT_YEAR_USEDTIME, getCurrentYearUsedtime());
		if(getRemainingOvertime() != null) res.put(NAME_REMAINING_OVERTIME, getRemainingOvertime());
		if(getUsed() != null) res.put(NAME_USED, getUsed());
		if(getOvertimeHours() != null) res.put(NAME_OVERTIME_HOURS, getOvertimeHours());
		if(getUsedY() != null) res.put(NAME_USED_Y, getUsedY());
		if(getOvertimeHoursY() != null) res.put(NAME_OVERTIME_HOURS_Y, getOvertimeHoursY());
		if(getEmployeeId() != null) res.put(NAME_EMPLOYEE_ID, getEmployeeId());
		if(getDepartmentId() != null) res.put(NAME_DEPARTMENT_ID, getDepartmentId());
		if(getPlateId() != null) res.put(NAME_PLATE_ID, getPlateId());
		if(getYear() != null) res.put(NAME_YEAR, getYear());
		if(getCurrentPage() > 0) {
			res.put(NAME_CURRENT_PAGE, getCurrentPage());
			res.put(NAME_PAGE_LINES, getPageLines());
		}
		return res;
	}

	public static List<Map<String, Object>> GenerateMapList(List<BaseCalculateAnnualLeaveNew> ol) {
		List<Map<String, Object>> res = new ArrayList<>();
		for(BaseCalculateAnnualLeaveNew b : ol) res.add(b.toMap());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if(values.containsKey(NAME_CURRENT_PAGE) && (val = values.get(NAME_CURRENT_PAGE)) != null) setCurrentPage(__getInt(val));
		if(values.containsKey(NAME_PAGE_LINES) && (val = values.get(NAME_PAGE_LINES)) != null) setPageLines(__getInt(val));
		if(values.containsKey(NAME_EMPLOYEE_NAME) && (val = values.get(NAME_EMPLOYEE_NAME)) != null) setEmployeeName(__getString(val));
		if(values.containsKey(NAME_EMPLOYEE_NO) && (val = values.get(NAME_EMPLOYEE_NO)) != null) setEmployeeNo(__getString(val));
		if(values.containsKey(NAME_DEPARTMENT_NAME) && (val = values.get(NAME_DEPARTMENT_NAME)) != null) setDepartmentName(__getString(val));
		if(values.containsKey(NAME_CURRENT_YEAR_TOTAL_ANNUAL_LEAVE) && (val = values.get(NAME_CURRENT_YEAR_TOTAL_ANNUAL_LEAVE)) != null) setCurrentYearTotalAnnualLeave(__getDecimal(val));  
		if(values.containsKey(NAME_CURRENT_YEAR_USAGE_AMOUNT_ANNUAL) && (val = values.get(NAME_CURRENT_YEAR_USAGE_AMOUNT_ANNUAL)) != null) setCurrentYearUsageAmountAnnual(__getDecimal(val));  
		if(values.containsKey(NAME_CURRENT_REMAINING_AMOUNT_ANNUAL) && (val = values.get(NAME_CURRENT_REMAINING_AMOUNT_ANNUAL)) != null) setCurrentRemainingAmountAnnual(__getDecimal(val));  
		if(values.containsKey(NAME_CURRENT_YEAR_TOTAL_WEALFARE_LEAVE) && (val = values.get(NAME_CURRENT_YEAR_TOTAL_WEALFARE_LEAVE)) != null) setCurrentYearTotalWealfareLeave(__getDecimal(val));  
		if(values.containsKey(NAME_CURRENT_YEAR_USAGE_AMOUNT_WEALFARE) && (val = values.get(NAME_CURRENT_YEAR_USAGE_AMOUNT_WEALFARE)) != null) setCurrentYearUsageAmountWealfare(__getDecimal(val));  
		if(values.containsKey(NAME_CURRENT_REMAINING_AMOUNT_WEALFARE) && (val = values.get(NAME_CURRENT_REMAINING_AMOUNT_WEALFARE)) != null) setCurrentRemainingAmountWealfare(__getDecimal(val));  
		if(values.containsKey(NAME_LAST_YEAR_TOTAL_ANNUAL_LEAVE) && (val = values.get(NAME_LAST_YEAR_TOTAL_ANNUAL_LEAVE)) != null) setLastYearTotalAnnualLeave(__getDecimal(val));  
		if(values.containsKey(NAME_LAST_YEAR_USAGE_AMOUNT_ANNUAL) && (val = values.get(NAME_LAST_YEAR_USAGE_AMOUNT_ANNUAL)) != null) setLastYearUsageAmountAnnual(__getDecimal(val));  
		if(values.containsKey(NAME_LAST_REMAINING_AMOUNT_ANNUAL) && (val = values.get(NAME_LAST_REMAINING_AMOUNT_ANNUAL)) != null) setLastRemainingAmountAnnual(__getDecimal(val));  
		if(values.containsKey(NAME_LAST_YEAR_TOTAL_WEALFARE_LEAVE) && (val = values.get(NAME_LAST_YEAR_TOTAL_WEALFARE_LEAVE)) != null) setLastYearTotalWealfareLeave(__getDecimal(val));  
		if(values.containsKey(NAME_LAST_YEAR_USAGE_AMOUNT_WEALFARE) && (val = values.get(NAME_LAST_YEAR_USAGE_AMOUNT_WEALFARE)) != null) setLastYearUsageAmountWealfare(__getDecimal(val));  
		if(values.containsKey(NAME_LAST_REMAINING_AMOUNT_WEALFARE) && (val = values.get(NAME_LAST_REMAINING_AMOUNT_WEALFARE)) != null) setLastRemainingAmountWealfare(__getDecimal(val));  
		if(values.containsKey(NAME_LAST_REMAINING_LEAVE) && (val = values.get(NAME_LAST_REMAINING_LEAVE)) != null) setLastRemainingLeave(__getDecimal(val));  
		if(values.containsKey(NAME_CURRENT_YEAR_LEAVE) && (val = values.get(NAME_CURRENT_YEAR_LEAVE)) != null) setCurrentYearLeave(__getDecimal(val));  
		if(values.containsKey(NAME_CURRENT_YEAR_USEDTIME) && (val = values.get(NAME_CURRENT_YEAR_USEDTIME)) != null) setCurrentYearUsedtime(__getDecimal(val));  
		if(values.containsKey(NAME_REMAINING_OVERTIME) && (val = values.get(NAME_REMAINING_OVERTIME)) != null) setRemainingOvertime(__getDecimal(val));  
		if(values.containsKey(NAME_USED) && (val = values.get(NAME_USED)) != null) setUsed(__getDecimal(val));  
		if(values.containsKey(NAME_OVERTIME_HOURS) && (val = values.get(NAME_OVERTIME_HOURS)) != null) setOvertimeHours(__getDecimal(val));  
		if(values.containsKey(NAME_USED_Y) && (val = values.get(NAME_USED_Y)) != null) setUsedY(__getDecimal(val));  
		if(values.containsKey(NAME_OVERTIME_HOURS_Y) && (val = values.get(NAME_OVERTIME_HOURS_Y)) != null) setOvertimeHoursY(__getDecimal(val));  
		if(values.containsKey(NAME_EMPLOYEE_ID) && (val = values.get(NAME_EMPLOYEE_ID)) != null) setEmployeeId(__getInt(val)); 
		if(values.containsKey(NAME_DEPARTMENT_ID) && (val = values.get(NAME_DEPARTMENT_ID)) != null) setDepartmentId(__getInt(val)); 
		if(values.containsKey(NAME_PLATE_ID) && (val = values.get(NAME_PLATE_ID)) != null) setPlateId(__getInt(val)); 
		if(values.containsKey(NAME_YEAR) && (val = values.get(NAME_YEAR)) != null) setYear(__getInt(val)); 
	}

	protected java.lang.String  __employee_name ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __department_name ;
	protected java.math.BigDecimal  __current_year_total_annual_leave ;
	protected java.math.BigDecimal  __current_year_usage_amount_annual ;
	protected java.math.BigDecimal  __current_remaining_amount_annual ;
	protected java.math.BigDecimal  __current_year_total_wealfare_leave ;
	protected java.math.BigDecimal  __current_year_usage_amount_wealfare ;
	protected java.math.BigDecimal  __current_remaining_amount_wealfare ;
	protected java.math.BigDecimal  __last_year_total_annual_leave ;
	protected java.math.BigDecimal  __last_year_usage_amount_annual ;
	protected java.math.BigDecimal  __last_remaining_amount_annual ;
	protected java.math.BigDecimal  __last_year_total_wealfare_leave ;
	protected java.math.BigDecimal  __last_year_usage_amount_wealfare ;
	protected java.math.BigDecimal  __last_remaining_amount_wealfare ;
	protected java.math.BigDecimal  __last_remaining_leave ;
	protected java.math.BigDecimal  __current_year_leave ;
	protected java.math.BigDecimal  __current_year_usedtime ;
	protected java.math.BigDecimal  __remaining_overtime ;
	protected java.math.BigDecimal  __used ;
	protected java.math.BigDecimal  __overtime_hours ;
	protected java.math.BigDecimal  __used_y ;
	protected java.math.BigDecimal  __overtime_hours_y ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
}
