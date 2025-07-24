package pomplatform.leavetype.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionLinkOfLeaveTypeAndArea extends GenericCondition{

	public ConditionLinkOfLeaveTypeAndArea(){
		setParameterCount(1);
	}

	public java.lang.Integer getLeaveTypeId() {
		return this.__leave_type_id;
	}

	public void setLeaveTypeId( java.lang.Integer value ) {
		this.__leave_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getLeaveTypeId() != null) sb.append(__wrapNumber(1, "leaveTypeId", getLeaveTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("leaveTypeId")) != null) setLeaveTypeId(__getInt(val)); 
	}

	private java.lang.Integer __leave_type_id = null;
}

