package pomplatform.workflow.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionUsedVacationLeave extends GenericCondition{

	public ConditionUsedVacationLeave(){
		setParameterCount(4);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getStartYear() {
		return this.__start_year;
	}

	public void setStartYear( java.lang.Integer value ) {
		this.__start_year = value;
	}

	public java.lang.Integer getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( java.lang.Integer value ) {
		this.__start_month = value;
	}

	public java.lang.Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.lang.Integer value ) {
		this.__end_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getStartYear() != null) sb.append(__wrapNumber(1, "startYear", getStartYear()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("startYear")) != null) setStartYear(__getInt(val)); 
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getEmployeeId() != null) res.add("employeeId");
		if(getStartYear() != null) res.add("startYear");
		if(getStartMonth() != null) res.add("startMonth");
		if(getEndMonth() != null) res.add("endMonth");
		return res;
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __start_year = null;
	private java.lang.Integer __start_month = null;
	private java.lang.Integer __end_month = null;
}

