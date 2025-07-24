package pomplatform.workflow.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetOvertimeApplyHours extends GenericCondition{

	public ConditionGetOvertimeApplyHours(){
		setParameterCount(3);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getStartTime() != null) sb.append(__wrapDate(1, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(1, "endTime", getEndTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.util.Date __start_time = null;
	private java.util.Date __end_time = null;
}

