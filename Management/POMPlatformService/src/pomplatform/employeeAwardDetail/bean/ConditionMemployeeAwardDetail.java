package pomplatform.employeeAwardDetail.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMemployeeAwardDetail extends GenericCondition{

	public ConditionMemployeeAwardDetail(){
		setParameterCount(6);
	}

	public java.lang.Integer getYears() {
		return this.__years;
	}

	public void setYears( java.lang.Integer value ) {
		this.__years = value;
	}

	public java.lang.Integer getMonths() {
		return this.__months;
	}

	public void setMonths( java.lang.Integer value ) {
		this.__months = value;
	}

	public java.lang.Integer getProjectId() {
		return this.__project_id;
	}

	public void setProjectId( java.lang.Integer value ) {
		this.__project_id = value;
	}

	public java.lang.Short getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Short value ) {
		this.__employee_id = value;
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

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getYears() != null) sb.append(__wrapNumber(1, "years", getYears()));
		if(getMonths() != null) sb.append(__wrapNumber(1, "months", getMonths()));
		if(getProjectId() != null) sb.append(__wrapNumber(1, "projectId", getProjectId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("years")) != null) setYears(__getInt(val)); 
		if((val = values.get("months")) != null) setMonths(__getInt(val)); 
		if((val = values.get("projectId")) != null) setProjectId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getShort(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
	}

	private java.lang.Integer __years = null;
	private java.lang.Integer __months = null;
	private java.lang.Integer __project_id = null;
	private java.lang.Short __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.String __employee_name = null;
}

