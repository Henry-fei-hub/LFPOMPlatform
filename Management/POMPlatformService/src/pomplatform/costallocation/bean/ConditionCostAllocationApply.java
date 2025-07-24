package pomplatform.costallocation.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCostAllocationApply extends GenericCondition{

	public ConditionCostAllocationApply(){
		setParameterCount(1);
	}

	public java.lang.Integer getResetCostId() {
		return this.__reset_cost_id;
	}

	public void setResetCostId( java.lang.Integer value ) {
		this.__reset_cost_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getResetCostId() != null) sb.append(__wrapNumber(1, "resetCostId", getResetCostId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("resetCostId")) != null) setResetCostId(__getInt(val)); 
	}

	private java.lang.Integer __reset_cost_id = null;
}

