package pomplatform.orderplacement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOrderPlacement extends GenericCondition{

	public ConditionOrderPlacement(){
		setParameterCount(1);
	}

	public java.lang.Integer getOrderInfoId() {
		return this.__order_info_id;
	}

	public void setOrderInfoId( java.lang.Integer value ) {
		this.__order_info_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getOrderInfoId() != null) sb.append(__wrapNumber(1, "orderInfoId", getOrderInfoId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("orderInfoId")) != null) setOrderInfoId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getOrderInfoId() != null) res.add("orderInfoId");
		return res;
	}

	private java.lang.Integer __order_info_id = null;
}

