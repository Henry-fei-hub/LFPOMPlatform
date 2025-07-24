package pomplatform.projectintegralchangerecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMprojectintegralchangerecord extends GenericCondition{

	public ConditionMprojectintegralchangerecord(){
		setParameterCount(3);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getPlateEmployeeId() {
		return this.__plate_employee_id;
	}

	public void setPlateEmployeeId( java.lang.Integer value ) {
		this.__plate_employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getPlateEmployeeId() != null) sb.append(__wrapNumber(1, "plateEmployeeId", getPlateEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateEmployeeId")) != null) setPlateEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __plate_employee_id = null;
}

