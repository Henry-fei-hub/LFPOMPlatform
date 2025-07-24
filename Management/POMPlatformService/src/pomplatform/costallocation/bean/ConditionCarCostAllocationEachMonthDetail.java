package pomplatform.costallocation.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCarCostAllocationEachMonthDetail extends GenericCondition{

	public ConditionCarCostAllocationEachMonthDetail(){
		setParameterCount(6);
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
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

	public java.lang.Integer getYear() {
		return __year;
	}

	public void setYear(java.lang.Integer year) {
		this.__year = year;
	}

	public java.lang.Integer getMonth() {
		return __month;
	}

	public void setMonth(java.lang.Integer month) {
		this.__month = month;
	}

	public java.lang.Integer getId() {
		return __id;
	}

	public void setId(java.lang.Integer id) {
		this.__id = id;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCostType() != null) sb.append(__wrapNumber(1, "costType", getCostType()));
		if(getStartTime() != null) sb.append(__wrapDate(1, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(1, "endTime", getEndTime()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getId() != null) sb.append(__wrapNumber(1, "id", getId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val));
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("id")) != null) setId(__getInt(val)); 
	}

	private java.lang.Integer __cost_type = null;
	private java.util.Date __start_time = null;
	private java.util.Date __end_time = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __id = null;
}

