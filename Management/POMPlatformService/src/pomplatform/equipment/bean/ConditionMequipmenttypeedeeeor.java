package pomplatform.equipment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionMequipmenttypeedeeeor extends GenericCondition{

	public ConditionMequipmenttypeedeeeor(){
		setParameterCount(3);
	}

	public Integer getName() {
		return this.__name;
	}

	public void setName( Integer value ) {
		this.__name = value;
	}

	public Integer getType() {
		return this.__type;
	}

	public void setType( Integer value ) {
		this.__type = value;
	}

	public Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( Boolean value ) {
		this.__enabled = value;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getName() != null) sb.append(__wrapNumber(1, "name", getName()));
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getEnabled() != null) sb.append(__wrapBoolean(1, "enabled", getEnabled()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("name")) != null) setName(__getInt(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getName() != null) res.add("name");
		if(getType() != null) res.add("type");
		if(getEnabled() != null) res.add("enabled");
		return res;
	}

	private Integer __name = null;
	private Integer __type = null;
	private Boolean __enabled = null;
}

