package pomplatform.mcapitalsubcontractscoor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcapitalsubcontractscoor extends GenericCondition{

	public ConditionMcapitalsubcontractscoor(){
		setParameterCount(2);
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCapitalId() != null) sb.append(__wrapNumber(1, "capitalId", getCapitalId()));
		if(getOperatorId() != null) sb.append(__wrapNumber(1, "operatorId", getOperatorId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
	}

	private java.lang.Integer __capital_id = null;
	private java.lang.Integer __operator_id = null;
}

