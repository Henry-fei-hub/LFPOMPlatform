package pomplatform.cwd.softoperate.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMsoftwareoperationlogeoseedor extends GenericCondition{

	public ConditionMsoftwareoperationlogeoseedor(){
		setParameterCount(5);
	}

	public java.lang.Integer getOperationType() {
		return this.__operation_type;
	}

	public void setOperationType( java.lang.Integer value ) {
		this.__operation_type = value;
	}

	public java.lang.Integer getSoftwareType() {
		return this.__software_type;
	}

	public void setSoftwareType( java.lang.Integer value ) {
		this.__software_type = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
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
		if(getOperationType() != null) sb.append(__wrapNumber(1, "operationType", getOperationType()));
		if(getSoftwareType() != null) sb.append(__wrapNumber(1, "softwareType", getSoftwareType()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("operationType")) != null) setOperationType(__getInt(val)); 
		if((val = values.get("softwareType")) != null) setSoftwareType(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __operation_type = null;
	private java.lang.Integer __software_type = null;
	private java.lang.String __employee_no = null;
	private java.lang.String __employee_name = null;
	private java.lang.Integer __department_id = null;
}

