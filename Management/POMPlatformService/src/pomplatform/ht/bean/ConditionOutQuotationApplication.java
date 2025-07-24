package pomplatform.ht.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOutQuotationApplication extends GenericCondition{

	public ConditionOutQuotationApplication(){
		setParameterCount(1);
	}

	public java.lang.Integer getOutQuotationId() {
		return this.__out_quotation_id;
	}

	public void setOutQuotationId( java.lang.Integer value ) {
		this.__out_quotation_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getOutQuotationId() != null) sb.append(__wrapNumber(1, "outQuotationId", getOutQuotationId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("outQuotationId")) != null) setOutQuotationId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getOutQuotationId() != null) res.add("outQuotationId");
		return res;
	}

	private java.lang.Integer __out_quotation_id = null;
}

