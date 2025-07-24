package pomplatform.projectprogress.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectprogrespppor extends GenericCondition{

	public ConditionSprojectprogrespppor(){
		setParameterCount(4);
	}

	public java.lang.Integer getProjectProgressId() {
		return this.__project_progress_id;
	}

	public void setProjectProgressId( java.lang.Integer value ) {
		this.__project_progress_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectProgressId() != null) sb.append(__wrapNumber(1, "projectProgressId", getProjectProgressId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(1, "designPhase", getDesignPhase()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectProgressId")) != null) setProjectProgressId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
	}

	private java.lang.Integer __project_progress_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __project_manage_id = null;
	private java.lang.Integer __design_phase = null;
}

