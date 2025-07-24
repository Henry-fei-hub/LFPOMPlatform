package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadEmpShiftInfo extends GenericBase implements BaseFactory<BaseOnLoadEmpShiftInfo>, Comparable<BaseOnLoadEmpShiftInfo> 
{


	public static BaseOnLoadEmpShiftInfo newInstance(){
		return new BaseOnLoadEmpShiftInfo();
	}

	@Override
	public BaseOnLoadEmpShiftInfo make(){
		BaseOnLoadEmpShiftInfo b = new BaseOnLoadEmpShiftInfo();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_SHIFT_MANAGE_ID = "shift_manage_id" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_SHIFT_TIME_MANAGE_ID = "shift_time_manage_id" ;
	public final static java.lang.String CS_MONDAY = "monday" ;
	public final static java.lang.String CS_TUESDAY = "tuesday" ;
	public final static java.lang.String CS_WEDNESDAY = "wednesday" ;
	public final static java.lang.String CS_THURSDAY = "thursday" ;
	public final static java.lang.String CS_FRIDAY = "friday" ;
	public final static java.lang.String CS_SATURDAY = "saturday" ;
	public final static java.lang.String CS_SUNDAY = "sunday" ;

	public final static java.lang.String ALL_CAPTIONS = "职员编码,班次编码,记录日期,时段id,星期一,星期二,星期三,星期四,星期五,星期六,星期日";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getShiftManageId() {
		return this.__shift_manage_id;
	}

	public void setShiftManageId( java.lang.Integer value ) {
		this.__shift_manage_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.Integer getShiftTimeManageId() {
		return this.__shift_time_manage_id;
	}

	public void setShiftTimeManageId( java.lang.Integer value ) {
		this.__shift_time_manage_id = value;
	}

	public java.lang.Boolean getMonday() {
		return this.__monday;
	}

	public void setMonday( java.lang.Boolean value ) {
		this.__monday = value;
	}

	public java.lang.Boolean getTuesday() {
		return this.__tuesday;
	}

	public void setTuesday( java.lang.Boolean value ) {
		this.__tuesday = value;
	}

	public java.lang.Boolean getWednesday() {
		return this.__wednesday;
	}

	public void setWednesday( java.lang.Boolean value ) {
		this.__wednesday = value;
	}

	public java.lang.Boolean getThursday() {
		return this.__thursday;
	}

	public void setThursday( java.lang.Boolean value ) {
		this.__thursday = value;
	}

	public java.lang.Boolean getFriday() {
		return this.__friday;
	}

	public void setFriday( java.lang.Boolean value ) {
		this.__friday = value;
	}

	public java.lang.Boolean getSaturday() {
		return this.__saturday;
	}

	public void setSaturday( java.lang.Boolean value ) {
		this.__saturday = value;
	}

	public java.lang.Boolean getSunday() {
		return this.__sunday;
	}

	public void setSunday( java.lang.Boolean value ) {
		this.__sunday = value;
	}

	public void cloneCopy(BaseOnLoadEmpShiftInfo __bean){
		__bean.setEmployeeId(getEmployeeId());
		__bean.setShiftManageId(getShiftManageId());
		__bean.setRecordDate(getRecordDate());
		__bean.setShiftTimeManageId(getShiftTimeManageId());
		__bean.setMonday(getMonday());
		__bean.setTuesday(getTuesday());
		__bean.setWednesday(getWednesday());
		__bean.setThursday(getThursday());
		__bean.setFriday(getFriday());
		__bean.setSaturday(getSaturday());
		__bean.setSunday(getSunday());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getShiftManageId() == null ? "" : getShiftManageId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getShiftTimeManageId() == null ? "" : getShiftTimeManageId());
		sb.append(",");
		sb.append(getMonday() == null ? "" : getMonday());
		sb.append(",");
		sb.append(getTuesday() == null ? "" : getTuesday());
		sb.append(",");
		sb.append(getWednesday() == null ? "" : getWednesday());
		sb.append(",");
		sb.append(getThursday() == null ? "" : getThursday());
		sb.append(",");
		sb.append(getFriday() == null ? "" : getFriday());
		sb.append(",");
		sb.append(getSaturday() == null ? "" : getSaturday());
		sb.append(",");
		sb.append(getSunday() == null ? "" : getSunday());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadEmpShiftInfo o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__shift_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__shift_time_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__monday);
		hash = 97 * hash + Objects.hashCode(this.__tuesday);
		hash = 97 * hash + Objects.hashCode(this.__wednesday);
		hash = 97 * hash + Objects.hashCode(this.__thursday);
		hash = 97 * hash + Objects.hashCode(this.__friday);
		hash = 97 * hash + Objects.hashCode(this.__saturday);
		hash = 97 * hash + Objects.hashCode(this.__sunday);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadEmpShiftInfo o = (BaseOnLoadEmpShiftInfo)obj;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__shift_manage_id, o.getShiftManageId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__shift_time_manage_id, o.getShiftTimeManageId())) return false;
		if(!Objects.equals(this.__monday, o.getMonday())) return false;
		if(!Objects.equals(this.__tuesday, o.getTuesday())) return false;
		if(!Objects.equals(this.__wednesday, o.getWednesday())) return false;
		if(!Objects.equals(this.__thursday, o.getThursday())) return false;
		if(!Objects.equals(this.__friday, o.getFriday())) return false;
		if(!Objects.equals(this.__saturday, o.getSaturday())) return false;
		if(!Objects.equals(this.__sunday, o.getSunday())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getShiftManageId() != null) sb.append(__wrapNumber(count++, "shiftManageId", getShiftManageId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getShiftTimeManageId() != null) sb.append(__wrapNumber(count++, "shiftTimeManageId", getShiftTimeManageId()));
		if(getMonday() != null) sb.append(__wrapBoolean(count++, "monday", getMonday()));
		if(getTuesday() != null) sb.append(__wrapBoolean(count++, "tuesday", getTuesday()));
		if(getWednesday() != null) sb.append(__wrapBoolean(count++, "wednesday", getWednesday()));
		if(getThursday() != null) sb.append(__wrapBoolean(count++, "thursday", getThursday()));
		if(getFriday() != null) sb.append(__wrapBoolean(count++, "friday", getFriday()));
		if(getSaturday() != null) sb.append(__wrapBoolean(count++, "saturday", getSaturday()));
		if(getSunday() != null) sb.append(__wrapBoolean(count++, "sunday", getSunday()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("shiftManageId")) != null) setShiftManageId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("shiftTimeManageId")) != null) setShiftTimeManageId(__getInt(val)); 
		if((val = values.get("monday")) != null) setMonday(__getBoolean(val));
		if((val = values.get("tuesday")) != null) setTuesday(__getBoolean(val));
		if((val = values.get("wednesday")) != null) setWednesday(__getBoolean(val));
		if((val = values.get("thursday")) != null) setThursday(__getBoolean(val));
		if((val = values.get("friday")) != null) setFriday(__getBoolean(val));
		if((val = values.get("saturday")) != null) setSaturday(__getBoolean(val));
		if((val = values.get("sunday")) != null) setSunday(__getBoolean(val));
	}

	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __shift_manage_id ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __shift_time_manage_id ;
	protected java.lang.Boolean  __monday ;
	protected java.lang.Boolean  __tuesday ;
	protected java.lang.Boolean  __wednesday ;
	protected java.lang.Boolean  __thursday ;
	protected java.lang.Boolean  __friday ;
	protected java.lang.Boolean  __saturday ;
	protected java.lang.Boolean  __sunday ;
}
