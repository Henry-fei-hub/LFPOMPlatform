package pomplatform.reimbursement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionCommonNormalRemarkAndAmount extends GenericCondition{

	public ConditionCommonNormalRemarkAndAmount(){
		setParameterCount(1);
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBusinessId() != null) sb.append(__wrapNumber(1, "businessId", getBusinessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val)); 
	}

	private java.lang.Integer __business_id = null;
}

