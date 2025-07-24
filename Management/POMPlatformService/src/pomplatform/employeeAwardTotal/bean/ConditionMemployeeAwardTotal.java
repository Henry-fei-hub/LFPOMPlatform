package pomplatform.employeeAwardTotal.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMemployeeAwardTotal extends GenericCondition{

	public ConditionMemployeeAwardTotal(){
		setParameterCount(6);
	}

	public java.util.Date getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( java.util.Date value ) {
		this.__start_month = value;
	}

	public java.util.Date getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.util.Date value ) {
		this.__end_month = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getStartMonth() != null) sb.append(__wrapDate(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapDate(1, "endMonth", getEndMonth()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("startMonth")) != null) setStartMonth(__getDate(val)); 
		if((val = values.get("endMonth")) != null) setEndMonth(__getDate(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	private java.util.Date __start_month = null;
	private java.util.Date __end_month = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.String __employee_name = null;
}

