package pomplatform.funciton.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionNotApplyPermissions extends GenericCondition{

	public ConditionNotApplyPermissions(){
		setParameterCount(3);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getApplicationId() {
		return this.__application_id;
	}

	public void setApplicationId( java.lang.Integer value ) {
		this.__application_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getApplicationId() != null) sb.append(__wrapNumber(1, "applicationId", getApplicationId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("applicationId")) != null) setApplicationId(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __application_id = null;
}

