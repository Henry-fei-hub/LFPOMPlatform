package com.pomplatform.db.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMeeting extends GenericBase implements BaseFactory<BaseMeeting>, Comparable<BaseMeeting> 
{


	public static BaseMeeting newInstance(){
		return new BaseMeeting();
	}

	@Override
	public BaseMeeting make(){
		BaseMeeting b = new BaseMeeting();
		return b;
	}

	public final static java.lang.String CS_MEETING_RECORD_CHART_ID = "meeting_record_chart_id" ;
	public final static java.lang.String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id" ;
	public final static java.lang.String CS_STATUS = "status" ;
	public final static java.lang.String CS_MEETING_THEME = "meeting_theme" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_MEETING_ROOM_TIME_ID = "meeting_room_time_id" ;
	public final static java.lang.String CS_MEETING_ROOM_TIME = "meeting_room_time" ;
	public final static java.lang.String CS_MEETING_RELEVANCE_ID = "meeting_relevance_id" ;
	public final static java.lang.String CS_END_TIME_TWO = "end_time_two" ;
	public final static java.lang.String CS_MEETING_TIME = "meeting_time" ;
	public final static java.lang.String CS_MEETING_STATUS = "meeting_status" ;
	public final static java.lang.String CS_START_TIME = "start_time" ;
	public final static java.lang.String CS_END_TIME = "end_time" ;
	public final static java.lang.String CS_START_TIMES = "start_times" ;
	public final static java.lang.String CS_END_TIMES = "end_times" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,会议室编码,预约人编码,状态 ( 0未预约，1已预约，2使用中，3已作废 ,4已完成),会议主题,创建日期,时区编码,时间区间,关联id,一个区间段的时间(预留字段),会议时间,会议记录的类型（1普通会议  2周例会  3月例会 ),开始时间,结束时间,开始时间区间int类型表示，在修改预约的时候需要,结束时间区间int类型表示，在修改预约的时候需要";

	public java.lang.Integer getMeetingRecordChartId() {
		return this.__meeting_record_chart_id;
	}

	public void setMeetingRecordChartId( java.lang.Integer value ) {
		this.__meeting_record_chart_id = value;
	}

	public java.lang.Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( java.lang.Integer value ) {
		this.__meeting_room_id = value;
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

	public java.lang.String getMeetingTheme() {
		return this.__meeting_theme;
	}

	public void setMeetingTheme( java.lang.String value ) {
		this.__meeting_theme = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
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

	public java.lang.Integer getMeetingRelevanceId() {
		return this.__meeting_relevance_id;
	}

	public void setMeetingRelevanceId( java.lang.Integer value ) {
		this.__meeting_relevance_id = value;
	}

	public java.lang.Integer getEndTimeTwo() {
		return this.__end_time_two;
	}

	public void setEndTimeTwo( java.lang.Integer value ) {
		this.__end_time_two = value;
	}

	public java.util.Date getMeetingTime() {
		return this.__meeting_time;
	}

	public void setMeetingTime( java.util.Date value ) {
		this.__meeting_time = value;
	}

	public java.lang.Integer getMeetingStatus() {
		return this.__meeting_status;
	}

	public void setMeetingStatus( java.lang.Integer value ) {
		this.__meeting_status = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.lang.Integer getStartTimes() {
		return this.__start_times;
	}

	public void setStartTimes( java.lang.Integer value ) {
		this.__start_times = value;
	}

	public java.lang.Integer getEndTimes() {
		return this.__end_times;
	}

	public void setEndTimes( java.lang.Integer value ) {
		this.__end_times = value;
	}

	public void cloneCopy(BaseMeeting __bean){
		__bean.setMeetingRecordChartId(getMeetingRecordChartId());
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setStatus(getStatus());
		__bean.setMeetingTheme(getMeetingTheme());
		__bean.setRecordDate(getRecordDate());
		__bean.setMeetingRoomTimeId(getMeetingRoomTimeId());
		__bean.setMeetingRoomTime(getMeetingRoomTime());
		__bean.setMeetingRelevanceId(getMeetingRelevanceId());
		__bean.setEndTimeTwo(getEndTimeTwo());
		__bean.setMeetingTime(getMeetingTime());
		__bean.setMeetingStatus(getMeetingStatus());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setStartTimes(getStartTimes());
		__bean.setEndTimes(getEndTimes());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRecordChartId() == null ? "" : getMeetingRecordChartId());
		sb.append(",");
		sb.append(getMeetingRoomId() == null ? "" : getMeetingRoomId());
		sb.append(",");
		sb.append(getEmployeeId() == null ? "" : getEmployeeId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getMeetingTheme() == null ? "" : getMeetingTheme());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getMeetingRoomTimeId() == null ? "" : getMeetingRoomTimeId());
		sb.append(",");
		sb.append(getMeetingRoomTime() == null ? "" : getMeetingRoomTime());
		sb.append(",");
		sb.append(getMeetingRelevanceId() == null ? "" : getMeetingRelevanceId());
		sb.append(",");
		sb.append(getEndTimeTwo() == null ? "" : getEndTimeTwo());
		sb.append(",");
		sb.append(getMeetingTime() == null ? "" : sdf.format(getMeetingTime()));
		sb.append(",");
		sb.append(getMeetingStatus() == null ? "" : getMeetingStatus());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getStartTimes() == null ? "" : getStartTimes());
		sb.append(",");
		sb.append(getEndTimes() == null ? "" : getEndTimes());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeeting o) {
		return __meeting_record_chart_id == null ? -1 : __meeting_record_chart_id.compareTo(o.getMeetingRecordChartId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_record_chart_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__meeting_theme);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time);
		hash = 97 * hash + Objects.hashCode(this.__meeting_relevance_id);
		hash = 97 * hash + Objects.hashCode(this.__end_time_two);
		hash = 97 * hash + Objects.hashCode(this.__meeting_time);
		hash = 97 * hash + Objects.hashCode(this.__meeting_status);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__start_times);
		hash = 97 * hash + Objects.hashCode(this.__end_times);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeeting o = (BaseMeeting)obj;
		if(!Objects.equals(this.__meeting_record_chart_id, o.getMeetingRecordChartId())) return false;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__meeting_theme, o.getMeetingTheme())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__meeting_room_time_id, o.getMeetingRoomTimeId())) return false;
		if(!Objects.equals(this.__meeting_room_time, o.getMeetingRoomTime())) return false;
		if(!Objects.equals(this.__meeting_relevance_id, o.getMeetingRelevanceId())) return false;
		if(!Objects.equals(this.__end_time_two, o.getEndTimeTwo())) return false;
		if(!Objects.equals(this.__meeting_time, o.getMeetingTime())) return false;
		if(!Objects.equals(this.__meeting_status, o.getMeetingStatus())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__start_times, o.getStartTimes())) return false;
		if(!Objects.equals(this.__end_times, o.getEndTimes())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRecordChartId() != null) sb.append(__wrapNumber(count++, "meetingRecordChartId", getMeetingRecordChartId()));
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(count++, "meetingRoomId", getMeetingRoomId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getMeetingTheme() != null) sb.append(__wrapString(count++, "meetingTheme", getMeetingTheme()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getMeetingRoomTimeId() != null) sb.append(__wrapNumber(count++, "meetingRoomTimeId", getMeetingRoomTimeId()));
		if(getMeetingRoomTime() != null) sb.append(__wrapString(count++, "meetingRoomTime", getMeetingRoomTime()));
		if(getMeetingRelevanceId() != null) sb.append(__wrapNumber(count++, "meetingRelevanceId", getMeetingRelevanceId()));
		if(getEndTimeTwo() != null) sb.append(__wrapNumber(count++, "endTimeTwo", getEndTimeTwo()));
		if(getMeetingTime() != null) sb.append(__wrapDate(count++, "meetingTime", getMeetingTime()));
		if(getMeetingStatus() != null) sb.append(__wrapNumber(count++, "meetingStatus", getMeetingStatus()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getStartTimes() != null) sb.append(__wrapNumber(count++, "startTimes", getStartTimes()));
		if(getEndTimes() != null) sb.append(__wrapNumber(count++, "endTimes", getEndTimes()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRecordChartId() != null) res.put("meetingRecordChartId", getMeetingRecordChartId());
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getStatus() != null) res.put("status", getStatus());
		if(getMeetingTheme() != null) res.put("meetingTheme", getMeetingTheme());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getMeetingRoomTimeId() != null) res.put("meetingRoomTimeId", getMeetingRoomTimeId());
		if(getMeetingRoomTime() != null) res.put("meetingRoomTime", getMeetingRoomTime());
		if(getMeetingRelevanceId() != null) res.put("meetingRelevanceId", getMeetingRelevanceId());
		if(getEndTimeTwo() != null) res.put("endTimeTwo", getEndTimeTwo());
		if(getMeetingTime() != null) res.put("meetingTime", getMeetingTime());
		if(getMeetingStatus() != null) res.put("meetingStatus", getMeetingStatus());
		if(getStartTime() != null) res.put("startTime", getStartTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getStartTimes() != null) res.put("startTimes", getStartTimes());
		if(getEndTimes() != null) res.put("endTimes", getEndTimes());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRecordChartId")) != null) setMeetingRecordChartId(__getInt(val)); 
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("meetingTheme")) != null) setMeetingTheme(__getString(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("meetingRoomTimeId")) != null) setMeetingRoomTimeId(__getInt(val)); 
		if((val = values.get("meetingRoomTime")) != null) setMeetingRoomTime(__getString(val));
		if((val = values.get("meetingRelevanceId")) != null) setMeetingRelevanceId(__getInt(val)); 
		if((val = values.get("endTimeTwo")) != null) setEndTimeTwo(__getInt(val)); 
		if((val = values.get("meetingTime")) != null) setMeetingTime(__getDate(val)); 
		if((val = values.get("meetingStatus")) != null) setMeetingStatus(__getInt(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("startTimes")) != null) setStartTimes(__getInt(val)); 
		if((val = values.get("endTimes")) != null) setEndTimes(__getInt(val)); 
	}

	protected java.lang.Integer  __meeting_record_chart_id ;
	protected java.lang.Integer  __meeting_room_id ;
	protected java.lang.Integer  __employee_id ;
	protected java.lang.Integer  __status ;
	protected java.lang.String  __meeting_theme ;
	protected java.util.Date  __record_date ;
	protected java.lang.Integer  __meeting_room_time_id ;
	protected java.lang.String  __meeting_room_time ;
	protected java.lang.Integer  __meeting_relevance_id ;
	protected java.lang.Integer  __end_time_two ;
	protected java.util.Date  __meeting_time ;
	protected java.lang.Integer  __meeting_status ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected java.lang.Integer  __start_times ;
	protected java.lang.Integer  __end_times ;
}
