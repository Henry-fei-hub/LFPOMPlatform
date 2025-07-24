package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingTimer extends GenericBase implements BaseFactory<BaseMeetingTimer>, Comparable<BaseMeetingTimer> 
{


	public static BaseMeetingTimer newInstance(){
		return new BaseMeetingTimer();
	}

	@Override
	public BaseMeetingTimer make(){
		BaseMeetingTimer b = new BaseMeetingTimer();
		return b;
	}

	public final static java.lang.String CS_MEETING_TIMER_ID = "meeting_timer_id" ;
	public final static java.lang.String CS_MEETING_ROOM_TIME = "meeting_room_time" ;
	public final static java.lang.String CS_TIME_FLAG = "time_flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,时间段,flag标识";

	public java.lang.Integer getMeetingTimerId() {
		return this.__meeting_timer_id;
	}

	public void setMeetingTimerId( java.lang.Integer value ) {
		this.__meeting_timer_id = value;
	}

	public java.lang.String getMeetingRoomTime() {
		return this.__meeting_room_time;
	}

	public void setMeetingRoomTime( java.lang.String value ) {
		this.__meeting_room_time = value;
	}

	public java.lang.Integer getTimeFlag() {
		return this.__time_flag;
	}

	public void setTimeFlag( java.lang.Integer value ) {
		this.__time_flag = value;
	}

	public void cloneCopy(BaseMeetingTimer __bean){
		__bean.setMeetingTimerId(getMeetingTimerId());
		__bean.setMeetingRoomTime(getMeetingRoomTime());
		__bean.setTimeFlag(getTimeFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingTimerId() == null ? "" : getMeetingTimerId());
		sb.append(",");
		sb.append(getMeetingRoomTime() == null ? "" : getMeetingRoomTime());
		sb.append(",");
		sb.append(getTimeFlag() == null ? "" : getTimeFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingTimer o) {
		return __meeting_timer_id == null ? -1 : __meeting_timer_id.compareTo(o.getMeetingTimerId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_timer_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time);
		hash = 97 * hash + Objects.hashCode(this.__time_flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingTimer o = (BaseMeetingTimer)obj;
		if(!Objects.equals(this.__meeting_timer_id, o.getMeetingTimerId())) return false;
		if(!Objects.equals(this.__meeting_room_time, o.getMeetingRoomTime())) return false;
		if(!Objects.equals(this.__time_flag, o.getTimeFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingTimerId() != null) sb.append(__wrapNumber(count++, "meetingTimerId", getMeetingTimerId()));
		if(getMeetingRoomTime() != null) sb.append(__wrapString(count++, "meetingRoomTime", getMeetingRoomTime()));
		if(getTimeFlag() != null) sb.append(__wrapNumber(count++, "timeFlag", getTimeFlag()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingTimerId() != null) res.put("meetingTimerId", getMeetingTimerId());
		if(getMeetingRoomTime() != null) res.put("meetingRoomTime", getMeetingRoomTime());
		if(getTimeFlag() != null) res.put("timeFlag", getTimeFlag());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingTimerId")) != null) setMeetingTimerId(__getInt(val)); 
		if((val = values.get("meetingRoomTime")) != null) setMeetingRoomTime(__getString(val));
		if((val = values.get("timeFlag")) != null) setTimeFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __meeting_timer_id ;
	protected java.lang.String  __meeting_room_time ;
	protected java.lang.Integer  __time_flag ;
}
