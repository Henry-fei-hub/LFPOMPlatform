package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadProjectStageSettlement2 extends GenericCondition{

	public ConditionOnLoadProjectStageSettlement2(){
		setParameterCount(3);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getStageId() {
		return this.__stage_id;
	}

	public void setStageId( java.lang.Integer value ) {
		this.__stage_id = value;
	}

	public java.lang.Integer getCheckEmployeeId() {
		return this.__check_employee_id;
	}

	public void setCheckEmployeeId( java.lang.Integer value ) {
		this.__check_employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getStageId() != null) sb.append(__wrapNumber(1, "stageId", getStageId()));
		if(getCheckEmployeeId() != null) sb.append(__wrapNumber(1, "checkEmployeeId", getCheckEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("stageId")) != null) setStageId(__getInt(val)); 
		if((val = values.get("checkEmployeeId")) != null) setCheckEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __stage_id = null;
	private java.lang.Integer __check_employee_id = null;
}

