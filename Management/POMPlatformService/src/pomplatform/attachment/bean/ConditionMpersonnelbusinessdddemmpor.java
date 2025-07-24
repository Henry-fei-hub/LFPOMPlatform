package pomplatform.attachment.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMpersonnelbusinessdddemmpor extends GenericCondition{

	public ConditionMpersonnelbusinessdddemmpor(){
		setParameterCount(7);
	}

	public java.lang.Integer getDeleteFlag() {
		return this.__delete_flag;
	}

	public void setDeleteFlag( java.lang.Integer value ) {
		this.__delete_flag = value;
	}

	public java.lang.Integer getDrafter() {
		return this.__drafter;
	}

	public void setDrafter( java.lang.Integer value ) {
		this.__drafter = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.util.Date getMinCreateTime() {
		return this.__min_create_time;
	}

	public void setMinCreateTime( java.util.Date value ) {
		this.__min_create_time = value;
	}

	public java.util.Date getMaxCreateTime() {
		return this.__max_create_time;
	}

	public void setMaxCreateTime( java.util.Date value ) {
		this.__max_create_time = value;
	}

	public java.lang.Integer getProcessStatus() {
		return this.__process_status;
	}

	public void setProcessStatus( java.lang.Integer value ) {
		this.__process_status = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getDeleteFlag() != null) sb.append(__wrapNumber(1, "deleteFlag", getDeleteFlag()));
		if(getDrafter() != null) sb.append(__wrapNumber(1, "drafter", getDrafter()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getMinCreateTime() != null) sb.append(__wrapDate(1, "minCreateTime", getMinCreateTime()));
		if(getMaxCreateTime() != null) sb.append(__wrapDate(1, "maxCreateTime", getMaxCreateTime()));
		if(getProcessStatus() != null) sb.append(__wrapNumber(1, "processStatus", getProcessStatus()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("deleteFlag")) != null) setDeleteFlag(__getInt(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("minCreateTime")) != null) setMinCreateTime(__getDate(val)); 
		if((val = values.get("maxCreateTime")) != null) setMaxCreateTime(__getDate(val)); 
		if((val = values.get("processStatus")) != null) setProcessStatus(__getInt(val)); 
	}

	private java.lang.Integer __delete_flag = null;
	private java.lang.Integer __drafter = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __employee_no = null;
	private java.util.Date __min_create_time = null;
	private java.util.Date __max_create_time = null;
	private java.lang.Integer __process_status = null;
}

