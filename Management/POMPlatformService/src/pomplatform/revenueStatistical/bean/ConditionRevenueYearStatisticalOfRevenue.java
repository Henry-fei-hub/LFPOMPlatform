package pomplatform.revenueStatistical.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionRevenueYearStatisticalOfRevenue extends GenericCondition{

	public ConditionRevenueYearStatisticalOfRevenue(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __year = null;
}

