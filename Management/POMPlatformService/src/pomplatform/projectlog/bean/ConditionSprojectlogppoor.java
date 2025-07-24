package pomplatform.projectlog.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSprojectlogppoor extends GenericCondition{

	public ConditionSprojectlogppoor(){
		setParameterCount(7);
	}

	public java.lang.Integer getProjectLogId() {
		return this.__project_log_id;
	}

	public void setProjectLogId( java.lang.Integer value ) {
		this.__project_log_id = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Integer getOperateId() {
		return this.__operate_id;
	}

	public void setOperateId( java.lang.Integer value ) {
		this.__operate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getManagerId() {
		return this.__manager_id;
	}

	public void setManagerId( java.lang.Integer value ) {
		this.__manager_id = value;
	}

	public java.lang.Integer getDesignPhase() {
		return this.__design_phase;
	}

	public void setDesignPhase( java.lang.Integer value ) {
		this.__design_phase = value;
	}

	public java.lang.Integer getLogType() {
		return this.__log_type;
	}

	public void setLogType( java.lang.Integer value ) {
		this.__log_type = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getProjectLogId() != null) sb.append(__wrapNumber(1, "projectLogId", getProjectLogId()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getOperateId() != null) sb.append(__wrapNumber(1, "operateId", getOperateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getManagerId() != null) sb.append(__wrapNumber(1, "managerId", getManagerId()));
		if(getDesignPhase() != null) sb.append(__wrapNumber(1, "designPhase", getDesignPhase()));
		if(getLogType() != null) sb.append(__wrapNumber(1, "logType", getLogType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("projectLogId")) != null) setProjectLogId(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("operateId")) != null) setOperateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("managerId")) != null) setManagerId(__getInt(val)); 
		if((val = values.get("designPhase")) != null) setDesignPhase(__getInt(val)); 
		if((val = values.get("logType")) != null) setLogType(__getInt(val)); 
	}

	private java.lang.Integer __project_log_id = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Integer __operate_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __manager_id = null;
	private java.lang.Integer __design_phase = null;
	private java.lang.Integer __log_type = null;
}

