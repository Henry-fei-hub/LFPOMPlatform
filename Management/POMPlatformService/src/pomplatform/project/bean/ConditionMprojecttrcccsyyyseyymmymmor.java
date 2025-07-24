package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMprojecttrcccsyyyseyymmymmor extends GenericCondition{

	public ConditionMprojecttrcccsyyyseyymmymmor(){
		setParameterCount(6);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
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

	public java.lang.String getYearStr() {
		return this.__year_str;
	}

	public void setYearStr( java.lang.String value ) {
		this.__year_str = value;
	}

	public java.lang.String getMonthStartStr() {
		return this.__month_start_str;
	}

	public void setMonthStartStr( java.lang.String value ) {
		this.__month_start_str = value;
	}

	public java.lang.String getMonthEndStr() {
		return this.__month_end_str;
	}

	public void setMonthEndStr( java.lang.String value ) {
		this.__month_end_str = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		if(getYearStr() != null) sb.append(__wrapString(1, "yearStr", getYearStr()));
		if(getMonthStartStr() != null) sb.append(__wrapString(1, "monthStartStr", getMonthStartStr()));
		if(getMonthEndStr() != null) sb.append(__wrapString(1, "monthEndStr", getMonthEndStr()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val)); 
		if((val = values.get("yearStr")) != null) setYearStr(__getString(val));
		if((val = values.get("monthStartStr")) != null) setMonthStartStr(__getString(val));
		if((val = values.get("monthEndStr")) != null) setMonthEndStr(__getString(val));
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __start_month = null;
	private java.lang.Integer __end_month = null;
	private java.lang.String __year_str = null;
	private java.lang.String __month_start_str = null;
	private java.lang.String __month_end_str = null;
}

