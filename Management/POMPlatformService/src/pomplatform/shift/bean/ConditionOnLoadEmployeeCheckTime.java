package pomplatform.shift.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadEmployeeCheckTime extends GenericCondition{

	public ConditionOnLoadEmployeeCheckTime(){
		setParameterCount(4);
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
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
		if(getRecordDate() != null) sb.append(__wrapDate(1, "recordDate", getRecordDate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getStartTime() != null) sb.append(__wrapDate(1, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(1, "endTime", getEndTime()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getRecordDate() != null) res.add("recordDate");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getStartTime() != null) res.add("startTime");
		if(getEndTime() != null) res.add("endTime");
		return res;
	}

	private java.util.Date __record_date = null;
	private java.lang.Integer __employee_id = null;
	private java.util.Date __start_time = null;
	private java.util.Date __end_time = null;
}

