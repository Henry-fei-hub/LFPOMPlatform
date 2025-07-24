package pomplatform.k3code.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSk3codetpor extends GenericCondition{

	public ConditionSk3codetpor(){
		setParameterCount(2);
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getDepartmentType() {
		return this.__department_type;
	}

	public void setDepartmentType( java.lang.Integer value ) {
		this.__department_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getType() != null) sb.append(__wrapNumber(1, "type", getType()));
		if(getDepartmentType() != null) sb.append(__wrapNumber(1, "departmentType", getDepartmentType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("departmentType")) != null) setDepartmentType(__getInt(val)); 
	}

	private java.lang.Integer __type = null;
	private java.lang.Integer __department_type = null;
}

