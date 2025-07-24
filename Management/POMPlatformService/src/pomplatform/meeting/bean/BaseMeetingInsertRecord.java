package pomplatform.meeting.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseMeetingInsertRecord extends GenericBase implements BaseFactory<BaseMeetingInsertRecord>, Comparable<BaseMeetingInsertRecord>
{


	public static BaseMeetingInsertRecord newInstance(){
		return new BaseMeetingInsertRecord();
	}

	@Override
	public BaseMeetingInsertRecord make(){
		BaseMeetingInsertRecord b = new BaseMeetingInsertRecord();
		return b;
	}

	public final static String CS_MEETING_RECORD_CHART_ID = "meeting_record_chart_id" ;
	public final static String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_START_TIME = "start_time" ;
	public final static String CS_END_TIME = "end_time" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_MEETING_THEME = "meeting_theme" ;
	public final static String CS_RECORD_DATE = "record_date" ;

	public final static String ALL_CAPTIONS = "主键编码,会议室编码,预约人id,开始时间,结束时间,状态 ( 默认0，确认开始1，已使用,2，已完成3 ),会议主题,操作日期";

	public Integer getMeetingRecordChartId() {
		return this.__meeting_record_chart_id;
	}

	public void setMeetingRecordChartId( Integer value ) {
		this.__meeting_record_chart_id = value;
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

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public void cloneCopy(BaseMeetingInsertRecord __bean){
		__bean.setMeetingRecordChartId(getMeetingRecordChartId());
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setStatus(getStatus());
		__bean.setMeetingTheme(getMeetingTheme());
		__bean.setRecordDate(getRecordDate());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRecordChartId() == null ? "" : getMeetingRecordChartId());
		sb.append(",");
		sb.append(getMeetingRoomId() == null ? "" : getMeetingRoomId());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getMeetingTheme() == null ? "" : getMeetingTheme());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingInsertRecord o) {
		return __meeting_record_chart_id == null ? -1 : __meeting_record_chart_id.compareTo(o.getMeetingRecordChartId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_record_chart_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__meeting_theme);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingInsertRecord o = (BaseMeetingInsertRecord)obj;
		if(!Objects.equals(this.__meeting_record_chart_id, o.getMeetingRecordChartId())) return false;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__meeting_theme, o.getMeetingTheme())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRecordChartId() != null) sb.append(__wrapNumber(count++, "meetingRecordChartId", getMeetingRecordChartId()));
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(count++, "meetingRoomId", getMeetingRoomId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getMeetingTheme() != null) sb.append(__wrapString(count++, "meetingTheme", getMeetingTheme()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRecordChartId() != null) res.put("meetingRecordChartId", getMeetingRecordChartId());
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getStartTime() != null) res.put("startTime", getStartTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getStatus() != null) res.put("status", getStatus());
		if(getMeetingTheme() != null) res.put("meetingTheme", getMeetingTheme());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRecordChartId")) != null) setMeetingRecordChartId(__getInt(val));
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val));
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val));
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val));
		if((val = values.get("status")) != null) setStatus(__getInt(val));
		if((val = values.get("meetingTheme")) != null) setMeetingTheme(__getString(val));
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val));
	}

	protected Integer  __meeting_record_chart_id ;
	protected Integer  __meeting_room_id ;
	protected Integer  __employee_id ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected Integer  __status ;
	protected String  __meeting_theme ;
	protected java.util.Date  __record_date ;
}
