package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionStargetrecordbytor extends GenericCondition{

	public ConditionStargetrecordbytor(){
		setParameterCount(3);
	}

	public java.lang.Integer getBusinessLine() {
		return this.__business_line;
	}

	public void setBusinessLine( java.lang.Integer value ) {
		this.__business_line = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBusinessLine() != null) sb.append(__wrapNumber(1, "businessLine", getBusinessLine()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("businessLine")) != null) setBusinessLine(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
	}

	private java.lang.Integer __business_line = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __type = null;
}

