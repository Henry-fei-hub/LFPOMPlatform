package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadProjectOverview extends GenericCondition{

	public ConditionOnLoadProjectOverview(){
		setParameterCount(3);
	}

	public java.lang.Integer getSettlementStatus() {
		return this.__settlement_status;
	}

	public void setSettlementStatus( java.lang.Integer value ) {
		this.__settlement_status = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSettlementStatus() != null) sb.append(__wrapNumber(1, "settlementStatus", getSettlementStatus()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("settlementStatus")) != null) setSettlementStatus(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getSettlementStatus() != null) res.add("settlementStatus");
		if(getContractId() != null) res.add("contractId");
		if(getProjectId() != null) res.add("projectId");
		return res;
	}

	private java.lang.Integer __settlement_status = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __project_id = null;
}

