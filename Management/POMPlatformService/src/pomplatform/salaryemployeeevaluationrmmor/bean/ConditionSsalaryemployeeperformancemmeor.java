package pomplatform.salaryemployeeevaluationrmmor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSsalaryemployeeperformancemmeor extends GenericCondition{

	public ConditionSsalaryemployeeperformancemmeor(){
		setParameterCount(17);
	}

	public java.util.Date getMinHappenDate() {
		return this.__min_happen_date;
	}

	public void setMinHappenDate( java.util.Date value ) {
		this.__min_happen_date = value;
	}

	public java.util.Date getMaxHappenDate() {
		return this.__max_happen_date;
	}

	public void setMaxHappenDate( java.util.Date value ) {
		this.__max_happen_date = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no == null ? null : (this.__employee_no.indexOf("%") >= 0 ? this.__employee_no : "%"+this.__employee_no+"%");
	}

	public void setEmployeeNo( java.lang.String value ) {
		this.__employee_no = value;
	}

	public java.lang.Integer getSalaryEmployeePerformanceId() {
		return this.__salary_employee_performance_id;
	}

	public void setSalaryEmployeePerformanceId( java.lang.Integer value ) {
		this.__salary_employee_performance_id = value;
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

	public java.lang.Integer getCompanyId() {
		return this.__company_id;
	}

	public void setCompanyId( java.lang.Integer value ) {
		this.__company_id = value;
	}

	public java.lang.Integer getStatus() {
		return this.__status;
	}

	public void setStatus( java.lang.Integer value ) {
		this.__status = value;
	}

	public java.math.BigDecimal getShouldDays() {
		return this.__should_days;
	}

	public void setShouldDays( java.math.BigDecimal value ) {
		this.__should_days = value;
	}

	public java.math.BigDecimal getFactDays() {
		return this.__fact_days;
	}

	public void setFactDays( java.math.BigDecimal value ) {
		this.__fact_days = value;
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

	public java.lang.String getGrade() {
		return this.__grade;
	}

	public void setGrade( java.lang.String value ) {
		this.__grade = value;
	}

	public java.math.BigDecimal getProportion() {
		return this.__proportion;
	}

	public void setProportion( java.math.BigDecimal value ) {
		this.__proportion = value;
	}

	public java.math.BigDecimal getWorkingCoefficient() {
		return this.__working_coefficient;
	}

	public void setWorkingCoefficient( java.math.BigDecimal value ) {
		this.__working_coefficient = value;
	}

	public java.math.BigDecimal getActualPerformancePay() {
		return this.__actual_performance_pay;
	}

	public void setActualPerformancePay( java.math.BigDecimal value ) {
		this.__actual_performance_pay = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getMaxHappenDate() != null) sb.append(__wrapDate(1, "maxHappenDate", getMaxHappenDate()));
		if(getEmployeeNo() != null) sb.append(__wrapString(1, "employeeNo", getEmployeeNo()));
		if(getSalaryEmployeePerformanceId() != null) sb.append(__wrapNumber(1, "salaryEmployeePerformanceId", getSalaryEmployeePerformanceId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(1, "departmentId", getDepartmentId()));
		if(getCompanyId() != null) sb.append(__wrapNumber(1, "companyId", getCompanyId()));
		if(getStatus() != null) sb.append(__wrapNumber(1, "status", getStatus()));
		if(getShouldDays() != null) sb.append(__wrapNumber(1, "shouldDays", getShouldDays()));
		if(getFactDays() != null) sb.append(__wrapNumber(1, "factDays", getFactDays()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getGrade() != null) sb.append(__wrapString(1, "grade", getGrade()));
		if(getProportion() != null) sb.append(__wrapNumber(1, "proportion", getProportion()));
		if(getWorkingCoefficient() != null) sb.append(__wrapNumber(1, "workingCoefficient", getWorkingCoefficient()));
		if(getActualPerformancePay() != null) sb.append(__wrapNumber(1, "actualPerformancePay", getActualPerformancePay()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("maxHappenDate")) != null) setMaxHappenDate(__getDate(val)); 
		if((val = values.get("employeeNo")) != null) setEmployeeNo(__getString(val));
		if((val = values.get("salaryEmployeePerformanceId")) != null) setSalaryEmployeePerformanceId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("companyId")) != null) setCompanyId(__getInt(val)); 
		if((val = values.get("status")) != null) setStatus(__getInt(val)); 
		if((val = values.get("shouldDays")) != null) setShouldDays(__getDecimal(val));  
		if((val = values.get("factDays")) != null) setFactDays(__getDecimal(val));  
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("proportion")) != null) setProportion(__getDecimal(val));  
		if((val = values.get("workingCoefficient")) != null) setWorkingCoefficient(__getDecimal(val));  
		if((val = values.get("actualPerformancePay")) != null) setActualPerformancePay(__getDecimal(val));  
	}

	private java.util.Date __min_happen_date = null;
	private java.util.Date __max_happen_date = null;
	private java.lang.String __employee_no = null;
	private java.lang.Integer __salary_employee_performance_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __plate_id = null;
	private java.lang.Integer __department_id = null;
	private java.lang.Integer __company_id = null;
	private java.lang.Integer __status = null;
	private java.math.BigDecimal __should_days = null;
	private java.math.BigDecimal __fact_days = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.String __grade = null;
	private java.math.BigDecimal __proportion = null;
	private java.math.BigDecimal __working_coefficient = null;
	private java.math.BigDecimal __actual_performance_pay = null;
}

