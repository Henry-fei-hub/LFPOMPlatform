package pomplatform.salaryemployeeevaluationrmmor.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionSsalaryemployeeevaluationrmmor extends GenericCondition{

	public ConditionSsalaryemployeeevaluationrmmor(){
		setParameterCount(11);
	}

	public java.lang.String getRemark() {
		return this.__remark == null ? null : (this.__remark.indexOf("%") >= 0 ? this.__remark : "%"+this.__remark+"%");
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getMinOperateTime() {
		return this.__min_operate_time;
	}

	public void setMinOperateTime( java.util.Date value ) {
		this.__min_operate_time = value;
	}

	public java.util.Date getMaxOperateTime() {
		return this.__max_operate_time;
	}

	public void setMaxOperateTime( java.util.Date value ) {
		this.__max_operate_time = value;
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

	public java.lang.Integer getSalaryEmployeeEvaluationId() {
		return this.__salary_employee_evaluation_id;
	}

	public void setSalaryEmployeeEvaluationId( java.lang.Integer value ) {
		this.__salary_employee_evaluation_id = value;
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
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

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getRemark() != null) sb.append(__wrapString(1, "remark", getRemark()));
		if(getMinOperateTime() != null) sb.append(__wrapDate(1, "minOperateTime", getMinOperateTime()));
		if(getMaxOperateTime() != null) sb.append(__wrapDate(1, "maxOperateTime", getMaxOperateTime()));
		if(getMinHappenDate() != null) sb.append(__wrapDate(1, "minHappenDate", getMinHappenDate()));
		if(getMaxHappenDate() != null) sb.append(__wrapDate(1, "maxHappenDate", getMaxHappenDate()));
		if(getSalaryEmployeeEvaluationId() != null) sb.append(__wrapNumber(1, "salaryEmployeeEvaluationId", getSalaryEmployeeEvaluationId()));
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapNumber(1, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(1, "month", getMonth()));
		if(getGrade() != null) sb.append(__wrapString(1, "grade", getGrade()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(1, "operateEmployeeId", getOperateEmployeeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("minOperateTime")) != null) setMinOperateTime(__getDate(val)); 
		if((val = values.get("maxOperateTime")) != null) setMaxOperateTime(__getDate(val)); 
		if((val = values.get("minHappenDate")) != null) setMinHappenDate(__getDate(val)); 
		if((val = values.get("maxHappenDate")) != null) setMaxHappenDate(__getDate(val)); 
		if((val = values.get("salaryEmployeeEvaluationId")) != null) setSalaryEmployeeEvaluationId(__getInt(val)); 
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
	}

	private java.lang.String __remark = null;
	private java.util.Date __min_operate_time = null;
	private java.util.Date __max_operate_time = null;
	private java.util.Date __min_happen_date = null;
	private java.util.Date __max_happen_date = null;
	private java.lang.Integer __salary_employee_evaluation_id = null;
	private java.lang.Integer __employee_id = null;
	private java.lang.Integer __year = null;
	private java.lang.Integer __month = null;
	private java.lang.String __grade = null;
	private java.lang.Integer __operate_employee_id = null;
}

