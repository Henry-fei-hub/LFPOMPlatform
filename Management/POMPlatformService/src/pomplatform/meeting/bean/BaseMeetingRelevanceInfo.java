package pomplatform.meeting.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseMeetingRelevanceInfo extends GenericBase implements BaseFactory<BaseMeetingRelevanceInfo>, Comparable<BaseMeetingRelevanceInfo>
{


	public static BaseMeetingRelevanceInfo newInstance(){
		return new BaseMeetingRelevanceInfo();
	}

	@Override
	public BaseMeetingRelevanceInfo make(){
		BaseMeetingRelevanceInfo b = new BaseMeetingRelevanceInfo();
		return b;
	}

	public final static String CS_MEETING_RELEVANCE_ID = "meeting_relevance_id" ;
	public final static String CS_MEETING_ROOM_NAME = "meeting_room_name" ;
	public final static String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_MEETING_ROOM_TIME = "meeting_room_time" ;
	public final static String CS_RECORD_DATE = "record_date" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_MEETING_THEME = "meeting_theme" ;
	public final static String CS_START_TIME = "start_time" ;
	public final static String CS_END_TIME = "end_time" ;
	public final static String CS_MEETING_STATUS = "meeting_status" ;
	public final static String CS_WEEK_TIME = "week_time" ;
	public final static String CS_HOW_MANY_WEEKS = "how_many_weeks" ;
	public final static String CS_MEETING_INFO = "meeting_info" ;
	public final static String CS_MEETING_TIME = "meeting_time" ;

	public final static String ALL_CAPTIONS = "主键,会议室名称,会议室编码,预约人编码,时间区间,创建日期,状态 ( 0未预约，1已预约，2使用中，3已作废 ,4已完成),会议室主题,开始时间,结束时间,会议记录的类型（1普通会议  2周例会  3月例会 ),周例会时间,选择的是第几周,会议室详情描述,会议时间";

	public Integer getMeetingRelevanceId() {
		return this.__meeting_relevance_id;
	}

	public void setMeetingRelevanceId( Integer value ) {
		this.__meeting_relevance_id = value;
	}

	public String getMeetingRoomName() {
		return this.__meeting_room_name;
	}

	public void setMeetingRoomName( String value ) {
		this.__meeting_room_name = value;
	}

	public Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( Integer value ) {
		this.__meeting_room_id = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public String getMeetingRoomTime() {
		return this.__meeting_room_time;
	}

	public void setMeetingRoomTime( String value ) {
		this.__meeting_room_time = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public Integer getStatus() {
		return this.__status;
	}

	public void setStatus( Integer value ) {
		this.__status = value;
	}

	public String getMeetingTheme() {
		return this.__meeting_theme;
	}

	public void setMeetingTheme( String value ) {
		this.__meeting_theme = value;
	}

	public Integer getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( Integer value ) {
		this.__start_time = value;
	}

	public Integer getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( Integer value ) {
		this.__end_time = value;
	}

	public Integer getMeetingStatus() {
		return this.__meeting_status;
	}

	public void setMeetingStatus( Integer value ) {
		this.__meeting_status = value;
	}

	public Integer getWeekTime() {
		return this.__week_time;
	}

	public void setWeekTime( Integer value ) {
		this.__week_time = value;
	}

	public Integer getHowManyWeeks() {
		return this.__how_many_weeks;
	}

	public void setHowManyWeeks( Integer value ) {
		this.__how_many_weeks = value;
	}

	public String getMeetingInfo() {
		return this.__meeting_info;
	}

	public void setMeetingInfo( String value ) {
		this.__meeting_info = value;
	}

	public java.util.Date getMeetingTime() {
		return this.__meeting_time;
	}

	public void setMeetingTime( java.util.Date value ) {
		this.__meeting_time = value;
	}

	public void cloneCopy(BaseMeetingRelevanceInfo __bean){
		__bean.setMeetingRelevanceId(getMeetingRelevanceId());
		__bean.setMeetingRoomName(getMeetingRoomName());
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setMeetingRoomTime(getMeetingRoomTime());
		__bean.setRecordDate(getRecordDate());
		__bean.setStatus(getStatus());
		__bean.setMeetingTheme(getMeetingTheme());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setMeetingStatus(getMeetingStatus());
		__bean.setWeekTime(getWeekTime());
		__bean.setHowManyWeeks(getHowManyWeeks());
		__bean.setMeetingInfo(getMeetingInfo());
		__bean.setMeetingTime(getMeetingTime());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRelevanceId() == null ? "" : getMeetingRelevanceId());
		sb.append(",");
		sb.append(getMeetingRoomName() == null ? "" : getMeetingRoomName());
		sb.append(",");
		sb.append(getMeetingRoomId() == null ? "" : getMeetingRoomId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getMeetingRoomTime() == null ? "" : getMeetingRoomTime());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getMeetingTheme() == null ? "" : getMeetingTheme());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : getStartTime());
		sb.append(",");
		sb.append(getEndTime() == null ? "" : getEndTime());
		sb.append(",");
		sb.append(getMeetingStatus() == null ? "" : getMeetingStatus());
		sb.append(",");
		sb.append(getWeekTime() == null ? "" : getWeekTime());
		sb.append(",");
		sb.append(getHowManyWeeks() == null ? "" : getHowManyWeeks());
		sb.append(",");
		sb.append(getMeetingInfo() == null ? "" : getMeetingInfo());
		sb.append(",");
		sb.append(getMeetingTime() == null ? "" : sdf.format(getMeetingTime()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingRelevanceInfo o) {
		return __meeting_relevance_id == null ? -1 : __meeting_relevance_id.compareTo(o.getMeetingRelevanceId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_relevance_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_name);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__meeting_theme);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__meeting_status);
		hash = 97 * hash + Objects.hashCode(this.__week_time);
		hash = 97 * hash + Objects.hashCode(this.__how_many_weeks);
		hash = 97 * hash + Objects.hashCode(this.__meeting_info);
		hash = 97 * hash + Objects.hashCode(this.__meeting_time);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingRelevanceInfo o = (BaseMeetingRelevanceInfo)obj;
		if(!Objects.equals(this.__meeting_relevance_id, o.getMeetingRelevanceId())) return false;
		if(!Objects.equals(this.__meeting_room_name, o.getMeetingRoomName())) return false;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__meeting_room_time, o.getMeetingRoomTime())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__meeting_theme, o.getMeetingTheme())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__meeting_status, o.getMeetingStatus())) return false;
		if(!Objects.equals(this.__week_time, o.getWeekTime())) return false;
		if(!Objects.equals(this.__how_many_weeks, o.getHowManyWeeks())) return false;
		if(!Objects.equals(this.__meeting_info, o.getMeetingInfo())) return false;
		if(!Objects.equals(this.__meeting_time, o.getMeetingTime())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRelevanceId() != null) sb.append(__wrapNumber(count++, "meetingRelevanceId", getMeetingRelevanceId()));
		if(getMeetingRoomName() != null) sb.append(__wrapString(count++, "meetingRoomName", getMeetingRoomName()));
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(count++, "meetingRoomId", getMeetingRoomId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getMeetingRoomTime() != null) sb.append(__wrapString(count++, "meetingRoomTime", getMeetingRoomTime()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getMeetingTheme() != null) sb.append(__wrapString(count++, "meetingTheme", getMeetingTheme()));
		if(getStartTime() != null) sb.append(__wrapNumber(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapNumber(count++, "endTime", getEndTime()));
		if(getMeetingStatus() != null) sb.append(__wrapNumber(count++, "meetingStatus", getMeetingStatus()));
		if(getWeekTime() != null) sb.append(__wrapNumber(count++, "weekTime", getWeekTime()));
		if(getHowManyWeeks() != null) sb.append(__wrapNumber(count++, "howManyWeeks", getHowManyWeeks()));
		if(getMeetingInfo() != null) sb.append(__wrapString(count++, "meetingInfo", getMeetingInfo()));
		if(getMeetingTime() != null) sb.append(__wrapDate(count++, "meetingTime", getMeetingTime()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRelevanceId() != null) res.put("meetingRelevanceId", getMeetingRelevanceId());
		if(getMeetingRoomName() != null) res.put("meetingRoomName", getMeetingRoomName());
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getMeetingRoomTime() != null) res.put("meetingRoomTime", getMeetingRoomTime());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getStatus() != null) res.put("status", getStatus());
		if(getMeetingTheme() != null) res.put("meetingTheme", getMeetingTheme());
		if(getStartTime() != null) res.put("startTime", getStartTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getMeetingStatus() != null) res.put("meetingStatus", getMeetingStatus());
		if(getWeekTime() != null) res.put("weekTime", getWeekTime());
		if(getHowManyWeeks() != null) res.put("howManyWeeks", getHowManyWeeks());
		if(getMeetingInfo() != null) res.put("meetingInfo", getMeetingInfo());
		if(getMeetingTime() != null) res.put("meetingTime", getMeetingTime());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRelevanceId")) != null) setMeetingRelevanceId(__getInt(val)); 
		if((val = values.get("meetingRoomName")) != null) setMeetingRoomName(__getString(val));
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("meetingRoomTime")) != null) setMeetingRoomTime(__getString(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("meetingTheme")) != null) setMeetingTheme(__getString(val));
		if((val = values.get("startTime")) != null) setStartTime(__getInt(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getInt(val)); 
		if((val = values.get("meetingStatus")) != null) setMeetingStatus(__getInt(val)); 
		if((val = values.get("weekTime")) != null) setWeekTime(__getInt(val)); 
		if((val = values.get("howManyWeeks")) != null) setHowManyWeeks(__getInt(val)); 
		if((val = values.get("meetingInfo")) != null) setMeetingInfo(__getString(val));
		if((val = values.get("meetingTime")) != null) setMeetingTime(__getDate(val)); 
	}

	protected Integer  __meeting_relevance_id ;
	protected String  __meeting_room_name ;
	protected Integer  __meeting_room_id ;
	protected Integer  __employee_id ;
	protected String  __meeting_room_time ;
	protected java.util.Date  __record_date ;
	protected Integer  __status ;
	protected String  __meeting_theme ;
	protected Integer  __start_time ;
	protected Integer  __end_time ;
	protected Integer  __meeting_status ;
	protected Integer  __week_time ;
	protected Integer  __how_many_weeks ;
	protected String  __meeting_info ;
	protected java.util.Date  __meeting_time ;
}
