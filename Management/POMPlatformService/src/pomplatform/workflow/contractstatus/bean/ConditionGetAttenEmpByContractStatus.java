package pomplatform.workflow.contractstatus.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionGetAttenEmpByContractStatus extends GenericCondition{

	public ConditionGetAttenEmpByContractStatus(){
		setParameterCount(4);
	}

	public java.lang.Integer getRoleId() {
		return this.__role_id;
	}

	public void setRoleId( java.lang.Integer value ) {
		this.__role_id = value;
	}

	public java.lang.Integer getContractSigningStatus() {
		return this.__contract_signing_status;
	}

	public void setContractSigningStatus( java.lang.Integer value ) {
		this.__contract_signing_status = value;
	}

	public java.util.Date getSendingDate() {
		return this.__sending_date;
	}

	public void setSendingDate( java.util.Date value ) {
		this.__sending_date = value;
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getRoleId() != null) sb.append(__wrapNumber(1, "roleId", getRoleId()));
		if(getContractSigningStatus() != null) sb.append(__wrapNumber(1, "contractSigningStatus", getContractSigningStatus()));
		if(getSendingDate() != null) sb.append(__wrapDate(1, "sendingDate", getSendingDate()));
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("roleId")) != null) setRoleId(__getInt(val)); 
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val)); 
		if((val = values.get("sendingDate")) != null) setSendingDate(__getDate(val)); 
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
	}

	private java.lang.Integer __role_id = null;
	private java.lang.Integer __contract_signing_status = null;
	private java.util.Date __sending_date = null;
	private java.lang.Integer __contract_status = null;
}

