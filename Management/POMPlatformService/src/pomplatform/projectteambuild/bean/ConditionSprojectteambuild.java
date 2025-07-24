package pomplatform.projectteambuild.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectteambuild extends GenericCondition{

	public ConditionSprojectteambuild(){
		setParameterCount(4);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(1, "designPhase", getDesignPhase()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, "projectLevel", getProjectLevel()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __design_phase = null;
	private java.lang.Integer __project_level = null;
}

