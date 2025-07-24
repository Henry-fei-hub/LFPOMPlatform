package pomplatform.meeting.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseMeetingInfoPaymentBase extends GenericBase implements BaseFactory<BaseMeetingInfoPaymentBase>, Comparable<BaseMeetingInfoPaymentBase>
{


	public static BaseMeetingInfoPaymentBase newInstance(){
		return new BaseMeetingInfoPaymentBase();
	}

	@Override
	public BaseMeetingInfoPaymentBase make(){
		BaseMeetingInfoPaymentBase b = new BaseMeetingInfoPaymentBase();
		return b;
	}

	public final static String CS_MEETING_RECORD_CHART_ID = "meeting_record_chart_id" ;
	public final static String CS_STATUS = "status" ;
	public final static String CS_MEETING_THEME = "meeting_theme" ;
	public final static String CS_START_TIME = "start_time" ;
	public final static String CS_END_TIME = "end_time" ;
	public final static String CS_START_TIMES = "start_times" ;
	public final static String CS_END_TIMES = "end_times" ;
	public final static String CS_MEETING_ROOM_NAME = "meeting_room_name" ;
	public final static String CS_SITE = "site" ;
	public final static String CS_CONTAIN_NUM = "contain_num" ;
	public final static String CS_MEETING_ROOM_MASTER = "meeting_room_master" ;
	public final static String CS_EMPLOYEE_ID = "employee_id" ;
	public final static String CS_MEETING_ROOM_TIME = "meeting_room_time" ;
	public final static String CS_MEETING_ROOM_ID = "meeting_room_id" ;
	public final static String CS_RECORD_DATE = "record_date" ;
	public final static String CS_MEETING_RELEVANCE_ID = "meeting_relevance_id" ;
	public final static String CS_MEETING_STATUS = "meeting_status" ;
	public final static String CS_MEETING_TIME = "meeting_time" ;
	public final static String CS_CONFREE_NAMES = "confree_names" ;

	public final static String ALL_CAPTIONS = "主键编码,状态 ( 0未预约，1已预约，2使用中，3已作废 ,4已完成),会议主题,开始时间,结束时间,开始时间区间int类型表示，在修改预约的时候需要,结束时间区间int类型表示，在修改预约的时候需要,会议室名称,位置,容纳人数,会议室负责人,预约人编码,时间区间,会议室编码,创建日期,关联id,会议记录的类型（1普通会议  2周例会  3月例会 ),会议时间,";

	public Integer getMeetingRecordChartId() {
		return this.__meeting_record_chart_id;
	}

	public void setMeetingRecordChartId( Integer value ) {
		this.__meeting_record_chart_id = value;
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

	public Integer getStartTimes() {
		return this.__start_times;
	}

	public void setStartTimes( Integer value ) {
		this.__start_times = value;
	}

	public Integer getEndTimes() {
		return this.__end_times;
	}

	public void setEndTimes( Integer value ) {
		this.__end_times = value;
	}

	public String getMeetingRoomName() {
		return this.__meeting_room_name;
	}

	public void setMeetingRoomName( String value ) {
		this.__meeting_room_name = value;
	}

	public String getSite() {
		return this.__site;
	}

	public void setSite( String value ) {
		this.__site = value;
	}

	public Integer getContainNum() {
		return this.__contain_num;
	}

	public void setContainNum( Integer value ) {
		this.__contain_num = value;
	}

	public String getMeetingRoomMaster() {
		return this.__meeting_room_master;
	}

	public void setMeetingRoomMaster( String value ) {
		this.__meeting_room_master = value;
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

	public Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( Integer value ) {
		this.__meeting_room_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public Integer getMeetingRelevanceId() {
		return this.__meeting_relevance_id;
	}

	public void setMeetingRelevanceId( Integer value ) {
		this.__meeting_relevance_id = value;
	}

	public Integer getMeetingStatus() {
		return this.__meeting_status;
	}

	public void setMeetingStatus( Integer value ) {
		this.__meeting_status = value;
	}

	public java.util.Date getMeetingTime() {
		return this.__meeting_time;
	}

	public void setMeetingTime( java.util.Date value ) {
		this.__meeting_time = value;
	}

	public String getConfreeNames() {
		return this.__confree_names;
	}

	public void setConfreeNames( String value ) {
		this.__confree_names = value;
	}

	public void cloneCopy(BaseMeetingInfoPaymentBase __bean){
		__bean.setMeetingRecordChartId(getMeetingRecordChartId());
		__bean.setStatus(getStatus());
		__bean.setMeetingTheme(getMeetingTheme());
		__bean.setStartTime(getStartTime());
		__bean.setEndTime(getEndTime());
		__bean.setStartTimes(getStartTimes());
		__bean.setEndTimes(getEndTimes());
		__bean.setMeetingRoomName(getMeetingRoomName());
		__bean.setSite(getSite());
		__bean.setContainNum(getContainNum());
		__bean.setMeetingRoomMaster(getMeetingRoomMaster());
		__bean.setEmployeeId(getEmployeeId());
		__bean.setMeetingRoomTime(getMeetingRoomTime());
		__bean.setMeetingRoomId(getMeetingRoomId());
		__bean.setRecordDate(getRecordDate());
		__bean.setMeetingRelevanceId(getMeetingRelevanceId());
		__bean.setMeetingStatus(getMeetingStatus());
		__bean.setMeetingTime(getMeetingTime());
		__bean.setConfreeNames(getConfreeNames());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getMeetingRecordChartId() == null ? "" : getMeetingRecordChartId());
		sb.append(",");
		sb.append(getStatus() == null ? "" : getStatus());
		sb.append(",");
		sb.append(getMeetingTheme() == null ? "" : getMeetingTheme());
		sb.append(",");
		sb.append(getStartTime() == null ? "" : sdf.format(getStartTime()));
		sb.append(",");
		sb.append(getEndTime() == null ? "" : sdf.format(getEndTime()));
		sb.append(",");
		sb.append(getStartTimes() == null ? "" : getStartTimes());
		sb.append(",");
		sb.append(getEndTimes() == null ? "" : getEndTimes());
		sb.append(",");
		sb.append(getMeetingRoomName() == null ? "" : getMeetingRoomName());
		sb.append(",");
		sb.append(getSite() == null ? "" : getSite());
		sb.append(",");
		sb.append(getContainNum() == null ? "" : getContainNum());
		sb.append(",");
		sb.append(getMeetingRoomMaster() == null ? "" : getMeetingRoomMaster());
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getMeetingRoomTime() == null ? "" : getMeetingRoomTime());
		sb.append(",");
		sb.append(getMeetingRoomId() == null ? "" : getMeetingRoomId());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getMeetingRelevanceId() == null ? "" : getMeetingRelevanceId());
		sb.append(",");
		sb.append(getMeetingStatus() == null ? "" : getMeetingStatus());
		sb.append(",");
		sb.append(getMeetingTime() == null ? "" : sdf.format(getMeetingTime()));
		sb.append(",");
		sb.append(getConfreeNames() == null ? "" : getConfreeNames());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMeetingInfoPaymentBase o) {
		return __meeting_record_chart_id == null ? -1 : __meeting_record_chart_id.compareTo(o.getMeetingRecordChartId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__meeting_record_chart_id);
		hash = 97 * hash + Objects.hashCode(this.__status);
		hash = 97 * hash + Objects.hashCode(this.__meeting_theme);
		hash = 97 * hash + Objects.hashCode(this.__start_time);
		hash = 97 * hash + Objects.hashCode(this.__end_time);
		hash = 97 * hash + Objects.hashCode(this.__start_times);
		hash = 97 * hash + Objects.hashCode(this.__end_times);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_name);
		hash = 97 * hash + Objects.hashCode(this.__site);
		hash = 97 * hash + Objects.hashCode(this.__contain_num);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_master);
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_time);
		hash = 97 * hash + Objects.hashCode(this.__meeting_room_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__meeting_relevance_id);
		hash = 97 * hash + Objects.hashCode(this.__meeting_status);
		hash = 97 * hash + Objects.hashCode(this.__meeting_time);
		hash = 97 * hash + Objects.hashCode(this.__confree_names);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMeetingInfoPaymentBase o = (BaseMeetingInfoPaymentBase)obj;
		if(!Objects.equals(this.__meeting_record_chart_id, o.getMeetingRecordChartId())) return false;
		if(!Objects.equals(this.__status, o.getStatus())) return false;
		if(!Objects.equals(this.__meeting_theme, o.getMeetingTheme())) return false;
		if(!Objects.equals(this.__start_time, o.getStartTime())) return false;
		if(!Objects.equals(this.__end_time, o.getEndTime())) return false;
		if(!Objects.equals(this.__start_times, o.getStartTimes())) return false;
		if(!Objects.equals(this.__end_times, o.getEndTimes())) return false;
		if(!Objects.equals(this.__meeting_room_name, o.getMeetingRoomName())) return false;
		if(!Objects.equals(this.__site, o.getSite())) return false;
		if(!Objects.equals(this.__contain_num, o.getContainNum())) return false;
		if(!Objects.equals(this.__meeting_room_master, o.getMeetingRoomMaster())) return false;
		if(!Objects.equals(this.__employee_id, o.getEmployeeId())) return false;
		if(!Objects.equals(this.__meeting_room_time, o.getMeetingRoomTime())) return false;
		if(!Objects.equals(this.__meeting_room_id, o.getMeetingRoomId())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__meeting_relevance_id, o.getMeetingRelevanceId())) return false;
		if(!Objects.equals(this.__meeting_status, o.getMeetingStatus())) return false;
		if(!Objects.equals(this.__meeting_time, o.getMeetingTime())) return false;
		if(!Objects.equals(this.__confree_names, o.getConfreeNames())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getMeetingRecordChartId() != null) sb.append(__wrapNumber(count++, "meetingRecordChartId", getMeetingRecordChartId()));
		if(getStatus() != null) sb.append(__wrapNumber(count++, "status", getStatus()));
		if(getMeetingTheme() != null) sb.append(__wrapString(count++, "meetingTheme", getMeetingTheme()));
		if(getStartTime() != null) sb.append(__wrapDate(count++, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(count++, "endTime", getEndTime()));
		if(getStartTimes() != null) sb.append(__wrapNumber(count++, "startTimes", getStartTimes()));
		if(getEndTimes() != null) sb.append(__wrapNumber(count++, "endTimes", getEndTimes()));
		if(getMeetingRoomName() != null) sb.append(__wrapString(count++, "meetingRoomName", getMeetingRoomName()));
		if(getSite() != null) sb.append(__wrapString(count++, "site", getSite()));
		if(getContainNum() != null) sb.append(__wrapNumber(count++, "containNum", getContainNum()));
		if(getMeetingRoomMaster() != null) sb.append(__wrapString(count++, "meetingRoomMaster", getMeetingRoomMaster()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if(getMeetingRoomTime() != null) sb.append(__wrapString(count++, "meetingRoomTime", getMeetingRoomTime()));
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(count++, "meetingRoomId", getMeetingRoomId()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getMeetingRelevanceId() != null) sb.append(__wrapNumber(count++, "meetingRelevanceId", getMeetingRelevanceId()));
		if(getMeetingStatus() != null) sb.append(__wrapNumber(count++, "meetingStatus", getMeetingStatus()));
		if(getMeetingTime() != null) sb.append(__wrapDate(count++, "meetingTime", getMeetingTime()));
		if(getConfreeNames() != null) sb.append(__wrapString(count++, "confreeNames", getConfreeNames()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getMeetingRecordChartId() != null) res.put("meetingRecordChartId", getMeetingRecordChartId());
		if(getStatus() != null) res.put("status", getStatus());
		if(getMeetingTheme() != null) res.put("meetingTheme", getMeetingTheme());
		if(getStartTime() != null) res.put("startTime", getStartTime());
		if(getEndTime() != null) res.put("endTime", getEndTime());
		if(getStartTimes() != null) res.put("startTimes", getStartTimes());
		if(getEndTimes() != null) res.put("endTimes", getEndTimes());
		if(getMeetingRoomName() != null) res.put("meetingRoomName", getMeetingRoomName());
		if(getSite() != null) res.put("site", getSite());
		if(getContainNum() != null) res.put("containNum", getContainNum());
		if(getMeetingRoomMaster() != null) res.put("meetingRoomMaster", getMeetingRoomMaster());
		if(getEmployeeId() != null) res.put("employeeId", getEmployeeId());
		if(getMeetingRoomTime() != null) res.put("meetingRoomTime", getMeetingRoomTime());
		if(getMeetingRoomId() != null) res.put("meetingRoomId", getMeetingRoomId());
		if(getRecordDate() != null) res.put("recordDate", getRecordDate());
		if(getMeetingRelevanceId() != null) res.put("meetingRelevanceId", getMeetingRelevanceId());
		if(getMeetingStatus() != null) res.put("meetingStatus", getMeetingStatus());
		if(getMeetingTime() != null) res.put("meetingTime", getMeetingTime());
		if(getConfreeNames() != null) res.put("confreeNames", getConfreeNames());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("meetingRecordChartId")) != null) setMeetingRecordChartId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("meetingTheme")) != null) setMeetingTheme(__getString(val));
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("startTimes")) != null) setStartTimes(__getInt(val)); 
		if((val = values.get("endTimes")) != null) setEndTimes(__getInt(val)); 
		if((val = values.get("meetingRoomName")) != null) setMeetingRoomName(__getString(val));
		if((val = values.get("site")) != null) setSite(__getString(val));
		if((val = values.get("containNum")) != null) setContainNum(__getInt(val)); 
		if((val = values.get("meetingRoomMaster")) != null) setMeetingRoomMaster(__getString(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("meetingRoomTime")) != null) setMeetingRoomTime(__getString(val));
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("meetingRelevanceId")) != null) setMeetingRelevanceId(__getInt(val)); 
		if((val = values.get("meetingStatus")) != null) setMeetingStatus(__getInt(val)); 
		if((val = values.get("meetingTime")) != null) setMeetingTime(__getDate(val)); 
		if((val = values.get("confreeNames")) != null) setConfreeNames(__getString(val));
	}

	protected Integer  __meeting_record_chart_id ;
	protected Integer  __status ;
	protected String  __meeting_theme ;
	protected java.util.Date  __start_time ;
	protected java.util.Date  __end_time ;
	protected Integer  __start_times ;
	protected Integer  __end_times ;
	protected String  __meeting_room_name ;
	protected String  __site ;
	protected Integer  __contain_num ;
	protected String  __meeting_room_master ;
	protected Integer  __employee_id ;
	protected String  __meeting_room_time ;
	protected Integer  __meeting_room_id ;
	protected java.util.Date  __record_date ;
	protected Integer  __meeting_relevance_id ;
	protected Integer  __meeting_status ;
	protected java.util.Date  __meeting_time ;
	protected String  __confree_names ;
}
