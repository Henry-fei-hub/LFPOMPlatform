package delicacy.oa.bean;

import java.util.Map;

import delicacy.common.GenericCondition;

public class ConditionMclasstypecior extends GenericCondition{

	public ConditionMclasstypecior(){
		setParameterCount(1);
	}

	public java.lang.Long getId() {
		return this.__id;
	}

	public void setId( java.lang.Long value ) {
		this.__id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getId() != null) sb.append(__wrapNumber(1, "id", getId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("id")) != null) setId(__getLong(val)); 
	}

	private java.lang.Long __id = null;
}

