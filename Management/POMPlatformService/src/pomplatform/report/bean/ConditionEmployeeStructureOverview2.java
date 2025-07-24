package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionEmployeeStructureOverview2 extends GenericCondition{

	public ConditionEmployeeStructureOverview2(){
		setParameterCount(2);
	}

	public Integer getStartYear() {
		return this.__start_year;
	}

	public void setStartYear( Integer value ) {
		this.__start_year = value;
	}

	public Integer getEndYear() {
		return this.__end_year;
	}

	public void setEndYear( Integer value ) {
		this.__end_year = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartYear() != null) sb.append(__wrapNumber(1, "startYear", getStartYear()));
		if(getEndYear() != null) sb.append(__wrapNumber(1, "endYear", getEndYear()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startYear")) != null) setStartYear(__getInt(val)); 
		if((val = values.get("endYear")) != null) setEndYear(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getStartYear() != null) res.add("startYear");
		if(getEndYear() != null) res.add("endYear");
		return res;
	}

	private Integer __start_year = null;
	private Integer __end_year = null;
}

