package pomplatform.leavetype.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPersonalLeaveType extends GenericCondition{

	public ConditionPersonalLeaveType(){
		setParameterCount(2);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getAreaId() {
		return this.__area_id;
	}

	public void setAreaId( java.lang.Integer value ) {
		this.__area_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getAreaId() != null) sb.append(__wrapNumber(1, "areaId", getAreaId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("areaId")) != null) setAreaId(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __area_id = null;
}

