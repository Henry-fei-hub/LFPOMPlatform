package pomplatform.workflow.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionOnLoadPersonnelFlowDetail extends GenericCondition{

	public ConditionOnLoadPersonnelFlowDetail(){
		setParameterCount(7);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getParentProcessTypeId() {
		return this.__parent_process_type_id;
	}

	public void setParentProcessTypeId( java.lang.Integer value ) {
		this.__parent_process_type_id = value;
	}

	public java.lang.Integer getActivityType() {
		return this.__activity_type;
	}

	public void setActivityType( java.lang.Integer value ) {
		this.__activity_type = value;
	}

	public java.lang.Integer getProcessType() {
		return this.__process_type;
	}

	public void setProcessType( java.lang.Integer value ) {
		this.__process_type = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
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
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getParentProcessTypeId() != null) sb.append(__wrapNumber(1, "parentProcessTypeId", getParentProcessTypeId()));
		if(getActivityType() != null) sb.append(__wrapNumber(1, "activityType", getActivityType()));
		if(getProcessType() != null) sb.append(__wrapNumber(1, "processType", getProcessType()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("parentProcessTypeId")) != null) setParentProcessTypeId(__getInt(val)); 
		if((val = values.get("activityType")) != null) setActivityType(__getInt(val)); 
		if((val = values.get("processType")) != null) setProcessType(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __parent_process_type_id = null;
	private java.lang.Integer __activity_type = null;
	private java.lang.Integer __process_type = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __department_id = null;
}

