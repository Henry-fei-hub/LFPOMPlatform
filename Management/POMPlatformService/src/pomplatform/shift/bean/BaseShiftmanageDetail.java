package pomplatform.shift.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseShiftmanageDetail extends GenericBase implements BaseFactory<BaseShiftmanageDetail>, Comparable<BaseShiftmanageDetail> 
{


	public static BaseShiftmanageDetail newInstance(){
		return new BaseShiftmanageDetail();
	}

	@Override
	public BaseShiftmanageDetail make(){
		BaseShiftmanageDetail b = new BaseShiftmanageDetail();
		return b;
	}

	public final static java.lang.String CS_SHIFT_MANAGE_ID = "shift_manage_id" ;
	public final static java.lang.String CS_SHIFT_NAME = "shift_name" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_MONDAY = "monday" ;
	public final static java.lang.String CS_TUESDAY = "tuesday" ;
	public final static java.lang.String CS_WEDNESDAY = "wednesday" ;
	public final static java.lang.String CS_THURSDAY = "thursday" ;
	public final static java.lang.String CS_FRIDAY = "friday" ;
	public final static java.lang.String CS_SATURDAY = "saturday" ;
	public final static java.lang.String CS_SUNDAY = "sunday" ;
	public final static java.lang.String CS_IS_ENABLE = "is_enable" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_SHIFT_TIME_MANAGE_ID = "shift_time_manage_id" ;
	public final static java.lang.String CS_SHIFT_TIME_NAME = "shift_time_name" ;
	public final static java.lang.String CS_SIGN_IN_TIME = "sign_in_time" ;
	public final static java.lang.String CS_SIGN_OFF_TIME = "sign_off_time" ;
	public final static java.lang.String CS_TIME_OF_SHIFT_MANAGE_ID = "time_of_shift_manage_id" ;
	

	public final static java.lang.String ALL_CAPTIONS = "班次主键编码,班次名称,起用日期,结束日期,星期一,星期二,星期三,星期四,星期五,星期六,星期日,是否启用,备注,时段id,时段名称,上班时间（格式如0900）,下班时间（格式如0900）,班次的时段的id";

	public java.lang.Integer getShiftManageId() {
		return this.__shift_manage_id;
	}

	public void setShiftManageId( java.lang.Integer value ) {
		this.__shift_manage_id = value;
	}

	public java.lang.String getShiftName() {
		return this.__shift_name;
	}

	public void setShiftName( java.lang.String value ) {
		this.__shift_name = value;
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
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

	public java.lang.Boolean getIsEnable() {
		return this.__is_enable;
	}

	public void setIsEnable( java.lang.Boolean value ) {
		this.__is_enable = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getShiftTimeManageId() {
		return this.__shift_time_manage_id;
	}

	public void setShiftTimeManageId( java.lang.Integer value ) {
		this.__shift_time_manage_id = value;
	}

	public java.lang.String getShiftTimeName() {
		return this.__shift_time_name;
	}

	public void setShiftTimeName( java.lang.String value ) {
		this.__shift_time_name = value;
	}

	public java.lang.String getSignInTime() {
		return this.__sign_in_time;
	}

	public void setSignInTime( java.lang.String value ) {
		this.__sign_in_time = value;
	}

	public java.lang.String getSignOffTime() {
		return this.__sign_off_time;
	}

	public void setSignOffTime( java.lang.String value ) {
		this.__sign_off_time = value;
	}
	
	public java.lang.Integer getTimeOfShiftManageId() {
		return this.__time_of_shift_manage_id;
	}

	public void setTimeOfShiftManageId( java.lang.Integer value ) {
		this.__time_of_shift_manage_id = value;
	}
	public void cloneCopy(BaseShiftmanageDetail __bean){
		__bean.setShiftManageId(getShiftManageId());
		__bean.setShiftName(getShiftName());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setMonday(getMonday());
		__bean.setTuesday(getTuesday());
		__bean.setWednesday(getWednesday());
		__bean.setThursday(getThursday());
		__bean.setFriday(getFriday());
		__bean.setSaturday(getSaturday());
		__bean.setSunday(getSunday());
		__bean.setIsEnable(getIsEnable());
		__bean.setRemark(getRemark());
		__bean.setShiftTimeManageId(getShiftTimeManageId());
		__bean.setShiftTimeName(getShiftTimeName());
		__bean.setSignInTime(getSignInTime());
		__bean.setSignOffTime(getSignOffTime());
		__bean.setTimeOfShiftManageId(getTimeOfShiftManageId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getShiftManageId() == null ? "" : getShiftManageId());
		sb.append(",");
		sb.append(getShiftName() == null ? "" : getShiftName());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
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
		sb.append(",");
		sb.append(getIsEnable() == null ? "" : getIsEnable());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getShiftTimeManageId() == null ? "" : getShiftTimeManageId());
		sb.append(",");
		sb.append(getShiftTimeName() == null ? "" : getShiftTimeName());
		sb.append(",");
		sb.append(getSignInTime() == null ? "" : getSignInTime());
		sb.append(",");
		sb.append(getSignOffTime() == null ? "" : getSignOffTime());
		sb.append(",");
		sb.append(getTimeOfShiftManageId() == null ? "" : getTimeOfShiftManageId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseShiftmanageDetail o) {
		return __shift_manage_id == null ? -1 : __shift_manage_id.compareTo(o.getShiftManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__shift_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__shift_name);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__monday);
		hash = 97 * hash + Objects.hashCode(this.__tuesday);
		hash = 97 * hash + Objects.hashCode(this.__wednesday);
		hash = 97 * hash + Objects.hashCode(this.__thursday);
		hash = 97 * hash + Objects.hashCode(this.__friday);
		hash = 97 * hash + Objects.hashCode(this.__saturday);
		hash = 97 * hash + Objects.hashCode(this.__sunday);
		hash = 97 * hash + Objects.hashCode(this.__is_enable);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__shift_time_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__shift_time_name);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_off_time);
		hash = 97 * hash + Objects.hashCode(this.__time_of_shift_manage_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseShiftmanageDetail o = (BaseShiftmanageDetail)obj;
		if(!Objects.equals(this.__shift_manage_id, o.getShiftManageId())) return false;
		if(!Objects.equals(this.__shift_name, o.getShiftName())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__monday, o.getMonday())) return false;
		if(!Objects.equals(this.__tuesday, o.getTuesday())) return false;
		if(!Objects.equals(this.__wednesday, o.getWednesday())) return false;
		if(!Objects.equals(this.__thursday, o.getThursday())) return false;
		if(!Objects.equals(this.__friday, o.getFriday())) return false;
		if(!Objects.equals(this.__saturday, o.getSaturday())) return false;
		if(!Objects.equals(this.__sunday, o.getSunday())) return false;
		if(!Objects.equals(this.__is_enable, o.getIsEnable())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__shift_time_manage_id, o.getShiftTimeManageId())) return false;
		if(!Objects.equals(this.__shift_time_name, o.getShiftTimeName())) return false;
		if(!Objects.equals(this.__sign_in_time, o.getSignInTime())) return false;
		if(!Objects.equals(this.__sign_off_time, o.getSignOffTime())) return false;
		if(!Objects.equals(this.__time_of_shift_manage_id, o.getSignOffTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getShiftManageId() != null) sb.append(__wrapNumber(count++, "shiftManageId", getShiftManageId()));
		if(getShiftName() != null) sb.append(__wrapString(count++, "shiftName", getShiftName()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getMonday() != null) sb.append(__wrapBoolean(count++, "monday", getMonday()));
		if(getTuesday() != null) sb.append(__wrapBoolean(count++, "tuesday", getTuesday()));
		if(getWednesday() != null) sb.append(__wrapBoolean(count++, "wednesday", getWednesday()));
		if(getThursday() != null) sb.append(__wrapBoolean(count++, "thursday", getThursday()));
		if(getFriday() != null) sb.append(__wrapBoolean(count++, "friday", getFriday()));
		if(getSaturday() != null) sb.append(__wrapBoolean(count++, "saturday", getSaturday()));
		if(getSunday() != null) sb.append(__wrapBoolean(count++, "sunday", getSunday()));
		if(getIsEnable() != null) sb.append(__wrapBoolean(count++, "isEnable", getIsEnable()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getShiftTimeManageId() != null) sb.append(__wrapNumber(count++, "shiftTimeManageId", getShiftTimeManageId()));
		if(getShiftTimeName() != null) sb.append(__wrapString(count++, "shiftTimeName", getShiftTimeName()));
		if(getSignInTime() != null) sb.append(__wrapString(count++, "signInTime", getSignInTime()));
		if(getSignOffTime() != null) sb.append(__wrapString(count++, "signOffTime", getSignOffTime()));
		if(getTimeOfShiftManageId() != null) sb.append(__wrapNumber(count++, "timeOfShiftManageId", getTimeOfShiftManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("shiftManageId")) != null) setShiftManageId(__getInt(val)); 
		if((val = values.get("shiftName")) != null) setShiftName(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("monday")) != null) setMonday(__getBoolean(val));
		if((val = values.get("tuesday")) != null) setTuesday(__getBoolean(val));
		if((val = values.get("wednesday")) != null) setWednesday(__getBoolean(val));
		if((val = values.get("thursday")) != null) setThursday(__getBoolean(val));
		if((val = values.get("friday")) != null) setFriday(__getBoolean(val));
		if((val = values.get("saturday")) != null) setSaturday(__getBoolean(val));
		if((val = values.get("sunday")) != null) setSunday(__getBoolean(val));
		if((val = values.get("isEnable")) != null) setIsEnable(__getBoolean(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("shiftTimeManageId")) != null) setShiftTimeManageId(__getInt(val)); 
		if((val = values.get("shiftTimeName")) != null) setShiftTimeName(__getString(val));
		if((val = values.get("signInTime")) != null) setSignInTime(__getString(val));
		if((val = values.get("signOffTime")) != null) setSignOffTime(__getString(val));
		if((val = values.get("timeOfShiftManageId")) != null) setTimeOfShiftManageId(__getInt(val));
	}

	protected java.lang.Integer  __shift_manage_id ;
	protected java.lang.String  __shift_name ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.lang.Boolean  __monday ;
	protected java.lang.Boolean  __tuesday ;
	protected java.lang.Boolean  __wednesday ;
	protected java.lang.Boolean  __thursday ;
	protected java.lang.Boolean  __friday ;
	protected java.lang.Boolean  __saturday ;
	protected java.lang.Boolean  __sunday ;
	protected java.lang.Boolean  __is_enable ;
	protected java.lang.String  __remark ;
	protected java.lang.Integer  __shift_time_manage_id ;
	protected java.lang.String  __shift_time_name ;
	protected java.lang.String  __sign_in_time ;
	protected java.lang.String  __sign_off_time ;
	protected java.lang.Integer  __time_of_shift_manage_id;

}
