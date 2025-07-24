package pomplatform.subContractInfo.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSubContractInfo extends GenericCondition{

	public ConditionSubContractInfo(){
		setParameterCount(1);
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getParentId() != null) sb.append(__wrapNumber(1, "parentId", getParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
	}

	private java.lang.Integer __parent_id = null;
}

