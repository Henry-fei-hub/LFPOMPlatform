package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMemployeecheckinouteeseor extends GenericBase implements BaseFactory<BaseMemployeecheckinouteeseor>, Comparable<BaseMemployeecheckinouteeseor> 
{


	public static BaseMemployeecheckinouteeseor newInstance(){
		return new BaseMemployeecheckinouteeseor();
	}

	@Override
	public BaseMemployeecheckinouteeseor make(){
		BaseMemployeecheckinouteeseor b = new BaseMemployeecheckinouteeseor();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_CHECK_DATE = "check_date" ;
	public final static java.lang.String CS_DAY_OF_WEEK = "day_of_week" ;
	public final static java.lang.String CS_CHECK_IN = "check_in" ;
	public final static java.lang.String CS_CHECK_OUT = "check_out" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_LEAVE_HOURS = "leave_hours" ;
	public final static java.lang.String CS_LEAVE_DAYS = "leave_days" ;
	public final static java.lang.String CS_FINAL_STATUS = "final_status" ;
	public final static java.lang.String CS_COMMENTS = "comments" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;

	public final static java.lang.String ALL_CAPTIONS = "员工代码,员工号,员工姓名,考勤日期,星期,,,考勤状态,请假小时,请假天数,正常,备注,所属部门";

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

	public java.util.Date getCheckDate() {
		return this.__check_date;
	}

	public void setCheckDate( java.util.Date value ) {
		this.__check_date = value;
	}

	public java.lang.Integer getDayOfWeek() {
		return this.__day_of_week;
	}

	public void setDayOfWeek( java.lang.Integer value ) {
		this.__day_of_week = value;
	}

	public java.lang.String getCheckIn() {
		return this.__check_in;
	}

	public void setCheckIn( java.lang.String value ) {
		this.__check_in = value;
	}

	public java.lang.String getCheckOut() {
		return this.__check_out;
	}

	public void setCheckOut( java.lang.String value ) {
		this.__check_out = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getLeaveHours() {
		return this.__leave_hours;
	}

	public void setLeaveHours( java.math.BigDecimal value ) {
		this.__leave_hours = value;
	}

	public java.math.BigDecimal getLeaveDays() {
		return this.__leave_days;
	}

	public void setLeaveDays( java.math.BigDecimal value ) {
		this.__leave_days = value;
	}

	public java.lang.Boolean getFinalStatus() {
		return this.__final_status;
	}

	public void setFinalStatus( java.lang.Boolean value ) {
		this.__final_status = value;
	}

	public java.lang.String getComments() {
		return this.__comments;
	}

	public void setComments( java.lang.String value ) {
		this.__comments = value;
	}
	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public void cloneCopy(BaseMemployeecheckinouteeseor __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setCheckDate(getCheckDate());
		__bean.setDayOfWeek(getDayOfWeek());
		__bean.setCheckIn(getCheckIn());
		__bean.setCheckOut(getCheckOut());
		__bean.setStatus(getStatus());
		__bean.setLeaveHours(getLeaveHours());
		__bean.setLeaveDays(getLeaveDays());
		__bean.setFinalStatus(getFinalStatus());
		__bean.setComments(getComments());
		__bean.setDepartmentId(getDepartmentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getCheckDate() == null ? "" : sdf.format(getCheckDate()));
		sb.append(",");
		sb.append(getDayOfWeek() == null ? "" : getDayOfWeek());
		sb.append(",");
		sb.append(getCheckIn() == null ? "" : getCheckIn());
		sb.append(",");
		sb.append(getCheckOut() == null ? "" : getCheckOut());
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_22", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getLeaveHours() == null ? "" : getLeaveHours());
		sb.append(",");
		sb.append(getLeaveDays() == null ? "" : getLeaveDays());
		sb.append(",");
		sb.append(getFinalStatus() == null ? "" : getFinalStatus());
		sb.append(",");
		sb.append(getComments() == null ? "" : getComments());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMemployeecheckinouteeseor o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__check_date);
		hash = 97 * hash + Objects.hashCode(this.__day_of_week);
		hash = 97 * hash + Objects.hashCode(this.__check_in);
		hash = 97 * hash + Objects.hashCode(this.__check_out);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__leave_hours);
		hash = 97 * hash + Objects.hashCode(this.__leave_days);
		hash = 97 * hash + Objects.hashCode(this.__final_status);
		hash = 97 * hash + Objects.hashCode(this.__comments);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMemployeecheckinouteeseor o = (BaseMemployeecheckinouteeseor)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__check_date, o.getCheckDate())) return false;
		if(!Objects.equals(this.__day_of_week, o.getDayOfWeek())) return false;
		if(!Objects.equals(this.__check_in, o.getCheckIn())) return false;
		if(!Objects.equals(this.__check_out, o.getCheckOut())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__leave_hours, o.getLeaveHours())) return false;
		if(!Objects.equals(this.__leave_days, o.getLeaveDays())) return false;
		if(!Objects.equals(this.__final_status, o.getFinalStatus())) return false;
		if(!Objects.equals(this.__comments, o.getComments())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getCheckDate() != null) sb.append(__wrapDate(count++, "checkDate", getCheckDate()));
		if(getDayOfWeek() != null) sb.append(__wrapNumber(count++, "dayOfWeek", getDayOfWeek()));
		if(getCheckIn() != null) sb.append(__wrapString(count++, "checkIn", getCheckIn()));
		if(getCheckOut() != null) sb.append(__wrapString(count++, "checkOut", getCheckOut()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getLeaveHours() != null) sb.append(__wrapDecimal(count++, "leaveHours", getLeaveHours()));
		if(getLeaveDays() != null) sb.append(__wrapDecimal(count++, "leaveDays", getLeaveDays()));
		if(getFinalStatus() != null) sb.append(__wrapBoolean(count++, "finalStatus", getFinalStatus()));
		if(getComments() != null) sb.append(__wrapString(count++, "comments", getComments()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("checkDate")) != null) setCheckDate(__getDate(val)); 
		if((val = values.get("dayOfWeek")) != null) setDayOfWeek(__getInt(val)); 
		if((val = values.get("checkIn")) != null) setCheckIn(__getString(val));
		if((val = values.get("checkOut")) != null) setCheckOut(__getString(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("leaveHours")) != null) setLeaveHours(__getDecimal(val));  
		if((val = values.get("leaveDays")) != null) setLeaveDays(__getDecimal(val));  
		if((val = values.get("finalStatus")) != null) setFinalStatus(__getBoolean(val));
		if((val = values.get("comments")) != null) setComments(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.util.Date  __check_date ;
	protected java.lang.Integer  __day_of_week ;
	protected java.lang.String  __check_in ;
	protected java.lang.String  __check_out ;
	protected java.lang.Integer  __status ;
	protected java.math.BigDecimal  __leave_hours ;
	protected java.math.BigDecimal  __leave_days ;
	protected java.lang.Boolean  __final_status ;
	protected java.lang.String  __comments ;
	protected java.lang.Integer  __department_id ;
}
