package pomplatform.workflow.operation.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID extends GenericCondition{

	public ConditionOnLoadApplyListOfCostAllocationSerchEmplyeeID(){
		setParameterCount(1);
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
	}

	private java.lang.Integer __process_type = null;
}

