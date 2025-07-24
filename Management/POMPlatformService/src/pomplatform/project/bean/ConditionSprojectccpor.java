package pomplatform.project.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectccpor extends GenericCondition{

	public ConditionSprojectccpor(){
		setParameterCount(14);
	}

	public java.util.Date getTheStartDate() {
		return this.__the_start_date;
	}

	public void setTheStartDate( java.util.Date value ) {
		this.__the_start_date = value;
	}

	public java.util.Date getTheEndDate() {
		return this.__the_end_date;
	}

	public void setTheEndDate( java.util.Date value ) {
		this.__the_end_date = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.String getProjectName() {
		return this.__project_name == null ? null : (this.__project_name.indexOf("%") >= 0 ? this.__project_name : "%"+this.__project_name+"%");
	}

	public void setProjectName( java.lang.String value ) {
		this.__project_name = value;
	}

	public java.lang.String getContractCode() {
		return this.__contract_code;
	}

	public void setContractCode( java.lang.String value ) {
		this.__contract_code = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getProjectType() {
		return this.__project_type;
	}

	public void setProjectType( java.lang.Integer value ) {
		this.__project_type = value;
	}

	public java.lang.String getProjectCode() {
		return this.__project_code;
	}

	public void setProjectCode( java.lang.String value ) {
		this.__project_code = value;
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

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.lang.Integer getProjectLevel() {
		return this.__project_level;
	}

	public void setProjectLevel( java.lang.Integer value ) {
		this.__project_level = value;
	}

	public java.lang.Integer getProjectManageId() {
		return this.__project_manage_id;
	}

	public void setProjectManageId( java.lang.Integer value ) {
		this.__project_manage_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getTheStartDate() != null) sb.append(__wrapDate(1, "theStartDate", getTheStartDate()));
		if(getTheEndDate() != null) sb.append(__wrapDate(1, "theEndDate", getTheEndDate()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(1, "designPhase", getDesignPhase()));
		if(getProjectName() != null) sb.append(__wrapString(1, "projectName", getProjectName()));
		if(getContractCode() != null) sb.append(__wrapString(1, "contractCode", getContractCode()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getProjectType() != null) sb.append(__wrapNumber(1, "projectType", getProjectType()));
		if(getProjectCode() != null) sb.append(__wrapString(1, "projectCode", getProjectCode()));
		if(getStartDate() != null) sb.append(__wrapDate(1, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(1, "endDate", getEndDate()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getProjectLevel() != null) sb.append(__wrapNumber(1, "projectLevel", getProjectLevel()));
		if(getProjectManageId() != null) sb.append(__wrapNumber(1, "projectManageId", getProjectManageId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("theStartDate")) != null) setTheStartDate(__getDate(val)); 
		if((val = values.get("theEndDate")) != null) setTheEndDate(__getDate(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("projectName")) != null) setProjectName(__getString(val));
		if((val = values.get("contractCode")) != null) setContractCode(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("projectType")) != null) setProjectType(__getInt(val)); 
		if((val = values.get("projectCode")) != null) setProjectCode(__getString(val));
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("projectLevel")) != null) setProjectLevel(__getInt(val)); 
		if((val = values.get("projectManageId")) != null) setProjectManageId(__getInt(val)); 
	}

	private java.util.Date __the_start_date = null;
	private java.util.Date __the_end_date = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __design_phase = null;
	private java.lang.String __project_name = null;
	private java.lang.String __contract_code = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __project_type = null;
	private java.lang.String __project_code = null;
	private java.util.Date __start_date = null;
	private java.util.Date __end_date = null;
	private java.lang.Integer __status = null;
	private java.lang.Integer __project_level = null;
	private java.lang.Integer __project_manage_id = null;
}

