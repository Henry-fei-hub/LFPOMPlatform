package pomplatform.trainingmanagement.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeeItegral extends GenericCondition{

	public ConditionEmployeeItegral(){
		setParameterCount(3);
	}

	public java.lang.Integer getSelectYear() {
		return this.__select_year;
	}

	public void setSelectYear( java.lang.Integer value ) {
		this.__select_year = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getSelectYear() != null) sb.append(__wrapNumber(1, "selectYear", getSelectYear()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("selectYear")) != null) setSelectYear(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __select_year = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
}

