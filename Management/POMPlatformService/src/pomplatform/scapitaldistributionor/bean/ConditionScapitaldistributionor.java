package pomplatform.scapitaldistributionor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionScapitaldistributionor extends GenericCondition{

	public ConditionScapitaldistributionor(){
		setParameterCount(1);
	}

	public java.lang.Integer getCapitalDistributionId() {
		return this.__capital_distribution_id;
	}

	public void setCapitalDistributionId( java.lang.Integer value ) {
		this.__capital_distribution_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getCapitalDistributionId() != null) sb.append(__wrapNumber(1, "capitalDistributionId", getCapitalDistributionId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("capitalDistributionId")) != null) setCapitalDistributionId(__getInt(val)); 
	}

	private java.lang.Integer __capital_distribution_id = null;
}

