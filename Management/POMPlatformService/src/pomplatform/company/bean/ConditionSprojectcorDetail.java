package pomplatform.company.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectcorDetail extends GenericCondition{

	public ConditionSprojectcorDetail(){
		setParameterCount(1);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	private java.lang.Integer __contract_id = null;
}

