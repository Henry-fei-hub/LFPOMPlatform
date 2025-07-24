package pomplatform.contractchange.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionChangeProjectInfo extends GenericCondition{

	public ConditionChangeProjectInfo(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getFlag() != null) sb.append(__wrapNumber(1, "flag", getFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __flag = null;
}

