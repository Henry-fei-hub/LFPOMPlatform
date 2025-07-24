package pomplatform.meeting.bean;

import delicacy.common.GenericCondition;

import java.util.Map;

public class ConditionMeetingInsertRecord extends GenericCondition{

	public ConditionMeetingInsertRecord(){
		setParameterCount(3);
	}

	public Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( Integer value ) {
		this.__meeting_room_id = value;
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

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(1, "meetingRoomId", getMeetingRoomId()));
		if(getStartTime() != null) sb.append(__wrapDate(1, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(1, "endTime", getEndTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val));
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val));
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val));
	}

	private Integer __meeting_room_id = null;
	private java.util.Date __start_time = null;
	private java.util.Date __end_time = null;
}

