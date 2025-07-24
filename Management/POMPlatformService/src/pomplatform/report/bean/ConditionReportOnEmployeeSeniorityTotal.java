package pomplatform.report.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionReportOnEmployeeSeniorityTotal extends GenericCondition{

	public ConditionReportOnEmployeeSeniorityTotal(){
		setParameterCount(2);
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getPalteId() {
		return this.__palte_id;
	}

	public void setPalteId( java.lang.Integer value ) {
		this.__palte_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getPalteId() != null) sb.append(__wrapNumber(1, "palteId", getPalteId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("palteId")) != null) setPalteId(__getInt(val)); 
	}

	private java.lang.Integer __year = null;
	private java.lang.Integer __palte_id = null;
}

