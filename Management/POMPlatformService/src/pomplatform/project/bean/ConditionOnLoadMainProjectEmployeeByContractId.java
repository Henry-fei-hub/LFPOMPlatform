package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadMainProjectEmployeeByContractId extends GenericCondition{

	public ConditionOnLoadMainProjectEmployeeByContractId(){
		setParameterCount(3);
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getRelation() {
		return this.__relation;
	}

	public void setRelation( java.lang.Integer value ) {
		this.__relation = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getRelation() != null) sb.append(__wrapNumber(1, "relation", getRelation()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("relation")) != null) setRelation(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getContractId() != null) res.add("contractId");
		if(getContractCode() != null) res.add("contractCode");
		if(getRelation() != null) res.add("relation");
		return res;
	}

	private java.lang.Integer __contract_id = null;
	private java.lang.String __contract_code = null;
	private java.lang.Integer __relation = null;
}

