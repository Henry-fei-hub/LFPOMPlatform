package pomplatform.meeting.bean;

import delicacy.common.GenericCondition;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConditionMeetingInfoPaymentBase extends GenericCondition{

	public ConditionMeetingInfoPaymentBase(){
		setParameterCount(6);
	}

	public Double getYear() {
		return this.__year;
	}

	public void setYear( Double value ) {
		this.__year = value;
	}

	public Double getMonth() {
		return this.__month;
	}

	public void setMonth( Double value ) {
		this.__month = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( Integer value ) {
		this.__employee_id = value;
	}

	public Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( Integer value ) {
		this.__meeting_room_id = value;
	}

	public String getMeetingTheme() {
		return this.__meeting_theme;
	}

	public void setMeetingTheme( String value ) {
		this.__meeting_theme = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getRecordDate() != null) sb.append(__wrapDate(1, "recordDate", getRecordDate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(1, "meetingRoomId", getMeetingRoomId()));
		if(getMeetingTheme() != null) sb.append(__wrapString(1, "meetingTheme", getMeetingTheme()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getDouble(val)); 
		if((val = values.get("month")) != null) setMonth(__getDouble(val)); 
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val)); 
		if((val = values.get("meetingTheme")) != null) setMeetingTheme(__getString(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getYear() != null) res.add("year");
		if(getMonth() != null) res.add("month");
		if(getRecordDate() != null) res.add("recordDate");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getMeetingRoomId() != null) res.add("meetingRoomId");
		if(getMeetingTheme() != null) res.add("meetingTheme");
		return res;
	}

	private Double __year = null;
	private Double __month = null;
	private java.util.Date __record_date = null;
	private Integer __employee_id = null;
	private Integer __meeting_room_id = null;
	private String __meeting_theme = null;
}

