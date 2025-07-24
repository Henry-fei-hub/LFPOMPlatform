package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSumSalaryAndInsuranceCost extends GenericCondition{

	public ConditionSumSalaryAndInsuranceCost(){
		setParameterCount(3);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getLastMonth() {
		return this.__last_month;
	}

	public void setLastMonth( java.lang.Integer value ) {
		this.__last_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getLastMonth() != null) sb.append(__wrapNumber(1, "lastMonth", getLastMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("lastMonth")) != null) setLastMonth(__getInt(val)); 
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __last_month = null;
}

