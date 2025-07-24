package com.pomplatform.db.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseAttendanceRuleTime extends GenericBase implements BaseFactory<BaseAttendanceRuleTime>, Comparable<BaseAttendanceRuleTime> 
{


	public static BaseAttendanceRuleTime newInstance(){
		return new BaseAttendanceRuleTime();
	}

	@Override
	public BaseAttendanceRuleTime make(){
		BaseAttendanceRuleTime b = new BaseAttendanceRuleTime();
		return b;
	}

	public final static java.lang.String CS_ATTENDANCE_RULE_TIME_ID = "attendance_rule_time_id" ;
	public final static java.lang.String CS_ATTENDANCE_RULE_ID = "attendance_rule_id" ;
	public final static java.lang.String CS_FROM_TIME = "from_time" ;
	public final static java.lang.String CS_IS_CROSS_FROM = "is_cross_from" ;
	public final static java.lang.String CS_TO_TIME = "to_time" ;
	public final static java.lang.String CS_IS_CROSS_TO = "is_cross_to" ;
	public final static java.lang.String CS_MINUTES = "minutes" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,考勤规则主键id,从时间点开始,开始时间点是否跨天,到时间点结束,结束时间点是否跨天,分钟数";

	public java.lang.Integer getAttendanceRuleTimeId() {
		return this.__attendance_rule_time_id;
	}

	public void setAttendanceRuleTimeId( java.lang.Integer value ) {
		this.__attendance_rule_time_id = value;
	}

	public java.lang.Integer getAttendanceRuleId() {
		return this.__attendance_rule_id;
	}

	public void setAttendanceRuleId( java.lang.Integer value ) {
		this.__attendance_rule_id = value;
	}

	public java.lang.String getFromTime() {
		return this.__from_time;
	}

	public void setFromTime( java.lang.String value ) {
		this.__from_time = value;
	}

	public java.lang.Boolean getIsCrossFrom() {
		return this.__is_cross_from;
	}

	public void setIsCrossFrom( java.lang.Boolean value ) {
		this.__is_cross_from = value;
	}

	public java.lang.String getToTime() {
		return this.__to_time;
	}

	public void setToTime( java.lang.String value ) {
		this.__to_time = value;
	}

	public java.lang.Boolean getIsCrossTo() {
		return this.__is_cross_to;
	}

	public void setIsCrossTo( java.lang.Boolean value ) {
		this.__is_cross_to = value;
	}

	public java.lang.Integer getMinutes() {
		return this.__minutes;
	}

	public void setMinutes( java.lang.Integer value ) {
		this.__minutes = value;
	}

	public void cloneCopy(BaseAttendanceRuleTime __bean){
		__bean.setAttendanceRuleTimeId(getAttendanceRuleTimeId());
		__bean.setAttendanceRuleId(getAttendanceRuleId());
		__bean.setFromTime(getFromTime());
		__bean.setIsCrossFrom(getIsCrossFrom());
		__bean.setToTime(getToTime());
		__bean.setIsCrossTo(getIsCrossTo());
		__bean.setMinutes(getMinutes());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getAttendanceRuleTimeId() == null ? "" : getAttendanceRuleTimeId());
		sb.append(",");
		sb.append(getAttendanceRuleId() == null ? "" : getAttendanceRuleId());
		sb.append(",");
		sb.append(getFromTime() == null ? "" : getFromTime());
		sb.append(",");
		sb.append(getIsCrossFrom() == null ? "" : getIsCrossFrom());
		sb.append(",");
		sb.append(getToTime() == null ? "" : getToTime());
		sb.append(",");
		sb.append(getIsCrossTo() == null ? "" : getIsCrossTo());
		sb.append(",");
		sb.append(getMinutes() == null ? "" : getMinutes());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseAttendanceRuleTime o) {
		return __attendance_rule_time_id == null ? -1 : __attendance_rule_time_id.compareTo(o.getAttendanceRuleTimeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__attendance_rule_time_id);
		hash = 97 * hash + Objects.hashCode(this.__attendance_rule_id);
		hash = 97 * hash + Objects.hashCode(this.__from_time);
		hash = 97 * hash + Objects.hashCode(this.__is_cross_from);
		hash = 97 * hash + Objects.hashCode(this.__to_time);
		hash = 97 * hash + Objects.hashCode(this.__is_cross_to);
		hash = 97 * hash + Objects.hashCode(this.__minutes);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseAttendanceRuleTime o = (BaseAttendanceRuleTime)obj;
		if(!Objects.equals(this.__attendance_rule_time_id, o.getAttendanceRuleTimeId())) return false;
		if(!Objects.equals(this.__attendance_rule_id, o.getAttendanceRuleId())) return false;
		if(!Objects.equals(this.__from_time, o.getFromTime())) return false;
		if(!Objects.equals(this.__is_cross_from, o.getIsCrossFrom())) return false;
		if(!Objects.equals(this.__to_time, o.getToTime())) return false;
		if(!Objects.equals(this.__is_cross_to, o.getIsCrossTo())) return false;
		if(!Objects.equals(this.__minutes, o.getMinutes())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getAttendanceRuleTimeId() != null) sb.append(__wrapNumber(count++, "attendanceRuleTimeId", getAttendanceRuleTimeId()));
		if(getAttendanceRuleId() != null) sb.append(__wrapNumber(count++, "attendanceRuleId", getAttendanceRuleId()));
		if(getFromTime() != null) sb.append(__wrapString(count++, "fromTime", getFromTime()));
		if(getIsCrossFrom() != null) sb.append(__wrapBoolean(count++, "isCrossFrom", getIsCrossFrom()));
		if(getToTime() != null) sb.append(__wrapString(count++, "toTime", getToTime()));
		if(getIsCrossTo() != null) sb.append(__wrapBoolean(count++, "isCrossTo", getIsCrossTo()));
		if(getMinutes() != null) sb.append(__wrapNumber(count++, "minutes", getMinutes()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getAttendanceRuleTimeId() != null) res.put("attendanceRuleTimeId", getAttendanceRuleTimeId());
		if(getAttendanceRuleId() != null) res.put("attendanceRuleId", getAttendanceRuleId());
		if(getFromTime() != null) res.put("fromTime", getFromTime());
		if(getIsCrossFrom() != null) res.put("isCrossFrom", getIsCrossFrom());
		if(getToTime() != null) res.put("toTime", getToTime());
		if(getIsCrossTo() != null) res.put("isCrossTo", getIsCrossTo());
		if(getMinutes() != null) res.put("minutes", getMinutes());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("attendanceRuleTimeId")) != null) setAttendanceRuleTimeId(__getInt(val)); 
		if((val = values.get("attendanceRuleId")) != null) setAttendanceRuleId(__getInt(val)); 
		if((val = values.get("fromTime")) != null) setFromTime(__getString(val));
		if((val = values.get("isCrossFrom")) != null) setIsCrossFrom(__getBoolean(val));
		if((val = values.get("toTime")) != null) setToTime(__getString(val));
		if((val = values.get("isCrossTo")) != null) setIsCrossTo(__getBoolean(val));
		if((val = values.get("minutes")) != null) setMinutes(__getInt(val)); 
	}

	protected java.lang.Integer  __attendance_rule_time_id ;
	protected java.lang.Integer  __attendance_rule_id ;
	protected java.lang.String  __from_time ;
	protected java.lang.Boolean  __is_cross_from ;
	protected java.lang.String  __to_time ;
	protected java.lang.Boolean  __is_cross_to ;
	protected java.lang.Integer  __minutes ;
}
