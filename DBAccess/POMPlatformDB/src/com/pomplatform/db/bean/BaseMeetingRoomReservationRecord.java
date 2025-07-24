package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeetingRoomReservationRecord extends GenericBase implements BaseFactory<BaseMeetingRoomReservationRecord>, Comparable<BaseMeetingRoomReservationRecord> 
{


	public static BaseMeetingRoomReservationRecord newInstance(){
		return new BaseMeetingRoomReservationRecord();
	}

	@Override
	public BaseMeetingRoomReservationRecord make(){
		BaseMeetingRoomReservationRecord b = new BaseMeetingRoomReservationRecord();
		return b;
	}

	public final static java.lang.String CS_MEETING_ROOM_RESERVATION_RECORD_ID = "meeting_room_reservation_record_id" ;
	public final static java.lang.String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static java.lang.String CS_MEETING_ROOM_TIME_ID = "meeting_room_time_id" ;
	public final static java.lang.String CS_MEETING_ROOM_TIME = "meeting_room_time" ;
	public final static java.lang.String CS_MEETING_DATE = "meeting_date" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_STATUS = "status" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,会议室编码,时区编码,时间区间,日期,预约人编码,状态(0,已预约 1未预约  2禁止预约)";

	public java.lang.Integer getMeetingRoomReservationRecordId() {
		return this.__meeting_room_reservation_record_id;
	}

	public void setMeetingRoomReservationRecordId( java.lang.Integer value ) {
		this.__meeting_room_reservation_record_id = value;
	}

	public java.lang.Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( java.lang.Integer value ) {
		this.__meeting_room_id = value;
	}

	public java.lang.Integer getMeetingRoomTimeId() {
		return this.__meeting_room_time_id;
	}

	public void setMeetingRoomTimeId( java.lang.Integer value ) {
		this.__meeting_room_time_id = value;
	}

	public java.lang.String getMeetingRoomTime() {
		return this.__meeting_room_time;
	}

	public void setMeetingRoomTime( java.lang.String value ) {
		this.__meeting_room_time = value;
	}

	public java.util.Date getMeetingDate() {
		return this.__meeting_date;
	}

	public void setMeetingDate( java.util.Date value ) {
		this.__meeting_date = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public void cloneCopy(BaseMeetingRoomReservationRecord __bean){
		__bean.setMeetingRoomReservationRecordId(getMeetingRoomReservationRecordId());
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setMeetingRoomTimeId(getMeetingRoomTimeId());
		__bean.setMeetingRoomTime(getMeetingRoomTime());
		__bean.setMeetingDate(getMeetingDate());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setStatus(getStatus());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRoomReservationRecordId() == null ? "" : getMeetingRoomReservationRecordId());
		sb.append(",");
		sb.append(getMeetingRoomId() == null ? "" : getMeetingRoomId());
		sb.append(",");
		sb.append(getMeetingRoomTimeId() == null ? "" : getMeetingRoomTimeId());
		sb.append(",");
		sb.append(getMeetingRoomTime() == null ? "" : getMeetingRoomTime());
		sb.append(",");
		sb.append(getMeetingDate() == null ? "" : sdf.format(getMeetingDate()));
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingRoomReservationRecord o) {
		return __meeting_room_reservation_record_id == null ? -1 : __meeting_room_reservation_record_id.compareTo(o.getMeetingRoomReservationRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_reservation_record_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time);
		hash = 97 * hash + Objects.hashCode(this.__meeting_date);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingRoomReservationRecord o = (BaseMeetingRoomReservationRecord)obj;
		if(!Objects.equals(this.__meeting_room_reservation_record_id, o.getMeetingRoomReservationRecordId())) return false;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__meeting_room_time_id, o.getMeetingRoomTimeId())) return false;
		if(!Objects.equals(this.__meeting_room_time, o.getMeetingRoomTime())) return false;
		if(!Objects.equals(this.__meeting_date, o.getMeetingDate())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRoomReservationRecordId() != null) sb.append(__wrapNumber(count++, "meetingRoomReservationRecordId", getMeetingRoomReservationRecordId()));
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(count++, "meetingRoomId", getMeetingRoomId()));
		if(getMeetingRoomTimeId() != null) sb.append(__wrapNumber(count++, "meetingRoomTimeId", getMeetingRoomTimeId()));
		if(getMeetingRoomTime() != null) sb.append(__wrapString(count++, "meetingRoomTime", getMeetingRoomTime()));
		if(getMeetingDate() != null) sb.append(__wrapDate(count++, "meetingDate", getMeetingDate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRoomReservationRecordId() != null) res.put("meetingRoomReservationRecordId", getMeetingRoomReservationRecordId());
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getMeetingRoomTimeId() != null) res.put("meetingRoomTimeId", getMeetingRoomTimeId());
		if(getMeetingRoomTime() != null) res.put("meetingRoomTime", getMeetingRoomTime());
		if(getMeetingDate() != null) res.put("meetingDate", getMeetingDate());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getStatus() != null) res.put("status", getStatus());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRoomReservationRecordId")) != null) setMeetingRoomReservationRecordId(__getInt(val)); 
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val)); 
		if((val = values.get("meetingRoomTimeId")) != null) setMeetingRoomTimeId(__getInt(val)); 
		if((val = values.get("meetingRoomTime")) != null) setMeetingRoomTime(__getString(val));
		if((val = values.get("meetingDate")) != null) setMeetingDate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
	}

	protected java.lang.Integer  __meeting_room_reservation_record_id ;
	protected java.lang.Integer  __meeting_room_id ;
	protected java.lang.Integer  __meeting_room_time_id ;
	protected java.lang.String  __meeting_room_time ;
	protected java.util.Date  __meeting_date ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __status ;
}
