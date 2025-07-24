package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryEmployeeEvaluationGrade extends GenericBase implements BaseFactory<BaseSalaryEmployeeEvaluationGrade>, Comparable<BaseSalaryEmployeeEvaluationGrade> 
{


	public static BaseSalaryEmployeeEvaluationGrade newInstance(){
		return new BaseSalaryEmployeeEvaluationGrade();
	}

	@Override
	public BaseSalaryEmployeeEvaluationGrade make(){
		BaseSalaryEmployeeEvaluationGrade b = new BaseSalaryEmployeeEvaluationGrade();
		return b;
	}

	public final static java.lang.String CS_SALARY_EMPLOYEE_EVALUATION_GRADE_ID = "salary_employee_evaluation_grade_id" ;
	public final static java.lang.String CS_GRADE = "grade" ;
	public final static java.lang.String CS_PROPORTION = "proportion" ;
	public final static java.lang.String CS_START_DATE = "start_date" ;
	public final static java.lang.String CS_END_DATE = "end_date" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_OPERATOR = "operator" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_FLAG = "flag" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,等级,比例,有效开始日期,有效结束日期,创建时间,操作人,有效年份  用于年度绩效,1  月绩效 2 年绩效";

	public java.lang.Integer getSalaryEmployeeEvaluationGradeId() {
		return this.__salary_employee_evaluation_grade_id;
	}

	public void setSalaryEmployeeEvaluationGradeId( java.lang.Integer value ) {
		this.__salary_employee_evaluation_grade_id = value;
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

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOperator() {
		return this.__operator;
	}

	public void setOperator( java.lang.Integer value ) {
		this.__operator = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public void cloneCopy(BaseSalaryEmployeeEvaluationGrade __bean){
		__bean.setSalaryEmployeeEvaluationGradeId(getSalaryEmployeeEvaluationGradeId());
		__bean.setGrade(getGrade());
		__bean.setProportion(getProportion());
		__bean.setStartDate(getStartDate());
		__bean.setEndDate(getEndDate());
		__bean.setCreateTime(getCreateTime());
		__bean.setOperator(getOperator());
		__bean.setYear(getYear());
		__bean.setFlag(getFlag());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSalaryEmployeeEvaluationGradeId() == null ? "" : getSalaryEmployeeEvaluationGradeId());
		sb.append(",");
		sb.append(getGrade() == null ? "" : getGrade());
		sb.append(",");
		sb.append(getProportion() == null ? "" : getProportion());
		sb.append(",");
		sb.append(getStartDate() == null ? "" : sdf.format(getStartDate()));
		sb.append(",");
		sb.append(getEndDate() == null ? "" : sdf.format(getEndDate()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOperator() == null ? "" : getOperator());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getFlag() == null ? "" : getFlag());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryEmployeeEvaluationGrade o) {
		return __salary_employee_evaluation_grade_id == null ? -1 : __salary_employee_evaluation_grade_id.compareTo(o.getSalaryEmployeeEvaluationGradeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__salary_employee_evaluation_grade_id);
		hash = 97 * hash + Objects.hashCode(this.__grade);
		hash = 97 * hash + Objects.hashCode(this.__proportion);
		hash = 97 * hash + Objects.hashCode(this.__start_date);
		hash = 97 * hash + Objects.hashCode(this.__end_date);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__operator);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSalaryEmployeeEvaluationGrade o = (BaseSalaryEmployeeEvaluationGrade)obj;
		if(!Objects.equals(this.__salary_employee_evaluation_grade_id, o.getSalaryEmployeeEvaluationGradeId())) return false;
		if(!Objects.equals(this.__grade, o.getGrade())) return false;
		if(!Objects.equals(this.__proportion, o.getProportion())) return false;
		if(!Objects.equals(this.__start_date, o.getStartDate())) return false;
		if(!Objects.equals(this.__end_date, o.getEndDate())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__operator, o.getOperator())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSalaryEmployeeEvaluationGradeId() != null) sb.append(__wrapNumber(count++, "salaryEmployeeEvaluationGradeId", getSalaryEmployeeEvaluationGradeId()));
		if(getGrade() != null) sb.append(__wrapString(count++, "grade", getGrade()));
		if(getProportion() != null) sb.append(__wrapDecimal(count++, "proportion", getProportion()));
		if(getStartDate() != null) sb.append(__wrapDate(count++, "startDate", getStartDate()));
		if(getEndDate() != null) sb.append(__wrapDate(count++, "endDate", getEndDate()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOperator() != null) sb.append(__wrapNumber(count++, "operator", getOperator()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("salaryEmployeeEvaluationGradeId")) != null) setSalaryEmployeeEvaluationGradeId(__getInt(val)); 
		if((val = values.get("grade")) != null) setGrade(__getString(val));
		if((val = values.get("proportion")) != null) setProportion(__getDecimal(val));  
		if((val = values.get("startDate")) != null) setStartDate(__getDate(val)); 
		if((val = values.get("endDate")) != null) setEndDate(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("operator")) != null) setOperator(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
	}

	protected java.lang.Integer  __salary_employee_evaluation_grade_id ;
	protected java.lang.String  __grade ;
	protected java.math.BigDecimal  __proportion ;
	protected java.util.Date  __start_date ;
	protected java.util.Date  __end_date ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __operator ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __flag ;
}
