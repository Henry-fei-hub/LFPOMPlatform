package pomplatform.salaryexceptions.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnSalaryExceptionData extends GenericBase implements BaseFactory<BaseOnSalaryExceptionData>, Comparable<BaseOnSalaryExceptionData> 
{


	public static BaseOnSalaryExceptionData newInstance(){
		return new BaseOnSalaryExceptionData();
	}

	@Override
	public BaseOnSalaryExceptionData make(){
		BaseOnSalaryExceptionData b = new BaseOnSalaryExceptionData();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_EMPLOYEE_NAME = "employee_name" ;
	public final static java.lang.String CS_ATTENDANCE_DEDUCTION = "attendance_deduction" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_REASON = "reason" ;
	public final static java.lang.String CS_FACT_DAYS = "fact_days" ;
	public final static java.lang.String CS_IS_APPLY = "is_apply" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_ISIS_APPLY = "isis_apply" ;
	public final static java.lang.String CS_ACTUALLY_DEDUCTION = "actually_deduction" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,员工编号,员工姓名,考勤扣除金额,日期,扣款原因,实到天数,是否已申请,考勤备注,年份,月份,,实际扣除金额";

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

	public java.lang.String getReason() {
		return this.__reason;
	}

	public void setReason( java.lang.String value ) {
		this.__reason = value;
	}

	public java.math.BigDecimal getFactDays() {
		return this.__fact_days;
	}

	public void setFactDays( java.math.BigDecimal value ) {
		this.__fact_days = value;
	}

	public java.lang.Boolean getIsApply() {
		return this.__is_apply;
	}

	public void setIsApply( java.lang.Boolean value ) {
		this.__is_apply = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
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

	public java.lang.Boolean getIsisApply() {
		return this.__isis_apply;
	}

	public void setIsisApply( java.lang.Boolean value ) {
		this.__isis_apply = value;
	}

	public java.math.BigDecimal getActuallyDeduction() {
		return this.__actually_deduction;
	}

	public void setActuallyDeduction( java.math.BigDecimal value ) {
		this.__actually_deduction = value;
	}

	public void cloneCopy(BaseOnSalaryExceptionData __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setEmployeeName(getEmployeeName());
		__bean.setAttendanceDeduction(getAttendanceDeduction());
		__bean.setRecordDate(getRecordDate());
		__bean.setReason(getReason());
		__bean.setFactDays(getFactDays());
		__bean.setIsApply(getIsApply());
		__bean.setRemark(getRemark());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setIsisApply(getIsisApply());
		__bean.setActuallyDeduction(getActuallyDeduction());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		sb.append(getAttendanceDeduction() == null ? "" : getAttendanceDeduction());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getReason() == null ? "" : getReason());
		sb.append(",");
		sb.append(getFactDays() == null ? "" : getFactDays());
		sb.append(",");
		sb.append(getIsApply() == null ? "" : getIsApply());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getIsisApply() == null ? "" : getIsisApply());
		sb.append(",");
		sb.append(getActuallyDeduction() == null ? "" : getActuallyDeduction());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnSalaryExceptionData o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__employee_name);
		hash = 97 * hash + Objects.hashCode(this.__attendance_deduction);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__reason);
		hash = 97 * hash + Objects.hashCode(this.__fact_days);
		hash = 97 * hash + Objects.hashCode(this.__is_apply);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__isis_apply);
		hash = 97 * hash + Objects.hashCode(this.__actually_deduction);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnSalaryExceptionData o = (BaseOnSalaryExceptionData)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__employee_name, o.getEmployeeName())) return false;
		if(!Objects.equals(this.__attendance_deduction, o.getAttendanceDeduction())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__reason, o.getReason())) return false;
		if(!Objects.equals(this.__fact_days, o.getFactDays())) return false;
		if(!Objects.equals(this.__is_apply, o.getIsApply())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__isis_apply, o.getIsisApply())) return false;
		if(!Objects.equals(this.__actually_deduction, o.getActuallyDeduction())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(count++, "employeeName", getEmployeeName()));
		if(getAttendanceDeduction() != null) sb.append(__wrapDecimal(count++, "attendanceDeduction", getAttendanceDeduction()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getReason() != null) sb.append(__wrapString(count++, "reason", getReason()));
		if(getFactDays() != null) sb.append(__wrapDecimal(count++, "factDays", getFactDays()));
		if(getIsApply() != null) sb.append(__wrapBoolean(count++, "isApply", getIsApply()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getIsisApply() != null) sb.append(__wrapBoolean(count++, "isisApply", getIsisApply()));
		if(getActuallyDeduction() != null) sb.append(__wrapDecimal(count++, "actuallyDeduction", getActuallyDeduction()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("attendanceDeduction")) != null) setAttendanceDeduction(__getDecimal(val));  
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("reason")) != null) setReason(__getString(val));
		if((val = values.get("factDays")) != null) setFactDays(__getDecimal(val));  
		if((val = values.get("isApply")) != null) setIsApply(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("isisApply")) != null) setIsisApply(__getBoolean(val));
		if((val = values.get("actuallyDeduction")) != null) setActuallyDeduction(__getDecimal(val));  
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.String  __employee_name ;
	protected java.math.BigDecimal  __attendance_deduction ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __reason ;
	protected java.math.BigDecimal  __fact_days ;
	protected java.lang.Boolean  __is_apply ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.lang.Boolean  __isis_apply ;
	protected java.math.BigDecimal  __actually_deduction ;
}
