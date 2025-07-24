package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPerCapitaSalaryAnalysis extends GenericCondition{

	public ConditionPerCapitaSalaryAnalysis(){
		setParameterCount(10);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.util.Date getFirstStart() {
		return this.__first_start;
	}

	public void setFirstStart( java.util.Date value ) {
		this.__first_start = value;
	}

	public java.util.Date getFirstEnd() {
		return this.__first_end;
	}

	public void setFirstEnd( java.util.Date value ) {
		this.__first_end = value;
	}

	public java.util.Date getSecondStart() {
		return this.__second_start;
	}

	public void setSecondStart( java.util.Date value ) {
		this.__second_start = value;
	}

	public java.util.Date getSecondEnd() {
		return this.__second_end;
	}

	public void setSecondEnd( java.util.Date value ) {
		this.__second_end = value;
	}

	public java.util.Date getThirdStart() {
		return this.__third_start;
	}

	public void setThirdStart( java.util.Date value ) {
		this.__third_start = value;
	}

	public java.util.Date getThirdEnd() {
		return this.__third_end;
	}

	public void setThirdEnd( java.util.Date value ) {
		this.__third_end = value;
	}

	public java.util.Date getFourthStart() {
		return this.__fourth_start;
	}

	public void setFourthStart( java.util.Date value ) {
		this.__fourth_start = value;
	}

	public java.util.Date getFourthEnd() {
		return this.__fourth_end;
	}

	public void setFourthEnd( java.util.Date value ) {
		this.__fourth_end = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getFirstStart() != null) sb.append(__wrapDate(1, "firstStart", getFirstStart()));
		if(getFirstEnd() != null) sb.append(__wrapDate(1, "firstEnd", getFirstEnd()));
		if(getSecondStart() != null) sb.append(__wrapDate(1, "secondStart", getSecondStart()));
		if(getSecondEnd() != null) sb.append(__wrapDate(1, "secondEnd", getSecondEnd()));
		if(getThirdStart() != null) sb.append(__wrapDate(1, "thirdStart", getThirdStart()));
		if(getThirdEnd() != null) sb.append(__wrapDate(1, "thirdEnd", getThirdEnd()));
		if(getFourthStart() != null) sb.append(__wrapDate(1, "fourthStart", getFourthStart()));
		if(getFourthEnd() != null) sb.append(__wrapDate(1, "fourthEnd", getFourthEnd()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("firstStart")) != null) setFirstStart(__getDate(val)); 
		if((val = values.get("firstEnd")) != null) setFirstEnd(__getDate(val)); 
		if((val = values.get("secondStart")) != null) setSecondStart(__getDate(val)); 
		if((val = values.get("secondEnd")) != null) setSecondEnd(__getDate(val)); 
		if((val = values.get("thirdStart")) != null) setThirdStart(__getDate(val)); 
		if((val = values.get("thirdEnd")) != null) setThirdEnd(__getDate(val)); 
		if((val = values.get("fourthStart")) != null) setFourthStart(__getDate(val)); 
		if((val = values.get("fourthEnd")) != null) setFourthEnd(__getDate(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __year = null;
	private java.util.Date __first_start = null;
	private java.util.Date __first_end = null;
	private java.util.Date __second_start = null;
	private java.util.Date __second_end = null;
	private java.util.Date __third_start = null;
	private java.util.Date __third_end = null;
	private java.util.Date __fourth_start = null;
	private java.util.Date __fourth_end = null;
}

