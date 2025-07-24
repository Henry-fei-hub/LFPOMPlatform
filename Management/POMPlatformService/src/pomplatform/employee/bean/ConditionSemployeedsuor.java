package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSemployeedsuor extends GenericCondition{

	public ConditionSemployeedsuor(){
		setParameterCount(6);
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Boolean getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Boolean value ) {
		this.__status = value;
	}

	public java.lang.Boolean getUsableStatus() {
		return this.__usable_status;
	}

	public void setUsableStatus( java.lang.Boolean value ) {
		this.__usable_status = value;
	}

	public java.lang.Boolean getIsDepartment() {
		return this.__is_department;
	}

	public void setIsDepartment( java.lang.Boolean value ) {
		this.__is_department = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapBoolean(1, "status", getStatus()));
		if(getUsableStatus() != null) sb.append(__wrapBoolean(1, "usableStatus", getUsableStatus()));
		if(getIsDepartment() != null) sb.append(__wrapBoolean(1, "isDepartment", getIsDepartment()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getBoolean(val));
		if((val = values.get("usableStatus")) != null) setUsableStatus(__getBoolean(val));
		if((val = values.get("isDepartment")) != null) setIsDepartment(__getBoolean(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
	}

	private java.lang.Integer __department_id = null;
	private java.lang.Boolean __status = null;
	private java.lang.Boolean __usable_status = null;
	private java.lang.Boolean __is_department = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __employee_no = null;
}

