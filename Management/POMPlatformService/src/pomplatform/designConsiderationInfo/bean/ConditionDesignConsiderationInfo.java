package pomplatform.designConsiderationInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionDesignConsiderationInfo extends GenericCondition{

	public ConditionDesignConsiderationInfo(){
		setParameterCount(1);
	}

	public java.lang.Integer getSubContractId() {
		return this.__sub_contract_id;
	}

	public void setSubContractId( java.lang.Integer value ) {
		this.__sub_contract_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSubContractId() != null) sb.append(__wrapNumber(1, "subContractId", getSubContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("subContractId")) != null) setSubContractId(__getInt(val)); 
	}

	private java.lang.Integer __sub_contract_id = null;
}

