package pomplatform.contract.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSumPlateContractDistribution extends GenericCondition{

	public ConditionSumPlateContractDistribution(){
		setParameterCount(3);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getBusinessType() {
		return __business_type;
	}

	public void setBusinessType(java.lang.Integer __business_type) {
		this.__business_type = __business_type;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __business_type = null;
}

