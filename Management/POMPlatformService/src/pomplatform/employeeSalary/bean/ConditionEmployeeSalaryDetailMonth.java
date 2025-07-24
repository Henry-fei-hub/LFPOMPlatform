package pomplatform.employeeSalary.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeeSalaryDetailMonth extends GenericCondition{

	public ConditionEmployeeSalaryDetailMonth(){
		setParameterCount(8);
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

	public java.lang.Integer getSameYearEndMonth() {
		return this.__same_year_end_month;
	}

	public void setSameYearEndMonth( java.lang.Integer value ) {
		this.__same_year_end_month = value;
	}

	public java.lang.Integer getBiggerStartYear() {
		return this.__bigger_start_year;
	}

	public void setBiggerStartYear( java.lang.Integer value ) {
		this.__bigger_start_year = value;
	}

	public java.lang.Integer getSmallerEndYear() {
		return this.__smaller_end_year;
	}

	public void setSmallerEndYear( java.lang.Integer value ) {
		this.__smaller_end_year = value;
	}

	public java.lang.Integer getEndYear() {
		return this.__end_year;
	}

	public void setEndYear( java.lang.Integer value ) {
		this.__end_year = value;
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
		if(getSameYearEndMonth() != null) sb.append(__wrapNumber(1, "sameYearEndMonth", getSameYearEndMonth()));
		if(getBiggerStartYear() != null) sb.append(__wrapNumber(1, "biggerStartYear", getBiggerStartYear()));
		if(getSmallerEndYear() != null) sb.append(__wrapNumber(1, "smallerEndYear", getSmallerEndYear()));
		if(getEndYear() != null) sb.append(__wrapNumber(1, "endYear", getEndYear()));
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
		if((val = values.get("sameYearEndMonth")) != null) setSameYearEndMonth(__getInt(val)); 
		if((val = values.get("biggerStartYear")) != null) setBiggerStartYear(__getInt(val)); 
		if((val = values.get("smallerEndYear")) != null) setSmallerEndYear(__getInt(val)); 
		if((val = values.get("endYear")) != null) setEndYear(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __start_year = null;
	private java.lang.Integer __start_month = null;
	private java.lang.Integer __same_year_end_month = null;
	private java.lang.Integer __bigger_start_year = null;
	private java.lang.Integer __smaller_end_year = null;
	private java.lang.Integer __end_year = null;
	private java.lang.Integer __end_month = null;
}

