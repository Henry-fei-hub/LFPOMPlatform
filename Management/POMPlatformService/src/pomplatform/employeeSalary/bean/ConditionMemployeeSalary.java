package pomplatform.employeeSalary.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMemployeeSalary extends GenericCondition{

	public ConditionMemployeeSalary(){
		setParameterCount(7);
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.Integer getYears() {
		return this.__years;
	}

	public void setYears( java.lang.Integer value ) {
		this.__years = value;
	}

	public java.lang.Integer getStartMonth() {
		return this.__start_month;
	}

	public void setStartMonth( java.lang.Integer value ) {
		this.__start_month = value;
	}

	public java.lang.Integer getEndMonth() {
		return this.__end_month;
	}

	public void setEndMonth( java.lang.Integer value ) {
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getYears() != null) sb.append(__wrapNumber(1, "years", getYears()));
		if(getStartMonth() != null) sb.append(__wrapNumber(1, "startMonth", getStartMonth()));
		if(getEndMonth() != null) sb.append(__wrapNumber(1, "endMonth", getEndMonth()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("years")) != null) setYears(__getInt(val));
		if((val = values.get("startMonth")) != null) setStartMonth(__getInt(val));
		if((val = values.get("endMonth")) != null) setEndMonth(__getInt(val));
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
	}

	private java.lang.String __employee_name = null;
	private java.lang.Integer __years = null;
	private java.lang.Integer __start_month = null;
	private java.lang.Integer __end_month = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __department_id = null;
}

