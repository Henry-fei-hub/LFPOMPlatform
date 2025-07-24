package pomplatform.workflow.personnelbusiness.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNetworkPrivileges extends GenericCondition{

	public ConditionNetworkPrivileges(){
		setParameterCount(1);
	}

	public java.lang.Integer getPersonnelBusinessId() {
		return this.__personnel_business_id;
	}

	public void setPersonnelBusinessId( java.lang.Integer value ) {
		this.__personnel_business_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPersonnelBusinessId() != null) sb.append(__wrapNumber(1, "personnelBusinessId", getPersonnelBusinessId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("personnelBusinessId")) != null) setPersonnelBusinessId(__getInt(val)); 
	}

	private java.lang.Integer __personnel_business_id = null;
}

