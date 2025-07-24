package pomplatform.salary.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.Map;
import java.util.Objects;

public class BaseCalculateAnnualLeave extends GenericBase implements BaseFactory<BaseCalculateAnnualLeave>, Comparable<BaseCalculateAnnualLeave>
{


	public static BaseCalculateAnnualLeave newInstance(){
		return new BaseCalculateAnnualLeave();
	}

	@Override
	public BaseCalculateAnnualLeave make(){
		BaseCalculateAnnualLeave b = new BaseCalculateAnnualLeave();
		return b;
	}

	public final static String CS_EMPLOYEE_NO = "employee_no" ;
	public final static String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static String CS_DEPARTMENT_NAME = "department_name" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_DEPARTMENT_ID = "department_id" ;
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
	public final static java.lang.String CS_LAST_REMAINING_LEAVE = "last_remaining_leave" ;
	public final static java.lang.String CS_CURRENT_YEAR_LEAVE = "current_year_leave" ;
	public final static java.lang.String CS_CURRENT_YEAR_USEDTIME = "current_year_usedtime" ;
	public final static String CS_REMAINING_OVERTIME = "remaining_overtime";

	public final static String ALL_CAPTIONS = "员工编号,员工姓名,员工部门,当年度年假,当年使用的年假,当年剩余年假,当年带薪病假,当年使用带薪病假,剩余带薪病假,上一年年假,上一年使用年假,上一年剩余年假,上一年带薪病假,上一年使用带薪病假,上一年剩余带薪病假,上年度剩余加班（小时）,本年度加班（小时）,本年度使用调休假,剩余加班（小时）";

	public String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( String value ) {
		this.__employee_no = value;
	}

	public String getEmployeeName() {
		return this.__employee_name;
	}

	public void setEmployeeName( String value ) {
		this.__employee_name = value;
	}

	public String getDepartmentName() {
		return this.__department_name;
	}

