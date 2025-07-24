package pomplatform.projectEmployee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectemployeepdsor extends GenericCondition{

	public ConditionSprojectemployeepdsor(){
		setParameterCount(4);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}
	
	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(1, "designPhase", getDesignPhase()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getStageId() != null) sb.append(__wrapNumber(1, "stageId", getStageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __design_phase = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __stage_id = null;
}

