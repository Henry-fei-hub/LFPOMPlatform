package pomplatform.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionEmployeeSalaryType extends GenericCondition{

	public ConditionEmployeeSalaryType(){
		setParameterCount(10);
	}

	public java.lang.Integer getEmployeeSalaryTypeId() {
		return this.__employee_salary_type_id;
	}

	public void setEmployeeSalaryTypeId( java.lang.Integer value ) {
		this.__employee_salary_type_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeName() {
		return this.__employee_name == null ? null : (this.__employee_name.indexOf("%") >= 0 ? this.__employee_name : "%"+this.__employee_name+"%");
	}

	public void setEmployeeName( java.lang.String value ) {
		this.__employee_name = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.lang.Integer getSalaryType() {
		return this.__salary_type;
	}

	public void setSalaryType( java.lang.Integer value ) {
		this.__salary_type = value;
	}

	public java.lang.Integer getFundraisingProjectType() {
		return this.__fundraising_project_type;
	}

	public void setFundraisingProjectType( java.lang.Integer value ) {
		this.__fundraising_project_type = value;
	}

	public java.math.BigDecimal getFundraisingProjectRate() {
		return this.__fundraising_project_rate;
	}

	public void setFundraisingProjectRate( java.math.BigDecimal value ) {
		this.__fundraising_project_rate = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeSalaryTypeId() != null) sb.append(__wrapNumber(1, "employeeSalaryTypeId", getEmployeeSalaryTypeId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getEmployeeName() != null) sb.append(__wrapString(1, "employeeName", getEmployeeName()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getSalaryType() != null) sb.append(__wrapNumber(1, "salaryType", getSalaryType()));
		if(getFundraisingProjectType() != null) sb.append(__wrapNumber(1, "fundraisingProjectType", getFundraisingProjectType()));
		if(getFundraisingProjectRate() != null) sb.append(__wrapNumber(1, "fundraisingProjectRate", getFundraisingProjectRate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeSalaryTypeId")) != null) setEmployeeSalaryTypeId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("employeeName")) != null) setEmployeeName(__getString(val));
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("salaryType")) != null) setSalaryType(__getInt(val)); 
		if((val = values.get("fundraisingProjectType")) != null) setFundraisingProjectType(__getInt(val)); 
		if((val = values.get("fundraisingProjectRate")) != null) setFundraisingProjectRate(__getDecimal(val));  
	}

	private java.lang.Integer __employee_salary_type_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.String __employee_name = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.Integer __salary_type = null;
	private java.lang.Integer __fundraising_project_type = null;
	private java.math.BigDecimal __fundraising_project_rate = null;
}

