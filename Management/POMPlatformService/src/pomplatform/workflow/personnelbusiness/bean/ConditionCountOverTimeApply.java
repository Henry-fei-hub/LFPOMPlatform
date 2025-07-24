package pomplatform.workflow.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCountOverTimeApply extends GenericCondition{

	public ConditionCountOverTimeApply(){
		setParameterCount(2);
	}

	public java.util.Date getTime() {
		return this.__time;
	}

	public void setTime( java.util.Date value ) {
		this.__time = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTime() != null) sb.append(__wrapDate(1, "time", getTime()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("time")) != null) setTime(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.util.Date __time = null;
	private java.lang.Integer __employee_id = null;
}

