package pomplatform.mcapitalemployeeecceedor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMcapitalemployeeecceedor extends GenericCondition{

	public ConditionMcapitalemployeeecceedor(){
		setParameterCount(5);
	}

	public java.lang.Integer getCapitalEmployeeId() {
		return this.__capital_employee_id;
	}

	public void setCapitalEmployeeId( java.lang.Integer value ) {
		this.__capital_employee_id = value;
	}

	public java.lang.Integer getCapitalId() {
		return this.__capital_id;
	}

	public void setCapitalId( java.lang.Integer value ) {
		this.__capital_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
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
		if(getCapitalEmployeeId() != null) sb.append(__wrapNumber(1, "capitalEmployeeId", getCapitalEmployeeId()));
		if(getCapitalId() != null) sb.append(__wrapNumber(1, "capitalId", getCapitalId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("capitalEmployeeId")) != null) setCapitalEmployeeId(__getInt(val)); 
		if((val = values.get("capitalId")) != null) setCapitalId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __capital_employee_id = null;
	private java.lang.Integer __capital_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __department_id = null;
}

