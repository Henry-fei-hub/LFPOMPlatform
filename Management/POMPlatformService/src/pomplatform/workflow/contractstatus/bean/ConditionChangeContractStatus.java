package pomplatform.workflow.contractstatus.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionChangeContractStatus extends GenericCondition{

	public ConditionChangeContractStatus(){
		setParameterCount(2);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
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
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __process_type = null;
}

