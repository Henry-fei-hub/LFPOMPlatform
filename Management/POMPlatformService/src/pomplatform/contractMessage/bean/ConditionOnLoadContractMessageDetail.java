package pomplatform.contractMessage.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadContractMessageDetail extends GenericCondition{

	public ConditionOnLoadContractMessageDetail(){
		setParameterCount(4);
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.Integer getContractMessageDetailId() {
		return this.__contract_message_detail_id;
	}

	public void setContractMessageDetailId( java.lang.Integer value ) {
		this.__contract_message_detail_id = value;
	}

	public java.lang.Integer getContractMessageId() {
		return this.__contract_message_id;
	}

	public void setContractMessageId( java.lang.Integer value ) {
		this.__contract_message_id = value;
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
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getContractMessageDetailId() != null) sb.append(__wrapNumber(1, "contractMessageDetailId", getContractMessageDetailId()));
		if(getContractMessageId() != null) sb.append(__wrapNumber(1, "contractMessageId", getContractMessageId()));
		if(getContractId() != null) sb.append(__wrapNumber(1, "contractId", getContractId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("contractMessageDetailId")) != null) setContractMessageDetailId(__getInt(val)); 
		if((val = values.get("contractMessageId")) != null) setContractMessageId(__getInt(val)); 
		if((val = values.get("contractId")) != null) setContractId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getRemark() != null) res.add("remark");
		if(getContractMessageDetailId() != null) res.add("contractMessageDetailId");
		if(getContractMessageId() != null) res.add("contractMessageId");
		if(getContractId() != null) res.add("contractId");
		return res;
	}

	private java.lang.String __remark = null;
	private java.lang.Integer __contract_message_detail_id = null;
	private java.lang.Integer __contract_message_id = null;
	private java.lang.Integer __contract_id = null;
}

