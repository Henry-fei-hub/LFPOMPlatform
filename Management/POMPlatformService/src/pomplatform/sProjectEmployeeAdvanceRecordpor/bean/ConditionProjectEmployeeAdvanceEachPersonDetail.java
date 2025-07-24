package pomplatform.sProjectEmployeeAdvanceRecordpor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionProjectEmployeeAdvanceEachPersonDetail extends GenericCondition{

	public ConditionProjectEmployeeAdvanceEachPersonDetail(){
		setParameterCount(2);
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
	}

	private java.lang.Integer __project_id = null;
	private java.lang.Integer __employee_id = null;
}

