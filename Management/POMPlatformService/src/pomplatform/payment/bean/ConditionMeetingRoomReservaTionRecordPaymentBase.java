package pomplatform.payment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMeetingRoomReservaTionRecordPaymentBase extends GenericCondition{

	public ConditionMeetingRoomReservaTionRecordPaymentBase(){
		setParameterCount(3);
	}

	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}

	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	public java.lang.Integer getRoomId() {
		return this.__room_id;
	}

	public void setRoomId( java.lang.Integer value ) {
		this.__room_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getRoomId() != null) sb.append(__wrapNumber(1, "roomId", getRoomId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val));
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val));
		if((val = values.get("roomId")) != null) setRoomId(__getInt(val));
	}

	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __room_id = null;
}

