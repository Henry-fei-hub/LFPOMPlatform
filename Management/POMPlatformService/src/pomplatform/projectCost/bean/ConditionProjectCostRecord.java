package pomplatform.projectCost.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionProjectCostRecord extends GenericCondition{

	public ConditionProjectCostRecord(){
		setParameterCount(7);
	}

	public java.lang.Integer getDesignTeam() {
		return this.__design_team;
	}

	public void setDesignTeam( java.lang.Integer value ) {
		this.__design_team = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code == null ? null : (this.__project_code.indexOf("%") >= 0 ? this.__project_code : "%"+this.__project_code+"%");
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
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
		if(getDesignTeam() != null) sb.append(__wrapNumber(1, "designTeam", getDesignTeam()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("designTeam")) != null) setDesignTeam(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getDesignTeam() != null) res.add("designTeam");
		if(getProjectCode() != null) res.add("projectCode");
		if(getProjectName() != null) res.add("projectName");
		if(getStartDate() != null) res.add("startDate");
		if(getEndDate() != null) res.add("endDate");
		if(getEmployeeId() != null) res.add("employeeId");
		if(getDepartmentId() != null) res.add("departmentId");
		return res;
	}

	private java.lang.Integer __design_team = null;
	private java.lang.String __project_code = null;
	private java.lang.String __project_name = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __department_id = null;
}

