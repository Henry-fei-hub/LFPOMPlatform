package pomplatform.sealKeepers.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionRankMaintenance extends GenericCondition{

	public ConditionRankMaintenance(){
		setParameterCount(1);
	}

	public java.lang.Integer getDicTypeValueId() {
		return this.__dic_type_value_id;
	}

	public void setDicTypeValueId( java.lang.Integer value ) {
		this.__dic_type_value_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDicTypeValueId() != null) sb.append(__wrapNumber(1, "dicTypeValueId", getDicTypeValueId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("dicTypeValueId")) != null) setDicTypeValueId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getDicTypeValueId() != null) res.add("dicTypeValueId");
		return res;
	}

	private java.lang.Integer __dic_type_value_id = null;
}

