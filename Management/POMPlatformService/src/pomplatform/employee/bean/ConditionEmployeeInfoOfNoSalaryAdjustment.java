package pomplatform.employee.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeeInfoOfNoSalaryAdjustment extends GenericCondition{

	public ConditionEmployeeInfoOfNoSalaryAdjustment(){
		setParameterCount(7);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.util.Date getStartTime() {
		return this.__start_time;
	}

	public void setStartTime( java.util.Date value ) {
		this.__start_time = value;
	}

	public java.util.Date getEndTime() {
		return this.__end_time;
	}

	public void setEndTime( java.util.Date value ) {
		this.__end_time = value;
	}

	public java.lang.Integer getDrafter() {
		return __drafter;
	}

	public void setDrafter(java.lang.Integer __drafter) {
		this.__drafter = __drafter;
	}

	public java.lang.String getFunctionCode() {
		return __function_code;
	}

	public void setFunctionCode(java.lang.String __function_code) {
		this.__function_code = __function_code;
	}

	public java.lang.Integer getDepartmentId() {
		return __department_id;
	}

	public void setDepartmentId(java.lang.Integer __department_id) {
		this.__department_id = __department_id;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getStartTime() != null) sb.append(__wrapDate(1, "startTime", getStartTime()));
		if(getEndTime() != null) sb.append(__wrapDate(1, "endTime", getEndTime()));
		if(getDrafter() != null) sb.append(__wrapNumber(1, "drafter", getDrafter()));
		if(getFunctionCode() != null) sb.append(__wrapString(1, "functionCode", getFunctionCode()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("startTime")) != null) setStartTime(__getDate(val)); 
		if((val = values.get("endTime")) != null) setEndTime(__getDate(val)); 
		if((val = values.get("drafter")) != null) setDrafter(__getInt(val)); 
		if((val = values.get("functionCode")) != null) setFunctionCode(__getString(val));
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.String __employee_name = null;
	private java.util.Date __start_time = null;
	private java.util.Date __end_time = null;
	private java.lang.Integer __drafter = null;
	private java.lang.String __function_code = null;
	private java.lang.Integer __department_id = null;
}

