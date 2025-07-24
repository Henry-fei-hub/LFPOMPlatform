package pomplatform.shift.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionShiftmanageDetail extends GenericCondition{

	public ConditionShiftmanageDetail(){
		setParameterCount(1);
	}

	public java.lang.Integer getShiftManageId() {
		return this.__shift_manage_id;
	}

	public void setShiftManageId( java.lang.Integer value ) {
		this.__shift_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getShiftManageId() != null) sb.append(__wrapNumber(1, "shiftManageId", getShiftManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("shiftManageId")) != null) setShiftManageId(__getInt(val)); 
	}

	private java.lang.Integer __shift_manage_id = null;
}

