package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionResignEmployeeEachMonth extends GenericCondition{

	public ConditionResignEmployeeEachMonth(){
		setParameterCount(4);
	}

	public Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( Integer value ) {
		this.__parent_id = value;
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

	public Double getYear() {
		return this.__year;
	}

	public void setYear( Double value ) {
		this.__year = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("year")) != null) setYear(__getDouble(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getParentId() != null) res.add("parentId");
		if(getStartDate() != null) res.add("startDate");
		if(getEndDate() != null) res.add("endDate");
		if(getYear() != null) res.add("year");
		return res;
	}

	private Integer __parent_id = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private Double __year = null;
}

