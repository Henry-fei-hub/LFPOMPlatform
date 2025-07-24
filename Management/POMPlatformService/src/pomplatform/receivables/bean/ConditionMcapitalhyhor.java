package pomplatform.receivables.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcapitalhyhor extends GenericCondition{

	public ConditionMcapitalhyhor(){
		setParameterCount(2);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.util.Date getHappenDate() {
		return this.__happen_date;
	}

	public void setHappenDate( java.util.Date value ) {
		this.__happen_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getHappenDate() != null) sb.append(__wrapDate(1, "happenDate", getHappenDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("happenDate")) != null) setHappenDate(__getDate(val)); 
	}

	private java.lang.Integer __year = null;
	private java.util.Date __happen_date = null;
}

