package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseShiftTimeManage extends GenericBase implements BaseFactory<BaseShiftTimeManage>, Comparable<BaseShiftTimeManage> 
{


	public static BaseShiftTimeManage newInstance(){
		return new BaseShiftTimeManage();
	}

	@Override
	public BaseShiftTimeManage make(){
		BaseShiftTimeManage b = new BaseShiftTimeManage();
		return b;
	}

	public final static java.lang.String CS_SHIFT_TIME_MANAGE_ID = "shift_time_manage_id" ;
	public final static java.lang.String CS_SHIFT_TIME_NAME = "shift_time_name" ;
	public final static java.lang.String CS_CHECK_SIGN_IN = "check_sign_in" ;
	public final static java.lang.String CS_SIGN_IN_TIME = "sign_in_time" ;
	public final static java.lang.String CS_CHECK_SIGN_OFF = "check_sign_off" ;
	public final static java.lang.String CS_SIGN_OFF_TIME = "sign_off_time" ;
	public final static java.lang.String CS_LATE_MINUTES = "late_minutes" ;
	public final static java.lang.String CS_LEAVE_EARLY_TIME = "leave_early_time" ;
	public final static java.lang.String CS_SIGN_IN_START_TIME = "sign_in_start_time" ;
	public final static java.lang.String CS_SIGN_IN_END_TIME = "sign_in_end_time" ;
	public final static java.lang.String CS_SIGN_OFF_START_TIME = "sign_off_start_time" ;
	public final static java.lang.String CS_SIGN_OFF_END_TIME = "sign_off_end_time" ;
	public final static java.lang.String CS_DAYS = "days" ;
	public final static java.lang.String CS_MINUTES = "minutes" ;
	public final static java.lang.String CS_OVERTIME_START_TIME = "overtime_start_time" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_UPDATE_TIME = "update_time" ;

	public final static java.lang.String ALL_CAPTIONS = "班次时段维护表编码,时段名称,是否需要签到,上班时间（格式如0900）,是否需要签退,下班时间（格式如0900）,计迟到时间（分钟）,计早退时间（分钟）,签到开始时间（格式如0900）,签到结束时间（格式如0900）,签退开始时间（格式如0900）,签退结束时间（格式如0900）,计多少工作日,计多少分钟,开始算加班时间（格式如2200）,创建时间,修改时间";

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

	public java.lang.Boolean getCheckSignIn() {
		return this.__check_sign_in;
	}

	public void setCheckSignIn( java.lang.Boolean value ) {
		this.__check_sign_in = value;
	}

	public java.lang.String getSignInTime() {
		return this.__sign_in_time;
	}

	public void setSignInTime( java.lang.String value ) {
		this.__sign_in_time = value;
	}

	public java.lang.Boolean getCheckSignOff() {
		return this.__check_sign_off;
	}

	public void setCheckSignOff( java.lang.Boolean value ) {
		this.__check_sign_off = value;
	}

	public java.lang.String getSignOffTime() {
		return this.__sign_off_time;
	}

	public void setSignOffTime( java.lang.String value ) {
		this.__sign_off_time = value;
	}

	public java.lang.Integer getLateMinutes() {
		return this.__late_minutes;
	}

	public void setLateMinutes( java.lang.Integer value ) {
		this.__late_minutes = value;
	}

	public java.lang.Integer getLeaveEarlyTime() {
		return this.__leave_early_time;
	}

	public void setLeaveEarlyTime( java.lang.Integer value ) {
		this.__leave_early_time = value;
	}

	public java.lang.String getSignInStartTime() {
		return this.__sign_in_start_time;
	}

	public void setSignInStartTime( java.lang.String value ) {
		this.__sign_in_start_time = value;
	}

	public java.lang.String getSignInEndTime() {
		return this.__sign_in_end_time;
	}

	public void setSignInEndTime( java.lang.String value ) {
		this.__sign_in_end_time = value;
	}

	public java.lang.String getSignOffStartTime() {
		return this.__sign_off_start_time;
	}

	public void setSignOffStartTime( java.lang.String value ) {
		this.__sign_off_start_time = value;
	}

	public java.lang.String getSignOffEndTime() {
		return this.__sign_off_end_time;
	}

	public void setSignOffEndTime( java.lang.String value ) {
		this.__sign_off_end_time = value;
	}

	public java.math.BigDecimal getDays() {
		return this.__days;
	}

	public void setDays( java.math.BigDecimal value ) {
		this.__days = value;
	}

	public java.lang.Integer getMinutes() {
		return this.__minutes;
	}

	public void setMinutes( java.lang.Integer value ) {
		this.__minutes = value;
	}

	public java.lang.String getOvertimeStartTime() {
		return this.__overtime_start_time;
	}

	public void setOvertimeStartTime( java.lang.String value ) {
		this.__overtime_start_time = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.util.Date getUpdateTime() {
		return this.__update_time;
	}

	public void setUpdateTime( java.util.Date value ) {
		this.__update_time = value;
	}

	public void cloneCopy(BaseShiftTimeManage __bean){
		__bean.setShiftTimeManageId(getShiftTimeManageId());
		__bean.setShiftTimeName(getShiftTimeName());
		__bean.setCheckSignIn(getCheckSignIn());
		__bean.setSignInTime(getSignInTime());
		__bean.setCheckSignOff(getCheckSignOff());
		__bean.setSignOffTime(getSignOffTime());
		__bean.setLateMinutes(getLateMinutes());
		__bean.setLeaveEarlyTime(getLeaveEarlyTime());
		__bean.setSignInStartTime(getSignInStartTime());
		__bean.setSignInEndTime(getSignInEndTime());
		__bean.setSignOffStartTime(getSignOffStartTime());
		__bean.setSignOffEndTime(getSignOffEndTime());
		__bean.setDays(getDays());
		__bean.setMinutes(getMinutes());
		__bean.setOvertimeStartTime(getOvertimeStartTime());
		__bean.setCreateTime(getCreateTime());
		__bean.setUpdateTime(getUpdateTime());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getShiftTimeManageId() == null ? "" : getShiftTimeManageId());
		sb.append(",");
		sb.append(getShiftTimeName() == null ? "" : getShiftTimeName());
		sb.append(",");
		sb.append(getCheckSignIn() == null ? "" : getCheckSignIn());
		sb.append(",");
		sb.append(getSignInTime() == null ? "" : getSignInTime());
		sb.append(",");
		sb.append(getCheckSignOff() == null ? "" : getCheckSignOff());
		sb.append(",");
		sb.append(getSignOffTime() == null ? "" : getSignOffTime());
		sb.append(",");
		sb.append(getLateMinutes() == null ? "" : getLateMinutes());
		sb.append(",");
		sb.append(getLeaveEarlyTime() == null ? "" : getLeaveEarlyTime());
		sb.append(",");
		sb.append(getSignInStartTime() == null ? "" : getSignInStartTime());
		sb.append(",");
		sb.append(getSignInEndTime() == null ? "" : getSignInEndTime());
		sb.append(",");
		sb.append(getSignOffStartTime() == null ? "" : getSignOffStartTime());
		sb.append(",");
		sb.append(getSignOffEndTime() == null ? "" : getSignOffEndTime());
		sb.append(",");
		sb.append(getDays() == null ? "" : getDays());
		sb.append(",");
		sb.append(getMinutes() == null ? "" : getMinutes());
		sb.append(",");
		sb.append(getOvertimeStartTime() == null ? "" : getOvertimeStartTime());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getUpdateTime() == null ? "" : sdf.format(getUpdateTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseShiftTimeManage o) {
		return __shift_time_manage_id == null ? -1 : __shift_time_manage_id.compareTo(o.getShiftTimeManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__shift_time_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__shift_time_name);
		hash = 97 * hash + Objects.hashCode(this.__check_sign_in);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_time);
		hash = 97 * hash + Objects.hashCode(this.__check_sign_off);
		hash = 97 * hash + Objects.hashCode(this.__sign_off_time);
		hash = 97 * hash + Objects.hashCode(this.__late_minutes);
		hash = 97 * hash + Objects.hashCode(this.__leave_early_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_start_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_in_end_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_off_start_time);
		hash = 97 * hash + Objects.hashCode(this.__sign_off_end_time);
		hash = 97 * hash + Objects.hashCode(this.__days);
		hash = 97 * hash + Objects.hashCode(this.__minutes);
		hash = 97 * hash + Objects.hashCode(this.__overtime_start_time);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__update_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseShiftTimeManage o = (BaseShiftTimeManage)obj;
		if(!Objects.equals(this.__shift_time_manage_id, o.getShiftTimeManageId())) return false;
		if(!Objects.equals(this.__shift_time_name, o.getShiftTimeName())) return false;
		if(!Objects.equals(this.__check_sign_in, o.getCheckSignIn())) return false;
		if(!Objects.equals(this.__sign_in_time, o.getSignInTime())) return false;
		if(!Objects.equals(this.__check_sign_off, o.getCheckSignOff())) return false;
		if(!Objects.equals(this.__sign_off_time, o.getSignOffTime())) return false;
		if(!Objects.equals(this.__late_minutes, o.getLateMinutes())) return false;
		if(!Objects.equals(this.__leave_early_time, o.getLeaveEarlyTime())) return false;
		if(!Objects.equals(this.__sign_in_start_time, o.getSignInStartTime())) return false;
		if(!Objects.equals(this.__sign_in_end_time, o.getSignInEndTime())) return false;
		if(!Objects.equals(this.__sign_off_start_time, o.getSignOffStartTime())) return false;
		if(!Objects.equals(this.__sign_off_end_time, o.getSignOffEndTime())) return false;
		if(!Objects.equals(this.__days, o.getDays())) return false;
		if(!Objects.equals(this.__minutes, o.getMinutes())) return false;
		if(!Objects.equals(this.__overtime_start_time, o.getOvertimeStartTime())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__update_time, o.getUpdateTime())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getShiftTimeManageId() != null) sb.append(__wrapNumber(count++, "shiftTimeManageId", getShiftTimeManageId()));
		if(getShiftTimeName() != null) sb.append(__wrapString(count++, "shiftTimeName", getShiftTimeName()));
		if(getCheckSignIn() != null) sb.append(__wrapBoolean(count++, "checkSignIn", getCheckSignIn()));
		if(getSignInTime() != null) sb.append(__wrapString(count++, "signInTime", getSignInTime()));
		if(getCheckSignOff() != null) sb.append(__wrapBoolean(count++, "checkSignOff", getCheckSignOff()));
		if(getSignOffTime() != null) sb.append(__wrapString(count++, "signOffTime", getSignOffTime()));
		if(getLateMinutes() != null) sb.append(__wrapNumber(count++, "lateMinutes", getLateMinutes()));
		if(getLeaveEarlyTime() != null) sb.append(__wrapNumber(count++, "leaveEarlyTime", getLeaveEarlyTime()));
		if(getSignInStartTime() != null) sb.append(__wrapString(count++, "signInStartTime", getSignInStartTime()));
		if(getSignInEndTime() != null) sb.append(__wrapString(count++, "signInEndTime", getSignInEndTime()));
		if(getSignOffStartTime() != null) sb.append(__wrapString(count++, "signOffStartTime", getSignOffStartTime()));
		if(getSignOffEndTime() != null) sb.append(__wrapString(count++, "signOffEndTime", getSignOffEndTime()));
		if(getDays() != null) sb.append(__wrapDecimal(count++, "days", getDays()));
		if(getMinutes() != null) sb.append(__wrapNumber(count++, "minutes", getMinutes()));
		if(getOvertimeStartTime() != null) sb.append(__wrapString(count++, "overtimeStartTime", getOvertimeStartTime()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getUpdateTime() != null) sb.append(__wrapDate(count++, "updateTime", getUpdateTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("shiftTimeManageId")) != null) setShiftTimeManageId(__getInt(val)); 
		if((val = values.get("shiftTimeName")) != null) setShiftTimeName(__getString(val));
		if((val = values.get("checkSignIn")) != null) setCheckSignIn(__getBoolean(val));
		if((val = values.get("signInTime")) != null) setSignInTime(__getString(val));
		if((val = values.get("checkSignOff")) != null) setCheckSignOff(__getBoolean(val));
		if((val = values.get("signOffTime")) != null) setSignOffTime(__getString(val));
		if((val = values.get("lateMinutes")) != null) setLateMinutes(__getInt(val)); 
		if((val = values.get("leaveEarlyTime")) != null) setLeaveEarlyTime(__getInt(val)); 
		if((val = values.get("signInStartTime")) != null) setSignInStartTime(__getString(val));
		if((val = values.get("signInEndTime")) != null) setSignInEndTime(__getString(val));
		if((val = values.get("signOffStartTime")) != null) setSignOffStartTime(__getString(val));
		if((val = values.get("signOffEndTime")) != null) setSignOffEndTime(__getString(val));
		if((val = values.get("days")) != null) setDays(__getDecimal(val));  
		if((val = values.get("minutes")) != null) setMinutes(__getInt(val)); 
		if((val = values.get("overtimeStartTime")) != null) setOvertimeStartTime(__getString(val));
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("updateTime")) != null) setUpdateTime(__getDate(val)); 
	}

	protected java.lang.Integer  __shift_time_manage_id ;
	protected java.lang.String  __shift_time_name ;
	protected java.lang.Boolean  __check_sign_in ;
	protected java.lang.String  __sign_in_time ;
	protected java.lang.Boolean  __check_sign_off ;
	protected java.lang.String  __sign_off_time ;
	protected java.lang.Integer  __late_minutes ;
	protected java.lang.Integer  __leave_early_time ;
	protected java.lang.String  __sign_in_start_time ;
	protected java.lang.String  __sign_in_end_time ;
	protected java.lang.String  __sign_off_start_time ;
	protected java.lang.String  __sign_off_end_time ;
	protected java.math.BigDecimal  __days ;
	protected java.lang.Integer  __minutes ;
	protected java.lang.String  __overtime_start_time ;
	protected java.util.Date  __create_time ;
	protected java.util.Date  __update_time ;
}
