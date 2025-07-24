package pomplatform.templet.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOutTemplet extends GenericCondition{

	public ConditionOutTemplet(){
		setParameterCount(1);
	}

	public java.lang.Integer getBusinessType() {
		return this.__business_type;
	}

	public void setBusinessType( java.lang.Integer value ) {
		this.__business_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getBusinessType() != null) sb.append(__wrapNumber(1, "businessType", getBusinessType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("businessType")) != null) setBusinessType(__getInt(val)); 
	}

	private java.lang.Integer __business_type = null;
}

