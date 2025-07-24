package pomplatform.meeting.bean;

import delicacy.common.GenericCondition;

import java.util.Map;

public class ConditionMeetingRoomManagement extends GenericCondition{

	public ConditionMeetingRoomManagement(){
		setParameterCount(4);
	}

	public String getMeetingRoomName() {
		return this.__meeting_room_name == null ? null : (this.__meeting_room_name.indexOf("%") >= 0 ? this.__meeting_room_name : "%"+this.__meeting_room_name+"%");
	}

	public void setMeetingRoomName( String value ) {
		this.__meeting_room_name = value;
	}

	public String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( String value ) {
		this.__remark = value;
	}

	public Integer getMeetingRoomId() {
		return this.__meeting_room_id;
	}

	public void setMeetingRoomId( Integer value ) {
		this.__meeting_room_id = value;
	}

	public Integer getCompanyRecordId() {
		return this.__company_record_id;
	}

	public void setCompanyRecordId( Integer value ) {
		this.__company_record_id = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMeetingRoomName() != null) sb.append(__wrapString(1, "meetingRoomName", getMeetingRoomName()));
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getMeetingRoomId() != null) sb.append(__wrapNumber(1, "meetingRoomId", getMeetingRoomId()));
		if(getCompanyRecordId() != null) sb.append(__wrapNumber(1, "companyRecordId", getCompanyRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("meetingRoomName")) != null) setMeetingRoomName(__getString(val));
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("meetingRoomId")) != null) setMeetingRoomId(__getInt(val));
		if((val = values.get("companyRecordId")) != null) setCompanyRecordId(__getInt(val));
	}

	private String __meeting_room_name = null;
	private String __remark = null;
	private Integer __meeting_room_id = null;
	private Integer __company_record_id = null;
}

