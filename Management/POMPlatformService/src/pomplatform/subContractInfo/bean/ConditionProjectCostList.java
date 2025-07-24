package pomplatform.subContractInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionProjectCostList extends GenericCondition{

	public ConditionProjectCostList(){
		setParameterCount(2);
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getCostType() != null) sb.append(__wrapNumber(1, "costType", getCostType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
	}

	private java.lang.Integer __status = null;
	private java.lang.Integer __cost_type = null;
}

