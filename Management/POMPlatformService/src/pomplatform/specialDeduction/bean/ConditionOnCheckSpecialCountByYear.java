package pomplatform.specialDeduction.bean;

import delicacy.common.GenericCondition;
import java.util.Map;

import java.util.Set;

import java.util.HashSet;

public class ConditionOnCheckSpecialCountByYear extends GenericCondition{

	public ConditionOnCheckSpecialCountByYear(){
		setParameterCount(3);
	}

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId( java.lang.Integer value ) {
		this.__employee_id = value;
	}

	public java.lang.String getYear() {
		return this.__year;
	}

	public void setYear( java.lang.String value ) {
		this.__year = value;
	}

	public java.lang.Integer getSpecialDeductionTypeId() {
		return this.__special_deduction_type_id;
	}

	public void setSpecialDeductionTypeId( java.lang.Integer value ) {
		this.__special_deduction_type_id = value;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toJSONString());
		if(getEmployeeId() != null) sb.append(__wrapNumber(1, "employeeId", getEmployeeId()));
		if(getYear() != null) sb.append(__wrapString(1, "year", getYear()));
		if(getSpecialDeductionTypeId() != null) sb.append(__wrapNumber(1, "specialDeductionTypeId", getSpecialDeductionTypeId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		super.setDataFromMap(values);
		Object val;
		if((val = values.get("employeeId")) != null) setEmployeeId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getString(val));
		if((val = values.get("specialDeductionTypeId")) != null) setSpecialDeductionTypeId(__getInt(val)); 
	}

	@Override
	public Set<String> getNotNullNames(){
		Set<String> res = new HashSet<>();
		if(getEmployeeId() != null) res.add("employeeId");
		if(getYear() != null) res.add("year");
		if(getSpecialDeductionTypeId() != null) res.add("specialDeductionTypeId");
		return res;
	}

	private java.lang.Integer __employee_id = null;
	private java.lang.String __year = null;
	private java.lang.Integer __special_deduction_type_id = null;
}

