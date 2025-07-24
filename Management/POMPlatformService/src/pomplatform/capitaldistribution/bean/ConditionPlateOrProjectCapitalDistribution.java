package pomplatform.capitaldistribution.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPlateOrProjectCapitalDistribution extends GenericCondition{

	public ConditionPlateOrProjectCapitalDistribution(){
		setParameterCount(2);
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getCapitalId() != null) sb.append(__wrapNumber(1, "capitalId", getCapitalId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
	}

	private java.lang.Integer __type = null;
	private java.lang.Integer __capital_id = null;
}

