package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionPreProjectMyRecords extends GenericCondition{

	public ConditionPreProjectMyRecords(){
		setParameterCount(8);
	}

	public java.lang.Integer getApplyEmployeeId() {
		return this.__apply_employee_id;
	}

	public void setApplyEmployeeId( java.lang.Integer value ) {
		this.__apply_employee_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.String getProjectStatus() {
		return this.__project_status;
	}

	public void setProjectStatus( java.lang.String value ) {
		this.__project_status = value;
	}

	public java.lang.Integer getProjectBaseOn() {
		return this.__project_base_on;
	}

	public void setProjectBaseOn( java.lang.Integer value ) {
		this.__project_base_on = value;
	}

	public java.lang.String getRelevantEmployees() {
		return this.__relevant_employees == null ? null : (this.__relevant_employees.indexOf("%") >= 0 ? this.__relevant_employees : "%"+this.__relevant_employees+"%");
	}

	public void setRelevantEmployees( java.lang.String value ) {
		this.__relevant_employees = value;
	}
	
	public java.util.Date getStartDate() {
		return this.__start_date;
	}

	public void setStartDate( java.util.Date value ) {
		this.__start_date = value;
	}
	public java.util.Date getEndDate() {
		return this.__end_date;
	}

	public void setEndDate( java.util.Date value ) {
		this.__end_date = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getApplyEmployeeId() != null) sb.append(__wrapNumber(1, "applyEmployeeId", getApplyEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProjectStatus() != null) sb.append(__wrapString(1, "projectStatus", getProjectStatus()));
		if(getProjectBaseOn() != null) sb.append(__wrapNumber(1, "projectBaseOn", getProjectBaseOn()));
		if(getRelevantEmployees() != null) sb.append(__wrapString(1, "relevantEmployees", getRelevantEmployees()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("applyEmployeeId")) != null) setApplyEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectStatus")) != null) setProjectStatus(__getString(val));
		if((val = values.get("projectBaseOn")) != null) setProjectBaseOn(__getInt(val)); 
		if((val = values.get("relevantEmployees")) != null) setRelevantEmployees(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val));
	}

	private java.lang.Integer __apply_employee_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __status = null;
	private java.lang.String __project_status = null;
	private java.lang.Integer __project_base_on = null;
	private java.lang.String __relevant_employees = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
}

