package pomplatform.addProjectEmpSalary.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

public class ConditionMaddProjectEmpSalary extends GenericCondition{

	public ConditionMaddProjectEmpSalary(){
		setParameterCount(3);
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getSalaryYear() {
		return this.__salary_year;
	}

	public void setSalaryYear( java.lang.String value ) {
		this.__salary_year = value;
	}

	public java.lang.String getSalaryMonth() {
		return this.__salary_month;
	}

	public void setSalaryMonth( java.lang.String value ) {
		this.__salary_month = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getPlateId() != null) sb.append(__wrapNumber(1, "plateId", getPlateId()));
		if(getSalaryYear() != null) sb.append(__wrapString(1, "salaryYear", getSalaryYear()));
		if(getSalaryMonth() != null) sb.append(__wrapString(1, "salaryMonth", getSalaryMonth()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("salaryYear")) != null) setSalaryYear(__getString(val));
		if((val = values.get("salaryMonth")) != null) setSalaryMonth(__getString(val));
	}

	private java.lang.Integer __plate_id = null;
	private java.lang.String __salary_year = null;
	private java.lang.String __salary_month = null;
}