	public void setDepartmentName( String value ) {
		this.__department_name = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( Integer value ) {
		this.__department_id = value;
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

	public void setRemainingOvertime( java.math.BigDecimal value ) {
		this.__remaining_overtime = value;
	}

	public java.math.BigDecimal getRemainingOvertime() {
		return this.__remaining_overtime;
	}

	public void cloneCopy(BaseCalculateAnnualLeave __bean){
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setDepartmentName(getDepartmentName());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setDepartmentId(getDepartmentId());
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
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
//		String strEmployeeName = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getEmployeeName()));
//		sb.append(strEmployeeName == null ? "" : strEmployeeName);
//		sb.append(",");
//		sb.append(getDepartmentName() == null ? "" : getDepartmentName());
//		sb.append(",");
		String employeeID = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(getEmployeeId() == null ? "" : employeeID);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
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
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCalculateAnnualLeave o) {
		return __employee_no == null ? -1 : __employee_no.compareTo(o.getEmployeeNo());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__department_name);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
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
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCalculateAnnualLeave o = (BaseCalculateAnnualLeave)obj;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__department_name, o.getDepartmentName())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
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
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getDepartmentName() != null) sb.append(__wrapString(count++, "departmentName", getDepartmentName()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getCurrentYearTotalAnnualLeave() != null) sb.append(__wrapDecimal(count++, "currentYearTotalAnnualLeave", getCurrentYearTotalAnnualLeave()));
		if(getCurrentYearUsageAmountAnnual() != null) sb.append(__wrapDecimal(count++, "currentYearUsageAmountAnnual", getCurrentYearUsageAmountAnnual()));
		if(getCurrentRemainingAmountAnnual() != null) sb.append(__wrapNumber(count++, "currentRemainingAmountAnnual", getCurrentRemainingAmountAnnual()));
		if(getCurrentYearTotalWealfareLeave() != null) sb.append(__wrapDecimal(count++, "currentYearTotalWealfareLeave", getCurrentYearTotalWealfareLeave()));
		if(getCurrentYearUsageAmountWealfare() != null) sb.append(__wrapDecimal(count++, "currentYearUsageAmountWealfare", getCurrentYearUsageAmountWealfare()));
		if(getCurrentRemainingAmountWealfare() != null) sb.append(__wrapNumber(count++, "currentRemainingAmountWealfare", getCurrentRemainingAmountWealfare()));
		if(getLastYearTotalAnnualLeave() != null) sb.append(__wrapDecimal(count++, "lastYearTotalAnnualLeave", getLastYearTotalAnnualLeave()));
		if(getLastYearUsageAmountAnnual() != null) sb.append(__wrapDecimal(count++, "lastYearUsageAmountAnnual", getLastYearUsageAmountAnnual()));
		if(getLastRemainingAmountAnnual() != null) sb.append(__wrapNumber(count++, "lastRemainingAmountAnnual", getLastRemainingAmountAnnual()));
		if(getLastYearTotalWealfareLeave() != null) sb.append(__wrapDecimal(count++, "lastYearTotalWealfareLeave", getLastYearTotalWealfareLeave()));
		if(getLastYearUsageAmountWealfare() != null) sb.append(__wrapDecimal(count++, "lastYearUsageAmountWealfare", getLastYearUsageAmountWealfare()));
		if(getLastRemainingAmountWealfare() != null) sb.append(__wrapNumber(count++, "lastRemainingAmountWealfare", getLastRemainingAmountWealfare()));
		if(getLastRemainingLeave() != null) sb.append(__wrapDecimal(count++, "lastRemainingLeave", getLastRemainingLeave()));
		if(getCurrentYearLeave() != null) sb.append(__wrapDecimal(count++, "currentYearLeave", getCurrentYearLeave()));
		if(getCurrentYearUsedtime() != null) sb.append(__wrapDecimal(count++, "currentYearUsedtime", getCurrentYearUsedtime()));
		if(getRemainingOvertime() != null) sb.append(__wrapDecimal(count++, "remainingOvertime", getRemainingOvertime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentName")) != null) setDepartmentName(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
		if((val = values.get("currentYearTotalAnnualLeave")) != null) setCurrentYearTotalAnnualLeave(__getDecimal(val));
		if((val = values.get("currentYearUsageAmountAnnual")) != null) setCurrentYearUsageAmountAnnual(__getDecimal(val));
		if((val = values.get("currentRemainingAmountAnnual")) != null) setCurrentRemainingAmountAnnual(__getDecimal(val));
		if((val = values.get("currentYearTotalWealfareLeave")) != null) setCurrentYearTotalWealfareLeave(__getDecimal(val));
		if((val = values.get("currentYearUsageAmountWealfare")) != null) setCurrentYearUsageAmountWealfare(__getDecimal(val));
		if((val = values.get("currentRemainingAmountWealfare")) != null) setCurrentRemainingAmountWealfare(__getDecimal(val));
		if((val = values.get("lastYearTotalAnnualLeave")) != null) setLastYearTotalAnnualLeave(__getDecimal(val));
		if((val = values.get("lastYearUsageAmountAnnual")) != null) setLastYearUsageAmountAnnual(__getDecimal(val));
		if((val = values.get("lastRemainingAmountAnnual")) != null) setLastRemainingAmountAnnual(__getDecimal(val));
		if((val = values.get("lastYearTotalWealfareLeave")) != null) setLastYearTotalWealfareLeave(__getDecimal(val));
		if((val = values.get("lastYearUsageAmountWealfare")) != null) setLastYearUsageAmountWealfare(__getDecimal(val));
		if((val = values.get("lastRemainingAmountWealfare")) != null) setLastRemainingAmountWealfare(__getDecimal(val));
		if((val = values.get("lastRemainingLeave")) != null) setLastRemainingLeave(__getDecimal(val));
		if((val = values.get("currentYearLeave")) != null) setCurrentYearLeave(__getDecimal(val));
		if((val = values.get("currentYearUsedtime")) != null) setCurrentYearUsedtime(__getDecimal(val));
		if((val = values.get("remainingOvertime")) != null) setRemainingOvertime(__getDecimal(val));
	}

	protected String  __employee_no ;
	protected String  __employee_name ;
	protected String  __department_name ;
	protected Integer  __employee_id ;
	protected Integer  __department_id ;
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
	protected java.math.BigDecimal __remaining_overtime;
}
