package pomplatform.funciton.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionGetDepartmentIdByEmployeeIdAndFunctionCode extends GenericCondition{

	public ConditionGetDepartmentIdByEmployeeIdAndFunctionCode(){
		setParameterCount(3);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getFunctionCode() {
		return this.__function_code;
	}

	public void setFunctionCode( java.lang.String value ) {
		this.__function_code = value;
	}

	public java.lang.Integer getApplicationId() {
		return __application_id;
	}

	public void setApplicationId(java.lang.Integer __application_id) {
		this.__application_id = __application_id;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getFunctionCode() != null) sb.append(__wrapString(1, "functionCode", getFunctionCode()));
		if(getApplicationId() != null) sb.append(__wrapNumber(1, "applicationId", getApplicationId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("functionCode")) != null) setFunctionCode(__getString(val));
		if((val = values.get("applicationId")) != null) setApplicationId(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.String __function_code = null;
	private java.lang.Integer __application_id = null;
}

