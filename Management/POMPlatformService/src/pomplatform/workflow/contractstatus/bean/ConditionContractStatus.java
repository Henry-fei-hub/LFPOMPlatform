package pomplatform.workflow.contractstatus.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionContractStatus extends GenericCondition{

	public ConditionContractStatus(){
		setParameterCount(1);
	}

	public java.lang.Integer getContractLogId() {
		return this.__contract_log_id;
	}

	public void setContractLogId( java.lang.Integer value ) {
		this.__contract_log_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractLogId() != null) sb.append(__wrapNumber(1, "contractLogId", getContractLogId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractLogId")) != null) setContractLogId(__getInt(val)); 
	}

	private java.lang.Integer __contract_log_id = null;
}

