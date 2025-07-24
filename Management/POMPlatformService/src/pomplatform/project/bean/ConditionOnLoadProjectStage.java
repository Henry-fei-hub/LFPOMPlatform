package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadProjectStage extends GenericCondition{

	public ConditionOnLoadProjectStage(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
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
		if(getCheckEmployeeId() != null) sb.append(__wrapNumber(1, "checkEmployeeId", getCheckEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("checkEmployeeId")) != null) setCheckEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __check_employee_id = null;
}

