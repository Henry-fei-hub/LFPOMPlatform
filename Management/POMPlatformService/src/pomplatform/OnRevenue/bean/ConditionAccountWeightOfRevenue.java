package pomplatform.OnRevenue.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionAccountWeightOfRevenue extends GenericCondition{

	public ConditionAccountWeightOfRevenue(){
		setParameterCount(1);
	}

	public java.lang.Integer getAccountWeightRecordId() {
		return this.__account_weight_record_id;
	}

	public void setAccountWeightRecordId( java.lang.Integer value ) {
		this.__account_weight_record_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getAccountWeightRecordId() != null) sb.append(__wrapNumber(1, "accountWeightRecordId", getAccountWeightRecordId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("accountWeightRecordId")) != null) setAccountWeightRecordId(__getInt(val)); 
	}

	private java.lang.Integer __account_weight_record_id = null;
}

