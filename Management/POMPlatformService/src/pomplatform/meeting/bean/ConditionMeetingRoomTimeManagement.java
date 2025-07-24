package pomplatform.meeting.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMeetingRoomTimeManagement extends GenericCondition{

	public ConditionMeetingRoomTimeManagement(){
		setParameterCount(5);
	}

	public java.lang.String getMeetingRoomTime() {
		return this.__meeting_room_time == null ? null : (this.__meeting_room_time.indexOf("%") >= 0 ? this.__meeting_room_time : "%"+this.__meeting_room_time+"%");
	}

	public void setMeetingRoomTime( java.lang.String value ) {
		this.__meeting_room_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getMeetingRoomTimeId() {
		return this.__meeting_room_time_id;
	}

	public void setMeetingRoomTimeId( java.lang.Integer value ) {
		this.__meeting_room_time_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMeetingRoomTime() != null) sb.append(__wrapString(1, "meetingRoomTime", getMeetingRoomTime()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getMeetingRoomTimeId() != null) sb.append(__wrapNumber(1, "meetingRoomTimeId", getMeetingRoomTimeId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("meetingRoomTime")) != null) setMeetingRoomTime(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("meetingRoomTimeId")) != null) setMeetingRoomTimeId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
	}

	private java.lang.String __meeting_room_time = null;
	private java.lang.String __remark = null;
	private java.lang.Integer __meeting_room_time_id = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __delete_flag = null;
}

