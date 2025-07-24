package pomplatform.projectSettlement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnLoadSettlementEmployees extends GenericCondition{

	public ConditionOnLoadSettlementEmployees(){
		setParameterCount(1);
	}

	public java.lang.Integer getSettlementId() {
		return this.__settlement_id;
	}

	public void setSettlementId( java.lang.Integer value ) {
		this.__settlement_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSettlementId() != null) sb.append(__wrapNumber(1, "settlementId", getSettlementId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("settlementId")) != null) setSettlementId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getSettlementId() != null) res.add("settlementId");
		return res;
	}

	private java.lang.Integer __settlement_id = null;
}

