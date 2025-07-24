package pomplatform.projectintegraltransferrecord.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMprojectintegraltransferrecord extends GenericCondition{

	public ConditionMprojectintegraltransferrecord(){
		setParameterCount(4);
	}

	public java.lang.Integer getFromProjectId() {
		return this.__from_project_id;
	}

	public void setFromProjectId( java.lang.Integer value ) {
		this.__from_project_id = value;
	}

	public java.lang.Integer getToProjectId() {
		return this.__to_project_id;
	}

	public void setToProjectId( java.lang.Integer value ) {
		this.__to_project_id = value;
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
		if(getFromProjectId() != null) sb.append(__wrapNumber(1, "fromProjectId", getFromProjectId()));
		if(getToProjectId() != null) sb.append(__wrapNumber(1, "toProjectId", getToProjectId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getPlateEmployeeId() != null) sb.append(__wrapNumber(1, "plateEmployeeId", getPlateEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("fromProjectId")) != null) setFromProjectId(__getInt(val)); 
		if((val = values.get("toProjectId")) != null) setToProjectId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateEmployeeId")) != null) setPlateEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __from_project_id = null;
	private java.lang.Integer __to_project_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __plate_employee_id = null;
}

