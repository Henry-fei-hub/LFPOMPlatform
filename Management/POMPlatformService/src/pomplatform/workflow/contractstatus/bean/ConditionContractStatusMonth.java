package pomplatform.workflow.contractstatus.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionContractStatusMonth extends GenericCondition{

	public ConditionContractStatusMonth(){
		setParameterCount(4);
	}

	public java.lang.Integer getNewStatus() {
		return this.__new_status;
	}

	public void setNewStatus( java.lang.Integer value ) {
		this.__new_status = value;
	}

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.Integer getContractMonth() {
		return this.__contract_month;
	}

	public void setContractMonth( java.lang.Integer value ) {
		this.__contract_month = value;
	}

	public java.lang.Integer getProcessType() {
		return __process_type;
	}

	public void setProcessType(java.lang.Integer value) {
		this.__process_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getNewStatus() != null) sb.append(__wrapNumber(1, "newStatus", getNewStatus()));
		if(getRoleId() != null) sb.append(__wrapNumber(1, "roleId", getRoleId()));
		if(getContractMonth() != null) sb.append(__wrapNumber(1, "contractMonth", getContractMonth()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("newStatus")) != null) setNewStatus(__getInt(val)); 
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("contractMonth")) != null) setContractMonth(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
	}

	private java.lang.Integer __new_status = null;
	private java.lang.Integer __role_id = null;
	private java.lang.Integer __contract_month = null;
	private java.lang.Integer __process_type = null;
}

