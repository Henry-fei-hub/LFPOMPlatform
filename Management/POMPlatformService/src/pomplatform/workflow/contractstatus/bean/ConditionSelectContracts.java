package pomplatform.workflow.contractstatus.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionSelectContracts extends GenericCondition{

	public ConditionSelectContracts(){
		setParameterCount(3);
	}

	public java.lang.Integer getContractStatus() {
		return this.__contract_status;
	}

	public void setContractStatus( java.lang.Integer value ) {
		this.__contract_status = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getContractStatus() != null) sb.append(__wrapNumber(1, "contractStatus", getContractStatus()));
		if(getContractSigningStatus() != null) sb.append(__wrapNumber(1, "contractSigningStatus", getContractSigningStatus()));
		if(getSendingDate() != null) sb.append(__wrapDate(1, "sendingDate", getSendingDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("contractStatus")) != null) setContractStatus(__getInt(val)); 
		if((val = values.get("contractSigningStatus")) != null) setContractSigningStatus(__getInt(val)); 
		if((val = values.get("sendingDate")) != null) setSendingDate(__getDate(val)); 
	}

	private java.lang.Integer __contract_status = null;
	private java.lang.Integer __contract_signing_status = null;
	private java.util.Date __sending_date = null;
}

