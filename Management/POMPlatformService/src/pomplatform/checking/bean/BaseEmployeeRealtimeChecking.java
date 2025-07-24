package pomplatform.checking.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseEmployeeRealtimeChecking extends GenericBase implements BaseFactory<BaseEmployeeRealtimeChecking>, Comparable<BaseEmployeeRealtimeChecking> 
{


	public static BaseEmployeeRealtimeChecking newInstance(){
		return new BaseEmployeeRealtimeChecking();
	}

	@Override
	public BaseEmployeeRealtimeChecking make(){
		BaseEmployeeRealtimeChecking b = new BaseEmployeeRealtimeChecking();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_CHECKIN = "checkin" ;
	public final static java.lang.String CS_CHECKOUT = "checkout" ;
	public final static java.lang.String CS_SHOULD_DAYS = "should_days" ;
	public final static java.lang.String CS_FACT_DAYS = "fact_days" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,员工编号,所属部门,年份,月份,考勤日期,签到时间,签退时间,应到天数,实到天数,考勤状态,备注";
	public final static java.lang.String DOWNLOAD_CAPTIONS = "所属部门,员工编号,员工姓名,考勤日期,签到时间,签退时间,考勤状态,备注";
	
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

	public java.lang.String getCheckin() {
		return this.__checkin;
	}

	public void setCheckin( java.lang.String value ) {
		this.__checkin = value;
	}

	public java.lang.String getCheckout() {
		return this.__checkout;
	}

	public void setCheckout( java.lang.String value ) {
		this.__checkout = value;
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

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseEmployeeRealtimeChecking __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setRecordDate(getRecordDate());
		__bean.setCheckin(getCheckin());
		__bean.setCheckout(getCheckout());
		__bean.setShouldDays(getShouldDays());
		__bean.setFactDays(getFactDays());
		__bean.setStatus(getStatus());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		StringBuilder sb = new StringBuilder();
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate())+"\t");
		sb.append(",");
		sb.append(getCheckin() == null ? "" : getCheckin()+"\t");
		sb.append(",");
		sb.append(getCheckout() == null ? "" : getCheckout()+"\t");
		sb.append(",");
		String strStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_91", String.valueOf(getStatus()));
		sb.append(strStatus == null ? "" : strStatus);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseEmployeeRealtimeChecking o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__checkin);
		hash = 97 * hash + Objects.hashCode(this.__checkout);
		hash = 97 * hash + Objects.hashCode(this.__should_days);
		hash = 97 * hash + Objects.hashCode(this.__fact_days);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseEmployeeRealtimeChecking o = (BaseEmployeeRealtimeChecking)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__employee_no, o.getEmployeeNo())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__checkin, o.getCheckin())) return false;
		if(!Objects.equals(this.__checkout, o.getCheckout())) return false;
		if(!Objects.equals(this.__should_days, o.getShouldDays())) return false;
		if(!Objects.equals(this.__fact_days, o.getFactDays())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getCheckin() != null) sb.append(__wrapString(count++, "checkin", getCheckin()));
		if(getCheckout() != null) sb.append(__wrapString(count++, "checkout", getCheckout()));
		if(getShouldDays() != null) sb.append(__wrapDecimal(count++, "shouldDays", getShouldDays()));
		if(getFactDays() != null) sb.append(__wrapDecimal(count++, "factDays", getFactDays()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("checkin")) != null) setCheckin(__getString(val));
		if((val = values.get("checkout")) != null) setCheckout(__getString(val));
		if((val = values.get("shouldDays")) != null) setShouldDays(__getDecimal(val));  
		if((val = values.get("factDays")) != null) setFactDays(__getDecimal(val));  
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.String  __employee_no ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __checkin ;
	protected java.lang.String  __checkout ;
	protected java.math.BigDecimal  __should_days ;
	protected java.math.BigDecimal  __fact_days ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __remark ;
}
