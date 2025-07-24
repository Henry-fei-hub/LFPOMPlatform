package pomplatform.workflow.contractstatus.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionContractThatHaveCostInWorkflow extends GenericCondition{

	public ConditionContractThatHaveCostInWorkflow(){
		setParameterCount(4);
	}

	public java.lang.Integer getProcessTypeProjectNormal() {
		return this.__process_type_project_normal;
	}

	public void setProcessTypeProjectNormal( java.lang.Integer value ) {
		this.__process_type_project_normal = value;
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getContractId() {
		return this.__contract_id;
	}

	public void setContractId( java.lang.Integer value ) {
		this.__contract_id = value;
	}

	public java.lang.Integer getProcessTypeProjectTravel() {
		return this.__process_type_project_travel;
	}

	public void setProcessTypeProjectTravel( java.lang.Integer value ) {
		this.__process_type_project_travel = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProcessTypeProjectNormal() != null) sb.append(__wrapNumber(1, "processTypeProjectNormal", getProcessTypeProjectNormal()));
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		if(getProcessTypeProjectTravel() != null) sb.append(__wrapNumber(1, "processTypeProjectTravel", getProcessTypeProjectTravel()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("processTypeProjectNormal")) != null) setProcessTypeProjectNormal(__getInt(val)); 
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
		if((val = values.get("processTypeProjectTravel")) != null) setProcessTypeProjectTravel(__getInt(val)); 
	}

	private java.lang.Integer __process_type_project_normal = null;
	private java.lang.Integer __delete_flag = null;
	private java.lang.Integer __contract_id = null;
	private java.lang.Integer __process_type_project_travel = null;
}

