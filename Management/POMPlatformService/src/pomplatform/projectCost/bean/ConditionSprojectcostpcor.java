package pomplatform.projectCost.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectcostpcor extends GenericCondition{

	public ConditionSprojectcostpcor(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getCostType() {
		return this.__cost_type;
	}

	public void setCostType( java.lang.Integer value ) {
		this.__cost_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getCostType() != null) sb.append(__wrapNumber(1, "costType", getCostType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("costType")) != null) setCostType(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __cost_type = null;
}

